<%-- 
    Document   : product
    Created on : May 25, 2020, 5:17:43 PM
    Author     : Hui
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
        <link rel="stylesheet" href=<c:url value="/css/product.css" /> />
        <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
    </head>
    <body>
    <jsp:include page="../header.jsp" />
    <c:set var="product" value="${requestScope.SEARCHRESULT}"/>    
    <div class="container" style="margin-top: 50px;">
        <a href="/PCShop/ViewLandingPageController">Home page</a>  &gt; <a href="/PCShop/ViewShopController?searchByName=">Shop</a>  &gt; ${product[0].name}
        </br>
        </br>
        <div class="row">
            <div class="col-md-6">
                <button type="button" style="outline: none; border: none; padding: 0;" data-toggle="modal" data-target="#imgModal" id="openImgModalBtn">
                    <img src="${product[0].path}" style="width: 500px; height: 500px;">
                </button>
            </div>
            <div class="col-md-6">
                <h1 class="">${product[0].name}</h1>
                <br />
                <div id="txtRating"></div>
                <br/>
                <c:choose>
                    <c:when test="${product[0].discount > 0}">
                        <span class="h3" style="color: #ccc;">
                            <s><fmt:formatNumber type="number" maxFractionDigits="1" value="${product[0].price}" /></s>
                        </span>
                        <span class="h3" style="color: #9e002a;">
                            <fmt:formatNumber type="number" maxFractionDigits="1" value="${product[0].price*(1-product[0].discount/100)}" />
                        </span>
                    </c:when>
                    <c:otherwise>
                        <h3 style="color: #9e002a;">
                            <fmt:formatNumber type="number" maxFractionDigits="1" value="${product[0].price}" />
                        </h3>                                    
                    </c:otherwise>
                </c:choose>
                    <br />
                    <br />
                        <strong>Availability: </strong>
                        <c:choose>
                            <c:when test="${product[0].quantityProduct > 0}">
                                <span class="text-success h4">${product[0].quantityProduct} in stock</span>
                            </c:when>
                            <c:otherwise>
                                <span class="text-danger h4">Out of stock</span>
                            </c:otherwise>
                        </c:choose>
                    <br/>
                    <br/>
                    <p class="h6">
                        ${product[0].description}
                    </p> <br/>
                    <form class="form-inline" action="MainController" method="POST">
                        <span class="h6" style="margin-right: 10px; margin-bottom: 0;" >Qty:</span><input class="form-control" type="number" step="1" min="1" max="${product[0].quantityProduct}" name="txtProQuantity" value="1">
                        <input type="hidden" name="controller" value="AddCartController">
                        <input type="hidden" name="txtProID" value="${product[0].ID}">
                        <input type="hidden" name="txtProName" value="${product[0].name}">
                        <input type="hidden" name="txtProPrice" value="${product[0].price}">
                        <input type="hidden" name="txtProDiscount" value="${product[0].discount}">
                        <input type="hidden" name="txtProCategoryID" value="${product[0].categoryID}">
                        <button class="btn btn-outline-dark my-2 my-sm-0" style="margin-left: 5px;" ${product[0].quantityProduct <= 0 ? 'disabled': ''}>Add to cart</button>
                    </form>
            </div>
        </div>
        <br/>
        <br/>
        <br/>
        <div class="container-fluid">
            <div class="h1 text-muted">Details </div>
            <br/>
            <div class="ml-3">
                <span class="h4 text-dark " style="letter-spacing: 0.1em; line-height: 40px;">${product[0].details}</span>
            </div>
        </div>
        <div style="height: 50px;"></div>
         <div class="container-fluid">
            <div class="h1 text-muted">Reviews </div>
        </div>
        <c:if test="${sessionScope.MEMBERID != 'guess'}">
            <div class="container-fluid" style="margin-top: 30px;">
                <div class="h2 text-muted">Leave your comment: </div>
                <form class="form-group" method="POST" action="MainController">
                    <textarea class="form-control" style="height: 150px;" type="text" name="txtComment"></textarea>
                    <input type="hidden" name="controller" value="AddCommentController"/>
                    <input type="hidden" name="pk" value="${product[0].ID}"/>
                    <input type="hidden" name="customerID" value="${sessionScope.MEMBERID}"/>
                    <input type="hidden" name="customerName" value="${sessionScope.USERNAME}"/>
                    <label class="text-muted">Rating: </label>
                        <div id="rating_bar">
                            <input type="radio" id="rate_5" name="rating" value="5" />
                            <label for="rate_5" title="Not effective!"></label>
                            <input type="radio" id="rate_4" name="rating" value="4" />
                            <label for="rate_4" title="Kinda effective!"></label>
                            <input type="radio" id="rate_3" name="rating" value="3" />
                            <label for="rate_3" title="Effective!"></label>
                            <input type="radio" id="rate_2" name="rating" value="2" />
                            <label for="rate_2" title="Pretty effective!"></label>
                            <input type="radio" id="rate_1" name="rating" value="1" />
                            <label for="rate_1" title="Super effecitive!"></label>
                        </div><br/>
                    <button class="btn btn-outline-dark my-2 my-sm-1" type="submit">Add comment</button>
                </form>
            </div>
        </c:if>
        <div>
            <c:set var="comments" value="${requestScope.COMMENTS}"/>
            <c:choose>
                <c:when test="${empty comments}">
                    <div class="container-fluid">
                        <div class="h3 text-muted">No comments yet. </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:set var="aveRating" value="0"/>
                    <c:set var="counter" value="0"/>
                    <c:forEach items="${comments}" var="comment">
                        <c:if test="${comment.getRating() > 0}">
                            <c:set var="counter" value="${counter + 1}"/>
                            <c:set var="numRating" value="${counter}"/>
                            <c:set var="totalRating" value="${(comment.getRating() + totalRating)}"/>
                            <c:set var="aveRating" value="${(totalRating/numRating)}"/>
                        </c:if>
                        <div class="card container-fluid">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-2">
                                        <img src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid"/>
                                        <p class="text-secondary text-center">Commented at ${comment.getDate()}</p>
                                        <p class="text-center">
                                            <c:forEach begin="1" end="${comment.getRating()}" varStatus="loop">
                                                <i class="fa fa-star" aria-hidden="true" style="color: orange;"></i>
                                            </c:forEach>
                                            <c:forEach begin="1" end="${5 - comment.getRating()}" varStatus="loop">
                                                <i class="fa fa-star" aria-hidden="true" style="color: #c7c5c5;"></i>
                                            </c:forEach>
                                        </p>
                                    </div>
                                    <div class="col-md-10">
                                        <p>
                                            <a class="float-left" href="https://maniruzzaman-akash.blogspot.com/p/contact.html"><strong>${comment.getCustomerName()}</strong></a>
                                            <c:choose>
                                                <c:when test="${comment.getCustomerID() == sessionScope.MEMBERID}">
                                                    <button class="btn btn-danger float-right" type="button" class="btn btn-primary" data-toggle="modal" data-target="<c:out value='#deleteCmtModal_${comment.getID()}'/>"><i class="fa fa-window-close" aria-hidden="true"></i></button>
                                                </c:when>
                                            </c:choose>
                                       </p>
                                       <div class="clearfix"></div>
                                        <p>${comment.getComment()}</p>
                                        <p>
                                            <a class="float-right btn btn-outline-primary ml-2"> <i class="fa fa-reply"></i> Reply</a>
                                            <a class="float-right btn text-white btn-danger"> <i class="fa fa-heart"></i> Like</a>
                                       </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal fade" id="<c:out value='deleteCmtModal_${comment.getID()}'/>" tabindex="-1" role="dialog">
                            <div class="modal-dialog modal-dialog-centered">
                              <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Delete your comment</h5>
                                </div>
                                <div class="modal-body text-center">
                                    <p>Are you sure to delete this comment ?</p>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <form style="display: inline;" action="MainController" method="POST">
                                        <button class="btn btn-danger">Delete</button>
                                        <input type="hidden" name="controller" value="DeleteCommentController"/>
                                        <input type="hidden" name="cmtID" value="${comment.getID()}"/>
                                        <input type="hidden" name="pk" value="${comment.getProductID()}"/>
                                    </form>
                                </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <input type="hidden" id="aveRating" name="aveRating" value="${aveRating}"/>
                    <script>
                        let aveRating = document.getElementById("aveRating").value;
                        let txtRating = document.getElementById("txtRating");
                        for(let i = 1; i<= Math.ceil(aveRating); i++) {
                            let el = document.createElement('i');
                            el.className = 'fa fa-star';
                            el.style.color = 'orange';
                            txtRating.appendChild(el);
                        }
                    </script>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="modal fade" id="imgModal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <img src="${product[0].path}" style="width: 600px; height: 600px;">
            </div>
        </div>
    </div>
    <div style="height: 100px;"></div>
    </body>
    <script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
</script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</html>