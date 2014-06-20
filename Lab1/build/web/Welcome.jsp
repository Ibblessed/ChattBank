<%-- 
    Document   : Welcome
    Created on : Jun 12, 2014, 2:01:05 PM
    Author     : Richard Davy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
         <style>
            #welcomeMessage{
                text-align: center;
                font-family: sans-serif;
                font-size: medium;
            }
        </style>
    </head>
    <body>
        <div id="welcomeMessage">
            <p>
                <img src="images/bankimage.jpg" width="250" height="250"/>
            </p>
            <h4>Welcome To Chatt Bank</h4>
            <article>
                &#x09;Welcome to Chatt Bank!<br /> We are pleased to have you as a Member.<br />
                To continue to our member login page please click the link below.
            </article>
            <p><a href ="LoginServlet?action=login">Member Login Page</a></p>
        </div>
        
    </body>
</html>
