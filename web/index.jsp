<%-- 
    Document   : index
    Created on : 17/05/2020, 12:47:19 AM
    Author     : juan_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto individual</title>
    </head>
    <center>
    <body style="background-color:#33ffca;">
        <h1 style="color:#FF0000"><FONT FACE="Algerian" SIZE="6">Login del sistema</h1>
        <img src="img/Videojuegos.jpg" id="miImagen">
        <form action="MyLogin">
            <table>
                <tr>
                    <td><FONT FACE="Bodoni Bk BT" SIZE="3">Usuario</td>
                    <td><input type="text" name="userin"></td>
                </tr>
                <tr>
                    <td><FONT FACE="Bodoni Bk BT" SIZE="3">Contraseña</td>
                    <td><input type="password" name="passwordin"></td>
                </tr>
                <th colspan="2"><input type="submit" value="Ingresar..."></th>
            </table>
        </form>
        <script>
            ${mensaje}
        </script>
    </center>
    </body>
</html>
