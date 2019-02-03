<%-- 
    Document   : index
    Created on : 10-may-2018, 17:53:45
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
            
        </style>
    </head>
    <body>
        
        
        
        <h1 style="text-align:center;">Operaciones bancarias</h1>
        <hr>
    <h3>Elige una opción</h3>
    <form action="DispatchSelect" method="POST">
    <select name="selec">
        <option value="1">1- Insertar una nueva cuenta bancaria</option>
        <option  value="2">2- Entrar en una cuenta bancaria</option>
        <option  value="3">3- Lista de todas las operaciones bancarias</option>
        <option  value="4">4- Lista de operaciones bancarias que han generado números rojos</option>
        <option  value="5">5- Ranking de cuentas en números rojos</option>
        <option  value="6">6- Obtener operación bancaria a partir de su ID</option>
    </select>
        <input type="submit" name="enviar" value="Enviar" />
    </form>

    
    </body>
</html>
