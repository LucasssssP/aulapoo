/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacotaobrabo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author giova
 */
@WebServlet(name = "CalculaComposto", urlPatterns = {"/calcula-composto.html"})
public class CalculaComposto extends HttpServlet {

    double montante;
    DecimalFormat formatarValor = new DecimalFormat("#,###.00");

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
            out.println("<title>Resultado</title>");
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
                    + "                <a href=\"juros-composto.html\">Juros composto</a>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </header>");
            out.println("<main>\n"
                    + "<div class=\"result\">"
                    + "<h1>Resultado Juros Composto</h1>"
                    + "<div class=\"borda\"></div>"
                    + "    <div class=\"table-box\">\n"
                    + "        <div class=\"table-row table-head\">\n"
                    + "            <div class=\"table-cell\">\n"
                    + "                <p>Periodo</p>\n"
                    + "            </div>\n"
                    + "            <div class=\"table-cell\">\n"
                    + "                <p>Capital</p>\n"
                    + "            </div>\n"
                    + "            <div class=\"table-cell\">\n"
                    + "                <p>Montante</p>\n"
                    + "            </div>\n"
                    + "        </div>\n");

            int taxa = Integer.parseInt(request.getParameter("taxa"));
            int valor = Integer.parseInt(request.getParameter("capital"));
            int periodo = Integer.parseInt(request.getParameter("periodo"));

            calcularMontante(valor, taxa);

            for (int i = 1; i <= periodo; i++) {
                out.println("<div class=\"table-row\">\n"
                        + "            <div class=\"table-cell\">\n"
                        + "                <p>" + i + "</p>\n"
                        + "            </div>\n"
                        + "            <div class=\"table-cell\">\n"
                        + "                <p>" + formatarValor.format(calcularJurosComposto(valor)) + "</p>\n"
                        + "            </div>\n"
                        + "            <div class=\"table-cell\">\n"
                        + "                <p>" + formatarValor.format(calcularMontante(calcularJurosComposto(valor), taxa)) + "</p>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "    </div>"
                        + "</div>"
                        + "    </main>");

            }

        }
    }

    public double calcularJurosComposto(double capital) {

        double juros = montante - capital;

        return capital + juros;

    }

    public double calcularMontante(double capital, double taxa) {

        taxa = taxa / 100;

        montante = capital * (1 + taxa);

        return montante;

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
