/**
 *
 */


var alertMsg = "";

var alertEvent = "";

var alertDoc = "";
var alertFuncNm = "";

var confirmFunc;

function LLYNX_Alert(msg, event, value){
	var chMsg = JSON.stringify(msg).replace(/\\n/g, "<br/>").replace(/"/g,"");
	if($(".popup_window").length){
		if(!$("#alertLayer").length){
			var layer = $("<div/>",{
				class:"popup_wrap",
				id:"alertLayer"
			});
			$("body").prepend(layer);
		}
		$("#alertLayer").show();
		$("#alertLayer").html('<iframe id="alertIfr" src="/common/alert.do" onload="addAlertMsg();"></iframe>');
		alertMsg = chMsg;

		if(event!=null && event!='' && event!=undefined){
			alertEvent = event;
			if(event=="focus"){
				alertDoc = value;
			}else if(event=="function"){
				alertFuncNm = value;
			}else if(event=="confirm"){
				confirmFunc = value;
			}
		}
	}else{
		if(!$("#alertLayer", top.document).length){
			var layer = $("<div/>",{
				class:"popup_wrap",
				id:"alertLayer"
			});
			$("body", top.document).prepend(layer);
		}
		$("#alertLayer", top.document).show();
		$("#alertLayer", top.document).html('<iframe id="alertIfr" src="/common/alert.do" onload="addAlertMsg();"></iframe>');
		$("#alertLayer", top.document).contents().find("#alertIfr").find(".popup_window").find(".popup_content").find(".popup_body").find("#msg").html(chMsg);
		top.alertMsg = chMsg;

		if(event!=null && event!='' && event!=undefined){
			top.alertEvent = event;
			if(event=="focus"){
				top.alertDoc = value;
			}else if(event=="function"){
				top.alertFuncNm = value;
			}else if(event=="close"){
				top.alertPopClose="Y";
			}
		}

	}
}

function LLYNX_Confirm(msg, value, where){
	var chMsg = JSON.stringify(msg).replace(/\\n/g, "<br/>").replace(/"/g,"");
	if($(".popup_window").length){
		if(!$("#alertLayer").length){
			var layer = $("<div/>",{
				class:"popup_wrap",
				id:"alertLayer"
			});
			$("body").prepend(layer);
		}
		$("#alertLayer").show();
		$("#alertLayer").html('<iframe id="alertIfr" src="/common/confirm.do" onload="addAlertMsg();"></iframe>');
		alertMsg = chMsg;
		if(where=="top"){
			alertEvent="topFunc";
		}else{
			alertEvent="function";
		}
		alertFuncNm = value;
	}else{
		if(!$("#alertLayer", top.document).length){
			var layer = $("<div/>",{
				class:"popup_wrap",
				id:"alertLayer"
			});
			$("body", top.document).prepend(layer);
		}
		$("#alertLayer", top.document).show();
		$("#alertLayer", top.document).html('<iframe id="alertIfr" src="/common/confirm.do" onload="addAlertMsg();"></iframe>');
		$("#alertLayer", top.document).contents().find("#alertIfr").find(".popup_window").find(".popup_content").find(".popup_body").find("#msg").html(chMsg);
		top.alertMsg = chMsg;
		if(where=="top"){
			top.alertEvent="topFunc";
		}else{
			top.alertEvent="function";
		}
		top.alertFuncNm = value;
	}
}

function addAlertMsg() {
	$("#alertIfr").contents().find(".popup_window").find(".popup_content").find(".popup_body").find("#msg").html(alertMsg.replace(/\\n/g, "<br/>"));
}

function afterConfirm(){
	if(alertEvent!=""){
		if($(".popup_window", parent.document).length>0){
			var ifr = $("#layerPopup", parent.parent.document);
			if(alertEvent=="focus"){
				ifr.contents().find("#"+alertDoc).focus();
			}else if(alertEvent=="function"){
				if(ifr[0].contentWindow.window.length){
					ifr[0].contentWindow.window[0][alertFuncNm]();
				}else{
					ifr[0].contentWindow.window[alertFuncNm]();
				}
			}else if(alertEvent=="topFunc"){
				window[alertFuncNm]();
			}else if(alertEvent=="close"){
				parent.popupClose();
			}
		}else{
			if($("#contents").length){
				if(findTab()!=undefined){
					var ifr = $("#"+findTab());
					if(alertEvent=="focus"){
						ifr.contents().find("#"+alertDoc).focus();
					}else if(alertEvent=="function"){
						if(ifr[0].contentWindow.window.length){
							ifr[0].contentWindow.window[0][alertFuncNm]();
						}else{
							ifr[0].contentWindow.window[alertFuncNm]();
						}
					}else if(alertEvent=="topFunc"){
						window[alertFuncNm]();
					}else if(alertEvent=="close"){
						parent.popupClose();
					}
				}else{
					window[alertFuncNm]();
				}

			}else{
				if(alertEvent=="focus"){
					$("#"+alertDoc).focus();
				}else if(alertEvent=="function"){
					window[alertFuncNm]();
				}else if(alertEvent=="close"){
					parent.popupClose();
				}
			}
		}
	}
}

//메인화면 팝업 종료
function alertClose() {
	afterConfirm();
	$("#alertLayer").hide();
	$("#alertLayer").html("");
	alertMsg="";
	alertEvent="";
	alertDoc="";
	alertFuncNm="";
}

function confirmClose(){
	$("#alertLayer").hide();
	$("#alertLayer").html("");
	alertMsg="";
	alertEvent="";
	alertDoc="";
	alertFuncNm="";
}

function findTab(){
	var id="";
	$("#contents").find("#tabs").find("div").each(function(){
		if($(this).css("display")!="none"){
			id=$(this).find("iframe").attr("id");
		}
	});
	return id;
}