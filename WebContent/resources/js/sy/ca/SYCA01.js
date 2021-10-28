/**
 * 상담원 완료코드목록 관리 페이지
 */


var codeColModel = [
	{label:"완료코드 ID", name:"id", align:"center", width:20},
	{label:"완료코드명", name:"name", align:"left", width:60},
	{label:"완료코드 유형", name:"completioncodeType", align:"center", width:40},
	{label:"생성자", name:"createdBy", align:"center", width:40},
	{label:"마지막 수정", name:"lastModifiedOn", align:"center", width:60},
	{label:"설명", name:"description", align:"left", width:80}
]

var codeSearchData = {
	currentPage:1,
	pageSize:20,
	order:"",
	sort:"",
	searchBy:"",
	searchValue:""
}

var codeGrid = new webticsGrid();

//grid resize
$(window).bind("resize", function() {
	$("#codeGrid").setGridWidth($("#divGrid").width(), true);
	// 가로 스크롤 제거
	$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
}).trigger("resize");


$(document).ready(function(){
	codeGrid.id("codeGrid");
	codeGrid.colModel(codeColModel);
	codeGrid.call();

	codeListSearch();
});

function codeListSearch(){
	ECMService.getAPI("completioncodes/custom", function(result){
		if(result.result=="S"){
			//console.log(result);
			codeGrid.setECMGrid(result);
		}else{
			LLYNX_Alert(result.msg);
		}
	});
}