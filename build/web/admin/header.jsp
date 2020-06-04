<%-- 
    Document   : header.jsp
    Created on : May 19, 2020, 3:07:34 PM
    Author     : Hui
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"/>
</head>

<body>
    <div class="header">
        <div class="header-top">
            <div>
                <a href="/PCShop/admin/ViewLandingPageController">
                    <img src="/PCShop/assets/Logo.png" id="logo" class="logo" />
                </a>
            </div>
            <div>
                <a class="navLink" href="/PCShop/admin/ViewAccountController">Accounts</a>
                <a class="navLink" href="/PCShop/admin/ViewShopController">Products</a>
                <a class="navLink" href="/PCShop/admin/ViewOrdersController">Orders</a>
            </div>  
            <div>
                <form action="/PCShop/MainController" method="POST">
                    <input type="hidden" id="currentURL" name="currentURL" />
                    <input type="hidden" name="controller" value="Logging" />
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