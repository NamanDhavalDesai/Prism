package nrx07;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.sql.*;
public class Search 
{
    static JFrame jf1;
    static JLabel label;
    
    public static void searchdata(String name)
    {
        Connection con = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","Nrx07CR7.");
            stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from players where name='"+name+"';");
            rs.next();
            if(rs.getString(4).equals(name))
            { 
                Printing.printingpage(name);
                jf1.setVisible(false);
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
            label.setText("PLAYER NOT FOUND");
        }
    }
    
    public static void basic_search()
    {
        jf1=new JFrame("Search");
    	jf1.setLayout(null);
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension d=t.getScreenSize();
        jf1.setSize(500,500);       
        jf1.setExtendedState(jf1.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        
        Font F1=new Font("Agency FB",Font.BOLD,70);
        
        BufferedImage img2=null;
        try{img2 = ImageIO.read(new File("C:\\Users\\naman\\Desktop\\NRX07\\Programing\\NetBeans\\NetBeansCode\\NRX07\\src\\nrx07\\ss_1.png"));}
        catch(IOException e){System.out.println(e);}
        Image dimg2=img2.getScaledInstance(d.width,d.height-100, Image.SCALE_SMOOTH);
        JLabel bg2=new JLabel(new ImageIcon(dimg2));
        bg2.setBounds(0,0,d.width,d.height+0);
        
        BufferedImage img=null;
        try{img = ImageIO.read(new File("C:\\Users\\naman\\Desktop\\NRX07\\Programing\\NetBeans\\NetBeansCode\\NRX07\\src\\nrx07\\black.png"));}
        catch(IOException e){System.out.println(e);}
        Image dimg=img.getScaledInstance(d.width+60,d.height+30, Image.SCALE_SMOOTH);
        JLabel bg1=new JLabel(new ImageIcon(dimg));
        bg1.setBounds(0,0,d.width,d.height);
        
        Font F2=new Font("Agency FB",Font.BOLD,50);
        int lax = (d.width/2);
        
        JLabel lb=new JLabel("PLAYER'S NAME ");
        lb.setFont(F2);
    	lb.setBounds(lax-450,340,500,60);
        lb.setForeground(Color.white);
    	jf1.add(lb);
        
        F2=new Font("Agency FB",Font.BOLD,30);
        
        JTextField tf1=new JTextField("Vidal");
        tf1.setFont(F2);
    	tf1.setBounds(lax-325,415,800,55);
    	jf1.add(tf1);
        
        Font F3=new Font("Agency FB",Font.PLAIN,22);
        
        JButton jb1=new JButton("SEARCH");
        jb1.setFont(F3);
        jb1.setBounds(lax-40,475,180,50);
        jb1.setForeground(Color.black);
        jb1.setBackground(Color.white);
        jb1.addActionListener(new ActionListener()
    	{
                @Override
    		public void actionPerformed(ActionEvent e)
    		{
                    searchdata(tf1.getText());
    		}
    	});
        jf1.add(jb1);
        
        F2=new Font("Agency FB",Font.PLAIN,30);
        JLabel lb4=new JLabel("NOTE - ENTER THE NAME OF THE PLAYER YOU WANT TO  ");
        lb4.setFont(F2);
    	lb4.setBounds(lax+100,105,500,60);
        lb4.setForeground(Color.white);
    	jf1.add(lb4);
        
        JLabel lb5=new JLabel(" SEARCH IN FULL ");
        lb5.setFont(F2);
    	lb5.setBounds(lax+160,140,500,60);
        lb5.setForeground(Color.white);
    	jf1.add(lb5);
        
        
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
            public void windowClosing(WindowEvent we){System.exit(0);}
        });
        
        
        F1=new Font("Agency FB",Font.PLAIN,30);
        label=new JLabel();
        label.setFont(F1);
        label.setForeground(Color.black);
        label.setBounds(lax+300,450,250,100);
        jf1.add(label);
        
        jf1.add(bg2);
        jf1.add(bg1);
        jf1.setVisible(true);
    }
}
