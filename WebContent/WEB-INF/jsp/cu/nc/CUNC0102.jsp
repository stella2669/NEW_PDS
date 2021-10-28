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
	<div class="popup_window drag w_500" style="min-width:400px">
		<div class="popup_header">
			<h1>${thisPage}</h1>
			<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
		</div>
		<div class="popup_content" style="overflow:hidden">
			<!-- popup_body : start -->
			<div class="popup_body">
				<div class="title">
					<h2 class="title_2nd">${thisPage}</h2>
				</div>
				<form id="resetForm">
				<div class="board_A0_L">
					<table aria-describedby="table_summary">
						<caption id="table_summary">${thisPage}</caption>
						<colgroup>
							<col style="width: 100px">
							<col style="width: auto">
						</colgroup>
						<tbody>
							<tr class="bd_top">
								<th scope="row">작업유형</th>
								<td>
									<ul>
										<li class="f_l w_100 mt_5">
											<input type="radio" class="radio_type01 mr_5" id="jobType_1" name="jobType" value="import" checked>
											<label for="jobType_1">등록하기</label>
										</li>
										<li class="f_l w_100 mt_5">
											<input type="radio" class="radio_type01 mr_5" id="jobType_2" name="jobType" value="except">
											<label for="jobType_2">제거하기</label>
										</li>
									</ul>
								</td>
							</tr>
							<tr>
								<th scope="row">데이터소스명</th>
								<td>
									<input type="text" class="input_type01 w_100p" title="데이터소스명" id="dataNm" name="dataNm" value="">
								</td>


							</tr>
							<tr>
								<th scope="row">설명</th>
								<td>
									<textarea class="textarea_type01 w_100p h_90"  id="description" name="description" title="설명" onkeyup="jsMaxLength(500);"></textarea>
								</td>

							</tr>
							<tr>

								<th scope="row">옵션</th>
								<td id="importTd">
									<ul>
										<li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="checkRejectPattern" name="checkRejectPattern">
											<label for="checkRejectPattern">패턴 거부 대상 확인</label>
										</li>
										<li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="checkPhoneFormatRule" name="checkPhoneFormatRule">
											<label for="checkPhoneFormatRule">전화번호 규칙 확인</label>
										</li>
									</ul>
								</td>
							</tr>
							<tr>
								<th scope="row">유형</th>
								<td id="changeColspan">
									<ul>
										<li class="f_l w_100 mt_5">
											<input type="radio" class="radio_type01 mr_5" id="datasourceType_1" name="datasourceType" value="contact_file" checked>
											<label for="datasourceType_1">파일</label>
										</li>
									</ul>
								</td>
							</tr>
							<tr>
								<th scope="row" class="fileType">파일유형</th>
								<td class="fileType">
									<ul>
										<li class="f_l w_50p mt_5">
											<input type="radio" class="radio_type01 mr_5" id="fileType_1" name="fileType" value="local" checked>
											<label for="fileType_1">PDS서버</label>
										</li>
										<li class="f_l w_50p mt_5">
											<input type="radio" class="radio_type01 mr_5" id="fileType_2" name="fileType" value="ftp">
											<label for="fileType_2">SFTP</label>
										</li>
									</ul>
								</td>
							</tr>

							<tr class="fileOption" style="display:none">
								<th scope="row">경로</th>
								<td class="localTd" colspan="3">
									<input type="text" class="input_type01 w_100p" title="파일경로" id="localFilePathOnServer" name="localFilePathOnServer">
									<label for="localFilePathOnServer">파일명만 입력(기본 경로 자동저장)</label>
								</td>
								<td class="ftpTd" style="display:none" colspan="3">
									<ul>
										<li class="f_l w_100p mt_5">
											<label for="ftpIPHostName" class="w_70 mr_5" style="height:24px">HOST명 : </label>
											<input type="text" class="input_type01 w_100p" title="HOST" id="ftpIPHostName" name="ftpIPHostName" autocomplete="off">
										</li>
										<li class="f_l w_50p mt_5 pr_10">
											<label for="ftpUserName" class="w_70 mr_5">사용자명 :   </label>
											<input type="text" class="input_type01 w_100p" title="사용자" id="ftpUserName" name="ftpUserName" autocomplete="off">
										</li>
										<li class="f_l w_50p mt_5">
											<label for="ftpPassword" class="w_70 mr_5">비밀번호 : </label>
											<input type="password" class="input_type01 w_100p" title="비밀번호" id="ftpPassword" name="ftpPassword" autocomplete="false">
										</li>
										<li class="f_l w_100p mt_5">
											<label for="ftpRemoteFilePath" class="w_70 mr_5">원격경로 : </label>
											<input type="text" class="input_type01 w_100p" title="원격경로" id="ftpRemoteFilePath" name="ftpRemoteFilePath" autocomplete="off">
										</li>
									</ul>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				</form>
				<!-- detail : end -->
				<!-- table : end -->
				<div class="popup_footer" style="margin-top:10px">
					<div class="button a_r">
						<button type="button" class="btn btn_third btn_size_n" id="save">
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
		var selectedDatasourceId = "${datasourceId}";
	</script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cu/nc/CUNC0102.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />