/**
 * 역할관리
 */

var loginInfo = _getLoginInfo();

var selectedAuthCd = "";

var authCdGrid = new webticsGrid();

var authCdColModel = [
	{name: "authCd", label: "역할코드", width:30, align: "center"},
	{name: "authNm", label: "역할명", width:30, align: "center"},
	{name: "useYn", label: "사용여부", width:20, align: "center"},
	{name: "bigo", label: "비고", width:160, align: "left"}
];

var authCdSearchData = {
	schAuthNm : ""
}

var authCdData = {
	chAuthCd:"",
	authCd:"",
	authNm:"",
	useYn:"",
	note:"",
	userId:loginInfo.userId
}

//grid resize
$(window).bind("resize", function() {
	$("#authCdGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){
	authCdGrid.id("authCdGrid");
	authCdGrid.colModel(authCdColModel);
	authCdGrid.rowNum(1000);
	authCdGrid.call();

	$("#search").click();
	$("#schAuthNm").focus();
});

$("#schAuthNm").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#search").click(function(){
	authCdDataReset();
	authCdSearchDataReset();
	authCdSearch();
});


$("#authNew").click(function(){
	authCdDataReset();
	$("#authCd").focus();
});

$("#authSave").click(function(){
	if(selectedAuthCd==""){
		if(setAuthCdData()){
			LLYNX_Confirm("등록하시겠습니까?", "insertAuthCd");
		}
	}else{
		if(setAuthCdData()){
			LLYNX_Confirm("수정하시겠습니까?", "updateAuthCd");
		}
	}
});

function insertAuthCd(){
	SYAU01_Service.dupCheckAuthCd(authCdData, function(result){
		if(result.result=="S"){
			SYAU01_Service.insertAuthCd(authCdData,function(result){
				if(result.result=="S"){
					LLYNX_Alert("등록되었습니다.");
					authCdSearch();
				}else{
					alert(result.msg);
				}
				authCdDataReset();
			});
		}else{
			LLYNX_Alert("이미 존재하는 역할코드입니다.");
		}
	});
}

function updateAuthCd(){
	SYAU01_Service.updateAuthCd(authCdData,function(result){
		if(result.result=="S"){
			LLYNX_Alert("수정 되었습니다.");
			authCdSearch();
		}else{
			alert(result.msg);
		}
		authCdDataReset();
	});
}

$("#authDel").click(function(){
	if(selectedAuthCd==""){
		LLYNX_Alert("선택된 공통코드가 없습니다.");
	}else{
		if(setAuthCdData()){
			LLYNX_Confirm("삭제하시겠습니까?", "deleteAuthCd");
		}
	}
});

function deleteAuthCd(){
	SYAU01_Service.deleteAuthCd(authCdData,function(result){
		if(result.result=="S"){
			LLYNX_Alert("삭제 되었습니다.");
			authCdSearch();
		}else{
			alert(result.msg);
		}
		authCdDataReset();
	});
}


function authCdSearch(){
	if(authCdValidator()){
		progressShow();
		SYAU01_Service.getAuthCdList(authCdSearchData,function(result){
			progressHide();
			if(result.result=="S"){
				authCdGrid.setGrid(result);
				authCdGrid.setSelectRowFunc("authCdSelectRow");
			} else {
				LLYNX_Alert(result.msg);
			}
		});
	}
}

function authCdValidator() {
	authCdSearchData.schAuthNm =  $("#schAuthNm").val();
	return true;
}

function authCdSearchDataReset(){
	authCdSearchData = { schAuthNm : "" };
}

function authCdSelectRow(rowData){
	authCdDataReset();
	selectedAuthCd = rowData.authCd;
	$("#authCd").val(rowData.authCd);
	$("#authNm").val(rowData.authNm);
	$("#useYn").val(rowData.useYn);
	$("#note").val(rowData.bigo);
}


function setAuthCdData(){
	if(authCdData.userId!=""&&$("#authCd").val()!=""){
		if(selectedAuthCd!=""){
			authCdData.authCd = selectedAuthCd;
		}else{
			authCdData.authCd = $("#authCd").val();
		}
		authCdData.chAuthCd = $("#authCd").val();
		authCdData.authNm = $("#authNm").val();
		authCdData.useYn = $("#useYn").val();
		authCdData.note = $("#note").val();
		return true;
	}else if(authCdData.userId==""){
		LLYNX_Alert("로그인 사용자 정보가 존재하지 않습니다.");
		return false;
	}else if($("#authCd").val()==""){
		LLYNX_Alert("역할코드를 입력해주세요.", 'authCd');
		return false;
	}
}

function authCdDataReset(){
	authCdData = {authCd:"", chAuthCd:"", authNm:"", useYn:"", note:"", userId:loginInfo.userId};
	selectedAuthCd = "";
	$("#authCd").val("");
	$("#authNm").val("");
	$("#useYn").val("Y");
	$("#note").val("");
}
