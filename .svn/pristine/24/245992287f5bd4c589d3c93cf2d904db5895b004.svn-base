/**
 * 캠페인 모니터링관리페이지
 */
var loginInfo = _getLoginInfo();

var selectedCampId = "";

var selectedSchCycle = "";
var isCycle = false;
var updateData;

var campMonColModel = [
	{ label: "캠페인ID", name: "campId", width: 30, align: "center", key:true},
	{ label: "캠페인명", name: "campNm", width: 70, align: "left" },
	{ label: "캠페인 상태", name: "campStat", width: 50, align: "center" },
	{ label: "전체건수", name: "totalCalllist", formatter:addCommaStr, width: 50, align: "right" },
	{ label: "시도건수", name: "tryCnt", formatter:addCommaStr, width: 50, align: "right" },
	{ label: "연결건수", name: "conCnt", formatter:addCommaStr, width: 50, align: "right" },
	{ label: "완료건수", name: "comCnt", formatter:addCommaStr, width: 50, align: "right" },
	{ label: "포기건수", name: "adonCnt", formatter:addCommaStr, width: 50, align: "right" },
	{ label: "완료율", name: "comRate", formatter:addPercent, width: 50, align: "right" },
	{ label: "포기율", name: "adonRate", formatter:addPercent, width: 50, align: "right" },
	{ label: "시도율", name: "tryRate", formatter:addPercent, width: 50, align: "right" },
	{ label: "평균통화시간", name:"eshAvrTime", hidden:true},
	{ label: "평균후처리시간", name:"aftworkAvrTime", hidden:true},
	{ label: "평균대기시간", name:"readyAvrTime", hidden:true},
	{ label: "평균휴식시간", name:"notreadyAvrTime", hidden:true}
]

var campMonSearchData = {
	schCampNm:"",
	schCampStat:""
}

var campMonGrid = new webticsGrid();

var processData = [
	{ status: "완료 건수", statusCnt: 0 },
	{ status: "미처리 건수", statusCnt: 0 }
];

var successData = [
	{ status: "연결 건수", statusCnt: 0 },
	{ status: "실패 건수", statusCnt: 0 }
];

var processSetting = {
	title: "현재 진행률",
	description: "",
	enableAnimations: false,
	showLegend: true,
	showBorderLine: true,
	legendLayout: { flow: 'oriental' },
	padding: { left: 5, top: 5, right: 5, bottom: 5 },
	titlePadding: { left: 0, top: 0, right: 0, bottom: 0 },
	source: processData,
	colorScheme: 'scheme02',
	seriesGroups: [
		{
			type: 'donut',
			showLabels: true,
			series: [
				{
					dataField: 'statusCnt',
					displayText: 'status',
					labelRadius: 110,
					initialAngle: 15,
					radius: 90,
					innerRadius: 50,
					centerOffset: 0,
					formatFunction: function(value, itemIndex) {
						return processData[itemIndex].status;
					},
					legendFormatFunction: function(value, itemIndex) {
						return processData[itemIndex].status;
					},
					toolTipFormatFunction: function(value, itemIndex) {
						return processData[itemIndex].status + " : " + value + "건";
					}
				}
			]
		}
	]
};

var successSetting = {
	title: "시도 연결율",
	description: "",
	enableAnimations: false,
	showLegend: true,
	showBorderLine: true,
	legendLayout: { flow: 'oriental' },
	padding: { left: 5, top: 5, right: 5, bottom: 5 },
	titlePadding: { left: 0, top: 0, right: 0, bottom: 0 },
	source: successData,
	colorScheme: 'scheme01',
	seriesGroups: [
		{
			type: 'donut',
			showLabels: true,
			series: [
				{
					dataField: 'statusCnt',
					displayText: 'status',
					labelRadius: 110,
					initialAngle: 15,
					radius: 90,
					innerRadius: 50,
					centerOffset: 0,
					formatFunction: function(value, itemIndex) {
						return successData[itemIndex].status;
					},
					legendFormatFunction: function(value, itemIndex) {
						return successData[itemIndex].status;
					},
					toolTipFormatFunction: function(value, itemIndex) {
						return successData[itemIndex].status + " : " + value + "건";
					}
				}
			]
		}
	]
};

var procByDateData = [];

var lineSettings = {
    title: "금주 캠페인 진행 현황",
    description: "",
    enableAnimations: false,
    showLegend: true,
    padding: { left: 5, top: 5, right: 11, bottom: 5 },
    titlePadding: { left: 10, top: 0, right: 0, bottom: 10 },
    source: procByDateData,
    xAxis:
    {
        dataField: 'Date',
        type: 'date',
        baseUnit: 'day',
        valuesOnTicks: true,
		minValue:1,
        labels:
        {
            formatFunction: function (value) {
                return value.getFullYear()+'/'+(value.getMonth()+1)+'/'+value.getDate();
            }
        },
        toolTipFormatFunction: function (value) {
            return value.getFullYear()+'/'+(value.getMonth()+1)+'/'+value.getDate();
        }
    },
    valueAxis:
    {
        unitInterval: 10,
        minValue: 0,
        maxValue: 1000,
        labels: {horizontalAlignment: 'right'},
        title: { text: '' }
    },
    colorScheme: 'scheme01',
    seriesGroups:
        [
            {
                type: 'stackedcolumn',
				columnsMaxWidth :50,
				valueAxis:
                {
                    visible: true,
                    unitInterval: 500,
			        minValue: 0,
			        maxValue: 1500,
                    title: { text: '건수' }
                },
                series: [
                        { dataField: 'sucCnt', displayText: '연결건수' },
                        { dataField: 'failCnt', displayText: '실패건수' }
                    ]
            },
			{
                type: 'line',
                valueAxis:
                {
                    visible: true,
                    position: 'right',
                    unitInterval: 500,
			        minValue: 0,
			        maxValue: 1500,
                    title: { text: '건수' },
                    gridLines: { visible: false },
                    labels: { horizontalAlignment: 'left' }
                },
                series: [
                        { dataField: 'tryCnt', displayText: '시도건수' },
                    ]
            }

        ]
};

//grid resize
$(window).bind("resize", function() {
	$("#campMonGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function() {
	campMonGrid.id("campMonGrid");
	campMonGrid.colModel(campMonColModel);
	campMonGrid.rowNum(10000);
	campMonGrid.call();

	$('#campProcessGraph').jqxChart(processSetting);
	$('#campSuccessGraph').jqxChart(successSetting);
	// $('#campCallGraph').jqxChart(lineSettings);

	$("#search").click();
	$("#schCampNm").focus();
});

$("#schCampNm").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#search").click(function() {
	campMonSearchDataReset();
	monDetailReset();
	campMonSearch();
});

$("#schCampStat").change(function(){
	campMonSearchData.schCampNm = $("#schCampNm").val();
	campMonSearchData.schCampStat = $(this).val();
	selectedSchCycle = $("#schCycle").val();
	campMonSearch();
});

$("#schCycle").change(function(){
	campMonSearchData.schCampNm = $("#schCampNm").val();
	campMonSearchData.schCampStat = $("#schCampStat").val();
	selectedSchCycle = $(this).val();
	campMonSearch();
});

$("#excelDown").click(function(){
	$("#excelFrm [name=title]").val("CampaignMonitoring_"+moment().format('YYYYMMDD_HHmmss'));
	$("#excelFrm [name=fileNm]").val("CampaignMonitoring_"+moment().format('YYYYMMDD_HHmmss'));
	$("#excelFrm [name=colModel]").val(JSON.stringify(campMonColModel));

	MNCM01_Service.getCampMonList(campMonSearchData, function(result){
		if(result.result=="S"){
			if(result.list.length>0){
				$("#excelFrm [name=dataList]").val(JSON.stringify(result.list));
				$("#excelFrm")[0].submit();
			}else{
				LLYNX_Alert("조회된 데이터가 없습니다.");
			}
		} else {
			LLYNX_Alert("캠페인모니터링 데이터를 가져오는 중 오류가 발생하였습니다.");
		}
	});
});

function campMonSearch() {
	if (campMonGridValidator()) {
		MNCM01_Service.getCampMonList(campMonSearchData, function(result){
			if(result.result=="S"){
				campMonGrid.setGrid(result);
				campMonGrid.setSelectRowFunc("campSelectRowFunc");
				if(result.list.length>0){
					$("#campMonGrid").jqGrid('setSelection', result.list[0].campId, true);
				}
				if(selectedSchCycle!=""){
					if(!isCycle){
						clearInterval(updateData);
						updateData = setInterval(function(){
							campMonSearchCycle();
						},selectedSchCycle*1000);
					}
					isCycle = true;
				}else{
					clearInterval(updateData);
					isCycle = false;
				}
			}else{
				LLYNX_Alert("캠페인모니터링 데이터를 가져오는 중 오류가 발생하였습니다.");
			}
		});
	}
}

function campMonSearchCycle(){
	MNCM01_Service.getCampMonList(campMonSearchData, function(result){
			if(result.result=="S"){
				campMonGrid.setGrid(result);
				campMonGrid.setSelectRowFunc("campSelectRowFunc");
				if(selectedSchCycle!=""){
					if(!isCycle){
						clearInterval(updateData);
						updateData = setInterval(function(){
							campMonSearchCycle();
						},selectedSchCycle*1000);
					}
					isCycle = true;
				}else{
					clearInterval(updateData);
					isCycle = false;
				}
				if(selectedCampId!=""){
					$("#campMonGrid").jqGrid("setSelection", selectedCampId, true);
				}
			}else{
				LLYNX_Alert("캠페인모니터링 데이터를 가져오는 중 오류가 발생하였습니다.");
			}
		});
}

function campSelectRowFunc(rowData, rowId) {
	selectedCampId = rowData.campId;
	$("#campNm").text(rowData.campNm);

	$("#eshAvrTime").text(secToTime(rowData.eshAvrTime));
	$("#aftworkAvrTime").text(secToTime(rowData.aftworkAvrTime));
	$("#readyAvrTime").text(secToTime(rowData.readyAvrTime));
	$("#notreadyAvrTime").text(secToTime(rowData.notreadyAvrTime));

	$("#totalCall").text(rowData.totalCalllist);
	$("#tryCnt").text(rowData.tryCnt);
	if(isNaN(rowData.comRate)){
		$("#comRate").text(rowData.comRate);
	}else{
		$("#comRate").text(rowData.comRate+"%");
	}

	$("#conCnt").text(rowData.conCnt);
	$("#comCnt").text(rowData.comCnt);
	$("#adonCnt").text(rowData.adonCnt);

	MNCM01_Service.getCampAgentMnData({campNm:rowData.campNm}, function(result){
		if(result.result=="S"){
			//console.log(result);
			$("#loginCnt").text(result.readyCnt+result.busyCnt+result.workNotReadyCnt+result.notReadyCnt);
			$("#readyCnt").text(result.readyCnt);
			$("#eshCnt").text(result.busyCnt);
			$("#aftworkCnt").text(result.workNotReadyCnt);
			$("#notreadyCnt").text(result.notReadyCnt);
		}else{
			LLYNX_Alert(result.msg);
		}
	});

	processData[0].statusCnt = removeComma(rowData.comCnt);
	processData[1].statusCnt = removeComma(rowData.totalCalllist)-removeComma(rowData.comCnt);
    $('#campProcessGraph').jqxChart('refresh');

	successData[0].statusCnt = removeComma(rowData.conCnt);
	successData[1].statusCnt = removeComma(rowData.tryCnt)-removeComma(rowData.conCnt);
    $('#campSuccessGraph').jqxChart('refresh');
}

function campMonGridValidator() {
	campMonSearchDataReset();
	campMonSearchData.schCampNm = $("#schCampNm").val();
	campMonSearchData.schCampStat = $("#schCampStat").val();
	if(selectedSchCycle!=$("#schCycle").val()){
		isCycle = false;
		selectedSchCycle = $("#schCycle").val();
	}

	return true;
}

function campMonSearchDataReset() {
	campMonSearchData = { schCampNm:"", schCampStat:"" };
	selectedSchCycle = "";
}

function monDetailReset(){
	selectedCampId = "";
	$("#campNm").text("");

	$("#eshAvrTime").text("");
	$("#aftworkAvrTime").text("");
	$("#readyAvrTime").text("");
	$("#notreadyAvrTime").text("");

	$("#totalCall").text("");
	$("#tryCnt").text("");
	$("#comRate").text("");
	$("#adonCnt").text("");
	$("#conCnt").text("");
	$("#comCnt").text("");

	$("#loginCnt").text("");
	$("#readyCnt").text("");
	$("#eshCnt").text("");
	$("#aftworkCnt").text("");
	$("#notreadyCnt").text("");

	processData[0].statusCnt = 0;
	processData[1].statusCnt = 0;
    $('#campProcessGraph').jqxChart('refresh');

	successData[0].statusCnt = 0;
	successData[1].statusCnt =0;
    $('#campSuccessGraph').jqxChart('refresh');
}