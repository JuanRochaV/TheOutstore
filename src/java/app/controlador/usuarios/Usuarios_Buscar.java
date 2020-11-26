/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controlador.usuarios;

import app.modelo.Usuarios;
import app.persistencia.UsuariosBD;
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
@WebServlet (name = "Usuarios_Buscar", urlPatterns = {"/Usuarios_Buscar"})
public class Usuarios_Buscar extends HttpServlet {

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
        
        UsuariosBD aBD = new UsuariosBD();
        Usuarios a = new Usuarios();
        
        clave = Integer.parseInt(request.getParameter("clave"));
        nombre = request.getParameter("nombre");
        
        try{
            aBD.abrir();
            a = aBD.buscar(clave, nombre);
            aBD.cerrar();
            
            if(a == null){
                paginaRespuesta = "Usuarios_Buscar.jsp";
                request.setAttribute("mensaje", "alert('Error en la busqueda')");
            }else{
                paginaRespuesta = "Usuarios_Buscar.jsp";
                request.setAttribute("mensaje", "alert('Busqueda finalizada!')");
                request.setAttribute("clave", a.getClave());
                request.setAttribute("nombre", a.getNombre());
                request.setAttribute("usuario", a.getUsuario());
                request.setAttribute("email", a.getEmail());
                request.setAttribute("ciudad", a.getCiudad());
                request.setAttribute("rfc", a.getRfc());
                request.setAttribute("tipo", a.getTipo());
            }
        }catch(ClassNotFoundException | SQLException ex){
            paginaRespuesta = "Usuarios_Buscar.jsp";
            request.setAttribute("mensaje","alert('Error en la busqueda')");
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
