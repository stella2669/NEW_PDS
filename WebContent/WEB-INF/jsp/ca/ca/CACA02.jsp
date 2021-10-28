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
			<p>처리중입니다. 잠시만 기다리세요.  </p>
		</div>
	</div>
	<div class="popup_window drag w_800">
		<div class="popup_header">
			<h1>콜백 상세조회</h1>
			<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
		</div>
		<div class="popup_content">
			<!-- popup_body : start -->
			<div class="popup_body">
				<div class="title">
					<h2 class="title_2nd">콜백 상세조회</h2>
				</div>
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">콜백 일괄편집</caption>
						<colgroup>
							<col style="width: 150px">
							<col style="width: auto">
							<col style="width: 150px">
							<col style="width: auto">
						</colgroup>
						<tbody id="rows">
							<tr class="bd_top" id="rows_0">
								<th scope="row">콜백 ID</th>
								<td id="callbackid">
									${paramMap.callbackid}
								</td>
								<th scope="row">캠페인 이름</th>
								<td id="campaignName">
								</td>
							</tr>

							<tr class="bd_top" id="rows_0">
								<th scope="row">컨택리스트 ID</th>
								<td id="contactlistId">
								</td>
								<th scope="row">컨택리스트 명</th>
								<td id="contactlistName">
								</td>
							</tr>
							<tr class="bd_top" id="rows_0">
								<th scope="row">시스템 컨택 아이디</th>
								<td id="systemContactId"></td>
								<th scope="row">사용자 컨택 아이디</th>
								<td id="userContactId"></td>

							</tr>

							<tr class="bd_top" id="rows_0">
								<th scope="row">상담원 세션 아이디</th>
								<td id="agentSessionId"></td>

								<th scope="row">작업 아이디</th>
								<td id="jobId"></td>

							</tr>
							<tr class="bd_top" id="rows_0">

								<th scope="row">동작 아이디 </th>
								<td id="actionId"></td>

								<th scope="row">콜백 수행 상담원</th>
								<td id="servicedByAgentId"></td>

							</tr>
							<tr class="bd_top" id="rows_0">
								<th scope="row">콜백 유형</th>
								<td id="callbackType"></td>

								<th scope="row">콜백 상태</th>
								<td id="status"></td>

							</tr>
							<tr class="bd_top" id="rows_0">
								<th scope="row">콜백 생성 상담원</th>
								<td id="createdBy"></td>

								<th scope="row">콜백 할당 상담원 </th>
								<td id="createdForAgent"></td>

							</tr>
							<tr class="bd_top" id="rows_0">
								<th scope="row">다음 시도 시간 </th>
								<td id="nextAttemptTime"></td>

								<th scope="row">시작 시간  </th>
								<td id="startTime"></td>

							</tr>
							<tr class="bd_top" id="rows_0">
								<th scope="row">종료 시간  </th>
								<td id="endTime"></td>
							   <th scope="row">콜백 생성 시간  </th>
							   <td id="createdOn"></td>

							</tr>
							<tr class="bd_top" id="rows_0">
								<th scope="row">전화번호  </th>
								<td id="address" ></td>

								<th scope="row">이름  </th>
								<td id="firstName" ></td>

							</tr>
							<tr class="bd_top" id="rows_0">
								<th scope="row">메모  </th>
								<td  colspan="3">
									<textarea class="textarea_type01 w_100p tah_1"  id="notes" name="description" title="설명" readonly></textarea>
								</td>


							</tr>

						</tbody>
					</table>
				</div>
				<div class="popup_footer" style="margin-top:10px">
					<div class="button a_r">

						<button type="button" class="btn btn_third btn_size_n popup_close">
							<i class="xi-close"></i>닫기
						</button>
					</div>
				</div>
				<!-- popup_footer : end -->
			</div>
		</div>
	</div>

	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<%-- <script type="text/javascript" src="<c:url value='/dwr/interface/CACA02_Service.js?timestamp=${nowDate}'/>"></script> --%>
	<script type="text/javascript" src="<c:url value='/resources/js/ca/ca/CACA02.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />