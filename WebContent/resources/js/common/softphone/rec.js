/*
 * 녹취
 */

function sendRecInfo(url, act) {
	var  VCMP = {VCMP:{version:"2.0",direction:{src:"AP",dest:"CTXManager"},msg:{}}};
	
	VCMP.VCMP.msg.id = act;
	VCMP.VCMP.msg.seq = recSeq();
	VCMP.VCMP.msg.agent_id = cnsrInfo.cnsrId;
	VCMP.VCMP.msg.ext_no = ctiInfo.inwrNo;
	VCMP.VCMP.msg.cti_login_id = ctiInfo.id;
	VCMP.VCMP.msg.cid_no = SP_INFO.tel.dialNo;
	VCMP.VCMP.msg.iobound = SP_INFO.tel.io != "" ? (SP_INFO.tel.io == "IN" ? "I" : "O") : "";
	VCMP.VCMP.msg.reckey = SP_INFO.tel.recKey;
	VCMP.VCMP.msg.req_date = getCallDateTimeStr();
	
	sendRecData(url, VCMP);
}

function sendRecInfoData(url, act, lcls, mcls, scls, sbusNo, goodsNm) {
	var  VCMP = {VCMP:{version:"2.0",direction:{src:"AP",dest:"CTXManager"},msg:{}}};
	
	if (SP_INFO.tel.recKey == "" || typeof SP_INFO.tel.recKey == "undefined") {
		fnSPLogging("sendRecInfoData", "녹취키 not fiound : 이전에 생성한 녹취키: [" +backupRecKey+ "], SP_INFO.tel.recKey : [" +SP_INFO.tel.recKey+ "]", true);
		return;
	}
	
	VCMP.VCMP.msg.id = act;
	VCMP.VCMP.msg.seq = recSeq();
	VCMP.VCMP.msg.agent_id = cnsrInfo.cnsrId;
	VCMP.VCMP.msg.ext_no = ctiInfo.inwrNo;
	VCMP.VCMP.msg.reckey = SP_INFO.tel.recKey;
	VCMP.VCMP.msg.data = [{name: "VALUE1", value: custInfo.s_cust_krnm}
							, {name: "VALUE2", value: custInfo.s_csno}
							, {name: "VALUE3", value: sbusNo}
							, {name: "VALUE4", value: custInfo.s_cmpg_id}
							, {name: "VALUE5", value: lcls}
							, {name: "VALUE6", value: mcls}
							, {name: "VALUE7", value: scls}
							, {name: "VALUE8", value: goodsNm}];
	VCMP.VCMP.msg.req_date = getCallDateTimeStr();
	
	sendRecData(url, VCMP);
}

function popupRec(url, key) {
	var uri = url +"?reckey="+key+"&agentid="+cnsrInfo.cnsrId;
	window.open(uri, "녹취팝업", "width=800,height=600");
	
	fnSPLogging("popupRec", uri, false);
}

function sendRecData(recUrl, param) {
	fnSPLogging(recUrl+ " send", param, false);

	$.ajax({
		url: recUrl
		, data: JSON.stringify(param)
//		, timeout: 500
		, method: "POST"
		, contentType: "application/x-www-form-urlencoded; charset=utf-8"
		, dataType: "json"
		, async: true
		, success: function(data) {
			fnSPLogging("녹취  :"+recUrl+" success", data, false);
		}, error: function(data) {
			fnSPLogging("녹취  :"+recUrl+" error ", data, true);
			LLYNX_Alert(recUrl.split("/")[3]+"\n\n녹취서버에서 응답이 없습니다.\n관리자에게 문의하세요.");
		}, complete: function(data) {}
	});
}

function recSeq() {
	var c = new Date();
	var seq = c.getMinutes().fill(2) +c.getSeconds().fill(2)+c.getMilliseconds()+ctiInfo.inwrNo.substr(2,2);
	
//	// console.log("214748367 < " + seq);
	if (parseInt(seq)>214748367) {
		seq = parseInt(seq)-214748300;
	}
	
	return seq;
}