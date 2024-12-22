<%-- 
    Document   : insert
    Created on : 27-Nov-2023, 3:33:11 pm
    Author     : aryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page Insert Data</title>
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
                        <td>Enter Player ID</td>
                        <td> <input type="text" name="player_id" value="" /> </td>
                    </tr>
                    <tr>
                        <td>Enter Player Name</td>
                        <td> <input type="text" name="player_name" value="" /> </td>
                    </tr>
                    <tr>
                        <td>Enter Player Status</td>
                        <td>
                            <input type="radio" name="status" value="Married" />Married
                            <input type="radio" name="status" value="Single" />Single
                        </td>
                    </tr>
                    <tr>
                        <td>Reset</td>
                        <td> <input type="reset" value="Clear" /> </td>
                    </tr>
                    <tr>
                        <td>Submit</td>
                        <td> <input type="submit" value="Submit" /> </td>
                    </tr>
                </tbody>
            </table>
        </form>
                    
        <c:if test="${pageContext.request.method=='POST'}">
            <c:catch var="exception">
                <sql:update dataSource="${ds}" var="i">
                    INSERT INTO player_profile (player_id, player_name, is_married) VALUES (?, ?, ?)
                    <sql:param value="${param.player_id}"/>
                    <sql:param value="${param.player_name}"/>
                    <sql:param value="${param.status}"/>
                </sql:update>
               
                    <c:if test="${i>0}">
                        <font size="5" color="green">Data Insert Success </font>
                    </c:if>
            </c:catch>
                        
                        <c:if test="${exception!=null}">
                            <font size="5" color="red">
                                <c:out value="Something went wrong.."></c:out>
                            </font>         
                        </c:if>
        </c:if>
        
                            <p align="center">
            <a href="index.jsp">Click to View Data</a>
            </p>
            
            <p align="center">
            <a href="update.jsp">Click to Update Data</a>
            </p>
                   
            <p align="center">
            <a href="delete.jsp">Click to Delete Data</a>
            </p>
    </body>
    
</html>
