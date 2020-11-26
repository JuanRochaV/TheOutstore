/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.persistencia;

import app.modelo.Proveedores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Juan Rocha
 */
public class ProveedoresBD {
    private Connection conexion = null;
    private String servidor = "localhost";
    private String database = "theoutstore";
    private String user = "root";
    private String contrasena = "";
    //private String driver = "com.mysql.jdbc.Driver";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "";
    
    public void abrir() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        url = "jdbc:mysql://" + servidor + "/" + database;
        conexion = DriverManager.getConnection(url, user, contrasena);
    }
    
    public void cerrar() throws SQLException{
        conexion.close();
    }
    
    public Proveedores buscar(int clave, String nombre) throws SQLException{
        Proveedores a = null;
        Statement smt;
        ResultSet rs;
        
        String query = "SELECT * FROM proveedores WHERE clave = "
                + clave + " OR nombre = '" + nombre + "'";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);
        
        while(rs.next()){
            a = new Proveedores();
            a.setClave(Integer.parseInt(rs.getString("clave")));
            a.setNombre(rs.getString("nombre"));
            a.setDireccion(rs.getString("direccion"));
            a.setEmail(rs.getString("email"));
            a.setPaginaWeb(rs.getString("paginaWeb"));
        }
        return a;
    }
    
    public Proveedores buscarProveedor(int clave) throws SQLException{
        Proveedores a = null;
        Statement smt;
        ResultSet rs;
        
        String query = "SELECT * FROM proveedores WHERE clave = "
                + clave +  "";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);
        
        while(rs.next()){
            a = new Proveedores();
            a.setClave(Integer.parseInt(rs.getString("clave")));
            a.setNombre(rs.getString("nombre"));
            a.setDireccion(rs.getString("direccion"));
            a.setEmail(rs.getString("email"));
            a.setPaginaWeb(rs.getString("paginaWeb"));
        }
        return a;
    }

    public int insertar (Proveedores a) throws SQLException{
        int clave = a.getClave();
        String nombre = a.getNombre();
        String direccion = a.getDireccion();
        String email = a.getEmail();
        String paginaWeb = a.getPaginaWeb();
        
        String query = "INSERT INTO proveedores VALUES("
                + clave + ","
                +"'" + nombre + "',"
                +"'" + direccion + "',"
                +"'" + email + "',"
                +"'" + paginaWeb + "' "
                +")";
        
        System.out.println(query);
        
        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public int eliminar(int clave, String nombre) throws SQLException{
        Statement smt;
        String query = "DELETE FROM proveedores WHERE clave = " +
                clave + " AND nombre = '" + nombre + "' ";
        System.out.println(query);
        smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public int modificar (Proveedores a) throws SQLException{
        int clave = a.getClave();
        String nombre = a.getNombre();
        String direccion = a.getDireccion();
        String email = a.getEmail();
        String paginaWeb = a.getPaginaWeb();
        
        String query = "UPDATE proveedores SET clave = "
                + clave + ","
                + "nombre = '" + nombre + "',"
                + "direccion = '" + direccion + "',"
                + "email = '" + email + "',"
                + "paginaWeb = '" + paginaWeb + "'"
                + " WHERE clave = "
                + clave;
        
        System.out.println(query);
        
        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public ArrayList<Proveedores> listar () throws SQLException{
        ArrayList <Proveedores> listaProveedores = new ArrayList<>();
        Proveedores a = null;
        Statement smt;
        ResultSet rs;
        
        String query = "SELECT * FROM Proveedores";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);
        
        while(rs.next()){
            a = new Proveedores();
            a.setClave(Integer.parseInt(rs.getString("clave")));
            a.setNombre(rs.getString("nombre"));
            a.setDireccion(rs.getString("direccion"));
            a.setEmail(rs.getString("email"));
            a.setPaginaWeb(rs.getString("paginaWeb"));
            listaProveedores.add(a);      
        }
        return listaProveedores;
    }
}
