<%-- 
    Document   : index.jsp
    Created on : Mar 28, 2015, 2:11:39 PM
    Author     : Guy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="userdata" class="nz.ac.aut.bcis.chickenfarm.UserData" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chicken farm</title>
    </head>
    <body>
        <h1><%=userdata.getEmail() %>, Welcome back to Chicken Farm </h1>
    </body>
</html>
