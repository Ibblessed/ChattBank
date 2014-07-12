<%-- 
    Document   : newAccount
    Created on : Jul 11, 2014, 2:46:59 PM
    Author     : AARONS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start A New Account</title>
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
        <div id='content'>
            <article>
                <img src="images/bankimage.jpg">
            </article>
            <h4><i>Start Your New Account Today<i></h4>
                        <article>
                            Thank you for choosing ChattBank as your place of monetary<br/>
                            entrustment. We look forward to giving you the service you deserve<br/>
                            and can't wait to call you a friend. To get started fill out the form<br/>
                            below.
                        </article>
                        <form name="newAccount" method="POST" action="NewAccount">
                            <table border="0" width="5" cellspacing="5" cellpadding="2">
                                <thead>
                                    <tr>
                                        <th colspan="3">Account Information</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td colspan="2">Account Type:</td>
                                        <td>
                                            <select name="type">
                                                <option value='CHK'>Checking</option>
                                                <option value='SAV'>Savings</option>
                                                <option value='MMA'>Money Market</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">Starting Balance:</td>
                                        <td><input name="balance" type="text" value=""/></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"></td>
                                        <td><input type="submit" value="Submit"/></td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                        <article>
                            <p>Click Here To Navigate To A New Page</p>

                            <p><a href="AccountServlet?action=search&id=${customer.custId}">Search Single Account</a>&Tab;&Tab;&Tab;
                                <a href="AccountServlet?action=view&id=${customer.custId}">View All Accounts</a>&Tab;&Tab;&Tab;
                                <a href="ManageAccounts?action=manage&id=${customer.custId}">Manage Accounts</a>&Tab;&Tab;&Tab;
                                <a href="Logout?action=logout">Log Out</a></p>
                        </article>

        </div>
    </body>
</html>
