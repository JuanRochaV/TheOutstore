/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controlador.carrito;

import app.modelo.Carrito;
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
@WebServlet (name = "Carrito_Comprar", urlPatterns = {"/Carrito_Comprar"})
public class Carrito_Comprar extends HttpServlet {

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
        String id_producto;
        int cantidadC;
        int stock;
        int diferencia;
        
        Carrito a = new Carrito();
        
        VideojuegosBD vBD = new VideojuegosBD();
        Videojuegos v = new Videojuegos();
        
        id_producto = request.getParameter("id_producto");
        cantidadC = Integer.parseInt(request.getParameter("cantidad"));           
        stock = Integer.parseInt(request.getParameter("stock"));
        
        diferencia = stock-cantidadC;
        
        a.setId_producto(id_producto);
        
        v.setStock(diferencia);
        
        try{
            vBD.abrir();
            int i = vBD.actualizarStock(diferencia, id_producto);
            vBD.cerrar();
            
            if(i == 0){
                paginaRespuesta = "Carrito_opciones.jsp";
                request.setAttribute("mensaje", "alert('Error en la compra')");
            }else{
                paginaRespuesta = "Carrito_opciones.jsp";
                request.setAttribute("mensaje", "alert('Insercion compra!')");
            }
        }catch(ClassNotFoundException | SQLException ex){
            paginaRespuesta = "Carrito_opciones.jsp";
            request.setAttribute("mensaje","alert('Error en la compra')");
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
