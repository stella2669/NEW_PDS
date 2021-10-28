/**
 * 인트로
 */

var loginInfo = _getLoginInfo();

var callGraphMaxCnt = 100; // 콜현황그래프 Max
var callGraphInterval = 10; // 콜현황그래프 건수 Gap

var interval01;
var interval02;

var agentData =[
	{status:"대기",statusCnt:0},
	{status:"후처리",statusCnt:0},
	{status:"통화중",statusCnt:0},
	{status:"휴식중",statusCnt:0}
];

var campData =[
	{status:"연결건수",statusCnt:0},
	{status:"실패건수",statusCnt:0}
];

var callData = [];

var strTypeData = {
	Progressive:{totalAttempts:0, successCalls:0, nuisanceCalls:0, previewDials:null, previewCancels:null},
	ExpertCallRatio:{totalAttempts:0, successCalls:0, nuisanceCalls:0, previewDials:null, previewCancels:null},
	CruiseControl:{totalAttempts:0, successCalls:0, nuisanceCalls:0, previewDials:null, previewCancels:null},
	Custom:{totalAttempts:0, successCalls:0, nuisanceCalls:0, previewDials:null, previewCancels:null},
	Preview:{totalAttempts:0, successCalls:0, nuisanceCalls:0, previewDials:null, previewCancels:null},
	TimeBased:{totalAttempts:0, successCalls:0, nuisanceCalls:0, previewDials:null, previewCancels:null},
	SkillBased:{totalAttempts:0, successCalls:0, nuisanceCalls:0, previewDials:null, previewCancels:null},
	None:{totalAttempts:0, successCalls:0, nuisanceCalls:0, previewDials:null, previewCancels:null},
	Manual:{totalAttempts:0, successCalls:0, nuisanceCalls:0, previewDials:null, previewCancels:null}
}

//초에 한번씩 호출
function getDataTime(){
	interval01 = setInterval(function () {
		agent_statistics01();	//상담사 상태
	}, 1000*5);

	interval02 = setInterval(function () {
		camp_statistics01();	//캠페인 상태
	}, 1000*5);
}

//상담원 상태
function agent_statistics01(){
	FRMA01_Service.getCampAgentMnData(function(result){
		if(result.result=="S"){
			$("#loginCnt").text(addCommaStr(result.busyCnt+result.readyCnt+result.workNotReadyCnt+result.notReadyCnt));	//로그인수
			$("#eshCnt").text(addCommaStr(result.busyCnt));		//통화중수
			$("#readyCnt").text(addCommaStr(result.readyCnt));	//대기수
			$("#aftworkCnt").text(addCommaStr(result.workNotReadyCnt));		//후처리
			$("#notReadyCnt").text(addCommaStr(result.notReadyCnt));		//휴식 + 후처리
		}else{
			LLYNX_Alert(result);
		}
	});
}

//캠페인 모니터링
function camp_statistics01(){
	FRMA01_Service.getIntroCampMonData(function(result){
		if(result.result=="S"){
			if(result.list.length>0){
				var todayData = result.list[result.list.length-1];
				$("#totalContactCount").text(addCommaStr(todayData.totalCalllist));	//총건수
				$("#totalAttemptingContactCount").text(addCommaStr(todayData.tryCnt));		//시도건
				$("#answeredContactCount").text(addCommaStr(todayData.conCnt));	//연결건

				if(todayData.tryCnt!=0){
					$("#completedRate").text((todayData.conCnt/todayData.tryCnt*100).toFixed(2)+"%");	// 완료율
				}else{
					$("#completedRate").text("-");
				}

				campData[0].statusCnt = parseInt(todayData.conCnt);
				campData[1].statusCnt = parseInt(todayData.tryCnt) - parseInt(todayData.conCnt);
				$('#campProcessGraph').jqxChart('refresh');

				callData = result.list;
				var tryCnts = [];
				for(var i=0;i<callData.length;i++){
					tryCnts.push(callData[i].tryCnt);
				}

				var max = Math.max.apply(null, tryCnts);
				var gap = Math.round(max/10);

				callGraphMaxCnt = max+gap; // 콜현황그래프 Max
				callGraphInterval = gap; // 콜현황그래프 건수 Gap

				graphSettingUpdate();
				$('#campCallGraph').jqxChart(lineSettings);
				$('#campCallGraph').jqxChart('refresh');
			}

			ECMService.getAPI("monitors/job/statistics", function(result){
				//console.log(result);
				if(result.result=="S"){
					for(var i=0;i<result.contents.length;i++){
						strTypeData[result.contents[i].pacingType].totalAttempts = result.contents[i].totalAttempts;
						strTypeData[result.contents[i].pacingType].successCalls = result.contents[i].successCalls;
						strTypeData[result.contents[i].pacingType].nuisanceCalls = result.contents[i].nuisanceCalls;
						strTypeData[result.contents[i].pacingType].previewDials = result.contents[i].previewDials;
						strTypeData[result.contents[i].pacingType].previewCancels = result.contents[i].previewCancels;
					}
					setStrCallStatics();
				}else{
					if(result.code!=null){
						LLYNX_Alert(ECMError(result.code, result.message));
						clearInterval(interval01);
						clearInterval(interval02);
					}else{
						LLYNX_Alert(result.msg);
						clearInterval(interval01);
						clearInterval(interval02);
					}
				}
			});

		}else{
			LLYNX_Alert(result.msg);
		}
	});
}

var userStatusGraph = $("#userStatusGraph");

var donutSetting = {
	title: "",
	description:"",
	showLegend: true,
	showBorderLine: true,
	enableAnimations:false,
	legendLayout: { left: 320, top: 100, height: 200, flow: 'vertical' },
	padding: { left: 5, top: 5, right: 50, bottom: 5 },
	titlePadding: { left: 0, top: 0, right: 0, bottom: 0 },
	source: agentData,
	colorScheme: 'scheme02',
	seriesGroups: [
		{
			type: 'donut',
			showLabels: true,
			series: [
				{
					dataField: 'statusCnt',
					displayText: 'status',
					labelRadius: 120,
					initialAngle: 15,
					radius: 110,
                    innerRadius: 50,
					centerOffset: 0,
					formatFunction: function (value, itemIndex) {
                    	return agentData[itemIndex].status;
                    },
					legendFormatFunction: function(value, itemIndex){
						return agentData[itemIndex].status;
					},
					toolTipFormatFunction:function(value, itemIndex){
						return agentData[itemIndex].status + " : " + value+"건";
					}
				}
			]
		}
	]
};

var donutSetting2 = {
	title: "진행률",
	description:"",
	showLegend: true,
	showBorderLine: true,
	enableAnimations:false,
	legendLayout: { left: 320, top: 100, height: 200, flow: 'vertical' },
	padding: { left: 5, top: 5, right: 50, bottom: 5 },
	titlePadding: { left: 0, top: 0, right: 0, bottom: 0 },
	source: campData,
	colorScheme: 'scheme03',
	seriesGroups: [
		{
			type: 'donut',
			showLabels: true,
			series: [
				{
					dataField: 'statusCnt',
					displayText: 'status',
					labelRadius: 90,
					initialAngle: 15,
					radius: 80,
                    innerRadius: 40,
					centerOffset: 0,
					formatFunction: function (value, itemIndex) {
                    	return campData[itemIndex].status;
                    },
					legendFormatFunction: function(value, itemIndex){
						return campData[itemIndex].status;
					},
					toolTipFormatFunction:function(value, itemIndex){
						return campData[itemIndex].status + " : " + value+"건";
					}
				}
			]
		}
	]
};

var lineSettings = {
    title: "캠페인 콜현황 모니터링",
    description: "",
	enableAnimations:false,
    showLegend: true,
    padding: { left: 5, top: 5, right: 11, bottom: 5 },
    titlePadding: { left: 10, top: 0, right: 0, bottom: 10 },
    source: callData,
    xAxis:
    {
        dataField: 'days',
        type: 'date',
        baseUnit: 'day',
        valuesOnTicks: true,
		minValue:1,
        labels:
        {
            formatFunction: function (value) {
                return value.getFullYear()+'년 '+(value.getMonth()+1)+'월 '+value.getDate()+'일';
            }
        },
        toolTipFormatFunction: function (value) {
            return value.getFullYear()+'년 '+(value.getMonth()+1)+'월 '+value.getDate()+'일';
        }
    },
    valueAxis:
    {
        unitInterval: 10,
        minValue: 0,
        maxValue: 120,
        labels: {horizontalAlignment: 'right'},
        title: { text: '' }
    },
    colorScheme: 'scheme01',
    seriesGroups:
        [
            {
                type: 'column',
				columnsMaxWidth :50,
				valueAxis:
                {
                    visible: true,
                    unitInterval: callGraphInterval,
			        minValue: 0,
			        maxValue: callGraphMaxCnt,
                    title: { text: '연결건수' }
                },
                series: [
                        { dataField: 'conCnt', displayText: '연결건수' }
                ]
            },
			{
                type: 'line',
                valueAxis:
                {
                    visible: true,
                    position: 'right',
                    unitInterval: callGraphInterval,
			        minValue: 0,
			        maxValue: callGraphMaxCnt,
                    title: { text: '시도건수' },
                    gridLines: { visible: false },
                    labels: { horizontalAlignment: 'left' }
                },
                series: [
                        { dataField: 'tryCnt', displayText: '시도건수' },
                ]
            }

        ]
};


$(document).ready(function() {
	var jqxWidget = $('#jqxWidget');

	var today = new Date();

	for(var i=0;i<=10;i++){
		var year = today.getFullYear();
		var month = ('0' + (today.getMonth() + 1)).slice(-2);
		var day = ('0' + (today.getDate()-10+i)).slice(-2);

		var dateString = year + '-' + month  + '-' + day;
		callData.push({totalCalllist: 0, conCnt: 0, days: dateString, tryCnt: 0})
	}

	$('#campProcessGraph').jqxChart(donutSetting2);
	$('#campCallGraph').jqxChart(lineSettings);
	//agent_statistics01();
	//camp_statistics01();
	//getDataTime();
});

function setStrCallStatics(){
	var showDatas = ["Progressive", "Manual", "Preview"];
	for(var i=0;i<showDatas.length;i++){
		if(showDatas[i]=="Progressive"){
			$("#"+showDatas[i]+"TotalAttempts").text(strTypeData[showDatas[i]].totalAttempts);
			$("#"+showDatas[i]+"SuccessCalls").text(strTypeData[showDatas[i]].successCalls);
			$("#"+showDatas[i]+"NuisanceCalls").text(strTypeData[showDatas[i]].nuisanceCalls);
		}else if(showDatas[i]=="Preview"){
			$("#"+showDatas[i]+"Dials").text(nullOrUndefinedToZero(strTypeData[showDatas[i]].previewDials));
			$("#"+showDatas[i]+"Cancels").text(nullOrUndefinedToZero(strTypeData[showDatas[i]].previewCancels));
		}else if(showDatas[i]=="Manual"){
			$("#"+showDatas[i]+"TotalAttempts").text(strTypeData[showDatas[i]].totalAttempts);
			$("#"+showDatas[i]+"SuccessCalls").text(strTypeData[showDatas[i]].successCalls);
			//$("#"+showDatas[i]+"NuisanceCalls").text(strTypeData[showDatas[i]].nuisanceCalls);
		}
	}
}


function graphSettingUpdate(){
	lineSettings = {
	    title: "캠페인 콜현황 모니터링",
	    description: "",
		enableAnimations:false,
	    showLegend: true,
	    padding: { left: 5, top: 5, right: 11, bottom: 5 },
	    titlePadding: { left: 10, top: 0, right: 0, bottom: 10 },
	    source: callData,
	    xAxis:
	    {
	        dataField: 'days',
	        type: 'date',
	        baseUnit: 'day',
	        valuesOnTicks: true,
			minValue:1,
	        labels:
	        {
	            formatFunction: function (value) {
	                return value.getFullYear()+'년 '+(value.getMonth()+1)+'월 '+value.getDate()+'일';
	            }
	        },
	        toolTipFormatFunction: function (value) {
	            return value.getFullYear()+'년 '+(value.getMonth()+1)+'월 '+value.getDate()+'일';
	        }
	    },
	    valueAxis:
	    {
	        unitInterval: 10,
	        minValue: 0,
	        maxValue: 120,
	        labels: {horizontalAlignment: 'right'},
	        title: { text: '' }
	    },
	    colorScheme: 'scheme01',
	    seriesGroups:
	        [
	            {
	                type: 'column',
					columnsMaxWidth :50,
					valueAxis:
	                {
	                    visible: true,
	                    unitInterval: callGraphInterval,
				        minValue: 0,
				        maxValue: callGraphMaxCnt,
	                    title: { text: '연결건수' }
	                },
	                series: [
	                        { dataField: 'conCnt', displayText: '연결건수' }
	                ]
	            },
				{
	                type: 'line',
	                valueAxis:
	                {
	                    visible: true,
	                    position: 'right',
	                    unitInterval: callGraphInterval,
				        minValue: 0,
				        maxValue: callGraphMaxCnt,
	                    title: { text: '시도건수' },
	                    gridLines: { visible: false },
	                    labels: { horizontalAlignment: 'left' }
	                },
	                series: [
	                        { dataField: 'tryCnt', displayText: '시도건수' },
	                ]
	            }

	        ]
	};
}