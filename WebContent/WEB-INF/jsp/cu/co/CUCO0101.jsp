<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
	<!-- popup : start -->
	<div  class="popup_wrap white_blank" id="popupDiv"></div>
	<!-- popup : end -->
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
			<h1>${thisPage}</h1>
			<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
		</div>
		<div class="popup_content">
			<!-- popup_body : start -->
			<div class="popup_body">
				<div class="title">
					<h2 class="title_2nd">${thisPage}</h2>
				</div>
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">${thisPage}</caption>
						<colgroup>
							<col style="width:100px">
							<col style="width:auto">
							<col style="width:auto">
						</colgroup>
						<tbody>
							<tr class="bd_top">
								<th scope="row">컨택리스트명</th>
								<td colspan="2">
									<input type="text" class="input_type01 w_100p" title="컨택리스트명" id="contactNm" name="contactNm">
								</td>
							</tr>
							<tr>
								<th scope="row">특성</th>
								<td>
									<select class="w_120" title="특성" id="attrListCd" name="attrListCd">
										<option value="">-선택하세요-</option>
										<c:forEach items="${attrList}" var="attrList" varStatus="_status">
											<option value="${attrList.attrListSeq}">${attrList.attrNm}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="row">설명</th>
								<td colspan="2">
									<textarea class="textarea_type01 w_100p tah_1"  id="bigo" name="bigo" title="설명" onkeyup="jsMaxLength(500);"></textarea>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="popup_footer" style="margin-top:10px">
					<div class="button a_r">
						<button type="button" class="btn btn_secondary btn_size_n" id="save">
							<i class="xi-check"></i>저장
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
		var selectedContactListId = "${contactlistId}";
	</script>

	<script type="text/javascript" src="<c:url value='/dwr/interface/CUCO01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cu/co/CUCO0101.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />