<%-- 
    Document   : header
    Created on : May 7, 2020, 12:48:42 PM
    Author     : Hui
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href=<c:url value="/css/bootstrap-config.css"/> />
    <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
    <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"/>
    <script type="text/javascript" src="/PCShop/js/jquery-3.5.1.slim.min.js"></script>
    <script type="text/javascript" src="/PCShop/js/jquery.validate.js"></script>
    <script type="text/javascript" src="/PCShop/js/additional-methods.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top text-white" style="padding-top: 0; padding-bottom: 0;">
        <a href="/PCShop/ViewLandingPageController" class="navbar-brand">
            <img src="/PCShop/assets/Logo.png" style="min-width: 100px; min-height: 100px;" id="logo" class="logo" />
        </a>
        <div class="collapse navbar-collapse justify-content-center align-items-center" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="navbar-brand active" style="margin-left: 15px;">
                        <div class="container">
                        <div class="dropdown">
                            <a href="/PCShop/ViewShopController">
                                <button onclick="window.location.history.push('/');" class="btn nav-link dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Shopping
                                </button>
                            </a>
                          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="/PCShop/ViewShopController?&searchByCategory=CPU">CPU</a>
                            <a class="dropdown-item" href="/PCShop/ViewShopController?searchByCategory=VGA">GPU</a>
                            <a class="dropdown-item" href="/PCShop/ViewShopController?searchByCategory=MAINBOARD">MAINBOARD</a>
                            <a class="dropdown-item" href="/PCShop/ViewShopController?searchByCategory=RAM">RAM</a>
                            <a class="dropdown-item" href="/PCShop/ViewShopController?searchByCategory=SSD">SSD</a>
                            <a class="dropdown-item" href="/PCShop/ViewShopController?searchByCategory=HDD">HDD</a>
                          </div>
                        </div>
                        </div>
                    </li>
                </ul>
          <c:if test="${sessionScope.USERNAME == null}">
              <form class="form-inline my-2 my-lg-0" action="MainController" method="POST">
                <button class="btn btn-outline-light my-2 my-sm-0" style="margin-left: 5px;" type="button" data-toggle="modal" data-target="#loginModal" id="openLoginModalBtn">Login</button>
                <button class="btn btn-outline-light my-2 my-sm-0" style="margin-left: 5px;" type="button" data-toggle="modal" data-target="#registerModal" id="openRegisterModalBtn">Register</button>
                <button class="btn btn-outline-light my-2 my-sm-0" style="margin-left: 5px;" name="btnAction" value="View cart"><i class="fa fa-shopping-cart cart" aria-hidden="true"></i></button>
                <input type="hidden" name="controller" value="Logging"/>
              </form>
          </c:if>
            <c:if test="${not empty sessionScope.USERNAME}">
                <form method="POST" action="MainController">
                    <a href="/PCShop/ViewAccountController" class="btn btn-outline-light my-2 my-sm-0"><i class="fa fa-user" aria-hidden="true"></i></a>
                    <button class="btn btn-outline-light my-2 my-sm-0" type="submit" name="btnAction" value="Logout"><i class="fa fa-sign-out" aria-hidden="true"></i></button>
                    <input type="hidden" name="controller" value="Logging"/>
                    <button class="btn btn-outline-light my-2 my-sm-0" name="btnAction" value="View cart"><i class="fa fa-shopping-cart cart" aria-hidden="true"></i></button> 
                </form>
          </c:if>
        </div>
    </nav>
    <div style="height: 110px;"></div>
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" >
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalCenterTitle">Login</h5>
              <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <form method="POST" action="MainController"> 
                <div class="modal-body">
                        <div class="form-group">
                           <label for="usernameLoginInput" class="text-dark">Username</label>
                           <input class="form-control" id="usernameLoginInput" type="text" aria-label="Username" name="txtUsername">
                        </div>
                        <div class="form-group">
                            <label for="passwordLoginInput" class="text-dark">Password</label>
                            <input class="form-control" id="passwordLoginInput" type="password"aria-label="Password" name="txtPassword">
                        </div>
                        <input type="hidden" name="controller" value="Logging"/>
                        <br/>
                        <a href="/PCShop/forgot.jsp" class="text-muted" style="hover { color: black;}">Forgot your password ?</a> 
                </div>
                <div class="modal-footer justify-content-center align-items-center">
                    <button class="btn btn-outline-dark my-2 my-sm-0" style="margin-left: 5px;" type="submit" value="Login" name="btnAction" id="loginBtn">Login</button>
                    <button class="btn btn-outline-dark my-2 my-sm-0" style="margin-left: 5px;" type="submit" value="Register" name="btnAction">Register</button>
                </div>
            </form>
          </div>
        </div>
    </div>
    <c:if test="${not empty requestScope.ERROR}">
        <div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" data-show="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLongTitle">Login</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                    ${requestScope.ERROR}
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal" id="closeErrorModalBtn">Close</button>
                </div>
              </div>
            </div>
        </div>
        <script type="text/javascript">
            $(window).on('load',function(){
            $('#errorModal').modal('show');
            });
            $("#closeErrorModalBtn").click(function() {
                $("#openLoginModalBtn").click();
            })
        </script>
    </c:if>
    <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalCenterTitle">Register</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <form method="POST" action="MainController" id="addAccountForm"> 
                <div class="modal-body">
                        <div class="form-group row">
                          <label class="col-sm-4 col-form-label">Username</label>
                          <div class="col-sm-8">
                              <input class="form-control" type="text" placeholder="(6-20 characters)" name="regUsername" value="${requestScope.regUsername}">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-4 col-form-label">Password</label>
                          <div class="col-sm-8">
                               <input class="form-control" type="password" placeholder="(6-30 characters)" id="regPassword" name="regPassword" value="${requestScope.regPassword}">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-4 col-form-label">Confirm password</label>
                          <div class="col-sm-8">
                               <input class="form-control" type="password" placeholder="(6-30 characters)" name="regConfirm" value="${requestScope.regPassword}">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-4 col-form-label">Last name</label>
                          <div class="col-sm-8">
                               <input class="form-control" type="text" placeholder="2-50 characters)" name="regLastname" value="${requestScope.regLastname}">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-4 col-form-label">First name</label>
                          <div class="col-sm-8">
                               <input class="form-control" type="text" placeholder="2-50 characters)" name="regFirstname" value="${requestScope.regFirstname}">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-4 col-form-label">Phone</label>
                          <div class="col-sm-8">
                               <input class="form-control" type="text" placeholder="(10 numbers)" name="regPhone" value="${requestScope.regPhone}">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-4 col-form-label">Address</label>
                          <div class="col-sm-8">
                               <input class="form-control" type="text" placeholder="2-50 characters)" name="regAddress" value="${requestScope.regAddress}">
                          </div>
                        </div>
                </div>
                <div class="modal-footer justify-content-center align-items-center">
                    <input type="hidden" name="controller" value="AddAccountController" />
                    <button class="btn btn-outline-dark my-2 my-sm-0" style="margin-left: 5px;" type="button" id="reset">Reset</button>
                    <input type="submit" value="Create New Account" name="action" class="btn btn-outline-dark my-2 my-sm-0" style="margin-left: 5px;"  />
                </div>
            </form>
          </div>
        </div>
    </div>
    <c:if test="${not empty requestScope.REGISTERERROR}">
        <div class="modal fade" id="userExistModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" data-show="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLongTitle">Noti</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                    ${requestScope.REGISTERERROR}
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal" id="closeRegisterErrorModalBtn">Close</button>
                </div>
              </div>
            </div>
        </div>
        <script type="text/javascript">
            $(window).on('load',function(){
            $('#userExistModal').modal('show');
            });
            $("#closeRegisterErrorModalBtn").click(function() {
                $("#openRegisterModalBtn").click();
            })
        </script>
    </c:if>
</body>
    <script>
        $(function(){
            $('#loginModal').keypress(function(e){
              if(e.which == 13) {
                  document.getElementByID("loginBtn").click();
              }
            })
        });
    </script>
    <script>
            $(function() {
                $("#addAccountForm").validate({
                    rules: {
                       regUsername: {
                           required: true,
                           rangelength: [6,20]
                       },
                       regPassword: {
                           required: true,
                           rangelength: [6,30]
                       },
                       regConfirm: {
                           equalTo: "#regPassword"
                       },
                       regLastname: {
                           required: true,
                           rangelength: [2,50]
                       },
                       regFirstname: {
                           required: true,
                           rangelength: [2,50]
                       },
                       regPhone: {
                           required: true,
                           length: [0]
                       },
                       regAddress: {
                           required: true,
                           rangelength: [2,50]
                       }
                   }
                })
            });
            $("#reset").click(function() {
                $(this).closest('form').find("input[type=text], textarea,input[type=password]").val("");
})          ;
    </script>
</html>