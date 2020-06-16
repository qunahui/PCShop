<%-- 
    Document   : forgot.jsp
    Created on : Jun 16, 2020, 2:45:23 PM
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
    </head>
    <jsp:include page="header.jsp"/>
    <body>
        <div class="container">
            <div class="row text-dark">
                <div class="col-xl-5 col-lg-6 col-md-8 col-sm-10 mx-auto text-center form p-4">
                    <h1 class="display-4 py-2">Forgot your password</h1>
                    <div class="px-2">
                        <form action="/PCShop/SendRequestController" method="POST">
                            <div class="justify-content-center">
                            <div class="form-group">
                                <label class="sr-only">Username</label>
                                <input type="text" class="form-control" placeholder="Username" name="txtUsername">
                            </div>
                            <div class="form-group">
                                <label class="sr-only">Email</label>
                                <input type="text" class="form-control" placeholder="Mail" name="txtMail">
                            </div>
                            <button type="button" class="btn btn-outline-dark btn-md" type="button" data-toggle="modal" data-target="#changPassModal" >Submit</button>
                            <input type="submit" style="display: none;" id="submit">
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal fade" id="changPassModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" data-show="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLongTitle">Notification</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
                        <div class="modal-body">
                            Please check your email to confirm your password recovery.
                        </div>
                      </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $("#changPassModal").on("hidden.bs.modal", function () {
                document.getElementById("submit").click();
            });
        </script>
    </body>
</html>
                