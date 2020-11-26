<%-- 
    Document   : Proveedores_Buscar
    Created on : 17/11/2020, 08:48:04 PM
    Author     : Juan Rocha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Proveedores</title>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Buscar Proveedores</h1>
        
        <form action="Proveedores_Buscar" method="POST">   
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
                    Dirección:
                </td>
                <td>
                    <font style="color:#FF0000">${direccion}</font>
                </td>
            </tr>
            <tr>
                <td>
                    E-mail:
                </td>
                <td>
                    <font style="color:#FF0000">${email}</font>
                </td>
            </tr>
            <tr>
                <td>
                    Pagina WEB:
                </td>
                <td>
                    <font style="color:#FF0000">${paginaWeb}</font><br>
                </tr>
            </td>
        </table>
        <br><br>
        <button onclick="location.href='Proveedores_opciones.jsp'">Regresar al inicio</button>
    </center>
    </body>
</html>