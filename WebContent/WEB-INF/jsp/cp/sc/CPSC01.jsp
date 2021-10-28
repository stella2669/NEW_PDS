<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>

<!-- wrap : start -->
<div class="inner_contents">
		<div class="search_A2">
			<div class="sc_input">
				<dl>
					<dt>검색</dt>
					<dd>
						<select id="schBy" class="select_type01" title="검색기준">
							<option value="name">일정명</option>
							<option value="frequency">반복주기</option>
							<option value="campaignName">캠페인명</option>
							<option value="datasourceName">데이터소스명</option>
						</select>
						<input id="schKeyword" type="text" class="input_type01 w_150 ml_10" title="검색어">
						<button type="button" class="btn btn_third btn_size_s ml_5" id="search">
							<i class="xi-search"></i>조회
						</button>
					</dd>
				</dl>

				<dl>
					<dt>정렬기준</dt>
					<dd>
						<select id="schSort" class="select_type01" title="정렬기준">
							<option value="id">일정ID</option>
							<option value="name">일정명</option>
							<option value="startTime">시작시간</option>
							<option value="endTime">완료시간</option>
						</select>
					</dd>
				</dl>
				<dl>
					<dt>순서</dt>
					<dd>
						<select id="schOrder" class="select_type01" title="순서">
							<option value="ASC">오름차순</option>
							<option value="DESC" selected>내림차순</option>
						</select>
					</dd>
				</dl>
			</div>
		</div>
		<!-- search : end -->
	<!-- title : start -->
	<div class="title">
		<h2 class="title_2nd">일정 목록</h2>
	</div>
	<!-- title : end -->
	<!-- table : start -->
	<div class="board_A0_L a_c type_grid" id="divGrid">
		<table aria-describedby="table_summary" id="scheduleGrid"></table>
		<tags:pagingECM gridId="scheduleGrid" srchFuncNm="scheduleSearch" />
	</div>
	<!-- table : end -->


	<!-- button : start -->
	<div class="button mt_10 a_r">
		<button type="button" class="btn btn_secondary btn_size_n" id="addSchedule">
			<i class="xi-plus-circle"></i>등록
		</button>
	</div>
	<!-- button : end -->

</div>



	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cp/sc/CPSC01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

