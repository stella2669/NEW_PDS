<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
	<!-- popup : start -->
	<div  class="popup_wrap white_blank" id="popupDiv"></div>
	<!-- popup : end -->
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
	<div class="popup_window drag w_1200">
		<div class="popup_header">
			<h1>${thisPage}</h1>
			<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
		</div>
		<div class="popup_content">
			<!-- popup_body : start -->
			<div class="popup_body">
				<div class="title">
					<h2 class="title_2nd">${thisPage}</h2>
				</div>
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">${thisPage}</caption>
						<colgroup>
							<col style="width: 100px">
							<col style="width: auto">
							<col style="width: 150px">
							<col style="width: 105px">
							<col style="width: 105px">
							<col style="width: 105px">
							<col style="width: 100px">
							<col style="width: auto">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">캠페인명</th>
								<td>
									<input id="campNm" maxlength="50" type="text" class="input_type01 w_100p" title="캠페인명">
								</td>
								<th scope="row" rowspan="5">캠페인 설명</th>
								<td rowspan="5" colspan="3">
									<textarea class="textarea_type01 w_100p h_100p"  id="description" name="description" title="캠페인 설명" onkeyup="jsMaxLength(500);"></textarea>
								</td>
								<th scope="row" rowspan="5">DNC그룹</th>
								<td rowspan="5">
									<input type="checkbox" class="chk_type01" id="applyDNC">
									<label for="applyDNC">DNC 적용</label>
									<select title="기본 DNC 선택" id="defaultDncgroup">
										<option value="">-기본 DNC그룹-</option>
									</select>
									<div id="dncgroup" class="mt_10"></div>
								</td>
							</tr>
							<tr>
								<th scope="row">캠페인 유형</th>
								<td>
									<select title="캠페인유형 선택" id="campType">
										<option value="">-캠페인유형-</option>
										<c:forEach var="campType" items="${campTypeList}">
											<option value="${campType.cd}">${campType.nm}</option>
										</c:forEach>
									</select>
								</td>

							</tr>
							<tr>
								<th scope="row">콜봇 시나리오</th>
								<td>
									<select title="캠페인전략 선택" id="campStrategy">
										<option value="">-캠페인 전략-</option>
									</select>
								</td>
							</tr>
						
							<tr>
								<th scope="row">컨택리스트</th>
								<td colspan="7">
									<!-- <button type="button" class="btn btn_third btn_size_s f_r" id="contactListSelect">
										<i class="xi-plus-circle"></i>선택
									</button> -->
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
								</td>
							</tr>

							<tr>
								<th scope="row">발신자 표기번호</th>
								<td colspan="3">
									<input id="displayAddress" type="text" class="input_type01 w_100p" title="발신자 표기번호">
								</td>
								<th scope="row">발신자 표기명</th>
								<td colspan="3">
									<input id="displayName" type="text" class="input_type01 w_100p" title="발신자 표기명">
								</td>
							</tr>

							<tr>
								<th scope="row" rowspan="2">캠페인 완료코드</th>
								<td rowspan="2" colspan="3">
									<div id="completioncodes"></div>
								</td>
								<th scope="row">이벤트 특성</th>
								<td colspan="3">
									<input type="checkbox" class="chk_type01" id="recorderAttributesYn">
									<label for="recorderAttributesYn">이벤트 SDK/레코더로 특성 보내기</label>
								</td>
								<!-- <th scope="row">시도제외 완료코드</th>
								<td>
									<div id="completioncodesExcludedForAttemptCalculation"></div>
								</td> -->
							</tr>
							<tr>
								<th scope="row">이벤트 SDK/레코더 특성</th>
								<td colspan="3">
									<div id="recorderAttributes">컨택리스트를 선택해주세요</div>
								</td>
							</tr>
							<!-- <tr>
								<th scope="row">내보내기 설정</th>
								<td colspan="5">
									<input type="checkbox" class="chk_type01" id="exportContacts">
									<label for="exportContacts">컨택 시도 결과 데이터 내보내기</label>
								</td>

							</tr>

							<tr class="exportTr" style="display:none">
								<th scope="row">내보내기 빈도</th>
								<td>
									<ul>
										<li class="f_l w_50p">
											<input type="radio" class="radio_type01 mr_5" id="exportFrequencyType_1" name="exportFrequencyType" value="EXPORT_AT_JOB_END">
											<label for="exportFrequencyType_1">종료 후</label>
										</li>
										<li class="f_l w_50p">
											<input type="radio" class="radio_type01 mr_5" id="exportFrequencyType_2" name="exportFrequencyType" value="HOURLY">
											<label for="exportFrequencyValue_2">매 시간</label>
										</li>
										<li class="f_l w_50p mt_10">
											<input type="radio" class="radio_type01 mr_5" id="exportFrequencyType_3" name="exportFrequencyType" value="EVERY_N_MINS">
											<label for="exportFrequencyType_3">N분마다 실행</label>
										</li>
										<li class="f_l w_50p mt_10">
											<input type="text" id="exportFrequencyValue_min" class="input_type01 w_80 mr_10" title="내보내기 빈도값" placeholder="15~10080">분마다
										</li>
										<li class="f_l w_50p mt_10">
											<input type="radio" class="radio_type01 mr_5" id="exportFrequencyType_4" name="exportFrequencyType" value="DAILY_AT">
											<label for="exportFrequencyType_4">매일 지정 시간</label>
										</li>
										<li class="f_l w_50p mt_10">
											<input type="time" id="exportFrequencyValue_daily" class="input_type01 w_110" title="내보내기 빈도값">
										</li>
									</ul>
								</td>
								<th scope="row">내보낼 완료코드</th>
								<td>
									<div id="exportDataCompletioncodes"></div>
								</td>
								<th scope="row">내보낼 특성</th>
								<td>
									<div id="exportDataColumns"></div>
								</td>
							</tr> -->
						</tbody>
					</table>
				</div>
				<div class="popup_footer" style="margin-top:10px">
					<div class="button a_r">
						<button type="button" class="btn btn_secondary btn_size_n" id="save">
							<i class="xi-check"></i>저장
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
	<script type="text/javascript">
		var selectedCampId = "${campId}";
	</script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/SYCP01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/CPCM01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cp/cm/CPCM0101.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />