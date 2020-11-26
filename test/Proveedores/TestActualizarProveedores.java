/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proveedores;

import app.modelo.Proveedores;
import app.persistencia.ProveedoresBD;
import java.sql.SQLException;

/**
 *
 * @author Juan Rocha
 */
public class TestActualizarProveedores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Proveedores a = new Proveedores();
        ProveedoresBD aBD = new ProveedoresBD();
        int estado = 0;

        a.setClave(1);
        a.setNombre("Sony");
        a.setDireccion("New York");
        a.setEmail("Sony@sony.com");
        a.setPaginaWeb("www.sonyNew.com");

        try {
            aBD.abrir();
            estado = aBD.modificar(a);
            aBD.cerrar();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
        if (estado == 0) {
            System.out.println("No se puedo actualizar");
        } else {
            System.out.println("Actualización existosa");
            System.out.println("Clave: " + a.getClave());
            System.out.println("Nombre: " + a.getNombre());
            System.out.println("Dirección: " + a.getDireccion());
            System.out.println("Email: " + a.getEmail());
            System.out.println("Pagina WEB: " + a.getPaginaWeb());
        }
    }
}
