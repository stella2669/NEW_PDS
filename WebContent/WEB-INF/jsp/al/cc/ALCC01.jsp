<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>

	<%
	List<Map<String, Object>> sumList = new ArrayList<Map<String, Object>>();
	%>

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
							<button type="button" class="btn btn_third btn_size_s ml_5" id="search">
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
						<c:if test="${campList.size()>0}">id="excelDown"</c:if>
						<c:if test="${campList.size()==0}">onclick="noDataAlert()"</c:if>
						>
						<i class="xi-search"></i>Excel
					</button>
				</div>
			</div>
			</form>
			<!-- search : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">캠페인 완료코드 통계</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L type_grid" style="overflow:auto">
			<table aria-describedby="table_summary" style="overflow:auto">
				<colgroup>
					<c:if test="${param.schby eq 'DATE' or param.schby eq 'HOUR'}">
						<col style="width: 150px">
					</c:if>
					<col style="width: auto">
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
												<c:if test="${param.schby eq 'DEFAULT' or param.schby eq 'DATE' or param.schby == null}">
													<c:if test="${camp.campaignId eq statics.campaignId and camp.syyyymmdd eq statics.syyyymmdd}">
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
												</c:if>
												<c:if test="${param.schby eq 'HOUR'}">
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
								<c:if test="${param.schby eq 'DEFAULT' or param.schby==null}">
								<td class="a_c" colspan="${4+completionCodeList.size()}" style='border:none; border-bottom:1px solid #c8c8c8;'>조회된 데이터가 없습니다.</td>
								</c:if>
								<c:if test="${param.schby eq 'DATE'}">
									<td class="a_c" colspan="${5+completionCodeList.size()} style='border:none; border-bottom:1px solid #c8c8c8;'">조회된 데이터가 없습니다.</td>
								</c:if>
								<c:if test="${param.schby eq 'HOUR'}">
									<td class="a_c" colspan="${6+completionCodeList.size()} style='border:none; border-bottom:1px solid #c8c8c8;'">조회된 데이터가 없습니다.</td>
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
	<script type="text/javascript" src="<c:url value='/dwr/interface/ALCC01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/al/cc/ALCC01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

