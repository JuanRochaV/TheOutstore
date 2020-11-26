package Usuarios;

import app.modelo.Usuarios;
import app.persistencia.UsuariosBD;
import java.sql.SQLException;

/**
 *
 * @author juan_
 */
public class TestInsertarUsuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuarios a = new Usuarios();
        UsuariosBD aBD = new UsuariosBD();
        int estado = 0;
        
//        a.setClave(1);
        a.setNombre("Juan Rocha");
        a.setUsuario("Manuel");
        a.setPass("123");
        a.setEmail("juan@gmail.com");
        a.setCiudad("Monterrey");
        a.setRfc("hhhhhhhhhhhhh");
        a.setTipo("Normal");
        
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
