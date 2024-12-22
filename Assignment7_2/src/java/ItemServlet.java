import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class ItemServlet extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            String[] check=null,temp=null;
//            String x = request.getParameter("spmix");
//            if (x !=null)
//            {
//                
//            }
            HttpSession session = request.getSession();
            String screen =request.getParameter("screen");
            if (screen.equals("screen1"))
            {
                
                session.setAttribute("spmix", request.getParameter("txt_spmix"));
                session.setAttribute("mug", request.getParameter("txt_mugpulav"));
                session.setAttribute("fruit", request.getParameter("txt_fruitdish"));
                session.setAttribute("salad", request.getParameter("txt_saladbowl"));   
                check=request.getParameterValues("a");
                response.sendRedirect("Screen-2.html");
            }
            else if (screen.equals("screen2"))
            {
                
                session.setAttribute("cc", request.getParameter("txt_cc"));
                session.setAttribute("spr", request.getParameter("txt_sprite"));
                session.setAttribute("md", request.getParameter("txt_md"));
                session.setAttribute("maaza", request.getParameter("txt_maaza"));
                temp=request.getParameterValues("b");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Screen-3 Your Order</title>");            
            out.println("</head>");
            out.println("<body>");
            out.print("<table border='1' align='center'>");
            out.print("<tr> <th>Item</th><th>Quantity</th><th>Total Price(Rs.)</th>");
                if (Integer.parseInt(session.getAttribute("spmix").toString())!=0)
                {
                    out.print("<tr><td>Sprout Mix</td>");
                    out.print("<td>"+session.getAttribute("spmix")+"</td>");
                    out.print("<td>"+Integer.parseInt(session.getAttribute("spmix").toString())*60+"</td></tr>");
                }
                if (Integer.parseInt(session.getAttribute("mug").toString())!=0)
                {
                    out.print("<tr><td>Mug Pulav</td>");
                    out.print("<td>"+session.getAttribute("mug")+"</td>");
                    out.print("<td>"+Integer.parseInt(session.getAttribute("mug").toString())*80+"</td></tr>");
                }
                if (Integer.parseInt(session.getAttribute("fruit").toString())!=0)
                {
                    out.print("<tr><td>Fruit Dish</td>");
                    out.print("<td>"+session.getAttribute("fruit")+"</td>");
                    out.print("<td>"+Integer.parseInt(session.getAttribute("fruit").toString())*70+"</td></tr>");
                }
                if (Integer.parseInt(session.getAttribute("salad").toString())!=0)
                {
                    out.print("<tr><td>Salad Bowl</td>");
                    out.print("<td>"+session.getAttribute("salad")+"</td>");
                    out.print("<td>"+Integer.parseInt(session.getAttribute("salad").toString())*70+"</td></tr>");
                }
                if (Integer.parseInt(session.getAttribute("cc").toString())!=0)
                {
                    out.print("<tr><td>Coca Cola</td>");
                    out.print("<td>"+session.getAttribute("cc")+"</td>");
                    out.print("<td>"+Integer.parseInt(session.getAttribute("cc").toString())*100+"</td></tr>");
                }
                if (Integer.parseInt(session.getAttribute("spr").toString())!=0)
                {
                    out.print("<tr><td>Sprite</td>");
                    out.print("<td>"+session.getAttribute("spr")+"</td>");
                    out.print("<td>"+Integer.parseInt(session.getAttribute("spr").toString())*65+"</td></tr>");
                }
                if (Integer.parseInt(session.getAttribute("md").toString())!=0)
                {
                    out.print("<tr><td>Mountain Dew</td>");
                    out.print("<td>"+session.getAttribute("md")+"</td>");
                    out.print("<td>"+Integer.parseInt(session.getAttribute("md").toString())*50+"</td></tr>");
                }
                if (Integer.parseInt(session.getAttribute("maaza").toString())!=0)
                {
                    out.print("<tr><td>Maaza</td>");
                    out.print("<td>"+session.getAttribute("maaza")+"</td>");
                    out.print("<td>"+Integer.parseInt(session.getAttribute("maaza").toString())*10+"</td></tr>");
                }
           
            out.print("<tr><td></td>");
            out.print("<td></td>");
            out.print("<td><input align=\"center\" type=\"submit\" name=\"Place Order\" value=\"Place Order\"></td></tr>");
            out.print("</table>");
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
