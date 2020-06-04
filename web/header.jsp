<%-- 
    Document   : header
    Created on : May 7, 2020, 12:48:42 PM
    Author     : Hui
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"/>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <a href="/PCShop/ViewLandingPageController" class="navbar-brand">
            <img src="/PCShop/assets/Logo-2.png" id="logo" class="logo" />
        </a>
        <div class="collapse navbar-collapse justify-content-center align-items-center" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="navbar-brand active">
                      <a class="nav-link" href="/PCShop/ViewShopController">Shopping</a>
                    </li>
                </ul>
          <c:if test="${sessionScope.USERNAME == null}">
              <form class="form-inline my-2 my-lg-0" action="MainController" method="POST">
                <button class="btn btn-outline-success my-2 my-sm-0" style="margin-left: 5px;" type="button" value="Login" name="btnAction" data-toggle="modal" data-target="#loginModal">Login</button>
                <button class="btn btn-outline-success my-2 my-sm-0" style="margin-left: 5px;" type="submit" value="Register" name="btnAction">Register</button>
                <button class="btn btn-outline-success my-2 my-sm-0" style="margin-left: 5px;" name="btnAction" value="View cart"><i class="fa fa-shopping-cart cart" aria-hidden="true"></i></button>
                <input type="hidden" name="controller" value="Logging"/>
              </form>
          </c:if>
            <c:if test="${not empty sessionScope.USERNAME}">
                <form method="POST" action="MainController">
                    <a href="/PCShop/ViewAccountController" class="btn btn-outline-success my-2 my-sm-0"><i class="fa fa-user" aria-hidden="true"></i></a>
                    <input class="btn btn-outline-success my-2 my-sm-0" type="submit" name="btnAction" value="Logout"/>
                    <input type="hidden" name="controller" value="Logging"/>
                    <button class="btn btn-outline-success my-2 my-sm-0" name="btnAction" value="View cart"><i class="fa fa-shopping-cart cart" aria-hidden="true"></i></button>
                </form>
          </c:if>
        </div>
      </nav>
    <div style="height: 100px;"></div>
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalCenterTitle">Login</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <form method="POST" action="MainController"> 
                <div class="modal-body">
                        <div class="form-group row">
                          <label class="col-sm-2 col-form-label">Email</label>
                          <div class="col-sm-10">
                            <input class="form-control" type="text" placeholder="Username" aria-label="Username" name="txtUsername">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label class="col-sm-2 col-form-label">Password</label>
                          <div class="col-sm-10">
                               <input class="form-control" type="password" placeholder="Password" aria-label="Password" name="txtPassword">
                          </div>
                        </div>
                        <input type="hidden" name="controller" value="Logging"/>
                </div>
                <div class="modal-footer justify-content-center align-items-center">
                    <button class="btn btn-outline-success my-2 my-sm-0" style="margin-left: 5px;" type="submit" value="Login" name="btnAction" id="loginBtn">Login</button>
                    <button class="btn btn-outline-success my-2 my-sm-0" style="margin-left: 5px;" type="submit" value="Register" name="btnAction">Register</button>
                </div>
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
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
              </div>
            </div>
        </div>
    </c:if>
</body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script>
        $(function(){
            $('#loginModal').keypress(function(e){
              if(e.which == 13) {
                  document.getElementByID("loginBtn").click();
              }
            })
        })
    </script>
</html>