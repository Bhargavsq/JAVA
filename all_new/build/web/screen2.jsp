<%-- 
    Document   : screen2
    Created on : 27-Nov-2023, 9:59:12 am
    Author     : aryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@page import="java.io.IOException"%> 
<%@page import="java.io.*"%> 
<%@page import="jakarta.servlet.*"%>
<%@page import="jakarta.servlet.http.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3 align="center">It's time to add skills Your Screen</h3>
        
        <form action="screen2.jsp" method="POST">
            <input type="hidden" name="screen" value="screen2">
            <table border="1" align='center'>
                
                <tbody>
                    <tr>
                        <td>Add Your Skills</td>
                        <td> <input type="checkbox" name="skills" value="java" /> Java
                            <input type="checkbox" name="skills" value=".net" /> .NET
                            <input type="checkbox" name="skills" value="mobile application" /> Mobile Application Development
                        </td>
                    </tr>
                    <tr>
                        <td>Reset</td>
                        <td> <input type="reset" value="Clear" /> </td>
                    </tr>
                    <tr>
                        <td>Submit</td>
                        <td> <input type="submit" value="Display" /> </td>
                    </tr>
                </tbody>
            </table>

            
        </form>
            
        <%
            String screen = request.getParameter("screen");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String programme = request.getParameter("programme");
            
            String[] skills = request.getParameterValues("skills");                  
            
            if(screen.equals("screen1")){
                
                session.setAttribute("fname", fname);
                session.setAttribute("lname", lname);
                session.setAttribute("programme", programme);
            }
            
            
            if(screen.equals("screen2")){
                String temp = "";
                for(String s : skills){
                    temp = temp + " " + s;
                }
                session.setAttribute("temp", temp);

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet view_servlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h3 align='center'>First Name: " + session.getAttribute("fname")+ "</h3>");
                out.println("<h3 align='center'>Last Name: " + session.getAttribute("lname")+ "</h3>");
                out.println("<h3 align='center'>Programme : " + session.getAttribute("programme")+ "</h3>");
                out.println("<h3 align='center'>Skills: " + session.getAttribute("temp")+ "</h3>");
                out.println("</body>");
                out.println("</html>");
            }
        
        %>
    </body>
</html>



        
