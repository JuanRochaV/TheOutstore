package Clientes;

import app.modelo.Clientes;
import app.persistencia.ClientesBD;
import java.sql.SQLException;

/**
 *
 * @author juan_
 */
public class TestInsertarClientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clientes a = new Clientes();
        ClientesBD aBD = new ClientesBD();
        int estado = 0;
        
//        a.setClave(1);
        a.setNombre("Juan Rocha");
        a.setEmail("juan@hotmail.com");
        a.setCiudad("Léon");
        a.setRfc("VECJ880326XXX");
        
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
