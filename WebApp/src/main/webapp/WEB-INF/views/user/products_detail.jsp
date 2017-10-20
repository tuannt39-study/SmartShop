<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>SMART-SHOP | Chi tiết sản phẩm</title>
    <jsp:include page="../layout/user/head.jsp"></jsp:include>
</head><!--/head-->

<body>
	<header id="header"><!--header-->
    	<jsp:include page="../layout/user/header.jsp"></jsp:include>
	</header><!--/header-->
	
	
	<section id="advertisement">
		<div class="container">
			<img src="<c:url value="/assets/users/images/shop/advertisement.jpg"  />" alt="" />
		</div>
	</section>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Danh mục sản phẩm</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#sportswear">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											Nam
										</a>
									</h4>
								</div>
								<div id="sportswear" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#">Nike </a></li>
											<li><a href="#">Under Armour </a></li>
											<li><a href="#">Adidas </a></li>
											<li><a href="#">Puma</a></li>
											<li><a href="#">ASICS </a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#mens">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											Nữ
										</a>
									</h4>
								</div>
								<div id="mens" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#">Fendi</a></li>
											<li><a href="#">Guess</a></li>
											<li><a href="#">Valentino</a></li>
											<li><a href="#">Dior</a></li>
											<li><a href="#">Versace</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">Túi</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">Giày</a></h4>
								</div>
							</div>
						</div><!--/category-products-->
					
						<div class="brands_products"><!--brands_products-->
							<h2>Nhãn hiệu</h2>
							<div class="brands-name">
								<ul class="nav nav-pills nav-stacked">
									<li><a href="#"> <span class="pull-right">(50)</span>Acne</a></li>
									<li><a href="#"> <span class="pull-right">(56)</span>Grüne Erde</a></li>
									<li><a href="#"> <span class="pull-right">(27)</span>Albiro</a></li>
									<li><a href="#"> <span class="pull-right">(32)</span>Ronhill</a></li>
								</ul>
							</div>
						</div><!--/brands_products-->
						
						<div class="shipping text-center"><!--shipping-->
							<img src="<c:url value="/assets/users/images/home/shipping.jpg" />"  alt="" />
						</div><!--/shipping-->
					
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="product_details"><!--product_details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="<c:url value="/assets/users/images/shop/product12.jpg" />" alt="" />
								<h3>ZOOM</h3>
							</div>
							<div id="similar-product" class="carousel slide" data-ride="carousel">
								
								  <!-- Wrapper for slides -->
								    <div class="carousel-inner">
										<div class="item active">
										  <a href=""><img src="<c:url value="/assets/users/images/product_details/similar1.jpg" />"  alt=""></a>
										  <a href=""><img src="<c:url value="/assets/users/images/product_details/similar2.jpg" />"  alt=""></a>
										  <a href=""><img src="<c:url value="/assets/users/images/product_details/similar3.jpg" />"  alt=""></a>
										</div>
										<div class="item">
										  <a href=""><img src="<c:url value="/assets/users/images/product_details/similar1.jpg" />"  alt=""></a>
										  <a href=""><img src="<c:url value="/assets/users/images/product_details/similar2.jpg" />"  alt=""></a>
										  <a href=""><img src="<c:url value="/assets/users/images/product_details/similar3.jpg" />"  alt=""></a>
										</div>
										<div class="item">
										  <a href=""><img src="<c:url value="/assets/users/images/product_details/similar1.jpg" />"  alt=""></a>
										  <a href=""><img src="<c:url value="/assets/users/images/product_details/similar2.jpg" />"  alt=""></a>
										  <a href=""><img src="<c:url value="/assets/users/images/product_details/similar3.jpg" />"  alt=""></a>
										</div>
										
									</div>

								  <!-- Controls -->
								  <a class="left item-control" href="#similar-product" data-slide="prev">
									<i class="fa fa-angle-left"></i>
								  </a>
								  <a class="right item-control" href="#similar-product" data-slide="next">
									<i class="fa fa-angle-right"></i>
								  </a>
							</div>

						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<img src="<c:url value="/assets/users/images/product_details/new.jpg" />"  class="newarrival" alt="" />
								<h2>Anne Klein Sleeveless Colorblock Scuba</h2>
								<p>Web ID: 1089772</p>
								<img src="<c:url value="/assets/users/images/product_details/rating.png" />"  alt="" />
								<span>
									<span> $59</span>
									<label>Sô lượng:</label>
									<input type="text" value="3" />
									<button type="button" class="btn btn-fefault cart">
										<i class="fa fa-shopping-cart"></i>
										Thêm vào giỏ
									</button>
								</span>
								<p><b>Trạng thái:</b> Còn hàng</p>
								<p><b>Loại:</b> Mới</p>
								<p><b>Nhà sản xuất:</b> Smart-shop</p>
								<a href=""><img src="<c:url value="/assets/users/images/product_details/share.png" />"  class="share img-responsive"  alt="" /></a>
							</div><!--/product-information-->
						</div>
					</div><!--/product_details-->
					
					<div class="category-tab shop-details-tab"><!--category-tab-->
						<div class="col-sm-12">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#reviews" data-toggle="tab">Nhận xét (1)</a></li>
							</ul>
						</div>
						
							
							<div class="tab-pane fade active in" id="reviews" >
								<div class="col-sm-12">
									<ul>
										<li><a href=""><i class="fa fa-user"></i>Bui Duc</a></li>
										<li><a href=""><i class="fa fa-clock-o"></i>12:41</a></li>
										<li><a href=""><i class="fa fa-calendar-o"></i>31/12/2014</a></li>
									</ul>
									<p>Sản phẩm rất tuyệt vời.</p>
									<p><b>Viết nhận xét của bạn</b></p>
									
									<form action="#">
										<span>
											<input type="text" placeholder="Địa chỉ email"/>
											<input type="email" placeholder="Mật khẩu"/>
										</span>
										<textarea name="" ></textarea>
										<b>Xếp hạng: </b> <img src="<c:url value="/assets/users/images/product_details/rating.png" />"  alt="" />
										<button type="button" class="btn btn-default pull-right">
											Nhận xét
										</button>
									</form>
								</div>
							</div>
							
						</div>
					</div><!--/category-tab-->
					
					<div class="recommended_items"><!--recommended_items-->
						<h2 class="title text-center">Gợi ý</h2>
						
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">	
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="<c:url value="/assets/users/images/home/recommend1.jpg" />"  alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</button>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="<c:url value="/assets/users/images/home/recommend2.jpg" />"  alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</button>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="<c:url value="/assets/users/images/home/recommend3.jpg" />"  alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="item">	
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="<c:url value="/assets/users/images/home/recommend1.jpg" />"  alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</button>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="<c:url value="/assets/users/images/home/recommend2.jpg" />"  alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</button>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="<c:url value="/assets/users/images/home/recommend3.jpg" />"  alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div><!--/recommended_items-->
					
				</div>
			</div>
		</div>
	</section>
	
	<footer id="footer"><!--Footer-->
		<jsp:include page="../layout/user/footer.jsp"></jsp:include>
	</footer><!--/Footer-->
	
	<jsp:include page="../layout/user/headend.jsp"></jsp:include>
</body>
</html>