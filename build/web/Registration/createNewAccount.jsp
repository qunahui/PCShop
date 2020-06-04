<%-- 
    Document   : createNewAccount
    Created on : May 2, 2020, 3:01:48 PM
    Author     : Hui
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New Account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:url value="/css/landingPage.css" />">
        <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
        <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
        <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
    </head>
    <body>
        <jsp:include page="../header.jsp" /> 
        <script type="text/javascript" src="/PCShop/js/jquery.js"></script>
        <script type="text/javascript" src="/PCShop/js/jquery.validate.js"></script>
        <script type="text/javascript" src="/PCShop/js/additional-methods.js"></script>
        <h2>Create new account</h2>
        <form action="MainController" method="POST" id="addAccountForm">
            Username* <input type="text" name="txtUsername" value="${param.txtUsername}"/> (6-20 characters) <br/> 
            Password* <input type="password" name="txtPassword" value=""/> (6-30 characters) <br/> 
            Confirm <input type="password" name="txtConfirm" value=""/> (6-20 characters) <br/> 
            Last name* <input type="text" name="txtLastname" value="${param.txtLastname}"/> (2-50 characters) <br/> 
            First name* <input type="text" name="txtFirstname" value="${param.txtFirstname}"/> (2-50 characters) <br/> 
            Phone* <input type="number" name="txtPhone" value="${param.txtPhone}"/> (10 numbers) <br/> 
            Address* <input type="text" name="txtAddress" value="${param.txtAddress}"/> (2-50 characters) <br/> 
            
            <input type="submit" value="Create New Account" name="action" />
            <input type="hidden" name="controller" value="AddAccountController" />
            <input type="reset" value="Reset"/>
        </form><br/>
        <c:if test="${not empty requestScope.REGISTERERROR}">
            <font color="red">
                ${requestScope.REGISTERERROR}
            </font><br/>
        </c:if>
        <script>
            $(function() {
                $("#addAccountForm").validate({
                    rules: {
                       txtUsername: {
                           required: true,
                           rangelength: [6,20]
                       },
                       txtPassword: {
                           required: true,
                           rangelength: [6,30]
                       },
                       txtConfirm: {
                           equalTo: "#txtPassword"
                       },
                       txtLastname: {
                           required: true,
                           rangelength: [2,50]
                       },
                       txtFirstname: {
                           required: true,
                           rangelength: [2,50]
                       },
                       txtPhone: {
                           required: true,
                           length: [0]
                       },
                       txtAddress: {
                           required: true,
                           rangelength: [2,50]
                       }
                   }
                })
            });
        </script>
    </body>
</html>