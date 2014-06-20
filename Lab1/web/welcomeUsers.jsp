<%-- 
    Document   : welcomeUsers
    Created on : Jun 19, 2014, 8:01:22 PM
    Author     : AARONS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome User</title>
        <link rel="stylesheet" href="chattBank.css" type="text/css">
    </head>
    <body>
        <div id = "image">
            <img src="images/bankimage.jpg" />
        </div>
        <div id = "userText">
            <article><%= request.getAttribute("message") %></article>
            <article><a href = "AccountServlet?action=search">To Search Accounts Click Here:</a></article>
        </div>
    </body>
</html>
