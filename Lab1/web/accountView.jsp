<%-- 
    Document   : accountView
    Created on : Jul 2, 2014, 2:41:10 AM
    Author     : Richard Davy
--%>

<%@page import="com.ChattBank.business.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Account</title>
        <link rel="stylesheet" href="chattBank.css" type="text/css">
        <style>
                #image{
                    text-align: center;
                }
                #acctForm{
                    text-align: center;
                }
                #acctTable{
                    margin-left: 645px;
                }
                #submitTable{
                    margin-left: 755px;
                }
            </style>
    </head>
    <body>
        <div id = "image">
            <img src="images/bankimage.jpg" />
        </div>
        <h1>Here Is The Account You Requested</h1>
        <%
            Account acct = (Account) session.getAttribute("account");
        %>
        
        <table border="1" width="2" cellspacing="5" cellpadding="2">
            <thead>
                <tr>
                    <th colspan="10">Your Chatt Accounts</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td colspan="2"></td>
                    <td colspan="2">Customer Id</td>
                    <td colspan="2">Account Number</td>
                    <td colspan="2">Account Type</td>
                    <td colspan="2">Account Balance</td>
                </tr>
                <tr>
                    <td colspan="2">Account: </td>
                    <td colspan="2"><%= acct.getCustId()%></td>
                    <td colspan="2"><%= acct.getAcctNo()%></td>
                    <td colspan="2"><%= acct.getAcctType()%></td>
                    <td colspan="2"><%= acct.getBalance()%></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
