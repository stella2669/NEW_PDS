// 로그인 사용자 정보
var loginInfo = _getLoginInfo();

var selectedLcd = "";
var selectedLcdReqYn="";
var selectedScd = "";

var lcdGrid = new webticsGrid();
var scdGrid = new webticsGrid();

var lcdColModel = [
	{ name: "comLcd", label: "공통코드", width:80, align: "center" },
	{ name: "comLnm", label: "공통코드명", width:80, align: "center" },
	{ name: "useYn", label: "사용여부", width:40, align: "center" },
	{ name: "reqYn", label: "필수여부", width:40, align: "center" },
	{ name: "bigo", label: "비고", width:160, align: "left" },
];

var scdColModel = [
	{ name: "comLcd", label: "공통코드", hidden: true },
	{ name: "comScd", label: "상세코드", width:80, align: "center" },
	{ name: "comSnm", label: "상세코드명", width:80, align: "center" },
	{ name: "useYn", label: "사용여부", width:40, align: "center" },
	{ name: "bigo", label: "비고", width:160, align: "left" },
	{ name: "sort", label: "순서", hidden: true }
];

var lcdSearchData = {
	schComLnm: ""
}

var scdSearchData = {
	comLcd: ""
}

var lcdData = {
	comLcd: "",
	chComLcd: "",
	comLnm: "",
	useYn: "",
	reqYn:"",
	note: "",
	userId: loginInfo.userId
}


var scdData = {
	comLcd: "",
	comScd: "",
	chComScd: "",
	comSnm: "",
	useYn: "",
	note: "",
	sort: "",
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

	$("#search").click();
	$("#schComLnm").focus();
});

$("#schComLnm").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#search").click(function() {
	lcdDataReset();
	scdDataReset();
	scdGridReset();
	lcdSearch();
});

$("#lcdNew").click(function() {
	lcdDataReset();
	$("#comLcd").focus();
});

$("#lcdSave").click(function() {
	if (setLcdData()) {
		if (selectedLcd == "") {
			LLYNX_Confirm("등록하시겠습니까?", "insertLcd");
		} else {
			if(selectedLcdReqYn=="Y"){
				LLYNX_Alert("필수 공통코드는 변경할 수 없습니다.\n관리자에게 문의하세요.");
			}else{
				LLYNX_Confirm("수정하시겠습니까?", "updateLcd");
			}
		}
	}
});

function insertLcd(){
	SYCM01_Service.dupCheckLcd(lcdData, function(result) {
		if (result.result == "S") {
			SYCM01_Service.insertLcd(lcdData, function(result) {
				if (result.result == "S") {
					LLYNX_Alert("등록되었습니다.");
					lcdDataReset();
					lcdSearch();
				} else {
					LLYNX_Alert(result.msg);
				}
			});
		} else {
			LLYNX_Alert("이미 존재하는 공통코드입니다.");
			$("#comLcd").focus();
		}
	});
}

function updateLcd(){
	SYCM01_Service.updateLcd(lcdData, function(result) {
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
	if (selectedLcd == "") {
		LLYNX_Alert("선택된 공통코드가 없습니다.");
	} else {
		if(selectedLcdReqYn=="Y"){
			LLYNX_Alert("필수 공통코드는 삭제할 수 없습니다.\n관리자에게 문의하세요.");
		}else{
			if (setLcdData()) {
				LLYNX_Confirm("삭제하시겠습니까?", "deleteLcd");
			}
		}
	}
});

function deleteLcd(){
	SYCM01_Service.deleteLcd(lcdData, function(result) {
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
	$("#comScd").focus();
});

$("#scdSave").click(function() {
	if (setScdData()) {
		if (selectedScd == "") {
			LLYNX_Confirm("등록하시겠습니까?", "insertScd");
		} else {
			if(selectedLcdReqYn=="Y"){
				LLYNX_Alert("필수 공통코드의 상세코드는 수정할 수 없습니다.");
			}else{
				LLYNX_Confirm("수정하시겠습니까?", "updateScd");
			}

		}
	}
});

function insertScd(){
	SYCM01_Service.dupCheckScd(scdData, function(result) {
		if (result.result == "S") {
			SYCM01_Service.insertScd(scdData, function(result) {
				if (result.result == "S") {
					LLYNX_Alert("등록되었습니다.");
					scdDataReset();
					scdSearch(selectedLcd);
				} else {
					LLYNX_Alert(result.msg);
				}
			});
		} else {
			LLYNX_Alert("이미 존재하는 상세코드입니다.");
			$("#comScd").focus();
		}
	});
}

function updateScd(){
	SYCM01_Service.updateScd(scdData, function(result) {
		if (result.result == "S") {
			LLYNX_Alert("수정되었습니다.");
			scdDataReset();
			scdSearch(selectedLcd);
		} else {
			LLYNX_Alert(result.msg);
		}
	});
}

$("#scdDel").click(function() {
	if (selectedScd == "") {
		LLYNX_Alert("선택된 상세코드가 없습니다.");
	} else {
		if(selectedLcdReqYn=="Y"){
			LLYNX_Alert("필수 공통코드의 상세코드는 삭제할 수 없습니다.")
		}else{
			if (setScdData()) {
				LLYNX_Confirm("삭제하시겠습니까?", "deleteScd");
			}
		}
	}
});

function deleteScd(){
	SYCM01_Service.deleteScd(scdData, function(result) {
		if (result.result == "S") {
			LLYNX_Alert("삭제되었습니다.");
			scdDataReset();
			scdSearch(selectedLcd);
		} else {
			LLYNX_Alert(result.msg);
		}
	});
}

function lcdSearch() {
	if (lcdValidator()) {
		progressShow();
		SYCM01_Service.getComLcdList(lcdSearchData, function(result) {
			progressHide();
			if (result.result == "S") {
				lcdGrid.setGrid(result);
				lcdGrid.setSelectRowFunc("lcdSelectRow");
			} else {
				LLYNX_Alert(result.msg);
			}
		});
	}
}

function lcdValidator() {
	lcdSearchDataReset();
	lcdSearchData.schComLnm = $("#schComLnm").val();

	return true;
}

function lcdSearchDataReset() {
	lcdSearchData = {
		schComLnm: ""
	};
}

function lcdSelectRow(rowData) {
	selectedLcd = rowData.comLcd;
	selectedLcdReqYn = rowData.reqYn;
	$("#comLcd").val(rowData.comLcd);
	$("#comLcd").prop("readonly", true);
	$("#comLnm").val(rowData.comLnm);
	$("#lcdReqYn").val(rowData.reqYn);
	$("#lcdUseYn").val(rowData.useYn);
	$("#lcdNote").val(rowData.bigo);
	scdSearch(rowData.comLcd);
}

function setLcdData() {
	if (lcdData.siteCd != "" && lcdData.empNo != "" && $("#comLcd").val()) {
		if (selectedLcd == "") {
			lcdData.comLcd = $("#comLcd").val();
		} else {
			lcdData.comLcd = selectedLcd;
		}
		lcdData.chComLcd = $("#comLcd").val();
		lcdData.comLnm = $("#comLnm").val();
		lcdData.reqYn = $("#lcdReqYn").val();
		lcdData.useYn = $("#lcdUseYn").val();
		lcdData.note = $("#lcdNote").val();
		return true;
	} else if ($("#comLcd").val() == "") {
		LLYNX_Alert("공통코드를 입력해주세요.", 'comLcd');
		return false;
	} else if (lcdData.userId == "") {
		LLYNX_Alert("로그인 상담원 정보가 존재하지 않습니다.\n다시 로그인해주세요.");
		return false;
	}
}

function lcdDataReset() {
	lcdData = { comLcd: "", chComLcd:"", comLnm: "", useYn: "", reqYn:"", note: "",  userId: loginInfo.userId };
	selectedLcd = "";
	$("#comLcd").val("");
	$("#comLcd").prop("readonly", false);
	$("#comLnm").val("");
	$("#lcdReqYn").val("N");
	$("#lcdUseYn").val("Y");
	$("#lcdNote").val("");
	scdSearch('');
}

function scdSearch(comLcd) {
	if (scdValidator(comLcd)) {
		progressShow();
		SYCM01_Service.getComScdList(scdSearchData, function(result) {
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

function scdValidator(comLcd) {
	scdSearchDataReset();
	scdSearchData.comLcd = comLcd;

	return true;
}

function scdSearchDataReset() {
	scdSearchData = {
		comLcd: ""
	}
}

function scdSelectRow(rowData) {
	selectedScd = rowData.comScd;
	$("#comScd").val(rowData.comScd);
	$("#comSnm").val(rowData.comSnm);
	$("#scdUseYn").val(rowData.useYn);
	$("#scdSort").val(rowData.sort);
	$("#scdNote").val(rowData.bigo);
}

function setScdData() {
	if (selectedLcd != "" && lcdData.userId != "" && $("#comScd").val() != "") {
		scdData.comLcd = selectedLcd;
		if (selectedScd == "") {
			scdData.comScd = $("#comScd").val();
		} else {
			scdData.comScd = selectedScd;
		}
		scdData.chComScd = $("#comScd").val();
		scdData.comSnm = $("#comSnm").val();
		scdData.useYn = $("#scdUseYn").val();
		scdData.sort = $("#scdSort").val();
		scdData.note = $("#scdNote").val();
		return true;
	} else if (selectedLcd == "") {
		LLYNX_Alert("선택된 공통코드가 없습니다.\n다시 선택해주세요.");
		return false;
	} else if ($("#comScd").val() == "") {
		LLYNX_Alert("상세코드를 입력해주세요.", 'comScd');
		return false;
	} else if (lcdData.userId == "") {
		LLYNX_Alert("로그인 상담원 정보가 존재하지 않습니다.\n다시 로그인해주세요.");
		return false;
	}
}

function scdDataReset() {
	scdData = { comLcd: "", comScd: "", chComScd: "", comSnm: "", useYn: "", note: "", sort: "", userId: loginInfo.userId };
	selectedScd = "";
	$("#comScd").val("");
	$("#comSnm").val("");
	$("#scdUseYn").val("Y");
	$("#scdSort").val("");
	$("#scdNote").val("");
}

function scdGridReset(){
	$("#scdGrid").clearGridData();
	$("#scdGrid").trigger("reloadGrid");
}