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
        <link rel="stylesheet" href=<c:url value="/css/landingPage.css" /> />
        <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
</head>
    <body>
        <jsp:include page="../header.jsp" />
         <c:if test="${not empty param.cboProduct}">
            <p>
                Search results for <c:out value="${param.cboProduct}"/>
            </p>
        </c:if>
        <form class="form-inline container justify-content-center align-items-center" action="MainController" method="GET" >
            <div class="form-group mx-sm-3 mb-2">
              <label style="margin-right: 10px;">Choose your accessories: </label>
              <input type="text" class="form-control" placeholder="Search...." name="searchByName" value="${requestScope.SEARCHBYNAME}" id="nameSearch"/>
            </div>
              <button class="btn btn-outline-success mb-2" type="submit" value="Search product" name="btnAction" id="submit">Search</button>
           <div class="form-group mb-2 mx-sm-3">
                <select name="searchByCategory" id="CategorySelect" class="custom-select">
                    <option value="" ${requestScope.SEARCHBYCATEGORY == null ? 'selected':''}></option>
                    <option value="RAM" ${requestScope.SEARCHBYCATEGORY == 'RAM' ? 'selected':''}>RAM</option>
                    <option value="SSD" ${requestScope.SEARCHBYCATEGORY == 'SSD' ? 'selected':''}>SSD</option>
                    <option value="HDD" ${requestScope.SEARCHBYCATEGORY == 'HDD' ? 'selected':''}>HDD</option>
                </select>
            </div>
            <div class="form-group mb-2 mx-sm-3">
                <select name="sortBy" id="SortSelect" class="custom-select">
                    <option value="sortByDate" ${requestScope.OPTIONSELECTED == null ? 'selected':''} ${requestScope.OPTIONSELECTED == 'sortByDate' ? 'selected':''}>Search by date</option>
                    <option value="sortByPriceASC" ${requestScope.OPTIONSELECTED == 'sortByPriceASC' ? 'selected':''}>Search by price (low to high)</option>
                    <option value="sortByPriceDESC" ${requestScope.OPTIONSELECTED == 'sortByPriceDESC' ? 'selected':''}>Search by price (high to low)</option>
                </select>
            </div>
            <input type="hidden" name="controller" value="ViewShopController"/>
            <input type="hidden" name="action" id="searchAction"/>
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
                        <button class="card--button__left">View details</button>
                    </form>
                    <form action="MainController" method="POST">
                        <input type="hidden" name="controller" value="AddCartController">
                        <input type="hidden" name="txtProID" value="${product.ID}">
                        <input type="hidden" name="txtProName" value="${product.name}">
                        <input type="hidden" name="txtProPrice" value="${product.price}">
                        <input type="hidden" name="txtProDiscount" value="${product.discount}">
                        <input type="hidden" name="txtProCategoryID" value="${product.categoryID}">
                        <input type="hidden" name="txtProDescription" value="${product.description}">
                        <input type="hidden" name="txtProPath" value="${product.path}">
                        <input type="hidden" name="txtProQuantity" value="1">
                        <c:choose>
                            <c:when test="${product.quantityProduct > 0}">
                                <button class="card--button__right">Add to cart</button>
                            </c:when>
                            <c:otherwise>
                                <button class="card--button__right card--button__danger" disabled >Out of stock</button>
                            </c:otherwise>
                        </c:choose>
                    </form>
                </li>
            </c:forEach>
        </ul>
    </body>
    <script>
        let input = document.getElementById("submit");
        let sortSel = document.getElementById("SortSelect");
        let catSel = document.getElementById("CategorySelect");
        let searchAction = document.getElementById("searchAction");
        let nameSearch = document.getElementById("nameSearch");
        sortSel.onchange = function(){
            if(catSel.value !== "") {
                searchAction.value= "categorySearch";
            } else {
                searchAction.value = "nameSearch";
            }
            input.click();
        }
        catSel.onchange = function(){
            searchAction.value = "categorySearch";
            nameSearch.value = "";
            input.click();
            console.log("changed");
        }
        nameSearch.onfocus = function () {
            searchAction.value = "nameSearch";
            catSel[0].selected = 'selected';
        }
    </script>
</html>
