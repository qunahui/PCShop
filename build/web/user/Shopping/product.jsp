<%-- 
    Document   : product
    Created on : May 23, 2020, 4:05:54 PM
    Author     : Hui
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
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
            <h1>Hello this is product Page!</h1>
            <c:set var="product" value="${requestScope.SEARCHRESULT}"/>
            <div class="content-container content-container__product">
                <div class="left-content">
                    <img src="${product[0].path}" style="width: 500px; height: 500px;">
                </div>
                <div class="right-content">
                    <h1>${product[0].name}</h1>
                    <c:choose>
                        <c:when test="${product[0].discount >= 1}">
                            <span><s>${product[0].price}</s></span>
                            <c:set var="priceDiscounted" value="${product[0].price * (1 - product[0].discount/100)}"/>
                            <span>${priceDiscounted}</span>
                        </c:when>    
                        <c:otherwise>
                            <span>${product[0].price}</span>
                        </c:otherwise>
                    </c:choose>
                    <br />
                    <p>Availability: <c:choose>
                            <c:when test="${product[0].quantityProduct > 0}">
                                <font color="green">${product[0].quantityProduct} in stock</font>
                            </c:when>
                            <c:otherwise>
                                <font color="red">Out of stock</font>
                            </c:otherwise>
                        </c:choose>
                    </p>
                    <p>${product[0].details}</p>
                    <span>Qty</span> <input type="number" step="1" min="1" max="${product[0].quantityProduct}" placeholder="1">
                    <button>Add to cart</button>
                </div>
            </div>
            <div>
                <h2>Description</h2>
                <p>${product[0].description}</p>
            </div>
        </div>
    </body>
</html>
