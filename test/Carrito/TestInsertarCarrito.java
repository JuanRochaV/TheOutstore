package Carrito;

import app.modelo.Carrito;
import app.persistencia.CarritoBD;
import java.sql.SQLException;

/**
 *
 * @author juan_
 */
public class TestInsertarCarrito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carrito a = new Carrito();
        CarritoBD aBD = new CarritoBD();
        int estado = 0;
        
//        a.setClave(1);
        a.setId_usuario("1");
        a.setId_producto("1");
        a.setCantidad(22);
        
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
