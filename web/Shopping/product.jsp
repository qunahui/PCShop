<%-- 
    Document   : product
    Created on : May 25, 2020, 5:17:43 PM
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
            <c:set var="product" value="${requestScope.SEARCHRESULT}"/>
            <div class="content-container content-container__product">
                <div class="left-content">
                    <img src="${product[0].path}" style="width: 500px; height: 500px;">
                </div>
                <div class="right-content">
                        <h1 >${product[0].name}</h1>
                        <c:choose>
                            <c:when test="${product[0].discount > 0}">
                                <font color="#ccc"><s>${product[0].price}</s></font>
                                ${product[0].price*(1-product[0].discount/100)}
                            </c:when>
                            <c:otherwise>
                                ${product[0].price}
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
                            <p>
                                ${product[0].details}
                            </p> <br/>
                            <form action="MainController" method="POST">
                                <span>Qty</span> <input type="number" step="1" min="1" max="${product[0].quantityProduct}" name="txtProQuantity" value="1">
                                <input type="hidden" name="controller" value="AddCartController">
                                <input type="hidden" name="txtProID" value="${product[0].ID}">
                                <input type="hidden" name="txtProName" value="${product[0].name}">
                                <input type="hidden" name="txtProPrice" value="${product[0].price}">
                                <input type="hidden" name="txtProDiscount" value="${product[0].discount}">
                                <input type="hidden" name="txtProCategoryID" value="${product[0].categoryID}">
                                <button class="card--button__right" ${product[0].quantityProduct <= 0 ? 'disabled': ''}>Add to cart</button>
                            </form>
                </div>
            </div>
            <div>
                <h2>Description</h2>
                ${product[0].description}
            </div>
            <div>
                Leave your comment: 
                <form method="POST" action="MainController">
                    <textarea value="" type="text" name="txtUserComment">
                        
                    </textarea>
                    <input type="hidden" name="controller" value="AddCommentController"/>
                    <button type="submit">Add comment</button>
                </form>
            </div>
        </div>
    </body>
</html>
