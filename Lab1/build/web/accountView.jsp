<%-- 
    Document   : accountView
    Created on : Jul 2, 2014, 2:41:10 AM
    Author     : Richard Davy
--%>

<%@page import="com.ChattBank.business.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                table{
                    margin-left: auto;
                    margin-right: auto;
                }
                h4{
                    text-align: center;
                }
            </style>
    </head>
    <body>
        <div id = "image">
            <img src="images/bankimage.jpg" />
        </div>
        <h4>Here Is The Account You Requested</h4>
        <table border="1" width="75%" cellspacing="5" cellpadding="2">
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
                    <td colspan="2">${account.custId}</td>
                    <td colspan="2">${account.acctNo}</td>
                    <td colspan="2">${account.acctType}</td>
                    <td colspan="2">${account.balance}</td>
                </tr>
            </tbody>
        </table>
                <table width="50%" cellspacing="5" cellpadding="2">
            <thead>
                <tr>

                    <td></td>
                    <td>Click Here To Navigate To A New Page</td>
                    <td></td>

                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><a href="AccountServlet?action=search&id=${customer.custId}">Search Single Account</a></td>
                    <td><a href="ManageAccounts?action=manage&id=${customer.custId}">Manage Accounts</a></td>
                    <td><a href="Logout?action=logout">Log Out</a></td>
                </tr>
            </tbody>
        </table>        
    </body>
</html>
