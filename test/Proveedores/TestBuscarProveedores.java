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
 * @author juan_
 */
public class TestBuscarProveedores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProveedoresBD aBD = new ProveedoresBD();
        Proveedores a = null;
        int clave = 1;
        String nombre = "Sony";
        
        try{
            aBD.abrir();
            a = aBD.buscar(clave, nombre);
            aBD.cerrar();
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
        
        if (a == null){
            System.out.println("Proveedor inexistente");
        }else{
            System.out.println("Clave: " + a.getClave());
            System.out.println("Nombre: " + a.getNombre());
            System.out.println("Dirección: " + a.getDireccion());
            System.out.println("E-mail: " + a.getEmail());
            System.out.println("Pagina WEB: " + a.getPaginaWeb());
        }
    }
}
