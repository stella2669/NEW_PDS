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
					<dt>프로그램 코드명</dt>
					<dd>
						<input id="schProgNm" maxlength="50"  type="text" class="input_type01 w_150" title="프로그램 코드명">
					</dd>
				</dl>
				<dl>
					<dt>메뉴코드</dt>
					<dd>
						<select id="schMenuCd" class="w_120">
							<option value="">-전체-</option>
							<c:forEach items="${MenuCodeList}" var="MenuCodeList" varStatus="_status">
								<option value="${MenuCodeList.menuId}">${MenuCodeList.menuNm}</option>
							</c:forEach>
						</select>
						<button type="button" class="btn btn_third btn_size_s ml_5" id="search">
							<i class="xi-search"></i>조회
						</button>
					</dd>
				</dl>
			</div>
		</div>
		<!-- search : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">프로그램 코드 목록</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L a_c type_grid disable_paging">
			<table aria-describedby="table_summary" id="progCdGrid">
			</table>
		</div>
		<!-- table : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">프로그램 코드 상세정보</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L">
			<table aria-describedby="table_summary">
				<caption id="table_summary">프로그램 코드 상세정보</caption>
				<colgroup>
					<col style="width:">
					<col style="width:">
					<col style="width:">
					<col style="width:">
					<col style="width:">
					<col style="width:">
				</colgroup>
				<tbody>
					<tr class="bd_top">
						<th scope="row">메뉴코드</th>
						<td>
							<select id="menuCd" class="w_120">
								<option value="">--메뉴코드선택--</option>
								<c:forEach items="${MenuCodeList}" var="MenuCodeList" varStatus="_status">
									<option value="${MenuCodeList.menuId}">${MenuCodeList.menuNm}</option>
								</c:forEach>
							</select>
						</td>
						<th scope="row">프로그램 코드</th>
						<td>
							<input id="progCd" maxlength="14" type="text" class="input_type01 w_30p" title="프로그램 ID">
						</td>
						<th scope="row">프로그램 코드명</th>
						<td>
							<input id="progNm" maxlength="30" type="text" class="input_type01 w_50p" title="프로그램 코드명">
						</td>
					</tr>
					<tr>
						<th scope="row">정렬순서</th>
						<td><input id="sort" type="text" maxlength="3"
							class="input_type01 w_30p" title="정렬순서" onKeyUp="isNumber2(this);"></td>
						<th scope="row">사용여부</th>
						<td><select id="useYn" class="select_type01">
								<option value="Y">사용</option>
								<option value="N">미사용</option>
						</select></td>
						<th scope="row">호출url</th>
						<td>
							<input id="callUrl" maxlength="50" type="text" class="input_type01 w_100p" title="호출url">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- table : end -->
		<!-- button : start -->
		<div class="button mt_10 a_r">
			<button type="button" class="btn btn_secondary btn_size_n" id="progNew">
				<i class="xi-new"></i>신규
			</button>
			<button type="button" class="btn btn_secondary btn_size_n" id="progSave">
				<i class="xi-check"></i>저장
			</button>
			<button type="button" class="btn btn_primary btn_size_n" id="progDel">
				<i class="xi-trash"></i>삭제
			</button>
		</div>
		<!-- button : end -->
	</div>

	<script type="text/javascript" src="<c:url value='/dwr/interface/SYPG01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/sy/pg/SYPG01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

