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
	<div class="popup_window drag w_400" style="min-width:400px">
		<div class="popup_header">
			<h1>캠페인 작업매개변수</h1>
			<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
		</div>
		<div class="popup_content">
			<!-- popup_body : start -->
			<div class="popup_body">
				<div class="title">
					<h2 class="title_2nd">캠페인 작업매개변수</h2>
				</div>
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">캠페인 작업매개변수</caption>
						<colgroup>
							<col style="width: 150px">
							<col style="width: auto">
						</colgroup>
						<tbody id="rows">
							<tr class="bd_top">
								<th scope="row">선택된 캠페인명</th>
								<td id="campNm"></td>
							</tr>
							<tr>
								<th scope="row">페이싱 유형</th>
								<td id="pacingType"></td>
							</tr>
							<tr>
								<th scope="row">채널 유형</th>
								<td id="channelType"></td>
							</tr>
							<tr>
								<th scope="row">우선순위</th>
								<td>
									<select class="w_50" id="priority">
										<c:forEach var="i" begin="1" end="10">
											<option>${i}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="row">최소 상담사</th>
								<td><input type="text" class="input_type01 w_100" id="minAgent"></td>
							</tr>
							<tr>
								<th scope="row">최대 상담사</th>
								<td><input type="text" class="input_type01 w_100" id="maxAgent"></td>
							</tr>
							<tr class="ECR" style="display:none">
								<th scope="row">최소 적중률</th>
								<td><input type="text" class="input_type01 w_100" id="MinHitRate">%</td>
							</tr>
							<tr class="ECR" style="display:none">
								<th scope="row">전문 통화 비율 유형</th>
								<td>
									<select id="EcrProbType">
										<option value="ecrAgtUpdateTime">전문 통화비율 업데이트</option>
										<option value="ecrAgtWorkTime">전문 통화비율 처리</option>
									</select>
								</td>
							</tr>
							<tr class="ecrAgtUpdateType_pram" style="display:none">
								<th scope="row">전문 통화비율 업데이트 확률</th>
								<td><input type="text" class="input_type01 w_100" id="EcrUpdateProb">%</td>
							</tr>
							<tr class="ecrAgtWorkType_param" style="display:none">
								<th scope="row">전문 통화비율 처리 확률</th>
								<td><input type="text" class="input_type01 w_100" id="EcrHandleProb">%</td>
							</tr>
							<tr class="CruiseControl" style="display:none">
								<th scope="row">원하는 서비스 레벨</th>
								<td><input type="text" class="input_type01 w_100" id="desiredSL"></td>
							</tr>
							<tr class="Progressive" style="display:none">
								<th scope="row">초과 다이얼 비율</th>
								<td><input type="text" class="input_type01 w_100" id="overDialRatio"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="popup_footer" style="margin-top:10px">
					<div class="button a_r">
						<button type="button" class="btn btn_secondary btn_size_n" id="save">
							<i class="xi-check"></i>수정
						</button>
						<button type="button" class="btn btn_third btn_size_n popup_close">
							<i class="xi-close"></i>닫기
						</button>
					</div>
				</div>
				<!-- popup_footer : end -->
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var selectedCampId = "${campId}";
	</script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cp/cm/CPCM04.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />