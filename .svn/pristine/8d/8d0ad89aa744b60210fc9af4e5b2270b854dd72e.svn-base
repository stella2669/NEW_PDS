/**
 * 메인 프레임
 */
// tab 변수 선언
var tabs
var link;
var tabs_id;
var find_id;
var tab_id;

var empInfo = {}; // 상담원 정보

var activePg = "";


var BTN_CLICK_LOGOUT = false; // 로그아웃 버튼 클릭여부


$(document).ready(function() {
	// 최초 화면 사이즈 변경
	window.moveTo(0,0);
	window.resizeTo(1920, 1080);

	// 사용자 정보
	var loginUser = _getLoginInfo();


	empInfo.userId     = loginUser.userId;
	empInfo.userNm     = loginUser.userNm;
	empInfo.password   = loginUser.password;
	empInfo.groupCd   = loginUser.groupCd;
	empInfo.authCd    = loginUser.authCd;

	// 탭
	tabs = $("#tabs").tabs();

	tabs.on("click", ".tab_close", function() {
		var panelId = $(this).closest("li").remove().attr("aria-controls");
		$("#"+panelId).remove();
		sizeTab_x();
		tabs.tabs("refresh");

		var tabNo = $("#tabs").tabs().tabs('option','active');
		if(tabNo!=0){
			activeMenu($("#tabs").find("li").eq(tabNo).attr("tabProgCd"));
		}else{
			activeMenu('');
		}
	});

	$("#sub_tabs").tabs();

	slider = $(".bxslider").bxSlider({
		auto: true,
		speed: 500,
		pause: 3000,
		autoHover: true,
		autoControls: false,
		controls:false,
		pager: false,
		mode: 'vertical', //'horizontal',
		easing: 'linear'
	});
});


$("#refreshTab").click(function(){
	var tabNo = $("#tabs").tabs().tabs('option','active');
	$(".main_tab_body").eq(tabNo).find("iframe").attr("src", $(".main_tab_body").eq(tabNo).find("iframe").attr("src"));
});




function readNotice(seq) {
	// popupOpen("/aba/aba000200p.do?" + seq);
}

// 메인화면 팝업 오픈
function popupOpen(url) {
	$("#cmmPoopup").show();
	$("#cmmPoopup").html('<iframe id="layerPopup" src="'+url+'" onload="parent.addDiv();"></iframe>');
}

function addDiv() {
	$("#layerPopup").contents().find(".popup_window").wrap("<div class='popup_align'></div>");
}

// 메인화면 팝업 종료
function popupClose() {
	$("#layerPopup").remove();
	$("#cmmPoopup").html("");
	$("#cmmPoopup").hide();
}

function moveTab(idx) {
	var tabsSize = parseInt($(".main_tab_header li").length);
	var mvIdx = parseInt(idx);
	var currIdx = parseInt(tabs.tabs("option", "active"));
	var selectIdx = currIdx+mvIdx;

	if (tabsSize<selectIdx) {
		return;
	}
	tabs.tabs({active:selectIdx});
}

// 이전 탭으로 이동
$("#prevTab").click(function(e) {
	e.preventDefault();
	moveTab(-1);
});

// 다음 탭으로 이동
$("#nextTab").click(function(e) {
	e.preventDefault();
	moveTab(1);
});

// 모든 탭 닫기
$("#closeAllTabs").click(function(e) {
	e.preventDefault();

	$(".main_tab_header li").each(function(index, item) {
		if (index>0) { // 인트로는 지우지 않음
			var panelId = $(item).closest("li").remove().attr("aria-controls");
			$("#"+panelId).remove();
			sizeTab_x();
			activeMenu('');
		}
	});
	tabs.tabs("refresh");
S
	// 인드로 그리드 보여주기 위해 - 포커스가 떠나있을 경우 그리드 리스트가 보이지 않음
	window.dispatchEvent(new Event('resize'));
});

$(".fix").click(function() {
	// 인드로 그리드 보여주기 위해 - 포커스가 떠나있을 경우 그리드 리스트가 보이지 않음
	window.dispatchEvent(new Event('resize'));
});
