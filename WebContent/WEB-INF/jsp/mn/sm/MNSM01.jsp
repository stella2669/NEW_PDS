<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>


	<form id="excelFrm" method="post" action="/com/excelDown.do">
		<input type="hidden" name="hiddenYn" value="N"/>
		<input type="hidden" name="title"/>
		<input type="hidden" name="fileNm"/>
		<input type="hidden" name="colModel"/>
		<input type="hidden" name="dataList"/>
	</form>

	<!-- wrap : start -->
	<div class="inner_contents">
			<div class="search_A2">
				<div class="sc_input">
					<dl>
						<dt>캠페인명</dt>
						<dd>
							<input id="schCampNm" type="text" class="input_type01 w_150 ml_10" title="검색어">
							<button type="button" class="btn btn_third btn_size_s ml_5" id="search">
								<i class="xi-search"></i>조회
							</button>
						</dd>
					</dl>

					<dl>
						<dt>작업상태</dt>
						<dd>
							<select id="schCampStat" class="select_type01" title="작업상태">
								<option value="">전체</option>
								<option value="RUN">실행</option>
								<option value="STOP">중지</option>
							</select>
						</dd>
					</dl>
					<dl>
						<dt>조회주기</dt>
						<dd>
							<select id="schCycle" class="select_type01" title="조회주기">
								<option value="">정지</option>
								<option value="3" selected>3초</option>
								<option value="5">5초</option>
								<option value="10">10초</option>
								<option value="20">20초</option>
							</select>
						</dd>
					</dl>
				</div>
				<div class="button mr_10">
					<button type="button" class="btn btn_third btn_size_s" id="excelDown">
						<i class="xi-search"></i>Excel
					</button>
				</div>
			</div>
			<!-- search : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">캠페인 목록</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L a_c type_grid disable_paging" id="divGrid">
			<table aria-describedby="table_summary" id="campMonGrid"></table>
		</div>
		<!-- table : end -->
		<!-- title : start -->
		<div class="mt_10" style="height:492px">

			<div  class="w_65p h_100p f_l p_10" style="background-color:#ececec; border-radius:5px">
				<div class="board_A0_L a_c type_grid disable_paging h_100p" id="divGrid2" style="background-color:#FFF">
					<table aria-describedby="table_summary" id="agentGrid"></table>
				</div>
			</div>

			<div class="h_100p p_10 f_l ml_10" style="width:calc(35% - 11px);background-color:#ececec; border-radius:5px">
				<div class="w_100p h_160 pb_10">
					<div class="monitor_box_5n mr_10">
	           			<div  class="databox_header">
	           				<b>로그인</b>
	           			</div>
	           			<div class="databox_body" id="loginCnt"></div>

	           		</div>
					<div class="monitor_box_5n mr_10">
	           			<div  class="databox_header">
	           				<b>통화</b>
	           			</div>
	           			<div class="databox_body" id="eshCnt"></div>

	           		</div>
					<div class="monitor_box_5n mr_10">
	           			<div  class="databox_header">
	           				<b>후처리</b>
	           			</div>
	           			<div class="databox_body" id="aftworkCnt"></div>

	           		</div>
					<div class="monitor_box_5n mr_10">
	           			<div  class="databox_header">
	           				<b>대기</b>
	           			</div>
	           			<div class="databox_body" id="readyCnt"></div>

	           		</div>
					<div class="monitor_box_5n">
	           			<div  class="databox_header">
	           				<b>휴식</b>
	           			</div>
	           			<div class="databox_body" id="notreadyCnt"></div>

	           		</div>
				</div>
				<div class="w_100p" style="height:calc(100% - 160px)">
					<div id='userStatusGraph' style="width:100%; height:100%;"></div>
				</div>
			</div>
		</div>
		<!-- row : end -->

	</div>



	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/MNSM01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/MNCM01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/mn/sm/MNSM01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

