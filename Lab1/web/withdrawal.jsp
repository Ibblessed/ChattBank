<%-- 
    Document   : withdrawal
    Created on : Jul 7, 2014, 10:54:53 PM
    Author     : AARONS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile Withdrawal</title>
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
                <p>${message}</p>
                <br/><br/>
                <br/><br/>
                <table width="50%">
                    <form name="deposit" method="post" action="Withdrawal?action=withdraw&id=${customer.custId}">
                        <thead>
                            <tr>
                                <td>Please Select An Account To Withdraw From</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Select An Account:

                                    <select name="acctNo">
                                        <option value=""></option>

                                        <c:forEach var="account" items="${acctList}">
                                            <option value="${account.acctNo}">Account: ${account.acctNo} Balance: ${account.balance}</option>
                                        </c:forEach>                                
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Specify An Amount: <input type="text" value="" name="withAmt" /></td>                                
                            </tr>
                            <tr>
                                <td><input type="submit" value="submit" /></td>
                            </tr>
                        </tbody>
                    </form>
                </table>
            </article>
                        
            <br/><br/>
            <br/><br/>
            
            <article>
                <p>To Navigate From This Page Select One Of The Links Below</p>
                <p>
                    <a href="AccountServlet?action=view&id=${customer.custId}">View All Accounts</a>&Tab;&Tab;&Tab;
                    <a href="ManageAccounts?action=manage&id=${customer.custId}">Manage Accounts</a>&Tab;&Tab;&Tab;
                    <td><a href="Logout?action=logout">Log Out</a></td>
                </p>
            </article>
            
        </div>
    </body>
</html>
