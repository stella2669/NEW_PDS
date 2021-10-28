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
	<div class="popup_window drag w_700">
		<div class="popup_header">
			<h1>콜백 편집</h1>
			<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
		</div>
		<div class="popup_content">
			<!-- popup_body : start -->
			<div class="popup_body">
				<div class="title">
					<h2 class="title_2nd">콜백 편집</h2>
				</div>
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">콜백 일괄편집</caption>
						<colgroup>
							<col style="width: 140px">
							<col style="width: 160px">
							<col style="width: 140px">
							<col style="width: auto">
						</colgroup>
						<tbody id="rows">
							<tr class="bd_top" id="rows_0">
									<th scope="row">콜백 ID</th>
									<td id="callbackid" colspan="3" >${paramMap.callbackid}</td>

								</tr>
							<tr class="bd_top" id="rows_0">
								<th scope="row">현재 콜백 유형</th>
								<td id="callbackType_c"  ></td>
								<th scope="row">새 콜백 유형</th>
								<td>
									<select id="callbackType" style="width: 120px;">
										<option value="">전체</option>
										<c:forEach items="${CB100}" var="CB100" varStatus="_status">
											<option value="${CB100.cd}" >${CB100.nm}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="bd_top newAgentRow">
								<th scope="row">현재 상담원 ID</th>
								<td id="createdForAgent_c" ></td>
								<th scope="row">새 상담원 ID</th>
								<td>
									<input name="createdForAgent" id = "createdForAgent"  type="text" value=""  style="width:80px;" maxlength="15" >
								</td>
							</tr>
							<tr>
								<th scope="row">현재 시작시간</th>
								<td id="startTime_c" colspan="3" ></td>
							</tr>
							<tr>
								<th scope="row">새 시작시간</th>
								<td colspan="3">
									<div class="input_box">
										<input class="input_type01" id="startTime" type="datetime-local" title="시작 시간" step="60">
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">현재 종료시간</th>
								<td id="endTime_c" colspan="3" ></td>
							</tr>
							<tr>
								<th scope="row">새 종료시간</th>
								<td colspan="3">
									<div class="input_box">
										<input class="input_type01" id="endTime" type="datetime-local" title="종료 시간" step="60">
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">현재 다음시도시간</th>
								<td id="nextAttemptTime_c" colspan="3" ></td>
							</tr>
							<tr>
								<th scope="row">새 다음시도시간</th>
								<td colspan="3">
									<input class="input_type01" id="nextAttemptTime" type="datetime-local" title="다음 시도 시간" step="60">

								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="popup_footer" style="margin-top:10px">
					<div class="button a_r">
						<button type="button" class="btn btn_secondary btn_size_n" id="save">
							<i class="xi-check"></i>편 집
						</button>
						<button type="button" class="btn btn_third btn_size_n popup_close">
							<i class="xi-close"></i>닫 기
						</button>
					</div>
				</div>
				<!-- popup_footer : end -->
			</div>
		</div>
	</div>

	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<%-- <script type="text/javascript" src="<c:url value='/dwr/interface/CACA02_Service.js?timestamp=${nowDate}'/>"></script> --%>
	<script type="text/javascript" src="<c:url value='/resources/js/ca/ca/CACA03.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />