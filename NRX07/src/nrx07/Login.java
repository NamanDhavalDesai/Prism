package nrx07;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.sql.*;
public class Login
{
    static String username;
    static String password;
    static JPasswordField pf;
    static JTextField tf1;
    static JFrame jf1;
    static JLabel label;
    public static void checkuser()
    {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs;
        String query,passworddata=null;
        int k=1;
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minii","root","Nrx07CR7.");
            stmt=con.createStatement();
            query="select user_id, password_ from users where user_id ='"+username+"';";
            rs = stmt.executeQuery(query);
            rs.next();
            passworddata=rs.getString(2);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            label.setText("USER NOT FOUND");
            tf1.setText("");
            pf.setText("");
            k--;
        }
        if(password.equals(passworddata) &&  k==1)
        {
            if(username.equals("NRX07") || username.equals("AY489") || username.equals("PSG1012"))
            {
                Private.data();
                jf1.setVisible(false);
            }
            else
            {
                Search.basic_search();
                jf1.setVisible(false);
            }
        }
        else if (k==1)
        {
            label.setText("INCORRECT PASSWORD");
            pf.setText("");
        }
    }
    
    public static void loginpassword()
    {        
        jf1=new JFrame("Login");
    	jf1.setLayout(null);
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension d=t.getScreenSize();
        jf1.setSize(500,500);       
        jf1.setExtendedState(jf1.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        
        BufferedImage img=null;
        try{img = ImageIO.read(new File("C:\\Users\\naman\\Desktop\\NRX07\\Programing\\NetBeans\\NetBeansCode\\NRX07\\src\\nrx07\\second.png"));}
        catch(IOException e){System.out.println(e);}
        Image dimg=img.getScaledInstance(d.width+60,d.height-200, Image.SCALE_SMOOTH);
        JLabel bgl=new JLabel(new ImageIcon(dimg));
        bgl.setBounds(0,0,d.width+60,d.height-30);
        
        BufferedImage img2=null;
        try{img2 = ImageIO.read(new File("C:\\Users\\naman\\Desktop\\NRX07\\Programing\\NetBeans\\NetBeansCode\\NRX07\\src\\nrx07\\black.png"));}
        catch(IOException e){System.out.println(e);}
        Image dimg2=img2.getScaledInstance(d.width+60,d.height+100, Image.SCALE_SMOOTH);
        JLabel bg2=new JLabel(new ImageIcon(dimg2));
        bg2.setBounds(0,0,d.width+60,d.height+30);
        
        Font F1=new Font("Agency FB",Font.BOLD,30);
        
        label=new JLabel();
        label.setFont(F1);
        label.setForeground(Color.black);
        label.setBounds(240,375,250,100);
        jf1.add(label);
        
        F1=new Font("Agency FB",Font.BOLD,70);
        
        JLabel la=new JLabel("LOGIN");
        la.setFont(F1);
        int lax = (d.width/2);
    	la.setBounds(lax-100,150,200,60);
        la.setForeground(Color.white);
    	jf1.add(la);
        
        Font F2=new Font("Agency FB",Font.BOLD,30);
        
        JLabel lb=new JLabel("  USERNAME ");
        lb.setFont(F2);
    	lb.setBounds(lax-400,250,200,60);
        lb.setForeground(Color.white);
    	jf1.add(lb);
        
        JLabel lc=new JLabel("PASSWORD ");
        lc.setFont(F2);
    	lc.setBounds(lax-400,300,300,70);
        lc.setForeground(Color.white);
    	jf1.add(lc);
        
        tf1=new JTextField("NRX");
    	tf1.setBounds(lax-275,265,700,30);
    	jf1.add(tf1);
    	
    	pf=new JPasswordField();
    	pf.setBounds(lax-275,320,700,30);
    	jf1.add(pf);
        
        Font F3=new Font("Agency FB",Font.PLAIN,22);
        
        JButton jb1=new JButton("LOGIN");
        jb1.setFont(F3);
        jb1.setBounds(lax+240,375,180,50);
        jb1.setForeground(Color.black);
        jb1.setBackground(Color.white);
        jb1.addActionListener(new ActionListener()
    	{
                @Override
    		public void actionPerformed(ActionEvent e)
    		{
                    username=tf1.getText();
                    password= new String(pf.getPassword());
                    checkuser();
    		}
    	});
        jf1.add(jb1);
        
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
                    loginpage();
                    jf1.setVisible(false);
    		}
    	});
        jf1.add(jb2);
        
        jf1.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
        jf1.add(bgl);
        jf1.add(bg2);
        jf1.setVisible(true);
    }
    
    public static void loginpage()
    {
        JFrame jf1=new JFrame("Home");
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
        
        BufferedImage img2=null;
        try{img2 = ImageIO.read(new File("C:\\Users\\naman\\Desktop\\NRX07\\Programing\\NetBeans\\NetBeansCode\\NRX07\\src\\nrx07\\pl.png"));}
        catch(IOException e){System.out.println(e);}
         Image dimg2=img2.getScaledInstance(300,300, Image.SCALE_SMOOTH);
        JLabel bg2=new JLabel(new ImageIcon(dimg2));
        bg2.setBounds(-10,0,d.width+30,d.height-60);
        
        Font F1=new Font("Agency FB",Font.PLAIN,30);
        
        JLabel la=new JLabel("PLAYER'S RESEARCH AND INFORMATION SEARCHING MODEL ");
        la.setFont(F1);
        int lax = (d.width/3);
    	la.setBounds(lax-23,450,700,25);
        la.setForeground(Color.white);
    	jf1.add(la);
        
        F1=new Font("Agency FB",Font.BOLD,30);
        
        JLabel lb1=new JLabel("    P R I S M");
        lb1.setFont(F1);
    	lb1.setBounds(lax+152,400,700,25);
        lb1.setForeground(Color.white);
    	jf1.add(lb1);
        
        F1=new Font("Agency FB",Font.PLAIN,22);
        
        JButton jb1=new JButton("SIGN UP");
        jb1.setFont(F1);
        jb1.setBounds(lax-10,500,180,50);
        jb1.setForeground(Color.black);
        jb1.setBackground(Color.white);
        jb1.addActionListener(new ActionListener()
    	{
                @Override
    		public void actionPerformed(ActionEvent e)
    		{
                    Signup.sp();
                    jf1.setVisible(false);
    		}
    	});
        jf1.add(jb1);
        
        JButton jb2=new JButton("LOGIN");
        jb2.setFont(F1);
        jb2.setBounds(lax+250,500,180,50);
        jb2.setForeground(Color.black);
        jb2.setBackground(Color.white);
        jb2.addActionListener(new ActionListener()
    	{
                @Override
    		public void actionPerformed(ActionEvent e)
    		{
                    loginpassword();
                    jf1.setVisible(false);
    		}
    	});
        jf1.add(jb2);
        
        jf1.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we){System.exit(0);}
        });
        jf1.add(bg2);
        jf1.add(bgl);
        jf1.setVisible(true);
    }
}