/**
 * 콜백 상세조회
 */

var loginInfo = _getLoginInfo();

$(document).ready(function(){
	callbackSearch();
});

function callbackSearch(){
	//$("#callbackid").val();
	//alert($("#callbackid").text());
	if(trim($("#callbackid").text())==""){
		return;
	}
	ECMService.getAPI("callbacks/"+trim($("#callbackid").text()), function(result){
		//
		if(result.result=="S"){
			$("#campaignName").text(result.campaignName);
			$("#contactlistId").text(result.contactlistId);
			$("#contactlistName").text(result.contactlistName);
			$("#systemContactId").text(result.systemContactId);
			$("#userContactId").text(result.userContactId);

			$("#agentSessionId").text(result.agentSessionId);
			$("#jobId").text(result.jobId);
			$("#actionId").text(result.actionId);
			$("#servicedByAgentId").text(result.servicedByAgentId);
			$("#callbackType").text(setName01(result.callbackType));

			$("#status").text(setName02(result.status));
			$("#createdBy").text(result.createdBy);
			$("#createdForAgent").text(result.createdForAgent);
			$("#nextAttemptTime").text(result.nextAttemptTime);
			$("#startTime").text(momentDateFormat(result.startTime));
			$("#endTime").text(momentDateFormat(result.endTime));

			$("#createdOn").text(momentDateFormat(result.createdOn));
			$("#address").text(emptyString(result.address));
			$("#firstName").text(emptyString(result.lastName)+" "+emptyString(result.firstName));
			$("#notes").text(result.notes);

			//parent.document.ifr_tabs-PG_CACA_01.campmNm1.text("-----------------");
			//$("#ifr_tabs-PG_CACA_01", parent.document)[0].contentWindow.test01();
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
		//console.log("========="+result);
	});
}

$(".popup_close").click(function(){
	parent.popupClose();
});


function setName01(value){
	var format="";;
	switch(value) {
		case "Agent" :
			format='상담사';
			break;
		case "Campaign" :
			format='캠페인';
			break;
		case "Standard" :
			format='표준';
			break;
		case "StrictAgent" :
			format='지정 상담사';
			break;
		default :
			format=value;
		break;
	}

	return format;
}

function setName02(value){
	var format="";;
	switch(value) {
		case "ActiveAttachedToJob" :
			format='활성 작업에 연결됨';
			break;
		case "Completed" :
			format='완료됨';
			break;
		case "Expired" :
			format='만료됨';
			break;
		case "CampaignTerminated" :
			format='캠페인 종료됨';
			break;
		case "Overwritten" :
			format='덮어씀';
			break;
		case "ContactExcluded" :
			format='제외된 컨택';
			break;
		case "WaitingForJob" :
			format='작업 대기중';
			break;
		case "ManuallyCancelled" :
			format='수동으로 취소됨';
			break;
		case "QueuedForDialing" :
			format='연결중';
			break;
		case "InProgress" :
			format='처리중';
			break;
		default :
			format=value;
		break;
	}

	return format;
}

function emptyString(str){
	if(str==null||str==undefined){
		return "";
	}else{
		return str;
	}
}
