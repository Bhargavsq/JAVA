package jdbcdemo;

import java.sql.*;

public class UpdateDemo {

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
         
            query="UPDATE PRODUCT SET QUANTITY = 12 WHERE PRODUCT_NAME='Headphone'";
         
            st=cn.createStatement();
            
            int n = st.executeUpdate(query);
            System.out.println(n+" record(s) affected.");
            
            cn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
         
        

    }
    
}
