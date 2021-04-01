package nrx07;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.sql.*;
public class Printing 
{
    static int j,k;
    static String pos=null;
    static String name2=null;
    static int hash;
    static int i;
    public static void printingpage(String name)
    {
        int ctr=1;
        
        JFrame jf1=new JFrame("Print");
    	jf1.setLayout(null);
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension d=t.getScreenSize();
        jf1.setSize(500,500);       
        jf1.setExtendedState(jf1.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        
        BufferedImage img=null;
        try{img = ImageIO.read(new File("C:\\Users\\naman\\Desktop\\NRX07\\Programing\\NetBeans\\NetBeansCode\\NRX07\\src\\nrx07\\first.png"));}
        catch(IOException e){System.out.println(e);}
        Image dimg=img.getScaledInstance(d.width+60,d.height-30, Image.SCALE_SMOOTH);
        JLabel bgl=new JLabel(new ImageIcon(dimg));
        bgl.setBounds(0,0,d.width+60,d.height-30);
        
        Connection con = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","Nrx07CR7.");
            stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from players where name='"+name+"';");
            while(rs.next())
            {
                ctr++;
            }
        }
        catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        
        String[][] data=new String[ctr+1][8];
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","Nrx07CR7.");
            stmt=con.createStatement();
            ResultSet rs2 = stmt.executeQuery("select * from players where name='"+name+"';");
            ctr=1;
            while(rs2.next())
            {
                data[ctr][0]=rs2.getString(1);
                data[ctr][1]=rs2.getString(2);
                data[ctr][2]=rs2.getString(3);
                data[ctr][3]=rs2.getString(4);
                data[ctr][4]=rs2.getString(5);
                data[ctr][5]=rs2.getString(6);
                data[ctr][6]=rs2.getString(7);
                data[ctr][7]=rs2.getString(8);
                ctr++;
            }
        }
        catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        
        String col[]={"hash_","rating","position","name","club","league","country","skillboost"};
        int len=ctr;
        ctr=0;
        data[ctr][0]="HASH";
        data[ctr][1]="RATING";
        data[ctr][2]="POSITION";
        data[ctr][3]="NAME";
        data[ctr][4]="CLUB";
        data[ctr][5]="LEAGUE";
        data[ctr][6]="COUNTRY";
        data[ctr][7]="SKILLBOOST";
        
        Font F1=new Font("Agency FB",Font.BOLD,70);
        
        JLabel la=new JLabel("RESULTS:");
        la.setFont(F1);
        int lax = (d.width/2);
    	la.setBounds(lax-550,80,400,60);
        la.setForeground(Color.white);
    	jf1.add(la);
        
        Font F4=new Font("Agency FB",Font.PLAIN,22);
        JTable jt=new JTable(data,col);
        jt.setBounds(125, 150, 1000 , (len)*24);
        jt.setBackground(Color.darkGray);
        jt.setForeground(Color.white);
        jt.setRowHeight(24);
        jt.getColumnModel().getColumn(0).setPreferredWidth(20);
        jt.getColumnModel().getColumn(1).setPreferredWidth(30);
        jt.getColumnModel().getColumn(2).setPreferredWidth(35);
        jt.getColumnModel().getColumn(3).setPreferredWidth(100);
        jt.getColumnModel().getColumn(4).setPreferredWidth(100);
        jt.getColumnModel().getColumn(5).setPreferredWidth(200);
        jt.getColumnModel().getColumn(6).setPreferredWidth(120);
        jt.getColumnModel().getColumn(7).setPreferredWidth(130);
        jt.setFont(F4);
        jf1.add(jt);
        
        Font F3=new Font("Agency FB",Font.PLAIN,30);
        
        int y=150+24;
                
        JButton[] JB=new JButton[len-1];
        for(i=0;i<len-1;i++)
        {
            JB[i]=new JButton("...");
            JB[i].setForeground(Color.white);
            JB[i].setBackground(Color.darkGray);
            JB[i].setFont(F3);
            JB[i].setBounds(1125,(y+(24*i)),50,24);
            pos=data[i+1][2];
            name2=data[i+1][3];
            hash=Integer.parseInt(data[i+1][0]);
            JB[i].addActionListener(new ActionListener()
            {
                    @Override
        		public void actionPerformed(ActionEvent e)
        		{
                            for(j=0;j<len-1;j++)
                                if(e.getSource()==JB[j])
                                {
                                    k=j;
                                }
                            if(pos.equals("GK"))
                            {
                                PI.kinfo(k,name);
                            }
                            else
                            {
                                PI.pinfo(k,name);
                            }
                            //jf1.setVisible(false);
        		}
            });
            jf1.add(JB[i]);
        }
        
        
        F3=new Font("Agency FB",Font.PLAIN,22);                  
        JButton jb2=new JButton("BACK");
        jb2.setFont(F3);
        jb2.setBounds(0,0,180,50);
        jb2.setForeground(Color.black);
        jb2.setBackground(Color.white);
        jb2.addActionListener(new ActionListener()
    	{
                @Override
    		public void actionPerformed(ActionEvent e)
    		{
                    Search.basic_search();
                    jf1.setVisible(false);
    		}
    	});
        
        jf1.add(jb2);

        JButton jb3=new JButton("LOGOUT");
        jb3.setFont(F3);
        jb3.setBounds(1100,0,180,50);
        jb3.setForeground(Color.black);
        jb3.setBackground(Color.white);
        jb3.addActionListener(new ActionListener()
    	{
                @Override
    		public void actionPerformed(ActionEvent e)
    		{
                    Login.loginpassword();
                    jf1.setVisible(false);
    		}
    	});
        
        jf1.add(jb3);
        
        jf1.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
        jf1.add(bgl);
        jf1.setVisible(true);
    }
}