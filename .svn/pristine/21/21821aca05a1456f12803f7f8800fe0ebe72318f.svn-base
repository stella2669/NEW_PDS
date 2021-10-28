<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>

<!-- wrap : start -->
<div class="inner_contents">
		<div class="search_A2">
			<div class="sc_input">
				<dl>
					<dt>검색</dt>
					<dd>
						<select id="schBy" class="select_type01" title="검색기준">
							<option value="name">휴일명</option>
						</select>
						<input id="schKeyword" type="text" class="input_type01 w_150 ml_10" title="검색어">
						<button type="button" class="btn btn_third btn_size_s ml_5" id="search">
							<i class="xi-search"></i>조회
						</button>
					</dd>
				</dl>

				<dl>
					<dt>정렬기준</dt>
					<dd>
						<select id="schSort" class="select_type01" title="정렬기준">
							<option value="id">휴일ID</option>
							<option value="name">휴일명</option>
							<!-- <option value="holidayType">휴일 유형</option> -->
						</select>
					</dd>
				</dl>
				<dl>
					<dt>순서</dt>
					<dd>
						<select id="schOrder" class="select_type01" title="순서">
							<option value="ASC">오름차순</option>
							<option value="DESC" selected>내림차순</option>
						</select>
					</dd>
				</dl>
			</div>
			<div class="button mr_10">

			</div>
		</div>
		<!-- search : end -->
	<!-- title : start -->
	<div class="title">
		<h2 class="title_2nd">휴일 목록</h2>
	</div>
	<!-- title : end -->
	<!-- table : start -->
	<div class="board_A0_L a_c type_grid disable_paging" id="divGrid">
		<table aria-describedby="table_summary" id="holidayGrid"></table>
		<tags:pagingECM gridId="holidayGrid" srchFuncNm="holidaySearch" />
	</div>
	<!-- table : end -->
	<!-- title : start -->
	<div class="title">
		<h2 class="title_2nd">휴일 상세정보</h2>
	</div>
	<!-- title : end -->
	<!-- table : start -->
	<div class="board_A0_L">
		<table aria-describedby="table_summary">
			<caption id="table_summary">휴일 상세정보</caption>
			<tbody>
				<tr>
					<th scope="row" style="width: 100px">휴일명</th>
					<td class="chColspan" style="width: auto">
						<input id="holidayNm" maxlength="50" type="text" class="input_type01 w_100p" title="휴일명">
					</td>
					<!-- <th scope="row" class="selectCamp" rowspan="4" style="width: 100px">캠페인 선택</th>
					<td rowspan="4" class="selectCamp"  style="width: 50%">
						<div class="f_l" id="campListBox"></div>
						<div class="f_l w_50p h_100p p_10" id="selectCampaigns"></div>
					</td> -->
					<%-- <th scope="row" class="selectCountry" style="width: 100px">휴일 제약 완료코드</th>
					<td class="selectCountry" style="width: auto">
						<select id="restrictionCompletioncode">
							<option value="">-완료코드 선택-</option>
							<c:forEach var="comp" items="${compCodeList}">
								<option value="${comp.id}">${comp.krName}</option>
							</c:forEach>
						</select>
					</td> --%>
					<th scope="row">날짜</th>
					<td>
						<div class="input_box">
							<span class="date_pick">
								<input type="text" class="date_cell input_type01 w_80" id="holidayDate" name="holidayDate">
								<label class="date_icon" for="holidayDate"><i class="xi-calendar-check"></i><span class="replace_text">날짜선택</span></label>
							</span>
						</div>
					</td>
					<th scope="row">옵션</th>
					<td>
						<ul>
							<li class="f_l w_150">
								<input type="checkbox" class="radio_type01 mr_5" id="recurrent" name="recurrent">
								<label for="recurrent">매년반복</label>
							</li>
							<li class="f_l w_150">
								<input type="checkbox" class="radio_type01 mr_5" id="enabled" name="enabled" checked>
								<label for="enabled">활성화여부</label>
							</li>
						</ul>
					</td>
				</tr>
				<%-- <tr>
					<th scope="row">휴일 유형</th>
					<td>
						<select id="holidayType" class="select_type01" title="휴일 유형선택">
							<c:forEach var="type" items="${typeList}">
								<option value="${type.cd}">${type.nm}</option>
							</c:forEach>
						</select>
					</td>
					<th scope="row" class="restrictionSelect" style="display:none;width: 100px">휴일 제약유형</th>
					<td class="restrictionSelect" style="display:none;width: auto">
						<select id="holidayRestrictionType" class="select_type01" title="휴일 제약유형선택">
							<c:forEach var="type2" items="${typeList2}">
								<option value="${type2.cd}">${type2.nm}</option>
							</c:forEach>
						</select>
					</td>
					<th scope="row" class="selectCountry" style="display:none;width: 100px">휴일 제약 완료코드</th>
					<td class="selectCountry" style="display:none;width: auto">
						<select id="restrictionCompletioncode">
							<option value="">-완료코드 선택-</option>
							<c:forEach var="comp" items="${compCodeList}">
								<option value="${comp.id}">${comp.krName}</option>
							</c:forEach>
						</select>
					</td>
				</tr> --%>
				<tr>

				</tr>

			</tbody>
		</table>
	</div>
	<!-- table : end -->

	<!-- button : start -->
	<div class="button mt_10 a_r">
		<button type="button" class="btn btn_secondary btn_size_n" id="reset">
			<i class="xi-new"></i>신규
		</button>
		<button type="button" class="btn btn_secondary btn_size_n" id="save">
			<i class="xi-check"></i>저장
		</button>
		<button type="button" class="btn btn_primary btn_size_n" id="delete">
			<i class="xi-trash"></i>삭제
		</button>
	</div>
	<!-- button : end -->

</div>



	<script type="text/javascript" src="<c:url value='/dwr/interface/SYCP01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cp/hm/CPHM01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

