/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;



public class my_Servlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           HttpSession session =request.getSession();
           String [] check =request.getParameterValues("a");
           String temp ="";
           String screen = request.getParameter("screen");
           String fname=request.getParameter("fname");
           String lname=request.getParameter("lname");
           String prog = request.getParameter("b");
           if(screen.equals("screen1"))
           {
            session.setAttribute("firstname",fname);
            session.setAttribute("lastname",lname);
            session.setAttribute("prog",prog);
       
            response.sendRedirect("second.html");
           }  
            if(screen.equals("screen2")) 
           {   
            for(String s:check){
            temp+=s;
            }
            
            session.setAttribute("temp",temp);
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet my_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1 align='center'> firstname: "+session.getAttribute("firstname") + "</h1>");
            out.println("<h1 align='center'> lastname: "+session.getAttribute("lastname") + "</h1>");
            out.println("<h1 align='center'> program: "+session.getAttribute("prog") + "</h1>");
            
            out.println("<h1 align='center'> skills: "+session.getAttribute("temp") + "</h1>");
           
            out.println("</body>");
            out.println("</html>");
   
            
           }      
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
