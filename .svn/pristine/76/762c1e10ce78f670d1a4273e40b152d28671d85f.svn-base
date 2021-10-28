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
	<div class="popup_window drag w_600">
		<div class="popup_header">
			<h1>일괄 수정</h1>
			<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
		</div>
		<div class="popup_content">
			<!-- popup_body : start -->
			<div class="popup_body">
				<div class="title">
					<h2 class="title_2nd">상담원 일괄 수정</h2>
				</div>
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">상담원 일괄 수정</caption>
						<colgroup>
							<col style="width: 100px">
							<col style="width: auto">

						</colgroup>
						<tbody id="rows">
							<tr class="bd_top" id="rows_0">
								<th scope="row">선택한 콜백 ID</th>
								<td id="callbackids">${paramMap.callbackids}</td>
							</tr>
							<tr class="bd_top" id="rows_0">
								<th scope="row">새 상담원 ID</th>
								<td>
									<input class="input_type01" type="text" id="agentId">
									<label for="agentId">선택한 콜백에 대해 상담원 일괄편집</label>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="popup_footer" style="margin-top:10px">
					<div class="button a_r">
						<button type="button" class="btn btn_secondary btn_size_n" id="save">
							<i class="xi-check"></i>일괄 수정
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
		cabackIds="${param.callbackids}";
	</script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/ca/ca/CACA05.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />