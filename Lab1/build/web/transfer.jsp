<%-- 
    Document   : transfer
    Created on : Jul 8, 2014, 9:47:32 AM
    Author     : Richard Davy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer Funds</title>
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
            <div id="image">
                <img src="images/bankimage.jpg"></img>
            </div>
            <div id="accounts">
                <p>${message}</p>
                <form method="POST" action="Transfer?id=${customer.custId}">

                    <table>

                        <thead>
                            <tr>
                                <td></td>
                                <td colspan="3">Please Select Accounts To Transfer From And To</td>
                                <td></td>
                            </tr>                      
                        </thead>

                        <tbody>
                            <tr>
                                <td></td>
                                <td>Transfer From:</td>
                                <td colspan="2">
                                    <select name="from">
                                        <option value=""></option>

                                        <c:forEach var="account" items="${acctList}">
                                            <option value="${account.acctNo}">Account: ${account.acctNo} Balance: ${account.balance}</option>
                                        </c:forEach>    

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>Transfer To:</td>
                                <td colspan="2">
                                    <select name="to">
                                        <option value=""></option>

                                        <c:forEach var="account" items="${acctList}">
                                            <option value="${account.acctNo}">Account: ${account.acctNo} Balance: ${account.balance}</option>
                                        </c:forEach>    

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>How Much: </td>
                                <td colspan="2">

                                    <input name="tranAmt" type="text" value="" />

                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><input type="submit" value="Submit"></td>
                            </tr>

                        </tbody>

                    </table>

                </form>
                <br/><br/>
                <br/><br/>

                <article>
                    <p>To Navigate From This Page Select One Of The Links Below</p>
                    <p>
                        <a href="AccountServlet?action=view&id=${customer.custId}">View All Accounts</a>&Tab;&Tab;&Tab;
                        <a href="ManageAccounts?action=manage&id=${customer.custId}">Manage Accounts</a>&Tab;&Tab;&Tab;
                        <a href="Logout?action=logout">Log Out</a>
                    </p>
                </article>
            </div>
        </div>
    </body>
</html>
