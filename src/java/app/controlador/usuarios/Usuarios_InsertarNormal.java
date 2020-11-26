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
@WebServlet (name = "Usuarios_InsertarNormal", urlPatterns = {"/Usuarios_InsertarNormal"})
public class Usuarios_InsertarNormal extends HttpServlet {

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
        String usuario = "";
        String email = "";
        String ciudad = "";
        String rfc = "";
        String tipo = "";
        String pass = "";
        
        UsuariosBD aBD = new UsuariosBD();
        Usuarios a = new Usuarios();
        
//        clave = Integer.parseInt(request.getParameter("clave"));
        nombre = request.getParameter("nombre");
        usuario = request.getParameter("usuario");
        email = request.getParameter("email");
        ciudad = request.getParameter("ciudad");
        rfc = request.getParameter("rfc");
        tipo = request.getParameter("tipo");
        pass = request.getParameter("pass");
        
//        a.setClave(clave);
        a.setNombre(nombre);
        a.setUsuario(usuario);
        a.setEmail(email);
        a.setCiudad(ciudad);
        a.setRfc(rfc);
        a.setTipo(tipo);
        a.setPass(pass);
        
        try{
            aBD.abrir();
            int i = aBD.insertar(a);
            aBD.cerrar();
            
            if(i == 0){
                paginaRespuesta = "Usuarios_InsertarNormal.jsp";
                request.setAttribute("mensaje", "alert('Error en la insercion')");
            }else{
                paginaRespuesta = "Usuarios_InsertarNormal.jsp";
                request.setAttribute("mensaje", "alert('Insercion correcta!')");
            }
        }catch(ClassNotFoundException | SQLException ex){
            paginaRespuesta = "Usuarios_InsertarNormal.jsp";
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
