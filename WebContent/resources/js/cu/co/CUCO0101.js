/**
 * 데이터관리 - 컨택리스트
 */
var loginInfo = _getLoginInfo();

var contactData = {
	contactSeq: "",
	contactNm: "",
	attrListCd: "",
	bigo: "",
	isUse : "",
	jobState: "",
	userId: loginInfo.userId
}

$(document).ready(function(){
	// 상세정보 버튼 클릭 시
	if(selectedContactListId != ""){
		CUCO01_Service.getContactList({contactSeq:selectedContactListId}, function(result){
			if(result.result == "S"){
				$('#contactNm').val(result.list[0].contactNm);
				$('#attrListCd').val(result.list[0].attrListSeq);
				$('#bigo').val(result.list[0].bigo);
			}else{
				LLYNX_Alert(result.msg);
			}
		});
	}
});

$("#save").click(function(){
	if(setContactData()){
		if(selectedContactListId==""){
			LLYNX_Confirm("등록하시겠습니까?", "insertContactList");
		}else{
			LLYNX_Confirm("수정하시겠습니까?", "updateContactList");
		}
	}
});

$(".popup_close").click(function(){
	parent.popupClose();
});

function insertContactList(){
	CUCO01_Service.insertContactlist(contactData, function(result) {
		if (result.result == "S") {
			$("#ifr_tabs-PG_CUCO_01", parent.document)[0].contentWindow.contactListSearch();
			resetContactData();
			LLYNX_Alert("등록되었습니다.", "close");
		} else {
			LLYNX_Alert(result.msg);
		}
	});
}

function updateContactList(){
	CUCO01_Service.updateContactList(contactData, function(result){
		if(result.result == "S"){
			$("#ifr_tabs-PG_CUCO_01", parent.document)[0].contentWindow.contactListSearch();
			resetContactData();
			LLYNX_Alert("수정되었습니다.", "close");
		} else {
			LLYNX_Alert(result.msg);
		}
	});
}

function setContactData(){
	if($("#contactNm").val()==""){
		LLYNX_Alert("컨택리스트명을 입력해주세요", "focus", "contactNm");
		return false;
	}else{
		contactData.contactSeq = selectedContactListId;
		contactData.contactNm = $("#contactNm").val();
		contactData.attrListCd = $("#attrListCd").val();
		contactData.bigo = $("#bigo").val();
		contactData.isUse = 'Y';
		contactData.jobState = '1000';
		console.log(contactData);
		return true;
	}
}

function resetContactData(){
	contactData = {
		contactSeq: "",
		contactNm: "",
		attrListCd: "",
		bigo: "",
		isUse : "",
		jobState: "",
		userId: loginInfo.userId
	}
}