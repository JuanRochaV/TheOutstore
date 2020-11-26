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
public class TestActualizarUsuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Usuarios a = new Usuarios();
        UsuariosBD aBD = new UsuariosBD();
        int estado = 0;

        a.setClave(1);
        a.setNombre("Juan Rocha");
        a.setUsuario("Manuel");
        a.setEmail("juan_rocha@hotmail.com");
        a.setCiudad("Leon");
        a.setRfc("xxxxxxxxxxx");
        a.setTipo("Administrador");
        a.setPass("123");

        try {
            aBD.abrir();
            estado = aBD.modificar(a);
            aBD.cerrar();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
        if (estado == 0) {
            System.out.println("No se puedo actualizar");
        } else {
            System.out.println("Actualización existosa");
            System.out.println("Clave: " + a.getClave());
            System.out.println("Nombre: " + a.getNombre());
            System.out.println("Usuario: " + a.getUsuario());
            System.out.println("Email: " + a.getEmail());
            System.out.println("Ciudad: " + a.getCiudad());
            System.out.println("RFC: " + a.getRfc());
            System.out.println("tipo: " + a.getTipo());
            System.out.println("pass: " + a.getPass());
        }
    }
    
}
