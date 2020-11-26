/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controlador.productos;

import app.modelo.Videojuegos;
import app.persistencia.VideojuegosBD;
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
@WebServlet (name = "Productos_Buscar", urlPatterns = {"/Productos_Buscar"})
public class Productos_Buscar extends HttpServlet {

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
        
        VideojuegosBD aBD = new VideojuegosBD();
        Videojuegos a = new Videojuegos();
        
        clave = Integer.parseInt(request.getParameter("clave"));
        nombre = request.getParameter("nombre");
        
        try{
            aBD.abrir();
            a = aBD.buscar(clave, nombre);
            aBD.cerrar();
            
            if(a == null){
                paginaRespuesta = "Productos_Buscar.jsp";
                request.setAttribute("mensaje", "alert('Error en la busqueda')");
            }else{
                paginaRespuesta = "Productos_Buscar.jsp";
                request.setAttribute("mensaje", "alert('Busqueda finalizada!')");
                request.setAttribute("clave", a.getClave());
                request.setAttribute("nombre", a.getNombre());
                request.setAttribute("precioUnitario", a.getPrecioUnitario());
                request.setAttribute("id_proveedor", a.getId_proveedor());
                request.setAttribute("costo", a.getCosto());
                request.setAttribute("nombre_proveedor", a.getNombre_proveedor());
                request.setAttribute("stock", a.getStock());
            }
        }catch(ClassNotFoundException | SQLException ex){
            paginaRespuesta = "Productos_Buscar.jsp";
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
