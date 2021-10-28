/**
 * 컨택리스트 관리
 */

var selectedContactId="";

var contactColModel = [
	{label:"컨택리스트ID", name:"contactSeq", align:"center", width:30, key:true},
	{label:"컨택리스트명", name:"contactNm", align:"left", width:60},
//	{label:"전체 컨택수", formatter:addCommaStr, name:"", align:"right", width:30},	
	{label:"사용여부", name:"isUse", align:"center", width:30},
	{label:"생성자", name:"crtUserId", align:"center", width:30},
	{label:"상세보기", name:"contactSeq", formatter : detailButton, align:"center", width:35},
	{label:"업로드", name:"contactSeq", formatter : uploadButton, align:"center", width:35},
	{label:"비우기", name:"contactSeq", formatter : emptyButton, align:"center", width:35},
	{label:"설명", hidden:true}
]

var contactSearchData = {
	currentPage:1,
	pageSize:15,
	order:"",
	sort:"",
	searchBy:"",
	searchValue:""
}

var contactGrid = new webticsGrid();

//grid resize
$(window).bind("resize", function() {
	$("#contactGrid").setGridWidth($("#divDataGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){
	contactGrid.id("contactGrid");
	contactGrid.colModel(contactColModel);
	contactGrid.call();

	$("#search").click();
	$("#schKeyword").focus();
});

$("#schKeyword").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#search").click(function(){
	contactDataReset();
	setFirstSrch_contactGrid();
	contactListSearch();
});

$("#schSort").change(function(){
	contactSearchData.sort = $(this).val();
	contactListSearch();
});

$("#schOrder").change(function(){
	contactSearchData.order =  $(this).val();
	contactListSearch();
});

$("#save").click(function(){
	parent.popupOpen("/cu/cuco0101.do");
});

$("#delete").click(function(){
	if(selectedContactId == ""){
		LLYNX_Alert("삭제할 컨택리스트를 선택해주세요");
		return;
	}
	LLYNX_Confirm("삭제하시겠습니까?", "deleteContactList");
});

function deleteContactList(){
	CUCO01_Service.deleteContactList({contactSeq : selectedContactId}, function(result){
		if(result.result == "S"){
			LLYNX_Alert("삭제되었습니다.", "close");
			$("#search").click();
		}else{
			LLYNX_Alert(result.msg);
		}
	});
}

function validator(){
	if(firstYn_contactGrid){
		contactSearchDataReset();
		contactSearchData.sort =  $("#schSort").val();
		contactSearchData.order =  $("#schOrder").val();
		contactSearchData.searchBy =  $("#schBy").val();
		contactSearchData.searchValue =  $("#schKeyword").val();
	}
	contactSearchData = getPageInfo_contactGrid(contactSearchData);
	return true;
}

function contactListSearch(){
	if(validator()){
		progressShow();
		CUCO01_Service.getContactList(contactSearchData, function(result) {
			//console.log(JSON.stringify(result));
			progressHide();
			if (result.result == "S") {
				contactGrid.setGrid(result);
				contactGrid.setSelectRowFunc("contactSelectRow");
			} else {
				LLYNX_Alert(result.msg);
			}
		});
	}
}

function contactSelectRow(rowData, rowId){
	selectedContactId = $("#contactGrid").jqGrid("getCell", rowId, "contactSeq");
	$(".ui-state-highlight").removeClass("ui-state-highlight");
	$("#"+selectedContactId).addClass("ui-state-highlight");
}


function contactSearchDataReset(){
	selectedContactId="";
	contactSearchData = { currentPage:1, pageSize:15, order:"", sort:"", searchBy:"", searchValue:"" };
}

function contactDataReset(){
	selectedContactId="";
}

function detailButton(value){
	var buttons = '<button type="button" class="btn btn_secondary btn_size_n" onclick="contactDetail(\''+value+'\')"><i class="xi-zoom-in"></i>상세정보</button>';
	return buttons;
}

function uploadButton(value){
	var format = '<button type="button" class="btn btn_third btn_size_n" onclick="contactUpload('+value+')"><i class="xi-file"></i>컨택업로드</button>';
	return format;
}

function emptyButton(value){
	var format = '<button type="button" class="btn btn_primary btn_size_n" onclick="listEmpty('+value+')"><i class="xi-eraser"></i>비우기</button>';
	return format;
}

function contactDetail(id){
	parent.popupOpen("/cu/cuco0101.do?contactlistId="+id);
}

function contactUpload(id){
	parent.popupOpen("/cu/cuco02.do?contactListId="+id);
}

function linkDatasorce(id){
	parent.popupOpen("/cu/cuco04.do?contactListId="+id);
}

var emptyId = "";

function listEmpty(id){
	emptyId = id;
	LLYNX_Confirm("비우시겠습니까?", "emptyContactList");
}

function emptyContactList(){
	ECMService.insertAPI("contactlists/"+emptyId+"/empty", function(result){
		if(result.result=="S"){
			emptyId="";
			LLYNX_Alert("컨택리스트를 비웠습니다.(작업에 시간이 소요될 수 있습니다.)");
			contactListSearch();
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function pressSearchButton(){
	$("#search").click();
}