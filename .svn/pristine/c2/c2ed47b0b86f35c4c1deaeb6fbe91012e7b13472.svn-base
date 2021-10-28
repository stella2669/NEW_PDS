// 로그인 사용자 정보
var loginInfo = _getLoginInfo();

var selectedProgCd = "";

var progCdGrid = new webticsGrid();

var progCdColModel = [
	{name: "menuCd", label: "메뉴코드", hidden: true},
	{name: "menuNm", label: "메뉴명", align: "center"},
	{name: "progCd", label: "프로그램코드", align: "center"},
	{name: "progNm", label: "프로그램코드명", align: "center"},

	{name: "useYn", label: "사용여부", align: "center"},
	{name: "callUrl", label: "URL", align: "center"},
	{name: "sort", label: "순서", hidden: true}
];

var progCdSearchData = {
	schProgNm : "",
	schUseYn : "",
	schMenuCd: ""
}

var progCdData = {
	chProgCd:"",
	progCd:"",
	progNm:"",
	menuCd:"",
	useYn:"",
	callUrl:"",
	sort:"",
	userId:loginInfo.userId
}

//grid resize
$(window).bind("resize", function() {
	$("#progCdGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){
	progCdGrid.id("progCdGrid");
	progCdGrid.colModel(progCdColModel);
	progCdGrid.rowNum(1000);
	progCdGrid.call();

	$("#search").click();
	$("#schProgNm").focus();
});

$("#search").click(function(){
	progCdDataReset();
	progCdSearchDataReset();
	progCdSearch();
});

$("#schProgNm").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#schMenuCd").change(function(){
	progCdSearch();
});

$("#progNew").click(function(){
	progCdDataReset();
	$("#progCd").focus();
});



$("#progSave").click(function(){
	if(selectedProgCd==""){
		if(setProgCdData()){
			LLYNX_Confirm("등록하시겠습니까?", "insertProgram");
		}
	}else{
		if(setProgCdData()){
			LLYNX_Confirm("수정하시겠습니까?", "updateProgram");
		}
	}
});

function insertProgram(){
	SYPG01_Service.dupCheckProgCd(progCdData, function(result){
		if(result.result=="S"){
			SYPG01_Service.insertProgCd(progCdData,function(rslt){
				if(rslt.result=="S"){
					LLYNX_Alert("등록되었습니다.");
					progCdSearch();
				}else{
					alert(rslt.msg);
				}
				progCdDataReset();
			});
		}else{
			LLYNX_Alert("이미 존재하는 프로그램코드입니다.");
		}
	});
}

function updateProgram(){
	SYPG01_Service.updateProgCd(progCdData,function(rslt){
		if(rslt.result=="S"){
			LLYNX_Alert("수정 되었습니다.");
			progCdSearch();
		}else{
			alert(rslt.msg);
		}
		progCdDataReset();
	});
}

$("#progDel").click(function(){
	if(selectedProgCd==""){
		LLYNX_Alert("선택된 공통코드가 없습니다.");
	}else{
		if(setProgCdData()){
			LLYNX_Confirm("삭제하시겠습니까?", "deleteProgram");
		}
	}
});

function deleteProgram(){
	SYPG01_Service.deleteProgCd(progCdData,function(rslt){
		if(rslt.result=="S"){
			LLYNX_Alert("삭제 되었습니다.");
			progCdSearch();
		}else{
			alert(rslt.msg);
		}
		progCdDataReset();
	});
}

function progCdSearch(){
	if(progCdValidator()){
		progressShow();
		SYPG01_Service.getProgCdList(progCdSearchData,function(result){
			progressHide();
			if(result.result=="S"){
				progCdGrid.setGrid(result);
				progCdGrid.setSelectRowFunc("progCdSelectRow");
			} else {
				LLYNX_Alert(result.msg);
			}
		});
	}
}

function progCdValidator() {
	progCdSearchData.schProgNm =  $("#schProgNm").val();
	progCdSearchData.schMenuCd =  $("#schMenuCd").val();
	progCdSearchData.schUseYn =  $("#schUseYn").val();
	return true;
}

function progCdSearchDataReset(){
	progCdSearchData = {
		schProgNm : "",
		schUseYn : "",
		schMenuCd: ""
	};
}

function progCdSelectRow(rowData){
	progCdDataReset();
	selectedProgCd = rowData.progCd;
	$("#progCd").val(rowData.progCd);
	$("#progNm").val(rowData.progNm);
	$("#menuCd").val(rowData.menuCd);
	$("#useYn").val(rowData.useYn);
	$("#sort").val(rowData.sort);
	$("#callUrl").val(rowData.callUrl);
}


function setProgCdData(){
	if(progCdData.userId!=""&&$("#progCd").val()!=""
		&&$("#menuCd").val()!=""){
		//console.log(selectedProgCd);
		if(selectedProgCd!=""){
			progCdData.progCd = selectedProgCd;
		}else{
			progCdData.progCd = $("#progCd").val();
		}

		progCdData.chProgCd = $("#progCd").val();
		progCdData.progNm = $("#progNm").val();
		progCdData.menuCd = $("#menuCd").val();
		progCdData.useYn = $("#useYn").val();
		progCdData.callUrl = $("#callUrl").val();
		progCdData.sort = $("#sort").val();
		return true;
	}else if(progCdData.userId==""){
		LLYNX_Alert("로그인 사용자 정보가 존재하지 않습니다.");
		return false;
	}else if($("#progCd").val()==""){
		LLYNX_Alert("프로그램코드를 입력해주세요.", 'progCd');
		return false;
	}else if($("#menuCd").val()==""){
		LLYNX_Alert("메뉴코드를 선택해주세요.");
		return false;
	}
}

function progCdDataReset(){
	progCdData = {progCd:"", chProgCd:"", progNm:"", menuCd:"", useYn:"", callUrl:"", sort:"", userId:loginInfo.userId};
	selectedProgCd = "";
	$("#progCd").val("");
	$("#progNm").val("");
	$("#menuCd").val("");
	$("#useYn").val("Y");
	$("#sort").val("");
	$("#callUrl").val("");
}

