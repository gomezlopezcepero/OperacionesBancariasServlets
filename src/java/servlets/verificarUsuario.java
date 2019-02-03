/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.OperacionesBancariasEJB;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.CuentasBancarias;
import pojo.Propietarios;

/**
 *
 * @author Paco
 */
@WebServlet(name = "verificarUsuario", urlPatterns = {"/verificarUsuario"})
public class verificarUsuario extends HttpServlet {

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
            String dni = request.getParameter("dni");
            String numSecreto = request.getParameter("numSecreto");

            DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now2 = LocalDateTime.now();
           String fecha=  dt.format(now2).toString();
            
            
            if (bancoEJB.verificarExistencia(dni, numSecreto, fecha)) {
               
                RequestDispatcher rd = null;
                ServletContext contexto=getServletContext();
                
                HttpSession sesion = request.getSession();
                sesion.setAttribute("dni", dni);
                sesion.setAttribute("fecha", fecha);
                
                rd=contexto.getRequestDispatcher("/usuario.jsp");
                 rd.forward(request, response);
                
            } else {
                out.println("El usuario o la contraseña es incorrecta");
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
