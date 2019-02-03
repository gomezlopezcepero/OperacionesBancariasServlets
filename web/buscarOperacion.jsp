<%-- 
    Document   : buscarOperacion
    Created on : 13-may-2018, 18:55:54
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
        <form action="VerOperacion" method="POST">
            <table>
                <tr><td>Introduce el ID de la operación </td><td><input title="Elige un ID" type="text" name="id" required pattern="[0-9]{1,3}"></td></tr>
               <tr><td> <input type="submit" value="Login"></td></tr>

            </table>
        </form>
    </body>
</html>
