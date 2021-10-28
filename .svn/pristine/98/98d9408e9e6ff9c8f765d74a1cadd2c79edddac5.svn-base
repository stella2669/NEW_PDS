<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate value="${today}" pattern="yyyyMMddhhmmss" var="nowDate" scope="session"/>	
<!DOCTYPE html>
<html lang="ko">
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
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dash_board.css'/>" />		
		
		<script type="text/javascript" src="<c:url value='/resources/js/libs/jquery-3.2.0.min.js'/>"></script>		
		<script type="text/javascript" src="<c:url value='/resources/js/libs/jquery-ui.js'/>"></script>			
		<script type="text/javascript" src="<c:url value='/resources/js/libs/jquery.jqGrid.min.js'/>"></script>	
		<script type="text/javascript" src="<c:url value='/resources/js/libs/jquery.bxslider.js'/>"></script>	
		
		<script type="text/javascript" src="<c:url value='/dwr/engine.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/dwr/util.js'/>"></script>	
		
		<script type="text/javascript" src="<c:url value='/resources/js/common/browserStorage.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/layoutSession.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/common.js?timestamp=${nowDate}'/>"></script>	
		<script type="text/javascript" src="<c:url value='/resources/js/common/llynxAlert.js?timestamp=${nowDate}'/>"></script>	
		<script type="text/javascript" src="<c:url value='/resources/js/common/session_check.js?timestamp=${nowDate}'/>"></script>	
		<script type="text/javascript" src="<c:url value='/resources/js/common/grid.js?timestamp=${nowDate}'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/crypto.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/eventHandler.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/popup.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/resources/js/common/datepicker.js'/>"></script>

		<script type="text/javascript">
			// 브라우저 자동완성 제거
			$(document).ready(function() {
				$(":input").on("focus", function() {
					$(this).attr("autocomplete", "off");
				});
			});
		</script> 
	</head>