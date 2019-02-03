<%-- 
    Document   : insertarCuenta
    Created on : 10-may-2018, 18:53:56
    Author     : Paco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   <style>
            
            *{
                text-align:center;
                
                
            }
            
            td{
                text-align:left;
            }
            
            tr{
                    height:50px;
                }
            
        </style>
    </head>
    <body>
        
        
        
        <h1 style="text-align:center;">Operaciones bancarias</h1>
        <hr>
        <form action="insertarCuenta" method="POST">
            <table>
                <tr><td>Introduce el número de cuenta</td><td> <input title="formato xxxx-xxxx-xxxx-xxxx" type="text" name="numCuenta" required pattern="[0-9]{4}[-]{1}[0-9]{4}[-]{1}[0-9]{4}[-]{1}[0-9]{4}"></td></tr>
                <tr><td>Introduce el DNI </td><td><input title="formato xxxxxxxxA" type="text" name="dni" required pattern="[0-9]{8}[A-Za-z]{1}"></td></tr>
                <tr><td>Introduce el Nombre de usuario</td><td><input title="de 3 a 15 letras o dígitos" type="text" required name="usuario" pattern="[A-Za-z0-9]{3,15}"></td></tr>
                <tr><td>Introduce el número secreto</td><td> <input title="4 dígitos" type="text" name="numSecreto" required pattern="[0-9]{4}"></td></tr>
                <tr><td>Introduce el Nombre</td><td><input type="text" name="nombre" required pattern="[A-Za-z]{3,15}"></td></tr>
                <tr><td>Introduce el primer apellido</td><td><input title="de 3 a 15 letras" type="text" name="primerApellido" required pattern="[A-Za-z]{3,15}"></td></tr>
                <tr><td>Introduce el segundo apellido</td><td><input title="de 3 a 15 letras" type="text" name="segundoApellido" required pattern="[A-Za-z]{3,15}"></td></tr>
                <tr><td> <input type="submit" value="insertar"></td></tr>

            </table>
        </form>
        
    </body>
</html>
