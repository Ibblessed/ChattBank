<%-- 
    Document   : accounts
    Created on : Jun 25, 2014, 12:24:38 AM
    Author     : Richard Davy
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ChattBank.business.Account"%>
<%@page import="com.ChattBank.business.Accounts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Accounts</title>
        
    </head>
    <body>
        <div id = "image">
            <img src="images/bankimage.jpg" />
        </div>
        <%
            ArrayList<Account> list = new ArrayList();

            list.addAll((ArrayList) session.getAttribute("acctList"));
        %>

        <h4>Here Are Your Accounts</h4>
        <table border="1" width="2" cellspacing="5" cellpadding="2">
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
                <% for (int i = 0; i < list.size(); i++) {%>
                <tr>
                    <td colspan="3">Account: </td>
                    <td colspan="3"><%= list.get(i).getCustId()%></td>
                    <td colspan="3"><%= list.get(i).getAcctNo()%></td>
                    <td colspan="3"><%= list.get(i).getAcctType()%></td>
                    <td colspan="3"><%= list.get(i).getBalance()%></td>
                </tr>
                <% } %>
                <% list.clear();%>
            </tbody>
        </table>
        <p>Thank you for your business!</p>

    </body>
</html>
