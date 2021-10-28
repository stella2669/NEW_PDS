/**
 * 컨택리스트 데이터소스관리
 */

var datasourceData = {}; // 데이터소스 등록 데이터

$(document).ready(function(){
	if(selectedDatasourceId!=""){
		ECMService.getAPI("datasources/"+selectedDatasourceId, function(result){
			if(result.result=="S"){
				//console.log(result)
;				setDatasourceDetail(result);
			}else{
				if(result.code!=null){
					LLYNX_Alert(ECMError(result.code, result.message));
				}else{
					LLYNX_Alert(result.msg);
				}
			}
		});
	}
	$("input:radio[name=datasourceType]").change();
});


$("input:radio[name=datasourceType]").change(function(){
	if($("input:radio[name=datasourceType]:checked").val()=="contact_file"){
		$(".fileType").show();
		$(".fileOption").show();
		$("input:radio[name=fileTyp]").change();
		$("#changeColspan").attr("colspan", 1);
	}else{
		$(".fileType").hide();
		$(".fileOption").hide();
		$("#changeColspan").attr("colspan", 3);
	}
});

$("input:radio[name=fileType]").change(function(){
	var val = $("input:radio[name=fileType]:checked").val();
	if(val=="local"){
		$(".fileOption").show();
		$(".localTd").show();
		$(".ftpTd").hide();
	}else if(val=="ftp"){
		$(".fileOption").show();
		$(".localTd").hide();
		$(".ftpTd").show();
	}else{
		$(".fileOption").hide();
	}
});

$("#save").click(function(){
	if(setDatasourceData()){
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
			LLYNX_Alert("저장되었습니다.", "close");
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

	if(parent.dnclistNm==null||parent.dnclistNm==""){
		LLYNX_Alert("DNC리스트명을 찾을 수 없습니다.\n 다시 시도해주세요");
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

	datasourceData.listName = parent.dnclistNm;

	if($("input:radio[name=jobType]:checked").val()=="import"){
		datasourceData.datasourceType = "dnc_file_for_add";
	}else{
		datasourceData.datasourceType = "dnc_file_for_remove";
	}

	datasourceData.name = $("#dataNm").val();
	datasourceData.description = $("#description").val();
	datasourceData.checkRejectPattern = $("#checkRejectPattern").prop("checked");
	datasourceData.checkPhoneFormatRule = $("#checkPhoneFormatRule").prop("checked");

	// 선택지는 없지만 필수값 default
	datasourceData.fieldSeparator = ","; // 필수값 default 콤마
	datasourceData.ifContactExists = "updateExisting"; // 필수값 default updateExisting

	// 데이터소스 타입이 파일일 때
	if($("input:radio[name=fileType]:checked").val()=="ftp"){
		// 파일 -> FTP/SFTP 일때
		datasourceData.ftpFileType = true;
		datasourceData.ftpSecured = true;
		datasourceData.ftpIPHostName = $("#ftpIPHostName").val();
		datasourceData.ftpUserName = $("#ftpUserName").val();
		datasourceData.ftpRemoteFilePath = $("#ftpRemoteFilePath").val();
		datasourceData.ftpPassword = $("#ftpPassword").val();
	}else if("local"){
		// 파일 -> Local 일때
		datasourceData.ftpFileType = false;
		datasourceData.localFilePathOnServer = $("#localFilePathOnServer").val();
	}
	return true;
}

function setDatasourceDetail(data){
	$("#dataNm").val(data.name);
	$("#dataNm").prop("readonly", true);
	$("#description").val(data.description);
	$("#checkRejectPattern").prop("checked", data.checkRejectPattern);
	$("#checkPhoneFormatRule").prop("checked", data.checkPhoneFormatRule);

	// 데이터소스 타입이 파일일 때
	if(data.ftpFileType){
		// 파일 -> FTP/SFTP 일때
		$("input:radio[name=fileType]:radio[value='ftp']").prop("checked", true);
		$("input:radio[name=fileType]").change();
		$("#ftpSecured").prop("checked", data.ftpSecured);
		$("#ftpIPHostName").val(data.ftpIPHostName);
		$("#ftpUserName").val(data.ftpUserName);
		$("#ftpRemoteFilePath").val(data.ftpRemoteFilePath);
		// $("#ftpPassword").val(data.ftpPassword);
	}else if("local"){
		// 파일 -> Local 일때
		$("input:radio[name=fileType]:radio[value='local']").prop("checked", true);
		$("input:radio[name=fileType]").change();
		var fileName = data.localFilePathOnServer.replace("/opt/Avaya/avpom/POManager/public/default/dncimport/", "");
		$("#localFilePathOnServer").val(fileName);
	}
}
