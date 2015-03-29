<%-- 
    Document   : index.jsp
    Created on : Mar 28, 2015, 2:11:39 PM
    Author     : Guy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="userdata" class="nz.ac.aut.bcis.chickenfarm.UserData" scope="session"/>
<!DOCTYPE html>
<html onclick="addItem(event);">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/index.css">
        <title>ChickenFarm</title>
    </head>
    <body onload="load();">
        <h1>Welcome back to Chicken Farm, <%= userdata.getEmail() %></h1>
        <form name="info" method="POST" action="addChicken">
        </form>
    </body>
    
    <script>
        function load()
        {        
             
            var types = <%= userdata.getArrayOfTypes() %>;
            var xLocs = <%= userdata.getArrayOfXLocs() %>;
            var yLocs = <%= userdata.getArrayOfYLocs() %>;
            
            for(var i = 0; i < types.length; i++)
            {
                 addItemImage(xLocs[i], yLocs[i], types[i])   
            }
        }

        function addItemImage(x, y, type)
        {
            var img = document.createElement("img");
            img.setAttribute("style", "position: absolute; top:" + y + "px; left:" + x +"px; width:50px; height:50px");
            img.setAttribute("src", "images/"+type+".jpg");
            document.body.appendChild(img);
        }
        
        function addItem(event)
        {
            var x = event.clientX - 25;
            var y = event.clientY - 25;
            
            var p1 = document.createElement("input");
            p1.setAttribute("type", "hidden");
            p1.setAttribute("name", "xLoc");
            p1.setAttribute("value", x);
            document.info.appendChild(p1);
            
            var p2 = document.createElement("input");
            p2.setAttribute("type", "hidden");
            p2.setAttribute("name", "yLoc");
            p2.setAttribute("value", y);
            document.info.appendChild(p2);
            
            var p3 = document.createElement("input");
            p3.setAttribute("type", "hidden");
            p3.setAttribute("name", "type");
            p3.setAttribute("value", "CHICKEN");
            document.info.appendChild(p3);
            
            document.info.submit();
        }
    </script>
</html>
