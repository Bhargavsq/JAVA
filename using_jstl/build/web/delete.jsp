<%-- 
    Document   : delete
    Created on : 27-Nov-2023, 4:18:14 pm
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
       
        <sql:setDataSource var="ds"
                           driver="com.mysql.cj.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/football"
                           user="root"
                           password=""/>
        
        <form method="POST">
            
            <table border="1" align="center">
                <tbody>
                    <tr>
                        <td>Player ID</td>
                        <td> <input type="text" name="player_id" value="" /> </td>
                    </tr>
                    <tr>
                        <td>Clear</td>
                        <td> <input type="submit" value="Clear" /> </td>
                    </tr>
                    <tr>
                        <td>Submit</td>
                        <td> <input type="submit" value="submit" /> </td>
                    </tr>
                </tbody>
            </table>
        </form>
        
        <c:if test="${pageContext.request.method=='POST'}">
            
            <c:catch var="exception">
                
                <sql:update dataSource="${ds}" var="i">
                DELETE FROM player_profile WHERE player_id = ?
                <sql:param value="${param.player_id}"/>
                </sql:update>
                
                <c:if test="${i>0}">
                    <font size="7" color="lightblue">Delete Success</font>
                </c:if>
                
                
            </c:catch>
                    
                    <c:if test="${exception!=null}">
                        
                        <font size="7" color="coral">Something went wrong</font>
                    </c:if>
            
        </c:if>
                        
                        
                      
                    
                
            
               
                       <p align="center">
            <a href="insert.jsp">Click to Insert Data</a>
            </p>
            
            <p align="center">
            <a href="index.jsp">Click to View Data</a>
            </p>
            
            <p align="center">
            <a href="update.jsp">Click to Update Data</a>
            </p>
        
    </body>
</html>
