<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->

    <head>
        <title>SMART-SHOP | Tài khoản - ADMIN</title>
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
                                    <a href="javascript:;">Tài Khoản</a>
                                    <i class="fa fa-circle"></i>
                                </li>
                                <li>
                                    <span>Quản lý tài Khoản</span>
                                </li>
                            </ul>
                        </div>
                        <!-- END PAGE BAR -->
                        <!-- BEGIN PAGE TITLE-->
                        <h1 class="page-title"> Quản lý tài Khoản </h1>
                        <!-- END PAGE TITLE-->
                        <!-- END PAGE HEADER-->
                        <div class="row">
                            <div class="col-md-12">
                                <!-- BEGIN EXAMPLE TABLE PORTLET-->
                                <div class="portlet light bordered">
                                    <div class="portlet-title">
                                        <div class="caption font-dark">
                                            <i class="icon-settings font-dark"></i>
                                            <span class="caption-subject bold uppercase"> Quản lý tài Khoản </span>
                                        </div>
                                    </div>
                                    <div class="portlet-body">
                                        <div class="table-toolbar">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="btn-group">
                                                        <a href="/WebApp/admin/account/form"><button id="sample_editable_1_new" class="btn sbold green"> Thêm tài khoản
                                                            <i class="fa fa-plus"></i>
                                                        </button></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
                                            <thead>
                                                <tr>
                                                    <th> Mã </th>
                                                    <th> Tên tài khoản </th>
                                                    <th> Email </th>
                                                    <th> Họ tên </th>
                                                    <th> Điện thoại </th>
                                                    <th> Địa chỉ </th>
                                                    <th> Ngày tạo </th>
                                                    <th> Quyền </th>
                                                    <th> Trạng thái </th>
                                                    <th> Thao tác </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr class="odd gradeX">
                                                    <td> 1 </td>
                                                    <td> tuannt39 </td>
                                                    <td>
                                                        <a href="mailto:shuxer@gmail.com"> tuannt39@gmail.com </a>
                                                    </td>
                                                    <td> Nguyễn Thế Tuân </td>
                                                    <td> 096523945783 </td>
                                                    <td> Hà Nội </td>
                                                    <td> 30-10-2017 20:09:40 </td>
                                                    <td>
                                                        <span class="label label-sm label-info"> Quản lý </span>
                                                    </td>
                                                    <td>
                                                        <span class="label label-sm label-success"> Hoạt động </span>
                                                    </td>
                                                    <td>
                                                        <a href="account_form.html"><span class="label label-sm label-warning"> Sửa </span></a>
                                                    </td>
                                                </tr>
                                                <tr class="odd gradeX">
                                                    <td> 2 </td>
                                                    <td> tuannt39 </td>
                                                    <td>
                                                        <a href="mailto:shuxer@gmail.com"> tuannt39@gmail.com </a>
                                                    </td>
                                                    <td> Nguyễn Thế Tuân </td>
                                                    <td> 096523945783 </td>
                                                    <td> Hà Nội </td>
                                                    <td> 30-10-2017 20:09:40 </td>
                                                    <td>
                                                        <span class="label label-sm label-info"> Khách hàng </span>
                                                    </td>
                                                    <td>
                                                        <span class="label label-sm label-danger"> Khóa </span>
                                                    </td>
                                                    <td>
                                                        <a href="account_form.html"><span class="label label-sm label-warning"> Sửa </span></a>
                                                    </td>
                                                </tr>
                                                <tr class="odd gradeX">
                                                    <td> 3 </td>
                                                    <td> tuannt39 </td>
                                                    <td>
                                                        <a href="mailto:shuxer@gmail.com"> tuannt39@gmail.com </a>
                                                    </td>
                                                    <td> Nguyễn Thế Tuân </td>
                                                    <td> 096523945783 </td>
                                                    <td> Hà Nội </td>
                                                    <td> 30-10-2017 20:09:40 </td>
                                                    <td>
                                                        <span class="label label-sm label-info"> Sales </span>
                                                    </td>
                                                    <td>
                                                        <span class="label label-sm label-success"> Hoạt động </span>
                                                    </td>
                                                    <td>
                                                        <a href="account_form.html"><span class="label label-sm label-warning"> Sửa </span></a>
                                                    </td>
                                                </tr>
                                                <tr class="odd gradeX">
                                                    <td> 4 </td>
                                                    <td> tuannt39 </td>
                                                    <td>
                                                        <a href="mailto:shuxer@gmail.com"> tuannt39@gmail.com </a>
                                                    </td>
                                                    <td> Nguyễn Thế Tuân </td>
                                                    <td> 096523945783 </td>
                                                    <td> Hà Nội </td>
                                                    <td> 30-10-2017 20:09:40 </td>
                                                    <td>
                                                        <span class="label label-sm label-info"> Marketing </span>
                                                    </td>
                                                    <td>
                                                        <span class="label label-sm label-success"> Hoạt động </span>
                                                    </td>
                                                    <td>
                                                        <a href="account_form.html"><span class="label label-sm label-warning"> Sửa </span></a>
                                                    </td>
                                                </tr>
                                                <tr class="odd gradeX">
                                                    <td> 5 </td>
                                                    <td> tuannt39 </td>
                                                    <td>
                                                        <a href="mailto:shuxer@gmail.com"> tuannt39@gmail.com </a>
                                                    </td>
                                                    <td> Nguyễn Thế Tuân </td>
                                                    <td> 096523945783 </td>
                                                    <td> Hà Nội </td>
                                                    <td> 30-10-2017 20:09:40 </td>
                                                    <td>
                                                        <span class="label label-sm label-info"> Khách hàng </span>
                                                    </td>
                                                    <td>
                                                        <span class="label label-sm label-danger"> Khóa </span>
                                                    </td>
                                                    <td>
                                                        <a href="account_form.html"><span class="label label-sm label-warning"> Sửa </span></a>
                                                    </td>
                                                </tr>
                                                <tr class="odd gradeX">
                                                    <td> 6 </td>
                                                    <td> tuannt39 </td>
                                                    <td>
                                                        <a href="mailto:shuxer@gmail.com"> tuannt39@gmail.com </a>
                                                    </td>
                                                    <td> Nguyễn Thế Tuân </td>
                                                    <td> 096523945783 </td>
                                                    <td> Hà Nội </td>
                                                    <td> 30-10-2017 20:09:40 </td>
                                                    <td>
                                                        <span class="label label-sm label-info"> Khách hàng </span>
                                                    </td>
                                                    <td>
                                                        <span class="label label-sm label-success"> Hoạt động </span>
                                                    </td>
                                                    <td>
                                                        <a href="account_form.html"><span class="label label-sm label-warning"> Sửa </span></a>
                                                    </td>
                                                </tr>
                                                <tr class="odd gradeX">
                                                    <td> 7 </td>
                                                    <td> tuannt39 </td>
                                                    <td>
                                                        <a href="mailto:shuxer@gmail.com"> tuannt39@gmail.com </a>
                                                    </td>
                                                    <td> Nguyễn Thế Tuân </td>
                                                    <td> 096523945783 </td>
                                                    <td> Hà Nội </td>
                                                    <td> 30-10-2017 20:09:40 </td>
                                                    <td>
                                                        <span class="label label-sm label-info"> Khách hàng </span>
                                                    </td>
                                                    <td>
                                                        <span class="label label-sm label-success"> Hoạt động </span>
                                                    </td>
                                                    <td>
                                                        <a href="account_form.html"><span class="label label-sm label-warning"> Sửa </span></a>
                                                    </td>
                                                </tr>
                                                <tr class="odd gradeX">
                                                    <td> 8 </td>
                                                    <td> tuannt39 </td>
                                                    <td>
                                                        <a href="mailto:shuxer@gmail.com"> tuannt39@gmail.com </a>
                                                    </td>
                                                    <td> Nguyễn Thế Tuân </td>
                                                    <td> 096523945783 </td>
                                                    <td> Hà Nội </td>
                                                    <td> 30-10-2017 20:09:40 </td>
                                                    <td>
                                                        <span class="label label-sm label-info"> Khách hàng </span>
                                                    </td>
                                                    <td>
                                                        <span class="label label-sm label-success"> Hoạt động </span>
                                                    </td>
                                                    <td>
                                                        <a href="account_form.html"><span class="label label-sm label-warning"> Sửa </span></a>
                                                    </td>
                                                </tr>
                                                <tr class="odd gradeX">
                                                    <td> 9 </td>
                                                    <td> tuannt39 </td>
                                                    <td>
                                                        <a href="mailto:shuxer@gmail.com"> tuannt39@gmail.com </a>
                                                    </td>
                                                    <td> Nguyễn Thế Tuân </td>
                                                    <td> 096523945783 </td>
                                                    <td> Hà Nội </td>
                                                    <td> 30-10-2017 20:09:40 </td>
                                                    <td>
                                                        <span class="label label-sm label-info"> Khách hàng </span>
                                                    </td>
                                                    <td>
                                                        <span class="label label-sm label-success"> Hoạt động </span>
                                                    </td>
                                                    <td>
                                                        <a href="account_form.html"><span class="label label-sm label-warning"> Sửa </span></a>
                                                    </td>
                                                </tr>
                                                <tr class="odd gradeX">
                                                    <td> 10 </td>
                                                    <td> tuannt39 </td>
                                                    <td>
                                                        <a href="mailto:shuxer@gmail.com"> tuannt39@gmail.com </a>
                                                    </td>
                                                    <td> Nguyễn Thế Tuân </td>
                                                    <td> 096523945783 </td>
                                                    <td> Hà Nội </td>
                                                    <td> 30-10-2017 20:09:40 </td>
                                                    <td>
                                                        <span class="label label-sm label-info"> Khách hàng </span>
                                                    </td>
                                                    <td>
                                                        <span class="label label-sm label-success"> Hoạt động </span>
                                                    </td>
                                                    <td>
                                                        <a href="account_form.html"><span class="label label-sm label-warning"> Sửa </span></a>
                                                    </td>
                                                </tr>
                                                <tr class="odd gradeX">
                                                    <td> 11 </td>
                                                    <td> tuannt39 </td>
                                                    <td>
                                                        <a href="mailto:shuxer@gmail.com"> tuannt39@gmail.com </a>
                                                    </td>
                                                    <td> Nguyễn Thế Tuân </td>
                                                    <td> 096523945783 </td>
                                                    <td> Hà Nội </td>
                                                    <td> 30-10-2017 20:09:40 </td>
                                                    <td>
                                                        <span class="label label-sm label-info"> Khách hàng </span>
                                                    </td>
                                                    <td>
                                                        <span class="label label-sm label-success"> Hoạt động </span>
                                                    </td>
                                                    <td>
                                                        <a href="account_form.html"><span class="label label-sm label-warning"> Sửa </span></a>
                                                    </td>
                                                </tr>
                                                <tr class="odd gradeX">
                                                    <td> 12 </td>
                                                    <td> tuannt39 </td>
                                                    <td>
                                                        <a href="mailto:shuxer@gmail.com"> tuannt39@gmail.com </a>
                                                    </td>
                                                    <td> Nguyễn Thế Tuân </td>
                                                    <td> 096523945783 </td>
                                                    <td> Hà Nội </td>
                                                    <td> 30-10-2017 20:09:40 </td>
                                                    <td>
                                                        <span class="label label-sm label-info"> Khách hàng </span>
                                                    </td>
                                                    <td>
                                                        <span class="label label-sm label-success"> Hoạt động </span>
                                                    </td>
                                                    <td>
                                                        <a href="account_form.html"><span class="label label-sm label-warning"> Sửa </span></a>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <!-- END EXAMPLE TABLE PORTLET-->
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