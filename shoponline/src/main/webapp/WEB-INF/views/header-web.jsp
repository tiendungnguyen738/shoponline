 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="shoponline.utils.SecurityUtils" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-lg-2 text-center text-lg-left">
						<!-- logo -->
						<a href="./index.html" class="site-logo">
							<img src="<c:url value='/resources/home/img/logo.png'/>" alt=""/>
						</a>
					</div>
					<div class="col-xl-6 col-lg-5">
						<form class="header-search-form" action="/shoponline/search" method="get">
							<input type="text" placeholder="Search on divisima ...." name="productName">
							<button><i class="flaticon-search"></i></button>
						</form>
					</div>
					<div class="col-xl-4 col-lg-5">
						<div class="user-panel">
							<div class="up-item">
							<!-- lưu ý: để sử dụng được security:authorize thì cần import thư viện securiry taglib vào pom
								và khai báo thư viện trong file jsp-->
							<!-- isAnonymous(): dịch nôm na là ẩn danh - tức chưa đăng nhập -->
								<security:authorize access = "isAnonymous()">
									<i class="flaticon-profile"></i>
									<a href="/shoponline/dang-nhap">Sign</a> In or <a href="#">Create Account</a>
								</security:authorize>
							<!--  isAuthenticated: là đã đăng nhập rồi-->
								<security:authorize access = "isAuthenticated()">
									Hello, <%=SecurityUtils.getPrincipal().getUserName() %>
									<a class="nav-link" href="<c:url value='/thoat'/>">Exit</a>
								</security:authorize>
							</div>
							<div class="up-item">
								<div class="shopping-card">
									<i class="flaticon-bag"></i>
									<span>${soLuongSanPham }</span>
								</div>
								<a href="/shoponline/gio-hang">Shopping Cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>