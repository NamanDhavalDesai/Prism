package nrx07;
import java.util.*;
import java.sql.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class NRX07 
{
    static int j=-1;
    static String[] ratings=new String [200000];
    static String[] positions=new String [200000];
    static String[] names=new String [200000];
    static String[] clubs=new String [200000];
    static String[] leagues=new String [200000];
    static String[] nations=new String [200000];
    static String[] skillboosts=new String [200000];
    static String[] stats1=new String [200000];
    static String[] stats2=new String [200000];
    static String[] stats3=new String [200000];
    static String[] stats4=new String [200000];
    static String[] stats5=new String [200000];
    static String[] stats6=new String [200000];
    public static void main(String[] args) 
    {
        Scanner ob=new Scanner (System.in);
        System.out.println("Enter the length");
        int len=ob.nextInt();
        get(len);
        print();
    }
    public static void get(int len)
    {
        for(int i =0;i<=len;i++)
        {
            String userlink="https://fifarenderz.com/20/players?page="+i+"&scope=DESC&filter=rating&bigcards=false";
            getdata(userlink);
            System.out.print(i+" ");
            System.out.println(" ");
        }
    }
    public static void print()
    {
        for(int i=0;i<j+1;i++)
            System.out.println((i+1)+"\t\t"+ratings[i]+"\t\t"+positions[i]+"\t\t"+names[i]+"\t\t"+clubs[i]+"\t\t"+leagues[i]+"\t\t"+nations[i]+"\t\t"+skillboosts[i]+"\t\t"+stats1[i]+"\t\t"+stats2[i]+"\t\t"+stats3[i]+"\t\t"+stats4[i]+"\t\t"+stats5[i]+"\t\t"+stats6[i]);
        System.out.println(j+1);
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
}
