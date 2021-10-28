/**
 * DNC리스트 데이터소스관리
 */

var dnclistNm = "";

var dataGrid = new webticsGrid();

var selectedDatasorce="";

var isCycle = false;
var selectedSchCycle="";
var updateData;

var dataGridColModel = [
	{label: "ID", name: "id", align: "center", width:20},
	{label: "데이터소스명", name: "name", align: "left", width:100},
	{label: "데이터소스 유형", name: "datasourceType", formatter:datasourceTypeKr, align: "center", width:50},
	{label: "작업상태", name: "isJobActive", formatter : datasourceActiveKr,  align: "center", width:50},
	{label: "마지막수정일", name: "lastModifiedOn", formatter:momentDateFormat, align: "center", width:50},
	{label: "상세보기", name:"id", formatter: setButtons, width:40}
];

var dataSearchData = {
	currentPage: 1,
	pageSize: 10,
	searchBy: "dnclistName",
	searchValue: ""
}

//grid resize
$(window).bind("resize", function() {
	$("#dataGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){
	dataGrid.id("dataGrid");
	dataGrid.colModel(dataGridColModel);
	dataGrid.rowNum(dataSearchData.pageSize);
	dataGrid.call();

	if(selectedDnclistId!=""){
		ECMService.getAPI("dnclists/"+selectedDnclistId,function(result){
			if(result.result=="S"){
				$("#dncListNm").text(result.name);
				dnclistNm = result.name;
				dataSearchData.searchValue = result.name;
				dataListSearch();
			}else{
				if(result.code!=null){
					LLYNX_Alert(ECMError(result.code, result.message));
				}else{
					LLYNX_Alert(result.msg);
				}
			}
		});
	}else{
		LLYNX_Alert("선택된 DNC리스트 정보가 없습니다.\n다시 시도해주세요.", 'close')
	}

});


$("#schCycle").change(function(){
	if(selectedSchCycle!=$("#schCycle").val()){
		isCycle = false;
		selectedSchCycle = $("#schCycle").val();
	}
	dataListSearch();
});


function validator(){
	if(firstYn_dataGrid){
		dataSearchDataReset();
		dataSearchData.searchBy =  "dnclistName";
		if(dnclistNm==""){
			LLYNX_Alert("DNC리스트 정보가 없습니다.");
		}else{
			dataSearchData.searchValue =  dnclistNm;
		}
		if(selectedSchCycle!=$("#schCycle").val()){
			isCycle = false;
			selectedSchCycle = $("#schCycle").val();
		}
	}
	dataSearchData = getPageInfo_dataGrid(dataSearchData);
	return true;
}

$("#addDatasource").click(function(){
	popupOpen("/cu/cunc0102.do");
});


$("#excute").click(function(){
	if(selectedDatasorce!=""){
		LLYNX_Confirm("실행하시겠습니까?", "excuteDatasource");
	}else{
		LLYNX_Alert("선택한 데이터소스가 없습니다.");
	}
});

function excuteDatasource(){
	ECMService.insertAPI("datasources/"+selectedDatasorce+"/run", function(result){
		if(result.result&&result.result!="F"){
				dataListSearch();
				LLYNX_Alert("실행 되었습니다.(작업에 시간이 소요될 수 있습니다.)");
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
	if(selectedDatasorce!=""){
		LLYNX_Confirm("삭제하시겠습니까?", "deleteDatasource");
	}else{
		LLYNX_Alert("선택된 데이터소스가 없습니다.");
	}
});

function deleteDatasource(){
	ECMService.deleteAPI("datasources/"+selectedDatasorce, function(result){
		if(result.result=="S"){
			dataListSearch();
			LLYNX_Alert("삭제되었습니다.");
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

$(".popup_close").click(function(){
	parent.popupClose();
});

function dataListSearch(){
	if(validator()){
		ECMService.getAPI("datasources", JSON.stringify(dataSearchData), function(result){
			if(result.result=="S"){
				var tempResult = {};
				tempResult.contents = [];
				for(var i=0;i<result.contents.length;i++){
					if(result.contents[i].datasourceType!="upload_file"&&
					   result.contents[i].datasourceType!="exclude_contacts"&&
					   result.contents[i].datasourceType!="reset_excluded_contacts"){
						tempResult.contents.push(result.contents[i]);
					}
				}
				dataGrid.setECMGrid(tempResult);
				dataGrid.setSelectRowFunc("dataSelectRow");
				if(selectedSchCycle!=""){
					if(!isCycle){
						clearInterval(updateData);
						updateData = setInterval(function(){dataListSearch();}, selectedSchCycle*1000);
					}
					isCycle = true;
				}else{
					clearInterval(updateData);
					isCycle = false;
				}
				if(selectedDatasorce!=""){
					$("#dataGrid").jqGrid("setSelection", selectedDatasorce, true);
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

function dataSelectRow(rowData, rowId){
	selectedDatasorce = $("#dataGrid").jqGrid("getCell", rowId, "id");
}

function dataSearchDataReset(){
	selectedDatasorce = "";
	dataSearchData = { currentPage: 1, pageSize: 10, searchBy: "dnclistName", searchValue: dnclistNm };
}

function setButtons(id){
	var button = '<button type="button" class="btn btn_third btn_size_n" onclick="datasourceDetail(\''+id+'\')"><i class="xi-zoom-in"></i>상세보기</button>';

	return button;
}

function datasourceDetail(id){
	popupOpen("/cu/cunc0102.do?datasourceId="+id);
}

// 메인화면 팝업 오픈
function popupOpen(url) {
	$("#popupDiv").show();
	$("#popupDiv").html('<iframe id="layerPopup" src="'+url+'" onload="addDiv2();"></iframe>');
}

function addDiv2() {
	$("#layerPopup").contents().find(".popup_window").wrap("<div class='popup_align'></div>");
}

// 메인화면 팝업 종료
function popupClose() {
	$("#popupDiv").html("");
	$("#popupDiv").hide();
}