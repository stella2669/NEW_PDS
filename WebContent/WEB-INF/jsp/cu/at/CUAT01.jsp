<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
<!-- wrap : start -->
	<!-- inner_contents : start -->
	<div class="inner_contents">
		
		<!-- search : end -->
		<!-- row : start -->
		<div class="row" style="height:calc(100% - 130px)">
			<!-- col : start -->
			<div class="col_pd col_5">
				<!-- title : start -->
				<div class="title">
					<h2 class="title_2nd">특성 리스트</h2>
				</div>
				<!-- title : end -->
				<!-- table : start -->
				<div class="board_A0_L a_c type_grid disable_paging" id="divLcdGrid">
					<table id="comLcdGrid" aria-describedby="table_summary">
					</table>
				</div>
				<!-- table : end -->
				<!-- title : start -->
				<div class="title">
					<h2 class="title_2nd">특성리스트 상세정보</h2>
				</div>
				<!-- title : end -->
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">특성 상세정보</caption>
						<colgroup>
							<col style="width: 20%">
							<col style="width: 30%">
							<col style="width: 20%">
							<col style="width: 30%">
						</colgroup>
						<tbody>
							<tr class="bd_top">
								<th scope="row">특성리스트명</th>
								<td colspan="3"><input id=attrNm type="text" class="input_type01 w_100p" title="특성리스트명"></td>
								
								
							</tr>
							<tr>
								<th scope="row">사용여부</th>
								<td colspan="3">
									<select id="isUse" class="select_type01" title="사용여부 선택">
										<option value="Y">예</option>
										<option value="N">아니오</option>
									</select>
								</td>
							</tr>
						
						</tbody>
					</table>
				</div>
				<!-- table : end -->
				<!-- button : start -->
				<div class="button mt_10 a_r">
					<button id="lcdNew" type="button"
						class="btn btn_secondary btn_size_n">
						<i class="xi-new"></i>신규
					</button>
					<button id="lcdSave" type="button"
						class="btn btn_secondary btn_size_n">
						<i class="xi-check"></i>저장
					</button>
					<button id="lcdDel" type="button"
						class="btn btn_primary btn_size_n">
						<i class="xi-trash"></i>삭제
					</button>
				</div>
				<!-- button : end -->
			</div>
			<!-- col : end -->

			<!-- col : start -->
			<div class="col_pd col_5">
				<!-- title : start -->
				<div class="title">
					<h2 class="title_2nd">특성 목록</h2>
				</div>
				<!-- title : end -->
				<!-- table : start -->
				<div class="board_A0_L a_c type_grid disable_paging" id="divScdGrid">
					<table id="comScdGrid" aria-describedby="table_summary">
					</table>
				</div>
				<!-- table : end -->
				<!-- title : start -->
				<div class="title">
					<h2 class="title_2nd">특성 상세정보</h2>
				</div>
				<!-- title : end -->
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">특성 상세정보</caption>
						<colgroup>
							<col style="width: 20%">
							<col style="width: 30%">
							<col style="width: 20%">
							<col style="width: 30%">
						</colgroup>
						<tbody>
							<tr class="bd_top">
								<th scope="row">특성명</th>
								<td><input id="attrinfoNm" type="text" size="15"
									maxlength="30" class="input_type01 w_100p" title="특성명"></td>
								<th scope="row">마스킹여부</th>
								<td><select id="isMask" class="select_type01"
									title="사용여부 선택">
										
										<option value="N">미사용</option>
										<option value="Y">사용</option>
								</select></td>
							</tr>
							<tr>
								<th scope="row">특성유형</th>
								<td>
									<select id="attrinfoType" class="w_120">
										<option value="">-선택하세요-</option>
										<c:forEach items="${typeAttr}" var="typeAttr" varStatus="_status">
											<option value="${typeAttr.cd}">${typeAttr.nm}</option>
										</c:forEach>
									</select>
								</td>
								<th scope="row">Key 여부</th>
								<td>
									<select id="isKey" class="select_type01" 	title="Key 여부 선택">										
										<option value="N">N</option>
										<option value="Y">Y</option>
								</select>
								</td>
							</tr>
							<tr>
								<th scope="row">순서</th>
								
								<td>
									<input id="sortNo" type="text" size="3"	maxlength="3" class="input_type01 w_100p" title="순서" onKeyUp="numberKeyup(this);">
								</select>
								</td>
							</tr>
							<tr>
								<th scope="row">비고</th>
								<td colspan="3"><textarea id="bigo" class="textarea_type01 w_100p tah_4" title="비고" onkeyup="jsMaxLength(500);"></textarea></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- table : end -->
				<!-- button : start -->
				<div class="button mt_10 a_r">
					<button id="scdNew" type="button"
						class="btn btn_secondary btn_size_n">
						<i class="xi-new"></i>신규
					</button>
					<button id="scdSave" type="button"
						class="btn btn_secondary btn_size_n">
						<i class="xi-check"></i>저장
					</button>
					<button id="scdDel" type="button"
						class="btn btn_primary btn_size_n">
						<i class="xi-trash"></i>삭제
					</button>
				</div>
				<!-- button : end -->
			</div>
			<!-- col : end -->
		</div>
	</div>
	<script type="text/javascript" src="<c:url value='/dwr/interface/CUAT01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cu/at/CUAT01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
