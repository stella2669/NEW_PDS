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
	{ label: "완료건수", name: "comCnt", formatter:addCommaStr, width: 50, align: "right" },
	{ label: "연결건수", name: "conCnt", formatter:addCommaStr, width: 50, align: "right" },
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
	schCampStat: ""
}


var agentColModel = [
	{ label: "ID", name: "agentId", width: 30, align: "center" },
	{ label: "상담사명", name: "agentNm", width: 50, align: "left" },
	{ label: "소속", name: "groupNm", width: 50, align: "center" },
	{ label: "내선번호", name: "dn", width: 50, align: "center" },
	/*{ label: "상태", name: "status", width: 50, align: "center" },
	{ label: "상태시간", name: "statusTime", width: 50, align: "center" },*/
	{ label: "통화건수", name: "eshCnt", width: 50, align: "center" },
	{ label: "평균통화시간", name: "eshAvrTime", formatter:secToTime, width: 50, align: "center" },
	{ label: "평균후처리시간", name: "aftworkAvrTime", formatter:secToTime, width: 50, align: "center" },
	{ label: "평균대기시간", name: "readyAvrTime", formatter:secToTime, width: 50, align: "center" },
	{ label: "평균휴식시간", name: "notreadyAvrTime", formatter:secToTime, width: 50, align: "center" }
]

var campMonGrid = new webticsGrid();
var agentGrid = new webticsGrid();

var graphData =[
	{status:"통화",statusCnt:0},
	{status:"후처리",statusCnt:0},
	{status:"대기",statusCnt:0},
	{status:"휴식",statusCnt:0}
];

var donutSetting = {
	title: "상담사 상태현황",
	description:"",
	enableAnimations: false,
	showLegend: true,
	showBorderLine: true,
	legendLayout: { left: 500, top: 100, height: 200, flow: 'vertical' },
	padding: { left: 5, top: 5, right: 50, bottom: 5 },
	titlePadding: { left: 0, top: 0, right: 0, bottom: 0 },
	source: graphData,
	colorScheme: 'scheme01',
	seriesGroups: [
		{
			type: 'donut',
			showLabels: true,
			series: [
				{
					dataField: 'statusCnt',
					displayText: 'status',
					labelRadius: 140,
					initialAngle: 15,
					radius: 120,
                    innerRadius: 50,
					centerOffset: 0,
					formatFunction: function (value, itemIndex) {
                    	return graphData[itemIndex].status;
                    },
					legendFormatFunction: function(value, itemIndex){
						return graphData[itemIndex].status;
					},
					toolTipFormatFunction:function(value, itemIndex){
						return graphData[itemIndex].status + " : " + value+"건";
					}
				}
			]
		}
	]
};

//grid resize
$(window).bind("resize", function() {
	$("#campMonGrid").setGridWidth($("#divGrid").width(), true);
	$("#agentGrid").setGridWidth($("#divGrid2").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");

$(document).ready(function() {
	campMonGrid.id("campMonGrid");
	campMonGrid.colModel(campMonColModel);
	campMonGrid.rowNum(10000);
	campMonGrid.call();

	agentGrid.id("agentGrid");
	agentGrid.colModel(agentColModel);
	agentGrid.rowNum(10000);
	agentGrid.call();

	$('#userStatusGraph').jqxChart(donutSetting);

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
		progressShow();
		MNCM01_Service.getCampMonList(campMonSearchData, function(result){
			progressHide();
			if(result.result=="S"){
				campMonGrid.setGrid(result);
				campMonGrid.setSelectRowFunc("campSelectRowFunc");
				if(result.list.length>0){
					if(selectedCampId==""){
						$("#campMonGrid").jqGrid('setSelection', result.list[0].campId, true);
					}
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

function campSelectRowFunc(rowData) {
	selectedCampId = rowData.campId;
	progressShow();
	MNSM01_Service.getCampAgentList({campId:rowData.campId}, function(result){
		progressHide();
		if(result.result=="S"){
			agentGrid.setGrid(result);
		}else{
			LLYNX_Alert("캠페인 상담사정보를 가져오는 중 오류가 발생하였습니다.");
		}
	});

	MNCM01_Service.getCampAgentMnData({campNm:rowData.campNm}, function(result){
		if(result.result=="S"){
			$("#loginCnt").text(result.readyCnt+result.busyCnt+result.workNotReadyCnt+result.notReadyCnt);
			$("#readyCnt").text(result.readyCnt);
			$("#eshCnt").text(result.busyCnt);
			$("#aftworkCnt").text(result.workNotReadyCnt);
			$("#notreadyCnt").text(result.notReadyCnt);

			graphData[0].statusCnt = removeComma(result.busyCnt);
			graphData[1].statusCnt = removeComma(result.workNotReadyCnt);
			graphData[2].statusCnt = removeComma(result.readyCnt);
			graphData[3].statusCnt = removeComma(result.notReadyCnt);
			$('#userStatusGraph').jqxChart('refresh');
		}else{
			LLYNX_Alert(result.msg);
		}
	});


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
	campMonSearchData = { schCampNm:"", schCampStat: "" };
	selectedSchCycle = "";
}

function monDetailReset(){
	$("#loginCnt").text("");
	$("#readyCnt").text("");
	$("#eshCnt").text("");
	$("#aftworkCnt").text("");
	$("#notreadyCnt").text("");

	graphData[0].statusCnt = 0;
	graphData[1].statusCnt = 0;
	graphData[2].statusCnt = 0;
	graphData[3].statusCnt = 0;
	$('#userStatusGraph').jqxChart('refresh');
	$("#agentGrid").clearGridData();
	$("#agentGrid").trigger("reloadGrid");
}