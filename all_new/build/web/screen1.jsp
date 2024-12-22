<%-- 
    Document   : screen1
    Created on : 27-Nov-2023, 9:55:27 am
    Author     : aryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@page import="java.io.IOException"%> 
<%@page import="java.io.*"%> 
<%@page import="jakarta.servlet.*"%>
<%@page import="jakarta.servlet.http.*"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h3 align="center">Welcome to Student Registration form using Java Servlet (Set1 - Que1)</h3> 
        <form action="screen2.jsp" method="POST">
            <input type="hidden" name="screen" value="screen1">
            <table border="1" align="center">
                
                <tbody>
                    <tr>
                        <td>Firstname:</td>
                        <td> <input type="text" name="fname" value="" /> </td>
                    </tr>
                    <tr>
                        <td>Lastname</td>
                        <td> <input type="text" name="lname" value="" /> </td>
                    </tr>
                    <tr>
                        <td>Programme</td>
                        <td> <input type="radio" name="programme" value="mca"/> MCA
                            <input type="radio" name="programme" value="msit"/> MSc(IT)
                        </td>
                    </tr>
                    <tr>
                        <td>Reset</td>
                        <td> <input type="reset" value="Clear" /> </td>
                    </tr>
                    <tr>
                        <td>Next</td>
                        <td> <input type="submit" value="Next" /> </td>
                    </tr>
                </tbody>
            </table>

            
        </form>
        
    </body>
</html>
