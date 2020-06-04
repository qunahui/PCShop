<%-- 
    Document   : header.jsp
    Created on : May 19, 2020, 3:07:34 PM
    Author     : Hui
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>

</head>

<body>
    <div class="header">
        <div class="header-top">
            <div>
                <img src="/PCShop/assets/Logo.png" id="logo" class="logo" />
            </div>
            <div>
                <a class="navLink" href="/PCShop/admin/ViewAccountController">Accounts</a>
                <a class="navLink" href="/PCShop/admin/ViewShopController">Shopping</a>
            </div>  
            <div>
                <form action="/PCShop/MainController" method="POST">
                    <input type="hidden" id="currentURL" name="currentURL" />
                    <p id="welcome-text">
                        Welcome,
                        <c:out value="${sessionScope.USERNAME != null ? sessionScope.USERNAME : 'Anonymous'}" />
                        <c:if test="${sessionScope.USERNAME != null}">
                            <input type="submit" value="Logout" name="btnAction">
                        </c:if>
                    </p>
                    <c:if test="${sessionScope.USERNAME == null}">
                        Username: <input type="text" name="txtUsername" value="" placeholder="user" />
                        Password: <input type="password" name="txtPassword" value="" placeholder="user" />
                        <input type="submit" value="Login" name="btnAction">
                        <input type="submit" value="Register" name="btnAction">
                        <button type="submit" value="View your cart" name="btnAction"><i class="fa fa-shopping-cart" aria-hidden="true"></i></button>
                    </c:if>
                </form>
            </div>
        </div>
        </div>
    </div>
</body>
<script type="text/javascript">
    document.getElementById('currentURL').value = window.location.href;
</script>

</html>