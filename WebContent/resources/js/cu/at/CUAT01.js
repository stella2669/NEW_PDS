// 로그인 사용자 정보
var loginInfo = _getLoginInfo();

var selectedattrListSeq = "";

var selectedattrInfoSeq = "";

var lcdGrid = new webticsGrid();
var scdGrid = new webticsGrid();

var lcdColModel = [
	{ name: "attrNm", label: "특성리스트명", width:120, align: "center" },
	{ name: "isuse", label: "사용여부", width:60, align: "center" },
	{ name: "temp01", label: " ",  align: "center" },
	{ name: "attrListSeq", label: "attr_list_seq", hidden: true, },
];

var scdColModel = [
	{ name: "attrListSeq", label: "attr_list_seq", hidden: true },
	{ name: "attrinfoId", label: "attrinfoId",hidden: true },
	{ name: "attrinfoNm", label: "특성명", width:100, align: "center" },
	{ name: "attrinfoTypeNm", label: "특성유형", width:60, align: "center" },
	{ name: "isMask", label: "마스킹여부", width:50, align: "center" },
	{ name: "isKey", label: "Key 여부", width:60, align: "center" },
	
	
	{ name: "sortNo", label: "순서", width:60, align: "center" },
	{ name: "attrinfoType", label: "attrinfoType",hidden: true },
	
	{ name: "bigo", label: "비고", align: "left" }
];

var scdSearchData = {
		attrListSeq: ""
}

var lcdSearchData  = {
		attrListSeq: ""
}

var lcdData = {
		attrNm: "",
		isUse: "",
		attrListSeq: "",
		userId: loginInfo.userId
}


var scdData = {
		attrListSeq: "",
		attrinfoId: "",
		attrinfoNm: "",
		attrinfoType: "",
		isKey: "",
		sortNo: "",
		isMask: "",
		bigo: "",
		userId: loginInfo.userId
}

//grid resize
$(window).bind("resize", function() {
	$("#comLcdGrid").setGridWidth($("#divLcdGrid").width(), true);
	$("#comScdGrid").setGridWidth($("#divScdGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function() {
	lcdGrid.id("comLcdGrid");
	lcdGrid.colModel(lcdColModel);
	lcdGrid.rowNum(1000);
	lcdGrid.call();

	scdGrid.id("comScdGrid");
	scdGrid.colModel(scdColModel);
	scdGrid.rowNum(1000);
	scdGrid.call();

	lcdSearch();
	
});


$("#search").click(function() {
	//리스트데이터 초기ㅇ화
	lcdDataReset();
	//scdDataReset();
	//scdGridReset();
	lcdSearch();
});

$("#lcdNew").click(function() {
	lcdDataReset();
	$("#attrNm").focus();
});

$("#lcdSave").click(function() {
	if (setLcdData()) {
		if (selectedattrListSeq == "") {
			LLYNX_Confirm("등록하시겠습니까?", "insertLcd");
		} else {
			LLYNX_Confirm("수정하시겠습니까?", "updateLcd");
		}
	}
});

function insertLcd(){
	CUAT01_Service.insertAttrlist(lcdData, function(result) {
		if (result.result == "S") {
			LLYNX_Alert("등록되었습니다.");
			lcdDataReset();
			lcdSearch();
		} else {
			LLYNX_Alert(result.msg);
		}
	});
}

function updateLcd(){
	CUAT01_Service.updateAttrlist(lcdData, function(result) {
			if (result.result == "S") {
				LLYNX_Alert("수정되었습니다.");
				lcdDataReset();
				lcdSearch();
			} else {
				LLYNX_Alert(result.msg);
			}
		});
}

$("#lcdDel").click(function() {
	if (selectedattrListSeq == "") {
		LLYNX_Alert("선택된 특성리스트가 없습니다.");
	} else {
		if (setLcdData()) {
			LLYNX_Confirm("삭제하시겠습니까?", "deleteLcd");
		}
	}
});

function deleteLcd(){
	CUAT01_Service.deleteAttrlist(lcdData, function(result) {
		if (result.result == "S") {
			LLYNX_Alert("삭제되었습니다.");
			lcdDataReset();
			lcdSearch();
		} else {
			LLYNX_Alert(result.msg);
		}
	});
}

$("#scdNew").click(function() {
	scdDataReset();
	$("#attrinfoNm").focus();
});

$("#scdSave").click(function() {
	if (setScdData()) {
		if (selectedattrInfoSeq == "") {
			LLYNX_Confirm("등록하시겠습니까?", "insertScd");
		} else {
			LLYNX_Confirm("수정하시겠습니까?", "updateScd");
		}
	}
});

function insertScd(){
	CUAT01_Service.insertAttrInfo(scdData, function(result) {
		if (result.result == "S") {
			LLYNX_Alert("등록되었습니다.");
			scdDataReset();
			scdSearch(selectedattrListSeq);
		} else {
			LLYNX_Alert(result.msg);
		}
	});
}

function updateScd(){
	
	CUAT01_Service.updateAttrInfo(scdData, function(result) {
		if (result.result == "S") {
			LLYNX_Alert("수정되었습니다.");
			scdDataReset();
			scdSearch(selectedattrListSeq);
		} else {
			LLYNX_Alert(result.msg);
		}
	});
}

$("#scdDel").click(function() {
	if (selectedattrInfoSeq == "") {
		LLYNX_Alert("선택된 특성목록 정복가 없습니다.");
	} else {
		if (setScdData()) {
			LLYNX_Confirm("삭제하시겠습니까?", "deleteScd");
		}
	}
});

function deleteScd(){
	CUAT01_Service.deleteAttrInfo(scdData, function(result) {
		if (result.result == "S") {
			LLYNX_Alert("삭제되었습니다.");
			scdDataReset();
			scdSearch(selectedattrListSeq);
		} else {
			LLYNX_Alert(result.msg);
		}
	});
}

function lcdSearch() {
	progressShow();
	CUAT01_Service.getAttrList(lcdSearchData, function(result) {
		//console.log(JSON.stringify(result));
		progressHide();
		if (result.result == "S") {
			lcdGrid.setGrid(result);
			lcdGrid.setSelectRowFunc("lcdSelectRow");
		} else {
			LLYNX_Alert(result.msg);
		}
	});
}



function lcdSelectRow(rowData) {
	selectedattrListSeq = rowData.attrListSeq;
	
	$("#attrNm").val(rowData.attrNm);
	$("#isUse").val(rowData.isuse);
	//특성정보 초기화
	scdDataReset();
	//특성정보조회
	scdSearch(rowData.attrListSeq);
}

function setLcdData() {
	
	if ( $("#attrNm").val()!="") {
		if (selectedattrListSeq == "") {
			lcdData.attrListSeq = "";
		} else {
			lcdData.attrListSeq = selectedattrListSeq;
		}
		lcdData.isUse = $("#isUse").val();
		lcdData.attrNm = $("#attrNm").val();
		return true;
	} else if ($("#attrNm").val() == "") {
		LLYNX_Alert("특성리스트명을 입력해주세요.", 'attrNm');
		return false;
	} else if (lcdData.userId == "") {
		LLYNX_Alert("로그인 상담원 정보가 존재하지 않습니다.\n다시 로그인해주세요.");
		return false;
	}
}

function lcdDataReset() {

	lcdData = { attrNm: "", isUse:"", attrListSeq: "",userId: loginInfo.userId };
	selectedattrListSeq = "";
	$("#attrNm").val("");
	$("#isUse").val("Y");
	
}

function scdSearch(attrListSeq) {
	if (scdValidator(attrListSeq)) {
		progressShow();
		CUAT01_Service.getAttrInfoList(scdSearchData, function(result) {
			progressHide();
			if (result.result == "S") {
				scdGrid.setGrid(result);
				scdGrid.setSelectRowFunc("scdSelectRow");
			} else {
				LLYNX_Alert(result.msg);
			}
		});
	}
}

function scdValidator(attrListSeq) {
	scdSearchDataReset();
	scdSearchData.attrListSeq = attrListSeq;

	return true;
}

function scdSearchDataReset() {
	scdSearchData = {
			attrListSeq: ""
	}
}

function scdSelectRow(rowData) {
	selectedattrInfoSeq = rowData.attrinfoId;
	$("#attrinfoNm").val(rowData.attrinfoNm);
	$("#attrinfoType").val(rowData.attrinfoType);
	$("#isKey").val(rowData.isKey);
	$("#sortNo").val(rowData.sortNo);
	$("#isMask").val(rowData.isMask);
	$("#bigo").val(rowData.bigo);
}

function setScdData() {
	if(selectedattrListSeq==""){
		LLYNX_Alert("선택된 특성리스트가 없습니다.\n다시 선택해주세요.");
		return false;
	}
	
	if(lcdData.userId==""){
		LLYNX_Alert("로그인 상담원 정보가 존재하지 않습니다.\n다시 로그인해주세요.");
		return false;
	}
	
	if($("#attrinfoNm").val() == "") {
		LLYNX_Alert("특성명을 입력해주세요.", 'attrinfoNm');
		return false;
	} 
	scdData.attrListSeq = selectedattrListSeq;
	scdData.attrinfoId = selectedattrInfoSeq;
	scdData.attrinfoNm = $("#attrinfoNm").val();
	scdData.attrinfoType = $("#attrinfoType").val();
	scdData.isKey = $("#isKey").val();
	scdData.isMask = $("#isMask").val();
	scdData.sortNo = $("#sortNo").val();
	scdData.bigo = $("#bigo").val();
	return true;
	
}

function scdDataReset() {
	
	scdData = { attrListSeq: "", attrinfoId: "", attrinfoNm: "",  attrinfoType: "", isKey: "",sortNo: "", isMask: "", bigo: "", userId: loginInfo.userId };
	selectedattrInfoSeq = "";
	$("#attrinfoNm").val("");
	$("#attrinfoType").val("");
	$("#isKey").val("N");
	$("#sortNo").val("");
	$("#isMask").val("N");
	$("#bigo").val("");
}

function scdGridReset(){
	$("#scdGrid").clearGridData();
	$("#scdGrid").trigger("reloadGrid");
}