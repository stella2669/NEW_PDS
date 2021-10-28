<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %>
<%@ page import ="java.util.Map" %>
<%@page import="java.net.URLEncoder"%>
<jsp:useBean id="su" class="com.llynx.cmn.util.StringUtil" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<fmt:requestEncoding value="utf-8"/>

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

	<div class="inner_contents">
		<!-- search : end -->
		<!-- title : start -->
		<div class="title">
			<h2 class="title_2nd">${title}</h2>
		</div>
		<!-- title : end -->
		<!-- table : start -->
		<div class="board_A0_L a_c type_grid disable_paging" style="overflow-x:auto; overflow-y:auto" >
			<table aria-describedby="table_summary"  border="1" cellpadding="3" cellspacing="1" bgcolor="white" class="txt">								
				<colgroup>
					<col style="width:auto">
					<col style="width:auto">
					<col style="width:auto">
					<col style="width:auto">
					<col style="width:auto">
				</colgroup>
				<thead>
					<tr class="bd_top" align="center" bgcolor="FAF7D2">
						<c:forEach items="${colModel}" var="col">
							<c:if test="${hiddenYn eq 'Y'}">
								<c:if test="${col.hidden==null or col.hidden==false or col.hidden eq 'false'}">				
									<th scope="col">${col.label}</th>
								</c:if>
							</c:if>
							<c:if test="${hiddenYn eq 'N'}">
								<th scope="col">${col.label}</th>
							</c:if>
						</c:forEach>
					</tr>								
				</thead>
				<tbody>
					<c:forEach items="${dataList}" var="data" varStatus="sts">
						<tr>
							<c:forEach items="${colModel}" var="col">
								<c:if test="${hiddenYn eq 'Y'}">
									<c:if test="${col.hidden==null or col.hidden==false or col.hidden eq 'false'}">
										<c:set var="key" value="${col.name}"/>
										<td>${data[key]}</td>
									</c:if>
								</c:if>
								<c:if test="${hiddenYn eq 'N'}">
									<c:set var="key" value="${col.name}"/>
									<td>${data[key]}</td>
								</c:if>
							</c:forEach>
						</tr>
					</c:forEach>									
				</tbody>
			</table>
		</div>
		<!-- table : end -->
 	</div>                                                     
</body>



