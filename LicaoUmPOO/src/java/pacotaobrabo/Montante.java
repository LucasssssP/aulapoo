/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacotaobrabo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LUCASDOSSANTOSPACHEC
 */
@WebServlet(name = "Montante", urlPatterns = {"/montante.html"})
public class Montante extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Página Montante</title>");
            out.println("<link rel=\"icon\" href=\"css/java.png\" type=\"ico\">");
            /*GOOGLE FONTS*/
            out.println("<link href=\"https://fonts.googleapis.com/css?family=Montserrat&display=swap\" rel=\"stylesheet\">");
            /*MAIN CSS*/
            out.println("<link rel=\"stylesheet\" href=\"./css/main.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<header>\n"
                    + "        <di class=\"navbar\">\n"
                    + "            <div class=\"menu\">\n"
                    + "                <a href=\"home.html\">Home</a>\n"
                    + "                <a href=\"juros-simples.html\">Jusros Simples</a>\n"
                    + "                <a href=\"juros-composto\">Juros composto</a>\n"
                    + "            </div>\n"
                    + "        </di>\n"
                    + "    </header>");
            out.println("<h1>Montante:</h1>");
            double v1 = Double.parseDouble(request.getParameter("capital"));
            double v2 = Double.parseDouble(request.getParameter("taxaj"));
            double v3 = Double.parseDouble(request.getParameter("periodo"));
            double r = v1 * v2 * v3;
            out.println("<h2>" + v1 + " X " + v2 + " X " + v3 + " = " + r);
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
