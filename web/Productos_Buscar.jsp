<%-- 
    Document   : Videojuegos_Buscar
    Created on : 17/05/2020, 01:00:39 AM
    Author     : juan_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Videojuegos</title>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Buscar Videojuegos</h1>

        <form action="Productos_Buscar" method="POST">
            <table>
                <tr>
                    <td>Clave:</td>
                    <td><input type="text" name="clave" value="" required="true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" value="" required="true"/></td>
                    <td></td>
                </tr>
                <th colspan="3">
                <center><input type="submit" value="Buscar" action = "controllerManagedBean.validarObligatorio()"/></center>
                </th>
            </table>
        </form>
        <script>
            ${mensaje}
        </script>

        <br>
        <table  border="2" cellspacing="1" cellpadding="1">
            <tr>
                <td colspan="2">
                    Busqueda
                </td>
            </tr>
            <tr>
                <td>
                    Clave: 
                </td>
                <td>
                    <font style="color:#FF0000"> ${clave}</font>
                </td>
            </tr>
            <tr>
                <td>
                    Nombre: 
                </td>
                <td>
                    <font style="color:#FF0000">${nombre}</font>
                </td>
            </tr>
            <tr>
                <td>
                    Precio Unitario:
                </td>
                <td>
                    <font style="color:#FF0000">${precioUnitario}</font>
                </td>
            </tr>
            <tr>
                <td>
                    ID Proveedor:
                </td>
                <td>
                    <font style="color:#FF0000">${id_proveedor}</font>
                </td>
            </tr>
            <tr>
                <td>
                    Proveedor:
                </td>
                <td>
                    <font style="color:#FF0000">${nombre_proveedor}</font>
                </td>
            </tr>
            <tr>
                <td>
                    Costo:
                </td>
                <td>
                    <font style="color:#FF0000">${costo}</font><br>
            </tr>
            <tr>
                <td>
                    Stock:
                </td>
                <td>
                    <font style="color:#FF0000">${stock}</font><br>
            </tr>
            </td>
        </table>
        <br><br>
        <button onclick="location.href = 'Productos_opciones.jsp'">Regresar al inicio</button>
    </center>
</body>
</html>