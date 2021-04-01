package nrx07;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Private 
{
    static Frame jf1;
    public static void data()
    {
        jf1=new JFrame("DataAdmin");
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
        
        Font F2=new Font("Agency FB",Font.BOLD,30);       
        int lax = (d.width/2);
        
        JLabel lb=new JLabel("Enter the number of pages");
        lb.setFont(F2);
    	lb.setBounds(lax-400,250,300,60);
        lb.setForeground(Color.white);
    	jf1.add(lb);
        
        JTextField tf1=new JTextField("500");
    	tf1.setBounds(lax-125,265,500,30);
    	jf1.add(tf1);
    	
        Font F1=new Font("Agency FB",Font.BOLD,30);
        
        JLabel label=new JLabel();
        label.setFont(F1);
        label.setForeground(Color.red);
        label.setBounds(lax-630,500,500,100);
        jf1.add(label);
        
        Font F3=new Font("Agency FB",Font.PLAIN,22);
        
        JButton jb1=new JButton("GET");
        jb1.setFont(F3);
        jb1.setBounds(lax+240,375,180,50);
        jb1.setForeground(Color.black);
        jb1.setBackground(Color.white);
        jb1.addActionListener(new ActionListener()
    	{
                @Override
    		public void actionPerformed(ActionEvent e)
    		{
                        Data.getsetdata(Integer.parseInt(tf1.getText()));
                        label.setText("DATA UPDATED");
    		}
    	});
        jf1.add(jb1);
        
        JButton jb3=new JButton("DELETE");
        jb3.setFont(F3);
        jb3.setBounds(lax+240,455,180,50);
        jb3.setForeground(Color.black);
        jb3.setBackground(Color.white);
        jb3.addActionListener(new ActionListener()
    	{
                @Override
    		public void actionPerformed(ActionEvent e)
    		{
                        Data.delete();
                        label.setText("DATA DELETED");
    		}
    	});
        jf1.add(jb3);
        
        JButton jb2=new JButton("CONTINUE");
        jb2.setFont(F3);
        jb2.setBounds(lax,375,180,50);
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