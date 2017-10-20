<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->

    <head>
        <title>SMART-SHOP | Đơn đặt hàng - ADMIN</title>
        <jsp:include page="../layout/admin/head.jsp"></jsp:include>
    </head>
    <!-- END HEAD -->

    <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white page-md">
        <div class="page-wrapper">
            <!-- BEGIN HEADER -->
            <div class="page-header navbar navbar-fixed-top">
                <!-- BEGIN HEADER INNER -->
                <div class="page-header-inner ">
                    <jsp:include page="../layout/admin/header.jsp"></jsp:include>
                </div>
                <!-- END HEADER INNER -->
            </div>
            <!-- END HEADER -->
            <!-- BEGIN HEADER & CONTENT DIVIDER -->
            <div class="clearfix"> </div>
            <!-- END HEADER & CONTENT DIVIDER -->
            <!-- BEGIN CONTAINER -->
            <div class="page-container">
                <!-- BEGIN SIDEBAR -->
                <div class="page-sidebar-wrapper">
                    <!-- BEGIN SIDEBAR -->
                    <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
                    <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
                    <div class="page-sidebar navbar-collapse collapse">
                        <!-- BEGIN SIDEBAR MENU -->
                        <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
                            <jsp:include page="../layout/admin/sidebar.jsp"></jsp:include>
                        </ul>
                        <!-- END SIDEBAR MENU -->
                    </div>
                    <!-- END SIDEBAR -->
                </div>
                <!-- END SIDEBAR -->
                <!-- BEGIN CONTENT -->
                <div class="page-content-wrapper">
                    <!-- BEGIN CONTENT BODY -->
                    <div class="page-content">
                        <!-- BEGIN PAGE HEADER-->
                        <!-- BEGIN PAGE BAR -->
                        <div class="page-bar">
                            <ul class="page-breadcrumb">
                                <li>
                                    <a href="javascript:;">Trang chủ</a>
                                    <i class="fa fa-circle"></i>
                                </li>
                                <li>
                                    <a href="javascript:;">Đơn đặt hàng</a>
                                    <i class="fa fa-circle"></i>
                                </li>
                                <li>
                                    <span>Chi tiết đơn hàng</span>
                                </li>
                            </ul>
                        </div>
                        <!-- END PAGE BAR -->
                        <!-- BEGIN PAGE TITLE-->
                        <h1 class="page-title"> Chi tiết đơn hàng 1 </h1>
                        <!-- END PAGE TITLE-->
                        <!-- END PAGE HEADER-->
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="portlet grey-cascade box">
                                    <div class="portlet-title">
                                        <div class="caption">
                                            <i class="fa fa-cogs"></i>Chi tiết đơn hàng 
                                        </div>
                                    </div>
                                    <div class="portlet-body">
                                        <div class="table-responsive">
                                            <table class="table table-hover table-bordered table-striped">
                                                <thead>
                                                    <tr>
                                                        <th> STT </th>
                                                        <th> Tên sản phẩm </th> 
                                                        <th> Số lượng </th>
                                                        <th> Thành tiền </th>
                                                        <th> Trạng thái </th>
                                                        <th> Ghi chú </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td> 1 </td>
                                                        <td>
                                                            <a href="javascript:;"> Áo khoác Bommer 2 </a>
                                                        </td>
                                                        <td> 2 </td>
                                                        <td> 500000 </td>
                                                        <td> <span class="label label-sm label-success"> Còn hàng </td>
                                                        <td> Không </td>
                                                    </tr>
                                                        <td> 2 </td>
                                                        <td>
                                                            <a href="javascript:;"> Áo khoác Bommer 2 </a>
                                                        </td>
                                                        <td> 2 </td>
                                                        <td> 500000 </td>
                                                        <td> <span class="label label-sm label-danger"> Hết hàng </td>
                                                        <td> Không </td>
                                                    </tr>
                                                    <tr>
                                                        <td> 3 </td>
                                                        <td>
                                                            <a href="javascript:;"> Áo khoác Bommer 2 </a>
                                                        </td>
                                                        <td> 2 </td>
                                                        <td> 500000 </td>
                                                        <td> <span class="label label-sm label-success"> Còn hàng </td>
                                                        <td> Không </td>
                                                    </tr>
                                                        <td> 4 </td>
                                                        <td>
                                                            <a href="javascript:;"> Áo khoác Bommer 2 </a>
                                                        </td>
                                                        <td> 2 </td>
                                                        <td> 500000 </td>
                                                        <td> <span class="label label-sm label-success"> Còn hàng </td>
                                                        <td> Không </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- END CONTENT BODY -->
                </div>
                <!-- END CONTENT -->
            </div>
            <!-- END CONTAINER -->
            <!-- BEGIN FOOTER -->
            <div class="page-footer">
                <jsp:include page="../layout/admin/footer.jsp"></jsp:include>
            </div>
            <!-- END FOOTER -->
        </div>
        
        <jsp:include page="../layout/admin/headend.jsp"></jsp:include>
    </body>

</html>