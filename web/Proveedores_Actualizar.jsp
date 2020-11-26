<%-- 
    Document   : Proveedores_Actualizar
    Created on : 17/11/2020, 08:45:34 PM
    Author     : Juan Rocha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Proveedores</title>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Actualizar Proveedores</h1>
        
        <form  action = "Proveedores_Actualizar" method="POST">
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
                <tr>
                    <td>Dirección:</td>
                    <td><input type="text" name="direccion" value="" required="true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><input type="text" name="email" value="" required="true" /></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Pagina WEB</td>
                    <td><input type="text" name="paginaWeb" value="" required="true"/></td>
                    <td></td>
                </tr>
                <th colspan="3">
                <center> <input type="submit" value="Actualizar" action = "controllerManagedBean.validarObligatorio()"/></center>
                </th>
            </table>
        </form>
        <script>
            ${mensaje}
        </script>
        <br><br>
        <button onclick="location.href='Proveedores_opciones.jsp'">Regresar al inicio</button>
    </center>
    </body>
</html>
