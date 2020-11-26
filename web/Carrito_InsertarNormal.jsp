<%-- 
    Document   : Cliente_Insertar
    Created on : 17/11/2020, 10:12:56 PM
    Author     : Juan Rocha
--%>

<%@page import="app.persistencia.VideojuegosBD"%>
<%@page import="app.modelo.Videojuegos"%>
<%@page import="java.sql.SQLException"%>
<%@page import="app.persistencia.CarritoBD"%>
<%@page import="app.modelo.VistaCarritoProductos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Cliente</title>
        <%
            ArrayList<Videojuegos> listaVideojuegos = null;
            VideojuegosBD aBD = new VideojuegosBD();

            try {
                aBD.abrir();
                listaVideojuegos = aBD.listar();
                aBD.cerrar();
            } catch (ClassNotFoundException | SQLException ex) {

            }

            if (listaVideojuegos == null) {

            } else {
        %>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Insertar productos al Carrito</h1>

        <form  action = "Carrito_Insertar" method="POST">
            <table>
                <%--Clave <input type="text" name="clave" value="" required="true"/><br>--%>
                
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="id_usuario" value="<% out.print(session.getAttribute("id"));%>" required="true" readonly="readonly"/></td>
                    <td><input type="text" value="<% out.print(session.getAttribute("name")); %>" required="true" readonly="readonly"/></td>
                </tr>
                <tr>
                    <td>Producto:</td>
                    <td>
                        <select name="id_producto" required="true">
                            <%
                                for (int i = 0; i < listaVideojuegos.size(); i++) {
                            %>
                            <option value="<%out.print(listaVideojuegos.get(i).getClave());%>"><%out.print(listaVideojuegos.get(i).getNombre());%></option> 
                            <%
                                    }
                                }
                            %>
                        </select>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="cantidad" required="true" /></td>
                    <td></td>
                </tr>
                <th colspan="3">
                <center><input type="submit" value="Insertar" action = "controllerManagedBean.validarObligatorio()"/></center>
                </th>

            </table>
        </form>
        <script>
            ${mensaje}
        </script>
        <br><br>
        <button onclick="location.href = 'Carrito_opcionesNormal.jsp'">Regresar al inicio</button>
    </center>
</body>
</html>
