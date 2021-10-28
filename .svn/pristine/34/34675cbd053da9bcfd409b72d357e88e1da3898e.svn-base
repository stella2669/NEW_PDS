/**
 * 스킬관리
 */

var loginInfo = _getLoginInfo();

var selectedSkillCdCd = "";

var skillGrid = new webticsGrid();

var skillColModel = [
	{ name: "skillCd", label: "스킬코드", width: 80, align: "center" },
	{ name: "skillNm", label: "스킬명", width: 80, align: "center" },
	{ name: "skillType", label: "스킬유형코드", hidden: true },
	{ name: "skillTypeNm", label: "스킬유형", width: 80, align: "center" },
	{ name: "useYn", label: "사용여부", width: 40, align: "center" },
	{ name: "bigo", label: "비고", width: 100, align: "left" }
];

var skillSearchData = {
	schSkillNm: "",
	schSkillType: "",
	schUseYn: ""
}

var skillData = {
	chSkillCdCd: "",
	skillCd: "",
	skillNm: "",
	skillType: "",
	useYn: "",
	note: "",
	userId: loginInfo.userId
}

//grid resize
$(window).bind("resize", function() {
	$("#skillGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function() {
	skillGrid.id("skillGrid");
	skillGrid.colModel(skillColModel);
	skillGrid.rowNum(1000);
	skillGrid.call();

	$("#search").click();
	$("#schSkillCdNm").focus();
});

$("#search").click(function() {
	skillDataReset();
	skillSearchDataReset();
	skillSearch();
});

$("#schSkillCdNm").keyup(function(e) {
	if (e.keyCode == 13) {
		$("#search").click();
	}
});

$("#skillNew").click(function() {
	skillDataReset();
});

$("#skillSave").click(function() {
	if (selectedSkillCd == "") {
		if (setSkillData()) {
			if(confirm('저장 하시겠습니까?')){
				USSM01_Service.dupCheckSkill(skillData, function(result){
					if(result.result=="S"){
						USSM01_Service.insertSkill(skillData, function(rslt) {
							if (rslt.result == "S") {
								LLYNX_Alert("저장되었습니다.");
								skillSearch();
							} else {
								alert(rslt.msg);
							}
							skillDataReset();
						});
					}else{
						LLYNX_Alert("이미 존재하는 스킬코드입니다.");
					}
				});
			}

		}
	} else {
		if (setSkillData()) {
			USSM01_Service.updateSkill(skillData, function(rslt) {
				if (rslt.result == "S") {
					LLYNX_Alert("수정 되었습니다.");
					skillSearch();
				} else {
					alert(rslt.msg);
				}
				skillDataReset();
			});
		}
	}
});

$("#skillDel").click(function() {
	if (selectedSkillCd == "") {
		LLYNX_Alert("선택된 공통코드가 없습니다.");
	} else {
		if (setSkillData()) {
			USSM01_Service.deleteSkill(skillData, function(rslt) {
				if (rslt.result == "S") {
					LLYNX_Alert("삭제 되었습니다.");
					skillSearch();
				} else {
					alert(rslt.msg);
				}
				skillDataReset();
			});
		}
	}
});

function skillSearch() {
	if (skillValidator()) {
		progressShow();
		USSM01_Service.getSkillList(skillSearchData, function(result) {
			progressHide();
			if (result.result == "S") {
				skillGrid.setGrid(result);
				skillGrid.setSelectRowFunc("skillSelectRow");
			} else {
				LLYNX_Alert(result.msg);
			}
		});
	}
}

function skillValidator() {
	skillSearchData.schSkillNm = $("#schSkillNm").val();
	skillSearchData.schSkillType = $("#schSkillType").val();
	skillSearchData.schUseYn = $("#schUseYn").val();
	return true;
}

function skillSearchDataReset() {
	skillSearchData = { schSkillNm: "", schSkillType: "", schUseYn: "" }
}

function skillSelectRow(rowData) {
	skillDataReset();
	selectedSkillCd = rowData.skillCd;
	$("#skillCd").val(rowData.skillCd);
	$("#skillNm").val(rowData.skillNm);
	$("#skillType").val(rowData.skillType);
	$("#useYn").val(rowData.useYn);
	$("#note").val(rowData.bigo);
}


function setSkillData() {

	if (skillData.userId=="") {
		LLYNX_Alert("로그인 사용자 정보가 존재하지 않습니다.");
		return false;
	}

	if ($("#skillCd").val()=="") {
		LLYNX_Alert("스킬코드를 입력해주세요.");
		$("#skillCd").focus();
		return false;
	}

	if($("#skillType").val()==""){
		LLYNX_Alert("스킬유형을 선택해주세요.");
		$("#skillType").focus();
		return false;
	}

	if (selectedSkillCd != "") {
		skillData.skillCd = selectedSkillCd;
	} else {
		skillData.skillCd = $("#skillCd").val();
	}
	skillData.chSkillCd = $("#skillCd").val();
	skillData.skillNm = $("#skillNm").val();
	skillData.skillType = $("#skillType").val();
	skillData.useYn = $("#useYn").val();
	skillData.note = $("#note").val();
	return true;

}

function skillDataReset() {
	skillData = {skillCd: "", chSkillCd: "", skillNm: "", skillType:"", useYn: "", note: "", userId: loginInfo.userId };
	selectedSkillCd = "";
	$("#skillCd").val("");
	$("#skillNm").val("");
	$("#skillType").val("");
	$("#useYn").val("Y");
	$("#note").val("");
}
