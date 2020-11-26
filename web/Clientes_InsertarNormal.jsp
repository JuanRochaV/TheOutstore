<%-- 
    Document   : Cliente_InsertarNormal
    Created on : 17/11/2020, 10:22:45 PM
    Author     : Juan Rocha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Cliente</title>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Insertar Cliente</h1>
        
        <form  action = "Clientes_InsertarNormal" method="POST">
            <table>
                <%--Clave <input type="text" name="clave" value="" required="true"/><br>--%>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" value="" required="true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><input type="text" name="email" value="" required="true"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Ciudad:</td>
                    <td><input type="text" name="ciudad" value="" required="true" /></td>
                    <td></td>
                </tr>
                <tr>
                    <td>RFC</td>
                    <td><input type="text" name="rfc" value="" required="true"/></td>
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
        <button onclick="location.href='Clientes_opcionesNormal.jsp'">Regresar al inicio</button>
    </center>
    </body>
</html>
