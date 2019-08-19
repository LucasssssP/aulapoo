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
 * @author LUCASDOSSANTOSPACHEC
 */
@WebServlet(name = "Montante", urlPatterns = {"/montante.html"})
public class Montante extends HttpServlet {
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
            out.println("<title>Página Montante</title>");
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
                    + "                <a href=\"juros-simples.html\">Juros Simples</a>\n"
                    + "                <a href=\"juros-composto.html\">Juros composto</a>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </header>");
            out.println("<main>\n"
                    + "<div class=\"result\">"
                    + "<h1>Resultado Juros Simples</h1>"
                    + "<div class=\"borda\"></div>"
                    + "    <div class=\"table-box\">\n"
                    + "        <div class=\"table-row table-head\">\n"
                    + "            <div class=\"table-cell\">\n"
                    + "                <p>Periodo(mês)</p>\n"
                    + "            </div>\n"
                    + "            <div class=\"table-cell\">\n"
                    + "                <p>Capital</p>\n"
                    + "            </div>\n"
                    + "            <div class=\"table-cell\">\n"
                    + "                <p>Montante</p>\n"
                    + "            </div>\n"
                    + "        </div>\n");
            double capital = Double.parseDouble(request.getParameter("capital"));
            double taxa = Double.parseDouble(request.getParameter("taxaj"));
            int periodo = Integer.parseInt(request.getParameter("periodo"));
            out.println("<div class=\"table-row\">\n"
                    + "            <div class=\"table-cell\">\n"
                    + "                <p>" + periodo + "</p>\n"
                    + "            </div>\n"
                    + "            <div class=\"table-cell\">\n"
                    + "                <p>" + formatarValor.format(capital) + "</p>\n"
                    + "            </div>\n"
                    + "            <div class=\"table-cell\">\n"
                    + "                <p>" + formatarValor.format(CalculaMontante(capital, taxa, periodo)) + "</p>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </div>"
                    + "</div>"
                    + "    </main>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public double CalculaMontante(double capital, double taxa, double periodo) {

        taxa = taxa / 100;

        double juros = (capital / periodo) * taxa; //parcela x taxa = juros p/ mes

        return (juros * periodo) + capital; //juros x periodo = todos os juros (+ capital = montante)

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
