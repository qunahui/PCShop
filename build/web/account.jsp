<%-- 
    Document   : account
    Created on : May 28, 2020, 3:14:15 PM
    Author     : Hui
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div style="height: 50px;"></div>
        <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
        <c:set var="orders" value="${requestScope.ORDERS}"/>
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="text-center">
                      <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar rounded-circle img-thumbnail" alt="avatar"> <br/> <br/>
                      <h6>Upload a different photo...</h6>
                      <input type="file" class="text-center center-block file-upload" style="display: none;">
                    </div></hr><br>
                    
                    <ul class="list-group">
                        <li class="list-group-item text-muted">Activity <i class="fa fa-dashboard fa-1x"></i></li>
                        <li class="list-group-item text-right"><span class="pull-left"><strong>Orders</strong></span> 1</li>
                        <li class="list-group-item text-right"><span class="pull-left"><strong>Cmt</strong></span> 2</li>
                    </ul> 
                </div>
                <div class="col-sm-9">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                          <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Profile</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Orders</a>
                        </li>
                    </ul> <br/> <br/>
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <form class="container" method="POST" action="MainController">
                                <div class="form-row">
                                  <div class="col">
                                        <label>First name</label>
                                    <input type="text" name="txtFirstname" class="form-control" placeholder="First name" value="${result.getFirstname()}">
                                  </div>
                                  <div class="col">
                                        <label>Last name</label>
                                    <input type="text" name="txtLastname" class="form-control" placeholder="Last name" value="${result.getLastname()}">
                                  </div>
                                </div> <br/>
                                <div class="form-row">
                                  <div class="col">
                                        <label>Phone</label>
                                    <input type="text" name="txtPhone" class="form-control" placeholder="Phone" value="${result.getPhone()}">
                                  </div>
                                  <div class="col">
                                        <label>Address</label>
                                    <input type="text" name="txtAddress" class="form-control" placeholder="Address" value="${result.getAddress()}">
                                  </div>
                                </div> <br/>
                                <div class="form-row">
                                    <div class="col">
                                        <label>Mail </label>
                                        <input type="text" name="txtMail" class="form-control" placeholder="Mail" value="${result.getMail()}" disabled>
                                    </div>
                                </div> <br/>
                                <input type="hidden" name="action" value="Change info"/>
                                <input type="hidden" name="controller" value="UpdateAccountController">
                                <button type="submit" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i> Save</button>
                            </form>
                            <br/>
                            <form id="confirmNewpass" class="container" method="POST" action="MainController">
                                <span class="h4 text-muted">Change password</span><br/><br/>
                                  <div>
                                    <label>Password</label>
                                    <input type="password" name="Password" class="form-control" placeholder="Password" value="" id="Password">
                                  </div> <br/>
                                  <div>
                                        <label>Confirm</label>
                                    <input type="password" name="Confirm" class="form-control" placeholder="Confirm" value="">
                                  </div> <br/>
                                <input type="hidden" name="controller" value="UpdateAccountController">
                                <input type="hidden" name="action" value="Change pass"/>
                                <button type="submit" class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i> Save</button>
                            </form>
                        </div>
                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                  <table class="table">
                                    <thead class="thead-light">
                                      <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Order ID</th>
                                        <th scope="col">Total</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Action</th>
                                      </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="order" items="${orders}" varStatus="counter">
                                            <tr>
                                                <th scope="row">${counter.count}</th>
                                                <td>${order.getID()}</td>
                                                <td><fmt:formatNumber type="number" maxFractionDigits="5" value="${order.getTotal()}" /></td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${order.getStatus() == 1}">
                                                            Unconfirmed
                                                        </c:when>
                                                        <c:when test="${order.getStatus() == 2}">
                                                            On process
                                                        </c:when>
                                                        <c:when test="${order.getStatus() == 3}">
                                                            Deliveried
                                                        </c:when>
                                                        <c:when test="${order.getStatus() == 4}">
                                                            Cancelled
                                                        </c:when>
                                                    </c:choose>
                                                </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${order.getStatus() == 1 && order.getNote() != 'Request cancel order'}">
                                                            <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#cancelOrderModal_<c:out value='${order.getID()}'/>" ><i class="fa fa-trash" aria-hidden="true"></i></button>
                                                        </c:when>
                                                        <c:when test="${order.getNote() == 'Request cancel order' && order.getStatus() != 4}">
                                                            <button type="button" class="btn btn-outline-danger" disabled>Cancelling</button>
                                                        </c:when>
                                                    </c:choose>
                                                </td>
                                            </tr>
                                            <div class="modal fade" id="<c:out value='cancelOrderModal_${order.getID()}'/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                   <div class="modal-content">
                                                        <div class="modal-header">
                                                           <h5 class="modal-title" id="exampleModalLabel">Cancel order #${order.getID()}</h5>
                                                           <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                           <span aria-hidden="true">&times;</span>
                                                           </button>
                                                        </div>
                                                    <form action="MainController" method="POST">
                                                        <div class="modal-body">
                                                            <p>Are you sure to cancel this order ? You need to wait for admin permission and this action can't be undo !</p>
                                                        </div>
                                                        <div class="modal-footer">
                                                           <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                           <button type="submit" class="btn btn-primary">Request cancel</button>
                                                        </div>
                                                        <input type="hidden" name="lastURL" value="${requestScope['javax.servlet.forward.query_string']}"/>
                                                        <input type="hidden" name="controller" value="CancelOrderController"/>
                                                        <input type="hidden" name="pk" value="${order.getID()}"/>
                                                   </form>
                                                    </div>
                                             </div>
                                           </div>
                                        </c:forEach>
                                    </tbody>
                                  </table>
                        </div>
                    </div>
                </div>
          </div>
        </div>
    </body>
    <script>
            $(function() {
                $("#confirmNewpass").validate({
                    rules: {
                       Password: {
                           required: true,
                           rangelength: [6,30]
                       },
                       Confirm: {
                           equalTo: "#Password"
                       }
                   }
                })
            });
    </script>
</html>
