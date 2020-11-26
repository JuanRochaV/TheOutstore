/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import app.modelo.Usuarios;
import app.persistencia.UsuariosBD;
import java.sql.SQLException;

/**
 *
 * @author Juan Rocha
 */
public class TestLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Usuarios a = null;
        UsuariosBD aBD = new UsuariosBD();
        boolean estado = false;
        String usuario = "Manuel";
        String pass = "123";
        
        try {
            aBD.abrir();
            estado = aBD.buscarLogin(pass, usuario);
            a = aBD.regresarBusqueda(pass, usuario);
            
            if ((estado == true) && (a.getTipo().equalsIgnoreCase("Administrador"))) {
                System.out.println("Accedio como " + usuario + " " +  a.getTipo());
               
            } else if ((estado == true) && (a.getTipo().equalsIgnoreCase("Normal"))){
                System.out.println("Accedio como " + usuario + " " + a.getTipo());
            }else{
                System.out.println("No existe");
            }
            aBD.cerrar();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
    }

}
