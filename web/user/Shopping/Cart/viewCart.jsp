<%-- 
    Document   : viewCart
    Created on : May 4, 2020, 2:40:13 PM
    Author     : Hui
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View</title>
    </head>
    <body>
        <jsp:include page="../Header/header.jsp"/>
        <h1>Your cart includes!</h1>
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${not empty cart}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr> 
                </thead>
                <tbody>
                <form action="ProcessServlet">
                    <c:forEach var="product" items="${cart.products}" varStatus="counter">
                        <tr>
                            <td>
                                ${counter.count}
                            .</td>
                            <td>
                                ${product.value.getName()}
                            </td>
                            <td>
                                ${product.value.getDescription()}
                            </td>
                            <td>
                                ${product.value.getPrice()}
                            </td>
                            <td>
                                ${product.value.getQuantity()}
                            </td>
                        </tr>
                    </c:forEach>
                        <tr>
                            <td colspan="3">
                                <a href="shopping.html">Add more items to your cart</a>
                            </td>
                            <td>
                                <input type="submit" value="Remove selected products" name="btnAction"/>
                            </td>
                        </tr>
                </form>
                </tbody>              
            </table>
        </c:if>
        <c:if test="${empty cart}">
            <h2>Cart does not exists!!!!</h2>
        </c:if>
    </body>
</html>
