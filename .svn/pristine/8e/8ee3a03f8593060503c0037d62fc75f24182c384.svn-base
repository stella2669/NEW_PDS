<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>

	<!-- wrap : start -->
	<div class="inner_contents">
			<form id="searchForm">
			<div class="search_A2">
				<div class="sc_input">
					<dl>
						<dt>조회 일자</dt>
						<dd>
							<div class="input_box">
								<span class="date_pick">
									<input type="text" class="date_cell input_type01 w_80" id="schStrtDate" name="schStrtDate">
									<label class="date_icon" for="schStrtDate"><i class="xi-calendar-check"></i><span class="replace_text">시작 기간</span></label>
								</span>
								<span class="date_space">~</span>
								<span class="date_pick">
									<input type="text" class="date_cell input_type01 w_80" id="schEndDate" name="schEndDate">
									<label class="date_icon" for="schEndDate"><i class="xi-calendar-check"></i><span class="replace_text">종료 기간</span></label>
								</span>
							</div>
						</dd>
						</dl>
						<dl>
						<dt>캠페인명</dt>
						<dd>
							<input type="text" class="input_type01 w_150" name="schCampNm" id="schCampNm">
							<button type="button" class="btn btn_third btn_size_s" id="search">
								<i class="xi-search"></i>조회
							</button>
						</dd>
					</dl>
					<dl>
						<dt>통계기준</dt>
						<dd>
							<select id="schby" title="통계기준" name="schby">
								<option value="DEFAULT">요약통계</option>
								<option value="DATE">일자별통계</option>
								<option value="HOUR">시간대별통계</option>
							</select>
						</dd>
					</dl>


				</div>
				<div class="button mr_10">
					<button type="button" class="btn btn_third btn_size_s"
						<c:if test="${campStaticsList.size()>0}">id="excelDown"</c:if>
						<c:if test="${campStaticsList.size()==0}">onclick="noDataAlert()"</c:if>
						>
						<i class="xi-search"></i>Excel
					</button>
				</div>
			</div>
			</form>
			<!-- search : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">캠페인 통계</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L type_grid" style="overflow:auto">
			<table aria-describedby="table_summary">
				<colgroup>
					<col style="width: ">
					<col style="width: ">
					<col style="width: ">
					<col style="width: ">
					<col style="width: ">
				</colgroup>
				<thead>
					<tr class="a_c">
						<c:if test="${param.schby!=null}">
							<c:if test="${param.schby eq 'DATE' or param.schby eq 'HOUR'}">
							<th>날짜</th>
							</c:if>
							<c:if test="${param.schby eq 'HOUR'}">
							<th>시간</th>
							</c:if>
						</c:if>
						<th>캠페인ID</th>
						<th>캠페인명</th>
						<th>총 컨택수</th>
						<th>시도건수</th>
						<th>시도율</th>
						<th>연결 성공수</th>
						<th>연결율</th>
						<th>포기콜</th>
						<th>포기율</th>
						<th>총 콜백</th>
						<th>총 통화수</th>
						<!-- <th>총 통화시간</th> -->
						<th>총 후처리수</th>
						<!-- <th>총 후처리시간</th> -->
						<th>총 대기수</th>
						<!-- <th>총 대기시간</th> -->
						<th>총 휴식수</th>
						<!-- <th>총 휴식시간</th> -->
						<!-- <th>상담원 활용율</th> -->
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${campStaticsList!=null and campStaticsList.size()>0}">
							<c:set var="rowSpan" value="1"/>
							<c:set var="totalContactsSum" value="0"/>
							<c:set var="voiceAttemptsSum" value="0"/>
							<c:set var="answerHumansSum" value="0"/>
							<c:set var="abandonCallsSum" value="0"/>
							<c:set var="callCountSum" value="0"/>
							<c:set var="callbackCountSum" value="0"/>
							<c:set var="acwCountSum" value="0"/>
							<c:set var="idleCountSum" value="0"/>
							<c:set var="breakCountSum" value="0"/>
							<c:forEach var="data" items="${campStaticsList}" varStatus="sts">
								<tr>

									<c:if test="${param.schby eq 'DATE' or param.schby eq 'HOUR'}">
										<td class="a_c">${data.syyyymmdd}</td>
									</c:if>

									<c:if test="${param.schby eq 'HOUR'}">
										<td class="a_c">${data.shour}시</td>
									</c:if>

									<td class="a_c">${data.campaignId}</td>
									<td>${data.campaignName}</td>
									<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${data.totalContacts}"/></td>
									<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${data.voiceAttempts}"/></td>

									<c:choose>
									<c:when test="${data.totalContacts>0}">
										<td class="a_r"><fmt:formatNumber type="percent" value="${data.voiceAttempts/data.totalContacts}"/></td>
									</c:when>
									<c:when test="${data.totalContacts==0}">
										<td class="a_r">0%</td>
									</c:when>
									</c:choose>

									<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${data.answerHumans}"/></td>

									<c:choose>
									<c:when test="${data.voiceAttempts>0}">
										<td class="a_r"><fmt:formatNumber type="percent" value="${data.answerHumans/data.voiceAttempts}"/></td>
									</c:when>
									<c:when test="${data.voiceAttempts==0}">
										<td class="a_r">0%</td>
									</c:when>
									</c:choose>

									<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${data.abandonCalls}"/></td>

									<c:choose>
									<c:when test="${data.voiceAttempts>0}">
										<td class="a_r"><fmt:formatNumber type="percent" value="${data.abandonCalls/data.voiceAttempts}"/></td>
									</c:when>
									<c:when test="${data.voiceAttempts==0}">
										<td class="a_r">0%</td>
									</c:when>
									</c:choose>

									<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${data.callbackCount}"/></td>

									<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${data.callCount}"/></td>
									<%-- <td class="a_r">${data.callDuration}</td> --%>
									<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${data.acwCount}"/></td>
									<%-- <td class="a_r">${data.acwDuration}</td> --%>
									<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${data.idleCount}"/></td>
									<%-- <td class="a_r">${data.idleDuration}</td> --%>
									<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${data.breakCount}"/></td>
									<%-- <td class="a_r">${data.jobBreakDuration}</td> --%>
									<%-- <td class="a_r">${data.agentUtilization}%</td> --%>
								</tr>


								<c:set var="totalContactsSum" value="${totalContactsSum+data.totalContacts}"/>
								<c:set var="voiceAttemptsSum" value="${voiceAttemptsSum+data.voiceAttempts}"/>
								<c:set var="answerHumansSum" value="${answerHumansSum+data.answerHumans}"/>
								<c:set var="abandonCallsSum" value="${abandonCallsSum+data.abandonCalls}"/>
								<c:set var="callCountSum" value="${callCountSum+data.callCount}"/>
								<c:set var="callbackCountSum" value="${callbackCountSum+data.callbackCount}"/>
								<c:set var="acwCountSum" value="${acwCountSum+data.acwCount}"/>
								<c:set var="idleCountSum" value="${idleCountSum+data.idleCount}"/>
								<c:set var="breakCountSum" value="${breakCountSum+data.breakCount}"/>

								<c:if test="${param.schby eq 'DATE' or param.schby eq 'HOUR'}">
									<c:if test="${param.schby eq 'DATE'}">
										<c:if test="${sts.index == campStaticsList.size()-1 or data.campaignId ne campStaticsList[sts.index+1].campaignId}">
											<tr>
												<th colspan="3">소계</th>
												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${totalContactsSum}"/></td>
												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${voiceAttemptsSum}"/></td>

												<c:choose>
												<c:when test="${totalContactsSum>0}">
													<td class="a_r"><fmt:formatNumber type="percent" value="${voiceAttemptsSum/totalContactsSum}"/></td>
												</c:when>
												<c:when test="${totalContactsSum==0}">
													<td class="a_r">0%</td>
												</c:when>
												</c:choose>

												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${answerHumansSum}"/></td>

												<c:choose>
												<c:when test="${totalContactsSum>0}">
													<td class="a_r"><fmt:formatNumber type="percent" value="${answerHumansSum/totalContactsSum}"/></td>
												</c:when>
												<c:when test="${totalContactsSum==0}">
													<td class="a_r">0%</td>
												</c:when>
												</c:choose>

												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${abandonCallsSum}"/></td>

												<c:choose>
												<c:when test="${voiceAttemptsSum>0}">
													<td class="a_r"><fmt:formatNumber type="percent" value="${abandonCallsSum/voiceAttemptsSum}"/></td>
												</c:when>
												<c:when test="${voiceAttemptsSum==0}">
													<td class="a_r">0%</td>
												</c:when>
												</c:choose>

												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${callbackCountSum}"/></td>
												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${callCountSum}"/></td>
												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${acwCountSum}"/></td>
												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${idleCountSum}"/></td>
												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${breakCountSum}"/></td>
												<c:set var="totalContactsSum" value="0"/>
												<c:set var="voiceAttemptsSum" value="0"/>
												<c:set var="answerHumansSum" value="0"/>
												<c:set var="abandonCallsSum" value="0"/>
												<c:set var="callCountSum" value="0"/>
												<c:set var="acwCountSum" value="0"/>
												<c:set var="idleCountSum" value="0"/>
												<c:set var="breakCountSum" value="0"/>
											</tr>
										</c:if>

									</c:if>
									<c:if test="${param.schby eq 'HOUR'}">
										<c:if test="${sts.index == campStaticsList.size()-1 or data.syyyymmdd ne campStaticsList[sts.index+1].syyyymmdd or data.campaignId ne campStaticsList[sts.index+1].campaignId}">
											<tr>
												<th colspan="4">소계</th>
												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${totalContactsSum}"/></td>
												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${voiceAttemptsSum}"/></td>

												<c:choose>
												<c:when test="${totalContactsSum>0}">
													<td class="a_r"><fmt:formatNumber type="percent" value="${voiceAttemptsSum/totalContactsSum}"/></td>
												</c:when>
												<c:when test="${totalContactsSum==0}">
													<td class="a_r">0%</td>
												</c:when>
												</c:choose>

												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${answerHumansSum}"/></td>

												<c:choose>
												<c:when test="${totalContactsSum>0}">
													<td class="a_r"><fmt:formatNumber type="percent" value="${answerHumansSum/totalContactsSum}"/></td>
												</c:when>
												<c:when test="${totalContactsSum==0}">
													<td class="a_r">0%</td>
												</c:when>
												</c:choose>

												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${abandonCallsSum}"/></td>

												<c:choose>
												<c:when test="${voiceAttemptsSum>0}">
													<td class="a_r"><fmt:formatNumber type="percent" value="${abandonCallsSum/voiceAttemptsSum}"/></td>
												</c:when>
												<c:when test="${voiceAttemptsSum==0}">
													<td class="a_r">0%</td>
												</c:when>
												</c:choose>

												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${callbackCountSum}"/></td>
												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${callCountSum}"/></td>
												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${acwCountSum}"/></td>
												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${idleCountSum}"/></td>
												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${breakCountSum}"/></td>
												<c:set var="totalContactsSum" value="0"/>
												<c:set var="voiceAttemptsSum" value="0"/>
												<c:set var="answerHumansSum" value="0"/>
												<c:set var="abandonCallsSum" value="0"/>
												<c:set var="callCountSum" value="0"/>
												<c:set var="callbackCountSum" value="0"/>
												<c:set var="acwCountSum" value="0"/>
												<c:set var="idleCountSum" value="0"/>
												<c:set var="breakCountSum" value="0"/>
											</tr>
										</c:if>
									</c:if>
								</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<c:if test="${param.schby eq 'DEFAULT' or param.schby==null}">
								<td class="a_c" colspan="13" style='border:none; border-bottom:1px solid #c8c8c8;'>조회된 데이터가 없습니다.</td>
								</c:if>
								<c:if test="${param.schby eq 'DATE'}">
									<td class="a_c" colspan="14" style='border:none; border-bottom:1px solid #c8c8c8;'>조회된 데이터가 없습니다.</td>
								</c:if>
								<c:if test="${param.schby eq 'HOUR'}">
									<td class="a_c" colspan="15" style='border:none; border-bottom:1px solid #c8c8c8;'>조회된 데이터가 없습니다.</td>
								</c:if>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- table : end -->
		<!-- title : start -->

	</div>

	<script type="text/javascript">
		var schby = "${param.schby}";
		var schStrtDate = "${param.schStrtDate}";
		var schEndDate = "${param.schEndDate}";
		var schCampNm = "${param.schCampNm}";
	</script>

	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/ALCA01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/al/ca/ALCA01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

