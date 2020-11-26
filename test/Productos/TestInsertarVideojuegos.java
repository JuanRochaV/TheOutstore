package Productos;

import app.modelo.Videojuegos;
import app.persistencia.VideojuegosBD;
import java.sql.SQLException;

/**
 *
 * @author juan_
 */
public class TestInsertarVideojuegos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Videojuegos a = new Videojuegos();
        VideojuegosBD aBD = new VideojuegosBD();
        int estado = 0;
        
//        a.setClave(1);
        a.setNombre("God of Warr");
        a.setPrecioUnitario(250);
        a.setId_proveedor(1);
        a.setCosto(345);
        a.setNombre_proveedor("Sony");
        a.setStock(33);
        
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
