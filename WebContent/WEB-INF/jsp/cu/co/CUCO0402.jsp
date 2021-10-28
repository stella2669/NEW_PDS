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
	<div class="popup_window w_900" style="min-width:400px">
		<div class="popup_header">
			<h1>가져올 데이터 맵핑</h1>
			<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
		</div>
		<div class="popup_content inner_contents">
			<!-- popup_body : start -->
			<div class="popup_body ">
				<div class="title">
					<h2 class="title_2nd">가져올 데이터 맵핑</h2>
				</div>
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">가져올 데이터 맵핑</caption>
						<colgroup>
							<col style="width: 100px">
							<col style="width: 220px">
							<col style="width: 100px">
							<col style="width: auto">
						</colgroup>
						<tbody>
							<tr class="bd_top">
								<th scope="row">테이블 선택</th>
								<td colspan="3">
									<select id="tableList" onchange="tableChange(this)">
										<option value="">-테이블선택-</option>
									</select>
								</td>
							</tr>
							<tr class="selectQueryTr">
								<th scope="row">컬럼 선택</th>
								<td>
									<!-- <div id="noTable">테이블을 선택해주세요</div> -->
									<div id="columnList" class="a_c">테이블을 선택해주세요</div>
								</td>
								<th scope="row">특성/컬럼 매핑</th>
								<td>
									<b>*굵게 표시된 특성은 현재 선택된 컨택리스트에 연결된 특성입니다.</b>
									<div class="board_A0_L mt_5">
										<table aria-describedby="table_summary">
											<caption id="table_summary">특성/컬럼 매핑</caption>
											<thead>
												<tr class="bd_top">
													<th scope="row">특성</th>
													<th scope="row">매핑할 컬럼</th>
												</tr>
											</thead>
											<tbody id="mapTbody">
												<c:forEach var="attr" items="${attrList}" varStatus="sts">
													<c:if test="${attr.attributeType eq 'Predefined' and attr.isMappable == true}">
														<tr class="predAttr">
															<c:choose>
															<c:when test="${attr.contactPropertyName eq 'userContactId'}">
																<td class="mapAttr" id="${attr.id}">id</td>
															</c:when>
															<c:otherwise>
																<td class="mapAttr" id="${attr.id}">${attr.contactPropertyName}</td>
															</c:otherwise>
															</c:choose>
															<td>
																<select class="mapCol">
																	<option value="">-선택한 컬럼-</option>
																</select>
															</td>
														</tr>
													</c:if>
												</c:forEach>
												<tr>
													<th class="a_c" scope="row" colspan="6">
														커스텀특성 매핑
														<button type="button" class="btn btn_secondary btn_size_n ml_10" onclick="addCustomAttr()">
															<i class="xi-plus"></i>추가
														</button>
														<button type="button" class="btn btn_primary btn_size_n" onclick="delCustomAttr()">
															<i class="xi-minus"></i>제거
														</button>
													</th>
												</tr>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
							<tr class="applyQueryTr">
								<th scope="row">적용 쿼리</th>
								<td colspan="3">
									<span id="defaultQuery"></span>
									<textarea class="textarea_type01 w_100p tah_1"  id="whereclause" name="whereclause" title="조건절"></textarea>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- detail : end -->
				<!-- table : end -->
				<div class="popup_footer" style="margin-top:10px">
					<div class="button a_r">
						<button type="button" class="btn btn_third btn_size_n" id="save">
							<i class="xi-check"></i>적용
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
		var selectContactlistId = "${contactListId}"
	</script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/Common_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/CUCO01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cu/co/CUCO0402.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />