<%-- 
    Document   : add_product
    Created on : May 20, 2020, 9:25:11 PM
    Author     : Hui
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
        <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
        <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
    </head>
    <body>
        <script type="text/javascript" src="/PCShop/js/jquery.js"></script>
        <script type="text/javascript" src="/PCShop/js/jquery.validate.js"></script>
        <script type="text/javascript" src="/PCShop/js/additional-methods.js"></script>
        
        <jsp:include page="../header.jsp" />
        <h1>Add product page</h1>
        <form name="addForm" action="MainController" id="addForm"
            enctype="multipart/form-data" method="post">
            <input type="hidden" name="controller" value="AddProductController"/>
            Name: <input type="text" name="txtProName" value=""> <br/>
            category ID: <input type="text" name="txtProCategoryID" value=""> <br/>
            Description <textarea type="text" name="txtProDescription"></textarea><br/>
            quantity: <input type="text" name="txtProQuantity" value=""> <br/>
            Price: <input type="text" name="txtProPrice" value=""> <br/>
            Details: <textarea type="text" name="txtProDetails"></textarea> <br/>
            Discount (optional)(%): <input type="text" name="txtProDiscount" value="0"> <br/>
            Product image: <input type="file" name="proImg" id="proImg" value="">

            <input type="submit" id="submit" value="submit">
        </form>
        <script>
            $(function() {
                $("#addForm").validate({
                    rules: {
                       txtProName: {
                           required: true,
                           minlength: [0]
                       },
                       txtProCategoryID: {
                           required: true,
                           minlength: [0]
                       },
                       txtProDescription: {
                           required: true,
                           minlength: [0]
                       },
                       txtProQuantity: {
                           required: true,
                           minlength: [0]
                       },
                       txtProPrice: {
                           required: true,
                           minlength: [0]
                       },
                       txtProDetails: {
                           required: true,
                           minlength: [0]
                       },
                       txtProDiscount: {

                       },
                       proImg: {
                           required: true,
                           accept: "jpg,png,jpeg,gif"
                       }
                   }
                })
            });
        </script>
    </body>

</html>
