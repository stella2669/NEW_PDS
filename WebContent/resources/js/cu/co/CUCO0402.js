/**
 * 데이터이스 가져올 데이터 맵핑
 */

var selectedColumns = [];

var mappingData = {};

var analQuery = {
	columns:[],
	table:"",
	conditions:[]
}

$(document).ready(function(){
	if(parent.dbMappingData.databaseQuery!=null && parent.dbMappingData.databaseQuery!="" && parent.dbMappingData.databaseQuery!=undefined){
		// 기존데이터가 있을 때 테이블리스트 세팅 후 기존 데이터 세팅
		setTableList(function(){setOriginTableData();});
	}else{
		setTableList();
	}
	setContactlistAttr();
});

function setContactlistAttr(){
	ECMService.getAPI("contactlists/"+selectContactlistId+"/attributes", function(result){
		if(result.result=="S"){
			for(var i=0;i<result.contents.length;i++){
				$("#"+result.contents[i].id).text("*"+$("#"+result.contents[i].id).text());
				$("#"+result.contents[i].id).css("font-weight", 900);
			}
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg)
			}
		}
	});
}

$("#columnList").on('select', function(event){
	var args = event.args;
	var item = args.item;

	if(item.value=="*"){
		var allItems = $("#columnList").jqxListBox('getItems');
		for(var i=0;i<allItems.length;i++){
			$("#columnList").jqxListBox('selectItem', allItems[i]);
		}
	}
});


$('#columnList').on('change', function () {
	// 기본 DNC리스트 option 설정
	var selectedItems = $("#columnList").jqxListBox("getSelectedItems");
	var allItems = $("#columnList").jqxListBox("getItems");
	var options='<option value="">-선택한 컬럼-</option>';
	selectedColumns.length = 0;
	var columns = "";
	for(var i=0;i<selectedItems.length;i++){
		selectedColumns.push(selectedItems[i].label);
		options+='<option>'+selectedItems[i].label+'</option>'
		if(i==0){
			columns+=selectedItems[i].label;
		}else{
			columns+=", "+selectedItems[i].label;
		}
	}

	if($("#tableList").val()!=""){
		if(selectedItems.length==allItems.length-1){
			$("#defaultQuery").text("SELECT * FROM "+$("#tableList").val());
		}else{
			$("#defaultQuery").text("SELECT "+columns+" FROM "+$("#tableList").val());
		}
	}
	$(".mapCol").html(options);
});


$("#save").click(function(){
	if(setMappingData()){
		var connectInfo = parent.dbConnectInfo;
		connectInfo.query = mappingData.databaseQuery;
		CUCO01_Service.getRowCount(connectInfo, function(result){
			if(result.result=="S"){
				parent.dbMappingData = mappingData;
				parent.showMappingData();
				parent.popupClose();
			}else{
				LLYNX_Alert("비정상적인 쿼리입니다.\n 다시 확인 후 선택해주세요.");
			}
		});
	}
});

$(".popup_close").click(function(){
	parent.popupClose();
});

function analysisQuery(callback){
	if(parent.dbMappingData.databaseQuery!=null && parent.dbMappingData.databaseQuery!="" && parent.dbMappingData.databaseQuery!=undefined){
		// 테이블명 추출
		var query = parent.dbMappingData.databaseQuery.toLowerCase();
		var tableName = "";
		if(query.indexOf("from")!=-1){
			if(query.indexOf("where")!=-1){
				tableName = query.substring(query.indexOf("from")+5, query.indexOf("where")-1);
			}else{
				tableName = query.substring(query.indexOf("from")+5);
			}
		}

		if(tableName.trim().indexOf(" ")!=-1){
			tableName = tableName.trim().split(" ")[0];
		}

		analQuery.table = tableName.trim();

		// 컬럼리스트 추출
		var columnsQuery = "";
		var columns = [];
		if(query.indexOf("select")!=-1){
			if(query.indexOf("from")!=-1){
				columnsQuery = query.substring(query.indexOf("select")+7, query.indexOf("from")-1);
			}else{
				columnsQuery = query.substring(query.indexOf("select")+7);
			}
		}
		console.log(columnsQuery);

		if(columnsQuery.indexOf(",")!=-1){
			columns = columnsQuery.split(",");
			for(var i=0;i<columns.length;i++){
				analQuery.columns.push(columns[i].trim());
			}
		}else{
			if(columnsQuery.indexOf("*")!=-1){
				analQuery.columns.push(columnsQuery.trim());
			}else{
				analQuery.columns.push(columnsQuery.trim());
			}
		}


		if(query.indexOf("where")!=-1){
			$("#whereclause").val(parent.dbMappingData.databaseQuery.substring(query.indexOf("where")));
		}

		if(callback!=null&&callback!=undefined){
			callback();
		}
	}
}

function setMappingData(){
	if($("#tableList").val()==""){
		LLYNX_Alert("선택한 테이블이 없습니다.");
		return false;
	}else if(selectedColumns.length==0){
		LLYNX_Alert("선택한 컬럼이 없습니다.");
		return false;
	}else{
		mappingData.systemAttributeMappingList = [];
		$(".predAttr").each(function(){
			var thisTr = $(this);
			if(thisTr.find(".mapCol").val()!=""){
				// 특성 컬럼 매핑데이터 리스트
				var mappingObj = {};
				mappingObj.attributeName = thisTr.find(".mapAttr").text().replace("*","");
				mappingObj.remoteDatabaseColumnName = thisTr.find(".mapCol").val();
				mappingData.systemAttributeMappingList.push(mappingObj);
			}
		});

		if($(".customAttr").length>0){
			mappingData.customAttributeMappingList = [];
			$(".customAttr").each(function(){
				var thisTr = $(this);
				if(thisTr.find(".mapCol").val()!=""){
					// 특성 컬럼 매핑데이터 리스트
					var mappingObj = {};
					mappingObj.attributeName = thisTr.find(".mapCustomAttr").val();
					mappingObj.remoteDatabaseColumnName = thisTr.find(".mapCol").val();
					mappingData.customAttributeMappingList.push(mappingObj);
				}
			});
		}

		mappingData.databaseQuery = $("#defaultQuery").text()+" "+$("#whereclause").val();

		if(mappingData.systemAttributeMappingList.length==0){
			LLYNX_Alert("특성과 매핑되는 컬럼이 존재하지 않습니다.");
			return false;
		}

		return true;
	}
}

function setTableList(callback){
	progressShow();
	CUCO01_Service.getTableList(parent.dbConnectInfo, function(result){
		if(result.result=="S"){
			var options ='<option value="">-테이블선택-</option>';
			for(var i=0;i<result.tableList.length;i++){
				options+='<option>'+result.tableList[i]+'</option>';
			}
			$("#tableList").html(options);

			if(callback!=null&&callback!=undefined){
				callback();
			}
			progressHide();

		}else{
			progressHide();
			LLYNX_Alert("테이블리스트를 가져오는데 실패하였습니다", "close");
		}
	});
}

function tableChange(obj, callback){
	var thisVal = $(obj).val();
	var param = parent.dbConnectInfo;
	param.tableName = thisVal;
	console.log(param);
	$("#columnList").jqxListBox({ source: null, multiple: true, width: 200, height: '100%'});
	CUCO01_Service.getColumnList(param, function(result){
		 if(result.result=="S"){
			$("#columnList").jqxListBox("clear");
			if(result.columnList.length>1){
				$("#columnList").jqxListBox("addItem", {label:"전체(*)", value:"*"});
			}
			for(var i=0;i<result.columnList.length;i++){
				$("#columnList").jqxListBox("addItem", {label:result.columnList[i], value:result.columnList[i]});
			}
			$("#defaultQuery").text("SELECT FROM "+thisVal);

			if(callback!=null&&callback!=undefined){
				callback();
			}
		}else{
			LLYNX_Alert("컬럼리스트를 가져오는데 실패하였습니다", "close");
		}
	});
}

function setOriginTableData(){
	analysisQuery(function(){
		console.log(analQuery.table);
		$("#tableList").val(analQuery.table);
		tableChange($("#tableList"), function(){
			setOriginColumnData();
		});
	});
}

function setOriginColumnData(){
	setColumnData(function(){
		if(parent.dbMappingData.systemAttributeMappingList.length>0){
			for(var i=0;i<parent.dbMappingData.systemAttributeMappingList.length;i++){
				$(".mapAttr").each(function(){
					if($(this).text().replace("*","")==parent.dbMappingData.systemAttributeMappingList[i].attributeName){
						if(parent.dbMappingData.systemAttributeMappingList[i].remoteDatabaseColumnName!="-"){
							$(this).closest("tr").find(".mapCol").val(parent.dbMappingData.systemAttributeMappingList[i].remoteDatabaseColumnName);
							$(".mapCol").change();
						}
					}
				});
			}
		}

		if(parent.dbMappingData.customAttributeMappingList.length>0){
			for(var i=0;i<parent.dbMappingData.customAttributeMappingList.length;i++){
				var index = i;
				addCustomAttr(function(){
					$(".customAttr").eq(index).find(".mapCustomAttr").val(parent.dbMappingData.customAttributeMappingList[index].attributeName);
					$(".customAttr").eq(index).find(".mapCol").val(parent.dbMappingData.customAttributeMappingList[index].remoteDatabaseColumnName);
					$(".mapCol").change();
				});
			}
		}
	});
}


function setColumnData(callback){
	if(analQuery.columns.length>0){
		if(analQuery.columns.length==1&&analQuery.columns[0]=="*"){
			var allItems = $("#columnList").jqxListBox('getItems');
			for(var i=0;i<allItems.length;i++){
				if(i!=0){
					$("#columnList").jqxListBox('selectItem', allItems[i]);
				}
			}
		}else{
			for(var i=0;i<analQuery.columns.length;i++){
				$("#columnList").jqxListBox('selectItem', $("#columnList").jqxListBox('getItemByValue', analQuery.columns[i]));
			}
		}

	}else{
		analysisQuery(function(){
			for(var i=0;i<analQuery.columns.length;i++){
				$("#columnList").jqxListBox('selectItem', $("#columnList").jqxListBox('getItemByValue', analQuery.columns[i]));
			}
		});
	}
	callback();
}

function addCustomAttr(callback){
	var tr = '<tr class="customAttr">';
	ECMService.getAPI("attributes", JSON.stringify({currentPage:1, pageSize:10000}), function(result){
		if(result.result=="S"){
			var custopnAttrOptions = '';
			var colOptions='<option value="">-선택한 컬럼-</option>';
			for(var i=0;i<result.contents.length;i++){
				if(result.contents[i].attributeType!="Predefined"){
					custopnAttrOptions+='<option dataType="'+result.contents[i].dataType+'">'+result.contents[i].contactPropertyName+'</option>';
				}
			}
			for(var i=0;i<selectedColumns.length;i++){
				colOptions+='<option>'+selectedColumns[i]+'</option>'
			}
			tr+='<td><select class="mapCustomAttr"><option value="">-커스텀 특성-</option>'+custopnAttrOptions+'</select></td>';
			tr+='<td><select class="mapCol">'+colOptions+'</select></td></tr>';
			$("#mapTbody").append(tr);


			if(callback!=null && callback!=undefined){
				callback();
			}
		}else{
			if(result.code!=null){
				LLYNX_Alert(ECMError(result.code, result.message));
			}else{
				LLYNX_Alert(result.msg);
			}
		}
	});
}

function delCustomAttr(){
	var trLeng = $(".customAttr").length;
	if(trLeng>0){
		$(".customAttr").eq(trLeng-1).remove();
	}else{
		LLYNX_Alert("추가된 커스텀특성 매핑정보가 없습니다.");
	}
}

function selectQueryReset(){
	$("#columnList").text("테이블을 선택해주세요.");
	$("#columnList").removeAttr("class");
	$("#columnList").addClass("a_c");
	$(".mapCol").each(function(){
		var colOptions='<option value="">-선택한 컬럼-</option>';
		$(this).html(colOptions);
	});
	$("#tableList").val("");
}