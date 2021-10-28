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
					<dt>검색</dt>
					<dd>
						<select id="schBy" class="select_type01" title="검색기준">
							<option value="DNCLIST_NM">DNC리스트명</option>
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
						<select id="schSort" title="정렬기준">
							<option value="dnclistSeq">ID</option>
							<option value="dnclistNm">DNC리스트명</option>
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


		<!-- row : start -->
		<div class="row" style="max-height: 100%;">
			<!-- col : start -->
			<div class="col_pd col_5">
				<!-- title : start -->
				<div class="title">
					<h2 class="title_2nd">DNC 리스트 목록</h2>
				</div>
				<!-- title : end -->
				<!-- table : start -->
				<div class="board_A0_L a_c type_grid" id="divGrid">
					<table aria-describedby="table_summary" id="dncGrid"></table>
					<tags:pagingECM gridId="dncGrid" srchFuncNm="dncSearch" />
				</div>
				<!-- table : end -->
				<!-- title : start -->
				<div class="title">
					<h2 class="title_2nd">DNC 리스트 상세정보</h2>
				</div>
				<!-- title : end -->
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">DNC 리스트 상세정보</caption>
						<colgroup>
							<col style="width: 100px">
							<col style="width: auto">
						</colgroup>
						<tbody>
							<tr class="bd_top">
								<th scope="row">DNC 리스트명</th>
								<td>
									<input id="dncListNm" type="text" class="input_type01 w_50p" title="DNC 리스트명">
								</td>
							</tr>
							<tr>
								<th scope="row">설명</th>
								<td>
									<textarea class="textarea_type01 w_100p tah_1"  id="description" name="description" title="설명" onkeyup="jsMaxLength(500);"></textarea>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- table : end -->
				<!-- button : start -->

				<div class="button mt_10 a_r">
<!-- 					<button type="button" class="btn btn_third btn_size_n" id="dncDatasource"> -->
<!-- 						<i class="xi-devices"></i>데이터소스 관리 -->
<!-- 					</button> -->
					<button type="button" class="btn btn_secondary btn_size_n" id="reset">
						<i class="xi-new"></i>신규
					</button>
					<button type="button" class="btn btn_secondary btn_size_n" id="save">
						<i class="xi-check"></i>저장
					</button>
<!-- 					<button type="button" class="btn btn_primary btn_size_n" id="empty"> -->
<!-- 						<i class="xi-eraser"></i>비우기 -->
<!-- 					</button> -->
					<button type="button" class="btn btn_primary btn_size_n" id="delete">
						<i class="xi-trash"></i>삭제
					</button>
				</div>
				<!-- button : end -->

			</div>
			<div class="col_pd col_5">
				<!-- title : start -->
				<div class="title">
					<h2 class="title_2nd">DNC 목록</h2>
				</div>
				<!-- table : start -->
				<div class="board_A0_L a_c type_grid disable_paging" id="divGrid2">
					<table aria-describedby="table_summary" id="dncDetailGrid"></table>
				</div>
				<!-- table : end -->
				<!-- title : start -->
				<div class="title">
					<h2 class="title_2nd">DNC 상세정보</h2>
				</div>
				<!-- title : end -->
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">DNC 상세정보</caption>
						<colgroup>
							<col style="width: 200px">
							<col style="width: auto">
						</colgroup>
						<tbody>
							<tr class="bd_top">
								<th scope="row">주소(전화번호, 이메일)</th>
								<td>
									<input id="address" type="text" class="input_type01 w_200" title="주소">
									<!-- <input type="checkbox" id="checkForPhoneRejection" class="ml_10">
									<label for="checkForPhoneRejection">전화번호 거부 패턴 확인 여부</label>
									<input type="checkbox" id="checkForPhoneFormats" class="ml_10">
									<label for="checkForPhoneFormats">전화번호 형식 확인 여부</label> -->
								</td>
						</tbody>
					</table>
				</div>
				<!-- table : end -->
				<!-- button : start -->
				<div class="button mt_10 a_r">
					<button type="button" class="btn btn_secondary btn_size_n" id="detailReset">
						<i class="xi-new"></i>신규
					</button>
					<button type="button" class="btn btn_secondary btn_size_n" id="detailSave">
						<i class="xi-check"></i>저장
					</button>
					<button type="button" class="btn btn_primary btn_size_n" id="detailDelete">
						<i class="xi-trash"></i>삭제
					</button>
				</div>
				<!-- button : end -->
			</div>
		</div>

	</div>

<%-- 	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script> --%>
	<script type="text/javascript" src="<c:url value='/dwr/interface/CUNC01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cu/nc/CUNC01.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />