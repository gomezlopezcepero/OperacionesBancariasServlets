<%-- 
    Document   : modificarClave
    Created on : 10-may-2018, 23:36:32
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
     <form action="modificarClave" method="POST">
            <table>
                 <tr><td>Introduce el nuevo número secreto</td><td> <input title="4 dígitos" type="text" name="numSecreto" required pattern="[0-9]{4}"></td></tr>
                 <tr><td> <input type="submit" value="Modificar"></td><td><input type="hidden" name="dni" value="<%=dni%>"</td> </tr>
            </table>
        </form>
        

    </body>
</html>
