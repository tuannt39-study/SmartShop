<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
                            <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
                            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                            <li class="sidebar-toggler-wrapper hide">
                                <div class="sidebar-toggler">
                                    <span></span>
                                </div>
                            </li>
                            <!-- END SIDEBAR TOGGLER BUTTON -->
                            <li class="nav-item  ">
                                <a href="/WebApp/admin" class="nav-link nav-toggle">
                                    <i class="icon-home"></i>
                                    <span class="title">Trang chủ</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="javascript:;" class="nav-link nav-toggle">
                                    <i class="icon-user"></i>
                                    <span class="title">Tài Khoản</span>
                                    <span class="arrow"></span>
                                </a>
                                <ul class="sub-menu">
                                    <li class="nav-item  ">
                                        <a href="/WebApp/admin/account" class="nav-link ">
                                            <span class="title">Quản lý tài khoản</span>
                                        </a>
                                    </li>
                                    <li class="nav-item  ">
                                        <a href="/WebApp/admin/login-log" class="nav-link ">
                                            <span class="title">Quản lý lượt đăng nhập</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item  ">
                                <a href="javascript:;" class="nav-link nav-toggle">
                                    <i class="icon-layers"></i>
                                    <span class="title">Sản Phẩm</span>
                                    <span class="arrow"></span>
                                </a>
                                <ul class="sub-menu">
                                    <li class="nav-item  ">
                                        <a href="/WebApp/admin/product" class="nav-link ">
                                            <span class="title">Danh mục sản phẩm</span>
                                        </a>
                                    </li>
                                    <li class="nav-item  ">
                                        <a href="/WebApp/admin/product-category" class="nav-link ">
                                            <span class="title">Quản lý sản phẩm</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item  ">
                                <a href="javascript:;" class="nav-link nav-toggle">
                                    <i class="icon-social-dribbble"></i>
                                    <span class="title">Tin Tức</span>
                                    <span class="arrow"></span>
                                </a>
                                <ul class="sub-menu">
                                    <li class="nav-item  ">
                                        <a href="/WebApp/admin/news-category" class="nav-link ">
                                            <span class="title">Chuyên mục tin tức</span>
                                        </a>
                                    </li>
                                    <li class="nav-item  ">
                                        <a href="/WebApp/admin/news" class="nav-link ">
                                            <span class="title">Quản lý bài viết</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item  ">
                                <a href="/WebApp/admin/oder" class="nav-link nav-toggle">
                                    <i class="icon-basket"></i>
                                    <span class="title">Đơn đặt hàng</span>
                                </a>
                            </li>
                            <li class="nav-item  ">
                                <a href="javascript:;" class="nav-link nav-toggle">
                                    <i class="icon-settings"></i>
                                    <span class="title">Liên hệ</span>
                                    <span class="arrow"></span>
                                </a>
                                <ul class="sub-menu">
                                    <li class="nav-item  ">
                                        <a href="/WebApp/admin/contact" class="nav-link ">
                                            <span class="title">Liên hệ</span>
                                        </a>
                                    </li>
                                    <li class="nav-item  ">
                                        <a href="/WebApp/admin/feedback" class="nav-link ">
                                            <span class="title">Phản hồi</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
