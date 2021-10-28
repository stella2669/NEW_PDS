<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />	

<body>

<!-- wrap : start -->
<div class="inner_contents">
		
	<!-- title : start -->
	<div class="title" style="padding-top:0px">
		<div class="w_500 f_l mt_15 mb_5">
			<h2 class="title_2nd">상담사 완료코드 목록</h2>
		</div>
		<div class="button f_r a_r">
			<button type="button" class="btn btn_third btn_size_n">
				<i class="xi-refresh"></i>동기화
			</button>
		</div>
	</div>
	<!-- title : end -->
	<!-- table : start -->
	<div class="board_A0_L a_c type_grid disable_paging" id="divGrid">
		<table aria-describedby="table_summary" id="codeGrid"></table>
		<tags:pagingECM gridId="codeGrid" srchFuncNm="codeSearch" />
	</div>
	<!-- table : end -->	
</div>

	
	
	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/SYCA01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/sy/ca/SYCA01.js?timestamp=${nowDate}'/>"></script>				
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

