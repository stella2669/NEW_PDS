/**
 * 역할관리
 */

// 로그인 사용자 정보
var loginInfo = _getLoginInfo();

// 선택한 사용자 USER_ID
var selectedUserId = "";

// 사용자 정보 그리드
var userGrid = new webticsGrid();

// 프로그램 그리드
var progGrid = new webticsGrid();

//  사용자 그리드 콜모델(테이블 헤더)
var userColModel = [
	{name: "groupNm", label: "그룹명", align: "center"},
	{name: "groupCd", label: "그룹코드", hidden: true},
	{name: "userNm", label: "이름", align: "center"},
	{name: "userId", label: "ID", align: "center"}
];

// 프로그램 그리드 콜모델(테이블 헤더)
var progColModel = [
	{name: "menuNm", label: "메뉴명", hidden: true},
	{name: "progNm", label: "권한명", align: "center"},
	{name: "progCd", label: "프로그램코드", hidden: true},
	{name: "authYn", label: "역할", index : "checkbox", edittype:"checkbox" , editoptions :{value:"Y:N"}, formatter:'checkbox' }
];

// 사용자 검색 시 필요한 데이터(Map<String,Object>와 같은 형태 - 파라미터값)
var userSearchData = {
	groupCd : "",
	orderBy:"groupNm",
	sortBy:"asc"
}

// 프로그램 검색 시 필요한 데이터(Map<String,Object>와 같은 형태 - 파라미터값)
var progSearchData = {
	userId : ""
}

// 저장할 데이터(Map<String,Object>와 같은 형태 - 파라미터값)
var authData = {
	authUserId:"",
	userId:loginInfo.userId
};

// 저장할 데이터 리스트가 들어갈 배열
var progCdList = [];

//grid resize
$(window).bind("resize", function() {
	$("#userGrid").setGridWidth($("#divGrid").width(), true);
	$("#progCdGrid").setGridWidth($("#divGrid2").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");


$(document).ready(function(){
	// 그리드(테이블) 그리기
	userGrid.id("userGrid");
	userGrid.colModel(userColModel);
	userGrid.rowNum(1000);
	userGrid.rownumbers(true);
	userGrid.call();

	// 그리드(테이블) 그리기
	progGrid.id("progCdGrid");
	progGrid.colModel(progColModel);
	progGrid.rowNum(1000);
	progGrid.call();

	// 초기화면 사용자 그리드 search
	userSearch();
	setAllCheck();
});

$("#orderBy").change(function(){
	userSearch();
});

$("#sortBy").change(function(){
	userSearch();
});

$("#groupCd").change(function(){
	userSearch();
});

function setAllCheck(){
	var allCheck = '<input type="checkbox" class="chk_type01" name="allCheckBox" id="allCheckBox" value="Y">';
	$("#jqgh_progCdGrid_authYn").html(allCheck);
	$("#jqgh_progCdGrid_authYn").removeClass("ui-jqgrid-sortable");

	$("#allCheckBox").change(function(){
		if($(this).is(":checked")==true){
			$("#progCdGrid").find("tbody").find("input[type=checkbox]").each(function(){
				$(this).prop("checked", true);
			});
		}else{
			$("#progCdGrid").find("input[type=checkbox]").each(function(){
				$(this).prop("checked", false);
			});
		}
	});
}

// 검색 클릭 시 이벤트
$("#search").click(function(){
	// 검색데이터 초기화
	userSearchDataReset();
	// 사용자 그리드 search
	userSearch();
	// 프로그램 그리드 초기화
	progGrid.resetGrid();
});

// 저장버튼 클릭 시 이벤트
$("#authSave").click(function(){
	// 저장할 데이터 세팅 메서드(return true 일 때 진행, return false일 때 오류 alert)
	if(setAuthData()){
		// dwr로 서비스 메서드 호출
		USAU01_Service.insertProgAuth(authData, progCdList, function(rslt){
			// 결과값이 성공일 때
			if(rslt.result=="S"){
				LLYNX_Alert("저장되었습니다.");
				// 저장 후 저장된 데이터 다시 search
				progSearch(selectedUserId);
				// 저장 데이터 초기화
				authDataReset();
			}else{
				// 실패시 alert
				LLYNX_Alert("저장에 실패하였습니다.");
			}
		});
	}
});

// 사용자 그리드 검색 메서드
function userSearch(){
	// 검색 파라미터값 세팅 및 검증(return true 일 때 진행, return false일 때 오류 alert)
	if(userValidator()){
		// 화면에 대기중 띄우기
		progressShow();
		// dwr로 서비스 메서드 호출
		USAU01_Service.getEmpList(userSearchData,function(result){
			// 대기중 없애기
			progressHide();
			// 결과값이 성공일때
			if(result.result=="S"){
				// 그리드에 데이터 세팅
				userGrid.setGrid(result);
				// 그리드 행 클릭 시 이벤트 function 이름 지정(140번째 줄)
				userGrid.setSelectRowFunc("userSelectRow");
			} else {
				// 자바에서 내려준 오류 메시지 alert
				LLYNX_Alert(result.msg);
			}
		});
	}
}

function userValidator() {
	// 상단의 그룹 셀렉트값 가져와서 검색 데이터(파라미터)에 할당(값이 false일 경우가 없음)
	userSearchData.groupCd =  $("#groupCd").val();
	userSearchData.orderBy =  $("#orderBy").val();
	userSearchData.sortBy =  $("#sortBy").val();
	return true;
}

function userSearchDataReset(){
	// 검색데이터 초기화
	userSearchData = {groupCd : "", orderBy:"groupNm", sortBy:"asc"};
}

// 그리드 행 클릭시 이벤트 (rowData에 해당 행의 데이터가 Map형식으로 들어있음)
function userSelectRow(rowData){
	// 최상단에 선택한 사용자의 empNo siteCd 넣어주기
	selectedUserId = rowData.userId; // colmodel에서의 name값과 동일
	progSearch(rowData.userId); // 선택한 행의 사용자ID(USER_ID)를 매개변수로 넘겨서 해당 사원의 프로그램 역할 리스트 검색
}

// 사용자별 프로그램 역할 리스트 가져오기
function progSearch(userId){
	if(progValidator(userId)){
		progressShow();
		USAU01_Service.getProgList(progSearchData,function(result){
			progressHide();
			if(result.result=="S"){
				progGrid.setGrid(result);
			} else {
				LLYNX_Alert(result.msg);
			}
		});
	}
}

// 프로그램 그리드 검색 데이터 세팅 및 검증
function progValidator(userId) {
	progSearchDataReset();
	progSearchData.userId = userId;

	return true;
}

// 프로그램 그리드 검색 데이터 초기화
function progSearchDataReset(){
	progSearchData = { userId : "" };
}

// 저장할(체크박스 선택 한) 역할 정보 세팅(insert할 데이터)
function setAuthData(){
	//선택된 사용자 정보가 있는지 체크
	if(selectedUserId!=""&&authData.userId!=""){

		// 선택한 사용자 정보를 insert할 파라미터 정보에 세팅
		authData.authUserId = selectedUserId;

		// 프로그램 그리드의 체크박스 선택된 값 for문으로 가져와서 리스트에 넣어주기
		var rowData = $("#progCdGrid").getRowData();
		for (var i = 0; i < rowData.length; i++) {
			if(rowData[i].authYn == "Y"){
				progCdList.push(rowData[i].progCd);
			}
		}
		// 사용자 정보 있으면 true return
		return true;

	}else if(selectedUserId==""){
		// 사용자 정보가 없을 경우 오류메시지 띄우고 false return
		LLYNX_Alert("선택된 사용자 정보가 없습니다.");
		return false;
	}else if(authData.userId==""){
		LLYNX_Alert("로그인 상담원 정보가 존재하지 않습니다.\n다시 로그인해주세요.");
		return false;
	}
}

// 저장후 저장한 데이터 초기화
function authDataReset(){
	authData = { authUserId:"", userId:loginInfo.userId };
	progCdList.length=0;
	// 프로그램 리스트 배열 초기화
}