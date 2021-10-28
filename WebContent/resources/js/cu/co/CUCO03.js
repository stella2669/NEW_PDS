/**
 * 캠페인 실행관리
 */

var loginInfo = _getLoginInfo();

$(document).ready(function(){
	if(selectedContactListId!=""){
		ECMService.getAPI("contactlists/"+selectedContactListId,function(result){
			if(result.result=="S"){
				$("#contactNm").text(result.name);
			}else{
				LLYNX_Alert(result.msg, 'close');
			}
		});
	}else{
		LLYNX_Alert("선택된 캠페인 정보가 없습니다.\n다시 시도해주세요.", 'function', 'thisPopupClose')
	}
});

$("#save").click(function(){
	LLYNX_Confirm("변경하시겠습니까?", "changeStatusContact");
});

function changeStatusContact(){
	ECMService.insertAPI("contactlists/"+selectedContactListId+"/status", JSON.stringify({status:$("#contactStatus").val()}), function(result){
		if(result.result&&result.result!="F"){
			$("#ifr_tabs-PG_CUCO_01", parent.document)[0].contentWindow.contactListSearch();
			LLYNX_Alert("변경되었습니다.", "close");
		}else{
			if(result.code!=null){
				if(result.code=="113"){
					LLYNX_Alert("상태를 변경할 컨택이 존재하지 않습니다.");
				}else{
					LLYNX_Alert(ECMError(result.code, result.message));
				}
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

$(".popup_close").click(function(){
	parent.popupClose();
});