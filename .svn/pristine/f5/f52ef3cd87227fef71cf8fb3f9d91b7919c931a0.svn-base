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
	<div class="popup_window drag w_550">
		<div class="popup_header">
			<h1>컨택리스트 선택</h1>
			<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
		</div>
		<div class="popup_content">
			<!-- popup_body : start -->
			<div class="popup_body">
				<div class="title">
					<h2 class="title_2nd">컨택리스트 선택</h2>
				</div>
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">컨택리스트 선택</caption>
						<colgroup>
							<col style="width: 100px">
							<col style="width: auto">
							<col style="width: 100px">
							<col style="width: auto">
						</colgroup>
						<tbody id="rows">
							<tr class="bd_top contactRows">
								<th scope="row">컨택리스트</th>
								<td>
									<select title="컨택리스트 선택" class="contactSelect" id="contactList_0">
										<option value="">-컨택리스트 선택-</option>
										<c:forEach var="clist" items="${contactlistList}">
											<option>${clist.name}</option>
										</c:forEach>
									</select>
								</td>
								<th scope="row">필터 템플릿</th>
								<td>
									<select title="필터템플릿 선택" class="filterSelect" id="filterTemplate_0">
										<option value="">-필터 템플릿 선택-</option>
										<c:forEach var="tlist" items="${filterTemplateList}">
											<option>${tlist.name}</option>
										</c:forEach>
									</select>
									<input type="checkbox" class="chk_type01 ml_10" id="applySameFilterTemplate">
									<label for="applySameFilterTemplate">모든 컨택리스트에 적용</label>
								</td>
							</tr>						
						</tbody>	
							<tr>
								<td colspan="4" class="a_c">
									<button type="button" class="btn btn_secondary btn_size_n" id="addList">
										<i class="xi-plus"></i>추가
									</button>
								</td>
							</tr>
					</table>
				</div>
				<div class="popup_footer" style="margin-top:10px">
					<div class="button a_r">
						<button type="button" class="btn btn_secondary btn_size_n" id="save">
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
	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/CPCM01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cp/cm/CPCM02.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />