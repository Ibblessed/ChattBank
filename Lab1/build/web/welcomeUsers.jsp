<%-- 
    Document   : welcomeUsers
    Created on : Jun 19, 2014, 8:01:22 PM
    Author     : Richard Davy
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
            <article><%= request.getAttribute("message")%></article>
            <article><a href = "<%= response.encodeURL(request.getContextPath()) + "/AccountServlet?action=view&id=" + session.getAttribute("id")%>">To View All Accounts Click Here:</a></article>
            <article>
                <a href = "AccountServlet?action=search&id=<%= session.getAttribute("id")%>">Or Click Here To Search Accounts Independently</a>
            </article>
        </div>
    </body>
</html>
