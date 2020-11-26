package Carrito;

import app.modelo.Carrito;
import app.modelo.Videojuegos;
import app.persistencia.CarritoBD;
import app.persistencia.VideojuegosBD;
import java.sql.SQLException;

/**
 *
 * @author juan_
 */
public class TestComprarCarrito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CarritoBD aBD = new CarritoBD();
        Carrito a = new Carrito();
        
        VideojuegosBD vBD = new VideojuegosBD();
        Videojuegos v = new Videojuegos();
        
        String id_producto = "1";
        int cantidadC = 3;
        int stock = 23;
        int diferencia;
        
        int estado = 0;
        diferencia = stock-cantidadC;
        
        a.setId_producto(id_producto);
        v.setStock(diferencia);
        
        try{
            vBD.abrir();
            estado = vBD.actualizarStock(diferencia,id_producto);
            vBD.cerrar();
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
