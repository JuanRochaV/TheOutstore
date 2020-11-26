package Proveedores;

import app.modelo.Proveedores;
import app.persistencia.ProveedoresBD;
import java.sql.SQLException;

/**
 *
 * @author Juan Rocha
 */
public class TestRegresarProveedor {

    
    public static void main(String[] args) {
        ProveedoresBD aBD = new ProveedoresBD();
        Proveedores a = null;
        int clave = 1;
        
        try{
            aBD.abrir();
            a = aBD.buscarProveedor(clave);
            aBD.cerrar();
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
        
        if (a == null){
            System.out.println("Proveedor inexistente");
        }else{
            System.out.println("Nombre: " + a.getNombre());
        }
    }
}
