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
					<dt>역할명</dt>
					<dd>
						<input id="schAuthNm" maxlength="30"  type="text" class="input_type01 w_150" title="역할명">
						<button type="button" class="btn btn_third btn_size_s ml_5" id="search">
							<i class="xi-search"></i>조회
						</button>
					</dd>
				</dl>

			</div>
		</div>
		<!-- search : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">역할 목록</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L a_c type_grid disable_paging" id="divGrid">
			<table aria-describedby="table_summary" id="authCdGrid">
			</table>
		</div>
		<!-- table : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">역할코드 상세정보</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L">
			<table aria-describedby="table_summary">
				<caption id="table_summary">역할코드 상세정보</caption>
				<colgroup>
					<col style="width: 100px">
					<col style="width: auto">
					<col style="width: 100px">
					<col style="width: auto">
				</colgroup>
				<tbody>
					<tr class="bd_top">
						<th scope="row">역할 코드</th>
						<td>
							<input id="authCd" maxlength="14" type="text" class="input_type01 w_30p" title="역할 ID">
						</td>
						<th scope="row">역할 코드명</th>
						<td>
							<input id="authNm" maxlength="30" type="text" class="input_type01 w_50p" title="역할 코드명">
						</td>
					</tr>
					<tr>
						<th scope="row">사용여부</th>
						<td>
							<select id="useYn" class="select_type01">
								<option value="Y">사용</option>
								<option value="N">미사용</option>
							</select>
						</td>
						<th scope="row">비고</th>
						<td>
							<input id="note" maxlength="50" type="text" class="input_type01 w_100p" title="비고">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- table : end -->
		<!-- button : start -->
		<div class="button mt_10 a_r">
			<button type="button" class="btn btn_secondary btn_size_n" id="authNew">
				<i class="xi-new"></i>신규
			</button>
			<button type="button" class="btn btn_secondary btn_size_n" id="authSave">
				<i class="xi-check"></i>저장
			</button>
			<button type="button" class="btn btn_primary btn_size_n" id="authDel">
				<i class="xi-trash"></i>삭제
			</button>
		</div>
		<!-- button : end -->
	</div>

	<script type="text/javascript" src="<c:url value='/dwr/interface/SYAU01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/sy/au/SYAU01.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />