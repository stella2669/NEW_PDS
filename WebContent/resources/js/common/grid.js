var webticsGrid = function () {
    var f = {};
    var o = {
    			$f:jQuery(f)
    			, type:"POST"
    			, dataType:"local"
    			, rowNum:50
                , rowList:[50,100,200]
                , viewRecords:false
                , autoWidth:true
                , height: "auto"
                , width: "auto"
                , multiSelect: false
                , colNames:[]
                , colModel:[]
                , options:{ edit:false, add:false, del:false }
                , sortOrder:"ASC"
                , jsonReader:{root:"gridList", page:1, total:50}
                , loadonce:true
                , cellEvent:[]
                , rowEvent:""
                , data:[]
                , loadui: "disable"
                , loadtext:""
                , rownumbers:false
				, cmTemplate:{title:false, sortable:false}
    };

    f.id = function(id) {
        o.id = "#" + id;
        return f;
    };
    f.url = function(url){
        o.url = url;
        return f;
    };
    f.type = function(type) {
        o.type = type;
        return f;
    };
    f.dataType = function(dataType) {
        o.dataType = dataType;
        return f;
    };
    f.rownumbers = function(rownumbers) {
        o.rownumbers = rownumbers;
        return f;
    };f.rownumWidth = function(rownumWidth) {
        o.rownumWidth = rownumWidth;
        return f;
    };
    f.rowNum = function(rowNum) {
        o.rowNum = rowNum;
        return f;
    };
    f.rowTotal = function(rowTotal) {
        o.rowTotal = rowTotal;
        return f;
    };
    f.rowList = function(rowList){
        o.rowList = rowList;
        return f;
    };
    f.pager = function(pager) {
        o.pager = "#" + pager;
        return f;
    };
    f.viewRecords = function(viewRecords) {
        o.viewRecords = viewRecords;
        return f;
    };
    f.autoWidth = function(autoWidth) {
        o.autoWidth = autoWidth;
        return f;
    };
    f.width = function(width) {
        o.width = width;
        return f;
    };
    f.height = function(height) {
        o.height = height;
        return f;
    };
    f.multiSelect = function(multiSelect) {
        o.multiSelect = multiSelect;
        return f;
    };
    f.colNames = function(colNames) {
        if ($.type(colNames) === "array") {
            o.colNames = colNames;
        }
        return f;
    };
    f.colModel = function(colModel) {
        if ($.type(colModel) === "array") {
            o.colModel = colModel;
        }
        return f;
    };
    f.options = function(options) {
        if ($.type(options) === "object") {
            o.options = options;
        }
        return f;
    };
    f.jsonReader = function(jsonReader) {
        if ($.type(jsonReader) === "object") {
            o.jsonReader = jsonReader;
        }
        return f;
    };
    f.sortName = function(sortName) {
        o.sortName = sortName;
        return f;
    };
    f.sortOrder = function(sortOrder) {
        o.sortOrder = sortOrder;
        return f;
    };
    f.caption = function(caption) {
        o.caption = caption;
        return f;
    };
    f.loadonce= function(loadonce) {
        o.loadonce = loadonce;
        return f;
    };
    f.complete = function(complete) {
        o.complete = complete;
        return f;
    };
    f.cellEvent = function(array){
        if(array.length>1){ // multi cell event add
            for(var item in array){
                o.cellEvent[item] = arguments[item];
            }
        } else {
    	  for(var item in array){
              o.cellEvent[item] = arguments[item];
          }
        }
        return f;
    };

    f.autoencode = function() {
    	o.autoencode = autoencode;
    	return f;
    }

    f.getRowCount = function() {
    	return $(o.id).getGridParam("records");
    };
    f.getRowData = function(rowId) {
    	return $(o.id).jqGrid("getRowData", rowId);
    };

    f.footerrow = function(footerrow){
    	o.footerrow = footerrow;
    	return f;
    };

    f.userDataOnFooter = function(userDataOnFooter) {
    	o.userDataOnFooter = userDataOnFooter;
    	return f;
    }

    f.cellEdit = function(cellEdit){
    	o.cellEdit = cellEdit;
    	return f;
    };

    f.cellsubmit = function(cellsubmit) {
    	o.cellsubmit = cellsubmit;
    	return f;
    }

    f.hoverrows = function(hoverrows) {
    	o.hoverrows = hoverrows;
    	return f;
    }

    f.call = function call()
    {
        $(o.id).jqGrid({
            url:           o.url
            , autowidth:   o.autoWidth
            , height:      o.height
            , width:       o.width
            , mtype :      o.type
            , datatype:    o.dataType
            , colNames:    o.colNames
            , colModel:    o.colModel
            , rownumbers:  o.rownumbers
            , rownumWidth: o.rownumWidth
            , rowNum:      o.rowNum
            , rowTotal:    o.rowTotal
            , rowList:     o.rowList
            , pager:       o.pager
            , sortname:    o.sortName
            , sortorder:   o.sortOrder
            , viewrecords: o.viewRecords
            , caption:     o.caption
            , cellEdit:    o.cellEdit
            , cellsubmit:  o.cellsubmit
            , multiselect: o.multiSelect
            , jsonReader : o.jsonReader
            , loadonce:    o.loadonce
            , footerrow:   o.footerrow
            , userDataOnFooter: o.userDataOnFooter
            , loadtext:    o.loadtext
            , loadui:      o.loadui
			, hoverrows:   o.hoverrows
			, cmTemplate:  o.cmTemplate
            , loadComplete: function(data) {
                if ($(o.id).getGridParam("records")===0) { // 조회결과 없음
                	$(o.id +" > tbody").append("<tr><td align='center' colspan="+$(o.id).jqGrid('getGridParam','colModel').length+" style='border:none; border-bottom:1px solid #c8c8c8;'>조회된 데이터가 없습니다.</td></tr>");
        		} else {
        			// TODO 데이터가 있을때 처리 가능
        		}

//            	$(o.id).jqGrid('navGrid', o.pager, o.options);
                if(!fnIsNull(o.complete)){
                    if(typeof(o.complete) == "function"){
                        o.complete(data);
                    } else {
                        eval(o.complete + "(data);");
//                    	new Function("return "+ o.complete + "(data);")();
                    }
                }
              }
            , loadError: function(xhr, status, errorThrown) {
            	// console.log("grid 오류 : " + xhr.status + " : " + status + " : " + errorThrown);
              }
            , onCellSelect: function(rowId, iCol, content, event) {
                var cm = $(o.id).jqGrid('getGridParam','colModel');
                var colName = cm[iCol].name;

                // multiple event
                if (o.cellEvent.length>1) {
                	for (var i=0; i<o.cellEvent.length; i++) {
                		try {
                			var evnetList = o.cellEvent[i];
	                		if (evnetList[0]== colName && !fnIsNull(evnetList[1])) {
	                            if (typeof(o.cellEvent) == "function") {
	                            	evnetList[1](rowId);
	                            } else {
	                                eval(evnetList[1] + "(rowId);");
//	                            	new Function("return "+ evnetList[1] + "(rowId);")();
	                            }
	                        }
                		} catch (e) {
//                			return;
                			// console.log("grid.js -> "+ e);
                		}
                	}
                } else {
                    if(o.cellEvent[0] == colName && !fnIsNull(o.cellEvent[1])) {
                        if (typeof(o.cellEvent) == "function") {
                            o.cellEvent[1](rowId);
                        } else {
                            eval(o.cellEvent[1] + "(rowId);");
//                        	new Function("return "+ o.cellEvent[1] + "(rowId);")();

                        }
                    }
                }
              }
			, gridComplete: function() {  /** 데이터 로딩시 함수 **/
                var grid = this;

                $('td[name="cellRowspan"]', grid).each(function() {
                    var spans = $('td[rowspanid="'+this.id+'"]',grid).length+1;
                    if(spans>1){
                     $(this).attr('rowspan',spans);
                    }
                });
            }
          });
      };

	f.getSelectedRowList = function() {
		var rowid = $(o.id).jqGrid("getGridParam", "selarrrow");
		if (!rowid || rowid.length == 0) {
			return null;
		}
		var list = new Array();
		for(var i=0; i<rowid.length; i++) {
			list.push($(o.id).jqGrid("getRowData", rowid[i]));
		}
		return list;
	}

	f.setGrid = function setGrid(data){
		var gridId = o.id.replace("#",'')
		if(data.list!=null&&data.list.length>0){
			$(o.id).clearGridData();
			$("#pager_"+gridId).html("");

			$(o.id).jqGrid("setGridParam", {
				data: data.list
			});
			if(data.paging!=null){
				var setPagingInfo = "setPageInfo_"+gridId;
				var paging = "paging_"+gridId;

				if (data.paging.paging.totalPage>1) { // 페이지가 있으면 보여줌
					window[setPagingInfo](data);
					window[paging]();
				}else{
					$("#pager_"+gridId).html("");
				}
			}

			$(o.id).trigger("reloadGrid");
			$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
		}else{
			$(o.id).clearGridData();
			$(o.id).trigger("reloadGrid");
			$("#pager_"+gridId).html("");
		}
	}


	f.setECMGrid = function setGrid(data){
		var gridId = o.id.replace("#",'');
		if(data.contents!=null){
			$(o.id).clearGridData();
			$("#pager_"+gridId).html("");

			$(o.id).jqGrid("setGridParam", {
				data: data.contents
			});

			if(data.currentPage!=null){
				var setPagingInfo = "setPageInfo_"+gridId;
				var paging = "paging_"+gridId;

				if (data.totalPageCount>1) { // 페이지가 있으면 보여줌
					window[setPagingInfo](data);
					window[paging]();
				}else{
					$("#pager_"+gridId).html("");
				}
			}

			$(o.id).trigger("reloadGrid");
			$('.ui-jqgrid .ui-jqgrid-bdiv').css('overflow-x', 'hidden');
		}else{
			$(o.id).clearGridData();
			$(o.id).trigger("reloadGrid");
			$("#pager_"+gridId).html("");
		}
	}

	f.setSelectRowFunc = function setSelectRowFunc(funcNm){
		$(o.id).jqGrid("setGridParam", {
			onSelectRow: function(rowid, status, e) {
				var rowData = $(o.id).jqGrid("getRowData", rowid);
				window[funcNm](rowData, rowid);
			}
		});
		$(o.id+" tr").css("cursor", "pointer");
	}

	f.setonCellSelectFunc = function setonCellSelectFunc(funcNm){
		$(o.id).jqGrid("setGridParam", {
			onCellSelect: function(rowid, iCol, cellcontent, e) {
				var rowData = $(o.id).jqGrid("getRowData", rowid);
				window[funcNm](rowData, rowid,iCol,cellcontent);
			}
		});
	}

	f.setDblclickRowFunc = function setDblclickRowFunc(funcNm){
		$(o.id).jqGrid("setGridParam", {
			ondblClickRow : function(rowid, iRow, iCol, e) {
				var rowData = $(o.id).jqGrid("getRowData", rowid);
				window[funcNm](rowData, rowid);
			}
		});
		$(o.id+" tr").css("cursor", "pointer");
	}

	f.resetGrid = function resetGrid(){
		$(o.id).clearGridData();
		$(o.id).trigger("reloadGrid");
	}

    return f;
};

