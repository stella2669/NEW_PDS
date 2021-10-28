<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%-- 공통 해더파일 include  --%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<body>
 	<div class="loading" id="jspLoading">
		<div>
			<span class="loading_progress">
				<span class="loading_progress">
			<i class="lp_1"></i>
				<i class="lp_2"></i>
				<i class="lp_3"></i>
		</span>
			</span>
			<p style="font-size:18px">처리중입니다. 잠시만 기다리세요.</p>
		</div>
	</div>
	<div class="inner_contents">
		<div class="search_A2">
			<div class="sc_input">
				<dl>
					<dt>검색</dt>
					<dd>
						<select id="schBy" class="select_type01" title="검색기준">
							<option value="name">컨택리스트명</option>
						</select>
						<input id="schKeyword" type="text" class="input_type01 w_150 ml_10" title="검색어">
						<button id="search" type="button" class="btn btn_third btn_size_s ml_5">
							<i class="xi-search"></i>조회
						</button>
					</dd>
				</dl>

				<dl>
					<dt>정렬기준</dt>
					<dd>
						<select id="schSort" class="select_type01" title="정렬기준">
							<option value="id">컨택리스트ID</option>
							<option value="name">컨택리스트명</option>
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
		<div class="title">
			<h2 class="title_2nd">컨택리스트 목록</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L a_c type_grid" id="divDataGrid">
			<table id="contactGrid"></table>
			<tags:pagingECM srchFuncNm="contactListSearch" gridId="contactGrid"/>
		</div>

		<!-- table : end -->
		<!-- button : start -->
		<div class="button mt_10 a_r">
			<button type="button" class="btn btn_secondary btn_size_n" id="save">
				<i class="xi-plus"></i>등록
			</button>
			<button type="button" class="btn btn_primary btn_size_n" id="delete">
				<i class="xi-trash"></i>삭제
			</button>
		</div>
		<!-- button : end -->
	</div>

	<script type="text/javascript" src="<c:url value='/resources/js/cu/co/CUCO01.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/CUCO01_Service.js?timestamp=${nowDate}'/>"></script>
</body>
<%-- 공통 푸터파일 include  --%>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />