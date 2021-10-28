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
	<!-- title : start -->
	<div class="title">
		<h2 class="title_2nd">역할정보</h2>
	</div>
	<!-- title : end -->
	<!-- row : start -->
	<div class="row" style="max-height:calc(100% - 80px)">
		<!-- col : startr -->
		<div class="col_pd col_4">
			<!-- table : start -->
			<div class="board_A0_L a_c type_grid disable_paging h_600" id="divGrid">
				<table aria-describedby="table_summary" id="authGrid">
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

<script type="text/javascript" src="<c:url value='/dwr/interface/USAU02_Service.js?timestamp=${nowDate}'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/us/au/USAU02.js?timestamp=${nowDate}'/>"></script>
<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />