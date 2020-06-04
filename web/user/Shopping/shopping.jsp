<%-- 
    Document   : shopping
    Created on : May 5, 2020, 11:29:49 AM
    Author     : Hui
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
        <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
        <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
        <link rel="stylesheet" href=<c:url value="/css/shopping.css" /> />
        <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
</head>

<body>
    <jsp:include page="../header.jsp" />
    <form action="MainController">
        <input type="submit" value="Add product">
        <input type="hidden" name="controller" value="ViewAddProductController"/>
    </form>
    <form action="MainController">
        <select name="sortBy" id="ProductSelect">
            <option value="sortByDate" ${requestScope.OPTIONSELECTED == null ? 'selected':''} ${requestScope.OPTIONSELECTED == 'sortByDate' ? 'selected':''}>Search by date</option>
            <option value="sortByPriceASC" ${requestScope.OPTIONSELECTED == 'sortByPriceASC' ? 'selected':''}>Search by price (low to high)</option>
            <option value="sortByPriceDESC" ${requestScope.OPTIONSELECTED == 'sortByPriceDESC' ? 'selected':''}>Search by price (high to low)</option>
        </select>
        <input type="hidden" name="controller" value="ViewShopController"/>
        <input type="submit" style="display:none;" id="submit">
    </form>
    <ul class="list-card row">
        <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
        <c:forEach items="${result}" var="product">
            <li class="card column">
                <img src="${product.path}" class="card--image">
                <h1 class="card--title">${product.name}</h1>
                <p class="card--price">${product.price}</p>
                <div class="card--description">${product.description}</div>
                <form action="MainController" method="POST">
                    <input type="hidden" name="controller" value="ViewProductController">
                    <input type="hidden" name="pk" value="${product.ID}">
                    <button class="card--button">Edit Product</button>
                </form>
            </li>
        </c:forEach>
    </ul>
</body>
<script>
    let input = document.getElementById("submit");
    let sel = document.getElementById("ProductSelect");
    sel.onchange = function(){
        input.click();
    }
</script>
</html>