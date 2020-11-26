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
 * @author juan_
 */
public class TestBuscarUsuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UsuariosBD aBD = new UsuariosBD();
        Usuarios a = null;
        int clave = 1;
        String nombre = "Juan Rocha";
        
        try{
            aBD.abrir();
            a = aBD.buscar(clave, nombre);
            aBD.cerrar();
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
        
        if (a == null){
            System.out.println("Usuario inexistente");
        }else{
            System.out.println("Clave: " + a.getClave());
            System.out.println("Nombre: " + a.getNombre());
            System.out.println("Usuario: " + a.getUsuario());
            System.out.println("E-mail: " + a.getEmail());
            System.out.println("Ciudad: " + a.getCiudad());
            System.out.println("rfc: " + a.getRfc());
            System.out.println("tipo: " + a.getTipo());
        }
    }
}
