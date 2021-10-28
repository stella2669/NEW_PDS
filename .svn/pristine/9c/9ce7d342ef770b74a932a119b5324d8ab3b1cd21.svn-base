<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%-- 공통 해더파일 include  --%>
<c:import url="/WEB-INF/jsp/common/layoutHeader.jsp" />

<body class="frame" style="height:100vh">
	<script  type="text/javascript" src="<c:url value='/resources/js/common/softphone/AvayaETS_CTI_Client.js?timestamp=${nowDate}'/>"></script>
	<script  type="text/javascript" src="<c:url value='/resources/js/common/softphone/MessageDefine.js?timestamp=${nowDate}'/>"></script>
	<script  type="text/javascript" src="<c:url value='/resources/js/common/softphone/softphoneDeclare.js?timestamp=${nowDate}'/>"></script>
	<script  type="text/javascript" src="<c:url value='/resources/js/common/softphone/ctiEventHandler.js?timestamp=${nowDate}'/>"></script>
	<script  type="text/javascript" src="<c:url value='/resources/js/common/softphone/rec.js?timestamp=${nowDate}'/>"></script>

	<!-- skip : start -->
	<div id="skip">
		<ul>
			<li><a href="#header">메뉴 바로가기</a></li>
			<li><a href="#container">본문 바로가기</a></li>
		</ul>
	</div>
	<!-- skip : end -->
	<!-- loading : start -->
	<div class="loading" id="jspLoading">
		<div>
			<span class="loading_progress">
			<i class="lp_1"></i>
			<i class="lp_2"></i>
			<i class="lp_3"></i>
		</span>
			<p>처리중입니다. 잠시만 기다리세요.</p>
		</div>
	</div>
	<!-- loading : end -->

	<!-- popup : start -->
	<div  class="popup_wrap white_blank" id="cmmPoopup"></div>
	<!-- popup : end -->

	<!-- wrap : start -->
	<div id="wrap" style="height:100%">
		<!-- header : start -->
		<header id="header">
			<c:import url="/WEB-INF/jsp/fr/me/FRME01.jsp" />
		</header>
		<!-- header : end -->
		<!-- container : start -->
		<div id="container" style="height:100%">
			<!-- contents : start -->
			<div id="contents" style="height:100%">

				<div id="tabs" class="tabs tab_main mt_10" style="height:100%">
					<ul class="main_tab_header">
						<li class="fix" onclick="activeMenu('')"><a href="#fix-menu1">인트로</a><span class="tooltip">intro</span></li>
					</ul>
					<!-- tab_body : start -->
					<div id="fix-menu1" class="main_tab_body" style="overflow:hidden">
						<iframe title="인트로 탭" id="PG_FRMA_01" src="<c:url value='/fr/frma01.do'/>" width="100%" height="100%"></iframe>

					</div>
					<!-- tab_body : end -->
					<div class="main_tab_ctrl">
						<button id="refreshTab" type="button">
							<i class="xi-refresh"></i><span class="replace_text">새로고침</span>
						</button>
						<button id="prevTab" type="button" class="prev">
							<i class="xi-angle-left-min"></i><span class="replace_text">이전</span>
						</button>
						<button id="nextTab" type="button" class="next">
							<i class="xi-angle-right-min"></i><span class="replace_text">다음</span>
						</button>
						<button id="closeAllTabs" type="button" class="close">
							<i class="xi-close"></i><span class="replace_text">닫기</span>
						</button>
					</div>
					<!-- 메뉴 tab 영역 -->
				</div>
			</div>
			<!-- contents : end -->
		</div>
		<!-- container : end -->
	</div>
	<!-- wrap : end -->

	<script  type="text/javascript" src="<c:url value='/dwr/interface/LOIN01_Service.js'/>"></script>
	<script  type="text/javascript" src="<c:url value='/dwr/interface/FRFR01_Service.js'/>"></script>
	<script  type="text/javascript" src="<c:url value='/dwr/interface/FRME01_Service.js'/>"></script>
	<script  type="text/javascript" src="<c:url value='/dwr/interface/LOOU01_Service.js'/>"></script>
	<script  type="text/javascript" src="<c:url value='/resources/js/fr/fr/FRFR01_00.js?timestamp=${nowDate}'/>"></script>
	<script  type="text/javascript" src="<c:url value='/resources/js/fr/me/FRME01.js?timestamp=${nowDate}'/>"></script>
</body>


<%-- 공통 푸터파일 include  --%>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />