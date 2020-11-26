package Usuarios;

import app.modelo.Usuarios;
import app.persistencia.UsuariosBD;
import java.sql.SQLException;

/**
 *
 * @author Juan Rocha
 */
public class TestBorrarUsuarios {

    public static void main(String[] args) {
        Usuarios a = new Usuarios();
        UsuariosBD aBD = new UsuariosBD();
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
