package Proveedores;

import app.modelo.Proveedores;
import app.persistencia.ProveedoresBD;
import java.sql.SQLException;

/**
 *
 * @author juan_
 */
public class TestInsertarProveedores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Proveedores a = new Proveedores();
        ProveedoresBD aBD = new ProveedoresBD();
        int estado = 0;
        
//        a.setClave(1);
        a.setNombre("Sony");
        a.setDireccion("California");
        a.setEmail("info@sony.com");
        a.setPaginaWeb("www.sony.com");
        
        try{
            aBD.abrir();
            estado = aBD.insertar(a);
            aBD.cerrar();
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
        if (estado == 0){
            System.out.println("No se puedo insertar");
        }else{
            System.out.println("Insersión existosa");
        }
    }
    
}
