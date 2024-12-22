<%-- 
    Document   : index
    Created on : 27-Nov-2023, 3:14:37 pm
    Author     : aryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3 align="center">Here is Sports Data..</h3>
        
        <sql:setDataSource var="ds"
                           driver="com.mysql.cj.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/football"
                           user="root"
                           password=""/>
        
        <sql:query dataSource="${ds}" var="rs">
            SELECT * FROM player_profile;
        </sql:query>
            
            <table border="1" align="center">
                    <tbody>
                        
                        <tr>
                            <td>Player Id </td>
                            <td>Player Name </td>
                            <td>Player Status </td>
                        </tr>
                        
            <c:forEach var="p" items="${rs.rows}">
                        <tr>
                            <td>${p.player_id}</td>
                            <td>${p.player_name}</td>
                            <td>${p.is_married}</td>
                        </tr>                
                <br>
            </c:forEach>
                      
                    </tbody>
                </table>

            <p align="center">
            <a href="insert.jsp">Click to Insert Data</a>
            </p>
            
            <p align="center">
            <a href="update.jsp">Click to Update Data</a>
            </p>
            
            
            <p align="center">
            <a href="delete.jsp">Click to Delete Data</a>
            </p>
    </body>
</html>
