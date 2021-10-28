/**
 * 캠페인 복제
 */

var loginInfo = _getLoginInfo();

var copyRequestBody = {
	fromCampaign:"",
	toCampaign:""
}

$(document).ready(function(){
	if(fromCampId!=""){
		ECMService.getAPI("campaigns/"+fromCampId,function(result){
			if(result.result=="S"){
				$("#fromCampaign").text(result.name);
				copyRequestBody.fromCampaign = result.name;
			}else{
				if(result.code!=null){
					LLYNX_Alert(ECMError(result.code, result.message));
				}else{
					LLYNX_Alert(result.msg);
				}
			}
		});
	}else{
		LLYNX_Alert("선택된 캠페인 정보가 없습니다.\n다시 시도해주세요.", 'close');
	}
});

$("#save").click(function(){
	if($("#toCampaign").val()!=""){
		LLYNX_Confirm("복사하시겠습니까?", "copyCamp");
	}
});

function copyCamp(){
	copyRequestBody.toCampaign = $("#toCampaign").val();
	ECMService.insertAPI("campaigns/clone", JSON.stringify(copyRequestBody), function(result){
		if(result.result&&result.result!="F"){
			$("#ifr_tabs-PG_CPCM_01", parent.document)[0].contentWindow.campSearch();
			LLYNX_Alert("복사되었습니다.", "close");
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

function thisPopupClose(){
	parent.popupClose();
}