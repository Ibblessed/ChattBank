<%-- 
    Document   : manageAccounts
    Created on : Jul 3, 2014, 4:26:51 PM
    Author     : AARONS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Your Accounts</title>
        <style>
            #content{
                text-align: center;
            }
            table{
                margin-left: auto;
                margin-right: auto;
            }
        </style>
    </head>
    <body>
        <div id="content">
            <div id = "image">
                <img src="images/bankimage.jpg" />
            </div>
            <article>
                Here You Can Select In Which Way You<br/> Like To Manage Your Accounts<br/>You Can:<br/><br/><br/>
                <a href="ManageAccounts?action=Deposit&id=${customer.custId}">Deposit To An Account</a><br/>
                <a href="ManageAccounts?action=Withdraw&id=${customer.custId}">Withdraw From An Account</a><br/>
                <a href="ManageAccounts?action=Transfer&id=${customer.custId}">Or Transfer funds</a><br/><br/><br/>
                Thank You For Being A Customer!
            </article>
            
            <br/><br/>
            <br/><br/>
            
            <article>
            
                    <p>Click Here To Navigate To A New Page</p>
              
                    <a href="AccountServlet?action=view">View All Accounts</a>&Tab;&Tab;&Tab;<a href="Logout?action=logout">Log Out</a>
                    
                      
            </article>
        </div>    
    </body>
</html>
