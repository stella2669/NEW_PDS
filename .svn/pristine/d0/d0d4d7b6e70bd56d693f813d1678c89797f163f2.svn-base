/**
 * 캠페인통계 페이지
 */

$(document).ready(function(){
	$('#schStrtDate').datepicker({dateFormat: 'yy-mm-dd'});
	$('#schEndDate').datepicker({dateFormat: 'yy-mm-dd'});
	$('#schStrtDate').datepicker('setDate', new Date());
	$('#schEndDate').datepicker('setDate', new Date());

	if(schby!=""){
		$('#schStrtDate').val(schStrtDate.substr(0,4)+"-"+schStrtDate.substr(4,2)+"-"+schStrtDate.substr(6,2));
		$('#schEndDate').val(schEndDate.substr(0,4)+"-"+schEndDate.substr(4,2)+"-"+schEndDate.substr(6,2));
		$('#schby').val(schby);
		$('#schCampNm').val(schCampNm);
		$('#schCampNm').focus();
	}
});

$("#schCampNm").keyup(function(e){
	if(e.keyCode==13){
		$("#search").click();
	}
});

$("#search").click(function(){
	var queryString = "/al/alcc01.do?";
	queryString+="schStrtDate="+$('#schStrtDate').val().replace(/-/ig, "")+"&";
	queryString+="schEndDate="+$('#schEndDate').val().replace(/-/ig, "")+"&";
	queryString+="schby="+$('#schby').val()+"&";
	queryString+="schCampNm="+$('#schCampNm').val();
	$("#ifr_tabs-PG_ALCC_01", parent.document).attr("src", queryString);
});

$("#schby").change(function(){
	var queryString = "/al/alcc01.do?";
	queryString+="schStrtDate="+$('#schStrtDate').val().replace(/-/ig, "")+"&";
	queryString+="schEndDate="+$('#schEndDate').val().replace(/-/ig, "")+"&";
	queryString+="schby="+$('#schby').val()+"&";
	queryString+="schCampNm="+$('#schCampNm').val();
	$("#ifr_tabs-PG_ALCC_01", parent.document).attr("src", queryString);
});

$("#excelDown").click(function(){
	var title="";
	var fileNm="";
	var url = $("#ifr_tabs-PG_ALCC_01", parent.document).attr("src");
	if(schby=="DEFAULT"){
		title="캠페인 완료코드 요약통계";
		fileNm="캠페인 완료코드 요약통계_"+schStrtDate+"_"+schEndDate;
	}else if(schby=="DATE"){
		title="캠페인 완료코드 일자별통계";
		fileNm="캠페인 완료코드 일자별통계_"+schStrtDate+"_"+schEndDate;
	}else{
		title="캠페인 완료코드 시간대별통계";
		fileNm="캠페인 완료코드 시간대별통계_"+schStrtDate+"_"+schEndDate;
	}
	url = "/al/alcc01ex.do?"+url.split("?")[1]+"&title="+title+"&fileNm="+fileNm;
	$(location).attr("href", url);
});

function noDataAlert(){
	LLYNX_Alert("출력할 데이터가 없습니다.");
}