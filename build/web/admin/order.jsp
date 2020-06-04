<%-- 
    Document   : order.jsp
    Created on : May 30, 2020, 10:15:54 AM
    Author     : Hui
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="<c:url value="/css/landingPage.css" />">
    <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
    <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
    <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
    <body>
        <jsp:include page="header.jsp" />
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse justify-content-center align-items-center" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                  <a class="nav-item nav-link <c:if test="${empty param.action || param.action == 'Unconfirmed'}">active</c:if>" href="/PCShop/admin/ViewOrdersController?action=Unconfirmed"><h4>Unconfimred</h4></a>
                  <a class="nav-item nav-link <c:if test="${param.action == 'On process'}">active</c:if>" href="/PCShop/admin/ViewOrdersController?action=On+process"><h4>On process</h4></a>
                  <a class="nav-item nav-link <c:if test="${param.action == 'Deliveried'}">active</c:if>" href="/PCShop/admin/ViewOrdersController?action=Deliveried"><h4>Deliveried</h4></a>
                  <a class="nav-item nav-link <c:if test="${param.action == 'Deleted'}">active</c:if>" href="/PCShop/admin/ViewOrdersController?action=Deleted"><h4>Deleted</h4></a>
              </div>
            </div>
        </nav>
        <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
        <table class="table table-bordered container-fluid">
            <thead class="thead-dark">
              <tr>
                <th scope="col">#</th>
                <th scope="col">Customer ID</th>
                <th scope="col">Customer Name</th>
                <th scope="col">Customer Phone</th>
                <th scope="col">Customer Address</th>
                <th scope="col">Note</th>
                <th scope="col">Order date</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${result}">
                    <tr>
                        <th scope="row" style="width: 10%">${order.getID()}</th>
                        <td style="width: 10%">
                            <c:choose>
                                <c:when test='${!order.getCustomerID().equals("")}'>
                                    ${order.getCustomerID()}
                                </c:when>
                                <c:otherwise>
                                    guess
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td style="width: 10%">${order.getCustomerName()}</td>
                        <td style="width: 10%">${order.getCustomerPhone()}</td>
                        <td>${order.getCustomerAddress()}</td>
                        <td>${order.getNote()}</td>
                        <td>${order.getOrderDate()}</td>
                        <td  style="width: 10%">
                            <c:choose>
                                <c:when test="${order.getStatus() == 1}">
                                    <form method="POST" action="MainController">
                                        <input type="hidden" name="controller" value="UpdateOrderController"/>
                                        <input type="hidden" name="lastURL" value="${requestScope['javax.servlet.forward.query_string']}"/>
                                        <input type="hidden" name="orderStatus" value="${order.getStatus()}"/>
                                        <input type="hidden" name="pk" value="${order.getID()}"/>
                                        <button type="submit" class="btn btn-outline-success" name="btnAction" value="Next step order"><i class="fa fa-check" aria-hidden="true"></i></button>
                                        <button type="submit" class="btn btn-outline-danger" name="btnAction" value="Delete order"><i class="fa fa-trash" aria-hidden="true"></i></button>
                                    </form>
                                </c:when>
                                <c:when test="${order.getStatus() == 2}">
                                    <form method="POST" action="MainController">
                                        <input type="hidden" name="pk" value="${order.getID()}"/>
                                        <input type="hidden" name="controller" value="UpdateOrderController"/>
                                        <input type="hidden" name="orderStatus" value="${order.getStatus()}"/>
                                        <input type="hidden" name="lastURL" value="${requestScope['javax.servlet.forward.query_string']}"/>
                                        <button type="submit" class="btn btn-outline-success" name="btnAction" value="Next step order"><i class="fa fa-check" aria-hidden="true"></i></button>
                                        <button type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#orderModal_<c:out value='${order.getID()}'/>" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                                        <button type="submit" class="btn btn-outline-danger" name="btnAction" value="Delete order"><i class="fa fa-trash" aria-hidden="true"></i></button>
                                    </form>
                                </c:when>
                                <c:when test="${order.getStatus() == 3}">
                                    <form method="POST" action="MainController">
                                        <input type="hidden" name="pk" value="${order.getID()}"/>
                                        <input type="hidden" name="controller" value="UpdateOrderController"/>
                                        <input type="hidden" name="orderStatus" value="${order.getStatus()}"/>
                                        <input type="hidden" name="lastURL" value="${requestScope['javax.servlet.forward.query_string']}"/>
                                        <button type="submit" class="btn btn-outline-danger" name="btnAction" value="Delete order"><i class="fa fa-trash" aria-hidden="true"></i></button>
                                    </form>
                                </c:when>
                                <c:when test="${order.isDeleted() == true}">
                                    <form method="POST" action="MainController">
                                        <input type="hidden" name="pk" value="${order.getID()}"/>
                                        <input type="hidden" name="controller" value="UpdateOrderController"/>
                                        <input type="hidden" name="lastURL" value="${requestScope['javax.servlet.forward.query_string']}"/>
                                        <button type="submit" class="btn btn-outline-info" name="btnAction" value="Restore order"><i class="fa fa-undo" aria-hidden="true"></i></button>
                                    </form>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                    <div class="modal fade" id="<c:out value='orderModal_${order.getID()}'/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                     <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Edit order #${order.getID()}</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                                </button>
                        </div>
                        <form action="MainController" method="POST">       
                        <div class="modal-body">
                                <div class="form-group">
                                  <label for="" class="col-form-label">Customer Name: </label>
                                  <input type="text" class="form-control" id="customer-name" name="txtCustomerName" value="${order.getCustomerName()}" required> 
                                </div>
                                <div class="form-group">
                                  <label for="recipient-name" class="col-form-label">Customer Phone: </label>
                                  <input type="text" class="form-control" id="customer-phone" name="txtCustomerPhone" value="${order.getCustomerPhone()}" required>
                                </div>
                                <div class="form-group">
                                  <label for="recipient-name" class="col-form-label">Customer Address: </label>
                                  <input type="text" class="form-control" id="customer-address" name="txtCustomerAddress" value="${order.getCustomerAddress()}" required>
                                </div>
                                <div class="form-group">
                                  <label for="recipient-name" class="col-form-label">Note: </label>
                                  <input type="text" class="form-control" id="note" name="txtNote" value="${order.getNote()}" required>
                                </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary" name="btnAction" value="Update order">Update</button>
                                </div>
                                <input type="hidden" name="lastURL" value="${requestScope['javax.servlet.forward.query_string']}"/>
                                <input type="hidden" name="controller" value="UpdateOrderController"/>
                                <input type="hidden" name="pk" value="${order.getID()}"/>
                        </form>
                    </div>
                  </div>
                </div>
                </c:forEach>
            </tbody>
          </table>
    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</html>
