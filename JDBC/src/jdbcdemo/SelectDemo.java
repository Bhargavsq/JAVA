package jdbcdemo;

import java.sql.*;

public class SelectDemo {

    public static void main(String[] args) 
    {
        Connection cn;
        Statement st;        
        ResultSet rs;
        
        String dbURL="jdbc:mysql://localhost:3306/product_database";
        String username="root";
        String password="";
        String query;
               
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(dbURL, username, password);
            query="SELECT * FROM PRODUCT";
            st=cn.createStatement();
            
            rs = st.executeQuery(query);
           
            while(rs.next())
            {
                System.out.print(rs.getInt(1));
                System.out.print("\t\t"+rs.getString(2));
                System.out.print("\t\t"+rs.getInt(3));
                System.out.println("\t\t"+rs.getFloat(4));
            }
            
             cn.close();
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        

    }
    
}
