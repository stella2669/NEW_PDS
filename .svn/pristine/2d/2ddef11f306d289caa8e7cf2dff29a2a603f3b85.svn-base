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

	<div class="inner_contents">
		<div class="search_A2">
			<div class="sc_input">
				<dl>
					<dt>캠페인 기간</dt>
					<dd>
						<div class="input_box">
							<span class="date_pick">
								<input type="text" class="date_cell input_type01 w_80" id="schStrtDate">
								<label class="date_icon" for="schStrtDate"><i class="xi-calendar-check"></i><span class="replace_text">시작 기간</span></label>
							</span>
							<span class="date_space">~</span>
							<span class="date_pick">
								<input type="text" class="date_cell input_type01 w_80" id="schEndDate">
								<label class="date_icon" for="schEndDate"><i class="xi-calendar-check"></i><span class="replace_text">종료 기간</span></label>
							</span>
						</div>
					</dd>
				</dl>
				<dl>
					<dt>캠페인명</dt>
					<dd>
						<input id="schCampNm" maxlength="50"  type="text" class="input_type01 w_150" title="캠페인명">
						<button type="button" class="btn btn_third btn_size_s ml_5" id="search">
							<i class="xi-search"></i>조회
						</button>
					</dd>
				</dl>
				<dl>
					<dt>템플릿</dt>
					<dd>
						<select title="템플릿 선택" id="schCampTemp">
							<option value="">전체</option>
							<%-- <c:forEach items="${campTempList}" var="campTemp">
								<option value="${campTemp.cd}">${campTemp.nm}</option>
							</c:forEach> --%>
						</select>
					</dd>
				</dl>
			</div>
		</div>
		<!-- search : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">캠페인 목록</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
				<div class="board_A0_L a_c type_grid" id="divGrid">
					<table aria-describedby="table_summary" id="campGrid"></table>
					<tags:paging gridId="campGrid" srchFuncNm="campListSearch" />
				</div>
				<!-- table : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">캠페인 상세정보</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L">
			<table aria-describedby="table_summary">
				<caption id="table_summary">캠페인 상세정보</caption>
				<colgroup>
					<col style="width: 10%">
					<col style="width: 30%">
					<col style="width: 10%">
					<col style="width: 20%">
					<col style="width: 10%">
					<col style="width: 20%">
				</colgroup>
				<tbody>
					<tr class="bd_top">
						<th scope="row">진행기간</th>
						<td id="campPeriod"></td>
						<th scope="row">캠페인명</th>
						<td id="campNm" colspan="3"></td>
					</tr>
					<tr>
						<th scope="row">총 건수</th>
						<td class="a_r" id="totCnt"></td>
						<th scope="row">진행 건수</th>
						<td class="a_r" id="proCnt"></td>
						<th scope="row">캠페인 실행상태</th>
						<td colspan="3">
							<select id="runningState">
								<option value="">-캠페인 실행상태-</option>
								<%-- <c:forEach items="${runningStateList}" var="state">
									<option value="${state.cd}">${state.nm}</option>
								</c:forEach> --%>
							</select>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- table : end -->
		<!-- button : start -->
		<div class="button mt_10 a_r">
			<button type="button" class="btn btn_secondary btn_size_n" id="save">
				<i class="xi-check"></i>저장
			</button>
		</div>
		<!-- button : end -->
	</div>

	<script type="text/javascript" src="<c:url value='/dwr/interface/CPCM01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/CPEM01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cp/em/CPEM01.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />