/**
 * 콜백 일괄삭제
 */
var loginInfo = _getLoginInfo();

$(document).ready(function(){
	//callbackSearch();
});

//삭제버튼 클릭시
$("#delete").click(function(){
	deleteCallbackAgent();
});


$(".popup_close").click(function(){
	parent.popupClose();
});


var calllist="";

function deleteCallbackAgent(){
	if(trim($("#callbackids").text())==""){
		alert('삭제할 콜백을 선택하세요!')
		return;
	}

	calllist=trim($("#callbackids").text());


	LLYNX_Confirm("삭제하시겠습니까?", "deleteCallbacks");
}

function deleteCallbacks(){
	ECMService.deleteAPI("callbacks?callbackIds="+calllist, function(result){
		if(result.result&&result.result!="F"){
			var str1="";
			str1=" 전체 항목수 : "+result.totalCount;
			str1=str1+"\n 성공 항목수 : "+result.successCount;
			str1=str1+"\n 실패 항목수 : "+result.failureCount;

			$("#ifr_tabs-PG_CACA_01", parent.document)[0].contentWindow.callbackSearch();
			LLYNX_Alert(str1, "close");
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message), "close");
			}else{
				LLYNX_Alert("콜백 삭제 중 오류가 발생하였습니다.", "close");
			}
		}


	});
}


