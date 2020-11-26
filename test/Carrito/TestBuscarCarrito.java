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
 * @author juan_
 */
public class TestBuscarCarrito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarritoBD aBD = new CarritoBD();
        Carrito a = null;
        int clave = 1;
        
        try{
            aBD.abrir();
            a = aBD.buscar(clave);
            aBD.cerrar();
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
        
        if (a == null){
            System.out.println("Carrito inexistente");
        }else{
            System.out.println("Clave: " + a.getClave());
            System.out.println("Id_usuario: " + a.getId_usuario());
            System.out.println("Id_producto: " + a.getId_producto());
            System.out.println("Cantidad: " + a.getCantidad());
        }
    }
}
