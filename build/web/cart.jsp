<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View</title>
        <link rel="stylesheet" href="<c:url value="/css/landingPage.css" />">
        <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
        <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h1 class="text-center" style="color: #154055; margin-bottom: 50px;">Your cart includes :</h1>
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${cart.isEmpty() == false}">
            <div class="container">
                <table id="cart" class="table table-hover table-condensed">
                    <thead>
                        <tr>
                            <th style="width:45%;">Product</th>
                            <th style="width:15%;" class="text-center">Price</th>
                            <th style="width:15%;" class="text-center">Discount</th>
                            <th style="width:10%;">Quantity</th>
                            <th style="width:20%;" class="text-center">Subtotal</th>
                            <th style="width:10%;"></th>
                        </tr> 
                    </thead>
                    <tbody>
                            <c:forEach var="product" items="${cart.products}" varStatus="counter">
                                <c:set var="total" value="${total + product.value.getTotal()}" />
                                <tr>
                                    <td data-th="Product">
                                        <div class="row">
                                            <div class="col-sm-3 hidden-xs"> 
                                                <img src="${product.value.getPath()}" class="img-fluid"/>
                                            </div>
                                            <div class="col-sm-9">
                                                <h4 class="nomargin">${product.value.getName()}</h4>
                                                <p>${product.value.getDescription()}</p>
                                            </div>
                                        </div>
                                    </td>
                                    <td data-th="Price" class="text-center"><fmt:formatNumber type="number" maxFractionDigits="1" value="${product.value.getPrice()}" /></td>
                                    <td data-th="Discount" class="text-center" style="color: #bbb;"><fmt:formatNumber type="number" maxFractionDigits="1" value="${product.value.getDiscount()}" /> %</td>
                                    <td data-th="Quantity">
                                        <form action="MainController" method="POST">
                                            <input type="number" class="form-control text-center" value="${product.value.getQuantity()}" name="txtProQuantity" id="ProQuantity" readonly="true">
                                            <input type="hidden" name="txtProID" value="${product.value.getID()}"> </br>
                                            <div class="text-center">
                                                <button class="btn btn-outline-dark" type="submit" value="Update quantity minus" name="btnAction" ${product.value.getQuantity() == 1 ? 'disabled':''}><i class="fa fa-minus" aria-hidden="true"></i></button>
                                                <button class="btn btn-outline-dark" type="submit" value="Update quantity plus" name="btnAction"><i class="fa fa-plus" aria-hidden="true"></i></button>
                                                <input type="hidden" name="controller" value="UpdateCartController"/>
                                            </div>
                                    </form>
                                    </td>
                                    <td data-th="Subtotal" class="text-center"><fmt:formatNumber type="number" maxFractionDigits="5" value="${product.value.getTotal()}" /></td>
                                    <td class="actions" data-th="">
                                        <form action="MainController" method="POST">
                                            <button class="btn btn-danger btn-sm" type="submit" name="btnAction" value="Remove product"><i class="fa fa-trash-o"></i></button>								
                                            <input type="hidden" name="chkProduct" value="${product.value.getID()}"/>
                                            <input type="hidden" name="controller" value="UpdateCartController"/>
                                        </form>
                                    </td>
                                </tr> 
                           </c:forEach>
                    </tbody>       
                    <tfoot style="display">
                        <tr class="visible-xs">
                        </tr>
                        <tr>
                            <td><a href="/PCShop/ViewShopController" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
                            <td colspan="2" class="hidden-xs"></td>
                                    <td class="hidden-xs text-center">
                                        <strong>
                                            <fmt:formatNumber type="number" maxFractionDigits="5" value="${total}" />
                                        </strong>
                                    </td>
                            <td>
                                <form method="/PCShop/MainControler" method="POST">
                                    <button type="submit" value="Check Out"  ${cart.isEmpty() == true ? 'disabled':''}  class="btn btn-success btn-block"/>Checkout <i class="fa fa-angle-right"></i></button>
                                    <input type="hidden" name="controller" value="ViewCheckOutController"/>
                                </form>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </c:if>
        <c:if test="${cart.isEmpty() == true}">
            <div class="container text-center"> 
                <h2>Cart does not exists!!!!</h2>
            </div>
        </c:if>
    </body>
</html>
