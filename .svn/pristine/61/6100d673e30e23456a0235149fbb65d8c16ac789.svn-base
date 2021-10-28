/**
 * 사용자관리
 */

// 로그인 사용자 정보
var loginInfo = _getLoginInfo();

var selectedUserId = "";

var userGrid = new webticsGrid();

var userColModel = [
	{name: "grNm", label: "사용자그룹", align: "center"},
	{name: "auNm", label: "역할", align: "center"},
	{name: "raNm", label: "직급", align: "center"},
	{name: "userId", label: "사용자 ID", align: "center"},
	{name: "userNm", label: "사용자명", align: "center"},
	{name: "userMail", label: "메일주소", align: "center"},
	{name: "stNm", label: "근무상태", align: "center"},
	{name: "groupCd", label: "그룹코드", hidden: true},
	{name: "stCd", label: "근무상태", hidden: true},
	{name: "authCd", label: "역할코드", hidden: true},
	{name: "rankCd", label: "직급코드", hidden: true},

];

var userSearchData = {
	schBy:"",
	schValue:"",
	orderBy:"userId",
	sortBy:"asc"
}


var saveDataObject = {};

//grid resize
$(window).bind("resize", function() {
	$("#userGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){
	userGrid.id("userGrid");
	userGrid.colModel(userColModel);
	userGrid.rowNum(1000);
	userGrid.rownumbers(true);
	userGrid.call();

	userSearch();
	$("#srchUserId").focus();
});

$("#search").click(function(){
	clearSearchData();
	userSearch();
});


//srchUserId 입력 후 엔터
$("#srchUserId").keyup(function(e){

	if(e.keyCode==13){
		$("#search").click();
	}
});

//사용자명 입력 후 엔터
$("#srchUserId").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});
//사용자명 입력 후 엔터
$("#srchUserNm").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#schBy").change(function(){
	var thisVal = $("#schBy").val();
	if(thisVal=="userId"){
		$("#srchUserId").show();
		$("#srchUserNm").hide();
		$("#srchAuthCd").hide();
		$("#srchRankCd").hide();
	}else if(thisVal=="userNm"){
		$("#srchUserId").hide();
		$("#srchUserNm").show();
		$("#srchAuthCd").hide();
		$("#srchRankCd").hide();
	}else if(thisVal=="authCd"){
		$("#srchUserId").hide();
		$("#srchUserNm").hide();
		$("#srchAuthCd").show();
		$("#srchRankCd").hide();
	}else if(thisVal=="rankCd"){
		$("#srchUserId").hide();
		$("#srchUserNm").hide();
		$("#srchAuthCd").hide();
		$("#srchRankCd").show();
	}
});

$('#orderBy').change(function(){
	userSearch();
});

$('#sortBy').change(function(){
	userSearch();
});


//신규버튼 클릭시
function initDetail(){
	clearDetail();
	$('#userId').focus();
}

//삭제 버튼 클릭시
function deleteDetail(){
	if(selectedUserId!=""){
		LLYNX_Confirm("삭제하시겠습니까?", "deleteUser");
	}else{
		LLYNX_Alert("삭제할 사용자를 선택하세요.")
	}
}

function deleteUser(){
	saveDataObject = {};
	saveDataObject.userId=selectedUserId;
	progressShow();
	USUM01_Service.deleteAgt01(saveDataObject,function(result){
		progressHide();
		if(result.result=="S"){
			LLYNX_Alert("사용자 정보가 삭제되었습니다.");
			userSearch();
		}else{
			LLYNX_Alert(result.msg);
		}

	});
}

//비밀번호 초기화 버튼 클릭시
function initPswd(){
	if(selectedUserId==""){
		LLYNX_Alert("비밀번호 변경할 사용자 정보를 선택 하세요.");
		return false;
	}

	saveDataObject = {};
	saveDataObject.userId=$('#userId').val();
	saveDataObject.password=getCrypto("1234567890", 9);
	saveDataObject.resetYn='Y';
	saveDataObject.uptUserId=loginInfo.userId;	//등록자 사버
	LLYNX_Confirm("비밀번호를 초기화하시겠습니까?", "initUsersPassword");
}

function initUsersPassword(){
	progressShow();
	USUM01_Service.changePawd(saveDataObject,function(result){
		progressHide();
		if(result.result=="S"){
			LLYNX_Alert("비밀번호가 초기화되었습니다.");
		}else{
			LLYNX_Alert(result.msg);
		}
	});
}


//상세 정보 초기화
function clearDetail(){
	selectedUserId="";
	$('#userId').val("");
	$('#userNm').val("");
	$('#groupCd').val("");
	$('#auCd').val("");
	$('#raCd').val("");
	$('#stCd').val("");
	$('#userMail').val("");
	$('#userId').attr("readonly",false);
}

function clearSearchData(){
	userSearchData = { schBy:"", schValue:"", orderBy:"userId", sortBy:"asc" };
}

//저장버튼 클릭시
function saveDetail(){

	if ($('#userId').val() == ""){
		LLYNX_Alert("사용자 ID를 입력해주세요.", 'userId');
		return false;
	}

	if ($('#userNm').val() == ""){
		LLYNX_Alert("사용자명을 입력해주세요.", 'userNm');
		return false;
	}

	if ($('#auCd').val() == ""){
		LLYNX_Alert("역할코드를 선택해주세요.", 'auCd');
		return false;
	}
	saveDataObject = {};
	saveDataObject.userId=$('#userId').val();
	saveDataObject.userNm=$('#userNm').val();
	saveDataObject.groupCd=$('#groupCd').val();
	saveDataObject.password=getCrypto("1234567890", 9); //초기 비밀번호
	saveDataObject.authCd=$('#auCd').val();
	saveDataObject.rankCd=$('#raCd').val();
	saveDataObject.stCd=$('#stCd').val();
	saveDataObject.userMail=$('#userMail').val();
	saveDataObject.crtUserId=loginInfo.userId;	//등록자 사버

	if(selectedUserId==""){
		//신규 등록
		LLYNX_Confirm("등록하시겠습니까?", "inserUser");
	}else{
		//정보 변경
		LLYNX_Confirm("수정하시겠습니까?", "updateUser");
	}
}

function inserUser(){
	saveDataObject.resetYn='Y';
	progressShow();
	USUM01_Service.dupCheckUser(saveDataObject, function(result){
		progressHide();
		if(result.result=="S"){
			USUM01_Service.insertAgt01(saveDataObject,function(result){
				if(result.result=="S"){
					LLYNX_Alert("등록되었습니다.");
					userSearch()();
				}else{
					LLYNX_Alert(result.msg);
				}
			});
		}else{
			LLYNX_Alert("이미 존재하는 사용자ID입니다.");
		}
	});
}

function updateUser(){
	delete saveDataObject.resetYn;
	progressShow();
	USUM01_Service.updateAgt01(saveDataObject,function(result){
		progressHide();
		if(result.result=="S"){
			LLYNX_Alert("수정되었습니다.");
			userSearch()();
		}else{
			LLYNX_Alert(result.msg);
		}
	});
}

function userSearch(){
	clearDetail();

	userSearchData.schBy=$('#schBy').val();
	if(userSearchData.schBy=="userId"){
		userSearchData.schValue = $("#srchUserId").val();
	}else if(userSearchData.schBy=="userNm"){
		userSearchData.schValue = $("#srchUserNm").val();
	}else if(userSearchData.schBy=="authCd"){
		userSearchData.schValue = $("#srchAuthCd").val();
	}else if(userSearchData.schBy=="rankCd"){
		userSearchData.schValue = $("#srchRankCd").val();
	}
	userSearchData.orderBy=$('#orderBy').val();
	userSearchData.sortBy=$('#sortBy').val();

	progressShow();
	USUM01_Service.getAgtList(userSearchData,function(jsonData){
		progressHide();

		if(jsonData.result=="S"){
			userGrid.setGrid(jsonData);
			userGrid.setSelectRowFunc("userSelectRow");
			//alert(JSON.stringify(jsonData));
		} else {
			LLYNX_Alert(jsonData.msg);
		}
	});

}



function userSelectRow(rowData){
	clearDetail();
	selectedUserId=rowData.userId;
	$('#userId').val(rowData.userId);
	$('#userId').attr("readonly",true);
	$('#userNm').val(rowData.userNm);
	$('#groupCd').val(rowData.groupCd);
	$('#auCd').val(rowData.authCd);
	$('#raCd').val(rowData.rankCd);
	$('#stCd').val(rowData.stCd);
	$('#userMail').val(rowData.userMail);
}
