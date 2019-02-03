<%-- 
    Document   : usuario
    Created on : 10-may-2018, 20:51:52
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
        <h1 style="text-align:center;">Bienvenido a la cuenta bancaria <span style="color:red"><%=dni.toString()%></span></h1>
    
    <form action="DispatchSelectUser" method="POST">
    <select name="selec">
        <option value="1">1- Modificar datos del propietario</option>
        <option  value="2">2- Cambiar número secreto</option>
        <option  value="3">3- Eliminar cuenta bancaria</option>
        <option  value="4">4- Hacer una operación bancaria</option>
        <option  value="5">5- Ver mis operaciones bancarias</option>
        <option  value="6">6- Ver fecha de mi último inicio de sesión</option>
        <option  value="7">7- Ver mi posición en el ranking de cuentas</option>
    </select>
        <input type="hidden" name="dni" value="<%=dni%>">
        <input type="submit" name="enviar" value="Entrar">
    </form><br>
        <a href="index.jsp">Volver al menú principal</a>
        
        
    </body>
</html>
