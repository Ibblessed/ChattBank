<%-- 
    Document   : login.jsp
    Created on : Jun 12, 2014, 2:58:15 PM
    Author     : AARONS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Member Login Page</title>
            <style>
                #memberLogin{
                    text-align: center;
                    font-family: sans-serif;
                }
                form, table{
                    margin-left: 325px;
                    font-family:sans-serif;
                }
                #memberForm{
                    vertical-align: middle;
                }
                #submit{
                    margin-left: 530px;
                }
                #image{
                    text-align: center;
                }
                #errorMessage{
                    text-align: center;
                    color: red;
                }
            </style>
            <script type="text/javascript">
//                function validateName(){
//                    var name = document.login.userName.value;
//                    var elem = document.getElementById("errorMessage");
//                    
//                    if (name === ""){
//                        alert("Please enter a User Name");
//                        changeAction("login.jsp");
//                    }
//                    if (isNaN(name)){
//                        alert("All user Names Are Comprised Of Numbers Please Try Again");
//                        changeAction("login.jsp");
//                    }else if (name < 3000 || name > 3999){
//                        alert("All User Names Are Between 3000 and 3999 Please Try Again");
//                        changeAction("login.jsp");
//                    }
//                }
//                
//                function validatePassword(){
//                    var pass = document.login.password.value;
//                    
//                    if (pass === ""){
//                        alert("Please enter a valid Password");
//                        changeAction("login.jsp");
//                    }
//                }
//                
//                function changeAction(webPage){
//                    document.login.action = webPage;
//                }
//                
//                function validate(){
//                    validateName();
//                    validatePassword();
//                }
            </script>
    </head>
    <body>
        <div id="image">
            <img src="images/bankimage.jpg" width="150" height="150">
        </div>
        <div id="memberLogin">
            <h3><u>Member Login Page</u></h3>
            <article>
                Welcome To Our Member Login Page!<br/>
                We Are Here To Serve YOU!!!<br />
                YOU are our driving force.
            </article><br/><br/>
        </div>
        <div id="memberForm">
            <h5 id = "errorMessage"><%= request.getAttribute("message") %></h5>
            <form method="post" name = "login" action="LoginServlet">
                <input type="hidden" name="action" value="doLogin" />
                <p id = "errorMessage"></p>
                <p id = "errormessage2"></p>
                <table width="5" cellspacing="5" cellpadding="2">
                    <thead>
                        <tr>
                            <th colspan="3">Login To Your Account</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>User Name</td>                        
                            <td colspan="2"><input type="text" name="id" value="<%= request.getAttribute("id")%>"  /></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="password" value="<%= request.getAttribute("password") %>" /></td>
                        </tr>
                    </tbody>
                </table>
                <table id="submit" width="2" cellspacing="2" cellpadding="2">
                    <tr>
                        <td id="button" ><input type="submit" value="Submit" name="submit" /></td>                        
                    </tr>
                    <tr>
                        <td id="button" ><input type="reset" value="Clear" name="reset" /></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>
