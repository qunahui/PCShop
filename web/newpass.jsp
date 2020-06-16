<%-- 
    Document   : newpass.jsp
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
                    <h1 class="display-4 py-2">Change new password</h1>
                    <div class="px-2">
                        <form id="confirmNewpass" action="/PCShop/ChangeNewController" method="POST">
                            <div class="justify-content-center">
                            <div class="form-group">
                                <label class="sr-only">Password</label> 
                                <input type="password" class="form-control" placeholder="Password" name="Password" id="Password"/>
                            </div>
                            <div class="form-group">
                                <label class="sr-only">Confirm</label>
                                <input type="password" class="form-control" placeholder="Confirm" name="Confirm"/>
                            </div>
                            <input type="hidden" name="sign" value="${requestScope.SIGN}">
                            <button type="submit" class="btn btn-outline-dark btn-md">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
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
    </body>
</html>
                