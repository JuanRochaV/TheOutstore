<%-- 
    Document   : Clientes_Eliminar
    Created on : 17/11/2020, 10:29:41 PM
    Author     : Juan Rocha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Cliente</title>
    </head>
    <body style="background-color:#33ffca;">
    <center>
        <h1>Eliminar Cliente</h1>
        
        <form action="Clientes_Eliminar" method="POST">
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
                <center><input type="submit" value="Eliminar" action = "controllerManagedBean.validarObligatorio()"/></center>
                </th>   
            </table>
        </form>
        <script>
            ${mensaje}
        </script>
        <br><br>
        <button onclick="location.href='Clientes_opciones.jsp'">Regresar al inicio</button>
    </center>
    </body>
</html>
