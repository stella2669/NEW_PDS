/**
 * 일정 추가
 */

var scheduleData = {
	scheduleType: "",
	name: "",
	startTime: "",
	timeZone: "",
	recurring: false
};

var today = new Date();
today.setMinutes(today.getMinutes()+5);
var fiveMinLater = moment(today).format("YYYY-MM-DDTHH:mm");

$(document).ready(function(){
	$("#startTime").val(fiveMinLater);
	$("#endTime").val(fiveMinLater);
});

$("#scheduleType").change(function(){
	var thisVal = $(this).val();
	if(thisVal=="Campaign"){
		ECMService.getAPI("campaigns", JSON.stringify({currentPage:1, pageSize:10000}), function(result){
			if(result.result=="S"){
				var options='<option value="">-일정명 선택-</option>'
				for(var i=0;i<result.contents.length;i++){
					options+='<option>'+result.contents[i].name+'</option>';
				}
				$("#scheduleName").html(options);
			}

		});
	}else if(thisVal=="Datasource"){
		ECMService.getAPI("datasources", JSON.stringify({currentPage:1, pageSize:10000}), function(result){
			//console.log(result);
			if(result.result=="S"){
				var options='<option value="">-일정명 선택-</option>'
				for(var i=0;i<result.contents.length;i++){
					if(result.contents[i].datasourceType!="upload_file"&&
					   result.contents[i].datasourceType!="exclude_contacts"&&
					   result.contents[i].datasourceType!="reset_excluded_contacts"){
						options+='<option>'+result.contents[i].name+'</option>';
					}
				}
				$("#scheduleName").html(options);
			}

		});
	}else{
		$("#scheduleName").html(options);
	}
});

$("#scheduleName").click(function(){
	if($("#scheduleType").val()==""){
		LLYNX_Alert("일정 유형을 먼저 선택해주세요.", "focus", "scheduleType");
	}
});

$("#addSchedule").click(function(){
	if(setScheduleDate()){
		//console.log(scheduleData);
		LLYNX_Confirm("등록하시겠습니까?", "addSchedule");
	}
});

function addSchedule(){
	ECMService.insertAPI("schedules", JSON.stringify(scheduleData), function(result){
		if(result.result && result.result!="F"){
			$("#ifr_tabs-PG_CPSC_01", parent.document)[0].contentWindow.scheduleSearch();
			LLYNX_Alert("등록되었습니다.", "close");
			scheduleDataReset();
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

$("#repeatYn").change(function(){
	if($("#repeatYn").prop("checked")){
		$(".repeatSchedule").show();
		$(".repeatSchedule input").prop("disabled", false);
	}else{
		$(".repeatSchedule").hide();
		$(".repeatSchedule input").prop("disabled", true);
	}
});

$("#recurringFrequency").change(function(){
	var thisVal = $(this).val();
	if(thisVal=="RunEveryNMins"){
		$("#minsInput").show();
		$("#dailyInput").hide();
		$("#weeklyInput").hide();
	}else if(thisVal=="Daily"){
		$("#minsInput").hide();
		$("#dailyInput").show();
		$("#weeklyInput").hide();
	}else if(thisVal=="Weekly"){
		$("#minsInput").hide();
		$("#dailyInput").hide();
		$("#weeklyInput").show();
	}else{
		$("#minsInput").hide();
		$("#dailyInput").hide();
		$("#weeklyInput").hide();
	}
});

$(".popup_close").click(function(){
	parent.popupClose();
});

function setScheduleDate(){
	if($("#scheduleType").val()==""){
		LLYNX_Alert("일정 유형을 선택해주세요.", "focus", "scheduleType");
		return false;
	}else if($("#scheduleName").val()==""){
		LLYNX_Alert("일정 이름을 선택해주세요.", "focus", "scheduleName");
		return false;
	}else if($("#startTime").val()==""){
		LLYNX_Alert("시작시간을 선택해주세요.", "focus", "startTime");
		return false;
	}else if($("#selectTimeZone").val()==""){
		LLYNX_Alert("시간대를 선택해주세요.", "focus", "selectTimeZone");
		return false;
	}else if(!moment($("#startTime").val()).isAfter(new Date)){
		LLYNX_Alert("일정 시작일시는 현재보다 이후여야합니다.", "focus", "startTime")
		return false;
	}else{
		if($("#repeatYn").prop("checked")){
			if(!moment($("#endTime").val()).isAfter($("#startTime").val())){
				LLYNX_Alert("일정 종료일시는 일정 시작일시보다 이후여야합니다.", "focus", "endTime");
			}
			scheduleData = {};
			scheduleData = { scheduleType: "", name: "", startTime: "", timeZone: "", recurring: false };
			// 반복일정 추가
			scheduleData.scheduleType = $("#scheduleType").val();
			scheduleData.name =  $("#scheduleName").val();
			scheduleData.startTime = moment($("#startTime").val()).format("YYYY/MM/DD HH:mm:ss");
			scheduleData.timeZone = "GMT"+$("#selectTimeZone option:selected").text().substr(1,6);
			scheduleData.recurring = $("#repeatYn").prop("checked");
			scheduleData.recurringFrequency = $("#recurringFrequency").val();
			if(scheduleData.recurringFrequency=="RunEveryNMins"){
				scheduleData.weekDaysOnly = "";
				scheduleData.selectedDays = [];
				scheduleData.runEveryMinutes = $("#runEveryMinutes").val();
			}else if(scheduleData.recurringFrequency=="Daily"){
				scheduleData.weekDaysOnly = $("#weekDaysOnly").prop("checked");
				scheduleData.selectedDays = [];
				scheduleData.runEveryMinutes = "";
			}else if(scheduleData.recurringFrequency=="Weekly"){
				scheduleData.weekDaysOnly = "";
				var days = [];
				$("input:checkbox[name=selectedDays]:checked").each(function(){
					days.push($(this).val());
				});
				scheduleData.selectedDays = days;
				scheduleData.runEveryMinutes = "";
			}else{
				scheduleData.weekDaysOnly = "";
				scheduleData.selectedDays = [];
				scheduleData.runEveryMinutes = "";
			}
			scheduleData.recurringEndTime = moment($("#endTime").val()).format("YYYY/MM/DD HH:mm:ss");

			return true;
		}else{
			// 단일일정 추가
			scheduleData.scheduleType = $("#scheduleType").val();
			scheduleData.name =  $("#scheduleName").val();
			scheduleData.startTime = moment($("#startTime").val()).format("YYYY/MM/DD HH:mm:ss");
			scheduleData.timeZone = "GMT"+$("#selectTimeZone option:selected").text().substr(1,6);
			scheduleData.recurring = $("#repeatYn").prop("checked");

			return true;
		}
	}
}

function scheduleDataReset(){
	scheduleData = {};
	scheduleData = { scheduleType: "", name: "", startTime: "", timeZone: "", recurring: false };
	$("#scheduleType").val("");
	$("#scheduleType").change();
	$("#startTime").val("");
	$("#selectTimeZone").val("Asia/Seoul");

	$("#runEveryMinutes").val("");
	$("input:checkbox[name=selectedDays]").prop("checked", false);
	$("#weekDaysOnly").prop("checked", false);

	$("#recurringFrequency").val("");
	$("#recurringFrequency").change();

	$("#repeatYn").prop("checked", false);
	$("#repeatYn").change();
}