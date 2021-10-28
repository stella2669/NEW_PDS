/**
 * 마이메뉴 관리 팝업
 */


// 로그인 사용자 정보
var loginInfo = _getLoginInfo();

// 프로그램 그리드
var authGrid = new webticsGrid();

// 프로그램 그리드 콜모델(테이블 헤더)
var authColModel = [
	{name: "progCd", label: "프로그램코드", hidden: true},
	{name: "progNm", label: "프로그램명", align: "center"},
	{name: "authYn", label: "권한", index : "checkbox", edittype:"checkbox" , editoptions :{value:"Y:N"}, formatter:'checkbox' }
];

var myMenuData = {
	userId: loginInfo.userId
}

var progCdList = []
$(document).ready(function(){
	// 그리드(테이블) 그리기
	authGrid.id("authGrid");
	authGrid.colModel(authColModel);
	authGrid.rowNum(1000);
	authGrid.call();

	// 초기화면 사용자 그리드 search
	authSearch();
	setAllCheck();
});

$("#save").click(function(){
	setMyMenuData();
	FRME01_Service.insertMyMenuList(myMenuData, progCdList, function(result){
		if(result.result=="S"){
			parent.myMenuReset();
			LLYNX_Alert("마이메뉴가 저장되었습니다.", "close");
		}else{
			LLYNX_Alert(result.msg);
		}
	});
})

$(".popup_close").click(function(){
	parent.popupClose();
});


function setAllCheck(){
	var allCheck = '<input type="checkbox" class="chk_type01" name="allCheckBox" id="allCheckBox" value="Y">';
	$("#jqgh_authGrid_authYn").html(allCheck);
	$("#jqgh_authGrid_authYn").removeClass("ui-jqgrid-sortable");

	$("#allCheckBox").change(function(){
		if($(this).is(":checked")==true){
			$("#authGrid").find("tbody").find("input[type=checkbox]").each(function(){
				$(this).prop("checked", true);
			});
		}else{
			$("#authGrid").find("input[type=checkbox]").each(function(){
				$(this).prop("checked", false);
			});
		}
	});
}

function authSearch(){
	if(loginInfo.userId!=""){
		FRME01_Service.getMyAuthList(function(result){
			if(result.result=="S"){
				authGrid.setGrid(result);
			}else{
				LLYNX_Alert(result.msg);
			}
		});
	}
}

function setMyMenuData(){
	progCdList.length=0;
	var rowData = $("#authGrid").getRowData();
	for (var i = 0; i < rowData.length; i++) {
		if(rowData[i].authYn == "Y"){
			progCdList.push(rowData[i].progCd);
		}
	}
}