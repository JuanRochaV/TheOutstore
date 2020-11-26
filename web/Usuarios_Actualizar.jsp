<%-- 
    Document   : Usuarios_Actualizar
    Created on : 17/11/2020, 11:31:34 PM
    Author     : Juan Rocha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Usuarios</title>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Actualizar Usuarios</h1>
        
        <form  action = "Usuarios_Actualizar" method="POST">
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
                    <td>Usuario:</td>
                    <td><input type="text" name="usuario" value="" required="true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type="password" name="pass" value="" required="true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><input type="text" name="email" value="" required="true" /></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Ciudad:</td>
                    <td><input type="text" name="ciudad" value="" required="true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>RFC:</td>
                    <td><input type="text" name="rfc" value="" required="true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Tipo de Usuario:</td>
                    <td><select name="tipo" required="true">
                            <option value="Administrador">Administrador</option> 
                            <option value="Normal" selected>Cliente</option>
                        </select></td>
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
        <button onclick="location.href='Usuarios_opciones.jsp'">Regresar al inicio</button>
    </center>
    </body>
</html>
