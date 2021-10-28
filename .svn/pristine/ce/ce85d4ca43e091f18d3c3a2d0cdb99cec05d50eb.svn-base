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
	<div class="popup_window drag w_1200" style="min-width:400px">
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
							<col style="width: 150px">
							<col style="width: 300px">
							<col style="width: 150px">
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


								<th scope="row" rowspan="3">옵션</th>
								<td rowspan="3" id="importTd">
									<ul>
										<li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="emptyContactListBeforeImport" name="emptyContactListBeforeImport">
											<label for="emptyContactListBeforeImport">가져오기 전 컨택목록 비우기</label>
										</li>
										<li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="pauseAssociatedCampaignsIfEmptyingContactlist" name="pauseAssociatedCampaignsIfEmptyingContactlist" disabled>
											<label for="pauseAssociatedCampaignsIfEmptyingContactlist">컨택 리스트 비우는 경우 캠페인 일시 중지</label>
										</li>
										<!-- <li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="ignoreActiveExcludeContactsIfEmptyingContactlist" name="ignoreActiveExcludeContactsIfEmptyingContactlist" disabled>
											<label for="ignoreActiveExcludeContactsIfEmptyingContactlist">컨택 리스트 비우는 경우 비활성 컨택 무시</label>
										</li>
										<li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="ignoreCallbackOnContactsIfEmptyingContactlist" name="ignoreCallbackOnContactsIfEmptyingContactlist" disabled>
											<label for="ignoreCallbackOnContactsIfEmptyingContactlist">컨택 리스트 비우는 경우 콜백 무시</label>
										</li>
										<li class="f_l w_50p mt_5" id="automaticTriggerImportLabel">
											<input type="checkbox" class="chk_type01 mr_5" id="automaticTriggerImport" name="automaticTriggerImport">
											<label for="automaticTriggerImport">파일 가져오기 자동 시작</label>
										</li>
										<li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="automaticUpdateTimezone" name="automaticUpdateTimezone">
											<label for="automaticUpdateTimezone">시간대 자동 업데이트</label>
										</li> -->
										<li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="checkRejectPattern" name="checkRejectPattern">
											<label for="checkRejectPattern">패턴 거부 대상 확인</label>
										</li>
										<li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="checkPhoneFormatRule" name="checkPhoneFormatRule">
											<label for="checkPhoneFormatRule">전화번호 규칙 확인</label>
										</li>
										<li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="checkDNC" name="checkDNC">
											<label for="checkDNC">DNC 목록의 전화번호 확인</label>
										</li>
										<li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="cleanupPhoneNumber" name="cleanupPhoneNumber">
											<label for="cleanupPhoneNumber">전화번호에서 숫자가 아닌 문자 제거</label>
										</li>
										<!-- <li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="emptyPhoneOnRuleMatch" name="emptyPhoneOnRuleMatch">
											<label for="emptyPhoneOnRuleMatch">규칙과 일치하는 전화번호 제거</label>
										</li>
										<li class="f_l w_50p mt_5">
											<input type="checkbox" class="chk_type01 mr_5" id="emptyInvalidEmail" name="emptyInvalidEmail">
											<label for="emptyInvalidEmail">잘못된 빈 이메일 주소 확인</label>
										</li> -->
										<li class="f_l w_50p mt_5">
											<select id="ifContactExists">
												<option value="updateExisting">기존 컨택 업데이트</option>
												<option value="ignoreNew">새 컨택 무시</option>
											</select>
											<label for="ifContactExists">중복 컨택 발견시</label>
										</li>
									</ul>
								</td>
								<td rowspan="3" style="display:none" id="exceptTd">
									<input type="checkbox" class="chk_type01 mr_5" id="retainCallBack" name="retainCallBack">
									<label for="retainCallBack">콜백 컨택 유지</label>
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
								<th scope="row">유형</th>
								<td id="changeColspan" colspan="3">
									<ul>
										<li class="f_l w_100 mt_5">
											<input type="radio" class="radio_type01 mr_5" id="datasourceType_1" name="datasourceType" value="contact_file">
											<label for="datasourceType_1">파일</label>
										</li>
										<li class="f_l w_100 mt_5">
											<input type="radio" class="radio_type01 mr_5" id="datasourceType_2" name="datasourceType" value="database_sql">
											<label for="datasourceType_2">데이터베이스</label>
										</li>
									</ul>
								</td>
								<th scope="row" class="fileType" style="display:none">파일유형</th>
								<td class="fileType" style="display:none">
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
								<td class="localTd">
									<input type="text" class="input_type01 w_100p" title="파일경로" id="localFilePathOnServer" name="localFilePathOnServer">
									<label for="localFilePathOnServer">파일명만 입력(기본 경로 자동저장)</label>
								</td>
								<td class="ftpTd" style="display:none">
									<!-- <input type="checkbox" class="chk_type01 mr_5" id="ftpSecured" name="ftpSecured">
									<label for="ftpSecured">보안됨</label><br/> -->
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
								<th scope="row">필드 구분방법</th>
								<td colspan="3">
									<ul>
										<li class="f_l w_33p mt_5">
											<input type="radio" class="radio_type01 mr_5" id="fieldSeparator_1" name="fieldSeparator" value="," checked>
											<label for="fieldSeparator_1">콤마(,)</label>
										</li>
										<li class="f_l w_33p mt_5">
											<input type="radio" class="radio_type01 mr_5" id="fieldSeparator_2" name="fieldSeparator" value="	">
											<label for="fieldSeparator_2">탭</label>
										</li>
										<li class="f_l w_33p mt_5">
											<input type="radio" class="radio_type01 mr_5" id="fieldSeparator_3" name="fieldSeparator" value=":">
											<label for="fieldSeparator_3">콜론(:)</label>
										</li>
										<li class="f_l w_33p mt_5">
											<input type="radio" class="radio_type01 mr_5" id="fieldSeparator_4" name="fieldSeparator" value=";">
											<label for="fieldSeparator_4">세미콜론(;)</label>
										</li>
										<li class="f_l w_33p mt_5">
											<input type="radio" class="radio_type01 mr_5" id="fieldSeparator_5" name="fieldSeparator" value="|">
											<label for="fieldSeparator_5">파이프(|)</label>
										</li>
										<li class="f_l w_33p mt_5">
											<input type="radio" class="radio_type01 mr_5" id="fieldSeparator_6" name="fieldSeparator" value="etc">
											<label for="fieldSeparator_6">기타</label>
											<input type="text" class="w_50 ml_10" id="etcFiledSperatorValue" maxlength="1">
										</li>
									</ul>
								</td>
							</tr>
							<tr class="dbOption" style="display:none">
								<th scope="row">데이터베이스 유형</th>
								<td>
									<select id="databaseType">
										<option value="ORACLE">ORACLE</option>
										<option value="POSTGRES" selected>POSTGRES</option>
										<option value="MSSQL">MSSQL</option>
									</select>
								</td>
								<th scope="row">데이터베이스 Host</th>
								<td>
									<input type="text" class="input_type01 w_100p" title="DB호스트" id="databaseIPHostName" name="databaseIPHostName" autocomplete="off">
								</td>
							</tr>
							<tr class="dbOption" style="display:none">
								<th scope="row" id="dbName">데이터베이스 이름</th>
								<td>
									<input type="text" class="input_type01 w_100p" title="DB스케마" id="databaseName" name="databaseName" autocomplete="off">
								</td>
								<th scope="row">데이터베이스 포트</th>
								<td>
									<input type="text" class="input_type01 w_100p" title="DB포트" id="databasePort" name="databasePort" autocomplete="off">
								</td>
							</tr>
							<tr class="dbOption" style="display:none">
								<th scope="row">사용자명</th>
								<td>
									<input type="text" class="input_type01 w_100p" title="사용자명" id="databaseUserName" name="databaseUserName" autocomplete="off">
								</td>
								<th scope="row">비밀번호</th>
								<td>
									<input type="password" class="input_type01 w_100p" title="비밀번호" id="databasePassword" name="databasePassword" autocomplete="off">
								</td>
							</tr>
							<tr class="dbOption" style="display:none">
								<td class="a_c" colspan="4">
									<button type="button" class="btn btn_primary btn_size_n" id="testConnect">
										<i class="xi-link"></i>연결테스트
									</button>
									<button type="button" class="btn btn_third btn_size_n" id="dbConnect">
										<i class="xi-link"></i>컬럼 맵핑
									</button>
								</td>
							</tr>
							<tr id="dbMappingDataTr" style="display:none">
								<th scope="row">매핑 쿼리</th>
								<td id="dbMappingDataTd" colspan="4"></td>
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
		var selectContactlistId = "${contactListId}"
		var selectedDatasourceId = "${datasourceId}";
	</script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/CUCO01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/dwr/interface/ECMService.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/cu/co/CUCO0401.js?timestamp=${nowDate}'/>"></script>
	<!-- wrap : end -->
</body>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />