<%-- 
    Document   : Videojuegos_opciones
    Created on : 17/05/2020, 11:01:46 AM
    Author     : juan_
--%>

<%@page import="app.persistencia.ProveedoresBD"%>
<%@page import="app.modelo.Proveedores"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="app.persistencia.VideojuegosBD"%>
<%@page import="app.modelo.Videojuegos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo de Productos</title>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Bienvenido al sistema, <% out.print(session.getAttribute("name")); %></h1>
        <%
            ArrayList<Videojuegos> listaVideojuegos = null;
            VideojuegosBD aBD = new VideojuegosBD();
            
            try{
                aBD.abrir();
                listaVideojuegos = aBD.listar();
                aBD.cerrar();
            }catch(ClassNotFoundException | SQLException ex){
                
            }
            
            if (listaVideojuegos == null){
                
            }else {
        %>
        
        <table  border="2" cellspacing="1" cellpadding="1">
            <tr>
                <th>Clave</th>
                <th>Nombre</th>
                <th>Precio Unitario</th>
                <th>ID Proveedor</th>
                <th>Proveedor</th>
                <th>Costo</th>
                <th>Stock</th>
            </tr>
        <%
            for (int i = 0; i < listaVideojuegos.size(); i++) {
        %>
            <tr>
                <td>
                    <%
                        out.print(listaVideojuegos.get(i).getClave());
                    %>
                </td>
                 <td>
                    <%
                        out.print(listaVideojuegos.get(i).getNombre());
                    %>
                </td>
                 <td>
                    <%
                        out.print(listaVideojuegos.get(i).getPrecioUnitario());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaVideojuegos.get(i).getId_proveedor());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaVideojuegos.get(i).getNombre_proveedor());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaVideojuegos.get(i).getCosto());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaVideojuegos.get(i).getStock());
                    %>
                </td>
            </tr>
         <%
                }
            }
         %>
        </table>
        <button onclick="location.href='Productos_Insertar.jsp'">Insertar</button>
        <button onclick="location.href='Productos_Actualizar.jsp'">Actualizar</button>
        <button onclick="location.href='Productos_Eliminar.jsp'">Eliminar</button>
        <button onclick="location.href='Productos_Buscar.jsp'">Buscar</button> <br>
        <button onclick="location.href='Menu_opciones.jsp'">Regresar al menú</button>
    </center>
    </body>
</html>
