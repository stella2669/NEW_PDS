/**
 * 일정관리
 */

var scheduleGrid = new webticsGrid();

var scheduleColModel = [
	{label: "일정ID", name: "id", width:20, align: "center", key:true},
	// {label: "일정명", name: "name", width:70, align: "left"},
	{label: "캠페인/데이터소스ID", hidden:true},
	{label: "캠페인/데이터소스명", name: "entityName", width:70, align: "left"},
	{label: "일정 유형", name: "scheduleType", formatter : setName01, width:40, align: "center"},
	{label: "반복여부", name: "recurring", formatter : recurringYn, width:30, align: "center"},
	{label: "반복주기", name: "recurringInfo", formatter : frequencyNm, width:60, align: "center"},
	{label: "시간대", name: "timeZone", width:50, align: "center"},
	{label: "시작시간", name: "startTime", formatter:momentDateFormat, width:50, align: "center"},
	{label: "완료시간", name: "endTime", formatter:momentDateFormat, width:50, align: "center"},
	{label: "활성화", name: "scheduleState", formatter:scheduleStateNm, width:20, align: "center"},
	{label: "반복주기", name: "frequency", hidden:true},
	{label: "요일", name: "weekDays", hidden:true},
	{label: "크론표현식", name: "cronExpression", hidden:true}
];

var scheduleSearchData = {
	currentPage : 1,
	pageSize : 15,
	sort : "id",
	searchBy : "",
	searchValue : ""
}

//grid resize
$(window).bind("resize", function() {
	$("#scheduleGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function(){
	scheduleGrid.id("scheduleGrid");
	scheduleGrid.colModel(scheduleColModel);
	scheduleGrid.rowNum(scheduleSearchData.pageSize);
	scheduleGrid.call();

	$("#recurringFrequency").change();
	$("#search").click();
	$("#schKeyword").focus();
});

$("#search").click(function(){
	scheduleSearchDataReset();
	setFirstSrch_scheduleGrid();
	scheduleSearch();
});

$("#schKeyword").keyup(function(event){
	if(event.keyCode==13){
		$("#search").click();
	}
});

$("#schSort").change(function(){
	scheduleSearchData.sort = $(this).val();
	scheduleSearchData.order = $("#schOrder").val();
	scheduleSearch();
});

$("#schOrder").change(function(){
	scheduleSearchData.order =  $(this).val();
	scheduleSearchData.sort =  $("#schSort").val();
	scheduleSearch();
});

$("#addSchedule").click(function(){
	parent.popupOpen("/cp/cpsc02.do");
});

function scheduleSearch(){
	if(scheduleValidator()){
		progressShow();
		ECMService.getAPI("schedules", JSON.stringify(scheduleSearchData), function(result){
			if(result.result=="S"){
				//console.log(result.contents);
				for(var i=0;i<result.contents.length;i++){
					var info = {};
					info.frequency = result.contents[i].frequency;
					info.weekDays = result.contents[i].weekDays;
					info.cronExpression = result.contents[i].cronExpression;
					info.runEveryMinutes = result.contents[i].runEveryMinutes;
					result.contents[i].recurringInfo = info;
				}
				scheduleGrid.setECMGrid(result);
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

function scheduleValidator() {
	if(firstYn_scheduleGrid){
		scheduleSearchDataReset();
		scheduleSearchData.sort =  $("#schSort").val();
		scheduleSearchData.order =  $("#schOrder").val();
		scheduleSearchData.searchBy =  $("#schBy").val();
		scheduleSearchData.searchValue =  $("#schKeyword").val();
	}
	scheduleSearchData = getPageInfo_scheduleGrid(scheduleSearchData);
	return true;
}

function scheduleSearchDataReset(){
	scheduleSearchData = { currentPage : 1, pageSize : 15, sort : "", order:"", searchBy : "", searchValue : "" };
}

function recurringYn(value){
	if(value==true){
		return "Y";
	}else{
		return "N";
	}
}

function frequencyNm(value){
	//console.log(value);
	var frequency = value.frequency;
	var cronExpression = value.cronExpression;
	var weekDays = value.weekDays;
	if(frequency=="RunEveryNMins"){
		var runEveryMinutes = value.runEveryMinutes;
		return "매 "+runEveryMinutes+"분마다";
	}else if(frequency=="Daily"){
		return "매일 "+cronFormat(cronExpression, "Time");
	}else if(frequency=="DailyWeekDays"){
		return "평일 "+cronFormat(cronExpression, "Time");
	}else if(frequency=="Weekly"){
		return "매주 "+weekDaysFormat(weekDays);
	}else if(frequency=="Monthly"){
		return "매월 "+cronFormat(cronExpression, "DayTime");
	}else if(frequency=="Yearly"){
		return "매년 "+cronFormat(cronExpression, "MonthDayTime");
	}else{
		return "";
	}
}

function scheduleStateNm(value){
	if(value=="Active"){
		return "활성";
	}else if(value=="Paused"){
		return "비활성";
	}else{
		return "";
	}
}

function setName01(value){
	var format="";
	switch(value) {
		case "Datasource" :
			format='데이터소스';
			break;
		case "Campaign" :
			format='캠페인';
			break;
		default :
			format=value;
		break;
	}
	return format;
}

function weekDaysFormat(value){
	weekDays = [
		{weekDay:"MON", weekDayKr:"월요일"},
		{weekDay:"TUE", weekDayKr:"화요일"},
		{weekDay:"WED", weekDayKr:"수요일"},
		{weekDay:"THU", weekDayKr:"목요일"},
		{weekDay:"FRI", weekDayKr:"금요일"},
		{weekDay:"SAT", weekDayKr:"토요일"},
		{weekDay:"SUN", weekDayKr:"일요일"}
	]

	var weekDaysKr ="";
	for(var i=0;i<value.length;i++){
		for(var j=0;j<weekDays.length;j++){
			if(value[i]==weekDays[j].weekDay){
				if(i==0){
					weekDaysKr+=weekDays[j].weekDayKr;
				}else{
					weekDaysKr+=", "+weekDays[j].weekDayKr;
				}
			}
		}
	}
	return weekDaysKr;
}

function cronFormat(value, type){
	if(value!=null && value!="" && value!=undefined && type!=""){
		crons = value.split(" ");
		if(type=="Time"){
			return zeroFormat(crons[2])+"시 "+zeroFormat(crons[1])+"분 "+zeroFormat(crons[0])+"초";
		}else if(type=="DayTime"){
			return zeroFormat(crons[3])+"일 "+zeroFormat(crons[2])+"시 "+zeroFormat(crons[1])+"분 "+zeroFormat(crons[0])+"초";
		}else if(type=="MonthDayTime"){
			return zeroFormat(crons[4])+"월 "+zeroFormat(crons[3])+"일 "+zeroFormat(crons[2])+"시 "+zeroFormat(crons[1])+"분 "+zeroFormat(crons[0])+"초";
		}
	}else{
		return value;
	}
}

function zeroFormat(value){
	if(isNaN(value)){
		value = value*1;
		if(isNaN(value)){
			return value;
		}else{
			if(value<10){
				value= "0"+value;
			}else{
				value = value;
			}
			return value;
		}
	}else{
		if(value<10){
			value= "0"+value;
		}else{
			value = value;
		}
		return value;
	}
}