package Clientes;

import app.modelo.Clientes;
import app.persistencia.ClientesBD;
import java.sql.SQLException;

/**
 *
 * @author Juan Rocha
 */
public class TestBorrarVideojuegos {

    public static void main(String[] args) {
        ClientesBD aBD = new ClientesBD();
        Clientes a = null;
        int estado = 0;
        int clave = 1;
        String nombre = "Juan Rocha";

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
