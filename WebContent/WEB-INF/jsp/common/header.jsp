<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate value="${today}" pattern="yyyyMMddhhmmss" var="nowDate" scope="session"/>
<!DOCTYPE html>
<html lang="ko" style="height:100%">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" >
		<meta name="format-detection" content="telephone=no" >

		<title>PDS Manager</title>

		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/var.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/reset.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/jquery-ui.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/ui.jqgrid.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/animate.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/xeicon.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/roboto.css'/>" />

		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/common.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/layout.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/button.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/board.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/pass.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/libs/jquery.datetimepicker/jquery.datetimepicker.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dash_board.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/libs/jquery.treeview/jquery.treeview.css'/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/libs/jqwidgets/styles/jqx.base.css" type="text/css'/>" />

		<script type="text/javascript" src="<c:url value='/resources/js/libs/jquery-3.2.0.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/libs/jquery.form.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/libs/jquery-ui.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/libs/jquery.jqGrid.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/libs/jquery.bxslider.js'/>"></script>

		<script type="text/javascript" src="<c:url value='/resources/js/libs/moment.min.js?timestamp=${nowDate}'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/libs/moment-timezone-with-data-10-year-range.min.js?timestamp=${nowDate}'/>"></script>

		<script type="text/javascript" src="<c:url value='/dwr/engine.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/dwr/util.js'/>"></script>

		<script type="text/javascript" src="<c:url value='/resources/js/common/browserStorage.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/session.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/xml2json.js?timestamp=${nowDate}'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/xmlSchema.js?timestamp=${nowDate}'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/common.js?timestamp=${nowDate}'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/ECMCommon.js?timestamp=${nowDate}'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/llynxAlert.js?timestamp=${nowDate}'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/grid.js?timestamp=${nowDate}'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/crypto.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/eventHandler.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/popup.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/datepicker.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/libs/jquery.datetimepicker/jquery.datetimepicker.full.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/libs/jquery.treeview/lib/jquery.cookie.js?timestamp=${nowDate}'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/libs/jquery.treeview/jquery.treeview.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxcore.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxdata.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxdraw.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxchart.core.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxcore.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxdata.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxdraw.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxscrollbar.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxbuttons.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxchart.core.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/globalization/globalize.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxsortable.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxribbon.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxmenu.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxwindow.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxlayout.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxdockinglayout.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxdockpanel.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxdragdrop.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxdatatable.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxlistbox.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxwindow.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxbuttons.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxscrollbar.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxlistbox.js?timestamp=${nowDate}'/>"></script>
	    <script type="text/javascript" src="<c:url value='/resources/js/libs/jqwidgets/jqxtree.js?timestamp=${nowDate}'/>"></script>

		<script type="text/javascript">
			// 브라우저 자동완성 제거
			$(document).ready(function() {
				$(":input").on("focus", function() {
					$(this).attr("autocomplete", "off");
				});
			});
		</script>
	</head>