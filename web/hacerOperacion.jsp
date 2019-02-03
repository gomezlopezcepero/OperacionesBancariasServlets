<%-- 
    Document   : hacerOperaciom
    Created on : 10-may-2018, 23:40:01
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
            form{
                text-align:left;
            }
            
        </style>
    </head>
    <body>
        
        
        <%
            
               HttpSession sesion = request.getSession();
               String dni= sesion.getAttribute("dni").toString();
            %>
        
        
        <h1 style="text-align:center;">Operaciones bancarias</h1>
        <hr>
        <form action="HacerOperacion" method="POST">
            
            <input type="radio" name="op" value="i"> Ingreso
            <input type="radio"  name="op" value="e"> Extracción<br><br>
            Introduce el número de la operación<br> <input type="number" name="ope"><br><br>
            <input type="hidden" value="<%=dni%>" name="dni">
            <input type="submit" value="hacer operación">
          
        </form>
        
        
    </body>
</html>
