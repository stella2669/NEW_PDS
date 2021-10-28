/**
 * left menu, user info
 */

$(document).ready(function(){
	// 메뉴생성
	FRME01_Service.getMenuList(function(rslt){
		getMenuList(rslt.menuList);
		getMyMenuList(rslt.menuList);
	});
});

// 로그아웃 버튼
$("#logOut").click(function() {
	LLYNX_Confirm("로그아웃 하시겠습니까?", "logoutFunc", "top");
});

function logoutFunc(){
	logoutAct("logout button");
}

$("#addMyMenu").click(function(){
	popupOpen("/fr/frme02.do");
});

function logoutAct(action) {
	BTN_CLICK_LOGOUT = true;                  // loop check

	sessionClear();                           // 브라우저 세션 삭제
	LOOU01_Service.logout(action, function() {});     // 서버 세션 삭제
	top.location.href = "/lo/loin01.do"; // 로그인 페이지 이동

	return null;
}

// 메뉴생성
function getMenuList(rslt) {
	var menuHtml = "";
	var mainHtml = "";
	var subHtml = "";
    for (var i in rslt.menu) {
		mainHtml += '<li class="depth_1 accordion"> <span role="button" class="pointer">'+rslt.menu[i].menuNm+'<i></i></span>';
		mainHtml += '<ul class="depth_2">';
		for (var j in rslt.subMenu) {
			if (rslt.menu[i].menuId == rslt.subMenu[j].parentId) {
				subHtml += '<li id="'+rslt.subMenu[j].menuId+'" rel="'+rslt.subMenu[j].url+'"><span role="button" class="pointer">'+rslt.subMenu[j].menuNm+'</span></li>';
			}
		}
		if (subHtml != "") {
			mainHtml += subHtml;
			mainHtml += '</ul></li>';

			menuHtml += mainHtml;
		}

		subHtml = "";
		mainHtml = "";
	}
	$("#allMenu").html(menuHtml);
}

// 메뉴생성
function getMyMenuList(rslt) {
	var menuHtml = "";
	var mainHtml = "";
	var subHtml = "";
    for (var i in rslt.menu) {
		mainHtml += '<li class="depth_1 accordion"> <span role="button" class="pointer">'+rslt.menu[i].menuNm+'<i></i></span>';
		mainHtml += '<ul class="depth_2">';
		for (var j in rslt.myMenu) {
			if (rslt.menu[i].menuId == rslt.myMenu[j].parentId) {
				subHtml += '<li id="'+rslt.myMenu[j].menuId+'" rel="'+rslt.myMenu[j].url+'"><span role="button" class="pointer">'+rslt.myMenu[j].menuNm+'</span></li>';
			}
		}
		if (subHtml != "") {
			mainHtml += subHtml;
			mainHtml += '</ul></li>';

			menuHtml += mainHtml;
		}

		subHtml = "";
		mainHtml = "";
	}
	$("#myMenu").html(menuHtml);
	if(rslt.myMenu.length>0){
		$("#myMenuTab").click();
	}
}


//좌측 메뉴 이벤트 처리 시작
//메뉴 전체 이벤트 처리
$(".gnb_ctrl").click(function(e) {
	e.preventDefault();

	if($(this).hasClass("mode_wide")){
		$("#container , #header , .gnb_ctrl").removeClass("mode_wide");
		$(".gnb_ctrl span").text("메인메뉴 닫기")
	} else {
		$("#container , #header , .gnb_ctrl").addClass("mode_wide");
		$(".gnb_ctrl span").text("메인메뉴 열기")
	}

	// 인트로 그리드 사이즈 조정
	window.dispatchEvent(new Event('resize'));
});


//대메뉴 클릭이벤트 처리
// $(".accordion > span").click(function(e) {
$(document).on("click", ".accordion > span", function(e) {
	e.preventDefault();

	 if($(this).parents(".accordion").hasClass("active")) {
	     $(this).parents(".accordion").removeClass("active");
	     $(this).parents(".accordion").find("ul").slideUp(100);
	 } else {
	     $(".accordion").removeClass("active");
	     $(this).parents(".accordion").addClass("active");
	     $(".accordion > ul").parent().not(this).find("ul").slideUp(100);
	     $(this).parents(".accordion").find("ul").slideToggle(100);
	 }
});

// 서브 메뉴 클릭시 탭 생성
//$("#gnb .depth_2 li").click(function(){
$(document).on("click", "#gnb .depth_2 li", function() {
	link = $(this);
	tabs_id = "tabs-" + $(link).attr("id");
	find_id = $("[id="+tabs_id+"]").attr("id");
	tab_id = "#" + tabs_id;

	if (find_id == tabs_id) {
		orderTab();
	} else {
		addTab(link);
		orderTab();
	}
	sizeTab_o();
});

//tab 처리
function sizeTab_o(){
	var tab_count = $(".main_tab_header li").length;
	var tab_header = $(".main_tab_header").outerWidth();
	var tab_div = 100 / tab_count;
	var tab_min = Math.ceil(tab_header / tab_count);
	var tab_sum = 0;

	$(".main_tab_header li").each(function(index, item){
		var tab_W = $(item).outerWidth();
		tab_sum = tab_sum + tab_W;
	});

	if(tab_header < tab_sum){
		$(".main_tab_header li").css("max-width", tab_div+"%").css("min-width", tab_div+"%");
	}
}

function sizeTab_x(){
	var tab_count = $(".main_tab_header li").length;
	var tab_header = $(".main_tab_header").outerWidth();
	var tab_div = 100 / tab_count;
	var tab_min = Math.ceil(tab_header / tab_count);
	var tab_sum = 0;
	$(".main_tab_header li").each(function(index, item){
		var tab_W = $(item).outerWidth();
		tab_sum = tab_sum + tab_W;
	});

	if(tab_min > 200){
		$(".main_tab_header li").css("max-width", "200px").css("min-width", "auto");
	} else {
		$(".main_tab_header li").css("max-width", tab_div+"%");
	}
}

function orderTab(){
	var ariactrl = "[aria-controls="+tabs_id+"]";
	$(ariactrl).insertAfter("#tab_fix");
	tabs.tabs("refresh");
	tabs.tabs("option", "active", id2Index("#tabs .main_tab_header", tab_id));
	activeMenu(tabs_id);
}

function id2Index(tabsId, srcId){
	var index = -1;
	var i = 0, tbH = $(tabsId).find("li a");
	var lntb = tbH.length;
	if(lntb>0){
		for(i=0; i<lntb; i++){
			o = tbH[i];
			if(o.href.search(srcId)>0){
				index = i;
			}
		}
	}

	return index;
}

var ifrOpt = 'width="100%" height="783px" scrolling="auto" frameborder="0" marginwidth="0" marginheight="0"';
function addTab(link) {
	var label = $(link).text();
	var id = "tabs-" + $(link).attr("id");
	var rel = $(link).attr("rel");
	var li = '<li class="flow" onclick="activeMenu(\''+id+'\')" tabProgCd="'+id+'"><a href="#'+id+'">'+label+'</a><button type="button" class="tab_close" onclick="activeMenu(\'\')"><i class="xi-close"></i><span class="replace_text">닫기</span></button><span class="tooltip">'+label+'</span></li>';

	tabs.find(".main_tab_header").append(li);
	tabs.append('<div id="'+id+'" class="main_tab_body"><iframe title="'+id+'" id="ifr_'+id+'" src="'+rel+'" '+ifrOpt+'></iframe></div>');
	tabs.tabs("refresh");

	activeMenu(id);
}


function activeMenu(id){
	var tabNo = $("#frme_tabs").tabs().tabs('option','active');
	var pgCd = "";
	if(id!=""){
		pgCd = id.substring(5);
		if(tabNo==0){
			$("#allMenu .depth_1").each(function(){
				$(this).removeClass("active");
			});
			$("#allMenu .depth_2").hide();
			$("#allMenu .depth_2 li").removeClass("active");
			if(pgCd!=""){
				$("#allMenu #"+pgCd).parents().parents().addClass("active");
				$("#allMenu #"+pgCd).parents().show();
				$("#allMenu #"+pgCd).addClass("active");
			}
		}else{
			$("#myMenu .depth_1").each(function(){
				$(this).removeClass("active");
			});
			$("#myMenu .depth_2").hide();
			$("#myMenu .depth_2 li").removeClass("active");
			if(pgCd!=""){
				$("#myMenu #"+pgCd).parents().parents().addClass("active");
				$("#myMenu #"+pgCd).parents().show();
				$("#myMenu #"+pgCd).addClass("active");
			}
		}
	}else{
		if(tabNo==0){
			$("#allMenu .depth_1").each(function(){
				$(this).removeClass("active");
			});
			$("#allMenu .depth_2").hide();
			$("#allMenu .depth_2 li").removeClass("active");
		}else{
			$("#myMenu .depth_1").each(function(){
				$(this).removeClass("active");
			});
			$("#myMenu .depth_2").hide();
			$("#myMenu .depth_2 li").removeClass("active");
		}
	}

}

function myMenuReset(){
	FRME01_Service.getMenuList(function(rslt){
		getMyMenuList(rslt.menuList);
	});
}
