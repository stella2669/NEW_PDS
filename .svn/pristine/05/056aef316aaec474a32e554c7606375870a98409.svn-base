<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
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

	<%
	List<Map<String, Object>> sumList = new ArrayList<Map<String, Object>>();
	%>

	<!-- wrap : start -->
	<div class="inner_contents">
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">${title}</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L type_grid" style="overflow:auto">
			<table aria-describedby="table_summary"  border="1" cellpadding="3" cellspacing="1" bgcolor="white" class="txt">
				<colgroup>
					<c:if test="${param.schby eq 'DATE' or param.schby eq 'HOUR'}">
						<col style="width: 150px">
					</c:if>
					<col style="width: auto">
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
						<c:forEach var="com" items="${completionCodeList}">
							<th style="min-width: 150px">${com.krName}</th>
							<c:set var="codeId" value="${com.id}"/>
							<%
								Map<String, Object> data = new HashMap<String, Object>();
								int codeId = (int)pageContext.getAttribute("codeId");
								data.put("id", codeId);
								data.put("count", 0);
								sumList.add(data);
							%>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${campList!=null and campList.size()>0}">
							<c:forEach var="camp" items="${campList}" varStatus="stsCamp">
								<tr>
									<c:if test="${param.schby eq 'DATE' or param.schby eq 'HOUR'}">
										<td class="a_c" style="min-width: 120px">${camp.syyyymmdd}</td>
									</c:if>

									<c:if test="${param.schby eq 'HOUR'}">
										<td class="a_c">${camp.shour}시</td>
									</c:if>
									<td class="a_c">${camp.campaignId}</td>
									<td>${camp.campaignName}</td>
									<c:forEach var="campCode" items="${completionCodeList}" varStatus="stsCode">
											<c:set var="comCount" value="0"/>
											<c:forEach var="statics" items="${campStaticsList}">
												<c:if test="${camp.campaignId eq statics.campaignId and camp.syyyymmdd eq statics.syyyymmdd and camp.shour eq statics.shour}">
													<c:if test="${campCode.id eq statics.completionCodeId}">
														<c:set var="comCount" value="${comCount+statics.comCount}"/>
														<c:set var="campCodeId" value="${statics.completionCodeId}"/>
														<c:set var="campCodeCount" value="${statics.comCount}"/>
														<%
															int campCodeId = (int)pageContext.getAttribute("campCodeId");
															int campCodeCount = (int)pageContext.getAttribute("campCodeCount");
															for(int i=0;i<sumList.size();i++){
																if((int)sumList.get(i).get("id")==campCodeId){
																	sumList.get(i).put("count", (int)sumList.get(i).get("count")+campCodeCount);
																}
															}
														%>
													</c:if>
												</c:if>
											</c:forEach>
											<td class="a_r">${comCount}</td>
									</c:forEach>
								</tr>
								<c:if test="${param.schby eq 'DATE' or param.schby eq 'HOUR'}">
									<c:if test="${param.schby eq 'DATE'}">
										<c:if test="${stsCamp.index == campList.size()-1 or camp.campaignId !=  campList[stsCamp.index+1].campaignId}">
											<tr>
												<th colspan="3">소계</th>
												<%
													for(int i=0;i<sumList.size();i++){
												%>
													<td class="a_r"><%=sumList.get(i).get("count")%></td>
												<%
														sumList.get(i).put("count", 0);
													}
												%>
											</tr>
										</c:if>
									</c:if>

									<c:if test="${param.schby eq 'HOUR'}">
										<c:if test="${stsCamp.index == campList.size()-1 or camp.campaignId !=  campList[stsCamp.index+1].campaignId or camp.syyyymmdd !=  campList[stsCamp.index+1].syyyymmdd}">
											<tr>
												<th colspan="4">소계</th>
												<%
													for(int i=0;i<sumList.size();i++){
												%>
													<td class="a_r"><%=sumList.get(i).get("count")%></td>
												<%
														sumList.get(i).put("count", 0);
													}
												%>
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
	<script type="text/javascript" src="<c:url value='/dwr/interface/ALCC01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/al/cc/ALCC01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

