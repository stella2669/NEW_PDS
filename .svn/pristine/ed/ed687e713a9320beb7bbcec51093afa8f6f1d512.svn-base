/**
 * 콜백 일괄수정
 */
var loginInfo = _getLoginInfo();

$(document).ready(function(){
	//callbackSearch();
});

//일괄버튼 클릭시
$("#save").click(function(){
	updateCallbackAgent();
});


$(".popup_close").click(function(){
	parent.popupClose();
});


var saveData = {
	callbackIdList:[],
	agentId:""
}

function updateCallbackAgent(){
	if(trim($("#callbackids").text())==""){
		alert('변경할 콜백을 선택하세요!')
		return;
	}

	if(trim($("#agentId").val())==""){
		alert('변경할 상담원을 입력하세요!')
		return;
	}
	saveData.agentId=$("#agentId").val();
	var calllist=trim($("#callbackids").text());
	//console.log(calllist);

	for(var i=0; i<calllist.split(",").length;i++){
		saveData.callbackIdList.push((calllist.split(",")[i])*1);
	}

	LLYNX_Confirm("변경하시겠습니까?", "updateFunction");
}

function updateFunction(){
	ECMService.updateAPI("callbacks", JSON.stringify(saveData), function(result){
		//console.log(result);
		var str1="";
		str1=" 전체 항목수 : "+result.totalCount;
		str1=str1+"\n 성공 항목수 : "+result.successCount;
		str1=str1+"\n 실패 항목수 : "+result.failureCount;

		LLYNX_Alert(str1, "close");
		$("#ifr_tabs-PG_CACA_01", parent.document)[0].contentWindow.callbackSearch();

	});
}

