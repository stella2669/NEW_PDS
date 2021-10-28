/**
 * 캠페인 일정 추가
 */

var campaignName="";

var scheduleData = {
	scheduleType: "",
	name: "",
	startTime: "",
	timeZone: "",
	recurring: false
};


$(document).ready(function(){
	$("#recurringFrequency").change();
	if(selectedCampId!=""){
		ECMService.getAPI("campaigns/"+selectedCampId,function(result){
			if(result.result=="S"){
				//console.log(result);
				$("#campNm").text(result.name);
				campaignName = result.name;
			}else{
				LLYNX_Alert(result.msg, 'close');
			}
		});
	}else{
		LLYNX_Alert("선택된 캠페인 정보가 없습니다.\n다시 시도해주세요.", 'close');
	}
});

$("#addSchedule").click(function(){
	if(setScheduleDate()){
		console.log(scheduleData);
		if(scheduleData.recurring){
			if(confirm('등록 하시겠습니까?')){
				ECMService.insertAPI("campaigns/"+selectedCampId+"/schedule/recurring", JSON.stringify(scheduleData), function(result){
					if(result.result&&result.result!="F"){
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
		}else{
			if(confirm('등록 하시겠습니까?')){
				ECMService.insertAPI("campaigns/"+selectedCampId+"/schedule", JSON.stringify(scheduleData), function(result){
					if(result.result&&result.result!="F"){
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
		}
	}
});

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
	//console.log(thisVal);
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
	if($("#startTime").val()==""){
		LLYNX_Alert("시작시간을 선택해주세요.", "focus", "startTime");
		return false;
	}else if($("#selectTimeZone").val()==""){
		LLYNX_Alert("시간대를 선택해주세요.", "focus", "selectTimeZone");
		return false;
	}else if(!moment($("#startTime").val()).isAfter(new Date)){
		LLYNX_Alert("일정 시작일시는 현재보다 이후여야합니다.", "focus", "startTime");
		return false;
	}else{
		if($("#repeatYn").prop("checked")){
			if(!moment($("#endTime").val()).isAfter($("#startTime").val())){
				LLYNX_Alert("일정 종료일시는 일정 시작일시보다 이후여야합니다.", "focus", "endTime");
			}
			scheduleData = {};
			scheduleData = { scheduleType: "Campaign", name: "", startTime: "", timeZone: "", recurring: false };
			// 반복일정 추가
			scheduleData.scheduleType = "Campaign";
			scheduleData.name =  campaignName;
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
	scheduleData= {};
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