/**
 * 캠페인 관리
 */


var campContactlistInfo={};

var dncList = [];
var completioncodesList = [];
var completioncodesExcludedForAttemptCalculationList = [];
var exportDataCompletioncodesList = [];
var exportDataColumnsList = [];
var recorderAttributesList = [];

var campData = {}

$(document).ready(function(){
	//progressShow();
	setSkillList();
	setCampStrategy();
	setDNCList();
	setCompletioncodesList();
	setLinkedCampList();

	if(selectedCampId!=""){
		setOriginData();
	}
});

$("#applyDNC").change(function(){
	var items = $('#dncgroup').jqxListBox("getItems");
	if($("#applyDNC").prop("checked")){
		for(var i=0;i<items.length;i++){
			$('#dncgroup').jqxListBox("enableItem", items[i]);
		}
		$("#defaultDncgroup").prop("disabled", false);
	}else{
		for(var i=0;i<items.length;i++){
			$('#dncgroup').jqxListBox("disableItem", items[i]);
		}
		$("#defaultDncgroup").prop("disabled", true);
	}
});

$("#defaultDncgroup").change(function(){
	var thisVal = $(this).val();
	var dncItems = $("#dncgroup").jqxListBox("getItems");
	var dncgroupId = "";
	for(i=0;i<dncItems.length;i++){
		if(dncItems[i].label==thisVal){
			dncgroupId = dncItems[i].value;
		}
	}
	ECMService.getAPI("dncgroups/"+dncgroupId, function(result){
		console.log(result);
		if(result.result=="S"){
			if(result.defaultDnclistName==null){
				LLYNX_Alert("선택하신 DNC그룹의 기본DNC그룹이 설정되어있지않습니다.");
				$("#defaultDncgroup").val("");
			}
		}else{
			LLYNX_Alert("기본 DNC그룹 검증 중 오류가 발생하였습니다.");
		}
	});
});

$("#exportContacts").change(function(){
	if($(this).prop("checked")){
		$(".exportTr").show();
	}else{
		$(".exportTr").hide();
	}
});

$("#recorderAttributesYn").change(function(){
	var items = $('#recorderAttributes').jqxListBox("getItems");
	if($("#recorderAttributesYn").prop("checked")){
		for(var i=0;i<items.length;i++){
			$('#recorderAttributes').jqxListBox("enableItem", items[i]);
		}
	}else{
		for(var i=0;i<items.length;i++){
			$('#recorderAttributes').jqxListBox("disableItem", items[i]);
		}
	}
});

$("#campStrategy").change(function(){
	var val = $(this).val();
	if(val.indexOf("Agentless")!=-1||val.indexOf("agentless")!=-1){
		$("#agentSkillId").val("");
		$("#agentSkillId").prop("disabled", true);
	}else{
		$("#agentSkillId").prop("disabled", false);
	}
});

$(".contactSelect").change(function(){
	var names=[];
	for(var i=0;i<$(".contactSelect").length;i++){
		if($(".contactSelect").eq(i).val()!=""){
			names.push($(".contactSelect").eq(i).val());
		}
	}
	setRecorderAttributesList(names);
});

/************************* 버튼이벤트 **********************************/

$("#contactListSelect").click(function(){
	if(selectedCampId!=""){
		popupOpen("/cp/cpcm02.do?campId="+selectedCampId);
	}else{
		popupOpen("/cp/cpcm02.do");
	}
});

$("#save").click(function(){
	if(setCampData()){
		console.log(campData);
		if(selectedCampId==""){
			LLYNX_Confirm("등록하시겠습니까?", "insertCamp");
		}else{
			LLYNX_Confirm("수정하시겠습니까?", "updateCamp");
		}
	}
});

function insertCamp(){
	progressShow();
	ECMService.insertAPI("campaigns", JSON.stringify(campData), function(result){
		progressHide();
		if(result.result=="S"){
			$("#ifr_tabs-PG_CPCM_01", parent.document)[0].contentWindow.campSearch();
			LLYNX_Alert("등록되었습니다.", "close");
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function updateCamp(){
	progressShow();
	ECMService.updateAPI("campaigns/"+selectedCampId, JSON.stringify(campData), function(result){
		progressHide();
		console.log(result);
		if(result.result=="S"){
			$("#ifr_tabs-PG_CPCM_01", parent.document)[0].contentWindow.campSearch();
			LLYNX_Alert("수정되었습니다.", "close");
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

/************************* 리스트박스 이벤트 **********************************/

$("#dncgroup").on('change', function(){
	// 기본 DNC리스트 option 설정
	var selectedItems = $("#dncgroup").jqxListBox("getSelectedItems");
	var options='<option value="">-기본 DNC그룹-</option>';
	for(var i=0;i<selectedItems.length;i++){
		options+='<option>'+selectedItems[i].label+'</option>'
	}
	$("#defaultDncgroup").html(options);
});

/*$("#dncgroup").on('select', function(event){
	var item = event.args.item;
	ECMService.getAPI("dncgroups/"+item.value, function(result){
		if(result.result=="S"){
			var option = "";
			if(result.defaultDnclistId!=0){
				option = '<option>'+result.name+'</option>';
				$("#defaultDncgroup").append(option);
			}
		}
	});
});

$("#dncgroup").on('unselect', function(event){
	var item = event.args.item;
	$("#defaultDncgroup option").each(function(){
		if($(this).text()==item.label){
			$(this).remove();
		}
	});
});*/

$('#completioncodes').on('select', function (event) {
    var item = event.args.item;
    if(item.value=="ALL"){
		var items = $('#completioncodes').jqxListBox("getItems");
		var selectedItems = $('#completioncodes').jqxListBox("getSelectedItems");
		if(selectedItems.length<items.length-1){
			$('#completioncodes').jqxListBox("clearSelection");
			for(var i=0;i<items.length;i++){
				if(i>0){
					$('#completioncodes').jqxListBox("selectItem", items[i]);
				}
			}
		}else{
			$('#completioncodes').jqxListBox("clearSelection");
		}
	}
});

$('#completioncodesExcludedForAttemptCalculation').on('select', function (event) {
    var item = event.args.item;
    if(item.value=="ALL"){
		var items = $('#completioncodesExcludedForAttemptCalculation').jqxListBox("getItems");
		var selectedItems = $('#completioncodesExcludedForAttemptCalculation').jqxListBox("getSelectedItems");
		if(selectedItems.length<items.length-1){
			$('#completioncodesExcludedForAttemptCalculation').jqxListBox("clearSelection");
			for(var i=0;i<items.length;i++){
				if(i>0){
					$('#completioncodesExcludedForAttemptCalculation').jqxListBox("selectItem", items[i]);
				}
			}
		}else{
			$('#completioncodesExcludedForAttemptCalculation').jqxListBox("clearSelection");
		}
	}
});

$('#recorderAttributes').on('select', function (event) {
    var item = event.args.item;
    if(item.value=="ALL"){
		var items = $('#recorderAttributes').jqxListBox("getItems");
		var selectedItems = $('#recorderAttributes').jqxListBox("getSelectedItems");
		if(selectedItems.length<items.length-1){
			$('#recorderAttributes').jqxListBox("clearSelection");
			for(var i=0;i<items.length;i++){
				if(i>0){
					$('#recorderAttributes').jqxListBox("selectItem", items[i]);
				}
			}
		}else{
			$('#recorderAttributes').jqxListBox("clearSelection");
		}
	}
});

/*$('#exportDataColumns').on('select', function (event) {
    var item = event.args.item;
    if(item.value=="ALL"){
		var items = $('#exportDataColumns').jqxListBox("getItems");
		for(var i=0;i<items.length;i++){
			if(i>0){
				$('#exportDataColumns').jqxListBox("disableItem", items[i]);
			}
		}
	}
});

$('#exportDataColumns').on('unselect', function (event) {
    var item = event.args.item;
    if(item.value=="ALL"){
		var items = $('#exportDataColumns').jqxListBox("getItems");
		for(var i=0;i<items.length;i++){
			if(i>0){
				$('#exportDataColumns').jqxListBox("enableItem", items[i]);
			}
		}
	}
});

$('#exportDataCompletioncodes').on('select', function (event) {
    var item = event.args.item;
    if(item.value=="ALL"){
		var items = $('#exportDataCompletioncodes').jqxListBox("getItems");
		for(var i=0;i<items.length;i++){
			if(i>0){
				$('#exportDataCompletioncodes').jqxListBox("disableItem", items[i]);
			}
		}
	}
});

$('#exportDataCompletioncodes').on('unselect', function (event) {
    var item = event.args.item;
    if(item.value=="ALL"){
		var items = $('#exportDataCompletioncodes').jqxListBox("getItems");
		for(var i=0;i<items.length;i++){
			if(i>0){
				$('#exportDataCompletioncodes').jqxListBox("enableItem", items[i]);
			}
		}
	}
});*/




/************************* 초기 select, 리스트박스 세팅 이벤트 **********************************/


function setSkillList(){
	ECMService.getAPI("agents/skills", JSON.stringify({currentPage:1, pageSize:1000}), function(result){
		if(result.result=="S"){
			var options = '<option value="">-상담원 스킬-</option>';
			for(var i=0;i<result.contents.length;i++){
				options += '<option value="'+result.contents[i].id+'">'+result.contents[i].name+'</option>'
			}
			$("#agentSkillId").html(options);
		}else{
			if(result.code!=null){
					LLYNX_Alert(ECMError(result.code, result.message));
				}else{
					LLYNX_Alert(result.msg);
				}
		}
	});
}

function setCampStrategy(){
	ECMService.getAPI("strategies", JSON.stringify({currentPage:1, pageSize:1000}), function(result){
		if(result.result=="S"){
			var options = '<option value="">-캠페인 전략-</option>';
			for(var i=0;i<result.contents.length;i++){
				if(result.contents[i].strategyType=="Completed"){
					options += '<option>'+result.contents[i].name+'</option>'
				}
			}
			$("#campStrategy").html(options);
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function setLinkedCampList(){
	ECMService.getAPI("campaigns", JSON.stringify({currentPage:1, pageSize:1000}), function(result){
		progressHide();
		if(result.result=="S"){
			var options = '<option value="">-캠페인 선택-</option>';
			for(var i=0;i<result.contents.length;i++){
				if(selectedCampId!=""){
					if(selectedCampId!=result.contents[i].id){
						options += '<option value="'+result.contents[i].id+'">'+result.contents[i].name+'</option>'
					}
				}else{
					options += '<option value="'+result.contents[i].id+'">'+result.contents[i].name+'</option>'
				}
			}
			$("#linkedCampaignId").html(options);
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function setDNCList(){
	ECMService.getAPI("dncgroups", JSON.stringify({currentPage:1, pageSize:1000}), function(result){
		if(result.result=="S"){
			$("#dncgroup").jqxListBox({ source: null, multiple: true, width: 250, height: 150});
			for(var i=0;i<result.contents.length;i++){
				$("#dncgroup").jqxListBox("addItem", {value:result.contents[i].id, label:result.contents[i].name});
			}
			$("#applyDNC").change();
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function setCompletioncodesList(){
	SYCP01_Service.getCompleteCodes({schType:"Custom"}, function(result){
		if(result.result=="S"){
			$("#completioncodes").jqxListBox({ source: null, multiple: true, width: "100%", height: 185});
			if(result.list.length>0){
				$("#completioncodes").jqxListBox("addItem", {value:"ALL", label:"전체"});
			}
			for(var i=0;i<result.list.length;i++){
				$("#completioncodes").jqxListBox("addItem", {value:result.list[i].name, label:result.list[i].krName});
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

/*function setCompletioncodesExcludedForAttemptCalculationList(){
	SYCP01_Service.getCompleteCodes({schType:""}, function(result){
		if(result.result=="S"){
			$("#completioncodesExcludedForAttemptCalculation").jqxListBox({ source: null, multiple: true, width: 300, height: 150});
			if(result.list.length>0){
				$("#completioncodesExcludedForAttemptCalculation").jqxListBox("addItem", {value:"ALL", label:"전체"});
			}
			for(var i=0;i<result.list.length;i++){
				$("#completioncodesExcludedForAttemptCalculation").jqxListBox("addItem", {value:result.list[i].name, label:result.list[i].krName});
			}
		}else{
			LLYNX_Alert(result.msg);
		}
	});
}*/

/*function setExportDataCompletioncodesList(){
	SYCP01_Service.getCompleteCodes({schType:""}, function(result){
		if(result.result=="S"){
			$("#exportDataCompletioncodes").jqxListBox({ source: null, multiple: true, width: 300, height: 150});
			if(result.list.length>0){
				$("#exportDataCompletioncodes").jqxListBox("addItem", {value:"ALL", label:"전체"});
			}
			for(var i=0;i<result.list.length;i++){
				$("#exportDataCompletioncodes").jqxListBox("addItem", {value:result.list[i].name, label:result.list[i].krName});
			}
		}else{
			LLYNX_Alert(result.msg);
		}
	});
}*/

/*function setExportDataColumnsList(){
	ECMService.getAPI("attributes", JSON.stringify({currentPage:1, pageSize:1000}), function(result){
		if(result.result=="S"){
			$("#exportDataColumns").jqxListBox({ source: null, multiple: true, width: 250, height: 150});
			if(result.contents.length>0){
				$("#exportDataColumns").jqxListBox("addItem", {value:"ALL", label:"전체"});
			}
			for(var i=0;i<result.contents.length;i++){
				if(result.contents[i].attributeType=="Predefined"){
					$("#exportDataColumns").jqxListBox("addItem", {value:result.contents[i].name,label:setcontactPropertyName01(result.contents[i].contactPropertyName)});
				}
			}

		}else{
			if(result.code!=null){
				LLYNX_Alert("데이터를 가져오는 중 에러가 발생하였습니다.\n"+"에러코드 : "+result.code+", 에러메시지 : "+result.message);
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}*/


function setRecorderAttributesList(contactlistNames, callback){
	if(contactlistNames!=null&&contactlistNames.length>0){
		console.log(contactlistNames)
		ECMService.getAPI("contactlists", JSON.stringify({currentPage:1, pageSize:1000}), function(result){
			if(result.result=="S"){
				var contactlistList = result.contents;
				var contactlistIds = "";
				for(var i=0;i<contactlistNames.length;i++){
					for(var j=0;j<contactlistList.length;j++){
						if(contactlistNames[i]==contactlistList[j].name){
							if(i==0){
								contactlistIds+=contactlistList[j].id;
							}else{
								contactlistIds+=","+contactlistList[j].id;
							}
						}

					}
				}
				console.log(contactlistIds);
				ECMService.getAPI("contactlists/attributes?contactlistIds="+contactlistIds, function(result){
					if(result.result=="S"){
						// console.log(result);
						$("#recorderAttributes").jqxListBox({ source: null, multiple: true, width: "100%", height: 150});
						if(result.contents.length>2){
							$("#recorderAttributes").jqxListBox("addItem", {value:"ALL", label:"전체"});
						}
						if(result.contents.length>0){
							for(var i=0;i<result.contents.length;i++){
								$("#recorderAttributes").jqxListBox("addItem", {value:result.contents[i].name,label:setcontactPropertyName01(result.contents[i].contactPropertyName)});
							}
							$("#recorderAttributesYn").change();
						}
						if(callback!=null&&callback!=undefined){
							callback();
						}
					}else{
						if(result.code!=null){
							LLYNX_Alert(ECMError(result.code, result.message));
						}else{
							LLYNX_Alert(result.msg);
						}
					}
				});
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



/************************* 그리드 및 데이터 이벤트 **********************************/

var campContactInfo = {};

var applySameFilterTemplate = false;
var defaultFilter = "";

function setOriginData(){
	progressShow();
	//console.log(selectedCampId);
	ECMService.getAPI("campaigns/"+selectedCampId, JSON.stringify({campaignId:selectedCampId}), function(result){
		progressHide();
		if(result.result=="S"){
			//console.log(result);
			campContactlistInfo.contactlists = result.contactlists;
			campContactlistInfo.applySameFilterTemplate = result.applySameFilterTemplate;
			setRecorderAttributesList(function(){
				if(result.recorderAttributes!=null){
					$("#recorderAttributesYn").prop("checked", true);
					$("#recorderAttributesYn").change();
					for(var j=0;j<result.recorderAttributes.length;j++){
						$("#recorderAttributes").jqxListBox('selectItem', $("#recorderAttributes").jqxListBox('getItemByValue', result.recorderAttributes[j]));
					}
				}
			});
			$("#campNm").val(result.name);
			$("#applyDNC").prop("checked", result.applyDNC);
			$("#applyDNC").change();
			$("#campType").val(result.campaignType);
			$("#campStrategy").val(result.strategyName);
			$("#agentSkillId").val(result.agentSkillId);
			$("#description").val(result.description);
			$("#displayAddress").val(result.displayAddress);
			$("#displayName").val(result.displayName);
			$("#recorderAttributesYn").prop("checked", result.sendAttributesToEventSDKRecorder);
			/*$("#exportContacts").prop("checked", result.exportContacts);
			$("#exportContacts").change();
			$("input:radio[name=exportFrequencyType]:radio[value='"+result.exportFrequencyType+"']").prop("checked", true);
			if(result.exportFrequencyType!=""){
				if(result.exportFrequencyType=="EVERY_N_MINS"){
					$("#exportFrequencyValue_min").val(result.exportFrequencyValue);
				}else if(result.exportFrequencyType=="DAILY_AT"){
					$("#exportFrequencyValue_daily").val(result.exportFrequencyValue);
				}
			}*/
			$("#linkedCampaignId").val(result.linkedCampaignId);

			if(result.dncgroups!=null){
				var dncItems = $("#dncgroup").jqxListBox("getItems");
				for(var j=0;j<result.dncgroups.length;j++){
					//$("#dncgroup").jqxListBox('selectItem', $("#dncgroup").jqxListBox('getItemByValue', result.dncgroups[j]));
					for(var i=0;i<dncItems.length;i++){
						if(dncItems[i].label==result.dncgroups[j]){
							$("#dncgroup").jqxListBox('selectItem', dncItems[i]);
						}
					}
				}
				$("#defaultDncgroup").val(result.defaultDncgroup);
			}

			if(result.completioncodes!=null){
				for(var j=0;j<result.completioncodes.length;j++){
					$("#completioncodes").jqxListBox('selectItem', $("#completioncodes").jqxListBox('getItemByValue',result.completioncodes[j]));
				}
			}

			/*if(result.completioncodesExcludedForAttemptCalculation!=null){
				for(var j=0;j<result.completioncodesExcludedForAttemptCalculation.length;j++){
					$("#completioncodesExcludedForAttemptCalculation").jqxListBox('selectItem', $("#completioncodesExcludedForAttemptCalculation").jqxListBox('getItemByValue',result.completioncodesExcludedForAttemptCalculation[j]));
				}
			}*/

			/*if(result.exportDataCompletioncodes!=null){
				for(var j=0;j<result.exportDataCompletioncodes.length;j++){
					$("#exportDataCompletioncodes").jqxListBox('selectItem', $("#completioncodes").jqxListBox('getItemByValue',result.exportDataCompletioncodes[j]));
				}
			}

			if(result.exportDataColumns!=null){
				for(var j=0;j<result.exportDataColumns.length;j++){
					$("#exportDataColumns").jqxListBox('selectItem', $("#exportDataColumns").jqxListBox('getItemByValue', result.exportDataColumns[j]));
				}
			}*/

			if(campContactlistInfo.contactlists.length>0){
				for(var i=0;i<campContactlistInfo.contactlists.length;i++){
					if(i==0){
						$(".contactRows").eq(i).find(".contactSelect").val(campContactlistInfo.contactlists[i].contactList);
						$(".contactRows").eq(i).find(".contactSelect").change();
						$(".contactRows").eq(i).find(".filterSelect").val(campContactlistInfo.contactlists[i].filterTemplateName);
						$("#applySameFilterTemplate").prop("checked", campContactlistInfo.applySameFilterTemplate);
						applySameFilterTemplate = campContactlistInfo.applySameFilterTemplate;
						if(campContactlistInfo.applySameFilterTemplate){
							applySameFilterTemplate = campContactlistInfo.applySameFilterTemplate;
							defaultFilter = campContactlistInfo.contactlists[i].filterTemplateName;
							$("#applySameFilterTemplate").change();
						}
					}else{
						addList(campContactlistInfo.contactlists[i].contactList, campContactlistInfo.contactlists[i].filterTemplateName);
					}
				}
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


function setCampData(){
	campData={};
	if($("#campNm").val()==""){
		LLYNX_Alert("캠페인명을 입력해주세요.", 'campNm');
		return false;
	}

	if($("#campType").val()==""){
		LLYNX_Alert("캠페인유형을 선택해주세요.", 'campType');
		return false;
	}


	campData.campaignName = $("#campNm").val();
	campData.description = $("#description").val();
	campData.campaignType = $("#campType").val();
	campData.campaignStrategy = $("#campStrategy").val();


	campData.applyDNC = $("#applyDNC").prop("checked");
	if($("#applyDNC").prop("checked")){
		var items = $("#dncgroup").jqxListBox("getSelectedItems");
		campData.dncgroups=[];
		for(var i=0;i<items.length;i++){
			campData.dncgroups.push(items[i].label);
		}
		campData.defaultDncgroup = $("#defaultDncgroup").val();
	}

	if(campData.applyDNC&&campData.defaultDncgroup==""){
		LLYNX_Alert("기본 DNC그룹을 선택해주세요.");
		return false;
	}

	campData.applySameFilterTemplate = campContactlistInfo.applySameFilterTemplate;
	campData.contactlists = campContactlistInfo.contactlists;

	var completioncodesItems = $("#completioncodes").jqxListBox("getSelectedItems");
	if(completioncodesItems.length>0){
		campData.completioncodes=[];
		for(var i=0;i<completioncodesItems.length;i++){
			campData.completioncodes.push(completioncodesItems[i].value);
		}
	}

	/*var completioncodesExcludedForAttemptCalculationItems = $("#completioncodesExcludedForAttemptCalculation").jqxListBox("getSelectedItems");
	if(completioncodesExcludedForAttemptCalculationItems.length>0){
		campData.completioncodesExcludedForAttemptCalculation=[];
		for(var i=0;i<completioncodesExcludedForAttemptCalculationItems.length;i++){
			campData.completioncodesExcludedForAttemptCalculation.push(completioncodesExcludedForAttemptCalculationItems[i].value);
		}
	}*/

	campData.agentSkillId = $("#agentSkillId").val();

	campData.displayAddress = $("#displayAddress").val();
	campData.displayName = $("#displayName").val();

	/*campData.exportContacts = $("#exportContacts").prop("checked");
	if($("#exportContacts").prop("checked")){
		var exportDataColumnsItems = $("#exportDataColumns").jqxListBox("getSelectedItems");
		if(exportDataColumnsItems.length>0){
			campData.exportDataColumns=[];
			for(var i=0;i<exportDataColumnsItems.length;i++){
				campData.exportDataColumns.push(exportDataColumnsItems[i].value);
			}
		}

		var exportDataCompletioncodesItems = $("#exportDataCompletioncodes").jqxListBox("getSelectedItems");
		if(exportDataCompletioncodesItems.length>0){
			campData.exportDataCompletioncodes=[];
			for(var i=0;i<exportDataCompletioncodesItems.length;i++){
				campData.exportDataCompletioncodes.push(exportDataCompletioncodesItems[i].value);
			}
		}

		campData.exportFrequencyType = $("input:radio[name=exportFrequencyType]:checked").val();
		if($("input:radio[name=exportFrequencyType]:checked").val()=="EVERY_N_MINS"){
			if(isNaN($("#exportFrequencyValue_min").val())){
				LLYNX_Alert("내보내기빈도유형을 N분마다를 선택하셨을 경우 내보내기 빈도값을 숫자로만 넣어야합니다.");
				return false;
			}else if($("#exportFrequencyValue_min").val()<15||$("#exportFrequencyValue_min").val()>10080){
				LLYNX_Alert("내보내기빈도유형을 N분마다를 선택하셨을 경우 내보내기 빈도값은\n 15~10080분까지 입력하실 수 있습니다.");
				return false;
			}
			campData.exportFrequencyValue = $("#exportFrequencyValue_min").val();

		}else if($("input:radio[name=exportFrequencyType]:checked").val()=="DAILY_AT"){
			campData.exportFrequencyValue = $("#exportFrequencyValue_daily").val();
		}



	}*/

	if($("#recorderAttributesYn").prop("checked")){
		var recorderAttributesItems = $("#recorderAttributes").jqxListBox("getSelectedItems");
		if(recorderAttributesItems.length>0){
			campData.recorderAttributes=[];
			for(var i=0;i<recorderAttributesItems.length;i++){
				campData.recorderAttributes.push(recorderAttributesItems[i].value);
			}
		}
	}
	campData.linkedCampaignId = $("#linkedCampaignId").val();

	tempContactlists = [];
	var dupYn = false;
	campData.applySameFilterTemplate = $("#applySameFilterTemplate").prop("checked");
	$(".contactRows").each(function(){
		var contactSelect = $(this).find(".contactSelect").val();
		var filterSelect = $(this).find(".filterSelect").val();
		var rowInfo={};
		if(contactSelect!=""){
			rowInfo.contactList = contactSelect;
			rowInfo.filterTemplateName = filterSelect;
			if(tempContactlists.length>0){
				for(var i=0;i<tempContactlists.length;i++){
					if(tempContactlists[i].contactList==rowInfo.contactList){
						dupYn = true;
					}
				}
			}

			tempContactlists.push(rowInfo);
		}
	});

	if(dupYn){
		LLYNX_Alert("컨택리스트가 중복선택되었습니다.");
		return false;
	}

	if(tempContactlists.length==0){
		LLYNX_Alert("적어도 하나의 컨택리스트를 선택해야합니다.");
		return false;
	}else{
		campData.contactlists = tempContactlists;
	}


	return true;
}

function campDataReset(){
	selectedCampId="";
	campData={};
	campContactlistInfo.length=0;
	$("#campNm").val("");
	$("#applyDNC").prop("checked", false);
	$("#campType").val("");
	$("#campStrategy").val("");
	$("#agentSkillId").val("");
	$("#defaultDncgroup").val("");
	$("#description").val("");
	$("#displayAddress").val("");
	$("#displayName").val("");
	$("#dncgroup").jqxListBox("clearSelection");
	$("#completioncodes").jqxListBox("clearSelection");
	/*$("#completioncodesExcludedForAttemptCalculation").jqxListBox("clearSelection");*/
	$("#recorderAttributes").jqxListBox("clearSelection");
	/*$("input:radio[name=exportFrequencyType]").prop("checked",false);
	$("#exportFrequencyValue_min").val("");
	$("#exportFrequencyValue_daily").val("");*/
	$("#linkedCampaignId").val("");
	$("#recorderAttributesYn").prop("checked", false);
	$("#recorderAttributesYn").change();
	/*$("#exportDataColumns").jqxListBox("clearSelection");
	$("#exportDataCompletioncodes").jqxListBox("clearSelection");*/


	$("#exportContacts").prop("checked", false);
	$("#exportContacts").change();
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

/** 컨택리스트 선택 */

$("#applySameFilterTemplate").change(function(){
	if($(this).prop("checked")){
		if($("#filterTemplate_0").val()==""){
			applySameFilterTemplate = false;
			$(this).prop("checked", false);
			LLYNX_Alert("적용할 필터 템플릿을 설정해주세요.");
		}else{
			applySameFilterTemplate = true;
			defaultFilter = $("#filterTemplate_0").val();
			$(".filterSelect").val(defaultFilter);
			$(".filterSelect").attr("disabled", true);
		}
	}else{
		applySameFilterTemplate = false;
		defaultFilter="";
		$(".filterSelect").attr("disabled", false);
	}
});

$("#addList").click(function(){
	addList();
});

function addList(contactValue, filterValue){
	var row = '<tr class="contactRows"><th scope="row">컨택리스트</th><td><select title="컨택리스트 선택" class="contactSelect">';


	ECMService.getAPI("contactlists", JSON.stringify({currentPage:1, pageSize:1000}), function(result){
		if(result.result=="S"){
			var contactOptions = '<option value="">-컨택리스트 선택-</option>';
			for(var i=0;i<result.contents.length;i++){
				if(contactValue!=""&&contactValue!=null&&contactValue!=undefined){
					if(contactValue == result.contents[i].name){
						contactOptions += '<option selected>'+result.contents[i].name+'</option>'
					}else{
						contactOptions += '<option>'+result.contents[i].name+'</option>'
					}

				}else{
					contactOptions += '<option>'+result.contents[i].name+'</option>'
				}
			}
			row += contactOptions+'</select></td>';
			row += '<th scope="row">필터 템플릿</th><td><select title="필터템플릿 선택" class="filterSelect">';
			ECMService.getAPI("filtertemplates", JSON.stringify({currentPage:1, pageSize:1000}), function(result){
				if(result.result=="S"){
					var filterOptions = '<option value="">-필터템플릿 선택-</option>';
					for(var i=0;i<result.contents.length;i++){
						if(applySameFilterTemplate){
							if(result.contents[i].name==defaultFilter){
								filterOptions += '<option selected>'+result.contents[i].name+'</option>';
							}else{
								filterOptions += '<option>'+result.contents[i].name+'</option>';
							}
						}else{
							if(filterValue!=""&&filterValue!=null&&filterValue!=undefined){
								if(filterValue == result.contents[i].name){
									filterOptions += '<option selected>'+result.contents[i].name+'</option>';
								}else{
									filterOptions += '<option>'+result.contents[i].name+'</option>';
								}
							}else{
								filterOptions += '<option>'+result.contents[i].name+'</option>';
							}
						}
					}
					row += filterOptions+'</select><button type="button" class="btn btn_primary btn_size_n ml_10 del_row"><i class="xi-trash"></i>삭제</button></td></tr>';
					$("#rows").append(row);

					if(applySameFilterTemplate){
						$(".filterSelect").attr("disabled", true);
					}

					$(".del_row").click(function(){
						var thisRow = $(this).closest("tr");
						thisRow.remove();
					});

					$(".contactSelect").change(function(){
						var names=[];
						for(var i=0;i<$(".contactSelect").length;i++){
							if($(".contactSelect").eq(i).val()!=""){
								names.push($(".contactSelect").eq(i).val());
							}
						}
						setRecorderAttributesList(names);
					});
				}else{
					if(result.code!=null){
						LLYNX_Alert(ECMError(result.code, result.message));
					}else{
						LLYNX_Alert(result.msg);
					}
				}
			});

		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}
