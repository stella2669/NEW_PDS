/**
 * 컨택 업로드
 */
var loginInfo = _getLoginInfo();

var selectedAttrListId = "";

$(document).ready(function(){
	if(selectedContactListId!=""){
		CUCO01_Service.getContactList({contactSeq:selectedContactListId}, function(result){
			if(result.result=="S"){
				$("#contactNm").text(result.list[0].contactNm);
				selectedAttrListId = result.list[0].attrListSeq;
			}else{
				LLYNX_Alert(result.msg, 'close');
			}
		});
	}else{
		LLYNX_Alert("선택된 캠페인 정보가 없습니다.\n다시 시도해주세요.", 'function', 'thisPopupClose')
	}
	$("#uploadForm [name=addURL]").val("contactlists/"+selectedContactListId+"/file");


});

//연결 특성 확인
$("#linkedAttr").click(function(){
	popupOpen("/cu/cuco05.do?contactListId="+selectedContactListId+"&attrListId="+selectedAttrListId);
});

//파일업로드
$("#upload").click(function(){
	LLYNX_Confirm("업로드하시겠습니까?", "uploadContactFile");
});

function uploadContactFile(){
	var uploadForm = $("#uploadForm")[0]
	var formData = new FormData(uploadForm);
	//console.log(formData);
//	ECMService.getAccessToken(function(result){
//		var token = result;
//		progressShow();
//		$.ajax({
//			url : 'http://10.0.6.104:9000/api/v1/contactlists/'+selectedContactListId+'/file',
//		    type : 'POST',
//		    data : formData,
//			enctype:'multipart/form-data',
//		    contentType : false,
//		    processData : false,
//			cache:false,
//			dataType:"JSON",
//			beforeSend : function(xhr){
//	            xhr.setRequestHeader("Authorization", token);
//	        },
//			success : function(result){
//				//console.log(result);
//				LLYNX_Alert("파일이 업로드되었습니다.(작업에 시간이 소요될 수 있습니다.)", "close");
//				progressHide();
//			},
//			error : function(err){
//				LLYNX_Alert("파일 업로드중 오류가 발생하였습니다.");
//				console.log(err);
//				progressHide();
//			}
//		});
//	});
}

$(".popup_close").click(function(){
	parent.popupClose();
});

// 메인화면 팝업 오픈
function popupOpen(url) {
	$("#popupDiv").show();
	$("#popupDiv").html('<iframe id="layerPopup" src="'+url+'" onload="addDiv2();"></iframe>');
}

function addDiv2() {
	$("#layerPopup").contents().find(".popup_window").wrap("<div class='popup_align'></div>");
}

// 메인화면 팝업 종료
function popupClose() {
	$("#popupDiv").html("");
	$("#popupDiv").hide();
}
