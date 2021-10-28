<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
<!-- wrap : start -->
	<!-- inner_contents : start -->
	<div class="inner_contents">
		<div class="search_A2">
			<div class="sc_input">
				<dl>
					<dt>공통코드명</dt>
					<dd>
						<input id="schComLnm" type="text" class="input_type01 w_150" title="기초코드명">
						<button type="button" id="search" class="btn btn_third btn_size_s ml_5">
							<i class="xi-search"></i>조회
						</button>
					</dd>
				</dl>
			</div>
		</div>
		<!-- search : end -->
		<!-- row : start -->
		<div class="row" style="height:calc(100% - 130px)">
			<!-- col : start -->
			<div class="col_pd col_5">
				<!-- title : start -->
				<div class="title">
					<h2 class="title_2nd">공통코드 목록</h2>
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
					<h2 class="title_2nd">공통코드 상세정보</h2>
				</div>
				<!-- title : end -->
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">공통코드 상세정보</caption>
						<colgroup>
							<col style="width: 20%">
							<col style="width: 30%">
							<col style="width: 20%">
							<col style="width: 30%">
						</colgroup>
						<tbody>
							<tr class="bd_top">
								<th scope="row">공통코드</th>
								<td><input id="comLcd" type="text" class="input_type01 w_100p" title="공통코드"></td>
								<th scope="row">필수여부</th>
								<td>
									<select id="lcdReqYn" class="select_type01" title="필수여부 선택">
										<option value="Y">예</option>
										<option value="N">아니오</option>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="row">코드명</th>
								<td><input id="comLnm" type="text" size="15" maxlength="50" class="input_type01 w_100p" title="코드명"></td>
								<th scope="row">사용여부</th>
								<td>
									<select id="lcdUseYn" class="select_type01" title="사용여부 선택">
										<option value="Y">사용</option>
										<option value="N">사용안함</option>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="row">비고</th>
								<td colspan="3"><textarea id="lcdNote" class="textarea_type01 w_100p tah_4" title="비고" onkeyup="jsMaxLength(500);"></textarea></td>
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
					<h2 class="title_2nd">상세코드 목록</h2>
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
					<h2 class="title_2nd">상세코드 상세정보</h2>
				</div>
				<!-- title : end -->
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">상세코드 상세정보</caption>
						<colgroup>
							<col style="width: 20%">
							<col style="width: 30%">
							<col style="width: 20%">
							<col style="width: 30%">
						</colgroup>
						<tbody>
							<tr class="bd_top">
								<th scope="row">상세코드</th>
								<td><input id="comScd" type="text" size="15"
									maxlength="30" class="input_type01 w_100p" title="상세코드"></td>
								<th scope="row">정렬순서</th>
								<td><input id="scdSort" type="text" size="3"
									maxlength="3" class="input_type01 w_100p" title="정렬순서" onKeyUp="numberKeyup(this);"></td>
							</tr>
							<tr>
								<th scope="row">코드명</th>
								<td><input id="comSnm" type="text" size="15"
									maxlength="30"
									class="input_type01 w_100p" title="코드명"></td>
								<th scope="row">사용여부</th>
								<td><select id="scdUseYn" class="select_type01"
									title="사용여부 선택">
										<option value="Y">사용</option>
										<option value="N">미사용</option>
								</select></td>
							</tr>
							<tr>
								<th scope="row">비고</th>
								<td colspan="3"><textarea id="scdNote" class="textarea_type01 w_100p tah_4" title="비고" onkeyup="jsMaxLength(500);"></textarea></td>
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
	<script type="text/javascript" src="<c:url value='/dwr/interface/SYCM01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/sy/cm/SYCM01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
