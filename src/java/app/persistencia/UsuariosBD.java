/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.persistencia;

import app.modelo.Usuarios;
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
public class UsuariosBD {
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
    
    public Usuarios buscar(int clave, String nombre) throws SQLException{
        Usuarios a = null;
        Statement smt;
        ResultSet rs;
        
        String query = "SELECT * FROM Usuarios WHERE clave = "
                + clave + " OR nombre = '" + nombre + "'";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);
        
        while(rs.next()){
            a = new Usuarios();
            a.setClave(Integer.parseInt(rs.getString("clave")));
            a.setNombre(rs.getString("nombre"));
            a.setUsuario(rs.getString("usuario"));
            a.setEmail(rs.getString("email"));
            a.setCiudad(rs.getString("ciudad"));
            a.setRfc(rs.getString("rfc"));
            a.setTipo(rs.getString("tipo"));
        }
        return a;
    }
    
    public  boolean buscarLogin(String pass, String usuario) throws SQLException{
        Statement smt;
        ResultSet rs;
        
        String query = "SELECT * FROM Usuarios WHERE usuario = '"
                + usuario + "' AND pass = '" + pass + "'";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);
        
        if(rs.next()){
            return true;
        }else
        return false;
    }
    
    public Usuarios regresarBusqueda(String pass, String usuario) throws SQLException{
        Usuarios a = null;
        Statement smt;
        ResultSet rs;
        
        String query = "SELECT * FROM Usuarios WHERE usuario = '"
                + usuario + "' AND pass = '" + pass + "'";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);
        
        while(rs.next()){
            a = new Usuarios();
            a.setClave(Integer.parseInt(rs.getString("clave")));
            a.setNombre(rs.getString("nombre"));
            a.setUsuario(rs.getString("usuario"));
            a.setEmail(rs.getString("email"));
            a.setCiudad(rs.getString("ciudad"));
            a.setRfc(rs.getString("rfc"));
            a.setTipo(rs.getString("tipo"));
        }
        return a;
    }
    
    
    public int insertar (Usuarios a) throws SQLException{
        int clave = a.getClave();
        String nombre = a.getNombre();
        String usuario = a.getUsuario();
        String email = a.getEmail();
        String ciudad = a.getCiudad();
        String rfc = a.getRfc();
        String tipo = a.getTipo();
        String pass = a.getPass();
        
        String query = "INSERT INTO Usuarios VALUES("
                + clave + ","
                +"'" + nombre + "',"
                +"'" + usuario + "',"
                +"'" + email + "',"
                +"'" + ciudad + "',"
                +"'" + rfc + "',"
                +"'" + tipo + "',"
                +"'" + pass + "' "
                +")";
        
        System.out.println(query);
        
        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public int eliminar(int clave, String nombre) throws SQLException{
        Statement smt;
        String query = "DELETE FROM usuarios WHERE clave = " +
                clave + " AND nombre = '" + nombre + "' ";
        System.out.println(query);
        smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public int modificar (Usuarios a) throws SQLException{
        int clave = a.getClave();
        String nombre = a.getNombre();
        String usuario = a.getUsuario();
        String email = a.getEmail();
        String ciudad = a.getCiudad();
        String rfc = a.getRfc();
        String tipo = a.getTipo();
        String pass = a.getPass();
        
        String query = "UPDATE usuarios SET clave = "
                + clave + ","
                + "nombre = '" + nombre + "',"
                + "usuario = '" + usuario + "',"
                + "email = '" + email + "',"
                + "ciudad = '" + ciudad + "',"
                + "rfc = '" + rfc + "',"
                + "tipo = '" + tipo + "',"
                + "pass = '" + pass + "'"
                + " WHERE clave = "
                + clave;
        
        System.out.println(query);
        
        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public ArrayList<Usuarios> listar () throws SQLException{
        ArrayList <Usuarios> listaUsuarios = new ArrayList<>();
        Usuarios a = null;
        Statement smt;
        ResultSet rs;
        
        String query = "SELECT * FROM usuarios";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);
        
        while(rs.next()){
            a = new Usuarios();
            a.setClave(Integer.parseInt(rs.getString("clave")));
            a.setNombre(rs.getString("nombre"));
            a.setUsuario(rs.getString("usuario"));
            a.setEmail(rs.getString("email"));
            a.setCiudad(rs.getString("ciudad"));
            a.setRfc(rs.getString("rfc"));
            a.setTipo(rs.getString("tipo"));
            listaUsuarios.add(a);      
        }
        return listaUsuarios;
    }
}
