<%-- 
    Document   : update
    Created on : 27-Nov-2023, 3:57:15 pm
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
            
            <table border="1">
                <tbody>
                    <tr>
                        <td>Player ID</td>
                        <td> <input type="text" name="player_id" value="" /> </td>
                    </tr>
                    <tr>
                        <td>Player Name</td>
                        <td> <input type="text" name="player_name" value="" /> </td>
                    </tr>
                    <tr>
                        <td>Player Status</td>
                        <td>
                            <input type="radio" name="status" value="Married" />Married
                            <input type="radio" name="status" value="Single" />Single
                        </td>
                    </tr>
                    <tr>
                        <td>Clear</td>
                        <td> <input type="submit" value="Clear" /> </td>
                    </tr>
                    <tr>
                        <td>Update</td>
                        <td> <input type="submit" value="submit" /> </td>
                    </tr>
                </tbody>
            </table>
        </form>
        
        
        <c:if test="${pageContext.request.method=='POST'}">
                <c:catch var="exception">
                    <sql:update dataSource="${ds}" var="i">
                        UPDATE player_profile SET player_name = ?, is_married = ? WHERE player_id = ?;
                        <sql:param value="${param.player_name}"/>
                        <sql:param value="${param.status}"/>
                        <sql:param value="${param.player_id}"/>    
                    </sql:update>
                    
                        <c:if test="${i>0}">
                            <font size="7" color="darkgreen">Update Success...</font>
                        </c:if>
                        
                </c:catch>
                            <c:if test="${exception!=null}">
                                <font size="7" color="red">Something went wrong..</font>
                            </c:if>
                
            </c:if>
        
        <p align="center">
            <a href="insert.jsp">Click to Insert Data</a>
            </p>
            
            <p align="center">
            <a href="index.jsp">Click to View Data</a>
            </p>
            
            <p align="center">
            <a href="delete.jsp">Click to Delete Data</a>
            </p>
    </body>
</html>
