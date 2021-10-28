/**
 * 고객데이터 추출
 */

var loginInfo = _getLoginInfo();

var campContactInfo = {};

var applySameFilterTemplate = false;
var defaultFilter = "";

$(document).ready(function(){
	if(parent.campContactlistInfo.contactlists.length>0){
		for(var i=0;i<parent.campContactlistInfo.contactlists.length;i++){
			if(i==0){
				$(".contactRows").eq(i).find(".contactSelect").val(parent.campContactlistInfo.contactlists[i].contactList);
				$(".contactRows").eq(i).find(".filterSelect").val(parent.campContactlistInfo.contactlists[i].filterTemplateName);
				$("#applySameFilterTemplate").prop("checked", parent.campContactlistInfo.applySameFilterTemplate);
				applySameFilterTemplate = parent.campContactlistInfo.applySameFilterTemplate;
				if(parent.campContactlistInfo.applySameFilterTemplates){
					defaultFilter = parent.campContactlistInfo.contactlists[i].filterTemplateName;
					$("#applySameFilterTemplate").change();
				}
			}else{
				addList(parent.campContactlistInfo.contactlists[i].contactList, parent.campContactlistInfo.contactlists[i].filterTemplateName);
			}
		}
	}
});


$("#applySameFilterTemplate").change(function(){
	if($(this).prop("checked")){
		if($("#filterTemplate_0").val()==""){
			applySameFilterTemplate = false;
			$(this).prop("checked", false);
			LLYNX_Alert("적용할 필터 템플릿을 설정해주세요.");
		}else{
			applySameFilterTemplate = true;
			defaultFilter = $("#filterTemplate_0").val();
			$(".filterSelect").val(defaultFilter);
			$(".filterSelect").attr("disabled", true);
		}
	}else{
		applySameFilterTemplate = false;
		defaultFilter="";
		$(".filterSelect").attr("disabled", false);
	}
});

$("#addList").click(function(){
	addList();
});


$("#save").click(function(){
	// 컨택리스틑 정보 말아서 캠페인 데이터에 넣어주기!

	campContactInfo.contactlists = [];
	campContactInfo.applySameFilterTemplate = $("#applySameFilterTemplate").prop("checked");
	$(".contactRows").each(function(){
		var contactSelect = $(this).find(".contactSelect").val();
		var filterSelect = $(this).find(".filterSelect").val();
		var rowInfo={};
		if(contactSelect!=""){
			rowInfo.contactList = contactSelect;
			rowInfo.filterTemplateName = filterSelect;
			campContactInfo.contactlists.push(rowInfo);
		}
	});

	if(campContactInfo.contactlists.length==0){
		LLYNX_Alert("적어도 하나의 컨택리스트를 선택해야합니다.");
	}else{
		parent.campContactlistInfo = campContactInfo;
		parent.setRecorderAttributesList();
		parent.popupClose();
	}
});


$(".popup_close").click(function(){
	parent.popupClose();
});


function addList(contactValue, filterValue){
	var row = '<tr class="contactRows"><th scope="row">컨택리스트</th><td><select title="컨택리스트 선택" class="contactSelect">';


	ECMService.getAPI("contactlists", JSON.stringify({currentPage:1, pageSize:1000}), function(result){
		if(result.result=="S"){
			var contactOptions = '<option value="">-컨택리스트 선택-</option>';
			for(var i=0;i<result.contents.length;i++){
				if(contactValue!=""&&contactValue!=null&&contactValue!=undefined){
					if(contactValue == result.contents[i].name){
						contactOptions += '<option selected>'+result.contents[i].name+'</option>'
					}else{
						contactOptions += '<option>'+result.contents[i].name+'</option>'
					}

				}else{
					contactOptions += '<option>'+result.contents[i].name+'</option>'
				}
			}
			row += contactOptions+'</select></td>';
			row += '<th scope="row">필터 템플릿</th><td><select title="필터템플릿 선택" class="filterSelect">';
			ECMService.getAPI("filtertemplates", JSON.stringify({currentPage:1, pageSize:1000}), function(result){
				if(result.result=="S"){
					var filterOptions = '<option value="">-필터템플릿 선택-</option>';
					for(var i=0;i<result.contents.length;i++){
						if(applySameFilterTemplate){
							if(result.contents[i].name==defaultFilter){
								filterOptions += '<option selected>'+result.contents[i].name+'</option>';
							}else{
								filterOptions += '<option>'+result.contents[i].name+'</option>';
							}
						}else{
							if(filterValue!=""&&filterValue!=null&&filterValue!=undefined){
								if(filterValue == result.contents[i].name){
									filterOptions += '<option selected>'+result.contents[i].name+'</option>';
								}else{
									filterOptions += '<option>'+result.contents[i].name+'</option>';
								}
							}else{
								filterOptions += '<option>'+result.contents[i].name+'</option>';
							}
						}
					}
					row += filterOptions+'</select><button type="button" class="btn btn_primary btn_size_n ml_10 del_row"><i class="xi-trash"></i>삭제</button></td></tr>';
					$("#rows").append(row);

					if(applySameFilterTemplate){
						$(".filterSelect").attr("disabled", true);
					}

					$(".del_row").click(function(){
						var thisRow = $(this).closest("tr");
						thisRow.remove();
					});
				}else{
					if(result.code!=null){
						LLYNX_Alert(ECMError(result.code, result.message));
					}else{
						LLYNX_Alert(result.msg);
					}
				}
			});
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

