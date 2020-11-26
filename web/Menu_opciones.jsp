<%-- 
    Document   : Menu_opciones
    Created on : 17/11/2020, 07:29:55 PM
    Author     : Juan Rocha
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="app.persistencia.UsuariosBD"%>
<%@page import="app.modelo.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogos</title>
    </head>
    <body>
    <body style="background-color:#33ffca;">

    <center>
        <h1>Elije lo que quieras administrar...</h1>
        <h1>Usuario: <% out.print(session.getAttribute("user"));%></h1>
        <h1><% out.print(session.getAttribute("type"));%></h1>
        <br><br>
        <table class="basic" border=1 cellpadding=15 cellspacing=2>
            <tr>
                <td><center><img src="img/productos.png" id="imgProductos"></center></td>
                <td><center><img src="img/proveedores.png" id="imgProveedores"></center></td>
                <td><center><img src="img/clientes.png" id="imgClientes"></center></td>
                <td><center><img src="img/usuarios.png" id="imgUsuarios"></center></td>
                <td><center><img src="img/carrito.png" id="imgUsuarios"></center></td>
            </tr>
            <tr><td><center><button onclick="location.href = 'Productos_opciones.jsp'">Productos</button></center></td>
                <td><center><button onclick="location.href = 'Proveedores_opciones.jsp'">Proveedores</button></center></td>
                <td><center><button onclick="location.href = 'Clientes_opciones.jsp'">Clientes</button> </center></td>
                <td><center><button onclick="location.href = 'Usuarios_opciones.jsp'">Usuarios</button> </center></td>
                <td><center><button onclick="location.href = 'Carrito_opciones.jsp'">Carrito</button> </center></td>
            </tr>
        </table>

        <br><button onclick="location.href = 'index.jsp'">Salir</button> <br>
    </center>
        </body>
        </html>
