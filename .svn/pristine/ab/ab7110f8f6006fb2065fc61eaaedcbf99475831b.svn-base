/**
 * 사용자관리
 */

// 로그인 사용자 정보
var loginInfo = _getLoginInfo();

var selectedUserId = "";

var userGrid = new webticsGrid();

var userColModel = [
	{name: "syyyymmdd", label: "일자", align: "center"},
	{name: "userId", label: "사용자 ID", align: "center"},
	{name: "userNm", label: "사용자 명", align: "center"},
	{name: "loginIp", label: "사용자 IP", align: "center"},
	{name: "tloginDate", label: "로그인 일시", align: "center"},
	{name: "tlogoutDate", label: "로그아웃 일시", align: "center"},
	{name: "", label: "", width:100 ,align: "center"}
];

var userSearchData = {
	srchUserId : "",
	srchUsernm : "",
	schStrtDate : "",
	schEndDate : "",
	orderBy:"schDate",
	sortBy:"desc"
}

//grid resize
$(window).bind("resize", function() {
	$("#userGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");


$(document).ready(function(){
	$('#schStrtDate').datepicker({dateFormat: 'yy-mm-dd'});
	$('#schEndDate').datepicker({dateFormat: 'yy-mm-dd'});
	$('#schStrtDate').datepicker('setDate', new Date());
	$('#schEndDate').datepicker('setDate', new Date());
	userGrid.id("userGrid");
	userGrid.colModel(userColModel);
	userGrid.rowNum(2000);
	userGrid.rownumbers(true);
	userGrid.call();

	userSearch();
});

$("#orderBy").change(function(){
	userSearch();
});

$("#sortBy").change(function(){
	userSearch();
});

$("#search").click(function(){
	empSearchDataReset();
	userSearch();
});


//srchUserId 입력 후 엔터
$("#srchUserId").keyup(function(e){

	if(e.keyCode==13){
		$("#search").click();
	}
});

//사용자명 입력 후 엔터
$("#srchUsernm").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});


function userSearch(){


	userSearchData.srchUserId=$('#srchUserId').val();
	userSearchData.srchUsernm=$('#srchUsernm').val();
	userSearchData.schStrtDate=removeHyphen($('#schStrtDate').val());
	userSearchData.schEndDate=removeHyphen($('#schEndDate').val());

	userSearchData.orderBy=$('#orderBy').val();
	userSearchData.sortBy=$('#sortBy').val();
	progressShow();
	USHI01_Service.getAgtLogOut(userSearchData,function(jsonData){
		progressHide();
		//console.log(jsonData);
		if(jsonData.result=="S"){
			userGrid.setGrid(jsonData);
			//userGrid.setSelectRowFunc("userSelectRow");
			//alert(JSON.stringify(jsonData));
		} else {
			LLYNX_Alert(jsonData.msg);
		}
	});

}

function empSearchDataReset(){
	userSearchData = { srchUserId : "", srchUsernm : "", schStrtDate : "", schEndDate : "", orderBy:"schDate", sortBy:"desc" };
}

