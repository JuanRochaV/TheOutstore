/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrito;

import app.modelo.Carrito;
import app.persistencia.CarritoBD;
import java.sql.SQLException;

/**
 *
 * @author Juan Rocha
 */
public class TestEliminarCarrito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carrito a = new Carrito();
        CarritoBD aBD = new CarritoBD();
        int estado = 0;
        
        try{
            aBD.abrir();
            estado = aBD.eliminar();
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
