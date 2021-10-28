<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>

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
	<div class="popup_window drag w_800" style="min-width:400px">
		<div class="popup_header">
			<h1>컨택리스트 연결 특성확인</h1>
			<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
		</div>
		<div class="popup_content">
			<!-- popup_body : start -->
			<div class="popup_body">
				<div class="title">
					<h2 class="title_2nd">컨택리스트 특성목록</h2>
				</div>
				<!-- table : start -->
				<div class="board_A0_L a_c type_grid">
					<table id="attrGrid"></table>
				</div>
				<div class="popup_footer" style="margin-top:10px">
					<div class="button a_r">
						<!-- <button type="button" class="btn btn_secondary btn_size_n" id="save">
							<i class="xi-check"></i>저장
						</button> -->
						<button type="button" class="btn btn_third btn_size_n popup_close">
							<i class="xi-close"></i>닫기
						</button>
					</div>
				</div>
				<!-- popup_footer : end -->
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var selectedContactListId = "${contactListId}";
		var selectedAttrListId = "${attrListId}";
		
	</script>
<%-- 	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script> --%>
	<script type="text/javascript" src="<c:url value='/dwr/interface/CUAT01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cu/co/CUCO05.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />