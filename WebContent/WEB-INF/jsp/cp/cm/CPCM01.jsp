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
							<option value="name">캠페인명</option>
							<option value="strategyName">전략명</option>
						</select>
						<input id="schKeyword" maxlength="50"  type="text" class="input_type01 w_150" title="검색어">
						<button type="button" class="btn btn_third btn_size_s ml_5" id="search">
							<i class="xi-search"></i>조회
						</button>
					</dd>
				</dl>

				<dl>
					<dt>정렬기준</dt>
					<dd>
						<select id="schSort" class="select_type01" title="정렬기준">
							<option value="id">캠페인ID</option>
							<option value="name">캠페인명</option>
							<option value="strategyName">전략명</option>
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
		</div>
		<!-- search : end -->
		<!-- <div class="row">
			<div class="col_pd col_5 alt"> -->
				<!-- title : start -->
				<div class="title">
					<h2 class="title_2nd">캠페인 목록</h2>
				</div>
				<!-- title : end -->
				<!-- table : start -->
				<div class="board_A0_L a_c type_grid" id="divGrid">
					<table aria-describedby="table_summary" id="campGrid"></table>
					<tags:pagingECM gridId="campGrid" srchFuncNm="campSearch" />
				</div>
				<!-- table : end -->
				<!-- button : start -->
				<div class="button mt_10 a_r">
					<button type="button" class="btn btn_secondary btn_size_n" id="regist">
						<i class="xi-plus"></i>등록
					</button>
					<button type="button" class="btn btn_primary btn_size_n" id="delete">
						<i class="xi-trash"></i>삭제
					</button>
				</div>
				<!-- button : end -->
			</div>

			<!-- <div class="col_pd col_5"> -->



			<!-- </div>
		</div>
	</div> -->

	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/CPCM01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cp/cm/CPCM01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

