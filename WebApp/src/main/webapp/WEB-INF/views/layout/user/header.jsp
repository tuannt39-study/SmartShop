<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 871</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> itsol@domain.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.html"><img src="<c:url value="/assets/users/images/home/logo.png" />" alt="" /></a>
						</div>
						<div class="btn-group pull-right">
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="javascript:;"><i class="fa fa-user"></i> Tài khoản</a></li>
								<li><a href="/WebApp/dat-hang"><i class="fa fa-crosshairs"></i> Đơn đặt hàng</a></li>
								<li><a href="/WebApp/gio-hang"><i class="fa fa-shopping-cart"></i> Giỏ hàng</a></li>
								<li><a href="/WebApp/dang-nhap"><i class="fa fa-lock"></i> Đăng nhập</a></li>
								<li><a href="/WebApp/dang-ky"><i class="fa fa-unlock"></i> Đăng ký</a></li>
								<li><a href="/WebApp/admin"> ADMIN</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index.html" class="active">Trang chủ</a></li>
								<li class="dropdown"><a href="#">Nam<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="/WebApp/san-pham">Quần áo</a></li>
										<li><a href="/WebApp/san-pham">Giày dép</a></li> 
                                    </ul>
                                </li> 
                                <li class="dropdown"><a href="#">Nữ<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="/WebApp/san-pham">Quần áo</a></li>
										<li><a href="/WebApp/san-pham">Giày dép</a></li> 
                                    </ul>
                                </li>
                                <li><a href="/WebApp/tin-tuc">Tin tức</a></li>
								<li><a href="/WebApp/lien-he">Liên hệ</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Tìm kiếm..."/>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->