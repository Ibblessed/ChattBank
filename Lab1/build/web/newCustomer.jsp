<%-- 
    Document   : newCustomer
    Created on : Jul 11, 2014, 4:39:05 PM
    Author     : AARONS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Become A Member</title>
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
                <img src="images/bankimage.jpg" />
            </article>
            
            <p>${message}</p>
            
            <form name="newCustomer" method="POST" action="NewCustomer">
                <table border="0" width="5" cellspacing="5" cellpadding="2">
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                            <th>Enter Your Information</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td colspan="2">Select A Password:</td>
                            <td><input type="password" name="password1" value="" size="15" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">Re-Enter Password:</td>
                            <td><input type="password" name="password2" value="" size="15" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">First Name:</td>
                            <td><input type="text" name="firstName" value="" size="15" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">Last Name:</td>
                            <td><input type="text" name="lastName" value="" size="15" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">Address:</td>
                            <td><input type="text" name="address" value="" size="15" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">Email:</td>
                            <td><input type="text" name="email" value="" size="15" /></td>
                        </tr>
                        <tr>
                            <td colspan="2"></td>
                            <td><input type="submit" value="Submit" /></td>
                        </tr>
                    </tbody>
                </table>

            </form>
        </div>
    </body>
</html>
