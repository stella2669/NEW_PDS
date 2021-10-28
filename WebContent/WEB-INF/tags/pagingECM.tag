<%@ attribute name="srchFuncNm" type="java.lang.String" %>
<%@ attribute name="gridId" type="java.lang.String" %>
<%@ tag language="java" pageEncoding="UTF-8"%>

<script type="text/javascript">

var srchFuncNm_${srchFuncNm} = "${srchFuncNm}";

var firstYn_${gridId} = true;
var currentPage_${gridId} = 1
var pageSize_${gridId} = 0;
var totalCount_${gridId} = 0;
var totalPage_${gridId} = 0;
var firstRowIndex_${gridId} = 0;
var lastRowIndex_${gridId} = 0;

function setFirstSrch_${gridId}(){
	firstYn_${gridId} = true;
	currentPage_${gridId} = 1
}

function setCurrentSrch_${gridId}(){
	firstYn_${gridId} = false;
}

function getFirstYn_${gridId}(){
	return firstYn_${gridId};
}

function setCurrentPage_${gridId}(btn, pageNo){
	switch ( btn ) {
	case "prev":
		currentPage_${gridId} = currentPage_${gridId} - 1;
		if ( currentPage_${gridId} < 1 ) currentPage_${gridId} = 1;
		break;
	case "next":
		currentPage_${gridId} = currentPage_${gridId} + 1;
		if ( currentPage_${gridId} > totalPage_${gridId} ) currentPage_${gridId} = totalPage_${gridId};
		break;
	case "first":
		currentPage_${gridId} = 1;
		break;
	case "last":
		currentPage_${gridId} = totalPage_${gridId};
		break;
	case "go":
		currentPage_${gridId} = pageNo;
		break;
	}
}

function setPageInfo_${gridId}( data ) {
	currentPage_${gridId} = data.currentPage;

	if(data.currentPage==1){
		pageSize_${gridId} = data.contents.length;
		totalCount_${gridId} = data.totalCount;
		totalPage_${gridId} = data.totalPageCount;
		firstRowIndex_${gridId} = 1+((currentPage_${gridId}-1)*pageSize_${gridId});
		lastRowIndex_${gridId} = pageSize_${gridId}*currentPage_${gridId};
	}else if(data.totalPageCount==data.currentPage){
		// 마지막 페이지일때
		totalCount_${gridId} = data.totalCount;
		totalPage_${gridId} = data.totalPageCount;
		firstRowIndex_${gridId} = 1+((currentPage_${gridId}-1)*pageSize_${gridId});
		lastRowIndex_${gridId} = data.totalCount;
	}else{
		totalCount_${gridId} = data.totalCount;
		totalPage_${gridId} = data.totalPageCount;
		firstRowIndex_${gridId} = 1+((currentPage_${gridId}-1)*pageSize_${gridId});
		lastRowIndex_${gridId} = pageSize_${gridId}*currentPage_${gridId};
	}
}

function getPageInfo_${gridId} ( dataObject ) {
	dataObject.currentPage = currentPage_${gridId};
	return dataObject;
}
// 	new pageInfo();

function paging_${gridId}() {
	var pager = $('#pager_${gridId}');
	htmlString = "";
	htmlString += "<button type='button' class='btn btn_dark btn_size_s btn_none btn_rad_5 mr_5' onclick='first_${gridId}();'>"+
			      "<i class='xi-forward xi-rotate-180'></i><span class='replace_text'>처음</span></button>"+
			      "<button type='button' class='btn btn_dark btn_size_s btn_none btn_rad_5' onClick='prev_${gridId}();'><i class='xi-caret-right xi-rotate-180'></i>"+
			      "<span class='replace_text'>이전</span></button><div class='number'><span class='page'><b>페이지 :</b>";

	var pageButtons = "";
	var maxPage = 5; // 노출될 페이지 수
	if(totalPage_${gridId}>5&&currentPage_${gridId}>3){
		pageButtons+="<span style='color:#555;cursor:pointer' onClick='go_${gridId}("+1+");'>1</span>";
		pageButtons+="... ";
	}
	for(var i=0;i<maxPage;i++){
		if(totalPage_${gridId}<6){
			if((i+1)<=totalPage_${gridId}){
				if((i+1)==currentPage_${gridId}){
					pageButtons+="<span style='color:#ea494b;cursor:pointer' onClick='go_${gridId}("+(i+1)+");'>"+(i+1)+"</span>"
				}else{
					pageButtons+="<span style='color:#555;cursor:pointer' onClick='go_${gridId}("+(i+1)+");'>"+(i+1)+"</span>";
				}
			}
		}else{
			if(currentPage_${gridId}<4){
				if((i+1)==currentPage_${gridId}){
					pageButtons+="<span style='color:#ea494b;cursor:pointer' onClick='go_${gridId}("+(i+1)+");'>"+(i+1)+"</span>"
				}else{
					pageButtons+="<span style='color:#555;cursor:pointer' onClick='go_${gridId}("+(i+1)+");'>"+(i+1)+"</span>";
				}
			}else if(currentPage_${gridId}<totalPage_${gridId}-1){
				var minPage = -2;
				var pageNo = currentPage_${gridId}+(minPage+i)
				if(pageNo==currentPage_${gridId}){
					pageButtons+="<span style='color:#ea494b;cursor:pointer' onClick='go_${gridId}("+pageNo+");'>"+pageNo+"</span>"
				}else{
					pageButtons+="<span style='color:#555;cursor:pointer' onClick='go_${gridId}("+pageNo+");'>"+pageNo+"</span>";
				}
			}else{
				var minPage= totalPage_${gridId}-4;
				var pageNo = minPage+i;
				if(pageNo==currentPage_${gridId}){
					pageButtons+="<span style='color:#ea494b;cursor:pointer' onClick='go_${gridId}("+pageNo+");'>"+pageNo+"</span>"
				}else{
					pageButtons+="<span style='color:#555;cursor:pointer' onClick='go_${gridId}("+pageNo+");'>"+pageNo+"</span>";
				}
			}
		}
	}
	if(totalPage_${gridId}>5&&currentPage_${gridId}<totalPage_${gridId}-2){
		pageButtons+="... ";
		pageButtons+="<span style='color:#555;cursor:pointer' onClick='go_${gridId}("+totalPage_${gridId}+");'>"+totalPage_${gridId}+"</span>";
	}
	htmlString += pageButtons;
	htmlString += "<span class='item ml_5'><b>보기 :</b><span>"+ firstRowIndex_${gridId} + "  -  " + lastRowIndex_${gridId} + "</span><span>" + totalCount_${gridId} +
			      "</span></span></div><button type='button' class='btn btn_dark btn_size_s btn_none btn_rad_5' onClick='next_${gridId}();'><i class='xi-caret-right'></i>"+
			      "<span class='replace_text'>다음</span></button><button type='button' class='btn btn_dark btn_size_s btn_none btn_rad_5 ml_5' onclick='last_${gridId}()'>"+
			      "<i class='xi-forward'></i><span class='replace_text'>마지막</span></button>";
	pager.html( htmlString );
}

function first_${gridId}() {
	setCurrentPage_${gridId}('first');
	setCurrentSrch_${gridId}();
	window[srchFuncNm_${srchFuncNm}]();
}

function last_${gridId}() {
	setCurrentPage_${gridId}('last');
	setCurrentSrch_${gridId}();
	window[srchFuncNm_${srchFuncNm}]();
}

function prev_${gridId}() {
	setCurrentPage_${gridId}('prev');
	setCurrentSrch_${gridId}();
	window[srchFuncNm_${srchFuncNm}]();
}

function next_${gridId}() {
	setCurrentPage_${gridId}('next');
	setCurrentSrch_${gridId}();
	window[srchFuncNm_${srchFuncNm}]();
}

function go_${gridId}(pageNo) {
	setCurrentPage_${gridId}('go', pageNo);
	setCurrentSrch_${gridId}();
	window[srchFuncNm_${srchFuncNm}]();
}

</script>
<div id="pager_${gridId}" class='paging'></div>
