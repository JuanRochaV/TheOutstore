package app.controlador.proveedores;

import app.modelo.Proveedores;
import app.persistencia.ProveedoresBD;
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
@WebServlet (name = "Proveedores_Actualizar", urlPatterns = {"/Proveedores_Actualizar"})
public class Proveedores_Actualizar extends HttpServlet {

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
        String direccion = "";
        String email = "";
        String paginaWeb = "";
        
        ProveedoresBD aBD = new ProveedoresBD();
        Proveedores a = new Proveedores();
        
        clave = Integer.parseInt(request.getParameter("clave"));
        nombre = request.getParameter("nombre");
        direccion = request.getParameter("direccion");
        email = request.getParameter("email");
        paginaWeb = request.getParameter("paginaWeb");
        
        a.setClave(clave);
        a.setNombre(nombre);
        a.setDireccion(direccion);
        a.setEmail(email);
        a.setPaginaWeb(paginaWeb);
        
        try{
            aBD.abrir();
            int i = aBD.modificar(a);
            aBD.cerrar();
            
            if(i == 0){
                paginaRespuesta = "Proveedores_Actualizar.jsp";
                request.setAttribute("mensaje", "alert('Error al modificar')");
            }else{
                paginaRespuesta = "Proveedores_Actualizar.jsp";
                request.setAttribute("mensaje", "alert('Actualizacion correcta!')");
            }
        }catch(ClassNotFoundException | SQLException ex){
            paginaRespuesta = "Proveedores_Actualizar.jsp";
            request.setAttribute("mensaje","alert('Error al modificar')");
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
