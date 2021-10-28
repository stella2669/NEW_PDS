/**
 * 권한관리
 */

var loginInfo = _getLoginInfo();

var selectedCampId = "";

var isCycle = false;
var selectedSchCycle="";
var updateData;

var campGrid = new webticsGrid();

var campColModel = [
	{label: "캠페인ID", name: "id", width:10, align: "center", key:true},
	{label: "캠페인명", name: "name", width:80, align: "left"},
	{label: "전략이름", name:"strategyName", width:40, align: "center"},
	{label: "캠페인 유형", name: "campaignType", formatter:setType01, width:25, align: "center"},
	{label: "상태", name: "jobStatus", hidden:true},
	{label: "상태", name: "jobStatus", formatter:statusFormat, width:25, align: "center"},
	{label: "상태변경", name: "id", width:25, formatter:setStateSelect, align: "center"},
	{label: "컨택목록", name: "contactlists", formatter:setContactListFormat, width:50, align: "center"},
	{label: "상세", name: "id", width:30, formatter:setButtons1, align: "center"},
	{label: "복제", name: "id", width:35, formatter:setButtons2, align: "center"},
	{label: "작업매개변수", name: "id", width:40, formatter:setButtons3, align: "center"},
];

var campSearchData = {
	currentPage : 1,
	pageSize : 15,
	sort : "id",
	order:"",
	searchBy : "",
	searchValue : ""
}

//grid resize
$(window).bind("resize", function() {
	$("#campGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){
	campGrid.id("campGrid");
	campGrid.colModel(campColModel);
	campGrid.rowNum(campSearchData.pageSize);
	campGrid.call();

	//campSearch();
	$("#schKeyword").focus();
});

$("#schKeyword").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#schSort").change(function(){
	campSearchData.sort = $(this).val();
	campSearchData.order = $("#schOrder").val();
	campSearch();
});

$("#schOrder").change(function(){
	campSearchData.order =  $(this).val();
	campSearchData.sort =  $("#schSort").val();
	campSearch();
});

$("#schCycle").change(function(){
	if(selectedSchCycle!=$("#schCycle").val()){
		isCycle = false;
		selectedSchCycle = $("#schCycle").val();
	}
	campSearch();
});

/************************* 버튼이벤트 **********************************/


$("#search").click(function(){
	setFirstSrch_campGrid();
	campSearch();
});

$("#regist").click(function(){
	parent.popupOpen("/cp/cpcm0101.do");
});


$("#delete").click(function(){
	if(selectedCampId!=""){
		LLYNX_Confirm("삭제하시겠습니까?", "deleteCamp");
	}else{
		LLYNX_Alert("선택된 캠페인이 없습니다.");
	}
});

function deleteCamp(){
	progressShow();
	ECMService.deleteAPI("campaigns/"+selectedCampId, function(result){
		progressHide();
		if(result.result=="S"){
			LLYNX_Alert("삭제되었습니다.");
			campSearch();
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

/************************* 그리드 및 데이터 이벤트 **********************************/

function campSearch(){
	if(campValidator()){
		ECMService.getAPI("campaigns", JSON.stringify(campSearchData), function(result){
			if(result.result=="S"){
				campGrid.setECMGrid(result);
				campGrid.setSelectRowFunc("campSelectRow");
				if(selectedSchCycle!=""){
					if(!isCycle){
						clearInterval(updateData);
						updateData = setInterval(function(){
							campSearchCycle();
						}, selectedSchCycle*1000);
					}
					isCycle = true;
				}else{
					clearInterval(updateData);
					isCycle = false;
				}
			}else{
				if(result.code!=null){
					LLYNX_Alert(ECMError(result.code, result.message));
				}else{
					LLYNX_Alert(result.msg);
				}
			}
		});
	}
}

function campSearchCycle(){
	ECMService.getAPI("campaigns", JSON.stringify(campSearchData), function(result){
		if(result.result=="S"){
			campGrid.setECMGrid(result);
			campGrid.setSelectRowFunc("campSelectRow");
			if(selectedSchCycle!=""){
				if(!isCycle){
					clearInterval(updateData);
					updateData = setInterval(function(){
						campSearchCycle();
					}, selectedSchCycle*1000);
				}
				isCycle = true;
			}else{
				clearInterval(updateData);
				isCycle = false;
			}
			if(selectedCampId!=""){
				$("#campGrid").jqGrid("setSelection", selectedCampId, true);
			}
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function campSelectRow(rowData, rowId){
	selectedCampId = $("#campGrid").jqGrid("getCell", rowId, "id");
}

function campValidator() {
	if(firstYn_campGrid){
		campSearchDataReset();
		campSearchData.sort =  $("#schSort").val();
		campSearchData.order =  $("#schOrder").val();
		campSearchData.searchBy =  $("#schBy").val();
		campSearchData.searchValue =  $("#schKeyword").val();
		if(selectedSchCycle!=$("#schCycle").val()){
			isCycle = false;
			selectedSchCycle = $("#schCycle").val();
		}

	}
	campSearchData = getPageInfo_campGrid(campSearchData);
	return true;
}

function campSearchDataReset(){
	selectedCampId="";
	campSearchData = { currentPage : 1, pageSize : 15, sort : "", order:"", searchBy : "", searchValue : "" };
}

function setType01(value){
	var format="";;
	if(value=='Finite'){
		format='유한';
	}else if(value=='InfiniteWithContacts'){
		format='무한';
	}else if(value=='InfiniteWithoutContacts'){
		format='무한(컨택리스트 연결 안함)';

	}else{
		format="";
	}
	return format;
}

function setStateSelect(value, option, rowObject){
	var status = rowObject.jobStatus;
	var options = '<select class="w_100p" onchange="statusChange(this, \''+value+'\')">';
	var buttons='<div class="button a_c" style="min-width:79px">';
	if(status == "Ready"){
		// 현재 상태가 대기중 일때
		//options += '<option value="">대기</option><option value="run">실행</option>';
		buttons+='<button type="button" class="btn btn_third btn_size_min" onclick="statusChange(\''+value+'\', \'run\')"><i class="xi-play"></i></button>'
	}else if(status == "Running"){
		// 현재 상태가 실행중 일때
		//options += '<option value="">실행 중</option><option value="pause">중지</option><option value="stop">종료</option>';
		buttons+='<button type="button" class="btn btn_third btn_size_min" onclick="statusChange(\''+value+'\', \'pause\')"><i class="xi-pause"></i></button>'
		buttons+='<button type="button" class="btn btn_third btn_size_min ml_5" onclick="statusChange(\''+value+'\', \'stop\')"><i class="xi-stop"></i></button>'
	}else if(status == "Paused"){
		// 현재 상태가 중지 일때
		//options += '<option value="">중지</option><option value="resume">재개</option><option value="stop">종료</option>';
		buttons+='<button type="button" class="btn btn_third btn_size_min" onclick="statusChange(\''+value+'\', \'resume\')"><i class="xi-refresh"></i></button>'
		buttons+='<button type="button" class="btn btn_third btn_size_min ml_5" onclick="statusChange(\''+value+'\', \'stop\')"><i class="xi-stop"></i></button>'
	}else{
		// 현재 상태가 콜백 일때
		//options += '<option value="">콜백</option><option value="run">실행</option><option value="pause">중지</option><option value="resume">재개</option><option value="stop">종료</option>';
		buttons+='<button type="button" class="btn btn_third btn_size_min ml_5" onclick="statusChange(\''+value+'\', \'stop\')"><i class="xi-stop"></i></button>'
	}
	options+='</select>';
	buttons+='</div>';

	return buttons;
}

function statusFormat(status){
	if(status == "Ready"){
		// 현재 상태가 대기중 일때
		return "대기";
	}else if(status == "Running"){
		// 현재 상태가 실행중 일때
		return "실행 중";
	}else if(status == "Paused"){
		// 현재 상태가 중지 일때
		return "중지";
	}else{
		// 현재 상태가 콜백 일때
		return "콜백";
	}
}

var changeId ="";
var changeStatus = "";

function statusChange(id, status){
	changeId=id;
	changeStatus=status;
	LLYNX_Confirm("상태를 변경하시겠습니까?", "statusChangeFunction");
}

function statusChangeFunction(){
	console.log("Request URL :" + "POST /api/v1/campaigns/"+changeId+"/"+changeStatus);
	ECMService.insertAPI("campaigns/"+changeId+"/"+changeStatus, function(result){
		if(result.result&&result.result!="F"){
			LLYNX_Alert("상태가 변경되었습니다.");
			changeId="";
			changeStatus="";
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function setButtons1(value){
	var buttons = '<button type="button" class="btn btn_secondary btn_size_n" onclick="campDetail(\''+value+'\')"><i class="xi-zoom-in"></i>상세정보</button>';
	return buttons;
}

function setButtons2(value){
	var buttons = '<button type="button" class="btn btn_third btn_size_n" onclick="copy(\''+value+'\')"><i class="xi-documents-o"></i>캠페인 복제</button>';
	return buttons;
}

function setButtons3(value){
	var buttons = '<button type="button" class="btn btn_third btn_size_n" onclick="parameter(\''+value+'\')"><i class="xi-play"></i>작업매개변수</button>';
	return buttons;
}

function setButtons4(value){
	var buttons = '<button type="button" class="btn btn_third btn_size_n" onclick="schedule(\''+value+'\')"><i class="xi-calendar-add"></i>일정등록</button>';
	return buttons;
}

function campDetail(id){
	parent.popupOpen("/cp/cpcm0101.do?campId="+id);
}

function copy(id){
	parent.popupOpen("/cp/cpcm03.do?campId="+id);
}

function parameter(id, option, rowObject){
	var status = $("#campGrid").jqGrid("getCell", id, "jobStatus");
	console.log(status)
	if(status!="Running"){
		LLYNX_Alert("캠페인이 실행 중이지 않습니다.")
	}else{
		parent.popupOpen("/cp/cpcm04.do?campId="+id);
	}
}

function setContactListFormat(value){
	if(value.length>0){
		value.sort();
		var lists = "";
		for(var i=0;i<value.length;i++){
			if(i==0){
				lists+=value[i];
			}else{
				lists+=", "+value[i];
			}
		}
		return lists;
	}else{
		return value;
	}
}

function schedule(id){
	parent.popupOpen("/cp/cpcm05.do?campId="+id);
}
