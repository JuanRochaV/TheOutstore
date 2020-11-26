/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.persistencia;

import app.modelo.Clientes;
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
public class ClientesBD {
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
    
    public Clientes buscar(int clave, String nombre) throws SQLException{
        Clientes a = null;
        Statement smt;
        ResultSet rs;
        
        String query = "SELECT * FROM Clientes WHERE clave = "
                + clave + " OR nombre = '" + nombre + "'";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);
        
        while(rs.next()){
            a = new Clientes();
            a.setClave(Integer.parseInt(rs.getString("clave")));
            a.setNombre(rs.getString("nombre"));
            a.setEmail(rs.getString("email"));
            a.setCiudad(rs.getString("Ciudad"));
            a.setRfc(rs.getString("rfc"));
        }
        return a;
    }
    
    public int insertar (Clientes a) throws SQLException{
        int clave = a.getClave();
        String nombre = a.getNombre();
        String email = a.getEmail();
        String ciudad = a.getCiudad();
        String rfc = a.getRfc();
        
        String query = "INSERT INTO Clientes VALUES("
                + clave + ","
                +"'" + nombre + "',"
                +"'" + email + "',"
                +"'" + ciudad + "',"
                +"'" + rfc + "' "
                +")";
        
        System.out.println(query);
        
        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public int eliminar(int clave, String nombre) throws SQLException{
        Statement smt;
        String query = "DELETE FROM Clientes WHERE clave = " +
                clave + " AND nombre = '" + nombre + "' ";
        System.out.println(query);
        smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public int modificar (Clientes a) throws SQLException{
        int clave = a.getClave();
        String nombre = a.getNombre();
        String email = a.getEmail();
        String ciudad = a.getCiudad();
        String rfc = a.getRfc();
        
        String query = "UPDATE Clientes SET clave = "
                + clave + ","
                + "nombre = '" + nombre + "',"
                + "email = '" + email + "',"
                + "ciudad = '" + ciudad + "',"
                + "rfc = '" + rfc + "'"
                + " WHERE clave = "
                + clave;
        
        System.out.println(query);
        
        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public ArrayList<Clientes> listar () throws SQLException{
        ArrayList <Clientes> listaClientes = new ArrayList<>();
        Clientes a = null;
        Statement smt;
        ResultSet rs;
        
        String query = "SELECT * FROM Clientes";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);
        
        while(rs.next()){
            a = new Clientes();
            a.setClave(Integer.parseInt(rs.getString("clave")));
            a.setNombre(rs.getString("nombre"));
            a.setEmail(rs.getString("email"));
            a.setCiudad(rs.getString("ciudad"));
            a.setRfc(rs.getString("rfc"));
            listaClientes.add(a);      
        }
        return listaClientes;
    }
}
