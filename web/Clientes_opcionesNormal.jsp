<%-- 
    Document   : Clientes_opcionesNormal
    Created on : 17/11/2020, 10:18:15 PM
    Author     : Juan Rocha
--%>

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
            ArrayList<Clientes> listaClientes = null;
            ClientesBD aBD = new ClientesBD();
            
            try{
                aBD.abrir();
                listaClientes = aBD.listar();
                aBD.cerrar();
            }catch(ClassNotFoundException | SQLException ex){
                
            }
            
            if (listaClientes == null){
                
            }else {
        %>
        
        <table  border="2" cellspacing="1" cellpadding="1">
            <tr>
                <th>Clave</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Ciudad</th>
                <th>RFC</th>
            </tr>
        <%
            for (int i = 0; i < listaClientes.size(); i++) {
        %>
            <tr>
                <td>
                    <%
                        out.print(listaClientes.get(i).getClave());
                    %>
                </td>
                 <td>
                    <%
                        out.print(listaClientes.get(i).getNombre());
                    %>
                </td>
                 <td>
                    <%
                        out.print(listaClientes.get(i).getEmail());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaClientes.get(i).getCiudad());
                    %>
                </td>
                <td>
                    <%
                        out.print(listaClientes.get(i).getRfc());
                    %>
                </td>
            </tr>
         <%
                }
            }
         %>
        </table>
        <button onclick="location.href='Clientes_InsertarNormal.jsp'">Insertar</button> <br>
        <button onclick="location.href='Menu_opcionesNormal.jsp'">Regresar al menú</button>
    </center>
    </body>
</html>
