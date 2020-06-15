<%-- 
    Document   : shopping
    Created on : May 5, 2020, 11:29:49 AM
    Author     : Hui
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <div style="margin-top: 20px;"></div>
        <div class="container justify-content-center align-items-center"> 
                <form class="form-inline float-left" action="ViewShopController" method="GET" >        
                    <div class="form-group mx-sm-3 mb-2">
                      <label style="margin-right: 10px;">Choose your accessories: </label>
                      <input type="text" class="form-control" placeholder="Search...." name="searchByName" value="${requestScope.SEARCHBYNAME ? requestScope.SEARCHBYNAME : null}"/>
                    </div>
                      <button class="btn btn-outline-success mb-2" type="submit" id="submit">Search</button>
                </form>
                <form class="form-inline float-left" action="ViewShopController" method="GET" >       
                   <div class="form-group mb-2 mx-sm-3">
                        <label style="margin-right: 10px;">Category: </label>
                        <select name="searchByCategory" id="CategorySelect" class="custom-select">
                            <option value="" ${requestScope.SEARCHBYCATEGORY == null ? 'selected':''}></option>
                            <option value="RAM" ${requestScope.SEARCHBYCATEGORY == 'RAM' ? 'selected':''}>RAM</option>
                            <option value="SSD" ${requestScope.SEARCHBYCATEGORY == 'SSD' ? 'selected':''}>SSD</option>
                            <option value="HDD" ${requestScope.SEARCHBYCATEGORY == 'HDD' ? 'selected':''}>HDD</option>
                            <option value="CPU" ${requestScope.SEARCHBYCATEGORY == 'CPU' ? 'selected':''}>CPU</option>
                            <option value="GPU" ${requestScope.SEARCHBYCATEGORY == 'GPU' ? 'selected':''}>GPU</option>
                            <option value="MAINBOARD" ${requestScope.SEARCHBYCATEGORY == 'MAINBOARD' ? 'selected':''}>MAINBOARD</option>
                        </select>
                        <input type="submit" style="display: none;" id="SelectSubmit"/>
                    </div>
                </form>
                <form class="form-inline" action="ViewShopController" method="GET" >
                    <div class="form-group mb-2 mx-sm-3">
                        <select name="sortBy" id="SortSelect" class="custom-select">
                            <option value="sortByDate" ${requestScope.OPTIONSELECTED == null ? 'selected':''} ${requestScope.OPTIONSELECTED == 'sortByDate' ? 'selected':''}>Search by date</option>
                            <option value="sortByPriceASC" ${requestScope.OPTIONSELECTED == 'sortByPriceASC' ? 'selected':''}>Search by price (low to high)</option>
                            <option value="sortByPriceDESC" ${requestScope.OPTIONSELECTED == 'sortByPriceDESC' ? 'selected':''}>Search by price (high to low)</option>
                        </select>
                        <input type="submit" style="display: none;" id="SortSubmit"/>
                    </div>
                </form>
        </div>
        <div class="container-fluid">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
            <c:forEach items="${result}" var="product">
                <div class="col-12 col-sm-8 col-md-6 col-lg-3 float-left">
                    <a class="text-decoration-none text-dark" href=<c:out value="/PCShop/MainController?controller=ViewProductController&pk=${product.getID()}" />>
                    <div class="card" style="height: 550px; margin-bottom: 30px;">
                      <img class="card-img" src="${product.getPath()}" alt="product" style="width: 350px; height: 350px;">
                      <div class="card-body">
                        <div style="height:  85px;">
                              <h4 class="card-title">${product.getName()}</h4>
                        </div>
                        <div class="buy d-flex justify-content-between align-items-center" style="margin-top: 10px;">
                            <c:choose>
                                <c:when test="${product.getDiscount() > 0}"> 
                                        <h5 class="mt-4"><s><fmt:formatNumber type="number" maxFractionDigits="1" value="${product.getPrice()}" /></s></h5>
                                    <div class="price text-danger">
                                        <h5 class="mt-4"><fmt:formatNumber type="number" maxFractionDigits="1" value="${product.getPrice()*(1-product.getDiscount()/100)}" /></h5>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="price text-danger">
                                        <h5 class="mt-4"><fmt:formatNumber type="number" maxFractionDigits="1" value="${product.getPrice()}" /></h5>
                                    </div>
                                </c:otherwise>
                            </c:choose>
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
                                        <button class="btn btn-success mt-3">Add to cart</button>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="btn btn-danger mt-3" disabled >Out of stock</button>
                                    </c:otherwise>
                                </c:choose>
                            </form>
                      </div>
                    </div>
                  </div>
                <a/>
            </div>
            </c:forEach>
        </div>
    </body>
    <script>
        let SelectSubmit = document.getElementById("SelectSubmit");
        let SortSubmit = document.getElementById("SortSubmit");
        let sortSel = document.getElementById("SortSelect");
        let catSel = document.getElementById("CategorySelect");
        catSel.onchange = function() {
            SelectSubmit.click();
        }
        sortSel.onchange = function() {
            insertParam("sortBy",sortSel.value);
        }
        function insertParam(key, value) {
            key = encodeURIComponent(key);
            value = encodeURIComponent(value);

            // kvp looks like ['key1=value1', 'key2=value2', ...]
            var kvp = document.location.search.substr(1).split('&');
            let i=0;

            for(; i<kvp.length; i++){
                if (kvp[i].startsWith(key + '=')) {
                    let pair = kvp[i].split('=');
                    pair[1] = value;
                    kvp[i] = pair.join('=');
                    break;
                }
            }

            if(i >= kvp.length){
                kvp[kvp.length] = [key,value].join('=');
            }

            // can return this or...
            let params = kvp.join('&');

            // reload page with new params
            document.location.search = params;
        }
    </script>
</html>
