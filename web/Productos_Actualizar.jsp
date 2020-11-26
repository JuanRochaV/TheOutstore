<%-- 
    Document   : Videojuegos_Actualizar
    Created on : 17/05/2020, 12:57:36 AM
    Author     : juan_
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="app.persistencia.ProveedoresBD"%>
<%@page import="app.modelo.Proveedores"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Videojuegos</title>
        <%
            ArrayList<Proveedores> listaProveedores = null;
            ProveedoresBD aBD = new ProveedoresBD();

            try {
                aBD.abrir();
                listaProveedores = aBD.listar();
                aBD.cerrar();
            } catch (ClassNotFoundException | SQLException ex) {

            }

            if (listaProveedores == null) {

            } else {
        %>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Actualizar Videojuegos</h1>
        
        <form  action = "Productos_Actualizar" method="POST">
            <table>
                <%--Clave <input type="text" name="clave" value=""/><br>--%>
                <tr>
                    <td>Clave:</td>
                    <td><input type="text" name="clave" value=""/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" value="" required="true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Precio Unitario:</td>
                    <td><input type="text" name="precioUnitario" value="" required="true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>ID Proveedor:</td>
                    <td>
                        <select name="id_proveedor" id="id_proveedor"required="true">
                            <%
                                for (int i = 0; i < listaProveedores.size(); i++) {
                            %>
                            <option value="<%out.print(listaProveedores.get(i).getClave());%>"><%out.print(listaProveedores.get(i).getClave());%></option> 
                            <%
                                }
                            %>
                        </select>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>Proveedor:</td>
                    <td>
                        <select name="nombre_proveedor" required="true">
                            <%
                                for (int i = 0; i < listaProveedores.size(); i++) {
                            %>
                            <option value="<%out.print(listaProveedores.get(i).getNombre());%>"><%out.print(listaProveedores.get(i).getNombre());%></option> 
                            <%
                                    }
                                }
                            %>
                        </select>
                    </td>
                    <td></td>
                </tr>
                </tr>
                <tr>
                    <td>Costo:</td>
                    <td><input type="text" name="costo" value="" required="true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Stock:</td>
                    <td><input type="text" name="stock" value="" required="true"/></td>
                    <td></td>
                </tr>
                <th colspan="3">
                <center><input type="submit" value="Actualizar" action = "controllerManagedBean.validarObligatorio()"/></center>
                </th>
            </table>
        </form>
        <script>
            ${mensaje}
        </script>
        <br><br>
        <button onclick="location.href='Productos_opciones.jsp'">Regresar al inicio</button>
    </center>
    </body>
</html>
