<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:set var="title" value="${title}"/>
<c:set var="fileNm" value="${fileNm}"/>

<%

String excelTitle = (String)pageContext.getAttribute("fileNm");
String excelFile = excelTitle.replace(" ", "_");
String fileNm = URLEncoder.encode(excelFile, "UTF-8");
response.setHeader("Content-Type", "application/x-msdownload");
response.setHeader("Content-Disposition", "attachment;filename="+fileNm +".xls;");
response.setContentType("appliction/vnd.ms-excel;charset=UTF-8");

%>

<meta http-equiv="Content-Type" content="appliction/vnd.ms-excel;charset=UTF-8">

<style type="text/css">
	body  {background:#ffffff; margin:0px;padding:0px;}
td  {color:#000000;font-size:12px; line-height:1.6em; font-family:돋움,Dotum,AppleGothic,Verdana,sans-serif;margin:0px;padding:0px;}
table {border:0px;}
img {border:0px;}
a{color:#3f3f3f;text-decoration:none;}
a.visited,a.visited:visited{color:#8c7f6d;}
a:hover{color:#8c7f6d;text-decoration:none;}

/* PNG 이미지 보이기 */
.png24 {tmp:expression(setPng24(this))}

/* Form 박스 */
.box1 {  font-family: "돋움"; font-size:12px; color:#727272; text-decoration: none; border:solid 1px #e3e3e3; background-color:#ffffff; padding-top:2px; padding-bottom:2px; vertical-align:middle;line-height:19px;height:19px }
.box2 {  font-size:12px; color:#727272; text-decoration:none; background-color:#ffffff; padding-top:5px; padding-right:5px; padding-bottom:5px; padding-left:5px; border:solid 1px #e3e3e3}
.box3 {  font-size:12px; color:#727272; text-decoration:none; background-color:#ffffff;  border:solid 0px #e3e3e3}
.box4 {  font-size:12px; color:#333333; text-decoration:none; background-color:#f2f2f2; height:140px; padding-top:5px; padding-right:5px; padding-bottom:5px; padding-left:5px; border:solid 1px #d7d7d7}
input.gray{
	border: 1px solid #e3e3e3;
	height: 23px
}
input, textarea{
	font-family: 돋움;
	font-size: 12pt;
	color:#727272;
}

/*텍스트*/

.txt01{font-family:굴림,Arial;font-size:13px;font-weight:bold;color:#5170a6;letter-spacing:0px;}
.txt02{font-family:굴림,Arial;font-size:13px;font-weight:bold;color:#727272;letter-spacing:0px;}


/* 링크 */
.sub_text01:link {font-family:굴림,Arial;  font-size:12px;color:#727272;font-weight:bold; text-decoration:none;}
.sub_text01:visited {font-family:굴림,Arial; font-size:12px;color:#ff9900;font-weight:bold; text-decoration:none;}
.sub_text01:active {font-family:굴림,Arial; font-size:12px;color:#ff9900;font-weight:bold; text-decoration:none;}
.sub_text01:hover	{font-family:굴림,Arial; font-size:12px;color:#ff9900;font-weight:bold; text-decoration:none;}


/* 스크롤바 색상 */
.iBody02 {		scrollbar-face-color: #cfcfcf;
		scrollbar-shadow-color: #FFFFFF;
		scrollbar-highlight-color: #cfcfcf;
		scrollbar-3dlight-color: #FFFFFF;
		scrollbar-darkshadow-color: #cfcfcf;
		scrollbar-track-color: #FFFFFF;
		scrollbar-arrow-color: #FFFFFF;
}
</style>
<body>

	<!-- wrap : start -->
	<div class="inner_contents">

		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">${title}</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L type_grid">
			<table aria-describedby="table_summary"  border="1" cellpadding="3" cellspacing="1" bgcolor="white" class="txt">
				<colgroup>
					<col style="width: ">
					<col style="width: ">
					<col style="width: ">
					<col style="width: ">
					<col style="width: ">
				</colgroup>
				<thead>
					<tr class="bd_top" align="center" bgcolor="FAF7D2">
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
							<c:set var="nuisanceCallsSum" value="0"/>
							<c:set var="callCounSum" value="0"/>
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

									<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${data.nuisanceCalls}"/></td>

									<c:choose>
									<c:when test="${data.voiceAttempts>0}">
										<td class="a_r"><fmt:formatNumber type="percent" value="${data.nuisanceCalls/data.voiceAttempts}"/></td>
									</c:when>
									<c:when test="${data.voiceAttempts==0}">
										<td class="a_r">0%</td>
									</c:when>
									</c:choose>

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


								<c:set var="totalContactsSum" value="${totalContactsSum+data.totalContacts }"/>
								<c:set var="voiceAttemptsSum" value="${voiceAttemptsSum+data.voiceAttempts }"/>
								<c:set var="answerHumansSum" value="${answerHumansSum+data.answerHumans }"/>
								<c:set var="nuisanceCallsSum" value="${nuisanceCallsSum+data.nuisanceCalls }"/>
								<c:set var="callCountSum" value="${callCountSum+data.callCount }"/>
								<c:set var="callbackCountSum" value="${callbackCountSum+data.callbackCount}"/>
								<c:set var="acwCountSum" value="${acwCountSum+data.acwCount }"/>
								<c:set var="idleCountSum" value="${idleCountSum+data.idleCount }"/>
								<c:set var="breakCountSum" value="${breakCountSum+data.breakCount }"/>
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

												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${nuisanceCallsSum}"/></td>

												<c:choose>
												<c:when test="${voiceAttemptsSum>0}">
													<td class="a_r"><fmt:formatNumber type="percent" value="${nuisanceCallsSum/voiceAttemptsSum}"/></td>
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
												<c:set var="nuisanceCallsSum" value="0"/>
												<c:set var="callCountSum" value="0"/>
												<c:set var="callbackCountSum" value="0"/>
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

												<td class="a_r"><fmt:formatNumber type="number" pattern="#" value="${nuisanceCallsSum}"/></td>

												<c:choose>
												<c:when test="${voiceAttemptsSum>0}">
													<td class="a_r"><fmt:formatNumber type="percent" value="${nuisanceCallsSum/voiceAttemptsSum}"/></td>
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
												<c:set var="nuisanceCallsSum" value="0"/>
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
								<td class="a_c" colspan="13">조회된 데이터가 없습니다.</td>
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

