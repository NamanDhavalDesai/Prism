package nrx07;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.sql.*;
public class PI 
{
    static int hash;
    public static void gethash(int no,String name)
    {
        int counter=0;
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
                hash=rs.getInt(1);
                if(counter==no)
                    break;
                counter++;
            }
        }
        catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }
    
    public static void pinfo(int no, String name)
    {
        gethash(no,name);
        String[] p=new String[8];
        String[] pstat=new String[6];
        String[] pexstat=new String[27];
        
        JFrame jf1=new JFrame("Print");
    	jf1.setLayout(null);
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension d=t.getScreenSize();
        jf1.setSize(500,500);       
        jf1.setExtendedState(jf1.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        
        BufferedImage img2=null;
        try{img2 = ImageIO.read(new File("C:\\Users\\naman\\Desktop\\NRX07\\Programing\\NetBeans\\NetBeansCode\\NRX07\\src\\nrx07\\black.png"));}
        catch(IOException e){System.out.println(e);}
        Image dimg2=img2.getScaledInstance(d.width+60,d.height+100, Image.SCALE_SMOOTH);
        JLabel bg2=new JLabel(new ImageIcon(dimg2));
        bg2.setBounds(0,0,d.width+60,d.height+30);
        
        BufferedImage img=null;
        try{img = ImageIO.read(new File("C:\\Users\\naman\\Desktop\\NRX07\\Programing\\NetBeans\\NetBeansCode\\NRX07\\src\\nrx07\\stats.png"));}
        catch(IOException e){System.out.println(e);}
        Image dimg=img.getScaledInstance(d.width,d.height-200, Image.SCALE_SMOOTH);
        JLabel bgl=new JLabel(new ImageIcon(dimg));
        bgl.setBounds(0,0,d.width,d.height);
        
        Connection con = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","Nrx07CR7.");
            stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from statplayers where hash_='"+hash+"';");
            while(rs.next())
            {
                pstat[0]=rs.getString(2);
                pstat[1]=rs.getString(3);
                pstat[2]=rs.getString(4);
                pstat[3]=rs.getString(5);
                pstat[4]=rs.getString(6);
                pstat[5]=rs.getString(7);   
            }
            ResultSet rs2 = stmt.executeQuery("select * from exstatplayers where hash_='"+hash+"';");
            while(rs2.next())
            {
                pexstat[0]=rs2.getString(2);
                pexstat[1]=rs2.getString(3);
                pexstat[2]=rs2.getString(4);
                pexstat[3]=rs2.getString(5);
                pexstat[4]=rs2.getString(6);
                pexstat[5]=rs2.getString(7);
                pexstat[6]=rs2.getString(8);
                pexstat[7]=rs2.getString(9);
                pexstat[8]=rs2.getString(10);
                pexstat[9]=rs2.getString(11);
                pexstat[10]=rs2.getString(12);
                pexstat[11]=rs2.getString(13);
                pexstat[12]=rs2.getString(14);
                pexstat[13]=rs2.getString(15);
                pexstat[14]=rs2.getString(16);
                pexstat[15]=rs2.getString(17);
                pexstat[16]=rs2.getString(18);
                pexstat[17]=rs2.getString(19);
                pexstat[18]=rs2.getString(20);
                pexstat[19]=rs2.getString(21);
                pexstat[20]=rs2.getString(22);
                pexstat[21]=rs2.getString(23);
                pexstat[22]=rs2.getString(24);
                pexstat[23]=rs2.getString(25);
                pexstat[24]=rs2.getString(26);
                pexstat[25]=rs2.getString(27);
                pexstat[26]=rs2.getString(28);
            }
            ResultSet rs3 = stmt.executeQuery("select * from players where hash_='"+hash+"';");
            while(rs3.next())
            {
                p[0]=rs3.getString(1);
                p[1]=rs3.getString(2);
                p[2]=rs3.getString(3);
                p[3]=rs3.getString(4);
                p[4]=rs3.getString(5);
                p[5]=rs3.getString(6);   
                p[6]=rs3.getString(7);
                p[7]=rs3.getString(8);   
            }
        }
        catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        
        Font F3=new Font("Agency FB",Font.PLAIN,22);                  
        JLabel j11=new JLabel("HASH");
        j11.setFont(F3);
        j11.setBounds(50,50,100,50);
        j11.setForeground(Color.red);
    	jf1.add(j11);
        JLabel j21=new JLabel(p[0]);
        j21.setFont(F3);
        j21.setBounds(150,50,300,50);
        j21.setForeground(Color.red);
    	jf1.add(j21);
        
        JLabel j12=new JLabel("RATING");
        j12.setFont(F3);
        j12.setBounds(50,75,100,50);
        j12.setForeground(Color.red);
    	jf1.add(j12);
        JLabel j22=new JLabel(p[1]);
        j22.setFont(F3);
        j22.setBounds(150,75,300,50);
        j22.setForeground(Color.red);
    	jf1.add(j22);
        
        JLabel j13=new JLabel("POSITION");
        j13.setFont(F3);
        j13.setBounds(50,100,100,50);
        j13.setForeground(Color.red);
    	jf1.add(j13);
        JLabel j23=new JLabel(p[2]);
        j23.setFont(F3);
        j23.setBounds(150,100,300,50);
        j23.setForeground(Color.red);
    	jf1.add(j23);
        
        JLabel j14=new JLabel("NAME");
        j14.setFont(F3);
        j14.setBounds(50,125,100,50);
        j14.setForeground(Color.red);
    	jf1.add(j14);
        JLabel j24=new JLabel(p[3]);
        j24.setFont(F3);
        j24.setBounds(150,125,300,50);
        j24.setForeground(Color.red);
    	jf1.add(j24);
        
        JLabel j15=new JLabel("CLUB");
        j15.setFont(F3);
        j15.setBounds(50,150,100,50);
        j15.setForeground(Color.red);
    	jf1.add(j15);
        JLabel j25=new JLabel(p[4]);
        j25.setFont(F3);
        j25.setBounds(150,150,300,50);
        j25.setForeground(Color.red);
    	jf1.add(j25);

        JLabel j16=new JLabel("LEAGUE");
        j16.setFont(F3);
        j16.setBounds(50,175,100,50);
        j16.setForeground(Color.red);
    	jf1.add(j16);
        JLabel j26=new JLabel(p[5]);
        j26.setFont(F3);
        j26.setBounds(150,175,300,50);
        j26.setForeground(Color.red);
    	jf1.add(j26);

        JLabel j17=new JLabel("NATION");
        j17.setFont(F3);
        j17.setBounds(50,200,100,50);
        j17.setForeground(Color.red);
    	jf1.add(j17);
        JLabel j27=new JLabel(p[6]);
        j27.setFont(F3);
        j27.setBounds(150,200,300,50);
        j27.setForeground(Color.red);
    	jf1.add(j27);
        
        JLabel j18=new JLabel("SKILLBOOST");
        j18.setFont(F3);
        j18.setBounds(50,225,100,50);
        j18.setForeground(Color.red);
    	jf1.add(j18);
        JLabel j28=new JLabel(p[7]);
        j28.setFont(F3);
        j28.setBounds(150,225,300,50);
        j28.setForeground(Color.red);
    	jf1.add(j28);
        
        JLabel js1=new JLabel("PACE");
        js1.setFont(F3);
        js1.setBounds(350,50,100,50);
        js1.setForeground(Color.white);
    	jf1.add(js1);
        JLabel jss1=new JLabel(pstat[0]);
        jss1.setFont(F3);
        jss1.setBounds(450,50,300,50);
        jss1.setForeground(Color.white);
    	jf1.add(jss1);
        
        JLabel jes1=new JLabel("ACCELERATION");
        jes1.setFont(F3);
        jes1.setBounds(550,50,100,50);
        jes1.setForeground(Color.white);
    	jf1.add(jes1);
        JLabel jess1=new JLabel(pexstat[0]);
        jess1.setFont(F3);
        jess1.setBounds(650,50,300,50);
        jess1.setForeground(Color.white);
    	jf1.add(jess1);
        
        JLabel jes2=new JLabel("SPRINT SPEED");
        jes2.setFont(F3);
        jes2.setBounds(550,75,100,50);
        jes2.setForeground(Color.white);
    	jf1.add(jes2);
        JLabel jess2=new JLabel(pexstat[1]);
        jess2.setFont(F3);
        jess2.setBounds(650,75,300,50);
        jess2.setForeground(Color.white);
    	jf1.add(jess2);                                                                                                     
                
        JLabel js2=new JLabel("SHOOTING");
        js2.setFont(F3);
        js2.setBounds(350,100,100,50);
        js2.setForeground(Color.white);
    	jf1.add(js2);
        JLabel jss2=new JLabel(pstat[1]);
        jss2.setFont(F3);
        jss2.setBounds(450,100,300,50);
        jss2.setForeground(Color.white);
    	jf1.add(jss2);
        
        JLabel jes3=new JLabel("POSITIONING");
        jes3.setFont(F3);
        jes3.setBounds(550,100,100,50);
        jes3.setForeground(Color.white);
    	jf1.add(jes3);
        JLabel jess3=new JLabel(pexstat[2]);
        jess3.setFont(F3);
        jess3.setBounds(650,100,300,50);
        jess3.setForeground(Color.white);
    	jf1.add(jess3);
        
        JLabel jes4=new JLabel("FINISHING");
        jes4.setFont(F3);
        jes4.setBounds(550,125,100,50);
        jes4.setForeground(Color.white);
    	jf1.add(jes4);
        JLabel jess4=new JLabel(pexstat[3]);
        jess4.setFont(F3);
        jess4.setBounds(650,125,300,50);
        jess4.setForeground(Color.white);
    	jf1.add(jess4);

        JLabel jes5=new JLabel("SHOT POWER");
        jes5.setFont(F3);
        jes5.setBounds(550,150,100,50);
        jes5.setForeground(Color.white);
    	jf1.add(jes5);
        JLabel jess5=new JLabel(pexstat[4]);
        jess5.setFont(F3);
        jess5.setBounds(650,150,300,50);
        jess5.setForeground(Color.white);
    	jf1.add(jess5);
        
        JLabel jes6=new JLabel("LONG SHOT");
        jes6.setFont(F3);
        jes6.setBounds(550,175,100,50);
        jes6.setForeground(Color.white);
    	jf1.add(jes6);
        JLabel jess6=new JLabel(pexstat[5]);
        jess6.setFont(F3);
        jess6.setBounds(650,175,300,50);
        jess6.setForeground(Color.white);
    	jf1.add(jess6);

        JLabel jes7=new JLabel("VOLLEYS");
        jes7.setFont(F3);
        jes7.setBounds(550,200,100,50);
        jes7.setForeground(Color.white);
    	jf1.add(jes7);
        JLabel jess7=new JLabel(pexstat[6]);
        jess7.setFont(F3);
        jess7.setBounds(650,200,300,50);
        jess7.setForeground(Color.white);
    	jf1.add(jess7);
        
        JLabel jes8=new JLabel("PENALTIES");
        jes8.setFont(F3);
        jes8.setBounds(550,225,100,50);
        jes8.setForeground(Color.white);
    	jf1.add(jes8);
        JLabel jess8=new JLabel(pexstat[7]);
        jess8.setFont(F3);
        jess8.setBounds(650,225,300,50);
        jess8.setForeground(Color.white);
    	jf1.add(jess8);
        
        JLabel js3=new JLabel("PASSING");
        js3.setFont(F3);
        js3.setBounds(350,250,100,50);
        js3.setForeground(Color.white);
    	jf1.add(js3);
        JLabel jss3=new JLabel(pstat[2]);
        jss3.setFont(F3);
        jss3.setBounds(450,250,300,50);
        jss3.setForeground(Color.white);
    	jf1.add(jss3);
                
        JLabel jes9=new JLabel("VISION");
        jes9.setFont(F3);
        jes9.setBounds(550,250,100,50);
        jes9.setForeground(Color.white);
    	jf1.add(jes9);
        JLabel jess9=new JLabel(pexstat[8]);
        jess9.setFont(F3);
        jess9.setBounds(650,250,300,50);
        jess9.setForeground(Color.white);
    	jf1.add(jess9);
        
        JLabel jes10=new JLabel("CROSSING");
        jes10.setFont(F3);
        jes10.setBounds(550,275,100,50);
        jes10.setForeground(Color.white);
    	jf1.add(jes10);
        JLabel jess10=new JLabel(pexstat[9]);
        jess10.setFont(F3);
        jess10.setBounds(650,275,300,50);
        jess10.setForeground(Color.white);
    	jf1.add(jess10);

        JLabel jes11=new JLabel("FREE KICK");
        jes11.setFont(F3);
        jes11.setBounds(550,300,100,50);
        jes11.setForeground(Color.white);
    	jf1.add(jes11);
        JLabel jess11=new JLabel(pexstat[10]);
        jess11.setFont(F3);
        jess11.setBounds(650,300,300,50);
        jess11.setForeground(Color.white);
    	jf1.add(jess11);
        
        JLabel jes12=new JLabel("SORT PASSING");
        jes12.setFont(F3);
        jes12.setBounds(550,325,100,50);
        jes12.setForeground(Color.white);
    	jf1.add(jes12);
        JLabel jess12=new JLabel(pexstat[11]);
        jess12.setFont(F3);
        jess12.setBounds(650,325,300,50);
        jess12.setForeground(Color.white);
    	jf1.add(jess12);

        JLabel jes13=new JLabel("LONG PASSING");
        jes13.setFont(F3);
        jes13.setBounds(550,350,100,50);
        jes13.setForeground(Color.white);
    	jf1.add(jes13);
        JLabel jess13=new JLabel(pexstat[12]);
        jess13.setFont(F3);
        jess13.setBounds(650,350,300,50);
        jess13.setForeground(Color.white);
    	jf1.add(jess13);
        
        JLabel jes14=new JLabel("CURVE");
        jes14.setFont(F3);
        jes14.setBounds(550,375,100,50);
        jes14.setForeground(Color.white);
    	jf1.add(jes14);
        JLabel jess14=new JLabel(pexstat[13]);
        jess14.setFont(F3);
        jess14.setBounds(650,375,300,50);
        jess14.setForeground(Color.white);
    	jf1.add(jess14);

        JLabel js4=new JLabel("AGILITY (AVG)");
        js4.setFont(F3);
        js4.setBounds(350,400,100,50);
        js4.setForeground(Color.white);
    	jf1.add(js4);
        JLabel jss4=new JLabel(pstat[3]);
        jss4.setFont(F3);
        jss4.setBounds(450,400,300,50);
        jss4.setForeground(Color.white);
    	jf1.add(jss4);
                
        JLabel jes15=new JLabel("AGILITY");
        jes15.setFont(F3);
        jes15.setBounds(550,400,100,50);
        jes15.setForeground(Color.white);
    	jf1.add(jes15);
        JLabel jess15=new JLabel(pexstat[14]);
        jess15.setFont(F3);
        jess15.setBounds(650,400,300,50);
        jess15.setForeground(Color.white);
    	jf1.add(jess15);
        
        JLabel jes16=new JLabel("BALANCE");
        jes16.setFont(F3);
        jes16.setBounds(550,425,100,50);
        jes16.setForeground(Color.white);
    	jf1.add(jes16);
        JLabel jess16=new JLabel(pexstat[15]);
        jess16.setFont(F3);
        jess16.setBounds(650,425,300,50);
        jess16.setForeground(Color.white);
    	jf1.add(jess16);

        JLabel jes17=new JLabel("REACTIONS");
        jes17.setFont(F3);
        jes17.setBounds(550,450,100,50);
        jes17.setForeground(Color.white);
    	jf1.add(jes17);
        JLabel jess17=new JLabel(pexstat[16]);
        jess17.setFont(F3);
        jess17.setBounds(650,450,300,50);
        jess17.setForeground(Color.white);
    	jf1.add(jess17);
        
        JLabel jes18=new JLabel("BALL CONTROL");
        jes18.setFont(F3);
        jes18.setBounds(550,475,100,50);
        jes18.setForeground(Color.white);
    	jf1.add(jes18);
        JLabel jess18=new JLabel(pexstat[17]);
        jess18.setFont(F3);
        jess18.setBounds(650,475,300,50);
        jess18.setForeground(Color.white);
    	jf1.add(jess18);

        JLabel jes19=new JLabel("DRIBBLING");
        jes19.setFont(F3);
        jes19.setBounds(550,500,100,50);
        jes19.setForeground(Color.white);
    	jf1.add(jes19);
        JLabel jess19=new JLabel(pexstat[18]);
        jess19.setFont(F3);
        jess19.setBounds(650,500,300,50);
        jess19.setForeground(Color.white);
    	jf1.add(jess19);
        
        JLabel js5=new JLabel("PHYSICAL");
        js5.setFont(F3);
        js5.setBounds(350,525,100,50);
        js5.setForeground(Color.white);
    	jf1.add(js5);
        JLabel jss5=new JLabel(pstat[5]);
        jss5.setFont(F3);
        jss5.setBounds(450,525,300,50);
        jss5.setForeground(Color.white);
    	jf1.add(jss5);
                
        JLabel jes20=new JLabel("JUMPING");
        jes20.setFont(F3);
        jes20.setBounds(550,525,100,50);
        jes20.setForeground(Color.white);
    	jf1.add(jes20);
        JLabel jess20=new JLabel(pexstat[24]);
        jess20.setFont(F3);
        jess20.setBounds(650,525,300,50);
        jess20.setForeground(Color.white);
    	jf1.add(jess20);
        
        JLabel jes21=new JLabel("STRENGTH");
        jes21.setFont(F3);
        jes21.setBounds(550,550,100,50);
        jes21.setForeground(Color.white);
    	jf1.add(jes21);
        JLabel jess21=new JLabel(pexstat[25]);
        jess21.setFont(F3);
        jess21.setBounds(650,550,300,50);
        jess21.setForeground(Color.white);
    	jf1.add(jess21);

        JLabel jes22=new JLabel("AGRESSION");
        jes22.setFont(F3);
        jes22.setBounds(550,575,100,50);
        jes22.setForeground(Color.white);
    	jf1.add(jes22);
        JLabel jess22=new JLabel(pexstat[26]);
        jess22.setFont(F3);
        jess22.setBounds(650,575,300,50);
        jess22.setForeground(Color.white);
    	jf1.add(jess22);
        
                JLabel js6=new JLabel("DEFENDING");
        js6.setFont(F3);
        js6.setBounds(750,50,100,50);
        js6.setForeground(Color.white);
    	jf1.add(js6);
        JLabel jss6=new JLabel(pstat[4]);
        jss6.setFont(F3);
        jss6.setBounds(850,50,300,50);
        jss6.setForeground(Color.white);
    	jf1.add(jss6);
        
        JLabel jes23=new JLabel("INTERCEPTINS");
        jes23.setFont(F3);
        jes23.setBounds(950,50,100,50);
        jes23.setForeground(Color.white);
    	jf1.add(jes23);
        JLabel jess23=new JLabel(pexstat[19]);
        jess23.setFont(F3);
        jess23.setBounds(1050,50,300,50);
        jess23.setForeground(Color.white);
    	jf1.add(jess23);
        
                JLabel jes24=new JLabel("HEADING");
        jes24.setFont(F3);
        jes24.setBounds(950,75,100,50);
        jes24.setForeground(Color.white);
    	jf1.add(jes24);
        JLabel jess24=new JLabel(pexstat[20]);
        jess24.setFont(F3);
        jess24.setBounds(1050,75,300,50);
        jess24.setForeground(Color.white);
    	jf1.add(jess24);

        JLabel jes25=new JLabel("MARKING");
        jes25.setFont(F3);
        jes25.setBounds(950,100,100,50);
        jes25.setForeground(Color.white);
    	jf1.add(jes25);
        JLabel jess25=new JLabel(pexstat[21]);
        jess25.setFont(F3);
        jess25.setBounds(1050,100,300,50);
        jess25.setForeground(Color.white);
    	jf1.add(jess25);

        JLabel jes26=new JLabel("STAND TACKLE");
        jes26.setFont(F3);
        jes26.setBounds(950,125,100,50);
        jes26.setForeground(Color.white);
    	jf1.add(jes26);
        JLabel jess26=new JLabel(pexstat[22]);
        jess26.setFont(F3);
        jess26.setBounds(1050,125,300,50);
        jess26.setForeground(Color.white);
    	jf1.add(jess26);

        JLabel jes27=new JLabel("SLIDE TACKLE");
        jes27.setFont(F3);
        jes27.setBounds(950,150,100,50);
        jes27.setForeground(Color.white);
    	jf1.add(jes27);
        JLabel jess27=new JLabel(pexstat[23]);
        jess27.setFont(F3);
        jess27.setBounds(1050,150,300,50);
        jess27.setForeground(Color.white);
    	jf1.add(jess27);
        
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
                    Printing.printingpage(name);
                    jf1.setVisible(false);
    		}
    	});
        //jf1.add(jb2);
        jf1.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                //System.exit(0);
                jf1.setVisible(false);
            }
        });
        jf1.add(bgl);
        jf1.add(bg2);
        jf1.setVisible(true);
    }
    public static void kinfo(int no, String name)
    {
        gethash(no,name);
        String[] kstat=new String[6];
        String[] kexstat=new String[11];
        String[] k=new String[8];
        JFrame jf1=new JFrame("Print");
    	jf1.setLayout(null);
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension d=t.getScreenSize();
        jf1.setSize(500,500);       
        jf1.setExtendedState(jf1.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        
        BufferedImage img2=null;
        try{img2 = ImageIO.read(new File("C:\\Users\\naman\\Desktop\\NRX07\\Programing\\NetBeans\\NetBeansCode\\NRX07\\src\\nrx07\\black.png"));}
        catch(IOException e){System.out.println(e);}
        Image dimg2=img2.getScaledInstance(d.width+60,d.height+100, Image.SCALE_SMOOTH);
        JLabel bg2=new JLabel(new ImageIcon(dimg2));
        bg2.setBounds(0,0,d.width+60,d.height+30);
        
        BufferedImage img=null;
        try{img = ImageIO.read(new File("C:\\Users\\naman\\Desktop\\NRX07\\Programing\\NetBeans\\NetBeansCode\\NRX07\\src\\nrx07\\stats.png"));}
        catch(IOException e){System.out.println(e);}
        Image dimg=img.getScaledInstance(d.width+60,d.height-200, Image.SCALE_SMOOTH);
        JLabel bgl=new JLabel(new ImageIcon(dimg));
        bgl.setBounds(0,0,d.width+60,d.height-30);
        
        Connection con = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","Nrx07CR7.");
            stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from statkeepers where hash_='"+hash+"';");
            while(rs.next())
            {
                kstat[0]=rs.getString(2);
                kstat[1]=rs.getString(3);
                kstat[2]=rs.getString(4);
                kstat[3]=rs.getString(5);
                kstat[4]=rs.getString(6);
                kstat[5]=rs.getString(7);   
            }
            ResultSet rs2 = stmt.executeQuery("select * from exstatkeepers where hash_='"+hash+"';");
            while(rs2.next())
            {
                kexstat[0]=rs2.getString(2);
                kexstat[1]=rs2.getString(3);
                kexstat[2]=rs2.getString(4);
                kexstat[3]=rs2.getString(5);
                kexstat[4]=rs2.getString(6);
                kexstat[5]=rs2.getString(7);
                kexstat[6]=rs2.getString(8);
                kexstat[7]=rs2.getString(9);
                kexstat[8]=rs2.getString(10);
                kexstat[9]=rs2.getString(11);
                
                kexstat[10]=rs2.getString(12);
            }
            ResultSet rs3 = stmt.executeQuery("select * from players where hash_='"+hash+"';");
            while(rs3.next())
            {
                k[0]=rs3.getString(1);
                k[1]=rs3.getString(2);
                k[2]=rs3.getString(3);
                k[3]=rs3.getString(4);
                k[4]=rs3.getString(5);
                k[5]=rs3.getString(6);   
                k[6]=rs3.getString(7);
                k[7]=rs3.getString(8);   
            }
        }
        catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        
        Font F3=new Font("Agency FB",Font.PLAIN,22);                  
        JLabel j11=new JLabel("HASH");
        j11.setFont(F3);
        j11.setBounds(50,50,100,50);
        j11.setForeground(Color.red);
    	jf1.add(j11);
        JLabel j21=new JLabel(k[0]);
        j21.setFont(F3);
        j21.setBounds(150,50,300,50);
        j21.setForeground(Color.red);
    	jf1.add(j21);
        
        JLabel j12=new JLabel("RATING");
        j12.setFont(F3);
        j12.setBounds(50,75,100,50);
        j12.setForeground(Color.red);
    	jf1.add(j12);
        JLabel j22=new JLabel(k[1]);
        j22.setFont(F3);
        j22.setBounds(150,75,300,50);
        j22.setForeground(Color.red);
    	jf1.add(j22);
        
        JLabel j13=new JLabel("POSITION");
        j13.setFont(F3);
        j13.setBounds(50,100,100,50);
        j13.setForeground(Color.red);
    	jf1.add(j13);
        JLabel j23=new JLabel(k[2]);
        j23.setFont(F3);
        j23.setBounds(150,100,300,50);
        j23.setForeground(Color.red);
    	jf1.add(j23);
        
        JLabel j14=new JLabel("NAME");
        j14.setFont(F3);
        j14.setBounds(50,125,100,50);
        j14.setForeground(Color.red);
    	jf1.add(j14);
        JLabel j24=new JLabel(k[3]);
        j24.setFont(F3);
        j24.setBounds(150,125,300,50);
        j24.setForeground(Color.red);
    	jf1.add(j24);
        
        JLabel j15=new JLabel("CLUB");
        j15.setFont(F3);
        j15.setBounds(50,150,100,50);
        j15.setForeground(Color.red);
    	jf1.add(j15);
        JLabel j25=new JLabel(k[4]);
        j25.setFont(F3);
        j25.setBounds(150,150,300,50);
        j25.setForeground(Color.red);
    	jf1.add(j25);

        JLabel j16=new JLabel("LEAGUE");
        j16.setFont(F3);
        j16.setBounds(50,175,100,50);
        j16.setForeground(Color.red);
    	jf1.add(j16);
        JLabel j26=new JLabel(k[5]);
        j26.setFont(F3);
        j26.setBounds(150,175,300,50);
        j26.setForeground(Color.red);
    	jf1.add(j26);

        JLabel j17=new JLabel("NATION");
        j17.setFont(F3);
        j17.setBounds(50,200,100,50);
        j17.setForeground(Color.red);
    	jf1.add(j17);
        JLabel j27=new JLabel(k[6]);
        j27.setFont(F3);
        j27.setBounds(150,200,300,50);
        j27.setForeground(Color.red);
    	jf1.add(j27);
        
        JLabel j18=new JLabel("SKILLBOOST");
        j18.setFont(F3);
        j18.setBounds(50,225,100,50);
        j18.setForeground(Color.red);
    	jf1.add(j18);
        JLabel j28=new JLabel(k[7]);
        j28.setFont(F3);
        j28.setBounds(150,225,300,50);
        j28.setForeground(Color.red);
    	jf1.add(j28);
        
        JLabel js1=new JLabel("DIVING");
        js1.setFont(F3);
        js1.setBounds(350,50,100,50);
        js1.setForeground(Color.white);
    	jf1.add(js1);
        JLabel jss1=new JLabel(kstat[0]);
        jss1.setFont(F3);
        jss1.setBounds(450,50,300,50);
        jss1.setForeground(Color.white);
    	jf1.add(jss1);
        
        JLabel js2=new JLabel("POSITIONING");
        js2.setFont(F3);
        js2.setBounds(350,75,100,50);
        js2.setForeground(Color.white);
    	jf1.add(js2);
        JLabel jss2=new JLabel(kstat[1]);
        jss2.setFont(F3);
        jss2.setBounds(450,75,300,50);
        jss2.setForeground(Color.white);
    	jf1.add(jss2);
        
        JLabel js3=new JLabel("HANDLING");
        js3.setFont(F3);
        js3.setBounds(350,100,100,50);
        js3.setForeground(Color.white);
    	jf1.add(js3);
        JLabel jss3=new JLabel(kstat[2]);
        jss3.setFont(F3);
        jss3.setBounds(450,100,300,50);
        jss3.setForeground(Color.white);
    	jf1.add(jss3);
        
        JLabel js4=new JLabel("REFLEXES");
        js4.setFont(F3);
        js4.setBounds(350,125,100,50);
        js4.setForeground(Color.white);
    	jf1.add(js4);
        JLabel jss4=new JLabel(kstat[3]);
        jss4.setFont(F3);
        jss4.setBounds(450,125,300,50);
        jss4.setForeground(Color.white);
    	jf1.add(jss4);
        
        JLabel jes1=new JLabel("LONG PASSING");
        jes1.setFont(F3);
        jes1.setBounds(550,150,100,50);
        jes1.setForeground(Color.white);
    	jf1.add(jes1);
        JLabel jess1=new JLabel(kexstat[6]);
        jess1.setFont(F3);
        jess1.setBounds(650,150,300,50);
        jess1.setForeground(Color.white);
    	jf1.add(jess1);
        
        JLabel js5=new JLabel("KICKING");
        js5.setFont(F3);
        js5.setBounds(350,150,100,50);
        js5.setForeground(Color.white);
    	jf1.add(js5);
        JLabel jss5=new JLabel(kstat[4]);
        jss5.setFont(F3);
        jss5.setBounds(450,150,300,50);
        jss5.setForeground(Color.white);
    	jf1.add(jss5);
        
        JLabel jes2=new JLabel("JUMPING");
        jes2.setFont(F3);
        jes2.setBounds(550,125,100,50);
        jes2.setForeground(Color.white);
    	jf1.add(jes2);
        JLabel jess2=new JLabel(kexstat[4]);
        jess2.setFont(F3);
        jess2.setBounds(650,125,300,50);
        jess2.setForeground(Color.white);
    	jf1.add(jess2);

        JLabel js6=new JLabel("PHYSICAL");
        js6.setFont(F3);
        js6.setBounds(350,175,100,50);
        js6.setForeground(Color.white);
    	jf1.add(js6);
        JLabel jss6=new JLabel(kstat[5]);
        jss6.setFont(F3);
        jss6.setBounds(450,175,300,50);
        jss6.setForeground(Color.white);
    	jf1.add(jss6);
        
        JLabel jes3=new JLabel("REACTIONS");
        jes3.setFont(F3);
        jes3.setBounds(550,175,100,50);
        jes3.setForeground(Color.white);
    	jf1.add(jes3);
        JLabel jess3=new JLabel(kexstat[7]);
        jess3.setFont(F3);
        jess3.setBounds(650,175,300,50);
        jess3.setForeground(Color.white);
    	jf1.add(jess3);
        
        JLabel jes4=new JLabel("AGILITY");
        jes4.setFont(F3);
        jes4.setBounds(550,200,100,50);
        jes4.setForeground(Color.white);
    	jf1.add(jes4);
        JLabel jess4=new JLabel(kexstat[8]);
        jess4.setFont(F3);
        jess4.setBounds(650,200,300,50);
        jess4.setForeground(Color.white);
    	jf1.add(jess4);
        
        JLabel jes5=new JLabel("SPRINT SPEED");
        jes5.setFont(F3);
        jes5.setBounds(550,225,100,50);
        jes5.setForeground(Color.white);
    	jf1.add(jes5);
        JLabel jess5=new JLabel(kexstat[9]);
        jess5.setFont(F3);
        jess5.setBounds(650,225,300,50);
        jess5.setForeground(Color.white);
    	jf1.add(jess5);
        
        JLabel jes6=new JLabel("STRENGTH");
        jes6.setFont(F3);
        jes6.setBounds(550,250,100,50);
        jes6.setForeground(Color.white);
    	jf1.add(jes6);
        JLabel jess6=new JLabel(kexstat[7]);
        jess6.setFont(F3);
        jess6.setBounds(650,250,300,50);
        jess6.setForeground(Color.white);
    	jf1.add(jess6);
        
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
                    Printing.printingpage(name);
                    jf1.setVisible(false);
    		}
    	});
        //jf1.add(jb2);
        jf1.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                //System.exit(0);
                jf1.setVisible(false);
            }
        });
        jf1.add(bgl);
        jf1.add(bg2);
        jf1.setVisible(true);
    }
}