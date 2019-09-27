<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="shoponline.utils.SecurityUtils" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
	<title>T.Dragon | NTD - store</title>
	<meta charset="UTF-8">
	<meta name="description" content=" Divisima | eCommerce Template">
	<meta name="keywords" content="divisima, eCommerce, creative, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Favicon -->
	<link href="<c:url value='/resources/home/img/favicon.ico'/>" rel="shortcut icon"/>

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">


	<!-- Stylesheets -->
	<link rel="stylesheet" href="<c:url value='/resources/home/css/bootstrap.min.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/resources/home/css/font-awesome.min.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/resources/home/css/flaticon.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/resources/home/css/slicknav.min.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/resources/home/css/jquery-ui.min.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/resources/home/css/owl.carousel.min.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/resources/home/css/animate.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/resources/home/css/style.css'/>"/>
</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header section -->
	<header class="header-section">
		<c:import url="header-web.jsp"></c:import>
		<c:import url="menu-web.jsp"></c:import>
	</header>
	<!-- Header section end -->



	<!-- Hero section -->
	<section class="hero-section">
		<div class="hero-slider owl-carousel">
			<div class="hs-item set-bg" data-setbg="<c:url value='/resources/home/img/bg.jpg'/>">
				<div class="container">
					<div class="row">
						<div class="col-xl-6 col-lg-7 text-white">
							<span>New Arrivals</span>
							<h2>denim jackets</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum sus-pendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. </p>
							<a href="#" class="site-btn sb-line">DISCOVER</a>
							<a href="#" class="site-btn sb-white">ADD TO CART</a>
						</div>
					</div>
					<div class="offer-card text-white">
						<span>from</span>
						<h2>$29</h2>
						<p>SHOP NOW</p>
					</div>
				</div>
			</div>
			<div class="hs-item set-bg" data-setbg="<c:url value='/resources/home/img/bg-2.jpg'/>">
				<div class="container">
					<div class="row">
						<div class="col-xl-6 col-lg-7 text-white">
							<span>New Arrivals</span>
							<h2>denim jackets</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum sus-pendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. </p>
							<a href="#" class="site-btn sb-line">DISCOVER</a>
							<a href="#" class="site-btn sb-white">ADD TO CART</a>
						</div>
					</div>
					<div class="offer-card text-white">
						<span>from</span>
						<h2>$29</h2>
						<p>SHOP NOW</p>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="slide-num-holder" id="snh-1"></div>
		</div>
	</section>
	<!-- Hero section end -->



	<!-- Features section -->
	<section class="features-section">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4 p-0 feature">
					<div class="feature-inner">
						<div class="feature-icon">
							<img src="<c:url value='/resources/home/img/icons/1.png'/>" alt="#">
						</div>
						<h2>Fast Secure Payments</h2>
					</div>
				</div>
				<div class="col-md-4 p-0 feature">
					<div class="feature-inner">
						<div class="feature-icon">
							<img src="<c:url value='/resources/home/img/icons/2.png'/>" alt="#">
						</div>
						<h2>Premium Products</h2>
					</div>
				</div>
				<div class="col-md-4 p-0 feature">
					<div class="feature-inner">
						<div class="feature-icon">
							<img src="<c:url value='/resources/home/img/icons/3.png'/>" alt="#">
						</div>
						<h2>Free & fast Delivery</h2>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Features section end -->


	<!-- letest product section -->
	<section class="top-letest-product-section">
		<div class="container">
			<div class="section-title">
				<h2>LATEST PRODUCTS</h2>
			</div>
			<div class="product-slider owl-carousel">
				<c:forEach items="${listProduct1}" var="product">
					<div class="product-item">
						<div class="pi-pic">
							<img src="<c:url value='/resources/image/products/${product.getImage()}'/>" alt="">
							<div class="pi-links">
								<a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
							</div>
						</div>
						<div class="pi-text">
							<h6>${product.getPrice()}</h6>
							<p>${product.getProductName()}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!-- letest product section end -->



	<!-- Product filter section -->
	<section class="product-filter-section">
		<div class="container">
			<div class="section-title">
				<h2>BROWSE TOP SELLING PRODUCTS</h2>
			</div>
			<ul class="product-filter-menu">
				<li><a href="#">TOPS</a></li>
				<li><a href="#">JUMPSUITS</a></li>
				<li><a href="#">LINGERIE</a></li>
				<li><a href="#">JEANS</a></li>
				<li><a href="#">DRESSES</a></li>
				<li><a href="#">COATS</a></li>
				<li><a href="#">JUMPERS</a></li>
				<li><a href="#">LEGGINGS</a></li>
			</ul>
			<div class="row productLoadMores">
				<c:forEach items="${listProduct1}" var="product">
						<a href="/shoponline/productDetail/${product.id}">
							<div class="col-lg-3 col-sm-6">
								<div class="product-item">
									<div class="pi-pic">
										<img src="<c:url value='/resources/image/products/${product.image}'/>" alt="" class="productLoadMoreeee">
										<div class="pi-links">
											<a href="/shoponline/productDetail/${product.id}" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
											<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
										</div>
									</div>
									<div class="pi-text">
										<h6>${product.price}</h6>
										<p class="productNameLoadMore">${product.productName } </p>
									</div>
								</div>
							</div>
						</a>
				</c:forEach>	
			</div>
			<div class="text-center pt-5">
				<button class="site-btn sb-line sb-dark" id="loadmore" data-trangThu="${tongSoLuongSanPham}">LOAD MORE</button>
			</div>
			
			
				<c:choose>
					<c:when test="${soLuongSanPhamTimKiem > 0 }">
						<div class="row"><p style="color:red; display: block; margin-left: 5%;font-size: 20px; font-weight: 4%;">${soLuongSanPhamTimKiem } results for ' ${ParameterSearch } '</p></div>
						<div class="row">
							<c:forEach items="${listProductSearch}" var="listProductSearch">
									<a href="/shoponline/productDetail/${listProductSearch.id}">
										<div class="col-lg-3 col-sm-6">
											<div class="product-item">
												<div class="pi-pic">
													<img src="<c:url value='/resources/image/products/${listProductSearch.image}'/>" alt="">
													<div class="pi-links">
														<a href="/shoponline/productDetail/${listProductSearch.id}" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
														<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
													</div>
												</div>
												<div class="pi-text">
													<h6>${listProductSearch.price}</h6>
													<p>${listProductSearch.productName } </p>
												</div>
											</div>
										</div>
									</a>
							</c:forEach>
							</div>
					</c:when>
					<c:when test="${soLuongSanPhamTimKiem == 0 }">
						<div class="row">
							<h4 style="color:red; text-align: center;">product is not exists ....</h4>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
	</section>
	<!-- Product filter section end -->


	<!-- Banner section -->
	<section class="banner-section">
		<div class="container">
			<div class="banner set-bg" data-setbg="<c:url value='/resources/home/img/banner-bg.jpg'/>">
				<div class="tag-new">NEW</div>
				<span>New Arrivals</span>
				<h2>STRIPED SHIRTS</h2>
				<a href="#" class="site-btn">SHOP NOW</a>
			</div>
		</div>
	</section>
	<!-- Banner section end  -->


	<!-- Footer section -->
	<c:import url="footer-web.jsp"></c:import>
	<!-- Footer section end -->



	<!--====== Javascripts & Jquery ======-->
	<script src="<c:url value='/resources/home/js/jquery-3.2.1.min.js'/>"></script>
	<script src="<c:url value='/resources/home/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/resources/home/js/jquery.slicknav.min.js'/>"></script>
	<script src="<c:url value='/resources/home/js/owl.carousel.min.js'/>"></script>
	<script src="<c:url value='/resources/home/js/jquery.nicescroll.min.js'/>"></script>
	<script src="<c:url value='/resources/home/js/jquery.zoom.min.js'/>"></script>
	<script src="<c:url value='/resources/home/js/jquery-ui.min.js'/>"></script>
	<script src="<c:url value='/resources/home/js/main.js'/>"></script>
	<script src="<c:url value='/resources/js/gioHang.js'/>"></script>
	</body>
</html>
