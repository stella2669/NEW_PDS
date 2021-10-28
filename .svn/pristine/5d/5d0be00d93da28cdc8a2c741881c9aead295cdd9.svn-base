/**
 * NC그룹관리
 */

var loginInfo = _getLoginInfo();

var selectedDncGroupId = "";

var dncGroupGrid = new webticsGrid();

var dncGroupColModel = [
	{label:"DNC그룹ID", name:"id", align:"center", width:20},
	{label:"DNC그룹명", name:"name", align:"left", width:50},
	{label:"기본 DNC리스트", name:"defaultDnclistName", align:"center", width:40},
	{label:"할당된 DNC리스트 목록", name:"dnclistNames", align:"left", width:100},
	{label:"설명", name:"description", align:"left", width:100},
	{label:"마지막 수정일시", name:"lastModifiedOn", formatter:momentDateFormat, align:"center", width:80}
];

var dncGroupSearchData = {
	currentPage:1,
	pageSize:15,
	order:"",
	sort:"",
	searchBy:"",
	searchValue:""
}

var dncGroupData = {
	name:"",
	description:""
}

//grid resize
$(window).bind("resize", function() {
	$("#dncGroupGrid").setGridWidth($("#divGrid").width(), true);

	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){
	dncGroupGrid.id("dncGroupGrid");
	dncGroupGrid.colModel(dncGroupColModel);
	dncGroupGrid.rowNum(dncGroupSearchData.pageSize);
	dncGroupGrid.call();

	$("#search").click();
});

$("#search").click(function(){
	dncGroupDataReset();
	setFirstSrch_dncGroupGrid();
	dncGroupSearch();
});

$("#schKeyword").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#schSort").change(function(){
	dncGroupSearchData.sort = $(this).val();
	dncGroupSearchData.order = $("#schOrder").val();
	dncGroupSearch();
});

$("#schOrder").change(function(){
	dncGroupSearchData.order =  $(this).val();
	dncGroupSearchData.sort =  $("#schSort").val();
	dncGroupSearch();
});

$("#reset").click(function(){
	dncGroupDataReset();
	$("#dncGroupNm").focus();
});

$("#save").click(function(){
	if(setDncGroupData()){
		if(selectedDncGroupId==""){
			LLYNX_Confirm("등록하시겠습니까?", "insertDncGroup");
		}else{
			LLYNX_Confirm("수정하시겠습니까?", "updateDncGroup");
		}
	}
});

function insertDncGroup(){
	ECMService.insertAPI( "dncgroups", JSON.stringify(dncGroupData), function(result){
		if(result.result=="S"){
			LLYNX_Alert("등록되었습니다.");
			$("#search").click();
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function updateDncGroup(){
	delete dncGroupData.name;
	ECMService.updateAPI("dncgroups/"+selectedDncGroupId, JSON.stringify(dncGroupData), function(result){
		if(result.result=="S"){
			LLYNX_Alert("수정되었습니다.");
			$("#search").click();
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

$("#delete").click(function(){
	if(selectedDncGroupId==""){
		LLYNX_Alert("선택된 DNC그룹이 없습니다.");
	}else{
		LLYNX_Confirm("삭제하시겠습니까?", "deleteDncGroup");
	}
});

function deleteDncGroup(){
	ECMService.deleteAPI("dncgroups/"+selectedDncGroupId, function(result){
		if(result.result=="S"){
			LLYNX_Alert("삭제되었습니다.");
			$("#search").click();
		}else{
			if(result.code!=null){
				if(result.code=="113"){
					LLYNX_Alert("캠페인과 연결된 DNC그룹은 삭제할 수 없습니다.");
				}else{
					LLYNX_Alert(ECMError(result.code, result.message));
				}
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

$("#addDncList").click(function(){
	if(selectedDncGroupId!=""){
		parent.parent.popupOpen("/cu/cunc0201.do?dncGroupId="+selectedDncGroupId);
	}else{
		LLYNX_Alert("선택된 DNC그룹이 없습니다.");
	}
});

function validator(){
	if(firstYn_dncGroupGrid){
		dncGroupSearchDataReset();
		dncGroupSearchData.sort =  $("#schSort").val();
		dncGroupSearchData.order =  $("#schOrder").val();
		dncGroupSearchData.searchBy =  $("#schBy").val();
		dncGroupSearchData.searchValue =  $("#schKeyword").val();
	}
	dncGroupSearchData = getPageInfo_dncGroupGrid(dncGroupSearchData);
	return true;
}

function dncGroupSearch(){
	if(validator()){
		ECMService.getAPI("dncgroups", JSON.stringify(dncGroupSearchData), function(result){
			if(result.result=="S"){
				dncGroupGrid.setECMGrid(result);
				dncGroupGrid.setSelectRowFunc("dncGroupSelectRow");
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

function dncGroupSelectRow(rowData){
	dncGroupDataReset();
	selectedDncGroupId = rowData.id;
	ECMService.getAPI("dncgroups/"+selectedDncGroupId, JSON.stringify({dncgroupId:selectedDncGroupId}), function(result){
		$("#dncGroupNm").val(result.name);
		$("#dncGroupNm").prop("readonly", true);
		$("#description").val(result.description);
	});
}

function dncGroupSearchDataReset(){
	dncGroupSearchData = { currentPage:1, pageSize:15, order:"", sort:"", searchBy:"", searchValue:"" };
}

function setDncGroupData(){
	if($("#dncGroupNm").val()==""){
		LLYNX_Alert("DNC그룹명은 필수값입니다.", "focus", "dncGroupNm");
		return false;
	}
	dncGroupData.name = $("#dncGroupNm").val();
	dncGroupData.description = $("#description").val();

	return true;
}

function dncGroupDataReset(){
	selectedDncGroupId="";
	dncGroupData = { name:"", description:"" };
	$("#dncGroupNm").val("");
	$("#dncGroupNm").prop("readonly", false);
	$("#description").val("");
}
