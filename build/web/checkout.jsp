<%-- 
    Document   : checkout
    Created on : May 27, 2020, 3:21:08 PM
    Author     : Hui
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
        <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
    </head>
    <body>
       <jsp:include page="header.jsp"/>
       <br/><br/>
       <h1 class="text-center">Check out Page</h1>
<!--       <form action="MainController" method="POST">
           <input type="submit" value="Confirm"/>
           <input type="hidden" name="controller" value="ConfirmCheckOutController"/>
       </form>-->
       <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
       <c:set var="cart" value="${sessionScope.CART}"/>
       <div class="container">
        <div class="row">
          <div class="col-md-7 order-md-1">
            <h4 class="mb-3">Billing address</h4>
            <form class="needs-validation" novalidate>
              <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="firstName">
                        First name
                    </label>
                  <input type="text" class="form-control" id="firstName" name="txtFirstname" placeholder="" value="${result.firstname}" required>
                </div>
                <div class="col-md-6 mb-3">
                  <label for="lastName">Last name</label>
                  <input type="text" class="form-control" id="lastName" placeholder="" name="txtLastname" value="${result.lastname}" required>
                </div>
              </div>
              <div class="mb-3">
                <label for="email">Email <span class="text-muted">(Optional)</span></label>
                <input type="email" class="form-control" id="email" placeholder="you@example.com" name="txtMail" value="">
              </div>
              <div class="mb-3">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" name="txtAddress" value="${result.address}" placeholder="1234 Main St" required>
              </div>
              <div class="mb-3">
                <label for="address">Phone</label>
                <input type="text" class="form-control" id="phone" name="txtPhone" value="${result.phone}" placeholder="01234567890" required>
              </div>
              <hr class="mb-4">
              <div class="mb-3">
                  <label for="note">Note <span class="text-muted">(Optional)</span></label>
                  <textarea type="text" class="form-control" id="phone" name="txtNote" value="" placeholder="Note something....."></textarea>
              </div>
              <hr class="mb-4">
              <br/>
              <input type="hidden" name="controller" value="ConfirmCheckOutController"/>
              <button class="btn btn-primary btn-lg btn-block" type="submit">Confirm</button>
            </form>
          </div>
            <div class="col-md-5 order-md-2 mb-4">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
              <span class="text-muted">Your cart</span>
              <span class="badge badge-secondary badge-pill">${cart.getLength()}</span>
            </h4>
            <ul class="list-group mb-3">
                <c:forEach var="product" items="${cart.products}" varStatus="counter">
                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <c:set var="total" value="${total + product.value.getTotal()}" />
                        <div class="col-md-6">
                          <h6 class="my-0">${product.value.getName()}</h6>
                          <small class="text-muted">${product.value.getDescription()}</small>
                        </div>
                        <div class="col-md-2">
                            <span class="my-0">x${product.value.getQuantity()}</span>
                        </div>
                        <span class="text-muted"><fmt:formatNumber type="number" maxFractionDigits="1" value="${product.value.getTotal()}" /></span>
                    </li>
                </c:forEach>
                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <div class="col-md-6">
                          <h6 class="my-0">Total (VND): </h6>
                        </div>
                        <span class="text-muted"><fmt:formatNumber type="number" maxFractionDigits="1" value="${total}" /></span>
                    </li>
            </ul>

            <form class="card p-2">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Promo code">
                <div class="input-group-append">
                  <button type="submit" class="btn btn-secondary">Redeem</button>
                </div>
              </div>
            </form>
          </div>
        </div>
        <br/>
        <br/>
        <br/>
        <footer class="my-5 pt-5 text-muted text-center text-small">
          <p class="mb-1">&copy; 2017-2019 Company Name</p>
          <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
          </ul>
        </footer>
      </div>
    </body>
</html>
