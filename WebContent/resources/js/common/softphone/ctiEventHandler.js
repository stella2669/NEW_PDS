/*
 * cti function 
 */
"use strict"

// CTI에서 호출되는 function lists.................
var userCmd;
var phoneStat;
function OnResult(Command, Result, Details) {
	SP_INFO.eventResult.cmd = Command.split(":")[0];
	SP_INFO.eventResult.result = parseInt(Result);
	SP_INFO.eventResult.dtlinfo = Details;
	
	phoneStat = $.trim(Details);
	
	if (SP_INFO.eventResult.result != 1  // 처리실패
			&& COMMAND_LIST.GET_DATA_STR != SP_INFO.eventResult.cmd  // CTI 데이터 조회
			&& COMMAND_LIST.GET_DATA_INTRINSIC != SP_INFO.eventResult.cmd  // CTI 데이터 조회
			&& COMMAND_LIST.GET_DATA_UUI != SP_INFO.eventResult.cmd  // CTI 데이터 조회
			&& COMMAND_LIST.SET_DATA_STR != SP_INFO.eventResult.cmd  // CTI 데이터 전송
			&& COMMAND_LIST.SET_DATA_INTRINSIC != SP_INFO.eventResult.cmd  // CTI 데이터 전송
			&& COMMAND_LIST.SET_DATA_UUI != SP_INFO.eventResult.cmd // CTI 데이터 전송
	) { // CTI 데이터 조회시 데이터가 없는것은 skip 처리
		progressHide();
		
//		if ("The agent login failed due to an internal system error." == phoneStat) {
//			softphoneHandler(SP_INFO.eventResult.cmd);
//			return;
//		}
		fnSPLogging("OnResult", "CTI 오류 발생["+SP_INFO.eventResult.cmd+"] / "+phoneStat, false);
		
		if (COMMAND_LIST.INIT_SDK == SP_INFO.eventResult.cmd 
				|| COMMAND_LIST.CONNECT_SERVER == SP_INFO.eventResult.cmd 
				|| COMMAND_LIST.LOGIN == SP_INFO.eventResult.cmd)// 로그인중 오류 발생되면 미사용으로 처리 - eventparam은 예외
		{
			if ("The agent has already been loggedin." == phoneStat) {
				LLYNX_Alert("소프트폰["+SP_INFO.eventResult.cmd+"] 로그인한 내선입니다.\n\n전화기 로그인 상태 확인후 다시 로그인하세요.");
				
			} else if ("There is no available terminal." == phoneStat) {
				LLYNX_Alert("소프트폰["+SP_INFO.eventResult.cmd+"] 통화중인 내선입니다.\n\n전화기 통화 상태 확인후 다시 로그인하세요.");
				
			} else if ("서버가 클라이언트 자격 증명을 거부했습니다." == phoneStat 
					|| "The server rejected the client credentials and reset the socket connection." == phoneStat) {
				LLYNX_Alert("소프트폰["+SP_INFO.eventResult.cmd+"] 로그인중 오류가 발생되었습니다.\n\n잘못된 CTI 로그인 ID입니다.\n로그인ID 확인후 다시 로그인하세요.");
				
			} else if ("Already Inited" == phoneStat || "There is no agent loggedin." == phoneStat 
					       || "The agent has already been loggedout." == phoneStat) { // 이미 로그인되어 있음
				softphoneHandler(COMMAND_LIST.LOGIN);
				fnSPLogging("OnResult", "CTI 로그인중 오류 발생["+SP_INFO.eventResult.cmd+"] 이미 로그인되어 있음", false);
				return;
				
			} else {
				LLYNX_Alert("소프트폰["+SP_INFO.eventResult.cmd+"] 로그인중 오류가 발생되었습니다.\n\n소프트폰 사용이 불가능합니다.\n관리자에게 문의하세요.\n\n\n오류 메세지\n"+phoneStat);
			}
			softphoneHandler(COMMAND_LIST.NOT_USE);
			fnSPLogging("OnResult", "CTI 로그인중 오류 발생["+SP_INFO.eventResult.cmd+"]", false);
		} else if (COMMAND_LIST.LOGOUT == SP_INFO.eventResult.cmd 
					|| COMMAND_LIST.DEINIT_SDK == SP_INFO.eventResult.cmd ) { // 로그아웃은 무시하고 지나간다.
			if ("The terminal is busy." == phoneStat) {
				LLYNX_Alert("소프트폰["+SP_INFO.eventResult.cmd+"] 통화중에는 소프트폰 로그아웃이 불가능합니다.");
			}
			fnSPLogging("OnResult", "CTI 로그아웃중 오류 발생["+SP_INFO.eventResult.cmd+"]", false);
		} else {
			if (COMMAND_LIST.NOT_READY == SP_INFO.eventResult.cmd ) { // 상태변경시 아웃바운드 통화종료일 경우 두번호출해야 해서 예외처리함
				return;
			}
			if ("The agent has already been loggedin." == phoneStat) {
				LLYNX_Alert("다른 자리에서 로그인된 내선번호입니다.\n소프트폰 미사용자로 로그인합니다.");
				
				softphoneHandler(COMMAND_LIST.NOT_USE);
			} else if (" There is no available contact." == phoneStat) {
				LLYNX_Alert("지금 전화기 상태에서 사용할 수 없는 기능입니다.\n잠시후 다시 시도하세요.");
			} else {
				LLYNX_Alert("소프트폰["+SP_INFO.eventResult.cmd+"] 처리중 오류가 발생되었습니다.\n\n오류코드["+Result+"] 오류내용\n"+phoneStat);
			}
		}
	} else { // 정상처리
		softphoneHandler(SP_INFO.eventResult.cmd);
	}
	
	// 이미 확인된 로그는 다시 로깅하지 않는다
	if (SP_INFO.eventResult.cmd != "OnConnectionState"
			|| SP_INFO.eventResult.cmd != "OnRemoteConnectionState"
			|| SP_INFO.eventResult.cmd != "OnTerminalConnectionState") {
		
		fnSPLogging("OnResult", "Command: " + Command + ", Result: " + Result + ", Details: " + Details, false);
	}
}
var connStat = {};
function OnConnectionState(Name, URI, DoNotDisturb, IsForwarded, ResourceState, ConnectionContactID, New, Previous, isRemote, Reason, CalledAddr
		, CallingAddr, CallingTerminal, ContactType, ContactID, LastReDirectAddr, MainContactID, OriginalDestination) {

    if ($.trim(MainContactID) == SP_INFO.tel.cid 
    		&& $.trim(MainContactID) !=  $.trim(ConnectionContactID)) {
		SP_INFO.tel.otherCid = $.trim(ConnectionContactID);
	}
	
	connStat.reason = Reason;
	connStat.cmd = New;
	connStat.previous = Previous;
	connStat.connectionContactID = $.trim(ConnectionContactID);
	connStat.mainContactID = $.trim(MainContactID);
	connStat.contactID = $.trim(ContactID);
	connStat.contactType = ContactType;
	connStat.resourceState = ResourceState;
	connStat.calledAddr = CalledAddr;
	connStat.callingAddr = CallingAddr;
	connStat.callingTerminal = CallingTerminal;
	connStat.name = Name;
	connStat.uri = URI;
	connStat.doNotDisturb = DoNotDisturb;
	connStat.isForwarded = IsForwarded;
	connStat.isRemote = isRemote;
	connStat.lastReDirectAddr = LastReDirectAddr;
	connStat.originalDestination = OriginalDestination;
	SP_INFO.eventResult.connStat = connStat;

	fnSPLogging("OnConnectionState", connStat, false);
	
	// 호전환 3자 이벤트는 제외
	if (Reason == COMMAND_LIST.EVENT_TRANSFER
			|| Reason == COMMAND_LIST.EVENT_TRANSFER_COMPLETE
			|| Reason == COMMAND_LIST.EVENT_CONFERENCE
			|| Reason == COMMAND_LIST.EVENT_CONFERENCE_COMPLETE) 
	{
		return;
	}
	
	OnResult(COMMAND_LIST.FROM_CONNECTION_STAT, 1, "");
}
var remoteStat = {};
function OnRemoteConnectionState(Name, URI, DoNotDisturb, IsForwarded, ResourceState, ConnectionContactID, New, Previous, isRemote, Reason, CalledAddr
		, CallingAddr, CallingTerminal, ContactType, ContactID, LastReDirectAddr, MainContactID, OriginalDestination) {

    if ($.trim(MainContactID) == SP_INFO.tel.cid 
    		&& $.trim(MainContactID) !=  $.trim(ConnectionContactID)) {
		SP_INFO.tel.otherCid = $.trim(ConnectionContactID);
	}
    
	remoteStat.reason = Reason;
	remoteStat.cmd = New;
	remoteStat.previous = Previous;
	remoteStat.connectionContactID = $.trim(ConnectionContactID);
	remoteStat.mainContactID = $.trim(MainContactID);
	remoteStat.contactID = $.trim(ContactID);
	remoteStat.contactType = ContactType;
	remoteStat.resourceState = ResourceState;
	remoteStat.calledAddr = CalledAddr;
	remoteStat.callingAddr = CallingAddr;
	remoteStat.callingTerminal = CallingTerminal;
	remoteStat.name = Name;
	remoteStat.uri = URI;
	remoteStat.doNotDisturb = DoNotDisturb;
	remoteStat.isForwarded = IsForwarded;
	remoteStat.isRemote = isRemote;
	remoteStat.lastReDirectAddr = LastReDirectAddr;
	remoteStat.originalDestination = OriginalDestination;
	SP_INFO.eventResult.remoteStat = remoteStat;
	
	fnSPLogging("OnRemoteConnectionState", remoteStat, false);

	// 호전환 3자 이벤트는 제외
	if (Reason == COMMAND_LIST.EVENT_TRANSFER
			|| Reason == COMMAND_LIST.EVENT_TRANSFER_COMPLETE
			|| Reason == COMMAND_LIST.EVENT_CONFERENCE
			|| Reason == COMMAND_LIST.EVENT_CONFERENCE_COMPLETE) 
	{
		return;
	}
	OnResult(COMMAND_LIST.FROM_REMOTE_CONNECTION_STAT, 1, "");
}
var terminalStat = {};
function OnTerminalConnectionState(Name, URI, DoNotDisturb, IsForwarded, ResourceState, ConnectionContactType, ConnectionContactID, New, Previous, isMute, Reason, CalledAddr
		, CallingAddr, CallingTerminal, ContactType, ContactID, LastReDirectAddr, MainContactID, OriginalDestination) {

    if ($.trim(MainContactID) == SP_INFO.tel.cid 
    		&& $.trim(MainContactID) !=  $.trim(ConnectionContactID)) {
		SP_INFO.tel.otherCid = $.trim(ConnectionContactID);
	}
    
	terminalStat.reason = Reason;
	terminalStat.cmd = New;
	terminalStat.previous = Previous;
	terminalStat.connectionContactID = $.trim(ConnectionContactID);
	terminalStat.mainContactID = $.trim(MainContactID);
	terminalStat.contactID = $.trim(ContactID);
	terminalStat.connectionContactType = ConnectionContactType;
	terminalStat.contactType = ContactType;
	terminalStat.resourceState = ResourceState;
	terminalStat.calledAddr = CalledAddr;
	terminalStat.callingAddr = CallingAddr;
	terminalStat.callingTerminal = CallingTerminal;
	terminalStat.name = Name;
	terminalStat.uri = URI;
	terminalStat.doNotDisturb = DoNotDisturb;
	terminalStat.isForwarded = IsForwarded;
	terminalStat.isMute = isMute;
	terminalStat.lastReDirectAddr = LastReDirectAddr;
	terminalStat.originalDestination = OriginalDestination;
	SP_INFO.eventResult.terminalStat = terminalStat;

	fnSPLogging("OnTerminalConnectionState", terminalStat, false);
	
	// 호전환 3자 이벤트는 제외
	if (Reason == COMMAND_LIST.EVENT_TRANSFER
			|| Reason == COMMAND_LIST.EVENT_TRANSFER_COMPLETE
			|| Reason == COMMAND_LIST.EVENT_CONFERENCE
			|| Reason == COMMAND_LIST.EVENT_CONFERENCE_COMPLETE) 
	{
		return;
	}
	
	OnResult(COMMAND_LIST.FROM_TERMINAL_CONNECTION_STAT, 1, "");
}
function OnError(Info, Details) {
	if ("Socket Connection Error" == $.trim(Info)) {
		LLYNX_Alert("CTI 서버 접속이 불가능합니다.\n관리자에게 문의하세요.");
	}
	
	fnSPLogging("OnError", "OnError -> Info: " + Info + ", Details: " + Details, true);
}
function OnSendComplete(Command, Sequence, Reserved){
	fnSPLogging("OnSendComplete", "Command : "+Command+" , Sequence : "+Sequence, false);
}	

function OnAgentState(TerminalName, AgentState, UserID, ReasonCode, LoginID) {	
	employeeStatusHandler(AgentState, ReasonCode);

	fnSPLogging("OnAgentState", "TerminalName: " + TerminalName + ", AgentState: " + AgentState + ", UserID: " + UserID + ", ReasonCode: " + ReasonCode + ", LoginID: " + LoginID, false);	
}
function OnEvent(Command, Info, Reserved){
	fnSPLogging("OnEvent", "Command: "+Command+", Info: "+Info+" , Reserved: "+Reserved, false);
}
function OnConfirm(Command, Result, Details) {
	fnSPLogging("OnConfirm", "Command: " + Command + ", Confirm: " + Result + ", Details: " + Details, false);
}
function OnCCTState(UserID, data, AgentState) {
	fnSPLogging("OnCCTConnect", "UserID: " + UserID + ", data: " + data + ", AgentState: " + AgentState, false);
}
function OnLinkState(LinkState, LinkStateReason, LinkID, ToolkitState, ServerAddress, Terminalname) {
	fnSPLogging("OnLinkState", "LinkState: " + LinkState + ", LinkStateReason: " + LinkStateReason + ", LinkID: " + LinkID + ", ToolkitState: " + ToolkitState + ", ServerAddress: " + ServerAddress + ", Terminalname: " + Terminalname, false);
}
function OnData(Cmd, ContactID, CallData, Result, Details) {
	fnSPLogging("OnData", " Command: " + Cmd + ", Confirm: " + Result + ", Details: " + Details, false);
}
function OnServerInfo(Result, Detail, ServerA, ServerS, ServerG, ServerPort) {
	fnSPLogging("OnServerInfo", "ServerA: " + ServerA + ", ServerS: " + ServerS + ", ServerG: " + ServerG + ", ServerPort: " + ServerPort + ", Result: " + Result + ", Detail: " + Detail, false);
}
function OnReadContact(Result, Subject, Body, From, To, Bcc, Cc, Time, Priority, Skillset, Status, Attachments, Details) {
	fnSPLogging("OnReadContact", "Result: " + Result + ", Subject: " + Subject + ", Body: " + Body + ", From: " + From  + ", To: " + To  + ", Bcc: " + Bcc  + ", Cc: " + Cc + ", Time: " + Time  + ", Priority: " + Priority + ", Skillset:" + Skillset + ", Status:" + Status + ", Attachments: " + Attachments + ", Details:" + Details, false);
}