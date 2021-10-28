<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>

	<!-- popup : start -->
	<div  class="popup_wrap white_blank" id="popupDiv"></div>
	<!-- popup : end -->

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

	<div class="popup_window drag w_1000" style="min-width:400px">
		<div class="popup_header">
			<h1>DNC리스트 데이터소스 관리</h1>
			<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
		</div>
		<div class="popup_content" style="overflow:hidden;height:700px">
			<!-- popup_body : start -->
			<div class="popup_body inner_contents">
				<div class="w_100p" style="height:30px">
					<div class="title f_l" style="width:auto">
						<h2 class="title_2nd mt_5">[<b id="dncListNm"></b>] DNC리스트에 대한 데이터소스 목록</h2>
					</div>
					<div class="f_l ml_10 w_100" style="height:30px">
						<select id="schCycle" class="select_type01" title="조회주기">
							<option value="">정지</option>
							<option value="3" selected>3초</option>
							<option value="5">5초</option>
							<option value="10">10초</option>
							<option value="20">20초</option>
						</select>
					</div>
				</div>
				<!-- title : end -->
				<!-- table : start -->
				<div class="board_A0_L a_c type_grid" id="divGrid">
					<table id="dataGrid"></table>
					<tags:pagingECM srchFuncNm="dataListSearch" gridId="dataGrid"/>
				</div>				<!-- table : end -->
				<div class="popup_footer" style="margin-top:10px">
					<div class="button a_r">
						<button type="button" class="btn btn_secondary btn_size_n" id="addDatasource">
							<i class="xi-plus-circle"></i>등록
						</button>
						<button type="button" class="btn btn_secondary btn_size_n" id="excute">
							<i class="xi-play"></i>데이터소스 실행
						</button>
						<button type="button" class="btn btn_primary btn_size_n" id="delete">
							<i class="xi-trash"></i>삭제
						</button>
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
		var selectedDnclistId = "${dnclistId}";
	</script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cu/nc/CUNC0101.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />