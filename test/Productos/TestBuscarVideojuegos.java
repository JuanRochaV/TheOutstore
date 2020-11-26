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
 * @author juan_
 */
public class TestBuscarVideojuegos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VideojuegosBD aBD = new VideojuegosBD();
        Videojuegos a = null;
        int clave = 1;
        String nombre = "God of Warr";
        
        try{
            aBD.abrir();
            a = aBD.buscar(clave, nombre);
            aBD.cerrar();
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
        
        if (a == null){
            System.out.println("Videojuego inexistente");
        }else{
            System.out.println("Clave: " + a.getClave());
            System.out.println("Nombre: " + a.getNombre());
            System.out.println("Precio Unitario: " + a.getPrecioUnitario());
            System.out.println("Id del proveedor: " + a.getId_proveedor());
            System.out.println("Costo: " + a.getCosto());
            System.out.println("Stock: " + a.getStock());
        }
    }
}
