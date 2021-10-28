/**
 * 콜백 편집
 */
var loginInfo = _getLoginInfo();

$(document).ready(function(){
	callbackSearch();
});

$(".popup_close").click(function(){
	parent.popupClose();
});

var updateData = {
	cabackId:"",
	timeZone:"GMT+09:00"
}

//편집버튼 클릭시
$("#save").click(function(){
	Save();
});

$("#callbackType").change(function(){
	var thisVal = $(this).val();
	if(thisVal=="Agent"||thisVal=="StrictAgent"){
		$(".newAgentRow").show();
	}else{
		$(".newAgentRow").hide();
	}
});

function Save(){
	if(trim($("#callbackid").text())==""){
		alert('변경할 콜백을 선택하세요.')
		return;
	}

	LLYNX_Confirm("저장하시겠습니까?", "editCallback");
}

function editCallback(){
	updateData.callbackId=trim($("#callbackid").text());

	if($("#callbackType").val()=="Agent"||$("#callbackType").val()=="StrictAgent"){
		updateData.agentId=$("#createdForAgent").val();
	}

	if($("#callbackType").val()!=''){
		updateData.callbackType=$("#callbackType").val();
	}

	if($("#startTime").val()!=""){
		updateData.startTime = moment($("#startTime").val()).format("YYYY/MM/DD HH:mm:ss");
	}

	if($("#endTime").val()!=""){
		updateData.endTime = moment($("#endTime").val()).format("YYYY/MM/DD HH:mm:ss");
	}
	if($("#nextAttemptTime").val()!=""){
		updateData.nextAttemptTime = moment($("#nextAttemptTime").val()).format("YYYY/MM/DD HH:mm:ss");
	}

	ECMService.updateAPI("callbacks/"+trim($("#callbackid").text()), JSON.stringify(updateData), function(result){
		//console.log(result);
		if(result.result=="S"){
			$("#ifr_tabs-PG_CACA_01", parent.document)[0].contentWindow.callbackSearch();
			LLYNX_Alert('저장 되었습니다.', "close");
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function callbackSearch(){
	//$("#callbackid").val();
	if(trim($("#callbackid").text())==""){
		return;
	}
	ECMService.getAPI("callbacks/"+trim($("#callbackid").text()), function(result){
		//
		if(result.result=="S"){
			$("#callbackType_c").text(setName01(result.callbackType));
			$("#callbackType").val(result.callbackType);
			$("#callbackType").change();
			if(result.callbackType=="Agent"||result.callbackType=="StrictAgent"){
				$("#createdForAgent_c").text(result.createdForAgent);
			}

			$("#endTime_c").text(date_to_str(result.endTime));
			$("#startTime_c").text(date_to_str(result.startTime));
			//alert(result.nextAttemptTime);
			$("#nextAttemptTime_c").text(date_to_str(result.nextAttemptTime));
			console.log(result.createdForAgent)
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

function setClear(str){

	if(str==1){
		$("#startDate").val('');
		$("#startTime").val('');
	}else if(str==2){
		$("#endDate").val('');
		$("#endTime").val('');
	}else if(str==3){
		$("#nextDate").val('');
		$("#nextTime").val('');
	}
}

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


