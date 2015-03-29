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
        <link rel="stylesheet" type="text/css" href="style/login.css">
        <title>Login Page</title>
    </head>
    <body>
        <form name="login" action="authlogin" method="POST">
            <h3>LOGIN</h3>
            <h5>EMAIL</h5>
            <input type="email" name="email" value="" placeholder="johnsmith@example.com" />
            <h5>PASSWORD</h5>
            <input type="password" name="password" value="" placeholder="Password" />
            <h5></h5>
            <input type="submit" value="Login" />
            <br>
            <input type="submit" formaction="register" value="Register"/>
            <jsp:useBean id="error" class="nz.ac.aut.bcis.chickenfarm.InfoMessage" scope="request"/>
            <h5><%=error.getMessage() %></h5>
        </form>
    </body>
</html>
