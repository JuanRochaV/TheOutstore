<%-- 
    Document   : Proveedores_opciones
    Created on : 17/11/2020, 09:09:38 PM
    Author     : Juan Rocha
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="app.persistencia.ProveedoresBD"%>
<%@page import="app.modelo.Proveedores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo de Proveedores</title>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Bienvenido al sistema, <% out.print(session.getAttribute("name")); %></h1>
        <%
            ArrayList<Proveedores> listaProveedores = null;
            ProveedoresBD aBD = new ProveedoresBD();
            
            try{
                aBD.abrir();
                listaProveedores = aBD.listar();
                aBD.cerrar();
            }catch(ClassNotFoundException | SQLException ex){
                
            }
            
            if (listaProveedores == null){
                
            }else {
        %>
        
        <table  border="2" cellspacing="1" cellpadding="1">
            <tr>
                <th>Clave</th>
                <th>Nombre</th>
                <th>Dirección</th>
                <th>E-mail</th>
                <th>Pagina WEB</th>
            </tr>
        <%
            for (int i = 0; i < listaProveedores.size(); i++) {
        %>
            <tr>
                <td>
                    <%
                        out.print(listaProveedores.get(i).getClave());
                    %>
                </td>
                 <td>
                    <%
                        out.print(listaProveedores.get(i).getNombre());
                    %>
                </td>
                 <td>
                    <%
                        out.print(listaProveedores.get(i).getDireccion());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaProveedores.get(i).getEmail());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaProveedores.get(i).getPaginaWeb());
                    %>
                </td>
            </tr>
         <%
                }
            }
         %>
        </table>
        <button onclick="location.href='Proveedores_Insertar.jsp'">Insertar</button>
        <button onclick="location.href='Proveedores_Actualizar.jsp'">Actualizar</button>
        <button onclick="location.href='Proveedores_Eliminar.jsp'">Eliminar</button>
        <button onclick="location.href='Proveedores_Buscar.jsp'">Buscar</button> <br>
        <button onclick="location.href='Menu_opciones.jsp'">Regresar al menú</button>
    </center>
    </body>
</html>
