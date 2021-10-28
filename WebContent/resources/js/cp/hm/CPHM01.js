/**
 * 휴일관리
 */

var loginInfo = _getLoginInfo();


var holidayGrid = new webticsGrid();

var holidayColModel = [
	{label:"휴일ID", name:"id", align:"center", width:10},
	{label:"휴일명", name:"name", align:"left", width:120},
	//{label:"휴일유형", name:"holidayType", formatter:setHolidayType, align:"center", width:40},
	//{label:"선택", name:"campaigns", formatter:setRowCampagins, align:"left", width:150},
	{label:"일자", name:"date", align:"center", width:30},
	{label:"반복", name:"recurrent", formatter:booleanFormat, align:"center", width:30},
	{label:"활성화", name:"enabled", formatter:booleanFormat, align:"center", width:30}
];

var holidaySearchData = {
	currentPage:1,
	pageSize:15,
	order:"",
	sort:"",
	searchBy:"",
	searchValue:""
}

var holidayData = {
	name:"",
	holidayType:"",
	date:"",
	recurrent:false,
	enabled:false
}

//grid resize
$(window).bind("resize", function() {
	$("#holidayGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){
	$('#holidayDate').datepicker({dateFormat: 'yy-mm-dd'});
	$("#holidayDate").datepicker('setDate', new Date());

	holidayGrid.id("holidayGrid");
	holidayGrid.colModel(holidayColModel);
	holidayGrid.rowNum(holidaySearchData.pageSize);
	holidayGrid.call();

	//setCampListBox();

	$("#search").click();
});

$("#search").click(function(){
	holidayDataReset();
	setFirstSrch_holidayGrid();
	holidaySearch();
});

$("#schKeyword").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#schSort").change(function(){
	holidaySearchData.sort = $(this).val();
	holidaySearchData.order = $("#schOrder").val();
	holidaySearch();
});

$("#schOrder").change(function(){
	holidaySearchData.order =  $(this).val();
	holidaySearchData.sort =  $("#schSort").val();
	holidaySearch();
});

$("#holidayType").change(function(){
	var thisVal = $(this).val();
	if(thisVal=="Campaign"){
		$("#selectType").text("캠페인 선택");
		$(".selectCamp").show();
		$(".selectCountry").hide();

		$(".restrictionSelect").hide();
		$(".chColspan").attr("colspan", "1");

		$("#campListBox").jqxListBox("clearSelection");
		$("#selectCampaigns").text("");
	}else{
		$("#selectType").text("제한 완료코드 선택");
		$(".selectCamp").hide();

		$(".restrictionSelect").show();
		$(".chColspan").attr("colspan", "5");

		$(".selectCountry").show();
		$("#selectCompCodes").text("");
		$("#holidayRestrictionType").change();
	}
});

/*$("#holidayRestrictionType").change(function(){
	var thisVal = $(this).val();
	if(thisVal=="Permanent"){
		// 휴일 제약 유형이 영구제한일때
		$("#restrictionCompletioncode").prop("disabled", false);
	}else{
		// 휴일 제약 유형이 임시제한일때
		$("#restrictionCompletioncode").val("");
		$("#restrictionCompletioncode").prop("disabled", true);
	}
});*/

$("#reset").click(function(){
	holidayDataReset();
	$("#holidayNm").focus();
});

$("#save").click(function(){
	if(setHolidayData()){
		if(selectedHolidayId==""){
			LLYNX_Confirm("등록하시겠습니까?", "insertHoliday");
		}else{
			LLYNX_Confirm("수정하시겠습니까?", "updateHoliday");
		}
	}
});

function insertHoliday(){
	ECMService.insertAPI( "holidays", JSON.stringify(holidayData), function(result){
		if(result.result=="S"){
			LLYNX_Alert("등록되었습니다.");
			$("#search").click();
		}else{
			if(result.code!=null){
				LLYNX_Alert("휴일정보를 저장하는 중 에러가 발생하였습니다.\n"+"에러코드 : "+result.code+", 에러메시지 : "+result.message);
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function updateHoliday(){
	delete holidayData.name;
	ECMService.updateAPI("holidays/"+selectedHolidayId, JSON.stringify(holidayData), function(result){
		if(result.result=="S"){
			LLYNX_Alert("수정되었습니다.");
			$("#search").click();
		}else{
			if(result.code!=null){
				LLYNX_Alert("휴일정보를 저장하는 중 에러가 발생하였습니다.\n"+"에러코드 : "+result.code+", 에러메시지 : "+result.message);
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

$("#delete").click(function(){
	if(selectedHolidayId==""){
		LLYNX_Alert("선택된 휴일이 없습니다.");
	}else{
		LLYNX_Confirm("삭제하시겠습니까?", "deleteHoliday");
	}
});

function deleteHoliday(){
	ECMService.deleteAPI("holidays/"+selectedHolidayId, function(result){
		if(result.result=="S"){
			LLYNX_Alert("삭제되었습니다.");
			$("#search").click();
		}else{
			if(result.code!=null){
				LLYNX_Alert("휴일을 삭제하는 중 에러가 발생하였습니다.\n"+"에러코드 : "+result.code+", 에러메시지 : "+result.message);
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function validator(){
	if(firstYn_holidayGrid){
		holidaySearchDataReset();
		holidaySearchData.sort =  $("#schSort").val();
		holidaySearchData.order =  $("#schOrder").val();
		holidaySearchData.searchBy =  $("#schBy").val();
		holidaySearchData.searchValue =  $("#schKeyword").val();
	}
	holidaySearchData = getPageInfo_holidayGrid(holidaySearchData);
	return true;
}

function holidaySearch(){
	if(validator()){
		ECMService.getAPI("holidays", JSON.stringify(holidaySearchData), function(result){
			if(result.result=="S"){
				holidayGrid.setECMGrid(result);
				holidayGrid.setSelectRowFunc("holidaySelectRow");
			}else{
				if(result.code!=null){
					LLYNX_Alert("데이터를 가져오는 중 에러가 발생하였습니다.\n"+"에러코드 : "+result.code+", 에러메시지 : "+result.message);
				}else{
					LLYNX_Alert(result.msg);
				}
			}
		});
	}
}

function holidaySelectRow(rowData){
	holidayDataReset();
	selectedHolidayId = rowData.id;
	ECMService.getAPI("holidays/"+selectedHolidayId, function(result){
		$("#holidayNm").val(result.name);
		$("#holidayNm").prop("readonly", true);
		$("#holidayType").val(result.holidayType);
		$("#holidayType").change();

		if(result.holidayType=="Country"){
			$("#holidayRestrictionType").val(result.holidayRestrictionType);
			$("#holidayRestrictionType").change();
			/*if(result.holidayRestrictionType=="Permanent"){
				$("#restrictionCompletioncode").val(result.restrictionCompletioncode);
			}*/
		}else{
			if(result.campaigns!=null&&result.campaigns.length>0){
				for(var i=0;i<result.campaigns.length;i++){
					$("#campListBox").jqxListBox("selectItem", $("#campListBox").jqxListBox("getItemByValue", result.campaigns[i].campaignId));
				}
			}
		}
		$("#holidayDate").val(result.date);
		$("#recurrent").prop("checked", result.recurrent);
		$("#enabled").prop("checked", result.enabled);

	});
}

function holidaySearchDataReset(){
	holidaySearchData = { currentPage:1, pageSize:15, order:"", sort:"", searchBy:"", searchValue:"" };
}

function setHolidayData(){
	if($("#holidayNm").val()==""){
		LLYNX_Alert("휴일명을 입력해주세요.", "focus", "holidayNm");
		return false;
	}

	if($("#holidayType").val()==""){
		LLYNX_Alert("휴일 유형을 선택해주세요.", "focus", "holidayType");
		return false;
	}

	if($("#holidayDate").val()==""){
		LLYNX_Alert("휴일 날짜를 선택해주세요.", "focus", "holidayDate");
		return false;
	}

	holidayData.name = $("#holidayNm").val();
	//holidayData.holidayType = $("#holidayType").val();
	holidayData.holidayType = "Country"; // type 국가로 고정
	holidayData.date = $("#holidayDate").val().replace(/-/gi, "/");
	holidayData.recurrent = $("#recurrent").prop("checked");
	holidayData.enabled = $("#enabled").prop("checked");


	/*if($("#holidayType").val()=="Campaign"){
		var selectList = $("#campListBox").jqxListBox("getSelectedItems");
		if(selectList.length>0){
			holidayData.campaigns = [];
			for(var i=0;i<selectList.length;i++){
				var info = {};
				info.campaignId = selectList[i].value;
				holidayData.campaigns.push(info);
			}
		}
	}else{*/
		// holidayData.holidayRestrictionType = $("#holidayRestrictionType").val();
		holidayData.holidayRestrictionType = "Permanent";
		holidayData.restrictionCompletioncode = 71;
	//}


	return true;
}

function holidayDataReset(){
	selectedHolidayId="";
	holidayData = { name:"", holidayType:"", date:"", recurrent:false, enabled:false }
	$("#holidayNm").val("");
	$("#holidayNm").prop("readonly", false);
	$("#holidayDate").datepicker('setDate', new Date());
	$("#recurrent").prop("checked", false);
	$("#enabled").prop("checked", true);

	//$("#campListBox").jqxListBox("clearSelection");
	//$("#selectCampaigns").text("");


	//$("#holidayRestrictionType").val("Temporary");
	//$("#restrictionCompletioncode").val("");

	//$("#holidayType").val("Campaign");
	//$("#holidayType").change();
}

function setRowCampagins(value){
	if(value.length){
		var list = "";
		for(var i=0;i<value.length;i++){
			if(i==0){
				list+="["+value[i].name+"]";
			}else{
				list+=", ["+value[i].name+"]";
			}
		}
		return list;
	}else{
		return "";
	}
}

function setHolidayType(value){
	if(value=="Campaign"){
		return "캠페인";
	}else if(value=="Country"){
		return "국가";
	}else{
		return value;
	}
}