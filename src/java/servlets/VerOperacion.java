/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.OperacionesBancariasEJB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Operaciones;

/**
 *
 * @author Paco
 */
@WebServlet(name = "VerOperacion", urlPatterns = {"/VerOperacion"})
public class VerOperacion extends HttpServlet {

    
    @EJB
    OperacionesBancariasEJB bancoEJB;
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
            
            String id = request.getParameter("id");
            
            int idI = Integer.parseInt(id);
            
            Operaciones l = bancoEJB.verOperacion(idI);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>\n" +
"            \n" +
"            table{\n" +
"                border:1px solid black;\n" +
"            }\n" +
"            \n" +
"            td{\n" +
"                border:1px solid black;\n" +
"                background-color: beige\n" +
"            }\n" +
"            \n" +
"            th{\n" +
"                border:1px solid black;\n" +
"                background-color: black;\n" +
"                color: white;\n" +
"            }\n" +
"            \n" +
"        </style>");
            out.println("<title>Servlet ServletActivitat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Operación bancaria con ID "+id+"</h1>");
            out.println("<table>\n" +
"            <thead>\n" +
"                <tr>\n" +
"                    <th>#</th>\n" +
"                    <th>NumCuenta</th>\n" +
"                    <th>Fecha</th>\n" +
"                    <th>Tipo</th>\n" +
"                    <th>Cantidad</th>\n" +
"                </tr>\n" +
"            </thead>\n" +
"            <tbody>");
            
                out.println("<tr>");
                out.println("<td>"+l.getIDOperacion()+"</td>\n");
                out.println("<td>"+l.getNumCuenta()+"</td>\n");
                out.println("<td>"+l.getFechahora()+"</td>\n");
                out.println("<td>"+l.getTipoOperacion()+"</td>\n");
                out.println("<td>"+l.getCantidad()+"</td>\n");
                out.println("</tr>");
            
out.println("</tbody>\n" +
"        </table>");
            

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
