<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <!--[if lt IE 9]>
		<script src="<c:url value="/assets/global/plugins/respond.min.js" />"></script>
		<script src="<c:url value="/assets/global/plugins/excanvas.min.js" />"></script> 
		<script src="<c:url value="/assets/global/plugins/ie8.fix.min.js" />"></script> 
		<![endif]-->
        <!-- BEGIN CORE PLUGINS -->
        <script src="<c:url value="/assets/global/plugins/jquery.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/global/plugins/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/global/plugins/js.cookie.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/global/plugins/jquery.blockui.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" />" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <script src="<c:url value="/assets/global/plugins/select2/js/select2.full.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/global/plugins/jquery-validation/js/additional-methods.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/global/plugins/ckeditor/ckeditor.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/global/scripts/datatable.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/global/plugins/datatables/datatables.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" />" type="text/javascript"></script>
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="<c:url value="/assets/global/scripts/app.min.js" />" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script src="<c:url value="/assets/pages/scripts/form-validation.min.js" />" type="text/javascript"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script src="<c:url value="/assets/pages/scripts/table-datatables-managed.min.js" />" type="text/javascript"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="<c:url value="/assets/layouts/layout/scripts/layout.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/layouts/layout/scripts/demo.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/layouts/global/scripts/quick-sidebar.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/assets/layouts/global/scripts/quick-nav.min.js" />" type="text/javascript"></script>
        <!-- END THEME LAYOUT SCRIPTS -->
        <script>
            $(document).ready(function()
            {
                $('#clickmewow').click(function()
                {
                    $('#radio1003').attr('checked', 'checked');
                });
            })
        </script>