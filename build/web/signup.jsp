<%-- 
    Document   : signup
    Created on : 26/03/2015, 5:47:18 PM
    Author     : guy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
    </head>
       <form name="login" action="createuser" method="POST">
                <h2>Sign up</h2>
            <h3>EMAIL</h3>
            <input type="email" name="email" value="" placeholder="johnsmith@example.com" />
            <h3>PASSWORD</h3>
            <input type="password" name="password" value="" placeholder="Password" />
            <input type="submit" value="" />
        </form>
</html>
