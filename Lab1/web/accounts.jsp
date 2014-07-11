<%-- 
    Document   : accounts
    Created on : Jun 25, 2014, 12:24:38 AM
    Author     : Richard Davy
--%>
<%@page import="com.ChattBank.business.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Accounts</title>
        <style>

            table{
                margin-left: auto;
                margin-right: auto;
            }
            #image, h4, p{
                text-align: center;
            }

        </style>
    </head>
    <body>
        <div id = "image">
            <img src="images/bankimage.jpg" />
        </div>

        <h4>Here Are Your Accounts</h4>
        <table border="1" width="75%" cellspacing="5" cellpadding="2">
            <thead>
                <tr>
                    <th colspan="15">Your Chatt Accounts</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td colspan="3"></td>
                    <td colspan="3">Customer Id</td>
                    <td colspan="3">Account Number</td>
                    <td colspan="3">Account Type</td>
                    <td colspan="3">Account Balance</td>
                </tr>

                <c:forEach var="account" items="${acctList}">

                    <tr>
                        <td colspan="3">Account: </td>
                        <td colspan="3">${account.acctNo}</td>
                        <td colspan="3">${account.custId}</td>
                        <td colspan="3">${account.acctType}</td>
                        <td colspan="3">${account.balance}</td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
        <p>Thank you for your business!</p><br/><br/>
                <article>
                    <p>Click Here To Navigate To A New Page</p>
                 
                    <p><a href="AccountServlet?action=search&id=${customer.custId}">Search Single Account</a>&Tab;&Tab;&Tab;
                    <a href="ManageAccounts?action=manage&id=${customer.custId}">Manage Accounts</a>&Tab;&Tab;&Tab;
                    <a href="Logout?action=logout">Log Out</a></p>
                </article>        

    </body>
</html>
