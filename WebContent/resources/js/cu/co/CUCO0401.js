/**
 * 컨택리스트 데이터소스관리
 */

var datasourceData = {}; // 데이터소스 등록 데이터
var dbConnectInfo = {}; // DB접속정보
var dbMappingData = {}; // DB연결하여 매핑할 정보


$(document).ready(function(){
	if(selectedDatasourceId!=""){
		ECMService.getAPI("datasources/"+selectedDatasourceId, function(result){
			if(result.result=="S"){
				setDatasourceDetail(result);
			}else{
				if(result.code!=null){
					LLYNX_Alert(ECMError(result.code, result.message));
				}else{
					LLYNX_Alert(result.msg);
				}
			}
		});
	}

});

$("#databaseType").change(function(){
	var thisVal = $(this).val();
	if(thisVal=="ORACLE"){
		$("#dbName").text("서비스 이름");
	}else{
		$("#dbName").text("데이터베이스 이름");
	}
});

$("input:radio[name=datasourceType]").change(function(){
	if($("input:radio[name=datasourceType]:checked").val()=="contact_file"){
		$(".dbOption").hide();
		$(".fileType").show();
		$(".fileOption").show();
		$("input:radio[name=fileTyp]").change();
		$("#changeColspan").attr("colspan", 1);
		$("#automaticTriggerImportLabel").show();
		$("#automaticTriggerImport").prop("checked", false);
	}else{
		$(".fileType").hide();
		$(".fileOption").hide();
		$("#changeColspan").attr("colspan", 3);
		$(".dbOption").show();
		$("#automaticTriggerImport").prop("checked", false);
		$("#automaticTriggerImportLabel").hide();
	}
});

$("input:radio[name=jobType]").change(function(){
	var val = $("input:radio[name=jobType]:checked").val();
	if(val=="import"){
		$("#exceptTd").hide();
		$("#importTd").show();
	}else{
		$("#exceptTd").show();
		$("#importTd").hide();
	}
});

$("input:radio[name=fileType]").change(function(){
	var val = $("input:radio[name=fileType]:checked").val();
	if(val=="local"){
		$(".ftpTd").hide();
		$(".fileOption").show();
		$(".localTd").show();
		$("#automaticTriggerImportLabel").show();
	}else if(val=="ftp"){
		$(".localTd").hide();
		$("#automaticTriggerImportLabel").hide();
		$(".fileOption").show();
		$(".ftpTd").show();
	}else{
		$(".fileOption").hide();
	}
});

$("#emptyContactListBeforeImport").change(function(){
	if($("#emptyContactListBeforeImport").prop("checked")){
		$("#pauseAssociatedCampaignsIfEmptyingContactlist").prop("disabled", false);
		$("#ignoreActiveExcludeContactsIfEmptyingContactlist").prop("disabled", false);
		$("#ignoreCallbackOnContactsIfEmptyingContactlist").prop("disabled", false);
	}else{
		$("#pauseAssociatedCampaignsIfEmptyingContactlist").prop("disabled", true);
		$("#ignoreActiveExcludeContactsIfEmptyingContactlist").prop("disabled", true);
		$("#ignoreCallbackOnContactsIfEmptyingContactlist").prop("disabled", true);
	}
});

$("#testConnect").click(function(){
	if($("#databaseIPHostName").val()==""){
		LLYNX_Alert("데이터베이스 HOST명을 입력해주세요.", "focus", "databaseIPHostName");
	}else if($("#databaseName").val()==""){
		LLYNX_Alert("데이터베이스명을 입력해주세요.", "focus", "databaseName");
	}else if($("#databasePort").val()==""){
		LLYNX_Alert("데이터베이스 포트를 입력해주세요.", "focus", "databasePort");
	}else if($("#databaseUserName").val()==""){
		LLYNX_Alert("데이터베이스 사용자명을 입력해주세요.", "focus", "databaseUserName");
	}else if($("#databasePassword").val()==""){
		LLYNX_Alert("데이터베이스 비밀번호를 입력해주세요.", "focus", "databasePassword");
	}else{
		dbConnectInfo.databaseType = $("#databaseType").val();
		dbConnectInfo.host = $("#databaseIPHostName").val();
		dbConnectInfo.port = $("#databasePort").val();
		dbConnectInfo.database = $("#databaseName").val();
		dbConnectInfo.username = $("#databaseUserName").val();
		dbConnectInfo.password = $("#databasePassword").val();
		CUCO01_Service.testConnect(dbConnectInfo, function(result){
			if(result.result=="S"){
				LLYNX_Alert("정상적으로 연결되었습니다.");
			}else{
				LLYNX_Alert("연결에 실패하였습니다.\n 입력한 정보를 확인해주세요.");
			}
		});
	}
});

$("#dbConnect").click(function(){
	if($("#databaseIPHostName").val()==""){
		LLYNX_Alert("데이터베이스 HOST명을 입력해주세요.", "focus", "databaseIPHostName");
	}else if($("#databaseName").val()==""){
		LLYNX_Alert("데이터베이스명을 입력해주세요.", "focus", "databaseName");
	}else if($("#databasePort").val()==""){
		LLYNX_Alert("데이터베이스 포트를 입력해주세요.", "focus", "databasePort");
	}else if($("#databaseUserName").val()==""){
		LLYNX_Alert("데이터베이스 사용자명을 입력해주세요.", "focus", "databaseUserName");
	}else if($("#databasePassword").val()==""){
		LLYNX_Alert("데이터베이스 비밀번호를 입력해주세요.", "focus", "databasePassword");
	}else{
		dbConnectInfo.databaseType = $("#databaseType").val();
		dbConnectInfo.host = $("#databaseIPHostName").val();
		dbConnectInfo.port = $("#databasePort").val();
		dbConnectInfo.database = $("#databaseName").val();
		dbConnectInfo.username = $("#databaseUserName").val();
		dbConnectInfo.password = $("#databasePassword").val();
		CUCO01_Service.testConnect(dbConnectInfo, function(result){
			if(result.result=="S"){
				popupOpen("/cu/cuco0402.do?contactListId="+selectContactlistId);
			}else{
				LLYNX_Alert("연결에 실패하였습니다.\n 입력한 정보를 확인해주세요.");
			}
		});
	}

});

$("#save").click(function(){
	if(setDatasourceData()){
		console.log(datasourceData);
		if(selectedDatasourceId==""){
			LLYNX_Confirm("등록하시겠습니까?", "insertDatasource");
		}else{
			LLYNX_Confirm("수정하시겠습니까?", "updateDatasource");
		}
	}
});

function insertDatasource(){
	ECMService.insertAPI("datasources", JSON.stringify(datasourceData), function(result){
		if(result.result=="S"){
			parent.dataListSearch();
			LLYNX_Alert("등록되었습니다.", "close");
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function updateDatasource(){
	ECMService.updateAPI("datasources/"+selectedDatasourceId, JSON.stringify(datasourceData), function(result){
		if(result.result=="S"){
			console.log(result);
			parent.dataListSearch();
			LLYNX_Alert("수정되었습니다.", "close");
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

$(".popup_close").click(function(){
	parent.popupClose();
});

function setDatasourceData(){

	if(parent.contactlistName==null||parent.contactlistName==""){
		LLYNX_Alert("컨택리스트명을 찾을 수 없습니다.\n 다시 시도해주세요");
		return false;
	}

	if($("#dataNm").val()==""){
		LLYNX_Alert("데이터소스명을 입력해주세요.", "focus", "dataNm");
		return false;
	}

	if($("input:radio[name=datasourceType]:checked").val()==""||$("input:radio[name=datasourceType]:checked").val()==null||$("input:radio[name=datasourceType]:checked").val()==undefined){
		LLYNX_Alert("데이터소스유형을 선택해주세요.", "focus", "datasourceType");
		return false;
	}

	datasourceData.listName = parent.contactlistName;

	if($("input:radio[name=jobType]:checked").val()=="import"){
		datasourceData.datasourceType = $("input:radio[name=datasourceType]:checked").val();
	}else{
		if($("input:radio[name=datasourceType]:checked").val()=="contact_file"){
			datasourceData.datasourceType = "EXCLUDE_CONTACTS_FILE";
		}else{
			datasourceData.datasourceType = "EXCLUDE_CONTACTS_DB";
		}
	}

	datasourceData.name = $("#dataNm").val();
	datasourceData.description = $("#description").val();
	datasourceData.emptyContactListBeforeImport = $("#emptyContactListBeforeImport").prop("checked");
	datasourceData.pauseAssociatedCampaignsIfEmptyingContactlist = $("#pauseAssociatedCampaignsIfEmptyingContactlist").prop("checked");
	datasourceData.ignoreActiveExcludeContactsIfEmptyingContactlist = $("#ignoreActiveExcludeContactsIfEmptyingContactlist").prop("checked");
	datasourceData.ignoreCallbackOnContactsIfEmptyingContactlist = $("#ignoreCallbackOnContactsIfEmptyingContactlist").prop("checked");
	datasourceData.ignoreCallbackOnContactsIfEmptyingContactlist = $("#ignoreCallbackOnContactsIfEmptyingContactlist").prop("checked");
	datasourceData.automaticTriggerImport = $("#automaticTriggerImport").prop("checked");
	datasourceData.automaticUpdateTimezone = $("#automaticUpdateTimezone").prop("checked");
	datasourceData.checkRejectPattern = $("#checkRejectPattern").prop("checked");
	datasourceData.checkPhoneFormatRule = $("#checkPhoneFormatRule").prop("checked");
	datasourceData.checkDNC = $("#checkDNC").prop("checked");
	datasourceData.cleanupPhoneNumber = $("#cleanupPhoneNumber").prop("checked");
	datasourceData.emptyPhoneOnRuleMatch = $("#emptyPhoneOnRuleMatch").prop("checked");
	datasourceData.emptyInvalidEmail = $("#emptyInvalidEmail").prop("checked");
	datasourceData.ifContactExists = $("#ifContactExists").val();

	if(datasourceData.datasourceType == "contact_file" || datasourceData.datasourceType ==  "EXCLUDE_CONTACTS_FILE"){
		if($("input:radio[name=fieldSeparator]:checked").val()!="etc"){
			datasourceData.fieldSeparator = $("input:radio[name=fieldSeparator]:checked").val();
		}else{
			datasourceData.fieldSeparator = $("#etcFiledSperatorValue").val();
		}
		// 데이터소스 타입이 파일일 때
		if($("input:radio[name=fileType]:checked").val()=="ftp"){

			// 파일 -> FTP/SFTP 일때
			datasourceData.ftpFileType = true;
			//datasourceData.ftpSecured = $("#ftpSecured").prop("checked");
			datasourceData.ftpSecured = true; // 보안됨 default로 변경
			datasourceData.ftpIPHostName = $("#ftpIPHostName").val();
			datasourceData.ftpUserName = $("#ftpUserName").val();
			datasourceData.ftpRemoteFilePath = $("#ftpRemoteFilePath").val();
			datasourceData.ftpPassword = $("#ftpPassword").val();
		}else if("local"){
			// 파일 -> Local 일때
			datasourceData.ftpFileType = false;
			datasourceData.localFilePathOnServer = $("#localFilePathOnServer").val();
		}
	}else{

		if($("#databaseIPHostName").val()==""){
			LLYNX_Alert("데이터베이스 HOST명을 입력해주세요.", "focus", "databaseIPHostName");
			return false;
		}

		if($("#databaseName").val()==""){
			LLYNX_Alert("데이터베이스명을 입력해주세요.", "focus", "databaseName");
			return false;
		}

		if($("#databasePort").val()==""){
			LLYNX_Alert("데이터베이스 포트를 입력해주세요.", "focus", "databasePort");
			return false;
		}

		if($("#databaseUserName").val()==""){
			LLYNX_Alert("데이터베이스 사용자명을 입력해주세요.", "focus", "databaseUserName");
			return false;
		}

		if($("#databasePassword").val()==""){
			LLYNX_Alert("데이터베이스 비밀번호를 입력해주세요.", "focus", "databasePassword");
			return false;
		}

		// 데이터소스 타입이 데이터베이스일 때
		datasourceData.databaseType = $("#databaseType").val();
		datasourceData.databaseIPHostName = $("#databaseIPHostName").val();
		datasourceData.databaseName = $("#databaseName").val();
		datasourceData.databasePort = $("#databasePort").val();
		datasourceData.databaseUserName = $("#databaseUserName").val();
		datasourceData.databasePassword = $("#databasePassword").val();

		if(dbMappingData.databaseQuery!=null && dbMappingData.databaseQuery!="" && dbMappingData.databaseQuery!=undefined && dbMappingData.systemAttributeMappingList.length>0){
			datasourceData.databaseQuery = dbMappingData.databaseQuery;
			datasourceData.systemAttributeMappingList = dbMappingData.systemAttributeMappingList;
			datasourceData.customAttributeMappingList = dbMappingData.customAttributeMappingList;
		}else{
			LLYNX_Alert("데이터베이스 매핑데이터가 없습니다.\n 데이터베이스 연결을 눌러 매핑데이터를 선택해주세요");
			datasourceData = {};
			return false;
		}
	}
	return true;
}

function setDatasourceDetail(data){
	$("#dataNm").val(data.name);
	$("#dataNm").prop("readonly", true);
	$("#description").val(data.description);
	$("#emptyContactListBeforeImport").prop("checked", data.emptyContactListBeforeImport);
	$("#pauseAssociatedCampaignsIfEmptyingContactlist").prop("checked", data.pauseAssociatedCampaignsIfEmptyingContactlist);
	$("#ignoreActiveExcludeContactsIfEmptyingContactlist").prop("checked", data.ignoreActiveExcludeContactsIfEmptyingContactlist);
	$("#ignoreCallbackOnContactsIfEmptyingContactlist").prop("checked", data.ignoreCallbackOnContactsIfEmptyingContactlist);
	$("#ignoreCallbackOnContactsIfEmptyingContactlist").prop("checked", data.ignoreCallbackOnContactsIfEmptyingContactlist);
	$("#automaticTriggerImport").prop("checked", data.automaticTriggerImport);
	$("#automaticUpdateTimezone").prop("checked", data.automaticUpdateTimezone);
	$("#checkRejectPattern").prop("checked", data.checkRejectPattern);
	$("#checkPhoneFormatRule").prop("checked", data.checkPhoneFormatRule);
	$("#checkDNC").prop("checked", data.checkDNC);
	$("#cleanupPhoneNumber").prop("checked", data.cleanupPhoneNumber);
	$("#emptyPhoneOnRuleMatch").prop("checked", data.emptyPhoneOnRuleMatch);
	$("#emptyInvalidEmail").prop("checked", data.emptyInvalidEmail);
	if(data.ifContactExists=="Update existing"){
		$("#ifContactExists").val("updateExisting");
	}else{
		$("#ifContactExists").val("ignoreNew");
	}


	if(data.datasourceType == "contact_file" || data.datasourceType ==  "EXCLUDE_CONTACTS_FILE"){
		if(data.datasourceType ==  "EXCLUDE_CONTACTS_FILE"){
			$("input:radio[name=jobType]:radio[value='except']").prop("checked", true);
			$("input:radio[name=jobType]").change();
		}
		$("input:radio[name=datasourceType]:radio[value='contact_file']").prop("checked", true);
		$("input:radio[name=datasourceType]").change();
		if(data.fieldSeparator==","||data.fieldSeparator=="|"||data.fieldSeparator==":"||data.fieldSeparator==";"){
			$("input:radio[name=fieldSeparator]:radio[value='"+data.fieldSeparator+"']").prop("checked", true);
		}else if(data.fieldSeparator=="Tab"){
			$("input:radio[name=fieldSeparator]:radio[value='	']").prop("checked", true);
		}else{
			$("input:radio[name=fieldSeparator]:radio[value='etc']").prop("checked", true);
			 $("#etcFiledSperatorValue").val(data.fieldSeparator);
		}

		// 데이터소스 타입이 파일일 때
		if(data.ftpFileType){
			// 파일 -> FTP/SFTP 일때
			$("input:radio[name=fileType]:radio[value='ftp']").prop("checked", true);
			$("input:radio[name=fileType]").change();
			$("#ftpSecured").prop("checked", data.ftpSecured);
			$("#ftpIPHostName").val(data.ftpIPHostName);
			$("#ftpUserName").val(data.ftpUserName);
			$("#ftpRemoteFilePath").val(data.ftpRemoteFilePath);
			// $("#ftpPassword").val(data.ftpPassword); 패스워드 항상 입력하도록
		}else if("local"){
			// 파일 -> Local 일때
			$("input:radio[name=fileType]:radio[value='local']").prop("checked", true);
			$("input:radio[name=fileType]").change();
			var fileName = data.localFilePathOnServer.replace("/opt/Avaya/avpom/POManager/public/default/contactlistimport/", "");
			$("#localFilePathOnServer").val(fileName);
		}
	}else{
		// 데이터소스 타입이 데이터베이스일 때
		$("input:radio[name=datasourceType]:radio[value='database_sql']").prop("checked", true);
		$("input:radio[name=datasourceType]").change();
		$("#databaseType").val(data.databaseType);
		$("#databaseIPHostName").val(data.databaseIPHostName);
		$("#databaseName").val(data.databaseName);
		$("#databasePort").val(data.databasePort);
		$("#databaseUserName").val(data.databaseUserName);
		// $("#databasePassword").val(data.databasePassword); 패스워드 항상 입력하도록
		$("#dbMappingDataTr").show();
		$("#dbMappingDataTd").text(data.databaseQuery);
		dbMappingData.databaseQuery = data.databaseQuery;
		dbMappingData.systemAttributeMappingList = data.systemAttributeMappingList;
		dbMappingData.customAttributeMappingList = data.customAttributeMappingList;
	}
}

function showMappingData(){
	$("#dbMappingDataTr").show();
	$("#dbMappingDataTd").text(dbMappingData.databaseQuery);
}

// 메인화면 팝업 오픈
function popupOpen(url) {
	$("#popupDiv").show();
	$("#popupDiv").html('<iframe id="layerPopup" src="'+url+'" onload="addDiv2();"></iframe>');
}

function addDiv2() {
	$("#layerPopup").contents().find(".popup_window").wrap("<div class='popup_align'></div>");
}

// 메인화면 팝업 종료
function popupClose() {
	$("#popupDiv").html("");
	$("#popupDiv").hide();
}