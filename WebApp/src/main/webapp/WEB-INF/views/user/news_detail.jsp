<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>SMART-SHOP | Chi tiết tin tức</title>
    <jsp:include page="../layout/user/head.jsp"></jsp:include>
</head><!--/head-->

<body>
	<header id="header"><!--header-->
    	<jsp:include page="../layout/user/header.jsp"></jsp:include>
	</header><!--/header-->
	
	<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>
						
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1><span>SMART</span>-SHOP</h1>
									<h2>Free E-Commerce Template</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<a href="product_details.html"><button type="button" class="btn btn-default get">Mua ngay</button></a>
								</div>
								<div class="col-sm-6">
									<img src="<c:url value="/assets/users/images/home/girl1.jpg"  />" class="girl img-responsive" alt="" />
									<img src="<c:url value="/assets/users/images/home/pricing.png"   />" class="pricing" alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">
									<h1><span>SMART</span>-SHOP</h1>
									<h2>100% Responsive Design</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<a href="product_details.html"><button type="button" class="btn btn-default get">Mua ngay</button></a>
								</div>
								<div class="col-sm-6">
									<img src="<c:url value="/assets/users/images/home/girl2.jpg" />"  class="girl img-responsive" alt="" />
									<img src="<c:url value="/assets/users/images/home/pricing.png"  />"  class="pricing" alt="" />
								</div>
							</div>
							
							<div class="item">
								<div class="col-sm-6">
									<h1><span>SMART</span>-SHOP</h1>
									<h2>Free Ecommerce Template</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<a href="product_details.html"><button type="button" class="btn btn-default get">Mua ngay</button></a>
								</div>
								<div class="col-sm-6">
									<img src="<c:url value="/assets/users/images/home/girl3.jpg" />"  class="girl img-responsive" alt="" />
									<img src="<c:url value="/assets/users/images/home/pricing.png" />"  class="pricing" alt="" />
								</div>
							</div>
							
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
	
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
				
				<div class="col-sm-9">
					<div class="blog-post-area">
						<h2 class="title text-center">Tin Mới Nhất</h2>
						<div class="single-blog-post">
							<h3>Xu hướng thời trang năm nay</h3>
							<div class="post-meta">
								<ul>
									<li><i class="fa fa-user"></i>Tuân GS</li>
									<li><i class="fa fa-clock-o"></i> 1:33 pm</li>
									<li><i class="fa fa-calendar"></i> DEC 5, 2013</li>
								</ul>							
							</div>
							<a href="">
								<img src="<c:url value="/assets/users/images/blog/blog-one.jpg" />"  alt="">
							</a>
							<p>
								Từng đánh chiếm hàng loạt trang báo tại Đại hàn dân quốc, mùa này, bộ đôi Phí Phương Anh - Hoàng Ku tiếp tục mang đến Seoul Fashion Week những trang phục sành điệu và ấn tượng nhất.</p> <br>

							<p>
								Vốn là "tay chơi" hàng hiệu xuất chúng, Hoàng Ku đã "chào sân" Seoul Fashion Week với bộ cánh có giá trị lên đến hơn 700 triệu đồng. Trong khi đó, Phí Phương Anh lại khiến giới mộ điệu tại đây nhìn không chớp mắt khi sải bước trong thiết kế đầy sáng tạo thuộc BST "Em Hoa" của NTK Công Trí -  vốn từng được vinh danh trên Vogue và  được Rihanna chọn mặc.</p> <br>

							<p>
								Đối với những ai không am hiểu về văn hóa Nhật Bản sẽ cho rằng đây là một điều không tốt đối với giới trẻ hay sự dễ dãi của nền giáo dục nhưng thực chất, chiếc váy ngắn giúp cho giới trẻ Nhật Bản nhớ về thời kỳ khó khăn của đất nước, khi tài nguyên còn rất nghèo nàn và sợi vải cũng trở thành một món hàng xa xỉ.</p> <br>

							<p>
								Việc này giúp cho người Nhật Bản rèn luyện tình chịu thương chịu khó và dần dà khi đã trở thành một cường quốc thì người Nhật vẫn giữ nét văn hóa này cho đến ngày nay.
							</p>
							<div class="pager-area">
								<ul class="pager pull-right">
									<li><a href="news_home.html">previ</a></li>
									<li><a href="#">Next</a></li>
								</ul>
							</div>
						</div>
					</div><!--/blog-post-area-->
						<!--/rating-area-->

					<div class="socials-share">
						<a href="https://www.facebook.com/groups/287553211395337/?ref=br_rs"><img src="<c:url value="/assets/users/images/blog/socials.png" />"  alt=""></a>
					</div><!--/socials-share-->
					<!--/Response-area-->
					<!--/Repaly Box-->
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