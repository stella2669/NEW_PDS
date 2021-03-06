/**
 * DNC 관리
 */

var loginInfo = _getLoginInfo();

var selectedDncListId = "";
var selectedDncListType="";

var selectedDncId = "";

var isCycle = false;
var selectedSchCycle="";
var updateData;

var dncGrid = new webticsGrid();
var dncDetailGrid = new webticsGrid();

var dncColModel = [
	{label: "DNC 리스트 ID", name: "dnclistSeq", width:55	, align: "center", key:true},
	{label: "DNC리스트명", name: "dnclistNm", formatter:commonDncList, width:120, align: "left"},
//	{label: "유형", name: "listType", formatter : setName01 ,width:80, align: "center"},
//	{label: "작업상태", name: "lastDatasourceJobStatus", formatter : lastDatasourceJobStatus, width:80, align: "center"},
//	{label: "총 건수", name: "addressCount", width:40, align: "right"},
	{label: "등록자", name: "crtEmpNo", width:60, align: "center"},
	{label: "설명", name:"bigo", hidden:true}
];

var dncDetailColModel = [
	{label: "DNC ID", name: "id", width:30, align: "center"},
	{label: "주소", name: "address", width:80, align: "left"},
	{label: "등록자", name: "createdBy", width:80, align: "center"},
	{label: "등록일", name:"createdOn", formatter:momentDateFormat, width:80, align: "center"}
];

var dncSearchData = {
	currentPage : 1,
	pageSize:10,
	sort:"",
	order:"",
	searchBy:"",
	searchValue:""
}

var dncDetailSearchData = {
	currentPage : 1,
	pageSize:10000,
	sort:"",
	order:"",
	searchBy:"",
	searchValue:""
}

var dncListData = {
	name:"",
	description:""
}

var dncDetailData = {
	dncAddress:"",
	checkForPhoneRejection: false,
	checkForPhoneFormats:false
}

//grid resize
$(window).bind("resize", function() {
	$("#dncGrid").setGridWidth($("#divGrid").width(), true);
	$("#dncDetailGrid").setGridWidth($("#divGrid2").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){
	dncGrid.id("dncGrid");
	dncGrid.colModel(dncColModel);
	dncGrid.rowNum(dncSearchData.pageSize);
	dncGrid.call();

	dncDetailGrid.id("dncDetailGrid");
	dncDetailGrid.colModel(dncDetailColModel);
	dncDetailGrid.rowNum(1000);
	dncDetailGrid.call();

	$("#search").click();
	$("#schKeyword").focus();
});

$("#schKeyword").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#schSort").change(function(){
	dncSearchData.sort = $(this).val();
	dncSearchData.order = $("#schOrder").val();
	dncSearch();
});

$("#schOrder").change(function(){
	dncSearchData.order =  $(this).val();
	dncSearchData.sort =  $("#schSort").val();
	dncSearch();
});

//$("#reset").click(function(){
//	dncListDataReset();
//	$("#dncListNm").focus();
//});

$("#search").click(function(){
	dncListDataReset();
	dncDetailDataReset();
	setFirstSrch_dncGrid();
	dncSearch();
});

//$("#dncDatasource").click(function(){
//	if(selectedDncListId!=""){
//		parent.parent.popupOpen("/cu/cunc0101.do?dnclistId="+selectedDncListId);
//	}else{
//		LLYNX_Alert("선택된 DNC리스트가 없습니다.");
//	}
//});

$("#save").click(function(){
	if(setDncListData()){
		if(selectedDncListId==""){
			LLYNX_Confirm("등록하시겠습니까?", "insertDncList");
		}else{
			if(selectedDncListType=="시스템"){
				LLYNX_Alert("시스템 유형 DNC리스트는 수정할 수 없습니다.");
			}else{
				LLYNX_Confirm("수정하시겠습니까?", "updateDncList");
			}
		}
	}
});

function insertDncList(){/*
	ECMService.insertAPI( "dnclists", JSON.stringify(dncListData), function(result){
		if(result.result=="S"){
			LLYNX_Alert("등록되었습니다.");
			dncListDataReset();
			dncSearch();
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});*/
}

function updateDncList(){/*
	delete dncListData.name;
	ECMService.updateAPI("dnclists/"+selectedDncListId, JSON.stringify(dncListData), function(result){
		console.log(result);
		if(result.result=="S"){
			LLYNX_Alert("수정되었습니다.");
			dncListDataReset();
			dncSearch();
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});*/
}
/*
$("#empty").click(function(){
	if(selectedDncListId==""){
		LLYNX_Alert("선택된 DNC리스트가 없습니다.");
	}else{
		LLYNX_Confirm("비우시겠습니까?", "emptyDncList");
	}
});

function emptyDncList(){
	ECMService.insertAPI("dnclists/"+selectedDncListId+"/empty", JSON.stringify({dnclistId:selectedDncListId}), function(result){
		if(result.result=="S"){
			LLYNX_Alert("DNC리스트를 비웠습니다.");
			dncListDataReset();
			dncSearch();
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
*/
$("#delete").click(function(){
	if(selectedDncListId==""){
		LLYNX_Alert("선택된 DNC리스트가 없습니다.");
	}else{
		if(selectedDncListType=="시스템"){
			LLYNX_Alert("시스템 유형 DNC리스트는 삭제할 수 없습니다.");
		}else{
			LLYNX_Confirm("삭제하시겠습니까?", "deleteDncList");
		}
	}
});

function deleteDncList(){
	/*
	ECMService.deleteAPI("dnclists/"+selectedDncListId, JSON.stringify({dnclistId:selectedDncListId}), function(result){
		if(result.result=="S"){
			LLYNX_Alert("삭제되었습니다.");
			dncListDataReset();
			dncSearch();
		}else{
			if(result.code!=null){
				if(result.code=="113"){
					LLYNX_Alert("연결된 캠페인이 있는 DNC 그룹은 삭제할 수 없습니다.");
				}else{
					LLYNX_Alert(ECMError(result.code, result.message));
				}
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});*/
}

$("#detailReset").click(function(){
	dncDetailDataReset();
	$("#address").focus();
});

$("#detailSave").click(function(){
	if(selectedDncListId==""){
		LLYNX_Alert("선택된 DNC리스트가 없습니다.");
	}else{
		if(selectedDncId==""){
			if(setDncDetailData()){
				LLYNX_Confirm("등록하시겠습니까?", "insertDnc");
			}

		}else{
			LLYNX_Alert("DNC는 수정이 불가능합니다.");
		}
	}
});

function insertDnc(){
/*	ECMService.insertAPI("dnclists/"+selectedDncListId+"/dncs", JSON.stringify(dncDetailData), function(result){
		//console.log(result);
		if(result.result&&result.result!="F"){
			LLYNX_Alert("등록되었습니다.");
			$("#dncGrid").jqGrid("setSelection", selectedDncListId, true);
			dncDetailDataReset();
			dncSearch();
		}else if(result.result=="F"){
			if(result.code!=null){
				LLYNX_Alert("데이터를 저장하는 중 에러가 발생하였습니다.\n"+"에러코드 : "+result.code+", 에러메시지 : "+result.message);
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});*/
}

$("#detailDelete").click(function(){
	if(selectedDncListId==""){
		LLYNX_Alert("선택된 DNC리스트가 없습니다.");
	}else{
		if(selectedDncId!=""){
			LLYNX_Confirm("삭제하시겠습니까?", "deleteDnc");
		}else{
			LLYNX_Alert("선택된 DNC가 없습니다");
		}
	}
});

function deleteDnc(){
/*	ECMService.deleteAPI("dnclists/"+selectedDncListId+"/dncs/"+selectedDncId, function(result){
		if(result.result=="S"){
			LLYNX_Alert("삭제되었습니다");
			$("#dncGrid").jqGrid("setSelection", selectedDncListId, true);
			dncDetailDataReset();
			dncSearch();
		}
	});*/
}

function dncSearch(){
	if(dncValidator()){
		CUNC01_Service.getDncList(dncSearchData, function(result){
			if(result.result == "S"){
				dncGrid.setGrid(result);
				dncGrid.setSelectRowFunc("dncSelectRow");
				if(selectedSchCycle != ""){
					if(!isCycle){
						clearInterval(updateData);
						updateData = setInterval(function(){
							dncSearchCycle();
						}, selectedSchCycle*1000);
					}
					isCycle = true;
				}else{
					clearInterval(uqdateData);
					isCycle = false;
				}
				if(selectedDncListId != ""){
					$(".ui-state-highlight").removeClass("ui-state-highlight");
					$("#"+selectedDncListId).addClass("ui-state-highlight");
				}else{
					dncGrid.setGrid(result);
				}
			}else{
				LLYNX_Alert(result.msg);
			}
		});
	}
}

function dncSearchCycle(){
	if(dncValidator()){
		CUNC01_Serivce.getDncList(dncSearchData, function(result){

		});
	}
/*	ECMService.getAPI("dnclists", JSON.stringify(dncSearchData), function(result){
		if(result.result=="S"){
			dncGrid.setECMGrid(result);
			dncGrid.setSelectRowFunc("dncSelectRow");
			if(selectedSchCycle!=""){
				if(!isCycle){
					clearInterval(updateData);
					updateData = setInterval(function(){
						dncSearchCycle();
					}, selectedSchCycle*1000);

				}
				isCycle = true;
			}else{
				clearInterval(updateData);
				isCycle = false;
			}
			if(selectedDncListId!=""){
				//$("#dncGrid").jqGrid('setSelection', selectedDncListId, true);
				$(".ui-state-highlight").removeClass("ui-state-highlight");
				$("#"+selectedDncListId).addClass("ui-state-highlight");
				ECMService.getAPI("dnclists/"+selectedDncListId+"/dncs", JSON.stringify({currentPage : 1, pageSize:10000 }), function(result){
					if(result.result=="S"){
						//console.log(result.contents[0].createdOn);
						dncDetailGrid.setECMGrid(result);
						dncDetailGrid.setSelectRowFunc("dncDetailSelectRow");
					} else {
						if(result.code!=null){
							LLYNX_Alert("데이터를 가져오는 중 에러가 발생하였습니다.\n"+"에러코드 : "+result.code+", 에러메시지 : "+result.message);
						}else{
							LLYNX_Alert(result.msg);
						}
					}
				});
			}
		} else {
			if(result.code!=null){
				LLYNX_Alert("데이터를 가져오는 중 에러가 발생하였습니다.\n"+"에러코드 : "+result.code+", 에러메시지 : "+result.message);
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});*/
}

function dncValidator() {
	if(firstYn_dncGrid){
		dncSearchDataReset();
		dncSearchData.sort =  $("#schSort").val();
		dncSearchData.order =  $("#schOrder").val();
		dncSearchData.searchBy =  $("#schBy").val();
		dncSearchData.searchValue =  $("#schKeyword").val();
		if(selectedSchCycle!=$("#schCycle").val()){
			isCycle = false;
			selectedSchCycle = $("#schCycle").val();
		}
	}
	dncSearchData = getPageInfo_dncGrid(dncSearchData);
	return true;
}

function dncSearchDataReset(){
	dncSearchData = { 
		currentPage : 1,
		pageSize:10,
		sort:"",
		order:"",
		searchBy:"",
		searchValue:""
	};
}

function setDncListData(){
	dncListData.name = $("#dncListNm").val();
	dncListData.description = $("#description").val();
	return true;
}

function dncListDataReset(){
	selectedDncListId = "";
	selectedDncListType = "";
	$("#dncListNm").val("");
	$("#dncListNm").prop("readonly",false);
	$("#description").val("");
	dncListData = { name:"", description:"" };
	dncDetailDataReset();
	$("#dncDetailGrid").clearGridData();
	$("#dncDetailGrid").trigger("reloadGrid");
}

function dncSelectRow(rowData){
	selectedDncListId = rowData.id;
	selectedDncListType = rowData.listType;
	$(".ui-state-highlight").removeClass("ui-state-highlight");
	$("#"+selectedDncListId).addClass("ui-state-highlight");
/*	ECMService.getAPI("dnclists/"+selectedDncListId, function(result){
		if(result.result=="S"){
			$("#dncListNm").val(result.name);
			$("#dncListNm").prop("readonly", true);
			$("#description").val(result.description);

			ECMService.getAPI("dnclists/"+selectedDncListId+"/dncs", JSON.stringify({currentPage : 1, pageSize:10000 }), function(result){
				if(result.result=="S"){
					//console.log(result.contents[0].createdOn);
					dncDetailGrid.setECMGrid(result);
					dncDetailGrid.setSelectRowFunc("dncDetailSelectRow");
				} else {
					if(result.code!=null){
						LLYNX_Alert("데이터를 가져오는 중 에러가 발생하였습니다.\n"+"에러코드 : "+result.code+", 에러메시지 : "+result.message);
					}else{
						LLYNX_Alert(result.msg);
					}
				}
			});
		}else{
			if(result.code!=null){
					LLYNX_Alert("데이터를 가져오는 중 에러가 발생하였습니다.\n"+"에러코드 : "+result.code+", 에러메시지 : "+result.message);
				}else{
					LLYNX_Alert(result.msg);
				}
		}
	});*/


}

function setName01(value){
	//console.log(value)
	var format="";;
	if(value=='System'){
		format='시스템';
	}else if(value=='Custom'){
		format='사용자 정의';
	}else{
		format="";
	}
	return format;
}

function dncDetailSelectRow(rowData){
	dncDetailDataReset();
	selectedDncId = rowData.id;
	$("#address").val(rowData.address);
	$("#address").prop("disabled", true);
}

function setDncDetailData(){
	dncDetailData.dncAddress = $("#address").val();
	return true;
}

function dncDetailDataReset(){
	dncDetailData.dncAddress = "";
	selectedDncId="";
	$("#address").prop("disabled", false);
	$("#address").val("");
}

function dncDetailGridReset(){
	$("#dncDetailGrid").jqGrid("clearGridData");
	$("#dncDetailGrid").trigger("reloadGrid");
}

function commonDncList(value){
	if(value=="Common DNC List"){
		return "일반 DNC 목록"
	}else{
		return value;
	}
}