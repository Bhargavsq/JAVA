package preparedstatement.demo;

import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) 
    {
        Connection cn;
        PreparedStatement ps;
        ResultSet rs;
        String query;
        
        String dbURL="jdbc:mysql://localhost:3306/product_database";
        String username="root";
        String password="";
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(dbURL, username, password);
            
            //query = "SELECT * FROM PRODUCT WHERE PRICE>= ?";  
            //query = "SELECT * FROM PRODUCT WHERE QUANTITY>= ? AND PRICE>= ?";  
            query = "INSERT INTO PRODUCT VALUES(?,?,?,?)";
            
            
            ps = cn.prepareStatement(query);
            
            ps.setInt(1,5089);
            ps.setString(2,"Webcam");
            ps.setInt(3,4);
            ps.setFloat(4,2200F);
            
            // rs =  ps.executeQuery(); 
            ps.executeUpdate();
            
            //while(rs.next())
              //  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getFloat(4));
            
        }
        catch(Exception e)
        {
                System.out.println(e.getMessage());    
        }
        

    }
    
}
