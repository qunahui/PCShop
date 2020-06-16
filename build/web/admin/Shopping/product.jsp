<%-- 
    Document   : product
    Created on : May 23, 2020, 4:05:54 PM
    Author     : Hui
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
        <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
        <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
    </head>
    <body>
        <jsp:include page="../header.jsp" />
        <div class="content-container">
            <c:set var="product" value="${requestScope.SEARCHRESULT}"/>
            <div class="content-container content-container__product">
                <div class="left-content">
                    <img src="${product[0].path}" style="width: 500px; height: 500px;">
                </div>
                <div class="right-content">
                    <form name="addForm" action="MainController" id="addForm" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="txtProID" value="${product[0].ID}">
                            <input style="width: 100%; height:30px; font-size: 30px; margin-bottom: 20px;" type="text" name="txtProName" value="${product[0].name}">
                            Category ID: <input style="width: 100%; height: 20px; font-size: 20px; margin-bottom: 20px;" type="text" name="txtProCategoryID" value="${product[0].categoryID}">
                            Price: <input style="width: 100%; height: 20px; font-size: 20px; margin-bottom: 20px;" type="text" name="txtProPrice" value="${product[0].price}">
                            Discount (%): <input style="width: 100%; height: 20px; font-size: 20px; margin-bottom: 20px;" type="text" name="txtProDiscount" value="${product[0].discount}">
                            <br />
                            <p>Availability: <c:choose>
                                    <c:when test="${product[0].quantityProduct > 0}">
                                        <font color="green"><input style=" width: 80px; height: 20px; font-size:20px; margin-bottom: 20px;" type="text" value="${product[0].quantityProduct}"> in stock</font>
                                    </c:when>
                                    <c:otherwise>
                                        <font color="red">Out of stock</font>
                                    </c:otherwise>
                                </c:choose>
                            </p>
                            <textarea style="width: 100%; height: 300px; font-size: 20px; margin-bottom: 20px; text-align: left; align-items: tart;" type="text" name="txtProDetails">${product[0].details}</textarea>
                            <span>Qty</span> <input type="number" step="1" min="1" max="${product[0].quantityProduct}" name="txtProQuantity" placeholder="1">
                            <h2>Description</h2>
                         <textarea style="width: 100%; height: 300px; font-size: 20px; margin-bottom: 20px; text-align: left; align-items: tart;" type="text" name="txtProDescription">${product[0].description}</textarea>
                         <input type="hidden" name="controller" value="EditProductController">
                         <input type="submit" name="action" value="Edit product"/>
                         <input type="submit" name="action" value="Delete product"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
