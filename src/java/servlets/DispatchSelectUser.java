/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paco
 */
public class DispatchSelectUser extends HttpServlet {

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
            
            
             RequestDispatcher rd = null;
         ServletContext contexto=getServletContext();
            String selec=request.getParameter("selec");
       
       switch(selec){
           
           case "1": 
               
               rd=contexto.getRequestDispatcher("/modificarUsuario.jsp");
                 rd.forward(request, response);
               
               break;
               
           case "2":
               
                rd=contexto.getRequestDispatcher("/modificarClave.jsp");
                rd.forward(request, response);
               
               break;
               
               
          case "3":
               
                rd=contexto.getRequestDispatcher("/eliminarCuenta");
                rd.forward(request, response);
               
               break;
               
          case "4":
              
              rd=contexto.getRequestDispatcher("/hacerOperacion.jsp");
                rd.forward(request, response);
              
              break;
              
              
          case "5":
              
              rd=contexto.getRequestDispatcher("/VerOperacionesUsuario");
                rd.forward(request, response);
              
              break;
              
              
         case "6":
              
              rd=contexto.getRequestDispatcher("/VerFechaLogin");
                rd.forward(request, response);
              
              break;
              
              
        case "7":
              
              rd=contexto.getRequestDispatcher("/VerMiRanking");
                rd.forward(request, response);
              
              break;

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
