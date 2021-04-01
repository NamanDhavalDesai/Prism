package nrx07;
import java.util.*;
import java.sql.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Data 
{
    static int len=0;
    static int j=-1;
    static int k=0;
    static String[] ratings=new String [30000];
    static String[] positions=new String [30000];
    static String[] names=new String [30000];
    static String[] clubs=new String [30000];
    static String[] leagues=new String [30000];
    static String[] nations=new String [30000];
    static String[] skillboosts=new String [30000];
    static String[] stats1=new String [30000];
    static String[] stats2=new String [30000];
    static String[] stats3=new String [30000];
    static String[] stats4=new String [30000];
    static String[] stats5=new String [30000];
    static String[] stats6=new String [30000];
    static String[] pstats1=new String [30000];
    static String[] pstats2=new String [30000];
    static String[] pstats3=new String [30000];
    static String[] pstats4=new String [30000];
    static String[] pstats5=new String [30000];
    static String[] pstats6=new String [30000];
    static String[] pstats7=new String [30000];
    static String[] pstats8=new String [30000];
    static String[] pstats9=new String [30000];
    static String[] pstats10=new String [30000];
    static String[] pstats11=new String [30000];
    static String[] pstats12=new String [30000];
    static String[] pstats13=new String [30000];
    static String[] pstats14=new String [30000];
    static String[] pstats15=new String [30000];
    static String[] pstats16=new String [30000];
    static String[] pstats17=new String [30000];
    static String[] pstats18=new String [30000];
    static String[] pstats19=new String [30000];
    static String[] pstats20=new String [30000];
    static String[] pstats21=new String [30000];
    static String[] pstats22=new String [30000];
    static String[] pstats23=new String [30000];
    static String[] pstats24=new String [30000];
    static String[] pstats25=new String [30000];
    static String[] pstats26=new String [30000];
    static String[] pstats27=new String [30000];
    static String[] gstats1=new String [30000];
    static String[] gstats2=new String [30000];
    static String[] gstats3=new String [30000];
    static String[] gstats4=new String [30000];
    static String[] gstats5=new String [30000];
    static String[] gstats6=new String [30000];
    static String[] gstats7=new String [30000];
    static String[] gstats8=new String [30000];
    static String[] gstats9=new String [30000];
    static String[] gstats10=new String [30000];
    static String[] gstats11=new String [30000];
    public static void getsetdata(int len) 
    {
        Scanner ob=new Scanner (System.in);
        get(len);
        set();
        //print();
    }
    public static void delete()
    {
        String sql;
        Connection con = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minii","root","Nrx07CR7.");
            stmt=con.createStatement();
            stmt.executeUpdate("delete from exstatplayers;");          
            stmt.executeUpdate("delete from exstatkeepers;");
            stmt.executeUpdate("delete from statplayers;");          
            stmt.executeUpdate("delete from statkeepers;");
            stmt.executeUpdate("delete from players;");          
        }
        catch(ClassNotFoundException | SQLException e){}
    }
    public static void set()
    {
        delete();
        String sql;
        Connection con = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minii","root","Nrx07CR7.");
             stmt=con.createStatement();
            for(int i=0;i<j+1;i++)
            {
                if(names[i].contains("'"))
                    names[i]=names[i].replace('\'',' ');
                if(clubs[i].contains("'"))
                    clubs[i]=clubs[i].replace('\'',' ');
                if(leagues[i].contains("'"))
                    leagues[i]=leagues[i].replace('\'',' ');
                if(nations[i].contains("'"))
                    nations[i]=nations[i].replace('\'',' ');
                
                sql = "INSERT INTO players VALUES ("+i+","+ratings[i]+","+"'"+positions[i]+"'"+","+"'"+names[i]+"'"+","
                                                +"'"+clubs[i]+"'"+","+"'"+leagues[i]+"'"+","
                                                +"'"+nations[i]+"'"+","+"'"+skillboosts[i]+"'"+")"+";";
                stmt.executeUpdate(sql);
                if(positions[i].equals("GK"))
                {
                    sql= "INSERT INTO statkeepers VALUES ("+i+","+stats1[i]+","+stats2[i]+","+stats3[i]+","+stats4[i]+","+stats5[i]
                            +","+stats6[i]+");";
                    stmt.executeUpdate(sql);
                    sql= "INSERT INTO exstatkeepers VALUES ("+i+","+gstats1[i]+","+gstats2[i]+","+gstats3[i]+","+gstats4[i]+","
                            +gstats5[i]+","+gstats6[i]+","+gstats7[i]+","+gstats8[i]+","+gstats9[i]+","+gstats10[i]
                            +","+gstats11[i]+");";
                    stmt.executeUpdate(sql);
                }
                else
                {
                    sql= "INSERT INTO statplayers VALUES ("+i+","+stats1[i]+","+stats2[i]+","+stats3[i]+","+stats4[i]+","+stats5[i]
                            +","+stats6[i]+");";
                    stmt.executeUpdate(sql);
                    sql= "INSERT INTO exstatplayers VALUES ("+i+","+pstats1[i]+","+pstats2[i]+","+pstats3[i]+","+pstats4[i]+","
                            +pstats5[i]+","+pstats6[i]+","+pstats7[i]+","+pstats8[i]+","+pstats9[i]+","+pstats10[i]
                            +","+pstats11[i]+","+pstats12[i]+","+pstats13[i]+","+pstats14[i]+","+pstats15[i]+","+pstats16[i]
                            +","+pstats17[i]+","+pstats18[i]+","+pstats19[i]+","+pstats20[i]+","+pstats21[i]+","+pstats22[i]
                            +","+pstats23[i]+","+pstats24[i]+","+pstats25[i]+","+pstats26[i]+","+pstats27[i]+");";
                    stmt.executeUpdate(sql);
                }
            }          
        }
        catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }
    public static void get(int len)
    {
        for(int i=1;i<=len;i++)
        {
            String userlink="https://fifarenderz.com/20/players?page="+i+"&scope=DESC&filter=rating&bigcards=false";
            getdata(userlink);
            getadddata(userlink);
        }
    }
    public static void print()
    {
        for(int i=0;i<j+1;i++)
        {
            System.out.print((i+1)+"\t\t"+ratings[i]+"\t\t"+positions[i]+"\t\t"+names[i]+"\t\t"+clubs[i]
                                  +"\t\t"+leagues[i]+"\t\t"+nations[i]+"\t\t"+skillboosts[i]+"\t\t"+stats1[i]
                                  +"\t\t"+stats2[i]+"\t\t"+stats3[i]+"\t\t"+stats4[i]+"\t\t"+stats5[i]+"\t\t"+stats6[i]);
            if(positions[i].equals("GK"))
                System.out.println("\t\t"+gstats1[i]+"\t\t"+gstats2[i]+"\t\t"+gstats3[i]+"\t\t"+gstats4[i]+
                                   "\t\t"+gstats5[i]+"\t\t"+gstats6[i]+"\t\t"+gstats7[i]+"\t\t"+gstats8[i]+
                                   "\t\t"+gstats9[i]+"\t\t"+gstats10[i]+"\t\t"+gstats11[i]);
            else
                System.out.println("\t\t"+pstats1[i]+"\t\t"+pstats2[i]+"\t\t"+pstats3[i]+"\t\t"+pstats4[i]+
                                   "\t\t"+pstats5[i]+"\t\t"+pstats6[i]+"\t\t"+pstats7[i]+"\t\t"+pstats8[i]+
                                   "\t\t"+pstats9[i]+"\t\t"+pstats10[i]+"\t\t"+pstats11[i]+"\t\t"+pstats12[i]+
                                   "\t\t"+pstats13[i]+"\t\t"+pstats14[i]+"\t\t"+pstats15[i]+"\t\t"+pstats16[i]+
                                   "\t\t"+pstats17[i]+"\t\t"+pstats18[i]+"\t\t"+pstats19[i]+"\t\t"+pstats20[i]+
                                   "\t\t"+pstats21[i]+"\t\t"+pstats22[i]+"\t\t"+pstats23[i]+"\t\t"+pstats24[i]+
                                   "\t\t"+pstats25[i]+"\t\t"+pstats26[i]+"\t\t"+pstats27[i] );
        }   
    }
    public static void getdata(String url)
    {
        String[] data=null;
        int i=0,len=0;
        Elements s;
        try
        {
            Document doc = Jsoup.connect(url).get();
            s=doc.select("span");
            data = new String[s.size()];
            for (i = 0; i < s.size(); i++) 
                data[i] = s.get(i).text();
        }
        catch(Exception e){} 
        len=(data.length-11)/19;       
        i=7;
        for(int loop=1;loop<=len;loop++)
        {
            j++;
            ratings[j]=data[i];
            positions[j]=data[i+1];
            names[j]=data[i+2];
            clubs[j]=data[i+3];
            leagues[j]=data[i+4];
            nations[j]=data[i+5];
            skillboosts[j]=data[i+6];
            stats1[j]=data[i+7];
            stats2[j]=data[i+9];
            stats3[j]=data[i+11];
            stats4[j]=data[i+13];
            stats5[j]=data[i+15];
            stats6[j]=data[i+17];
            i=i+19;
        }
    }
    public static void getadddata(String url)
    {
        Elements links=null;
        Elements rdata=null;
        String[] data=null;
        int i;
        try
        {
            Document doc = Jsoup.connect(url).get();
            links=doc.select("a[href]");
        }
        catch(Exception e){} 
        for (Element link : links) 
        {
            if( link.attr("href").startsWith("/20/player/") )
            {
                try
                {
                    Document doc = Jsoup.connect("https://fifarenderz.com/"+link.attr("href")).get();
                    rdata=doc.select("span");
                    data = new String[rdata.size()];
                    for (i = 0; i < rdata.size(); i++) 
                        data[i] = rdata.get(i).text();
                }
                catch(Exception e){} 
                for(i=0;i<data.length;i++)
                {
                    if(positions[k] == null)
                        break;
                    if(positions[k].equals("GK"))
                    {
                        if(data[i].equals("GK Diving"))
                            gstats1[k]=data[i+1];
                        if(data[i].equals("GK Positioning"))
                            gstats2[k]=data[i+1];
                        if(data[i].equals("Handling"))
                            gstats3[k]=data[i+1];
                        if(data[i].equals("Reflexes"))
                            gstats4[k]=data[i+1];
                        if(data[i].equals("Jumping"))
                            gstats5[k]=data[i+1];
                        if(data[i].equals("GK Kicking"))
                            gstats6[k]=data[i+1];
                        if(data[i].equals("Long Passing"))
                            gstats7[k]=data[i+1];
                        if(data[i].equals("Reactions"))
                            gstats8[k]=data[i+1];
                        if(data[i].equals("Agility"))
                            gstats9[k]=data[i+1];
                        if(data[i].equals("Sprint Speed"))
                            gstats10[k]=data[i+1];
                        if(data[i].equals("Strength"))
                        {
                            gstats11[k]=data[i+1];
                            k++;
                        }
                    }
                    else
                    {
                        if(data[i].equals("Acceleration"))
                            pstats1[k]=data[i+1];
                        if(data[i].equals("Sprint Speed"))
                            pstats2[k]=data[i+1];
                        if(data[i].equals("Positioning"))
                            pstats3[k]=data[i+1];
                        if(data[i].equals("Finishing"))
                            pstats4[k]=data[i+1];
                        if(data[i].equals("Shot Power"))
                            pstats5[k]=data[i+1];
                        if(data[i].equals("Long Shot"))
                            pstats6[k]=data[i+1];
                        if(data[i].equals("Volleys"))
                            pstats7[k]=data[i+1];
                        if(data[i].equals("Penalties"))
                            pstats8[k]=data[i+1];
                        if(data[i].equals("Vision"))
                            pstats9[k]=data[i+1];
                        if(data[i].equals("Crossing"))
                            pstats10[k]=data[i+1];
                        if(data[i].equals("Free Kick"))
                            pstats11[k]=data[i+1];
                        if(data[i].equals("Short Passing"))
                            pstats12[k]=data[i+1];
                        if(data[i].equals("Long Passing"))
                            pstats13[k]=data[i+1];
                        if(data[i].equals("Curve"))
                            pstats14[k]=data[i+1];
                        if(data[i].equals("Agility"))
                            pstats15[k]=data[i+1];
                        if(data[i].equals("Balance"))
                            pstats16[k]=data[i+1];
                        if(data[i].equals("Reactions"))
                            pstats17[k]=data[i+1];
                        if(data[i].equals("Ball Control"))
                            pstats18[k]=data[i+1];
                        if(data[i].equals("Dribbling"))
                            pstats19[k]=data[i+1];
                        if(data[i].equals("Interceptions"))
                            pstats20[k]=data[i+1];
                        if(data[i].equals("Heading"))
                            pstats21[k]=data[i+1];
                        if(data[i].equals("Marking"))
                            pstats22[k]=data[i+1];
                        if(data[i].equals("Stand Tackle"))
                            pstats23[k]=data[i+1];
                        if(data[i].equals("Sliding Tackle"))
                            pstats24[k]=data[i+1];
                        if(data[i].equals("Jumping"))
                            pstats25[k]=data[i+1];
                        if(data[i].equals("Strength"))
                            pstats26[k]=data[i+1];
                        if(data[i].equals("Aggression"))
                        {
                            pstats27[k]=data[i+1];
                            k++;
                        }
                    }
                }
            }
        }
    }
    //end of functions.
}