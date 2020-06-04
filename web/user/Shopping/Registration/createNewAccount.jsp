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
    </head>
    <body>
        <h2>Create new account</h2>
        <form action="ProcessServlet" method="POST">
            Username* <input type="text" name="txtUsername" value="${param.txtUsername}"/> (6-20 characters) <br/> 
            <c:set var="errors" value="${requestScope.INSERTERR}"/>
            <c:if test="${not empty errors.usernameLengthErr}">
                <font color="red">
                    ${errors.usernameLengthErr}
                </font><br/>
            </c:if>
            Password* <input type="password" name="txtPassword" value=""/> (6-30 characters) <br/> 
            <c:if test="${not empty errors.passwordLengthErr}">
                <font color="red">
                    ${errors.passwordLengthErr}
                </font><br/>
            </c:if>
            Confirm <input type="password" name="txtConfirm" value=""/> (6-20 characters) <br/> 
            <c:if test="${not empty errors.confirmNotMatch}">
                <font color="red">
                    ${errors.confirmNotMatch}
                </font><br/>
            </c:if>
            Last name* <input type="text" name="txtLastname" value="${param.txtLastname}"/> (2-50 characters) <br/> 
            <c:if test="${not empty errors.lastnameLengthErr}">
                <font color="red">
                    ${errors.lastnameLengthErr}
                </font><br/>
            </c:if>
            First name* <input type="text" name="txtFirstname" value="${param.txtFirstname}"/> (2-50 characters) <br/> 
            <c:if test="${not empty errors.firstnameLengthErr}">
                <font color="red">
                    ${errors.firstnameLengthErr}
                </font><br/>
            </c:if>
            Phone* <input type="number" name="txtPhone" value="${param.txtPhone}"/> (10 numbers) <br/> 
            <c:if test="${not empty errors.phoneLengthErr}">
                <font color="red">
                    ${errors.phoneLengthErr}
                </font><br/>
            </c:if>
            Address* <input type="text" name="txtAddress" value="${param.txtAddress}"/> (2-50 characters) <br/> 
            <c:if test="${not empty errors.addressLengthErr}">
                <font color="red">
                    ${errors.addressLengthErr}
                </font><br/>
            </c:if>
            
            <input type="submit" value="Create New Account" name="btnAction" />
            <input type="reset" value="Reset"/>
        </form><br/>
        <c:if test="${not empty errors.usernameIsExist}">
            <font color="red">
                ${errors.usernameIsExist}
            </font><br/>
        </c:if>
    </body>
</html>