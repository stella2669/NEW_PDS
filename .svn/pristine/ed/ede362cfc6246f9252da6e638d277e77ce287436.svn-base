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

<!-- popup : start -->
<div  class="popup_wrap white_blank" id="cmmPoopup"></div>
<!-- popup : end -->

<div class="inner_contents">
<!-- search : start -->
	<div class="search_A2">
		<div class="sc_input">

			<dl>
				<dt>검색기준</dt>
				<dd>
					<select id="schBy">
						<option value="userId">사용자ID</option>
						<option value="userNm">사용자명</option>
						<option value="authCd">역할</option>
						<option value="rankCd">직급</option>
					</select>
					<input type="text"  name="srchUserId"  id="srchUserId"    value=""  style="width:100px;">
					<input name="srchUserNm" id="srchUserNm"  type="text" value=""  style="width:100px; display:none">
					<select id="srchAuthCd" style="display:none">
						<option value="">전체</option>
						<c:forEach items="${auCdList}" var="auCdList" varStatus="_status">
							<option value="${auCdList.cd}">${auCdList.nm}</option>
						</c:forEach>
					</select>
					<select name="srchRankCd" id = "srchRankCd" style="display:none">
						<option value="">전체</option>
							<c:forEach items="${roCdList}" var="roCdList" varStatus="_status">
								<option value="${roCdList.cd}">${roCdList.nm}</option>
							</c:forEach>
					</select>
					<button type="button" class="btn btn_third btn_size_s ml_10 mr_10" id="search">
						<i class="xi-search"></i>조회
					</button>
				</dd>
			</dl>
			<dl>
				<dt>정렬기준</dt>
				<dd>
					<select id="orderBy">
						<option value="userId">사용자ID</option>
						<option value="userNm">사용자명</option>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>순서</dt>
				<dd>
					<select id="sortBy">
						<option value="asc">오름차순</option>
						<option value="desc" selected>내림차순</option>
					</select>
				</dd>
			</dl>

		</div>
		<!-- <div class="button mr_10">
			<button type="button" class="btn btn_third btn_size_s" onclick="excelDownload();">
				<i class="xi-download"></i>엑셀저장
			</button>
		</div> -->
	</div>
<!-- search : end -->
<!-- title : start -->
<div class="title">
	<h2 class="title_2nd">사용자 목록</h2>
</div>
<!-- title : end -->
<!-- table : start -->
<div class="board_A0_L a_c type_grid disable_paging" id="divGrid">
	<table aria-describedby="table_summary" id = "userGrid">
		<caption id="table_summary">TM사용자</caption>

	</table>
</div>
<!-- table : end -->
<!-- title : start -->
<div class="title">
	<h2 class="title_2nd">사용자 상세정보</h2>
</div>
<!-- title : end -->
<!-- table : start -->
<div class="board_A0_L">
	<table aria-describedby="table_summary">
		<caption id="table_summary">사용자 상세정보</caption>
		<colgroup>
			<col style="width:">
			<col style="width:">
			<col style="width:">
			<col style="width:">
			<col style="width:">
			<col style="width:">
			<col style="width:">
		</colgroup>
		<tbody>

			<tr class="bd_top">
				<th scope="row">사용자 ID</th>
				<td><input id = "userId" size="16" maxlength="15" type="text" class="input_type01 w_100"></td>

				<th scope="row">사용자명</th>
				<td><input id = "userNm" type="text"size="20" maxlength="20"  class="input_type01 w_100" title="사용자명" ></td>

			    <th scope="row">메일주소</th>
			    <td colspan="5"><input id="userMail" type="text" class="input_type01 w_200" title="메일주소"></td>
			</tr>
			<tr>
				<th scope="row">사용자그룹</th>
				<td>
					<div class="input_box">
						<select id="groupCd" style="width: 120px;">
							<option value="">-그룹선택-</option>
							<c:forEach items="${groupCdList}" var="groupCdList"
								varStatus="_status">
								<option value="${groupCdList.cd}">${groupCdList.nm}</option>
							</c:forEach>
						</select>
					</div>
				</td>
				<th scope="row">역할</th>
				<td>
					<div class="input_box">
						<select id="auCd" style="width: 120px;">
							<option value="">-역할선택-</option>
							<c:forEach items="${auCdList}" var="auCdList"
								varStatus="_status">
								<option value="${auCdList.cd}">${auCdList.nm}</option>
							</c:forEach>
						</select>
					</div>
				</td>
				<th scope="row">직급</th>
				<td>
					<div class="input_box">
						<select id="raCd" style="width: 120px;">
							<option value="">-직급선택-</option>
							<c:forEach items="${roCdList}" var="roCdList"
								varStatus="_status">
								<option value="${roCdList.cd}">${roCdList.nm}</option>
							</c:forEach>
						</select>
					</div>
				</td>
				<th scope="row">근무상태</th>
				<td>
					<div class="input_box">
						<select id="stCd" style="width: 120px;">
							<option value="">-근무상태선택-</option>
							<c:forEach items="${stCdList}" var="stCdList"
								varStatus="_status">
								<option value="${stCdList.cd}">${stCdList.nm}</option>
							</c:forEach>
						</select>
					</div>
				</td>

			</tr>

		</tbody>
	</table>
</div>
<!-- table : end -->
<!-- button : start -->
<div class="button mt_10 a_r">
<!-- 	<button type="button" class="btn btn_secondary btn_size_n" onclick="saveTeam();">     -->
<!-- 		<i class="xi-check" ></i>팀등록                                                                                             -->
<!-- 	</button>                                                                             -->
	<button type="button"  onclick="initPswd();" class="btn btn_third btn_size_n">
		<i class="xi-rotate-left"></i>비밀번호 초기화
	</button>
	<button id="save" onclick="initDetail();" type="button" class="btn btn_secondary btn_size_n">
		<i class="xi-new"></i>신규
	</button>
	<button id="update" onclick="saveDetail();" type="button" class="btn btn_third btn_size_n">
		<i class="xi-eraser"></i>저장
	</button>
	<button id="delete" onclick="deleteDetail();" type="button" class="btn btn_primary btn_size_n">
		<i class="xi-trash"></i>삭제
	</button>


</div>
</div>
<script type="text/javascript" src="<c:url value='/dwr/interface/USUM01_Service.js?timestamp=${nowDate}'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/us/um/USUM01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
