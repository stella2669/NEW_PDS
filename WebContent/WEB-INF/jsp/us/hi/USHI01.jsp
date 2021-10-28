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
				<dt>조회 일자</dt>
				<dd>
					<div class="input_box">
						<span class="date_pick">
							<input type="text" class="date_cell input_type01 w_80" id="schStrtDate">
							<label class="date_icon" for="schStrtDate"><i class="xi-calendar-check"></i><span class="replace_text">시작일자</span></label>
						</span>
						<span class="date_space">~</span>
						<span class="date_pick">
							<input type="text" class="date_cell input_type01 w_80" id="schEndDate">
							<label class="date_icon" for="schEndDate"><i class="xi-calendar-check"></i><span class="replace_text">종료 기간</span></label>
						</span>
					</div>
				</dd>
			</dl>
			<dl>
				<dt>사용자 ID</dt>
				<dd>
					<input type="text"  name="srchUserId"  id = "srchUserId"    value=""  style="width:100px;" maxlength="30" >
				</dd>
			</dl>
			<dl>
				<dt>사용자 명</dt>
				<dd>
					<input name="srchUsernm" id = "srchUsernm"  type="text" value=""  style="width:100px;" maxlength="30" >
					<button type="button" class="btn btn_third btn_size_s ml_10" id="search">
						<i class="xi-search"></i>조회
					</button>
				</dd>
			</dl>
			<dl>
				<dt>정렬기준</dt>
				<dd>
					<select id="orderBy">
						<option value="schDate">일자</option>
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
	</div>
<!-- search : end -->
<!-- title : start -->
<div class="title">
	<h2 class="title_2nd">사용자</h2>
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

<!-- table : end -->
<!-- button : start -->

</div>
<script type="text/javascript" src="<c:url value='/dwr/interface/USHI01_Service.js?timestamp=${nowDate}'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/us/hi/USHI01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
