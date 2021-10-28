/**
 * 캠페인 작업매개변수관리
 */

var loginInfo = _getLoginInfo();

var pacingType="";
var paramData = {};

$(document).ready(function(){
	setCampInfo();
});

$("#save").click(function(){
	if(setParameters()){
		LLYNX_Confirm("변경하시겠습니까?", "editParam");
	}
});

function editParam(){
	//console.log(paramData);
	ECMService.updateAPI("campaigns/"+selectedCampId+"/job-parameters", JSON.stringify(paramData), function(result){
		if(result.result&&result.result!="F"){
			$("#ifr_tabs-PG_CPCM_01", parent.document)[0].contentWindow.campSearch();
			LLYNX_Alert("변경되었습니다.", "close");
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}
$("#EcrProbType").change(function(){
	var thisVal = $(this).val();
	if(thisVal=="ecrAgtUpdateTime"){
		$(".ecrAgtUpdateType_pram").show();
	}else{
		$(".ecrAgtWorkType_param").show();
	}
});

$(".popup_close").click(function(){
	parent.popupClose();
});

function setCampInfo(){
	if(selectedCampId!=""){
		progressShow();
		ECMService.getAPI("campaigns/"+selectedCampId, function(result){
			if(result.result=="S"){
				$("#campNm").text(result.name);
				progressHide();
				ECMService.getAPI("campaigns/"+selectedCampId+"/job-parameters", function(paramResult){
					if(paramResult.result=="S"){
						pacingType = paramResult.pacingType;
						$("#pacingType").text(paramResult.pacingType);
						$("#channelType").text(paramResult.channelType);
						$("#priority").val(paramResult.parameters.priority);
						$("#minAgent").val(paramResult.parameters.minAgent);
						$("#maxAgent").val(paramResult.parameters.maxAgent);
						if(paramResult.pacingType=="ECR"){
							$(".ECR").show();
							$("#MinHitRate").val(paramResult.parameters.minHitRate);
							$("#EcrProbType").val(paramResult.parameters.ecrProbType);
							$("#EcrProbType").change();

							if(paramResult.parameters.ecrProbType=="ecrAgtUpdateTime"){
								$("#EcrUpdateProb").val(paramResult.parameters.ecrUpdateProb);
							}else{
								$("#EcrHandleProb").val(paramResult.parameters.ecrHandleProb);
							}
						}else if(paramResult.pacingType=="Progressive"){
							$(".Progressive").show();
							$("#overDialRatio").val(Math.round(paramResult.parameters.overDialRatio));
						}else if(paramResult.pacingType=="CruiseControl"){
							$(".CruiseControl").show();
							$("#desiredSL").val(Math.round(paramResult.parameters.desiredServiceLevel));
						}
					}else{
						if(paramResult.code!=null){
							if(paramResult.code=="201"){
								LLYNX_Alert("캠페인의 작업을 찾을 수 없습니다.", 'close');
							}else{
								LLYNX_Alert(ECMError(result.code, result.message));
							}
						}else{
							LLYNX_Alert(paramResult.msg);
						}
					}
				});
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
}

function setParameters(){
	paramData.parameters = {};

	if($("#priority").val()==""){
		LLYNX_Alert("우선순위를 입력해주세요.", "focus", "priority");
		return false;
	}

	if($("#minAgent").val()==""){
		LLYNX_Alert("최소 상담사를 입력해주세요.", "focus", "minAgent");
		return false;
	}

	if($("#maxAgent").val()==""){
		LLYNX_Alert("최대 상담사를 입력해주세요.", "focus", "maxAgent");
		return false;
	}

	if(isNaN($("#minAgent").val())||$("#minAgent").val()>9999||$("#minAgent").val()<0){
		LLYNX_Alert("최소 상담사는 0~9999 사이의 숫자를 입력해주세요.", "focus", "minAgent");
		return false;
	}

	if(isNaN($("#maxAgent").val())||$("#maxAgent").val()>9999||$("#maxAgent").val()<1){
		LLYNX_Alert("최대 상담사는 1~9999 사이의 숫자를 입력해주세요.", "focus", "maxAgent");
		return false;
	}

	paramData.parameters.priority = $("#priority").val();
	paramData.parameters.minAgent = $("#minAgent").val();
	paramData.parameters.maxAgent = $("#maxAgent").val();

	if(pacingType=="ECR"){
		paramData.parameters.minHitRate = $("#MinHitRate").val();
		paramData.parameters.ecrProbType = $("#EcrProbType").val();
		if(paramData.parameters.ecrProbType=="ecrAgtUpdateTime"){
			paramData.parameters.ecrProbValue = $("#EcrUpdateProb").val();
		}else{
			paramData.parameters.ecrProbValue = $("#EcrHandleProb").val();
		}
	}else if(pacingType=="Progressive"){
		paramData.parameters.overDialRatio = $("#overDialRatio").val();
	}else if(pacingType=="CruiseControl"){
		paramData.parameters.desiredServiceLevel = $("#desiredSL").val();
	}
	return true;

}