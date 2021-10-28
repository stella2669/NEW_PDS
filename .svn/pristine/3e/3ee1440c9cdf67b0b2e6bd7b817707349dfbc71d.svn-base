/**
 * DNC그룹에 DNC리스트 할당
 */

var loginInfo = _getLoginInfo();

var orignDncListsId = [];

var addDncListIds = [];
var removeDncListIds = [];

var dncGroupLinkData = {
	dnclistIds: [],
	setDefaultDnclist: false,
	dnclistId:""
}

$(document).ready(function(){
	if(selectedDncGroupId!=""){
		ECMService.getAPI("dncgroups/"+selectedDncGroupId,function(result){
			if(result.result=="S"){
				orignDncListsId = result.dnclistNames
				$("#dncGroupNm").text(result.name);
				setDncListSelect();
			}else{
				if(result.code!=null){
					LLYNX_Alert(ECMError(result.code, result.message));
				}else{
					LLYNX_Alert(result.msg);
				}
			}
		});
	}else{
		LLYNX_Alert("선택된 DNC그룹 정보가 없습니다.\n다시 시도해주세요.", 'function', 'thisPopupClose')
	}
});

$('#dncListSelect').on('change', function () {
	// 기본 DNC리스트 option 설정
	var selectedItems = $("#dncListSelect").jqxListBox("getSelectedItems");
	var options='<option value="">-기본 DNC리스트-</option>';
	for(var i=0;i<selectedItems.length;i++){
		options+='<option value="'+selectedItems[i].value+'">'+selectedItems[i].label+'</option>'
	}
	$("#defaultDncList").html(options);
});

$("#setDefaultDnclist").change(function(){
	if($("#setDefaultDnclist").prop("checked")){
		$("#defaultDncList").prop("disabled", false);
	}else{
		$("#defaultDncList").prop("disabled", true);
	}
});

$("#save").click(function(){
	var selectedItems = $("#dncListSelect").jqxListBox("getSelectedItems");
	var selectedItemsIds = [];
	for(var i=0;i<selectedItems.length;i++){
		selectedItemsIds.push((selectedItems[i].value)*1);
	}

	/*var equlas = selectedItemsIds.filter(x => orignDncListsId.includes(x));*/
	if(selectedItemsIds.length>0){
		// 추가된 DNC리스트 목록
		addDncListIds = selectedItemsIds;
		setDncGroupLinkData(addDncListIds);
		if(addDncListIds.length>0){
			LLYNX_Confirm("할당하시겠습니까?", "connectDncList");
		}
	}else{
		LLYNX_Alert("연결할 DNC리스트가 선택되지 않았습니다.");
	}
});

function connectDncList(){
	ECMService.insertAPI("dncgroups/"+selectedDncGroupId+"/dnclists", JSON.stringify(dncGroupLinkData), function(addResult){
		if(addResult.successCount>0){
			parent.document.getElementById("ifr_tabs-PG_CUNC_01").contentDocument.getElementById("dncGroupManager").contentWindow.dncGroupSearch();
			LLYNX_Alert("총 "+addResult.totalCount+"건 중 "+addResult.successCount+"개의 DNC리스트가 연결되었습니다.", "close");
		}else if(addResult.result=="F"){
			if(addResult.code!=null){
				LLYNX_Alert("DNC리스트 연결 중 에러가 발생하였습니다."+"에러코드 : "+addResult.code+", 에러메시지 : "+addResult.message);
			}else{
				LLYNX_Alert(addResult.msg);
			}
		}
	});
}

$(".popup_close").click(function(){
	parent.popupClose();
});

function setDncListSelect(){
	ECMService.getAPI("dnclists", JSON.stringify({cuurentPage:1, pageSize:1000}), function(result){
		if(result.result=="S"){
			$("#dncListSelect").jqxListBox({ source: null, multiple: true, width: 300, height: 150});
			for(var i=0;i<result.contents.length;i++){
				$("#dncListSelect").jqxListBox("addItem", {label:result.contents[i].name, value:result.contents[i].id});
			}
			if(orignDncListsId.length>0){
				var allItems=$("#dncListSelect").jqxListBox("getItems");
				for(var i=0;i<orignDncListsId.length;i++){
					for(var j=0;j<allItems.length;j++){
						if(orignDncListsId[i]==allItems[j].label){
							$("#dncListSelect").jqxListBox('selectItem', allItems[j]);
						}
					}
				}
			}

			ECMService.getAPI("dncgroups/"+selectedDncGroupId+"/default-dnclist", JSON.stringify({dncgroupId : selectedDncGroupId}), function(result){
				if(result.result=="S"){
					$("#setDefaultDnclist").prop("checked", true);
					$("#defaultDncList").prop("disabled", false);
					$("#defaultDncList").val(result.id);
				}else{
					if(result.code!="127"){
						LLYNX_Alert("DNC그룹의 기본 DNC리스트 정보를 가져오는 중 에러가 발생하였습니다.\n."+"에러코드 : "+result.code+", 에러메시지 : "+result.message);
					}
				}
			});
		}
	});
}

function setDncGroupLinkData(list){
	dncGroupLinkData.dnclistIds = list;
	dncGroupLinkData.setDefaultDnclist = $("#setDefaultDnclist").prop("checked");
	if($("#setDefaultDnclist").prop("checked")){
		if($("#defaultDncList").val()==""){
			LLYNX_Alert("기본 DNC리스트 설정을 체크하시면 기본 DNC리스트를 선택해야 합니다.", "focus", "defaultDncList");
			return false;
		}
		dncGroupLinkData.dnclistId = $("#defaultDncList").val()*1;
	}else{
		dncGroupLinkData.dnclistId = null;
	}
	return true;
}

function thisPopupClose(){
	parent.popupClose();
}