import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class DetailServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            HttpSession session =request.getSession();
            String screen =request.getParameter("screen");
           // String firname=null,lastnm = null,email = null,mobno = null,userid = null,passwd = null;
            if (screen.equals("screen1"))
            {
                session.setAttribute("firname", request.getParameter("fname"));
                session.setAttribute("lastnm", request.getParameter("lname"));
                
                
                
                response.sendRedirect("screen2.html");
            }
            else if (screen.equals("screen2"))
            {
                session.setAttribute("email", request.getParameter("email"));
                session.setAttribute("mobno", request.getParameter("mobno"));
                
                response.sendRedirect("screen3.html");
            }
            else 
            {
                session.setAttribute("userid", request.getParameter("userid"));
                session.setAttribute("passwd", request.getParameter("passwd"));
                
               // response.sendRedirect("DetailServlet");
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DetailServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'>FirstName:   "+session.getAttribute("firname")+"</h1>");
            out.println("<h1 align='center'>LastName:   "+session.getAttribute("lastnm")+"</h1>");
            out.println("<h1 align='center'>Email:   "+session.getAttribute("email")+"</h1>");
            out.println("<h1 align='center'>Mobile Number:   "+session.getAttribute("mobno")+"</h1>");
            out.println("<h1 align='center'>UserID:   "+session.getAttribute("userid")+"</h1>");
            out.println("<h1 align='center'>Password:    "+session.getAttribute("passwd")+"</h1>");
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
