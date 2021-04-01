package nrx07;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;
public class Signup 
{
    static JFrame jf1;
    static JTextField tf1;
    static JTextField tf2;
    static JTextField tf3;
    static JPasswordField tf4;
    static JPasswordField tf5;
    static JLabel label;
    static String password;
    
    public static void add()
    {
        Connection con = null;
        Statement stmt = null;
        int ctr=0;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minii","root","Nrx07CR7.");
            stmt=con.createStatement();
            String sql="insert into users values ('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+password+"');";
            stmt.executeUpdate(sql);
        }
        catch(ClassNotFoundException | SQLException e){}
        Login.loginpassword();
        jf1.setVisible(false);
    }
    
    public static void checkID()
    {
        Connection con = null;
        Statement stmt = null;
        int ctr=0;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minii","root","Nrx07CR7.");
             stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users;");
            while(rs.next())
                if(rs.getString(1).equals(tf1.getText()))
                    ctr++;
            if(ctr!=0)
                label.setText("USERNAME NOT AVAILABLE");
            else
                checkpassword();
        }
        catch(ClassNotFoundException | SQLException e){}
    }
    
    public static void checkpassword()
    {
        String password1 = new String(tf4.getPassword());
        String password2 = new String(tf5.getPassword());
        if(password1.equals(password2))
        {
            password=password1;
            label.setText("");
            add();
        }
        else
        {
            label.setText("PASSWORDS DO NOT MATCH");
            tf4.setText("");
            tf5.setText("");
        }
    }
    
    public static void sp()
    {
        jf1=new JFrame("Sign Up");
    	jf1.setLayout(null);
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension d=t.getScreenSize();
        jf1.setSize(500,500);       
        jf1.setExtendedState(jf1.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        
        Font F1=new Font("Agency FB",Font.BOLD,70);
        
        JLabel la=new JLabel("SIGN UP");
        la.setFont(F1);
        int lax = (d.width/2);
    	la.setBounds(lax-600,100,200,60);
        la.setForeground(Color.white);
    	jf1.add(la);
        
        Font F2=new Font("Agency FB",Font.BOLD,30);
        
        JLabel lb=new JLabel("  USERNAME ");
        lb.setFont(F2);
    	lb.setBounds(lax-600,180,200,60);
        lb.setForeground(Color.white);
    	jf1.add(lb);
        
        JLabel lc=new JLabel("          NAME ");
        lc.setFont(F2);
    	lc.setBounds(lax-600,230,300,70);
        lc.setForeground(Color.white);
    	jf1.add(lc);
        
        JLabel ld=new JLabel("PASSWORD ");
        ld.setFont(F2);
    	ld.setBounds(lax-600,335,300,70);
        ld.setForeground(Color.white);
    	jf1.add(ld);
        
        JLabel le=new JLabel("RE PASSWORD");
        le.setFont(F2);
    	le.setBounds(lax-630,390,300,70);
        le.setForeground(Color.white);
    	jf1.add(le);
        
        JLabel lf=new JLabel("           EMAIL ID");
        lf.setFont(F2);
    	lf.setBounds(lax-630,280,300,70);
        lf.setForeground(Color.white);
    	jf1.add(lf);
        
        tf1=new JTextField("NRX07");
    	tf1.setBounds(lax-475,195,500,30);
    	jf1.add(tf1);
    	
    	tf2=new JTextField("John Stone");
    	tf2.setBounds(lax-475,250,500,30);
    	jf1.add(tf2);
        
        tf3=new JTextField("example@gmail.com");
    	tf3.setBounds(lax-475,300,500,30);
    	jf1.add(tf3);
        
        tf4=new JPasswordField();
    	tf4.setBounds(lax-475,355,500,30);
    	jf1.add(tf4);
        
        tf5=new JPasswordField();
    	tf5.setBounds(lax-475,410,500,30);
    	jf1.add(tf5);
        
        Font F3=new Font("Agency FB",Font.PLAIN,22);
        
        F1=new Font("Agency FB",Font.BOLD,30);
        
        label=new JLabel();
        label.setFont(F1);
        label.setForeground(Color.red);
        label.setBounds(lax-630,500,500,100);
        jf1.add(label);
        
        JButton jb1=new JButton("SUBMIT");
        jb1.setFont(F3);
        jb1.setBounds(lax-154,470,180,50);
        jb1.setForeground(Color.black);
        jb1.setBackground(Color.white);
        jb1.addActionListener(new ActionListener()
    	{
                @Override
    		public void actionPerformed(ActionEvent e)
    		{
                    checkID();
    		}
    	});
        jf1.add(jb1);
        
        BufferedImage img=null;
        try{img = ImageIO.read(new File("C:\\Users\\naman\\Desktop\\NRX07\\Programing\\NetBeans\\NetBeansCode\\NRX07\\src\\nrx07\\sp_1.png"));}
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
                    Login.loginpage();
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
}
