/**
 * 컨택리스트 연결특성 조회
 */
var attrColModel = [
	{label:"특성ID", name:"attrinfoId", align:"center", width:30},
	{label:"특성명", name:"attrinfoNm", align:"left", width:70},
	{label:"특성 유형", name:"attrinfoTypeNm", align:"center", width:50},
	{label:"순서", name:"sortNo", width:30, align:"center"}
//	{label:"데이터 유형", name:"dataType", align:"center", width:50}
]

var attrGrid = new webticsGrid();

$(document).ready(function(){
	attrGrid.id("attrGrid");
	attrGrid.colModel(attrColModel);
	attrGrid.rowNum(1000);
	attrGrid.call();
	
	setLinkedAttrList();
});

// 연결된 특성목록 확인
function setLinkedAttrList(){
	if(selectedAttrListId != "" && selectedAttrListId!="undefined"){
		CUAT01_Service.getAttrInfoList({attrListSeq : selectedAttrListId}, function(result){
			console.log(result.list);
			if(result.result == "S"){
				attrGrid.setGrid(result);
			}else{
				LLYNX_Alert(result.msg, 'close');
			}
		});
	}else{
		LLYNX_Alert("선택된 컨택리스트 정보가 없습니다.\n다시 시도해주세요.", 'function', 'thisPopupClose')
	}
}

$(".popup_close").click(function(){
	parent.popupClose();
});
