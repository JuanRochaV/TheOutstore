<%-- 
    Document   : Clientes_Buscar
    Created on : 17/11/2020, 10:27:04 PM
    Author     : Juan Rocha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Cliente</title>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Buscar Cliente</h1>
        <form action="Clientes_Buscar" method="POST">
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
                <th colspan="2">
                <center><input type="submit" value="Buscar" action = "controllerManagedBean.validarObligatorio()"/></center>
                </th>            
        </form>
        <script>
            ${mensaje}
        </script>
        
        
        <table  border="2" cellspacing="1" cellpadding="1">
            <br><br>
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
                    Email:
                </td>
                <td>
                    <font style="color:#FF0000">${email}</font>
                </td>
            </tr>
            <tr>
                <td>
                    Ciudad:
                </td>
                <td>
                    <font style="color:#FF0000">${ciudad}</font>
                </td>
            </tr>
            <tr>
                <td>
                    RFC:
                </td>
                <td>
                    <font style="color:#FF0000">${rfc}</font><br>
                </tr>
            </td>
        </table>
        <br><br>
        <button onclick="location.href='Clientes_opciones.jsp'">Regresar al inicio</button>
    </center>
    </body>
</html>