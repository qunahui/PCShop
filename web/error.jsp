<%-- 
    Document   : error.jsp
    Created on : May 19, 2020, 2:58:41 PM
    Author     : Hui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1 style="text-align: center">
            <img src="/PCShop/assets/gif/error.gif" alt=""/>
            <br/>
            <font color="red">
            ${requestScope.ERROR}
            </font>
        </h1>
    </body>
</html>
