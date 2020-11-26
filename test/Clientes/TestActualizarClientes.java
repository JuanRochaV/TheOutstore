/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import app.modelo.Clientes;
import app.persistencia.ClientesBD;
import java.sql.SQLException;

/**
 *
 * @author Juan Rocha
 */
public class TestActualizarClientes {

    public static void main(String[] args) {
        ClientesBD aBD = new ClientesBD();
        Clientes a = new Clientes();
        int estado = 0;

        a.setClave(1);
        a.setNombre("Juan Rocha");
        a.setEmail("juan_rocha@hotmail.com");
        a.setCiudad("Monterrey");
        a.setRfc("VECJ880326XXX");

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
            System.out.println("E-mail: " + a.getEmail());
            System.out.println("Ciudad: " + a.getCiudad());
            System.out.println("RFC: " + a.getRfc());
        }
    }

}
