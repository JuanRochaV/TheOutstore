/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controlador.clientes;

import app.modelo.Clientes;
import app.persistencia.ClientesBD;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juan_
 */
@WebServlet (name = "Clientes_Eliminar", urlPatterns = {"/Clientes_Eliminar"})
public class Clientes_Eliminar extends HttpServlet {

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
        String paginaRespuesta;
        int clave;
        String nombre;
        
        ClientesBD aBD = new ClientesBD();
        Clientes a = new Clientes();
        
        clave = Integer.parseInt(request.getParameter("clave"));
        nombre = request.getParameter("nombre");
        
        try{
            aBD.abrir();
            int i = aBD.eliminar(clave, nombre);
            aBD.cerrar();
            
            if(i == 0){
                paginaRespuesta = "Clientes_Eliminar.jsp";
                request.setAttribute("mensaje", "alert('Error en la eliminacion')");
            }else{
                paginaRespuesta = "Clientes_Eliminar.jsp";
                request.setAttribute("mensaje", "alert('Eliminacion correcta!')");
            }
        }catch(ClassNotFoundException | SQLException ex){
            paginaRespuesta = "Clientes_Eliminar.jsp";
            request.setAttribute("mensaje","alert('Error en la eliminacion')");
        }
        
        //Redireccionar a la pagina de respuesta
        RequestDispatcher dispatcher = request.getRequestDispatcher(paginaRespuesta);
        dispatcher.forward(request, response);
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
