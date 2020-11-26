/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controlador;

//import app.modelo.Persona;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author juan_
 */
@WebServlet(name = "MyLogin", urlPatterns = {"/MyLogin"})
public class MyLogin extends HttpServlet {

    int usuario;

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

        String paginaRespuesta = "index.jsp";
        UsuariosBD uBD = new UsuariosBD();
        Usuarios a = new Usuarios();

        String user, password, mensaje;
        boolean estado = false;
        user = request.getParameter("userin");
        password = request.getParameter("passwordin");

        try {
            uBD.abrir();
            estado = uBD.buscarLogin(password, user);
            a = uBD.regresarBusqueda(password, user);
            
            HttpSession session=request.getSession();  

            if ((estado == true) && (a.getTipo().equalsIgnoreCase("Administrador"))) {
                session.setAttribute("id",a.getClave());
                session.setAttribute("name",a.getNombre());
                session.setAttribute("user",a.getUsuario());
                session.setAttribute("type",a.getTipo());
                paginaRespuesta = "Menu_opciones.jsp";
            }  else if ((estado == true) && (a.getTipo().equalsIgnoreCase("Normal"))) {      
                session.setAttribute("id",a.getClave());
                session.setAttribute("name",a.getNombre());
                session.setAttribute("user",a.getUsuario());
                session.setAttribute("type",a.getTipo());
                paginaRespuesta = "Menu_opcionesNormal.jsp";
            }  else {
                paginaRespuesta = "index.jsp";
                request.setAttribute("mensaje", "alert('Usuario o contraseña incorrectos')");
            }
             
        } catch (ClassNotFoundException | SQLException ex) {
            paginaRespuesta = "index.jsp";
            request.setAttribute("mensaje", "alert('Error en la busqueda')");
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
