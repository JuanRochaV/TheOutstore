<%-- 
    Document   : Usuarios_opciones
    Created on : 17/11/2020, 11:25:16 PM
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
        <title>Catálogo de Usuarios</title>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Bienvenido al sistema, <% out.print(session.getAttribute("name")); %></h1>
        <%
            ArrayList<Usuarios> listaUsuarios = null;
            UsuariosBD aBD = new UsuariosBD();
            
            try{
                aBD.abrir();
                listaUsuarios = aBD.listar();
                aBD.cerrar();
            }catch(ClassNotFoundException | SQLException ex){
                
            }
            
            if (listaUsuarios == null){
                
            }else {
        %>
        
        <table  border="2" cellspacing="1" cellpadding="1">
            <tr>
                <th>Clave</th>
                <th>Nombre</th>
                <th>Usuario</th>
                <th>E-mail</th>
                <th>Ciudad</th>
                <th>RFC</th>
                <th>Tipo de Usuario</th>
            </tr>
        <%
            for (int i = 0; i < listaUsuarios.size(); i++) {
        %>
            <tr>
                <td>
                    <%
                        out.print(listaUsuarios.get(i).getClave());
                    %>
                </td>
                 <td>
                    <%
                        out.print(listaUsuarios.get(i).getNombre());
                    %>
                </td>
                 <td>
                    <%
                        out.print(listaUsuarios.get(i).getUsuario());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaUsuarios.get(i).getEmail());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaUsuarios.get(i).getCiudad());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaUsuarios.get(i).getRfc());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaUsuarios.get(i).getTipo());
                    %>
                </td>   
            </tr>
         <%
                }
            }
         %>
        </table>
        <button onclick="location.href='Usuarios_Insertar.jsp'">Insertar</button>
        <button onclick="location.href='Usuarios_Actualizar.jsp'">Actualizar</button>
        <button onclick="location.href='Usuarios_Eliminar.jsp'">Eliminar</button>
        <button onclick="location.href='Usuarios_Buscar.jsp'">Buscar</button> <br>
        <button onclick="location.href='Menu_opciones.jsp'">Regresar al menú</button>
    </center>
    </body>
</html>
