/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VistaCarritoProdutos;

import app.modelo.VistaCarritoProductos;
import app.persistencia.CarritoBD;
import java.sql.SQLException;

/**
 *
 * @author juan_
 */
public class TestBuscarVistaCarritoProdutos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarritoBD aBD = new CarritoBD ();
        VistaCarritoProductos a = null;
        String nombre = "Juan Rocha";
        
        try{
            aBD.abrir();
            a = aBD.buscarVista(nombre);
            aBD.cerrar();
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
        
        if (a == null){
            System.out.println("Usuario inexistente");
        }else{
            System.out.println("Id_Producto: " + a.getId_producto());
            System.out.println("Nombre Producto: " + a.getNombreP());
            System.out.println("Id_Usuario: " + a.getId_usuario());
            System.out.println("Nombre Usuario: " + a.getNombreU());
            System.out.println("Cantidad: " + a.getCantidad());
        }
    }
}
