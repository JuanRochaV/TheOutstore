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
@WebServlet (name = "Clientes_InsertarNormal", urlPatterns = {"/Clientes_InsertarNormal"})
public class Clientes_InsertarNormal extends HttpServlet {

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
        String nombre = "";
        String email = "";
        String ciudad = "";
        String rfc = "";
        
        ClientesBD aBD = new ClientesBD();
        Clientes a = new Clientes();
        
//        clave = Integer.parseInt(request.getParameter("clave"));
        nombre = request.getParameter("nombre");
        email = request.getParameter("email");
        ciudad = request.getParameter("ciudad");
        rfc = request.getParameter("rfc");
        
//        a.setClave(clave);
        a.setNombre(nombre);
        a.setEmail(email);
        a.setCiudad(ciudad);
        a.setRfc(rfc);
        
        try{
            aBD.abrir();
            int i = aBD.insertar(a);
            aBD.cerrar();
            
            if(i == 0){
                paginaRespuesta = "Clientes_InsertarNormal.jsp";
                request.setAttribute("mensaje", "alert('Error en la insercion')");
            }else{
                paginaRespuesta = "Clientes_InsertarNormal.jsp";
                request.setAttribute("mensaje", "alert('Insercion correcta!')");
            }
        }catch(ClassNotFoundException | SQLException ex){
            paginaRespuesta = "Clientes_InsertarNormal.jsp";
            request.setAttribute("mensaje","alert('Error en la insercion')");
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
