<%-- 
    Document   : entrarUsuario
    Created on : 10-may-2018, 19:29:36
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
        <form action="verificarUsuario" method="POST">
            <table>
                <tr><td>Introduce el DNI </td><td><input title="formato xxxxxxxxA" type="text" name="dni" required pattern="[0-9]{8}[A-Za-z]{1}"></td></tr>
                <tr><td>Introduce el número secreto</td><td> <input title="4 dígitos" type="text" name="numSecreto" required pattern="[0-9]{4}"></td></tr>
               <tr><td> <input type="submit" value="Login"></td></tr>

            </table>
        </form>
        
        
    </body>
</html>
