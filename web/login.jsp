<%-- 
    Document   : index
    Created on : 23/03/2015, 5:06:54 PM
    Author     : Guy Langford-lee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/style.css">
        <title>Login Page</title>
       
        
    </head>
    <body>
        <form name="login" action="authlogin" method="POST">
            <h2>LOGIN</h2>
            <h3>EMAIL</h3>
            <input type="email" name="email" value="" placeholder="johnsmith@example.com" />
            <h3>PASSWORD</h3>
            <input type="password" name="password" value="" placeholder="Password" />
            <input type="submit" value="" />
            <jsp:useBean id="error" class="nz.ac.aut.bcis.chickenfarm.InfoMessage" scope="request"/>
            <h5><%=error.getMessage() %></h5>
        </form>
    </body>
</html>
