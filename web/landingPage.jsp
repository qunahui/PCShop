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
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" data-interval="1500" data-pause="hover">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                  <a href="/PCShop/ViewShopController?&searchByCategory=RAM">
                    <img class="d-block w-100" src="/PCShop/assets/category/RAM.jpg" style="width: 100%; height: 800px;" alt="First slide">
                  </a>
                <div class="carousel-caption d-none d-md-block">
                </div>
              </div>
              <div class="carousel-item">
                <a href="/PCShop/ViewShopController?&searchByCategory=GPU">
                    <img class="d-block w-100" src="/PCShop/assets/category/GPU.jpg" style="width: 100%; height: 800px;" alt="Second slide">
                </a>
              </div>
              <div class="carousel-item">
                <a href="/PCShop/ViewShopController?&searchByCategory=CPU">
                    <img class="d-block w-100" src="/PCShop/assets/category/CPU.jpg" style="width: 100%; height: 800px;" alt="Third slide">
                </a>
              </div>
              <div class="carousel-item">
                <a href="/PCShop/ViewShopController?&searchByCategory=MAINBOARD">
                    <img class="d-block w-100" src="/PCShop/assets/category/MB.jpg" style="width: 100%; height: 800px;" alt="4th slide">
                </a>
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="/PCShop/assets/category/Case.jpg"style="width: 100%; height: 800px;" alt="5th slide">
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
    </form>
    <div class="container">
    <div class="row row-divided" id="row-1873463315">
	<div class="col medium-4 large-4 col-divided col-hover-focus" data-animate="bounceIn" data-animated="true">
            <div class="col-inner">
		<div class="icon-box featured-box icon-box-center text-center" style="margin:0px 0px 0px 0px;">
                    <div class="icon-box-img has-icon-bg container-fluid" style="width: 46px">
                        <div class="icon ">
                                <div class="icon-inner" style="border-width:2px;color:rgb(182, 182, 182);">
                                <img width="100" height="100" src="https://pcplayboy.xyz/wp-content/uploads/2020/06/icon-delivery-1-400x400-1-300x300.png" class="attachment-medium size-medium" alt="" srcset="https://pcplayboy.xyz/wp-content/uploads/2020/06/icon-delivery-1-400x400-1-300x300.png 300w, https://pcplayboy.xyz/wp-content/uploads/2020/06/icon-delivery-1-400x400-1-150x150.png 150w, https://pcplayboy.xyz/wp-content/uploads/2020/06/icon-delivery-1-400x400-1-100x100.png 100w, https://pcplayboy.xyz/wp-content/uploads/2020/06/icon-delivery-1-400x400-1.png 400w" sizes="(max-width: 300px) 100vw, 300px">					</div>
                        </div>
                    </div>
                    <div class="icon-box-text last-reset">
                        <h5 class="uppercase">Miễn phí giao hàng</h5>						
                        <p>Miễn phí vận chuyển cho các đơn hàng nội thành và ngoại thành TPHCM.</p>
                    </div>
                </div>
            </div>
	</div>
	<div class="col medium-4 large-4 col-divided col-hover-focus" data-animate="bounceIn" data-animated="true">
            <div class="col-inner">
		<div class="icon-box featured-box icon-box-center text-center" style="margin:0px 0px 0px 0px;">
                    <div class="icon-box-img has-icon-bg" style="width: 46px">
                        <div class="icon">
                                <div class="icon-inner" style="border-width:2px;color:rgb(182, 182, 182);">
                                <img width="100" height="100" src="https://pcplayboy.xyz/wp-content/uploads/2020/06/customer-care-service-and-support-icon-vector-14678034-removebg-preview-318x400-1-239x300.png" class="attachment-medium size-medium" alt="" srcset="https://pcplayboy.xyz/wp-content/uploads/2020/06/customer-care-service-and-support-icon-vector-14678034-removebg-preview-318x400-1-239x300.png 239w, https://pcplayboy.xyz/wp-content/uploads/2020/06/customer-care-service-and-support-icon-vector-14678034-removebg-preview-318x400-1.png 318w" sizes="(max-width: 239px) 100vw, 239px">					</div>
                        </div>
                    </div>
                    <div class="icon-box-text last-reset">
			<h5 class="uppercase">chăm sóc khách hàng</h5>						
                        <p>Chúng tôi luôn hỗ trợ khách hàng 24/7 thông qua đường dây nóng 1900 6789 hoặc tại cửa hàng từ 9am-5pm, từ thứ 2 đến thứ 7.</p>       
                        <p>&nbsp;</p>
                    </div>
                </div>
            </div>
	</div>
	<div class="col medium-4 large-4 col-divided col-hover-focus" data-animate="bounceIn" data-animated="true">
            <div class="col-inner">
		<div class="icon-box featured-box icon-box-center text-center" style="margin:0px 0px 0px 0px;">
                    <div class="icon-box-img has-icon-bg" style="width: 46px">
                        <div class="icon">
                            <div class="icon-inner" style="border-width:2px;color:rgb(182, 182, 182);">
                                <img width="100" height="100" src="https://pcplayboy.xyz/wp-content/uploads/2020/06/download-removebg-preview-1.png" class="attachment-medium size-medium img-circle" alt="">					</div>
                            </div>
                    </div>
                    <div class="icon-box-text last-reset">
                        <h5 class="uppercase">chính sách bảo hành</h5>						
                        <p>Đổi mới 100% trong vòng 24 tháng nếu sản phẩm có lỗi do nhà sản xuất.</p>
                    </div>
                </div>
            </div>
	</div>
    </div>
    </div>
    </body>

</html>