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
 * @author giova
 */
@WebServlet(name = "JurosComposto", urlPatterns = {"/juros-composto.html"})
public class JurosComposto extends HttpServlet {

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
            out.println("<title>Juros Composto</title>");
            out.println("<link rel=\"icon\" href=\"css/java.png\" type=\"ico\">");
            /*GOOGLE FONTS*/
            out.println("<link href=\"https://fonts.googleapis.com/css?family=Montserrat&display=swap\" rel=\"stylesheet\">");
            /*MAIN CSS*/
            out.println("<link rel=\"stylesheet\" href=\"./css/main.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<header>\n"
                    + "        <div class=\"navbar\">\n"
                    + "            <div class=\"menu\">\n"
                    + "                <a href=\"home.html\">Home</a>\n"
                    + "                <a href=\"juros-simples.html\">Jusros Simples</a>\n"
                    + "                <a href=\"juros-composto.hmtl\">Juros composto</a>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </header>");
            out.println("<main>\n"
                    + "        <div class=\"formulario\">\n"
                    + "            <h1>Juros Composto</h1>\n"
                    + "            <div class=\"borda\"></div>\n"
                    + "            <form action=\"calcula-composto.html\" method=\"GET\">\n"
                    + "                <h4>Capital Inicial:</h4>\n"
                    + "                <input type=\"text\" name=\"capital\"/>\n"
                    + "                <h4>Taxa de juros:</h4>\n"
                    + "                <input type=\"text\" name=\"taxa\"/>\n"
                    + "                <h4>Quantidade de meses:</h4>\n"
                    + "                <input type=\"text\" name=\"periodo\"/><br>\n"
                    + "                <input type=\"submit\" value=\"Calcular\"/>\n"
                    + "            </form>\n"
                    + "        </div>\n"
                    + "    </main>");
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
