/**
 * 콜백 시간연장
 */
var loginInfo = _getLoginInfo();

$(document).ready(function(){
	callbackSearch();
	//alert(date_to_str("2021-04-26T13:54:00"));
});

//연장버튼 클릭시
$("#save").click(function(){
	nextTimeSave();
});


$(".popup_close").click(function(){
	parent.popupClose();
});


var nextData = {
	callbackid:"",
	endTime:"",
	timeZone:"GMT+09:00"
}

function nextTimeSave(){
	if(trim($("#callbackid").text())==""){
		alert('변경할 콜백을 선택하세요!')
		return;
	}

	if($("#nextDate").val()==''){
		alert('변경할 일자를 선택하세요!');
		return;
	}

	if($("#nextTime").val()==''){
		alert('변경할 시간대를 선택하세요!');
		return;
	}
	if(confirm('연장하시겠습니까?')){
		//alert($("#nextTime").val());
		nextData.callbackid=trim($("#callbackid").text());
		nextData.endTime=$("#nextDate").val().replaceAll("-","/")+" "+$("#nextTime").val()+":00";
		//alert(JSON.stringify({nextData}));
		//var att
		ECMService.insertAPI("callbacks/"+nextData.callbackid+"/extend", JSON.stringify(nextData), function(result){
			//console.log(result);
			if(result.result=="S"){
				LLYNX_Alert('연장 되었습니다!');
				//strgSearch();
				$("#ifr_tabs-PG_CACA_01", parent.document)[0].contentWindow.callbackSearch();
			}else{
				if(result.code!=null){
					LLYNX_Alert(ECMError(result.code, result.message));
				}else{
					LLYNX_Alert(result.msg);
				}
			}
		});
	}
}

function callbackSearch(){
	//$("#callbackid").val();
	if(trim($("#callbackid").text())==""){
		return;
	}


	ECMService.getAPI("callbacks/"+trim($("#callbackid").text()), function(result){
		//
		if(result.result=="S"){
			$("#endTime_c").text(date_to_str(result.endTime));

		}
		//console.log("========="+result);
	});
}


