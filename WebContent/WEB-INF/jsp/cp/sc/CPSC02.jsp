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
	<div class="popup_window drag w_700">
		<div class="popup_header">
			<h1>일정추가</h1>
			<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
		</div>
		<div class="popup_content">
			<!-- popup_body : start -->
			<div class="popup_body">
				<div class="title">
					<h2 class="title_2nd">일정추가</h2>
				</div>
				<!-- table : start -->
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">일정추가</caption>
						<colgroup>
							<col style="width: 150px">
							<col style="width: auto">
						</colgroup>
						<tbody id="rows">
							<tr>
								<th scope="row">일정 유형</th>
								<td>
									<select id="scheduleType" title="일정 유형선택">
										<option value="">-일정 유형-</option>
										<c:forEach var="type" items="${typeList}">
											<option value="${type.cd}">${type.nm}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>

								<th scope="row">일정명</th>
								<td>
									<select id="scheduleName">
										<option value="">-일정명 선택-</option>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="row">시작일시</th>
								<td>
									<div class="input_box">
										<span class="date_pick">
											<input class="input_type01" id="startTime" type="datetime-local" title="시작 시간" step="60">
										</span>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">시간대</th>
								<td>
									<select id="selectTimeZone" name="selectTimeZone" size="1">
										<option value="GMT">(-12:00) 날짜 변경선 서쪽</option>
										<option value="Pacific/Apia">(-11:00) 미드웨이 제도, 사모아</option>
										<option value="Pacific/Honolulu">(-10:00) 하와이</option>
										<option value="America/Anchorage">(-09:00) 알래스카</option>
										<option value="America/Los_Angeles">(-08:00) 태평양 표준시( 및 캐나다), 티후아나</option>
										<option value="America/Phoenix">(-07:00) 아리조나</option>
										<option value="America/Denver">(-07:00) 산지 표준시(미국 및 캐나다)</option>
										<option value="America/Chihuahua">(-07:00) 치와와, 라파스, 마사틀란</option>
										<option value="America/Managua">(-06:00) 중앙 아메리카</option>
										<option value="America/Regina">(-06:00) 서스캐처원</option>
										<option value="America/Mexico_City">(-06:00) 과달라하라, 멕시코시티, 몬테레이</option>
										<option value="America/Chicago">(-06:00) 중부 표준시(미국 및 캐나다)</option>
										<option value="America/Indianapolis">(-05:00) 인디애나(동부)</option>
										<option value="America/Bogota">(-05:00) 보고타, 리마, 키토</option>
										<option value="America/New_York">(-05:00) 동부 표준시(미국 및 캐나다)</option>
										<option value="America/Caracas">(-04:30) 카라카스</option>
										<option value="America/Santiago">(-04:00) 산티아고</option>
										<option value="America/Halifax">(-04:00) 대서양 표준시(캐나다)</option>
										<option value="America/St_Johns">(-03:30) 뉴펀들랜드</option>
										<option value="America/Buenos_Aires">(-03:00) 부에노스아이레스, 조지타운</option>
										<option value="America/Godthab">(-03:00) 그린란드</option>
										<option value="America/Sao_Paulo">(-03:00) 브라질리아</option>
										<option value="America/Noronha">(-02:00) 중부-대서양</option>
										<option value="Atlantic/Cape_Verde">(-01:00) 카보베르데 제도</option>
										<option value="Atlantic/Azores">(-01:00) 아조레스</option>
										<option value="Africa/Casablanca">(+00:00) 카스블랑카, 몬로비아</option>
										<option value="Europe/London">(+00:00) 그리니치 표준시: 더블린, 에든버러, 리스본, 런던</option>
										<option value="Africa/Lagos">(+01:00) 서중앙 아프리카</option>
										<option value="Europe/Berlin">(+01:00) 암스테르담, 베를린, 베른, 로마, 스톡홀름, 비엔나</option>
										<option value="Europe/Paris">(+01:00) 브뤼셀, 코펜하겐, 마드리드, 파리</option>
										<option value="Europe/Sarajevo">(+01:00) 사라예보, 스코페, 바르샤바, 자그레브</option>
										<option value="Europe/Belgrade">(+01:00) 베오그라드, 브라티슬라바, 부다페스트, 류블랴나, 프라하</option>
										<option value="Africa/Johannesburg">(+02:00) 하라레, 프리토리아</option>
										<option value="Asia/Jerusalem">(+02:00) 예루살렘</option>
										<option value="Europe/Istanbul">(+02:00) 아테네, 이스탄불, 민스크</option>
										<option value="Europe/Helsinki">(+02:00) 헬싱키, 키예프, 리가, 소피아, 탈린, 빌뉴스</option>
										<option value="Africa/Cairo">(+02:00) 카이로</option>
										<option value="Europe/Bucharest">(+02:00) 부쿠레슈티</option>
										<option value="Africa/Nairobi">(+03:00) 나이로비</option>
										<option value="Asia/Riyadh">(+03:00) 쿠웨이트, 리야드</option>
										<option value="Europe/Moscow">(+03:00) 모스코바,  상트페테르부르크, 볼고그라드</option>
										<option value="Asia/Baghdad">(+03:00) 바그다드</option>
										<option value="Asia/Tehran">(+03:30) 테헤란</option>
										<option value="Asia/Muscat">(+04:00) 아부다비, 무스카트</option>
										<option value="Asia/Tbilisi">(+04:00) 바쿠, 트빌리시, 예레반</option>
										<option value="Asia/Kabul">(+04:30) 카불</option>
										<option value="Asia/Karachi">(+05:00) 이슬라마바드, 카라치, 타슈켄트</option>
										<option value="Asia/Yekaterinburg">(+05:00) 예카테린부르크</option>
										<option value="Asia/Calcutta">(+05:30) 체나이, 콜카타, 뭄바이, 뉴델리</option>
										<option value="Asia/Katmandu">(+05:45) 카트만두</option>
										<option value="Asia/Colombo">(+06:00) 스리자야와르데네푸라 코테</option>
										<option value="Asia/Dhaka">(+06:00) 아스타나, 다카</option>
										<option value="Asia/Novosibirsk">(+06:00) 알마티, 노보시비르스크</option>
										<option value="Asia/Rangoon">(+06:30) 랑군</option>
										<option value="Asia/Bangkok">(+07:00) 방콕, 하노이, 자카르타</option>
										<option value="Asia/Krasnoyarsk">(+07:00) 크라스노야르스크</option>
										<option value="Australia/Perth">(+08:00) 퍼스</option>
										<option value="Asia/Taipei">(+08:00) 타이페이</option>
										<option value="Asia/Singapore">(+08:00) 콸라룸푸르, 싱가포르</option>
										<option value="Asia/Hong_Kong">(+08:00) 베이징, 충칭, 홍콩 특별 행정구, 우루무치</option>
										<option value="Asia/Irkutsk">(+08:00) 이르쿠츠크, 울란바토르</option>
										<option value="Asia/Tokyo">(+09:00) 오사카, 삿포로, 도쿄</option>
										<option value="Asia/Seoul" selected>(+09:00) 서울</option>
										<option value="Asia/Yakutsk">(+09:00) 야쿠츠크</option>
										<option value="Australia/Darwin">(+09:30) 다윈</option>
										<option value="Australia/Adelaide">(+09:30) 애들레이드</option>
										<option value="Pacific/Guam">(+10:00) 괌, 포트모르즈비</option>
										<option value="Australia/Brisbane">(+10:00) 브리즈번</option>
										<option value="Asia/Vladivostok">(+10:00) 블라디보스토크</option>
										<option value="Australia/Hobart">(+10:00) 호바트</option>
										<option value="Australia/Sydney">(+10:00) 캔버라, 멜버른, 시드니</option>
										<option value="Asia/Magadan">(+11:00) 마가단, 솔로몬 제도, 뉴칼레도니아</option>
										<option value="Pacific/Fiji">(+12:00) 피지, 캄차카 반도, 마셜 제도</option>
										<option value="Pacific/Auckland">(+12:00) 오클랜드, 웰링턴</option>
										<option value="Pacific/Tongatapu">(+13:00) 누쿠알로파</option>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="row">반복여부</th>
								<td>
									<input type="checkbox" id="repeatYn" class="check_type01">
									<label for="repeatYn">반복 여부</label>
								</td>
							</tr>
							<tr class="repeatSchedule" style="display:none">
								<th scope="row">반복주기</th>
								<td>
									<select id="recurringFrequency">
										<option value="">-반복주기 선택-</option>
										<option value="RunEveryNMins">N분마다</option>
										<option value="Daily">매일</option>
										<option value="Weekly">매주</option>
										<option value="Monthly">매월</option>
										<option value="Yearly">매년</option>
									</select>
									<span class="ml_10" id="dailyInput" style="display:none">
										<input type="checkbox" id="weekDaysOnly" class="check_type01">
										<label for="weekDaysOnly">평일만</label>
									</span>

									<span class="ml_10" id="minsInput" style="display:none">
										<input type="text" class="input_type01 a_r w_100" id="runEveryMinutes" onKeyUp="numberKeyup(this);">분마다
									</span>

									<div class="mt_10" id="weeklyInput" style="display:none">
										<ul>
											<li class="f_l">
												<input type="checkbox" id="selectedDaysSun" name="selectedDays" class="chk_type01" value="Sunday">
												<label for="selectedDaysSun">일요일</label>
											</li>
											<li class="f_l ml_10">
												<input type="checkbox" id="selectedDaysMon" name="selectedDays" class="chk_type01" value="Monday">
												<label for="selectedDaysMon">월요일</label>
											</li>
											<li class="f_l ml_10">
												<input type="checkbox" id="selectedDaysTue" name="selectedDays" class="chk_type01" value="Tuesday">
												<label for="selectedDaysTue">화요일</label>
											</li>
											<li class="f_l ml_10">
												<input type="checkbox" id="selectedDaysWed" name="selectedDays" class="chk_type01" value="Wednesday">
												<label for="selectedDaysWed">수요일</label>
											</li>
											<li class="f_l ml_10">
												<input type="checkbox" id="selectedDaysThu" name="selectedDays" class="chk_type01" value="Thursday">
												<label for="selectedDaysThu">목요일</label>
											</li>
											<li class="f_l ml_10">
												<input type="checkbox" id="selectedDaysFri" name="selectedDays" class="chk_type01" value="Friday">
												<label for="selectedDaysFri">금요일</label>
											</li>
											<li class="f_l ml_10">
												<input type="checkbox" id="selectedDaysSat" name="selectedDays" class="chk_type01" value="Saturday">
												<label for="selectedDaysSat">토요일</label>
											</li>
										</ul>
									</div>
								</td>
							</tr>
							<tr class="repeatSchedule" style="display:none">
								<th scope="row">완료일시</th>
								<td>
									<div class="input_box">
										<span class="date_pick">
											<input class="input_type01" id="endTime" type="datetime-local" title="완료 시간" step="60">
										</span>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="popup_footer" style="margin-top:10px">
					<div class="button a_r">
						<button type="button" class="btn btn_secondary btn_size_n" id="addSchedule">
							<i class="xi-plus-circle"></i>일정등록
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
	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cp/sc/CPSC02.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />