<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


	<!-- Page info -->
	<div class="page-top-info">
		<div class="container">
			<h4>Giỏ Hàng</h4>
			<div class="site-pagination">
				<a href="">Home</a> /
				<a href="">Giỏ Hàng</a>
			</div>
		</div>
	</div>
	<!-- Page info end -->


	<!-- cart section end -->
	<section class="cart-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="cart-table">
						<h3>Giỏ Hàng</h3>
						<div class="cart-table-warp">
							<table>
							<thead>
								<tr>
									<th class="product-th">Product</th>
									<th class="quy-th">Quantity</th>
									<th class="size-th" style="padding-left:70px;">SizeSize</th>
									<th class="total-th">Price</th>
									<th class="total-th">Color</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listSessionGioHang }" var="gioHang">
									<tr class="thongTinSanPham">
										<td class="product-col">
									 	 <img src="<c:url value='/resources/image/products/${gioHang.getImage() }'/>" alt="">
											<div class="pc-title">
												<h6 class="maSanPham" data-masp="${gioHang.getProductId()}">${gioHang.productName }</h6>
												<p class="priceProduct" data-price="${gioHang.price }">$${gioHang.price }</p>
											</div>
										</td>
										<td class="quy-col">
											<div class="quantity">
						                        <div>
													<input class="thayDoiSoLuong" type="number" style="border-radius: 20px; width: 50px; text-align: center;" min="1" value="${gioHang.getSoLuong() }">
												</div>
	                    					</div>
										</td>
										<td class="size-col" data-masize="${gioHang.getSizeId()}">${gioHang.sizeName }</td>
										<td class="total-col" data-pricePro="${gioHang.price }"></td>
										<td class="size-col color-col" data-mamau="${gioHang.getColorId()}">${gioHang.colorName }</td>
										<td><button type="button" class="btn btn-danger btn-xoaGioHang">Xóa</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
						<div class="total-cost">
							<h6>Tổng Tiền <span id="tongTienThanhToan" data-tongTien="0"></span></h6>
						</div>
					</div>
				</div>
				<div class="col-lg-4 card-right">
					<form class="promo-code-form" action="" method="post">
						<input type="text" placeholder="Enter your name" name="CustomerName" id="CustomerName"><br/>
						<input type="text" placeholder="Enter your phone" name="phone" id="phone"><br/>
						<input type="text" placeholder="Enter your address" name="address" id="address"><br/>
						<input type="text" placeholder="Enter your node" name="node" id="node"><br/>
						<button class="datHang">Đặt Hàng</button>
					</form>
					<a href="" class="site-btn">Proceed to checkout</a>
					<a href="/shoponline/" class="site-btn sb-dark">Continue shopping</a>
				</div>
			</div>
		</div>
	</section>
	<!-- cart section end -->

	<!-- Related product section -->
	<section class="related-product-section">
		<div class="container">
			<div class="section-title text-uppercase">
				<h2>Continue Shopping</h2>
			</div>
			<div class="row">
				<div class="col-lg-3 col-sm-6">
					<div class="product-item">
						<div class="pi-pic">
							<div class="tag-new">New</div>
							<img src="<c:url value='/resources/home/img/product/2.jpg'/>" alt="">
							<div class="pi-links">
								<a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
								<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
							</div>
						</div>
						<div class="pi-text">
							<h6>$35,00</h6>
							<p>Black and White Stripes Dress</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6">
					<div class="product-item">
						<div class="pi-pic">
							<img src="<c:url value='/resources/home/img/product/5.jpg'/>" alt="">
							<div class="pi-links">
								<a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
								<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
							</div>
						</div>
						<div class="pi-text">
							<h6>$35,00</h6>
							<p>Flamboyant Pink Top </p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6">
					<div class="product-item">
						<div class="pi-pic">
							<img src="<c:url value='/resources/home/img/product/9.jpg'/>" alt="">
							<div class="pi-links">
								<a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
								<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
							</div>
						</div>
						<div class="pi-text">
							<h6>$35,00</h6>
							<p>Flamboyant Pink Top </p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6">
					<div class="product-item">
						<div class="pi-pic">
							<img src="<c:url value='/resources/home/img/product/1.jpg'/>" alt="">
							<div class="pi-links">
								<a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
								<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
							</div>
						</div>
						<div class="pi-text">
							<h6>$35,00</h6>
							<p>Flamboyant Pink Top </p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Related product section end -->



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
