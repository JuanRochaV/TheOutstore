<%-- 
    Document   : Clientes_opciones
    Created on : 17/11/2020, 10:16:26 PM
    Author     : Juan Rocha
--%>

<%@page import="app.modelo.VistaCarritoProductos"%>
<%@page import="app.persistencia.CarritoBD"%>
<%@page import="app.modelo.Carrito"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="app.persistencia.ClientesBD"%>
<%@page import="app.modelo.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo de Clientes</title>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Bienvenido al sistema, <% out.print(session.getAttribute("name")); %></h1>
        <%
            ArrayList<VistaCarritoProductos> listaCarrito = null;
            CarritoBD aBD = new CarritoBD();

            try {
                aBD.abrir();
                listaCarrito = aBD.listarVista();
                aBD.cerrar();
            } catch (ClassNotFoundException | SQLException ex) {

            }

            if (listaCarrito == null) {

            } else {
        %>

        <table  border="2" cellspacing="1" cellpadding="1">
            <tr>
                <th>ID Producto</th>
                <th>Nombre Producto</th>
                <th>ID Usuario</th>
                <th>Nombre Usuario</th>
                <th>Cantidad</th>
            </tr>
            <%
                for (int i = 0; i < listaCarrito.size(); i++) {
            %>
            <tr>
                <td>
                    <%
                        out.print(listaCarrito.get(i).getId_producto());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaCarrito.get(i).getNombreP());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaCarrito.get(i).getId_usuario());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaCarrito.get(i).getNombreU());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaCarrito.get(i).getCantidad());
                    %>
                </td>
            </tr>
            <%
                    }
                }

            %>
        </table>
        <table>
            <tr>
                <td>
                    <button onclick="location.href = 'Carrito_Insertar.jsp'">Insertar</button>
                </td>
                <td>
                    <form  action = "Carrito_Eliminar" method="POST">
                        <button onclick="location.href = 'Carrito_Insertar.jsp'">Eliminar</button><br>
                    </form>
                </td>
                <td>
                    <form  action = "Carrito_Comprar" method="POST">
                        <button onclick="location.href = 'Carrito_Insertar.jsp'">Comprar</button><br>
                    </form>
                </td>
            </tr>
        </table>
        <script>
            ${mensaje}
        </script>
        <button onclick="location.href = 'Menu_opciones.jsp'">Regresar al menú</button>
    </center>
</body>
</html>
