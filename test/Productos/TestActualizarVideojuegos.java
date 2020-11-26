/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import app.modelo.Videojuegos;
import app.persistencia.VideojuegosBD;
import java.sql.SQLException;

/**
 *
 * @author Juan Rocha
 */
public class TestActualizarVideojuegos {

    public static void main(String[] args) {
        Videojuegos a = new Videojuegos();
        VideojuegosBD aBD = new VideojuegosBD();
        int estado = 0;

        a.setClave(1);
        a.setNombre("God of Warr");
        a.setPrecioUnitario(560);
        a.setId_proveedor(1);
        a.setNombre_proveedor("Sony");
        a.setCosto(600);
        a.setStock(22);

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
            System.out.println("Precio Unitario: " + a.getPrecioUnitario());
            System.out.println("Id del proveedor: " + a.getId_proveedor());
            System.out.println("Nombre Proveedor  : " + a.getNombre_proveedor());
            System.out.println("Costo: " + a.getCosto());
            System.out.println("Stock: " + a.getStock());
        }
    }

}
