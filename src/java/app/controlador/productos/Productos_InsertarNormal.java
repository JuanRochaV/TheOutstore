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
@WebServlet (name = "Productos_InsertarNormal", urlPatterns = {"/Productos_InsertarNormal"})
public class Productos_InsertarNormal extends HttpServlet {

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
        int precioUnitario;
        int id_proveedor;
        int costo;
        String nombre_proveedor = "";
        int stock;
        
        VideojuegosBD aBD = new VideojuegosBD();
        Videojuegos a = new Videojuegos();
        
//        clave = Integer.parseInt(request.getParameter("clave"));
        nombre = request.getParameter("nombre");
        precioUnitario = Integer.parseInt(request.getParameter("precioUnitario"));
        id_proveedor = Integer.parseInt(request.getParameter("id_proveedor"));
        costo = Integer.parseInt(request.getParameter("costo"));
        nombre_proveedor = request.getParameter("nombre_proveedor");
        stock = Integer.parseInt(request.getParameter("stock"));
        
//        a.setClave(clave);
        a.setNombre(nombre);
        a.setPrecioUnitario(precioUnitario);
        a.setId_proveedor(id_proveedor);
        a.setCosto(costo);
        a.setNombre_proveedor(nombre_proveedor);
        a.setStock(stock);
        
        try{
            aBD.abrir();
            int i = aBD.insertar(a);
            aBD.cerrar();
            
            if(i == 0){
                paginaRespuesta = "Productos_InsertarNormal.jsp";
                request.setAttribute("mensaje", "alert('Error en la insercion')");
            }else{
                paginaRespuesta = "Productos_InsertarNormal.jsp";
                request.setAttribute("mensaje", "alert('Insercion correcta!')");
            }
        }catch(ClassNotFoundException | SQLException ex){
            paginaRespuesta = "Productos_InsertarNormal.jsp";
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
