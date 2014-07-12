<%-- 
    Document   : welcomeUsers
    Created on : Jun 19, 2014, 8:01:22 PM
    Author     : Richard Davy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <article>${message}</article>
            <article><a href = "AccountServlet?action=view&id=${customer.custId}">To View All Accounts Click Here:</a></article>
            <article>
                <a href = "AccountServlet?action=search&id=${customer.custId}">Or Click Here To Search Accounts Independently</a>
            </article>
            <br/><br/>
            <article><i>New Customer... Then You Need A New Account!</i></article>
            <p><a href='newAccount.jsp'>Click Here</a></p>
        </div>
    </body>
</html>
