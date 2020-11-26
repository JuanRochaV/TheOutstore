package Productos;

import app.modelo.Proveedores;
import app.modelo.Videojuegos;
import app.persistencia.ProveedoresBD;
import app.persistencia.VideojuegosBD;
import java.sql.SQLException;

/**
 *
 * @author Juan Rocha
 */
public class TestBorrarVideojuegos {

    public static void main(String[] args) {
        VideojuegosBD aBD = new VideojuegosBD();
        Videojuegos a;
        a = new Videojuegos();
        int estado = 0;
        int clave = 2;
        String nombre = "God of Warr";

        try {
            aBD.abrir();
            estado = aBD.eliminar(clave, nombre);
            aBD.cerrar();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
        if (estado == 0) {
            System.out.println("No se puedo eliminar");
        } else {
            System.out.println("Eliminación existosa");
        }
    }
}
