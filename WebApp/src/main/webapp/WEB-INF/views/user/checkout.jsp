<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>SMART-SHOP | Đặt hàng</title>
    <jsp:include page="../layout/user/head.jsp"></jsp:include>
</head><!--/head-->

<body>
	<header id="header"><!--header-->
    	<jsp:include page="../layout/user/header.jsp"></jsp:include>
	</header><!--/header-->
	
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<h4>Đặt hàng</h4>
			</div>
			<div class="checkout-options">
				<h3>Người dùng mới</h3>
			</div><!--/checkout-options-->

			<div class="register-req">
				<p>Cảm ơn quý khách đã mua hàng của chúng tôi!</p>
			</div><!--/register-req-->

			<div class="shopper-informations">
				<div class="row">
					<div class="col-sm-3">
						<div class="shopper-info">
							<p>Hóa đơn</p>
							<form>
								<input type="text" placeholder="Họ tên">
								<input type="text" placeholder="Địa chỉ">
								<input type="password" placeholder="Số điện thoại">
								<input type="password" placeholder="Địa chỉ email">
							</form>
							<a class="btn btn-primary" href="">Reset</a>
							<a class="btn btn-primary" href="">Xác nhận hóa đơn</a>

						</div>
					</div>
					<div class="col-sm-5 clearfix">
						<div class="bill-to">
							<p>Ghi chú</p>
							<div class="form-one">
							       <textarea name="message"  placeholder=" " rows="10"></textarea>
							</div>
						</div>
					</div>				
				</div>
			</div>
			<div class="review-payment">
				<h2>Tổng tiền</h2>
			</div>

			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="description">Mã sản phẩm</td>
							<td class="image">Sản phẩm</td>
							<td class="description">Thông tin</td>
							<td class="price">Giá</td>
							<td class="quantity">Số lượng</td>
							<td class="total">Tổng tiền</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="cart_description"><p>1089771</p></td>
							<td class="cart_product">
								<a href=""><img src="<c:url value="/assets/users/images/cart/one.png" />" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">Black Scuba</a></h4>
							</td>
							<td class="cart_price">
								<p>$59</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">$59</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
						</tr>

						<tr>
							<td class="cart_description"><p>1089772</p></td>
							<td class="cart_product">
								<a href=""><img src="<c:url value="/assets/users/images/cart/two.png" />" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">Spink Scuba</a></h4>
							</td>
							<td class="cart_price">
								<p>$59</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">$59</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
						</tr>
						<tr>
							<td class="cart_description"><p>1089773</p></td>
							<td class="cart_product">
								<a href=""><img src="<c:url value="/assets/users/images/cart/three.png" />" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">Solid Scuba</a></h4>
							</td>
							<td class="cart_price">
								<p>$59</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">$59</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tr>
										<td>Tổng tiền</td>
										<td>$177</td>
									</tr>
									<tr class="shipping-cost">
										<td>Phí vận chuyển</td>
										<td>Miễn phí</td>										
									</tr>
									<tr>
										<td>Thanh toán</td>
										<td><span>$177</span></td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->

	

	<footer id="footer"><!--Footer-->
		<jsp:include page="../layout/user/footer.jsp"></jsp:include>
	</footer><!--/Footer-->
	
	<jsp:include page="../layout/user/headend.jsp"></jsp:include>
</body>
</html>