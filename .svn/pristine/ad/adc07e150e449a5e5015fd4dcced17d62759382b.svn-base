<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
<!-- 절취선 - 여기서부터 잘라요 : start -->
	<!-- sub_tabs : start -->
	<div id="sub_tabs" class="tabs tab_A0" style="height:100%">

		<ul class="sub_tab_header">
			<li><a href="#sub_tabs-1">DNC리스트 관리</a></li>
			<li><a href="#sub_tabs-2">DNC그룹 관리</a></li>
		</ul>

		<!-- sub_tab_body : start -->
		<div id="sub_tabs-1" class="sub_tab_body ui-tabs-panel ui-corner-bottom ui-widget-content" style="height:calc(100% - 30px)">
			<iframe title="DNC리스트 관리" id="dncListManger" src="<c:url value='/cu/cunc01.do'/>" width="90%" height="100%"></iframe>
		</div>
		<!-- sub_tab_body : end -->

		<!-- sub_tab_body : start -->
		<div id="sub_tabs-2" class="sub_tab_body ui-tabs-panel ui-corner-bottom ui-widget-content" style="height:calc(100% - 30px)">
			<iframe title="DNC그룹 관리" id="dncGroupManager" src="<c:url value='/cu/cunc02.do'/>" width="90%" height="100%"></iframe>
		</div>
		<!-- sub_tab_body : end -->
	</div>
	<!-- sub_tabs : end -->
	<!-- 절취선 - 여기서부터 잘라요 : end -->


	<script>
		$("#sub_tabs").tabs();
	</script>

	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

