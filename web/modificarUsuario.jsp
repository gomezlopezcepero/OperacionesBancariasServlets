<%-- 
    Document   : modificarUsuario
    Created on : 10-may-2018, 23:34:50
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
        
        <%
            
               HttpSession sesion = request.getSession();
               String dni= sesion.getAttribute("dni").toString();


            %>
        
        <h1 style="text-align:center;">Operaciones bancarias</h1>
        <hr>
        
        <form action="modificarUsuario" method="POST">
            <table>
                <tr><td>Introduce el Nombre</td><td><input type="text" name="nombre" required pattern="[A-Za-z]{3,15}"></td></tr>
                <tr><td>Introduce el primer apellido</td><td><input title="de 3 a 15 letras" type="text" name="primerApellido" required pattern="[A-Za-z]{3,15}"></td></tr>
                <tr><td>Introduce el segundo apellido</td><td><input title="de 3 a 15 letras" type="text" name="segundoApellido" required pattern="[A-Za-z]{3,15}"></td></tr>
                <tr><td> <input type="submit" value="modificar"></td><td><input type="hidden" name="dni" value="<%=dni%>"></td></tr>

            </table>
        </form>
        
    </body>
</html>
