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
	<!-- search : start -->
	<div class="search_A2">
		<div class="sc_input">
			<dl>
				<dt>사용자그룹</dt>
				<dd>
					<select id="groupCd" style="width: 100px;">
						<option value="">전체</option>
						<c:forEach items="${groupCdList}" var="groupCdList"
							varStatus="_status">
							<option value="${groupCdList.cd}">${groupCdList.nm}</option>
						</c:forEach>
					</select>
					<button type="button" class="btn btn_third btn_size_s ml_10" id="search">
						<i class="xi-search"></i>조회
					</button>
				</dd>
			</dl>
			<dl>
				<dt>정렬기준</dt>
				<dd>
					<select id="orderBy">
						<option value="groupNm">그룹명</option>
						<option value="userId">사용자ID</option>
						<option value="userNm">사용자명</option>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>순서</dt>
				<dd>
					<select id="sortBy">
						<option value="asc">오름차순</option>
						<option value="desc">내림차순</option>
					</select>
				</dd>
			</dl>
		</div>
		<div class="button mr_10">

		</div>
	</div>
	<!-- search : end -->
	<!-- title : start -->
	<div class="title">
		<h2 class="title_2nd">사용자정보</h2>
	</div>
	<!-- title : end -->
	<!-- row : start -->
	<div class="row" style="max-height:calc(100% - 130px)">
		<!-- col : startr -->
		<div class="col_pd col_4">
			<!-- table : start -->
			<div class="board_A0_L a_c type_grid disable_paging h_600" id="divGrid">
				<table aria-describedby="table_summary" id="userGrid">
				</table>
			</div>
			<!-- table : end -->
		</div>
		<!-- col : end -->
		<!-- col : start -->
		<div class="col_pd col_6">
			<!-- table : start -->
			<div class="board_A0_L a_c type_grid disable_paging h_600" id="divGrid2">
				<table aria-describedby="table_summary2" id="progCdGrid">
				</table>
			</div>
			<!-- table : end -->
		</div>
		<!-- col : end -->
	</div>
	<!-- row : end -->
	<div class="button mt_10 a_r">
		<button type="button" class="btn btn_secondary btn_size_n" id="authSave">
			<i class="xi-check"></i>저장
		</button>
	</div>
	<!-- button : end -->
</div>

<script type="text/javascript" src="<c:url value='/dwr/interface/USAU01_Service.js?timestamp=${nowDate}'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/us/au/USAU01.js?timestamp=${nowDate}'/>"></script>
<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />