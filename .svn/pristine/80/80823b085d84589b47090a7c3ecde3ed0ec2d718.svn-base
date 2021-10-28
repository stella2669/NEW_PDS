/*
 * 스킬관리
 */

// 로그인 사용자 정보
var loginInfo = _getLoginInfo();

// 선택한 사용자 USER_ID
var selectedUserId = "";
var selectedSkillCd1 = "";
var selectedSkillCd2 = "";

var change ="N";

var search = "";

// 좌측 그리드
var skillGrid1 = new webticsGrid();

// 우측 그리드
var skillGrid2 = new webticsGrid();

var list1 = [];

var list2 = [];

var idList1 = [];

var idList2= [];

// 좌측 그리드 콜모델(테이블 헤더)
var skill1ColModel = [
	{name: "userNm", label: "사용자명", align: "center"},
	{name: "auNm", label: "사용자 권한", align: "center"},
	{name: "authCd", label: "사용자 권한코드", hidden: true},
	{name: "userId", label: "사용자 ID", align: "center"}
];

// 우측 그리드 콜모델(테이블 헤더)
var skill2ColModel = [
	{name: "userNm", label: "사용자명", align: "center"},
	{name: "auNm", label: "사용자 권한", align: "center"},
	{name: "authCd", label: "사용자 권한코드", hidden: true},
	{name: "userId", label: "사용자 ID", align: "center"}
];

// 좌측 스킬유형, 상세스킬 검색 시 필요한 데이터(Map<String,Object>와 같은 형태)
var skillSearchData1 = {
	schSkillType1 : "",
	schSkill1 : ""
}

// 우측 스킬유형, 상세스킬 검색 시 필요한 데이터(Map<String,Object>와 같은 형태)
var skillSearchData2 = {
	schSkillType2: "",
	schSkill2: ""
}

var saveData = {
	skillCd1 : "",
	skillCd2 : "",
	userId: loginInfo.userId
}

//grid resize -tab이라서 resize해줘야함
$(window).bind("resize", function() {
	$("#skillGrid1").setGridWidth($("#divGrid1").width(), true);
	$("#skillGrid2").setGridWidth($("#divGrid2").width(), true);

	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){
	// 좌측 그리드 그리기
	skillGrid1.id("skillGrid1");
	skillGrid1.colModel(skill1ColModel);
	skillGrid1.rowNum(1000);
	skillGrid1.multiSelect(true);
	skillGrid1.call();
	
	// 우측 그리드 그리기
	skillGrid2.id("skillGrid2");
	skillGrid2.colModel(skill2ColModel);
	skillGrid2.rowNum(1000);
	skillGrid2.multiSelect(true);
	skillGrid2.call();

});

// 중복 조건 검색 시 검색 불가
$('.schSkill').change(function(){
	var skill1 = $('#schSkill1 option:selected').val();
	var skill2 = $('#schSkill2 option:selected').val();
	if(skill1 == skill2){
		LLYNX_Alert("이미 선택된 항목입니다.");
		$(this).val("");
	}
});

//다중 select box 설정
$("#schSkillType1").change(function(){
	var schSkillType = $(this).val();
	USSU01_Service.getSkillList({schSkillType:schSkillType}, function(list){
		$('#schSkill1 option').remove();
		var options = "<option value=''>--스킬선택--</option>"
		for(var i=0;i<list.length;i++){
			options += "<option value='"+list[i].skillCd+"'>"+list[i].skillNm+"</option>";
		}
		$('#schSkill1').append(options);
	});
});

$("#schSkillType2").change(function(){
	var schSkillType = $(this).val();
	USSU01_Service.getSkillList({schSkillType:schSkillType}, function(list){
		$('#schSkill2 option').remove();
		var options = "<option value=''>--스킬선택--</option>"
		for(var i=0;i<list.length;i++){
			options += "<option value='"+list[i].skillCd+"'>"+list[i].skillNm+"</option>";
		}
		$('#schSkill2').append(options);
	});
});

// 조회 시
$('#search1').click(function(){
	if(change == "Y"){
		if(confirm("저장되지 않은 변동 이력이 있습니다. 처음 상태로 돌아가시겠습니까??")){
			change="N";
			userSearch();
			LLYNX_Alert("초기화 되었습니다.");
		}else{
			return;
		}
		changeDisabled();
	}else{
		if($('#schSkillType1').val() == ""){
			LLYNX_Alert("선택된 스킬유형이 없습니다.");
			skillGrid1.setGrid(skillSearchData1);
			return;
		}
		if($('#schSkill1').val() == ""){
			LLYNX_Alert("선택된 스킬이 없습니다.");
			skillGrid1.setGrid(skillSearchData1);
			return;
		}
		skillSearchDataReset();
		search = $(this).attr("id");
		userSearch();
		search="";
	}
});

$('#search2').click(function(){
	if(change == "Y"){
		if(confirm("저장되지 않은 변동 이력이 있습니다. 처음 상태로 돌아가시겠습니까??")){
			change="N";
			userSearch();
			LLYNX_Alert("초기화 되었습니다.");
		}else{
			return;
		}
		changeDisabled();
	}else{
		if($('#schSkillType2').val() == ""){
			LLYNX_Alert("선택된 스킬유형이 없습니다.");
			skillGrid2.setGrid(skillSearchData2);
			return;
		}
		if($('#schSkill2').val() == ""){
			LLYNX_Alert("선택된 스킬이 없습니다.");
			skillGrid2.setGrid(skillSearchData2);
			return;
		}
		skillSearchDataReset();
		search = $(this).attr("id");
		userSearch();
		search="";
	}
});

//저장 시
$('#save').click(function(){
	saveDataReset();
	list1 = $('#skillGrid1').getRowData();	
	list2 = $('#skillGrid2').getRowData();
	if(setSaveData()){
		USSU01_Service.updateUserList(saveData, idList1, idList2, function(result){
			if(result.result == "S"){
				LLYNX_Alert("저장되었습니다.");
				userSearch();
				change="N";
			}else{
				LLYNX_Alert("저장에 실패하였습니다.");
			}
		});
	}
});

// 스킬 별 사용자 그리드 검색
function userSearch(){
	//조회하면서 userlist에 user저장
	if(validator()){
		progressShow();
		//arrow 버튼 누를 때
		if(search == ""){
			if(change == "Y"){
				var gridResult1 = {};
				var gridResult2 = {};
				progressHide();
				gridResult1.list = list1;
				skillGrid1.setGrid(gridResult1);
				gridResult2.list = list2;
				skillGrid2.setGrid(gridResult2);
			}else{
				if($('#schSkill1').val()== "not"){
					USSU01_Service.getNotSkillUserList(function(result){
						selectedSkillCd1 = $('#schSkill1').val();
						progressHide();
						skillGrid1.setGrid(result);
						skillGrid1.setSelectRowFunc("userSelectRow");
						changeDisabled();
					});
				}else{
					USSU01_Service.getUserList1(skillSearchData1, function(result){
						selectedSkillCd1 = skillSearchData1.schSkill1;
						progressHide();
						skillGrid1.setGrid(result);
						skillGrid1.setSelectRowFunc("userSelectRow");
						changeDisabled();
					});
				}
				if($('#schSkill2').val() == "not"){
					USSU01_Service.getNotSkillUserList(function(result){
						selectedSkillCd2 = $('#schSkill2').val();
						progressHide();
						skillGrid2.setGrid(result);
						skillGrid2.setSelectRowFunc("userSelectRow");
						changeDisabled();
					});
				}else{
					USSU01_Service.getUserList2(skillSearchData2, function(result){
						selectedSkillCd2 = skillSearchData2.schSkill2;
						progressHide();
						skillGrid2.setGrid(result);
						skillGrid2.setSelectRowFunc("userSelectRow");
						changeDisabled();
					});
				}
			}	
		}else if(search == "search1"){
			if($('#schSkill1').val()== "not"){
				USSU01_Service.getNotSkillUserList(function(result){
					selectedSkillCd1 = $('#schSkill1').val();
					progressHide();
					skillGrid1.setGrid(result);
					skillGrid1.setSelectRowFunc("userSelectRow");
					changeDisabled();
				});
			}else{
				USSU01_Service.getUserList1(skillSearchData1, function(result){
					selectedSkillCd1 = skillSearchData1.schSkill1;
					progressHide();
					skillGrid1.setGrid(result);
					skillGrid1.setSelectRowFunc("userSelectRow");
					changeDisabled();
				});
			}
		}else if(search == "search2"){
			if($('#schSkill2').val() == "not"){
				USSU01_Service.getNotSkillUserList(function(result){
					selectedSkillCd2 = $('#schSkill2').val();
					progressHide();
					skillGrid2.setGrid(result);
					skillGrid2.setSelectRowFunc("userSelectRow");
					changeDisabled();
				});
			}else{
				USSU01_Service.getUserList2(skillSearchData2, function(result){
					selectedSkillCd2 = skillSearchData2.schSkill2;
					progressHide();
					skillGrid2.setGrid(result);
					skillGrid2.setSelectRowFunc("userSelectRow");
					changeDisabled();
				});
			}
		}

	}else{
		LLYNX_Alert(result.msg);
	}
}

function changeDisabled(){
	if(selectedSkillCd1 != "" && selectedSkillCd2 != ""){
		$('.arrow').attr("disabled", false);
		return;
	}
}

// 검색한 데이터 searchData안에 넣어주기
function validator(){
	skillSearchDataReset();
	
	skillSearchData1.schSkillType1 = $("#schSkillType1").val();
	skillSearchData1.schSkill1 = $("#schSkill1").val();
	
	skillSearchData2.schSkillType2 = $("#schSkillType2").val();
	skillSearchData2.schSkill2 = $("#schSkill2").val();

	return true;
}

// 검색데이터 초기화
function skillSearchDataReset(){
	skillSearchData1 = {
		schSkillType1 : "",
		schSkill1 : ""
	}
	
	skillSearchData2 = {
		schSkillType2: "",
		schSkill2: ""
	}
}

function saveDataReset(){
	saveData = {
		skillCd1 : "",
		skillCd2 : "",
		userId: loginInfo.userId
	}
	idList1.length = 0;
	idList2.length = 0;
}

function setSaveData(){
	if(selectedSkillCd1 != "" && selectedSkillCd2 != ""){
		saveData.skillCd1 = selectedSkillCd1;
		saveData.skillCd2 = selectedSkillCd2;
		
		if(saveData.skillCd1 != "not"){
			for(var i = 0; i < list1.length; i++){
				idList1.push(list1[i].userId);
			}
		}
		
		if(saveData.skillCd2 != "not"){
			for(var i = 0; i< list2.length; i++){
				idList2.push(list2[i].userId);
			}
		}

		return true;
	}else if(selectedSkillCd1 =="" || selectedSkillCd2 == ""){
		LLYNX_Alert("선택된 스킬 정보가 없습니다.");
		return false;
	}
}

function listReset(){
	list1.length = 0;
	list2.length = 0;
}

// 2 -> 1 전체 이동
function allLeft(){
	listReset();
	
	list1 = $('#skillGrid1').getRowData();	
	list2 = $('#skillGrid2').getRowData();
	selId1 = $('#skillGrid1').getGridParam('selarrrow');
	
	if(list2.length == 0 || selId1.length != 0){
		LLYNX_Alert("이동이 불가합니다. 다시 선택해주세요.");
		return;
	}
	for(var i = 0; i < list2.length; i++){
		list1.push(list2[i]);
	}
	list2 = [];
	change="Y";
	userSearch();
}

// 2 -> 1 선택 이동
function goLeft(){
	listReset();
	
	//기존 스킬에 들어있는 userList
	list1 = $('#skillGrid1').getRowData();
	selId1 = $('#skillGrid1').getGridParam('selarrrow');
	selId2 = $('#skillGrid2').getGridParam('selarrrow');
	
	if(selId1.length != 0){
		LLYNX_Alert("이동이 불가합니다. 다시 선택해주세요.");
		return;
	}
	if(selId1.length == 0 && selId2.length == 0){
		LLYNX_Alert("선택된 사용자가 없습니다. 다시 선택해주세요.");
		return;
	}

	//grid2에서 선택된 id가 들어있는 배열
	selId2 = $('#skillGrid2').getGridParam('selarrrow');
	
	// id배열의 길이
	var rows = selId2.length;
	
	for(var i = 0; i < rows; i++){
		//선택된 id값을 통해 data를 배열 형식으로 가져오기
		var rowObject = $('#skillGrid2').getRowData(selId2[i]);
		
		// list1에 해당 data 넣기
		list1.push(rowObject);	
	}
	for(var i = rows - 1; i >= 0; i--){
		$('#skillGrid2').delRowData(selId2[i]);
	}
	list2 = $('#skillGrid2').getRowData();
	change="Y";
	userSearch();
}

//1 -> 2 선택 이동
function goRight(){
	listReset();
	list2 = $('#skillGrid2').getRowData();
	selId1 = $('#skillGrid1').getGridParam('selarrrow');
	selId2 = $('#skillGrid2').getGridParam('selarrrow');
	
	if(selId2.length !=""){
		LLYNX_Alert("이동이 불가합니다. 다시 선택해주세요.");
		return;
	}
	if(selId1.length == 0 && selId2.length == 0){
		LLYNX_Alert("선택된 사용자가 없습니다. 다시 선택해주세요.");
		return;
	}
	var rows = selId1.length;
	
	for(var i = 0; i < rows; i++){
		var rowObject = $('#skillGrid1').jqGrid('getRowData',selId1[i]);
		list2.push(rowObject);
	}
	for(var i = rows - 1; i >= 0; i--){
		$('#skillGrid1').delRowData(selId1[i]);
	}
	list1 = $('#skillGrid1').getRowData();
	change="Y";
	userSearch();
}

//1 -> 2 전체 이동
function allRight(){
	listReset();
	
	list1 = $('#skillGrid1').getRowData();
	list2 = $('#skillGrid2').getRowData();
	selId2 = $('#skillGrid2').getGridParam('selarrrow');

	if(list1.length == 0 || selId2.length != 0){
		LLYNX_Alert("이동이 불가합니다. 다시 선택해주세요.");
		userSearch();
		return;
	}
	for(var i = 0; i < list1.length; i++){
		list2.push(list1[i]);
	}
	list1 = [];
	change="Y";
	userSearch();
}

function userSelectRow(rowData){
	selectedUserId = rowData.userId;
}

