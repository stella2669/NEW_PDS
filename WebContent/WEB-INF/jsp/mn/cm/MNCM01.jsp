<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>

	<form id="excelFrm" method="post" action="/com/excelDown.do">
		<input type="hidden" name="hiddenYn" value="N"/>
		<input type="hidden" name="title"/>
		<input type="hidden" name="fileNm"/>
		<input type="hidden" name="colModel"/>
		<input type="hidden" name="dataList"/>
	</form>

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

	<!-- wrap : start -->
	<div class="inner_contents">
			<div class="search_A2">
				<div class="sc_input">
					<dl>
						<dt>캠페인명</dt>
						<dd>
							<input id="schCampNm" type="text" class="input_type01 w_150 ml_10" title="검색어">
							<button type="button" class="btn btn_third btn_size_s ml_5" id="search">
								<i class="xi-search"></i>조회
							</button>
						</dd>
					</dl>

					<dl>
						<dt>작업상태</dt>
						<dd>
							<select id="schCampStat" class="select_type01" title="작업상태">
								<option value="">전체</option>
								<option value="RUN">실행</option>
								<option value="STOP">중지</option>
							</select>
						</dd>
					</dl>
					<dl>
						<dt>조회주기</dt>
						<dd>
							<select id="schCycle" class="select_type01" title="조회주기">
								<option value="">정지</option>
								<option value="3" selected>3초</option>
								<option value="5">5초</option>
								<option value="10">10초</option>
								<option value="20">20초</option>
							</select>
						</dd>
					</dl>
				</div>
				<div class="button mr_10">
					<button type="button" class="btn btn_third btn_size_s" id="excelDown">
						<i class="xi-search"></i>Excel
					</button>
				</div>
			</div>
			<!-- search : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">캠페인 목록</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L a_c type_grid disable_paging" id="divGrid">
			<table aria-describedby="table_summary" id="campMonGrid"></table>
		</div>
		<!-- table : end -->
		<!-- title : start -->
		<div class="dashboard h_500">
			<!-- 인트로박스2 : start -->

				<div class="w_40p f_l p_10 mt_10" style="height:calc(100% - 10px); background-color:#ececec; overflow:hidden; border-radius:5px">

				<!-- 회색파티션 X 아래 pt_10
				<div class="w_25p h_100p f_l mt_10" style="overflow:hidden">
				-->

					<div class="w_100p h_30p f_l board_A0_L">

						<!-- 상담원 상태부분 인트로스타일

						<div class="monitor_box_5n mr_10">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#d3fbcd">
	            				<b>로그인</b>
	            			</div>
	            			<div class="databox_body" id="loginCount">0</div>

	            		</div>
						<div class="monitor_box_5n mr_10">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#d3fbcd">
	            				<b>통화</b>
	            			</div>
	            			<div class="databox_body" id="loginCount">0</div>

	            		</div>
						<div class="monitor_box_5n mr_10">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#d3fbcd">
	            				<b>후처리</b>
	            			</div>
	            			<div class="databox_body" id="loginCount">0</div>

	            		</div>
						<div class="monitor_box_5n mr_10">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#d3fbcd">
	            				<b>대기</b>
	            			</div>
	            			<div class="databox_body" id="loginCount">0</div>

	            		</div>
						<div class="monitor_box_5n">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#d3fbcd">
	            				<b>휴식</b>
	            			</div>
	            			<div class="databox_body" id="loginCount">0</div>

	            		</div> -->
	            		<table aria-describedby="table_summary" style="height:99.99%; font-size:20px;">
							<caption id="table_summary">모니터링 상세정보</caption>
							<colgroup>
								<col style="width: 20%">
								<col style="width: 20%">
								<col style="width: 20%">
								<col style="width: 20%">
								<col style="width: 20%">
							</colgroup>
							<thead>
								<tr>
									<th scope="row" class="a_c">로그인</th>
									<th scope="row" class="a_c">통화</th>
									<th scope="row" class="a_c">후처리</th>
									<th scope="row" class="a_c">대기</th>
									<th scope="row" class="a_c">휴식</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="a_r pr_30" id="loginCnt"></td>
									<td class="a_r pr_30" id="eshCnt"></td>
									<td class="a_r pr_30" id="aftworkCnt"></td>
									<td class="a_r pr_30" id="readyCnt"></td>
									<td class="a_r pr_30" id="notreadyCnt"></td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="w_100p h_70p pt_10 f_l board_A0_L" style="width:100%">
							<table aria-describedby="table_summary" style="height:99.99%">
								<caption id="table_summary">모니터링 상세정보</caption>
								<colgroup>
									<col style="width: 25%">
									<col style="width: 75%">
								</colgroup>
								<tbody>

									<tr>
										<th scope="row" class="a_c">캠페인명</th>
										<td id="campNm"></td>
									</tr>
									<tr>
										<th scope="row" class="a_c">평균통화시간</th>
										<td id="eshAvrTime"></td>
									</tr>
									<tr>
										<th scope="row" class="a_c">평균후처리시간</th>
										<td id="aftworkAvrTime"></td>
									</tr>
									<tr>
										<th scope="row" class="a_c">평균대기시간</th>
										<td id="readyAvrTime"></td>
									</tr>
									<tr>
										<th scope="row" class="a_c">평균휴식시간</th>
										<td id="notreadyAvrTime"></td>
									</tr>
								</tbody>
							</table>
						</div>
				</div>

				<div class="w_60p f_l p_10 mt_10 ml_10" style="width:calc(60% - 10px);height:calc(100% - 10px);background-color:#ececec;overflow:hidden; border-radius:5px">

				<!-- 회색파티션 X
				<div class="w_45p h_100p f_l" style="overflow:hidden">
				-->

					<div class="w_100p h_30p f_l">
	            		<%-- <table aria-describedby="table_summary" style="height:100%;font-size:15px">
							<caption id="table_summary">모니터링 상세정보</caption>
							<colgroup>
								<col style="width: 25%">
								<col style="width: 25%">
								<col style="width: 25%">
								<col style="width: 25%">
							</colgroup>
							<tbody>
								<tr>
									<th scope="row" class="a_c">로그인</th>
									<td class="a_c" id="loginCnt">0</td>
									<th scope="row" class="a_c">대기중</th>
									<td class="a_c" id="readyCnt">0</td>
								</tr>
								<tr>
									<th scope="row" class="a_c">통화중</th>
									<td class="a_c" id="eshCnt">0</td>
									<th scope="row" class="a_c">휴식</th>
									<td class="a_c" id="notreadyCnt">0</td>
								</tr>
							</tbody>
						</table> --%>
	            		<div class="monitor_box_6n mr_10">
	            			<div class="databox_header">
	            				<b>완료율</b>
	            			</div>
	            			<div class="databox_body" id="comRate"></div>
	            		</div>
						<div class="monitor_box_6n mr_10">
	            			<div class="databox_header">
	            				<b>전체</b>
	            			</div>
	            			<div class="databox_body" id="totalCall"></div>

	            		</div>
	            		<div class="monitor_box_6n mr_10">
	            			<div class="databox_header">
	            				<b>시도</b>
	            			</div>
	            			<div class="databox_body" id="tryCnt"></div>
	            		</div>
	            		<div class="monitor_box_6n mr_10">
	            			<div class="databox_header">
	            				<b>연결</b>
	            			</div>
	            			<div class="databox_body" id="conCnt"></div>
	            		</div>
	            		<div class="monitor_box_6n mr_10">
	            			<div class="databox_header">
	            				<b>완료</b>
	            			</div>
	            			<div class="databox_body" id="comCnt"></div>
	            		</div>
	            		<div class="monitor_box_6n">
	            			<div class="databox_header">
	            				<b>포기</b>
	            			</div>
	            			<div class="databox_body" id="adonCnt"></div>
	            		</div>
	            	</div>


					<div class="w_100p h_70p pt_10 f_l">
	            		<%-- <table aria-describedby="table_summary" style="height:99.99%">
							<caption id="table_summary">모니터링 상세정보</caption>
							<colgroup>
								<col style="width: 25%">
								<col style="width: 25%">
								<col style="width: 25%">
								<col style="width: 25%">
							</colgroup>
							<tbody>

								<tr>
									<th scope="row" class="a_c">캠페인명</th>
									<td id="campNm"></td>
									<th scope="row" class="a_c">시작시간</th>
									<td id="startTime"></td>
								</tr>
								<tr>
									<th scope="row" class="a_c">현재/목표가동률</th>
									<td></td>
									<th scope="row" class="a_c">포기호/숙련전화율</th>
									<td></td>
								</tr>
								<tr>
									<th scope="row" class="a_c">수행된 통화</th>
									<td id="procCnt"></td>
									<th scope="row" class="a_c">남은 통화</th>
									<td id="miCnt"></td>
								</tr>
							</tbody>
						</table> --%>

						<div class="h_100p f_l" style="width:50%">
							<div class="w_100p h_100p f_l">
			            		<div id='campProcessGraph' style="width:100%; height:100%;"></div>
			            	</div>
			            </div>

						<div class="h_100p f_l" style="width:50%">
							<div class="w_100p h_100p pl_10 f_l">
			            		<div id='campSuccessGraph' style="width:100%; height:100%;"></div>
			            	</div>
						</div>

					</div>
				</div>


				<!-- <div class="w_30p f_l p_10 mt_10 ml_10" style="width:calc(30% - 10px);height:calc(100% - 10px);background-color:#ececec;overflow:hidden"> -->

				<!-- 회색파티션 X
				<div class="w_30p h_100p f_l" style="overflow:hidden">
				-->
	            <!--
					<div class="w_100p h_100p pt_10 f_l">
						<div id='campCallGraph' style="width:100%; height:100%;"></div>
					</div>
				</div> -->
		</div>
		<!-- row : end -->

	</div>



	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/MNCM01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/mn/cm/MNCM01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

