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

	<div class="inner_contents have_subtab">
	<!-- search : start -->
		<div class="search_A2">
			<div class="sc_input">
				<dl>
					<dt>스킬명</dt>
					<dd>
						<input id="schSkillNm" maxlength="50"  type="text" class="input_type01 w_150" title="스킬명">
					</dd>
				</dl>
				<dl>
					<dt>스킬유형</dt>
					<dd>
						<select id="schSkillType" title="스킬유형">
							<option value="">전체</option>
							<c:forEach items="${skillTypeList}" var="skillType">
								<option value="${skillType.cd}">${skillType.nm}</option>
							</c:forEach>
						</select>
					</dd>
				</dl>
				<dl>
					<dt>사용여부</dt>
					<dd>
						<select id="schUseYn" title="사용여부">
							<option value="">전체</option>
							<option value="Y">사용</option>
							<option value="N">미사용</option>
						</select>
					</dd>
				</dl>
			</div>
			<div class="button mr_10">
				<button type="button" class="btn btn_third btn_size_s" id="search">
					<i class="xi-search"></i>조회
				</button>
			</div>
		</div>
		<!-- search : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">스킬 목록</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L a_c type_grid disable_paging" id="divGrid">
			<table aria-describedby="table_summary" id="skillGrid">
			</table>
		</div>
		<!-- table : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">스킬 상세정보</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L">
			<table aria-describedby="table_summary">
				<caption id="table_summary">스킬 상세정보</caption>
				<colgroup>
					<col style="width: 100px">
					<col style="width: auto">
					<col style="width: 100px">
					<col style="width: auto">
				</colgroup>
				<tbody>
					<tr class="bd_top">
						<th scope="row">스킬 유형</th>
						<td>
							<select id="skillType" title="스킬유형">
								<option value="">--스킬유형--</option>
								<c:forEach items="${skillTypeList}" var="skillType">
									<option value="${skillType.cd}">${skillType.nm}</option>
								</c:forEach>
							</select>
						</td>
						<th scope="row">스킬 코드</th>
						<td>
							<input id="skillCd" maxlength="14" type="text" class="input_type01 w_30p" title="스킬 ID">
						</td>
						<th scope="row">스킬명</th>
						<td>
							<input id="skillNm" maxlength="30" type="text" class="input_type01 w_50p" title="스킬명">
						</td>
						<th scope="row">사용여부</th>
						<td>
							<select id="useYn" class="select_type01">
								<option value="Y">사용</option>
								<option value="N">미사용</option>
							</select>
						</td>
					</tr>
					<tr>						
						<th scope="row">비고</th>
						<td colspan="7">
							<textarea class="textarea_type01 w_100p tah_1"  id="note" name="note" title="비고" onkeyup="jsMaxLength(500);"></textarea>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- table : end -->
		<!-- button : start -->
		<div class="button mt_10 a_r">
			<button type="button" class="btn btn_secondary btn_size_n" id="skillNew">
				<i class="xi-new"></i>신규
			</button>
			<button type="button" class="btn btn_secondary btn_size_n" id="skillSave">
				<i class="xi-check"></i>저장
			</button>
			<button type="button" class="btn btn_primary btn_size_n" id="skillDel">
				<i class="xi-trash"></i>삭제
			</button>
		</div>
		<!-- button : end -->
	</div>

	<script type="text/javascript" src="<c:url value='/dwr/interface/USSM01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/us/sm/USSM01.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />