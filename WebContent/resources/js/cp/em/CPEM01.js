/**
 * 권한관리
 */

var loginInfo = _getLoginInfo();

var selectedCampId = "";

var campGrid = new webticsGrid();

var campColModel = [
	{label: "번호", name: "rnIdx", width:10, align: "center"},
	{label: "캠페인ID", name: "campId", hidden:true},
	{label: "캠페인명", name: "campNm", width:80, align: "left"},
	{label: "템플릿ID", name: "tempId", hidden:true},
	{label: "템플릿명", name: "tempNm", width:50, align: "center"},
	{label: "캠페인시작일", name: "startDate", width:50, align: "center"},
	{label: "캠페인종료일", name: "endDate", width:50, align: "center"},
	{label: "총 건수", name:"totCnt", width:20, formatter:addCommaStr, align:"right"},
	{label: "진행 건수", name:"proCnt", width:20, formatter:addCommaStr, align:"right"},
	{label: "캠페인상태", name: "runningState", hidden:true},
	{label: "캠페인상태", name: "runningStateNm", width:30, align: "center"},
	{label: "비고", name: "bigo", hidden:true},
	{label: "데이터ID", name: "dataId", hidden:true},
	{label: "데이터보관주기", name: "storageCycle", hidden:true}
];

var campSearchData = {
	schStrtDate : "",
	schEndDate : "",
	schCampNm : "",
	schCampTemp:"",
	pageSize:15
}

var campData = {
	campId:"",
	runningState:"",
	userId:loginInfo.userId
}

//grid resize
$(window).bind("resize", function() {
	$("#campGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){
	$('#schStrtDate').datepicker({dateFormat: 'yy-mm-dd'});
	$('#schEndDate').datepicker({dateFormat: 'yy-mm-dd'});
	$('#schStrtDate').datepicker('setDate', new Date());
	$('#schEndDate').datepicker('setDate', new Date());

	campGrid.id("campGrid");
	campGrid.colModel(campColModel);
	campGrid.rowNum(campSearchData.pageSize);
	campGrid.call();

	$("#search").click();
	$("#schCampNm").focus();
});

$("#schCampNm").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#search").click(function(){
	campDataReset();
	setFirstSrch_campGrid();
	campSearch();
});

$("#save").click(function(){
	if(setCampData()){
		CPEM01_Service.campStateUpdate(campData, function(result){
			if(result.result=="S"){
				LLYNX_Alert("캠페인 상태가 변경되었습니다.");
				campDataReset();
				campSearch();
			}else{
				LLYNX_Alert(result.msg);
			}
		});
	}
});

function campSearch(){
	if(campValidator()){
		progressShow();
		CPCM01_Service.getCampList(campSearchData,function(result){
			progressHide();
			if(result.result=="S"){
				campGrid.setGrid(result);
				campGrid.setSelectRowFunc("campSelectRow");
			} else {
				LLYNX_Alert(result.msg);
			}
		});
	}
}

function campValidator() {
	if(firstYn_campGrid){
		campSearchDataReset();
		campSearchData.schStrtDate =  removeHyphen($("#schStrtDate").val());
		campSearchData.schEndDate =  removeHyphen($("#schEndDate").val());
		campSearchData.schCampNm =  $("#schCampNm").val();
		campSearchData.schCampTemp =  $("#schCampTemp").val();
	}
	campSearchData = getPageInfo_campGrid(campSearchData);
	return true;
}

function campSearchDataReset(){
	campSearchData = { schStrtDate : "", schEndDate : "", schCampNm : "", schCampTemp:"", pageSize:15 };
}

function campSelectRow(rowData){
	campDataReset();
	selectedCampId = rowData.campId;
	$("#campPeriod").text(rowData.startDate+" ~ "+rowData.endDate);
	$("#campNm").text(rowData.campNm);
	$("#totCnt").text(rowData.totCnt);
	$("#proCnt").text(rowData.proCnt);
	$("#runningState").val(rowData.runningState);
}

function setCampData(){

	if(selectedCampId==""){
		LLYNX_Alert("선택된 캠페인이 없습니다.");
		return false;
	}

	if($("#runningState").val()==""){
		LLYNX_Alert("캠페인 실행상태를 선택해주세요.", 'runningState');
		return false;
	}

	campData.campId = selectedCampId;
	campData.runningState = $("#runningState").val();

	return true;
}

function campDataReset(){
	selectedCampId="";
	$("#campPeriod").val("");
	$("#campNm").text("");
	$("#totCnt").text("");
	$("#proCnt").text("");
	$("#runningState").val("");
}

