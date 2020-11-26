package app.persistencia;

import app.modelo.Videojuegos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author juan_
 */
public class VideojuegosBD {
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
    
    public Videojuegos buscar(int clave, String nombre) throws SQLException{
        Videojuegos a = null;
        Statement smt;
        ResultSet rs;
        
        String query = "SELECT * FROM productos WHERE clave = "
                + clave + " OR nombrep = '" + nombre + "'";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);
        
        while(rs.next()){
            a = new Videojuegos();
            a.setClave(Integer.parseInt(rs.getString("clave")));
            a.setNombre(rs.getString("nombrep"));
            a.setPrecioUnitario(rs.getInt("precioUnitario"));
            a.setId_proveedor(rs.getInt("id_proveedor"));
            a.setCosto(rs.getInt("costo"));
            a.setNombre_proveedor(rs.getString("nombre_proveedor"));
            a.setStock(rs.getInt("stock"));
        }
        return a;
    }
    
    public int insertar (Videojuegos a) throws SQLException{
        int clave = a.getClave();
        String nombre = a.getNombre();
        int precioUnitario = a.getPrecioUnitario();
        int id_proveedor = a.getId_proveedor();
        int costo = a.getCosto();
        String nombre_proveedor = a.getNombre_proveedor();
        int stock = a.getStock();
        
        String query = "INSERT INTO productos VALUES("
                + clave + ","
                +"'" + nombre + "',"
                + precioUnitario + ","
                + id_proveedor + ","
                + costo + ", "
                +"'" + nombre_proveedor + "', "
                + stock +")";
        
        System.out.println(query);
        
        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public int eliminar(int clave, String nombre) throws SQLException{
        Statement smt;
        String query = "DELETE FROM productos WHERE clave = " +
                clave + " AND nombrep = '" + nombre + "' ";
        System.out.println(query);
        smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public int modificar (Videojuegos a) throws SQLException{
        int clave = a.getClave();
        String nombre = a.getNombre();
        int precioUnitario = a.getPrecioUnitario();
        int id_proveedor = a.getId_proveedor();
        int costo = a.getCosto();
        String nombre_proveedor = a.getNombre_proveedor();
        int stock = a.getStock();
        
        String query = "UPDATE productos SET nombrep = '" 
                + nombre + "',"
                + "precioUnitario = " + precioUnitario + ","
                + "id_proveedor = " + id_proveedor + ","
                + "costo = " + costo + ","
                + "nombre_proveedor = '" + nombre_proveedor + "',"
                + "stock = " + stock + ""
                + " WHERE clave = "
                + clave;
        
        System.out.println(query);
        
        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public int actualizarStock (int stock, String id) throws SQLException{  
        String query = "UPDATE productos SET stock = " 
                + stock + ""
                + " WHERE clave = '"
                + id + "'";
        
        System.out.println(query);
        
        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public ArrayList<Videojuegos> listar () throws SQLException{
        ArrayList <Videojuegos> listaProductos = new ArrayList<>();
        Videojuegos a = null;
        Statement smt;
        ResultSet rs;
        
        String query = "SELECT * FROM productos";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);
        
        while(rs.next()){
            a = new Videojuegos();
            a.setClave(Integer.parseInt(rs.getString("clave")));
            a.setNombre(rs.getString("nombrep"));
            a.setPrecioUnitario(rs.getInt("precioUnitario"));
            a.setId_proveedor(rs.getInt("id_proveedor"));
            a.setCosto(rs.getInt("costo"));
            a.setNombre_proveedor(rs.getString("nombre_proveedor"));
            a.setStock(rs.getInt("stock"));
            listaProductos.add(a);      
        }
        return listaProductos;
    }
}
