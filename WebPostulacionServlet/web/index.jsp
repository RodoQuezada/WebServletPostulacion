<%-- 
    Document   : index
    Created on : 02-sep-2017, 15:42:50
    Author     : rodo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Postulacion</title>
    </head>
    <body>
        <h1> Formulario de postulacion </h1>
        <form action="postular.do" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="nombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Edad: </td>
                        <td><input type="number" name="edad" value="" /> </td>
                    </tr>
                    <tr>
                        <td>Clave: </td>
                        <td><input type="password" name="clave" value="" /></td>
                    </tr>
                    <tr>
                        <td>Confirmar Clave: </td>
                        <td><input type="password" name="clave2" value="" /></td>
                    </tr>
                    <tr>
                        <td>Estado Civil: </td>
                        <td>
                            <input type="radio" name="estado" value="soltero" checked="checked" />Soltero
                            <input type="radio" name="estado" value="casado"  />Casado
                        </td>
                    </tr>
                    <tr>
                        <td>Sexo: </td>
                        <td>
                            <input type="radio" name="sexo" value="mujer" checked="checked" />Mujer
                            <input type="radio" name="sexo"  value="hombre"  />Hombre
                        </td>
                    </tr>
                    <tr>
                        <td>Pais: </td>
                        <td>
                            <select name="pais">
                                <option value="0">Tu pais?</option>
                                <option>Chile</option>
                                <option>Argentina</option>
                                <option>Bolivia</option>
                            </select>    
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Enviar" name="enviar" /></td>
                    </tr>
                </tbody>
            </table>
        </form> 
        <%
            String error = (String) request.getAttribute("error");
            String ok = (String) request.getAttribute("ok");

            if (error != null) {
                out.println(error);
            }
            if (ok != null) {
                out.println(ok);
            }
        %>
    </body>
</html>
