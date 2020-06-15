<%-- 
    Document   : shopping
    Created on : May 5, 2020, 11:29:49 AM
    Author     : Hui
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
        <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
        <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
        <link rel="stylesheet" href=<c:url value="/css/shopping.css" /> />
        <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
</head>

<body>
    <jsp:include page="../header.jsp" />
    <div class="container-fluid text-center" style="margin: 10px 0;">
        <a href="/PCShop/admin/ViewAddProductController"><button type="button" class="btn btn-large btn-outline-danger" name="action" value="">Add product</i></button></a>
    </div>
    <table border="1" class="table table-bordered container" >
        <thead class="thead-dark">
            <tr>
                <th scope="col">   </th>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Description</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
            <c:forEach var="product" items="${result}" varStatus="counter">
                    <tr>
                        <td style="width: 10%">
                            <img src="${product.path}" style="width: 100px; height: 100px;"/> 
                        </td>
                        <td style="width: 20%">
                            ${product.ID}
                        </td>
                        <td style="width: 15%">
                            ${product.name}
                        </td>
                        <td style="width: 10%">
                            ${product.price}
                        </td>
                        <td>
                            ${product.description}
                        </td>
                        <td style="width: 10%">
                            <form method="POST" action="MainController">
                                <input type="hidden" name="txtProID" value="${product.ID}">
                                <input type="hidden" name="controller" value="DeleteProductController"/>
                                <input type="hidden" name="lastURL" value="${requestScope['javax.servlet.forward.query_string']}"/>
                                <button type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#productModal_<c:out value='${product.ID}'/>" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                                <button type="submit" class="btn btn-outline-danger" name="action" value="Delete product"><i class="fa fa-trash" aria-hidden="true"></i></button>
                            </form>
                        </td>
                    </tr>
                    <div class="modal fade" id="<c:out value='productModal_${product.ID}'/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                     <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Edit product #${product.ID}</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                                </button>
                        </div>
                        <form name="addForm" action="MainController" id="addForm" action="MainController" method="POST" enctype="multipart/form-data">       
                            <div class="modal-body">
                                <div class="form-group">
                                  <label class="col-form-label">Product name: </label>
                                  <input type="text" class="form-control" id="product-id" name="txtProName" value="${product.name}" required/>
                                </div>
                                <div class="form-group">
                                  <label class="col-form-label">Product category: </label>
                                  <input type="text" class="form-control" id="product-category" name="txtProCategoryID" value="${product.categoryID}" required/>
                                </div>
                                <div class="form-group">
                                  <label class="col-form-label">Product price: </label>
                                  <input type="text" class="form-control" id="product-price" name="txtProPrice" value="${product.price}" required/>
                                </div>
                                <div class="form-group">
                                  <label class="col-form-label">Discount (%): </label>
                                  <input type="text" class="form-control" id="product-discount" name="txtProDiscount" value="${product.discount}" required/>
                                </div>
                                <div class="form-group">
                                  <label class="col-form-label">Quantity: </label>
                                  <input type="text" class="form-control" id="product-quanitty" name="txtProQuantity" value="${product.quantityProduct}" required/>
                                </div>
                                <div class="form-group">
                                  <label class="col-form-label">Description: </label>
                                  <textarea type="text" class="form-control" id="product-description" name="txtProDescription" required>${product.description}</textarea>
                                </div>
                                <div class="form-group">
                                  <label class="col-form-label">Details: </label>
                                  <textarea type="text" class="form-control" id="product-details" name="txtProDetails" required>${product.details}</textarea>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary"data-dismiss="modal">Close</button>
                                <input type="submit" class="btn btn-primary" name="action" value="Edit product"/>
                            </div>
                            <input type="hidden" name="lastURL" value="${requestScope['javax.servlet.forward.query_string']}"/>
                            <input type="hidden" name="controller" value="EditProductController"/>
                            <input type="hidden" name="txtProID" value="${product.ID}">
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