/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.OperacionesBancariasEJB;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.CuentasBancarias;
import pojo.Propietarios;

/**
 *
 * @author Paco
 */

@WebServlet(name = "insertarCuenta", urlPatterns = {"/insertarCuenta"})
public class insertarCuenta extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertarActividad</title>");
            out.println("</head>");
            out.println("<body>");
            // Recogemos los datos del formulario
            String numCuenta = request.getParameter("numCuenta");
            String dni = request.getParameter("dni");
            String usuario = request.getParameter("usuario");
            String numSecreto = request.getParameter("numSecreto");
            String nombre = request.getParameter("nombre");
            String primerApellido = request.getParameter("primerApellido");
            String segundoApellido = request.getParameter("segundoApellido");

            CuentasBancarias a = new CuentasBancarias(numCuenta, usuario, 0, dni);
            Propietarios b = new Propietarios(dni, usuario, nombre, primerApellido, segundoApellido, numSecreto);
            if (bancoEJB.insertarCuenta(a, b)) {
                out.println("La cuenta ha sido dado de alta.");
            } else {
                out.println("Ya existe una actividad con ese nombre.");
            }
            out.println("<form action=\"index.jsp\" method=\"POST\">"
                    + "Volver a la pagina inicial"
                    + "<input type=\"submit\" name=\"volver\" value=\"Volver\" />"
                    + "</form>");
            out.println("</body>");
            out.println("</html>");
            
        }catch(Exception ex){
            System.out.println("MtException : " + ex.getMessage());
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
