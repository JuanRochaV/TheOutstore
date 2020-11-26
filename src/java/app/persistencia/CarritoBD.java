package app.persistencia;

import app.modelo.Carrito;
import app.modelo.VistaCarritoProductos;
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
public class CarritoBD {

    private Connection conexion = null;
    private String servidor = "localhost";
    private String database = "theoutstore";
    private String user = "root";
    private String contrasena = "";
    //private String driver = "com.mysql.jdbc.Driver";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "";

    public void abrir() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        url = "jdbc:mysql://" + servidor + "/" + database;
        conexion = DriverManager.getConnection(url, user, contrasena);
    }

    public void cerrar() throws SQLException {
        conexion.close();
    }

    public int insertar(Carrito a) throws SQLException {
        int clave = a.getClave();
        String id_usuario = a.getId_usuario();
        String id_producto = a.getId_producto();
        int cantidad = a.getCantidad();

        String query = "INSERT INTO carrito VALUES("
                + clave + ","
                + id_usuario + ","
                + id_producto + ","
                + cantidad + ")";

        System.out.println(query);

        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }

    public Carrito buscar(int clave) throws SQLException {
        Carrito a = null;
        Statement smt;
        ResultSet rs;

        String query = "SELECT * FROM carrito WHERE clave = "
                + clave + "";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);

        while (rs.next()) {
            a = new Carrito();
            a.setClave(Integer.parseInt(rs.getString("clave")));
            a.setId_usuario(rs.getString("id_usuario"));
            a.setId_producto(rs.getString("id_producto"));
            a.setCantidad(Integer.parseInt(rs.getString("cantidad")));
        }
        return a;
    }

    public VistaCarritoProductos buscarVista(String nombre) throws SQLException {
        VistaCarritoProductos a = null;
        Statement smt;
        ResultSet rs;

        String query = "SELECT * FROM vista_carritoprodutos WHERE nombre = '"
                + nombre + "'";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);

        while (rs.next()) {
            a = new VistaCarritoProductos();
            a.setId_usuario(rs.getInt("id_usuario"));
            a.setId_producto(rs.getInt("id_producto"));
            a.setNombreP(rs.getString("nombrep"));
            a.setNombreU(rs.getString("nombre"));
            a.setCantidad(rs.getInt("cantidad"));
        }
        return a;
    }
    
    public int eliminar() throws SQLException{
        Statement smt;
        String query = "DELETE FROM carrito;" ;
        System.out.println(query);
        smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }

    public ArrayList<Carrito> listar() throws SQLException {
        ArrayList<Carrito> listaProductos = new ArrayList<>();
        Carrito a = null;
        Statement smt;
        ResultSet rs;

        String query = "SELECT * FROM productos";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);

        while (rs.next()) {
            a = new Carrito();
            a.setClave(Integer.parseInt(rs.getString("clave")));
            a.setId_usuario(rs.getString("id_usuario"));
            a.setId_producto(rs.getString("id_producto"));
            a.setCantidad(Integer.parseInt(rs.getString("cantidad")));
            listaProductos.add(a);
        }
        return listaProductos;
    }

    public ArrayList<VistaCarritoProductos> listarVista() throws SQLException {
        ArrayList<VistaCarritoProductos> listaProductos = new ArrayList<>();
        VistaCarritoProductos a = null;
        Statement smt;
        ResultSet rs;

        String query = "SELECT * FROM vista_carritoprodutos";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);

        while (rs.next()) {
            a = new VistaCarritoProductos();
            a.setId_usuario(rs.getInt("id_usuario"));
            a.setNombreU(rs.getString("nombre"));
            a.setId_producto(rs.getInt("id_producto"));
            a.setNombreP(rs.getString("nombreP"));
            a.setCantidad(rs.getInt("cantidad"));
            listaProductos.add(a);
        }
        return listaProductos;
    }
}
