<%-- 
    Document   : login
    Created on : May 7, 2020, 1:00:45 PM
    Author     : Hui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="../Header/header.jsp"/>
        <form action="ProcessServlet" method="POST"> 
            Username: <input type="text" name="txtUsername" value=""/> <br/>
            Password:  <input type="password" name="txtPassword" value=""/> <br/>
            <input type="submit" value="Login" name="action"/> <br/>
            <input type="reset" value="reset"/> <br/>
            <input type="submit" value="Click here to sign up" name="btnAction"/> <br/>
            <input type="submit" value="Click here to buy something" name="btnAction"/> <br/>
        </form>
    </body>
</html>
