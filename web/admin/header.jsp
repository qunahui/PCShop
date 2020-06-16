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
        <link rel="stylesheet" href=<c:url value="/css/bootstrap-config.css"/> />
    <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
    <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"/>
    <script type="text/javascript" src="/PCShop/js/jquery-3.5.1.slim.min.js"></script>
    <script type="text/javascript" src="/PCShop/js/jquery.validate.js"></script>
    <script type="text/javascript" src="/PCShop/js/additional-methods.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top text-white" style="padding-top: 0; padding-bottom: 0;">
        <a href="/PCShop/ViewLandingPageController" class="navbar-brand">
            <img src="/PCShop/assets/Logo.png" style="min-width: 100px; min-height: 100px;" id="logo" class="logo" />
        </a>
        <div class="collapse navbar-collapse justify-content-center align-items-center" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="navbar-brand active" style="margin-left: 15px;">
                      <a class="nav-link" href="/PCShop/admin/ViewAccountController">Accounts</a>
                    </li>
                    <li class="navbar-brand active" style="margin-left: 15px;">
                      <a class="nav-link" href="/PCShop/admin/ViewShopController">Products</a>
                    </li>
                    <li class="navbar-brand active" style="margin-left: 15px;">
                      <a class="nav-link" href="/PCShop/admin/ViewOrdersController">Orders</a>
                    </li>
                </ul>
            <c:if test="${not empty sessionScope.USERNAME}">
                <form method="POST" action="/PCShop/MainController">
                    <button class="btn btn-outline-light my-2 my-sm-0" type="submit" name="btnAction" value="Logout"><i class="fa fa-sign-out" aria-hidden="true"></i></button>
                    <input type="hidden" name="controller" value="Logging"/>
                </form>
          </c:if>
        </div>
    </nav>
    <div style="height: 110px;"></div>
</body>

</html>