<%-- 
    Document   : accountLookup
    Created on : Jun 12, 2014, 3:56:53 PM
    Author     : Richard Davy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.ChattBank.business.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Lookup Account</title>
            <style>
                #image{
                    text-align: center;
                }
                #acctForm{
                    margin-left: auto;
                    margin-right: auto;
                }
                #acctTable{
                    margin-left: auto;
                    margin-right: auto;
                }
                #submitTable{
                    margin-left: auto;
                    margin-right: auto;
                }
                table{
                    margin-right: auto;
                    margin-left: auto;
                }
            </style>
            <script type="text/javascript">
                function validateAccount() {
                    var acctNum = document.acctSearch.acctNumber.value;

                    if (isNaN(acctNum)) {
                        alert("Sorry The Account Number Seems To Be Invalid");
                        changeAction("accountLookup.jsp");
                    } else if (acctNum < 90000 || acctNum > 99999) {
                        alert("Sorry The Account Number Seems To Be Invalid");
                        changeAction("accountLookup.jsp");
                    }
                }
                function changeAction(webPage) {
                    document.acctSearch.action = webPage;
                }
            </script>
    </head>
    <body>
        <div id="image">
            <img src="images/bankimage.jpg"/>
        </div>

        <form name="acctSearch" action="AccountLookupServlet?action=getAcct" method="POST" onsubmit="validateAccount();">
            <table id="acctTable" border="0" width="5" cellspacing="5" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="3">Please select the account you are looking for:</th>                           
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Customer Account Number</td>
                        <td><select name="accountNo">
                                <option value=""></option>

                                <c:forEach var="account" items="${acctList}">

                                    <option value="${account.acctNo}">Account: ${account.acctNo} Balance: ${account.balance}</option>

                                </c:forEach>

                            </select></td>
                    </tr>
                    <tr>
                        <form method="post" action="AccountLookupServlet">
                        <td></td>
                        <td></td>
                        <td><input type="submit" value="Submit" /></td>
                        </form>
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
                    <td><a href="AccountServlet?action=view&id=${customer.custId}">View All Accounts</a></td>
                    <td><a href="ManageAccounts?action=manage&id=${customer.custId}">Manage Accounts</a></td>
                    <td><a href="Logout?action=logout">Log Out</a></td>
                </tr>
            </tbody>
        </table>        
            </div>
    </body>
</html>
