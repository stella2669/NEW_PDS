
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%-- 공통 해더파일 include  --%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
<!-- loading : start -->
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
<!-- loading : end -->

<!-- 상단 : start -->
	<div class="inner_contents">
		<div style="width:100%;height:50%">
			<div style="width:100%;height:40%;padding:10px">
				<div class="button ctrl_box" style="width:100%; height:100%">
					<div class="title" style="padding-top:0px">
						<h2 class="title_2nd">상담사 모니터링</h2>
					</div>
					<div class="btn_soft_ds btn_size_xw">
						<span><i class="icon_sp type_login" style="display:block; "></i>로그인</span>
						<span id="loginCnt">0</span>
					</div>

					<div class="btn_soft_ds_g btn_size_xw clear_b">
						<span><i class="icon_sp type_wait" style="display:block; "></i>대기</span>
						<span id="readyCnt">0</span>
					</div>

					<div class="btn_soft_ds_g btn_size_xw">
						<span><i class="icon_sp type_call" style="display:block;"></i>통화중</span>
						<span id="eshCnt">0</span>
					</div>

					<div class="btn_soft_ds_g btn_size_xw">
						<span><i class="icon_sp type_hold" style="display:block; "></i>후처리</span>
						<span id="aftworkCnt">0</span>
					</div>

					<div class="btn_soft_ds_g btn_size_xw" style="margin-right:0px">
						<span><i class="icon_sp type_rest" style="display:block; "></i>휴식중</span>
						<span id="notreadyCnt">0</span>
					</div>
				</div>
			</div>

			<div style="width:100%;height:60%;padding:10px">
				<div class="title">
					<h2 class="title_2nd">캠페인 모니터링</h2>
				</div>
				<div style="width:calc(25% - 7.5px);height:calc(100% - 37px);float:left;margin-right:10px">
	            	<div id='campProcessGraph' style="width:100%; height:100%;"></div>
				</div>
				<div style="width:calc(25% - 7.5px);height:calc(100% - 37px);float:left;margin-right:10px">
					<div style="border:1px solid #bcbcbc; width:100%;height:100%; padding:10px">
						<div class="title" style="padding-top:0px">
							<h2 class="title_2nd">Progressive</h2>
						</div>
						<div style="width:100%;height:calc(100% - 22px);display:flex;align-items:center">
							<div style="width:40%;height:100%;display:flex;align-items:center">
								<i class="icon_sp type_o_back" style="display:block;"></i>
							</div>
							<div class="board_A0_L" style="width:60%;height:70%;">
								<table aria-describedby="table_summary" style="height:99.99%">
									<caption id="table_summary">모니터링 상세정보</caption>
									<colgroup>
										<col style="width: 40%">
										<col style="width: 60%">
									</colgroup>
									<tbody>
										<tr>
											<th scope="row" class="a_c">총 발신</th>
											<td id="ProgressiveTotalAttempts" class="a_r"></td>
										</tr>
										<tr>
											<th scope="row" class="a_c">총 연결</th>
											<td id="ProgressiveSuccessCalls" class="a_r"></td>
										</tr>
										<tr>
											<th scope="row" class="a_c">총 포기호</th>
											<td id="ProgressiveNuisanceCalls" class="a_r"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div style="width:calc(25% - 7.5px);height:calc(100% - 37px);float:left;margin-right:10px">
					<div style="border:1px solid #bcbcbc; width:100%;height:100%; padding:10px">
						<div class="title" style="padding-top:0px">
							<h2 class="title_2nd">Preview</h2>
						</div>
						<div style="width:100%;height:calc(100% - 22px);display:flex;align-items:center">
							<div style="width:40%;height:100%;display:flex;align-items:center">
								<i class="icon_sp type_o_back" style="display:block;"></i>
							</div>
							<div class="board_A0_L" style="width:60%;height:70%;">
								<table aria-describedby="table_summary" style="height:99.99%">
									<caption id="table_summary">모니터링 상세정보</caption>
									<colgroup>
										<col style="width: 40%">
										<col style="width: 60%">
									</colgroup>
									<tbody>
										<tr>
											<th scope="row" class="a_c">총 발신</th>
											<td id="PreviewDials" class="a_r"></td>
										</tr>
										<tr>
											<th scope="row" class="a_c">총 취소</th>
											<td id="PreviewCancels" class="a_r"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div style="width:calc(25% - 7.5px);height:calc(100% - 37px);float:left;">
					<div style="border:1px solid #bcbcbc; width:100%;height:100%; padding:10px">
						<div class="title" style="padding-top:0px">
							<h2 class="title_2nd">Manual</h2>
						</div>
						<div style="width:100%;height:calc(100% - 22px);display:flex;align-items:center">
							<div style="width:40%;height:100%;display:flex;align-items:center">
								<i class="icon_sp type_o_back" style="display:block;"></i>
							</div>
							<div class="board_A0_L" style="width:60%;height:70%;">
								<table aria-describedby="table_summary" style="height:99.99%">
									<caption id="table_summary">모니터링 상세정보</caption>
									<colgroup>
										<col style="width: 40%">
										<col style="width: 60%">
									</colgroup>
									<tbody>
										<tr>
											<th scope="row" class="a_c">총 발신</th>
											<td id="ManualTotalAttempts" class="a_r"></td>
										</tr>
										<tr>
											<th scope="row" class="a_c">총 연결</th>
											<td id="ManualSuccessCalls" class="a_r"></td>
										</tr>
										<!-- <tr>
											<th scope="row" class="a_c">총 포기호</th>
											<td id="ManualNuisanceCalls" class="a_r"></td>
										</tr> -->
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div style="width:100%;height:50%;padding:10px">
			<!-- 인트로박스1 : start -->
			<!-- <div id="introBox1">
				<div>
	            	<span>상담사 모니터링</span>
	            </div>
				<div>
					<div class="intro_databox">
	            		<div class="data_box mr_10 mb_10">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#cdeefb">
	            				<b>로그인</b>
	            			</div>
	            			<div style="font-size:30px;height:40%;line-height:2;margin:10px;text-align:right" id="loginCount">0</div>

	            		</div>
	            		<div class="data_box mb_10">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#cdeefb">
	            				<b>통화중</b>
	            			</div>
	            			<div style="font-size:30px;height:40%;line-height:2;margin:10px;text-align:right" id="busyCount">0</div>
	            		</div>
	            		<div class="data_box02 mr_10">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#cdeefb">
	            				<b>대기</b>
	            			</div>
	            			<div style="font-size:30px;height:40%;line-height:2;margin:10px;text-align:right" id="readyCount">0</div>
	            		</div>
	            		<div class="data_box02 mr_10">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#cdeefb">
	            				<b>후처리</b>
	            			</div>
	            			<div style="font-size:30px;height:40%;line-height:2;margin:10px;text-align:right" id="wrapUpCount">0</div>
	            		</div>
	            		<div class="data_box02" >
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#cdeefb">
	            				<b>휴식</b>
	            			</div>
	            			<div style="font-size:30px;height:40%;line-height:2;margin:10px;text-align:right" id="notReadyCount">0</div>
	            		</div>

	            	</div>

	            	<div class="intro_chartbox">
	            		<div id='userStatusGraph' style="width:100%; height:100%;"></div>
	            	</div>
	            </div>
			</div>
			인트로박스1 : end
			인트로박스2 : start
			<div id="introBox2">
				<div>
	            	<span>캠페인 모니터링</span>
	            </div>
				<div>
					<div class="intro_databox">
	            		<div class="data_box mr_10 mb_10">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#cdeefb">
	            				<b>총건수</b>
	            			</div>
	            			<div style="font-size:30px;height:40%;line-height:2;margin:10px;text-align:right" id="totalContactCount">0</div>

	            		</div>
	            		<div class="data_box mb_10">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#cdeefb">
	            				<b>시도횟수</b>
	            			</div>
	            			<div style="font-size:30px;height:40%;line-height:2;margin:10px;text-align:right" id="totalAttemptingContactCount">0</div>
	            		</div>
	            		<div class="data_box mr_10">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#cdeefb">
	            				<b>연결건수</b>
	            			</div>
	            			<div style="font-size:30px;height:40%;line-height:2;margin:10px;text-align:right" id="answeredContactCount">0</div>
	            		</div>
	            		<div class="data_box">
	            			<div style="font-size:20px;text-align:center;height:45%;line-height:3.5;border-bottom:1px solid #C8C8C8;background-color:#cdeefb">
	            				<b>성공률</b>
	            			</div>
	            			<div style="font-size:30px;height:40%;line-height:2;margin:10px;text-align:right" id="completedRate">0</div>
	            		</div>
	            	</div>

            		<div class="intro_chartbox">
	            		<div id='campProcessGraph' style="width:100%; height:100%;"></div>
	            	</div>
				</div>
			</div> -->
			<!-- 인트로박스2 : end -->
			<!-- 인트로박스1 : start -->
			<!-- <div id="introBox3"> -->
				<!-- <div>
	            	<span>콜 현황 모니터링</span>
	            </div> -->
				<!-- <div style="padding:10px;"> -->
					<div id='campCallGraph' style="width:100%; height:100%;"></div>
				<!-- </div> -->
			<!-- </div> -->
			<!-- 인트로박스1 : end -->
		</div>
	</div>
<!-- 하단 : end -->

	<script  type="text/javascript" src="<c:url value='/dwr/interface/FRMA01_Service.js'/>"></script>
	<script  type="text/javascript" src="<c:url value='/resources/js/fr/ma/FRMA01.js?timestamp=${nowDate}'/>"></script>

</body>


<%-- 공통 푸터파일 include  --%>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />