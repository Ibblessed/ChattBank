<%-- 
    Document   : accountLookup
    Created on : Jun 12, 2014, 3:56:53 PM
    Author     : AARONS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                text-align: center;
            }
            #acctTable{
                margin-left: 645px;
            }
            #submitTable{
                margin-left: 755px;
            }
        </style>
        <script type="text/javascript">
            function validateAccount(){
                var acctNum = document.acctSearch.acctNumber.value;
                
                if (isNaN(acctNum)){
                    alert("Sorry The Account Number Seems To Be Invalid");
                    changeAction("accountLookup.jsp");
                }else if(acctNum < 90000 || acctNum > 99999){
                    alert("Sorry The Account Number Seems To Be Invalid");
                    changeAction("accountLookup.jsp");
                }
            }
            function changeAction(webPage){
                    document.acctSearch.action = webPage;
            }
        </script>
    </head>
    <body>
        <div id="image">
            <img src="images/bankimage.jpg"/>
        </div>
        <div id="acctForm">
            <form name="acctSearch" action="AccountServlet" method="POST" onsubmit="validateAccount();">
                <table id="acctTable" border="0" width="5" cellspacing="5" cellpadding="5">
                    <thead>
                        <tr>
                            <th colspan="3">Please enter the account you are looking for:</th>                           
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Account Number</td>
                            <td><input type="number" name="acctNumber" value="" size="25" /></td>
                        </tr>
                        <tr>
                            <td>Customer I.D.</td>
                            <td><input type="text" name="custID" value="" size="25" /></td>
                        </tr>
                        <tr>
                            <td>Type</td>
                            <td><input type="text" name="type" value="" size="25" /></td>
                        </tr>
                        <tr>
                            <td>Balance</td>
                            <td><input type="text" name="balance" value="" size="25" /></td>
                        </tr>
                    </tbody>
                </table>
                <table id="submitTable" border="0" width="5" cellspacing="5" cellpadding="5">
                    <tr>
                        <td><input type="submit" value="Search" name="submit" /></td>
                        <td><input type="reset" value="Clear" name="reset" /></td>                              
                    </tr>
                </table>

            </form>
        </div>
    </body>
</html>
