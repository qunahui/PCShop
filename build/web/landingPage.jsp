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
    <link rel="stylesheet" href="<c:url value="/css/landingPage.css" />">
    <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
    <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
</head>

<body>
    <jsp:include page="header.jsp" />
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" data-interval="3000" data-pause="hover">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img class="d-block w-100" src="/PCShop/assets/hot-deal-background-2.jpg" style="width: 100%; height: 800px;" alt="First slide">
                <div class="carousel-caption d-none d-md-block">
                </div>
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="/PCShop/assets/hot-deal-background.jpg" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="/PCShop/assets/hot-deal-background-2.jpg" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>
        <div>
            <a href="/PCShop/ViewShopController?action=categorySearch&searchByCategory=RAM">Search RAM</a>
        </div>
    </form>
</body>

</html>