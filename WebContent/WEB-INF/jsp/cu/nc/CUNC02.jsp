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
							<option value="name">DNC그룹명</option>
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
							<option value="id">DNC그룹ID</option>
							<option value="name">DNC그룹명</option>
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
			<div class="button mr_10">

			</div>
		</div>
		<!-- search : end -->
	<!-- title : start -->
	<div class="title">
		<h2 class="title_2nd">DNC그룹 목록</h2>
	</div>
	<!-- title : end -->
	<!-- table : start -->
	<div class="board_A0_L a_c type_grid" id="divGrid">
		<table aria-describedby="table_summary" id="dncGroupGrid"></table>
		<tags:pagingECM gridId="dncGroupGrid" srchFuncNm="dncGroupSearch" />
	</div>
	<!-- table : end -->
	<!-- title : start -->
	<div class="title">
		<h2 class="title_2nd">DNC그룹 상세정보</h2>
	</div>
	<!-- title : end -->
	<!-- table : start -->
	<div class="board_A0_L">
		<table aria-describedby="table_summary">
			<caption id="table_summary">DNC그룹 상세정보</caption>
			<colgroup>
				<col style="width: 100px">
				<col style="width: auto">
			</colgroup>
			<tbody>
				<tr>
					<th scope="row">DNC그룹명</th>
					<td>
						<input id="dncGroupNm" type="text" class="input_type01 w_100p" title="DNC그룹명">
					</td>
				</tr>
				<tr>
					<th scope="row">설명</th>
					<td>
						<textarea class="textarea_type01 w_100p h_40"  id="description" name="description" title="캠페인 설명" onkeyup="jsMaxLength(500);"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- table : end -->

	<!-- button : start -->
	<div class="button mt_10 a_r">
		<button type="button" class="btn btn_secondary btn_size_n" id="reset">
			<i class="xi-new"></i>신규
		</button>
		<button type="button" class="btn btn_secondary btn_size_n" id="save">
			<i class="xi-check"></i>저장
		</button>
		<button type="button" class="btn btn_secondary btn_size_n" id="addDncList">
			<i class="xi-plus"></i>DNC목록 할당
		</button>
		<button type="button" class="btn btn_primary btn_size_n" id="delete">
			<i class="xi-trash"></i>삭제
		</button>
	</div>
	<!-- button : end -->

</div>



	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cu/nc/CUNC02.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

