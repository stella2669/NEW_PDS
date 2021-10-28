/**
 * 콜백관리 페이지
 */

var loginInfo = _getLoginInfo();

var selectedCallbackIds = [];

var isCycle = false;
var selectedSchCycle="";
var updateData;

var callbackColModel = [
	{label:"콜백ID", name:"id", align:"center", width:20, key:true},
	{label:"캠페인명", name:"campaignName", align:"left", width:70},
	{label:"콜백유형", name:"callbackType",formatter : setName01, align:"center", width:30},
	{label:"콜백상태", name:"status", formatter : setName02,align:"center", width:50},
	{label:"생성 상담원ID", name:"createdBy", align:"center", width:35},
	{label:"할당 상담원ID", name:"createdForAgent", align:"center", width:35},
	{label:"수행 상담원 ID", name:"servicedByAgentId", align:"center", width:35},
	{label:"다음 시도 시간", name:"nextAttemptTime", formatter:momentDateFormat, align:"center", width:50},
	{label:"시작시간", name:"startTime", formatter:momentDateFormat, align:"center", width:50},
	{label:"종료시간", name:"endTime", formatter:momentDateFormat, align:"center", width:50},
	{label:"상세조회", name:"id", formatter : setButtons01, align:"center", width:38 },
	{label:"콜백수정", name:"id", formatter : setButtons02, align:"center", width:38 }
]

var callbackSearchData = {
	currentPage:1,
	pageSize:15,
	order:"",
	sort:"",
	searchBy:"",
	searchValue:""
}

var callbackGrid = new webticsGrid();


function callbackSearchDataReset(){
	callbackSearchData = { currentPage:1, pageSize:15, order:"", sort:"", searchBy:"", searchValue:"" };
}

//grid resize
$(window).bind("resize", function() {
	$("#callbackGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){

	callbackGrid.id("callbackGrid");
	callbackGrid.colModel(callbackColModel);
	callbackGrid.multiSelect(true);

	callbackGrid.call();

	callbackSearch();
});

$("#search").click(function(){
	callbackSearchDataReset();
	setFirstSrch_callbackGrid();
	callbackSearch();
});


$("#schKeyword").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#schSort").change(function(){
	callbackSearchData.sort = $(this).val();
	callbackSearchData.order = $("#schOrder").val();
	callbackSearch();
});

$("#schOrder").change(function(){
	callbackSearchData.order =  $(this).val();
	callbackSearchData.sort =  $("#schSort").val();
	callbackSearch();
});


$("#allEdit").click(function(){
	var s = jQuery("#callbackGrid").jqGrid('getGridParam', 'selarrrow');
	if(s==''){
		LLYNX_Alert("변경할 콜백정보를 선택하세요!");
		return;
	}
	parent.popupOpen("/ca/caca05.do?callbackids="+s);
});

$("#allDelete").click(function(){
	var s = jQuery("#callbackGrid").jqGrid('getGridParam', 'selarrrow');
	if(s==''){
		LLYNX_Alert("삭제할 콜백정보를 선택하세요!");
		return;
	}
	parent.popupOpen("/ca/caca06.do?callbackids="+s);
});

$("#allClose").click(function(){
	var selectDatas = $("#callbackGrid").jqGrid('getGridParam', 'selarrrow');
	if(selectDatas.length==0){
		LLYNX_Alert("선택된 콜백이 없습니다.");
	}else{
		var ids="";
		var canClose = true;
		for(var k=0; k<selectDatas.length;k++){
			var selCallbackId = $("#callbackGrid").jqGrid("getCell", selectDatas[k], "id");
			var selRowData = $("#callbackGrid").getRowData(selectDatas[k]);
			if(selRowData.status=="활성 작업에 연결됨"||selRowData.status=='작업 대기 중'){
				if(ids==""){
					ids += selCallbackId
				}else{
					ids += ","+selCallbackId
				}
				//콜백을 일괄 종료한다. ActiveAttachedToJob, WaitingForJob 상태의 콜백만 종료 가능하다.
			}else{
				canClose=false;
			}
		}

		if(canClose){
			parent.popupOpen("/ca/caca07.do?callbackids="+ids);
		}else{
			LLYNX_Alert("종료할 수 없는 콜백이 선택되었습니다.\n'활성 작업에 연결됨' 또는 '작업 대기 중'상태의\n콜백만 종료할 수 있습니다.");
		}
	}
});


function callbackSearch(){
	if(callbackValidator()){
		ECMService.getAPI("callbacks", JSON.stringify(callbackSearchData), function(result){
			if(result.result=="S"){
				callbackGrid.setECMGrid(result);
				callbackGrid.setSelectRowFunc("callbackSelectRow");
			}else{
				if(result.code!=null){
					LLYNX_Alert(ECMError(result.code, result.message));
				}else{
					LLYNX_Alert(result.msg);
				}
			}
			if(selectedSchCycle!=""){
				if(!isCycle){
					clearInterval(updateData);
					updateData = setInterval(function(){callbackSearchCycle();}, selectedSchCycle*1000);
				}
				isCycle = true;
			}else{
				clearInterval(updateData);
				isCycle = false;
			}
			selectedCallbackIds = [];
		});
	}
}

function callbackSearchCycle(){
	ECMService.getAPI("callbacks", JSON.stringify(callbackSearchData), function(result){
		if(result.result=="S"){
			callbackGrid.setECMGrid(result);
			callbackGrid.setSelectRowFunc("callbackSelectRow");
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
		if(selectedSchCycle!=""){
			if(!isCycle){
				clearInterval(updateData);
				updateData = setInterval(function(){callbackSearch();}, selectedSchCycle*1000);
			}
			isCycle = true;
		}else{
			clearInterval(updateData);
			isCycle = false;
		}
		if(selectedCallbackIds.length>0){
			var cycleSelectDatas = selectedCallbackIds;
			for(var i=0;i<cycleSelectDatas.length;i++){
				$("#callbackGrid").jqGrid("setSelection", cycleSelectDatas[i], true);
			}
		}
	});
}

function callbackSelectRow(){
	selectedCallbackIds = $("#callbackGrid").jqGrid('getGridParam', 'selarrrow');
}

function callbackValidator() {
	if(firstYn_callbackGrid){
		callbackSearchDataReset();
		callbackSearchData.sort =  $("#schSort").val();
		callbackSearchData.order =  $("#schOrder").val();
		callbackSearchData.searchBy =  $("#schBy").val();
		callbackSearchData.searchValue =  $("#schKeyword").val();
		if(selectedSchCycle!=$("#schCycle").val()){
			isCycle = false;
			selectedSchCycle = $("#schCycle").val();
		}
	}
	callbackSearchData = getPageInfo_callbackGrid(callbackSearchData);
	return true;
}

function setButtons01(value){
	var format = '<div class="button a_l"><button type="button" class="btn btn_third btn_size_n" onclick="detailBtn('+value+')"><i class="xi-file"></i>상세조회</button>';
	return format;
}

function setButtons02(value){
	var format = '<div class="button a_l"><button type="button" class="btn btn_third btn_size_n" onclick="editBtn('+value+')"><i class="xi-file"></i>콜백편집</button>';
	return format;
}

function detailBtn(id){
	parent.popupOpen("/ca/caca02.do?callbackid="+id);
}

function editBtn(id){
	parent.popupOpen("/ca/caca03.do?callbackid="+id);
}


function setName01(value){
	var format="";;
	switch(value) {
		case "Agent" :
			format='상담사';
			break;
		case "Campaign" :
			format='캠페인';
			break;
		case "Standard" :
			format='표준';
			break;
		case "StrictAgent" :
			format='지정 상담사';
			break;
		default :
			format=value;
		break;
	}

	return format;
}

function setName02(value){
	var format="";;
	switch(value) {
		case "ActiveAttachedToJob" :
			format='활성 작업에 연결됨';
			break;
		case "Completed" :
			format='완료됨';
			break;
		case "Expired" :
			format='만료됨';
			break;
		case "CampaignTerminated" :
			format='캠페인 종료됨';
			break;
		case "Overwritten" :
			format='덮어씀';
			break;
		case "ContactExcluded" :
			format='제외된 컨택';
			break;
		case "WaitingForJob" :
			format='작업 대기 중';
			break;
		case "ManuallyCancelled" :
			format='수동으로 취소됨';
			break;
		case "QueuedForDialing" :
			format='연결중';
			break;
		case "InProgress" :
			format='처리중';
			break;
		default :
			format=value;
		break;
	}

	return format;
}