package nrx07;
import java.sql.*;
public class NRX07 
{
    public static void main(String[] args) 
    {
        System.out.println("\"Hello\"");
        Connection con = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini1","root","Nrx07CR7.");
             stmt=con.createStatement();
            String sql = "INSERT INTO atn VALUES (7, 'Suyog', 'P')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO atn VALUES (8, 'Kash', 'P')";
            stmt.executeUpdate(sql);
        }
        catch(ClassNotFoundException | SQLException e){}
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini1","root","Nrx07CR7.");
             stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from atn");
            while(rs.next())
                System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3) );
        }
        catch(ClassNotFoundException | SQLException e){}
    }
}
