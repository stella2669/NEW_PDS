//////////////////////////////////////////////////
//
// ETS_Client
// Script Version 9.3.x 
//
//////////////////////////////////////////////////

// var websocket_url = 'ws://127.0.0.1:19373';
// var update_url = 'ws://127.0.0.1:19372';
var etsInfo = _getLoginInfo();
var websocket_url = etsInfo.socketUrl;
var update_url = etsInfo.socketUpdate;

//console.log("websocket_url="+ websocket_url+ ", update_url="+update_url);

var ECSETSInfo = new Object();
	ECSETSInfo.m_nUniqueID = 0;
	ECSETSInfo.m_strDN = "";
	ECSETSInfo.m_InitCheck = 0;
	ECSETSInfo.m_strMsgId = "";
	ECSETSInfo.m_strMsgType = "";
	ECSETSInfo.m_strSeq = 0;
	ECSETSInfo.m_strReserved = "";
	ECSETSInfo.m_strData = "";
	ECSETSInfo.m_logMsg = "";
	ECSETSInfo.m_isSupervisor = "N";
	ECSETSInfo.m_freeSeatSrv = "";
	
var ECSETSSocket = new Object();
	ECSETSSocket.m_ws = null;
	ECSETSSocket.m_ws_state = 0;
	ECSETSSocket.m_ws_updateSDK = null;
	ECSETSSocket.m_ws_updateSDK_state  = 0;
	ECSETSSocket.m_ws_timeout = null;
	ECSETSSocket.m_aliveReceiveWatcher = null;
	ECSETSSocket.m_aliveSendWatcher = null;

var ECSETSParcer = new Object();
	ECSETSParcer.m_mapParam = new obj();
	
	
/**
 * 한글포함 문자열 길이를 구한다
 */
function getTextLength(str) {
    var len = 0;
    for (var i = 0; i < str.length; i++) {
        if (escape(str.charAt(i)).length == 6) {
            len++;
        }
        len++;
    }
	try{
		return len;
	}finally{
		len = null;
	}
}

function prependZero(num, len) {
	while(num.toString().length < len) {
		num = "0" + num;
	}
	try{
		return num;
	}finally{
		num = null;
	}
};
function prependSpace(str, len) {
	while(str.toString().length < len) {
		str = str + " ";
	}
	try{
		return str;
	}finally{
		str = null;
	}
};


function webSocketConnectErr(errCode) {
	OnError("Socket Connection Error", errCode);
	// if (ECSETSInfo.m_InitCheck == 1) {
		// tagStrResult.strResult = "0";
		// tagStrResult.strCmd = "INIT";
		// tagStrResult.strREsultDetail = "Socket Connection Error";

		// OnResult(tagStrResult.strCmd, tagStrResult.strResult, tagStrResult.strREsultDetail);
	// }else{
		// tagStrError.Info = "Socket Connection Error";
		// tagStrError.nErrorCode = "";
  		// OnError(tagStrError.Info, "");
	// }
}


function WS_UpdateSDK_Connect(srtUpdateSrv_IP)
{
   
    if (srtUpdateSrv_IP == '' || srtUpdateSrv_IP == null)
    {
        srtUpdateSrv_IP = ECS_UPDATESRV_IP;
    }
	
	ECSETSSocket.m_ws_updateSDK = new WebSocket(update_url);

    ECSETSSocket.m_ws_updateSDK.onopen = function () {
        
		//SendLogMessage("CMD_UPDATESDK","INFO",'websocket UpdateSDK Server connected('+ srtUpdateSrv_IP + ')');
		ECSETSSocket.m_ws_updateSDK_state = 1;
		if (ECSETSSocket.m_ws_updateSDK_state != 1){
			WS_UpdateSDK_Connect(srtUpdateSrv_IP);
		}else{
			sendUpdateSDK(srtUpdateSrv_IP); 
		}
	};
    ECSETSSocket.m_ws_updateSDK.onmessage = function (event) {
       
		var message = event.data;  
		//console.log("onmessage:"+message);
		var strAlive = message.substr(MSG_ALIVE_CHECK_SIZE, 4);
		if(strAlive == "9999"){
			//console.log("send:"+message);
			//ws_updateSDK.send(message);
			try{
				return;
			}finally{
				strAlive = null;
			}
		}
		EtsMsgProcess(message);
		strAlive = null;
	};
	ECSETSSocket.m_ws_updateSDK.onclose = function (event) {
	    // 소켓이 close 되어 로그를 남길 수 없음.
	    ECSETSSocket.m_ws_updateSDK_state = 0;
		//SendLogMessage("0","WS_UpdateSDK_Connect","INFO",'ws_updateSDK close');
		//webSocketConnectErr(event.code);  
	};
	ECSETSSocket.m_ws_updateSDK.onerror = function (event) {
//		if (ws_updateSDK_state != 1){
//			ws_updateSDK_state = 1;
//			JS_InitSDK();
//		}
		webSocketConnectErr(event.code);
	};
}

function sendUpdateSDK(){
	ECSETSInfo.m_nUniqueID++;
	var strHeader = "";
	var strPacket = "";
	var strUpdateServerInfoIE = makeIEString(IE_UPDATESERVERINFO, ECS_UPDATESRV_IP);
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN,CMD_UPDATESDK, getTextLength(strUpdateServerInfoIE));
	strPacket = strHeader + strUpdateServerInfoIE;
	//console.log("sendUpdateSDK strPacket len :"+getTextLength(strPacket)+", servInfo len :"+getTextLength(strUpdateServerInfoIE)+", packet :"+strPacket);
	SendRequestMessage(ECSETSInfo.m_nUniqueID, CMD_UPDATESDK, strPacket);
	strHeader = null;
	strPacket = null;
}

function WebSocketConnect(){
    var support = "MozWebSocket" in window ? 'MozWebSocket' : ("WebSocket" in window ? 'WebSocket' : null);

    if (support == null) {
		SendLogMessage("WebSocketConnect", "INFO", "Your browser cannot support WebSocket!");
		try{
			return;
		}finally{
			support = null;
		}
    }
         
	if (ECSETSSocket.m_ws_state == 0) { 
		ECSETSSocket.m_ws = new WebSocket(websocket_url);
	}

    ECSETSSocket.m_ws.onopen = function () {
		SendLogMessage("WebSocketConnect", "INFO", "websocket connected");
    	ECSETSSocket.m_ws_state = 1;
    	setTimeout(sendInitSDK, 1000);
    };

   ECSETSSocket.m_ws.onmessage = function (event) {
     	var message = event.data;
		// alive packet ... 10초마다 한번씩 체크
		var strAlive = message.substr(MSG_ALIVE_CHECK_SIZE, 4);
		//console.log("onmessage :"+strAlive);
		if(strAlive == "9999"){
			//console.log("alive received");
			if(ECSETSSocket.m_aliveReceiveWatcher != null){
				clearTimeout(ECSETSSocket.m_aliveReceiveWatcher);
			}
			ECSETSSocket.m_aliveReceiveWatcher = setTimeout(SocketAliveReceiveErrorLog, 11000);
			SendRequestMessage(0,'Alive',message);
			try{
				return;
			}finally{
				strAlive = null;
				message = null;
			}
		}
		//SendLogMessage("1","", "Connect",'recv:['+ message + ']');
		EtsMsgProcess(message);
		message = null;
		strAlive = null;
  	};
  	ECSETSSocket.m_ws.onclose = function (event){
		//SendLogMessage("WebSocketConnect", "INFO","websocket close");
  		ECSETSSocket.m_ws_state = 0;
		OnEvent("WebSocket", "socket is closed", event.code);
		//webSocketConnectErr(event.code);
  	};
  	ECSETSSocket.m_ws.onerror = function(event){
  		ECSETSSocket.m_ws_state = 0;
		//SendLogMessage("WebSocketConnect", "INFO","websocket onerror");
  		webSocketConnectErr(event.code);
	};
}

function SendRequestMessage(nSeq,pszCmd,pszPacket){
    var nLength = pszPacket.toString().length;
    var strTemp = "";
	var iPacketLength = pszPacket.toString().length;

    if (nLength > RECV_MAXSIZE) {
		 strTemp = 'invalid packet Length:' + nLength;
		 SendLogMessage("SendRequestMessage", pszCmd, strTemp);
		 //console.log(strTemp);
		 return;
    }else{
    	if(pszCmd == "MakeCall")
		{
			var iPacketLength = pszPacket.toString().length;
			if( iPacketLength >= 49)
			{
				var DialPacket = pszPacket.substr(0,iPacketLength-4) + "XXXX";
				strTemp = "(Cmd:"+ pszCmd + ") Seq:" + nSeq +", Data:" + DialPacket + 
				          " , SendResult:" + iPacketLength;
				DialPacket = null;
			}
			else
			{
				strTemp = "(Cmd:"+ pszCmd + ") Seq:" + nSeq +", Data:" + pszPacket + 
				          " , SendResult:" + iPacketLength;
			}
		}else if (pszCmd == CMD_UPDATESDK){
			ECSETSSocket.m_ws_updateSDK.send(pszPacket);
			return;
		}else if(pszCmd == "Alive")
		{
			if(ECSETSSocket.m_ws.readyState == 1){
				ECSETSSocket.m_ws.send(pszPacket);
				//console.log("alive send");
				if(ECSETSSocket.m_aliveSendWatcher != null){
					clearTimeout(ECSETSSocket.m_aliveSendWatcher);
				}
				ECSETSSocket.m_aliveSendWatcher = setTimeout(SocketAliveSendErrorLog, 11000);
			}
			try{
				return;
			}finally{
				nLength = null;
				strTemp = null;
				iPacketLength = null;
			}
		}else{
			strTemp = "(Cmd:"+ pszCmd + ") Seq:" + nSeq +", Data:" + pszPacket + 
				          " , SendResult:" + iPacketLength;
		}

		//console.log('Send :[' + pszPacket.toString().length + ']' + '[' + pszPacket + ']');
		if(ECSETSSocket.m_ws != null){
			ECSETSSocket.m_ws.send(pszPacket);
			OnSendComplete(pszCmd, nSeq, "");
			SendLogMessage("SendRequestMessage", pszCmd, strTemp);
		}
    }
	nLength = null;
	strTemp = null;
	iPacketLength = null;
}

function MakeHeader(strSOP, nUniqueID, strMsgType, strDN, strCmd, nIELength) {
	var strHeader = "";
	var nHeaderLength = 0;
	strDN = prependSpace(strDN, 10);
	strHeader =  strSOP +
					prependZero(nUniqueID,5) + 
					strMsgType +
					strDN +
					strCmd;
	if (nIELength == 0) {
		nHeaderLength = strHeader.toString().length + 8;
		strHeader =  strSOP +
				prependZero(nHeaderLength,8) +
				prependZero(nUniqueID,5) + 
				strMsgType +
				strDN +
				strCmd;
				//console.log("MakeHeader 1length :"+getTextLength(strHeader));
	}
	else{
		nHeaderLength = strHeader.toString().length + nIELength + 8;
		strHeader =  
					strSOP +
					prependZero(nHeaderLength,8) +
					prependZero(nUniqueID,5) + 
					strMsgType +
					strDN +
					strCmd;
					//console.log("MakeHeader 2length :"+getTextLength(strHeader));
	}
	//console.log('HEADER :[' + strHeader.toString().length + ']' + strHeader );
	try{
		return strHeader;
	}finally{
		strHeader = null;
		nHeaderLength = null;
	}
}

function sendInitSDK(){
	// var strTemp = "Cmd:" + CMD_INITSDK + ", DN:" + ECSETSInfo.m_strDN;
	// SendLogMessage("sendInitSDK", "InitSDK", strTemp);
	if(ECSETSSocket.m_ws_timeout != null){
		clearTimeout(ECSETSSocket.m_ws_timeout);
		ECSETSSocket.m_ws_timeout = null;
	}

	ECSETSInfo.m_InitCheck = 1;
	
	var strHeader = "";
	var strPacket = "";
	var strDataIE = "";
	var strFreeSeatIE = "";
	var nDataIELength = 0;
	var nFreeSeatIELength = 0;
	
	ECSETSInfo.m_nUniqueID++;
	
	strDataIE = makeIEString(IE_HANGUL, ECSETSInfo.m_isSupervisor);
	nDataIELength = getTextLength(strDataIE);

	if (ECSETSInfo.m_freeSeatSrv != "") {
		strFreeSeatIE = makeIEString(IE_FREESEATSEVER, ECSETSInfo.m_freeSeatSrv)
		nFreeSeatIELength = getTextLength(strFreeSeatIE);
	}

	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_INITSDK, nDataIELength + nFreeSeatIELength);
	
	strPacket = strHeader + strDataIE + strFreeSeatIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, INITSDK, strPacket);
	
	strHeader = null;
	strPacket = null;
	strDataIE = null;
	nDataIELength = null;
}

function EtsEventParam(strEventSenderInfo){
	
	var strEventSenderInfoIE     = "";
	
	var nEventSenderInfoIELength = 0;
	var nIELength = 0;
	
	var strHeader = "";
	var strPacket = "";
	
	ECSETSInfo.m_nUniqueID++;
	
	//EventSenderInfo IE
	strEventSenderInfoIE = makeIEString(IE_EVENTSENDERINFO, strEventSenderInfo);
	nEventSenderInfoIELength = getTextLength(strEventSenderInfoIE);
	
	nIELength = nEventSenderInfoIELength;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_EVENTSERVERINFO2, nIELength);
	strPacket = strHeader + strEventSenderInfoIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, EVENTPARAM2, strPacket);
	strEventSenderInfoIE = null;
	nEventSenderInfoIELength = null;	
	nIELength = null;
	strHeader = null;
	strPacket = null;
}


function EtsEventParams(strEventSenderInfo, strFtpServerInfo, strComplementarySever){
	
	var strEventSenderInfoIE     = "";
	var strFTPServerInfoIE         = "";
	var strComplementaryServerIE = "";
	
	var nEventSenderInfoIELength = 0;
	var nFTPServerInfoIELength = 0;
	var nComplementaryServerIELength = 0;
	var nIELength = 0;
	
	var strHeader = "";
	var strPacket = "";
	
	ECSETSInfo.m_nUniqueID++;
	
	//EventSenderInfo IE
	strEventSenderInfoIE = makeIEString(IE_EVENTSENDERINFO, strEventSenderInfo);
	nEventSenderInfoIELength = getTextLength(strEventSenderInfoIE);
	
	//FtpServerInfo IE
	strFTPServerInfoIE = makeIEString(IE_FTPSERVERINFO, strFtpServerInfo);
	nFTPServerInfoIELength = getTextLength(strFTPServerInfoIE);
	
	//ComplementarySever IE
	strComplementaryServerIE = makeIEString(IE_COMPLEMENTARYSERVER, strComplementarySever);
	nComplementaryServerIELength = getTextLength(strComplementaryServerIE);
	
	nIELength = nEventSenderInfoIELength + nFTPServerInfoIELength + nComplementaryServerIELength;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_EVENTSERVERINFO, nIELength);
	strPacket = strHeader + strEventSenderInfoIE + strFTPServerInfoIE + strComplementaryServerIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, EVENTPARAMS, strPacket);
	strEventSenderInfoIE = null;
	strFTPServerInfoIE = null;
	strComplementaryServerIE = null;
	nEventSenderInfoIELength = null;
	nFTPServerInfoIELength = null;
	nComplementaryServerIELength = null;
	nIELength = null;
	strHeader = null;
	strPacket = null;
}

function InitSDK(dn, isSupervisor, freeSeatSrv){
	ECSETSInfo.m_strDN = prependSpace(dn,10);
	ECSETSInfo.m_isSupervisor = isSupervisor;
	ECSETSInfo.m_freeSeatSrv = freeSeatSrv;
	
	if (ECSETSSocket.m_ws_updateSDK_state != 1){
		WS_UpdateSDK_Connect(ECS_UPDATESRV_IP);
		return;
	}
	
	if (ECSETSSocket.m_ws_state != 1){
		WebSocketConnect();
	}else{
		sendInitSDK();	
	};
}

function DeinitSDK()
{
	var strHeader = "";

	// var strTemp = "Cmd:" + CMD_DEINITSDK;
	// SendLogMessage("DeinitSDK", "DeinitSDK", strTemp);

	ECSETSInfo.m_InitCheck = 0;
	ECSETSInfo.m_nUniqueID++;
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_DEINITSDK,0);
	SendRequestMessage(ECSETSInfo.m_nUniqueID, DEINITSDK,strHeader);
	ECSETSSocket.m_ws_state = 0;
	ECSETSSocket.m_ws_timeout = setTimeout(closeSocket, 1000);
	strHeader = null;
	ECSETSInfo.m_isSupervisor = "N";
}

function closeSocket(){
	//console.log("DeinitSDK onclose");
	ECSETSSocket.m_ws_timeout = null;
	if(ECSETSSocket.m_ws != null)ECSETSSocket.m_ws.close();
}

function ConnectToServer(IP1, IP2, IP3, Port, UserID, strDomain, strPassword, AppID, AgentName)
{
	ECSETSInfo.m_nUniqueID++;
	var srTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strServerInfoIE = "";
	var strUserIDIE = "";
	var strDomainIE = "";
	var strPasswordIE = "";
	var strDataIE = "";
	var nIELength = "";
	var nServerInfoIELength = "";
	var nUserIDIELength = "";
	var nDomainIELength = "";
	var nPasswordIELength = "";
	var nDataIE = 0;

	if (IP2.toString().length < 1) { IP2 = "";}
	if (IP3.toString().length < 1) { IP3 = "";}
	if (AppID.toString().length < 1) { AppID = "";}
	if (AgentName.toString().length < 1) { AgentName = "";}


	// strTemp = "Cmd:" + CMD_CONNECTTOSERVER + ", AServer:" + IP1 + ", SServer:" + IP2 +
	          // ", GServer:" + IP3 + ", Port:" + Port + ", UserID:" + UserID + ", Domain:" + strDomain +
	          // ", Password:" + strPassword + ", AppID:" + AppID + ", AgentName:" + AgentName;
	// SendLogMessage("ConnectToServer", "ConnectToServer", strTemp);

	// ServerInfo IE
	strServerInfoIE = makeIEServerString(IP1, IP2, IP3, Port);
	nServerInfoIELength = getTextLength(strServerInfoIE);

	// UserID IE
	strUserIDIE = IE_USERID +
					prependSpace(UserID,4);
	nUserIDIELength = strUserIDIE.toString().length + 8;
	strUserIDIE = IE_USERID +
					prependZero(nUserIDIELength,8) + 
					prependSpace(UserID,4);

	//Domain IE
	strDomainIE = makeIEString(IE_DOMAIN, strDomain);
	nDomainIELength = getTextLength(strDomainIE);

	//Password IE
	strPasswordIE = makeIEString(IE_PASSWORD, strPassword);
	nPasswordIELength = getTextLength(strPasswordIE);				

	//strDataIE IE
	strDataIE = makeIEString(IE_HANGUL, AppID + AgentName);
	nDataIE = getTextLength(strDataIE);
	

	nIELength = nServerInfoIELength + nUserIDIELength + nDomainIELength + nPasswordIELength + nDataIE;    
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_CONNECTTOSERVER, nIELength);
	strPacket = strHeader +
					strServerInfoIE + 
					strUserIDIE +
					strDomainIE + 
					strPasswordIE +
					strDataIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, CONNECTTOSERVER, strPacket);
	 
	srTemp = null;
	strHeader = null;
	strPacket = null;
	strServerInfoIE = null;
	strUserIDIE = null;
	strDomainIE = null;
	strPasswordIE = null;
	strDataIE = null;
	nIELength = null;
	nServerInfoIELength = null;
	nUserIDIELength = null;
	nDomainIELength = null;
	nPasswordIELength = null;
	nDataIE = null;
}

function Login(strPassword,strInitialState)
{
	var strHeader = "";
	var strTemp = "";
	var strPacket = "";
	var strPasswordIE = "";
	var strInitialStateIE = "";
	var nIELength = "";
	var nPasswordIELength = "";
	var nInitialStateIELenght = "";

	// strTemp = "Cmd:" + CMD_LOGIN + ", Password:" + strPassword + ", InitialState:" + strInitialState;
	// SendLogMessage("Login", "Login", strTemp);

	ECSETSInfo.m_nUniqueID++;

	strPasswordIE = makeIEString(IE_PASSWORD, strPassword);
	nPasswordIELength = getTextLength(strPasswordIE);

	strInitialStateIE = makeIEString(IE_INITIALSTATE, strInitialState.toString());
	nInitialStateIELenght = getTextLength(strInitialStateIE);
					
	nIELength = nPasswordIELength + nInitialStateIELenght;

	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_LOGIN,nIELength);
	strPacket = strHeader +
					strPasswordIE +
					strInitialStateIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, LOGIN,strPacket); 
	
	strHeader = null;
	strTemp = null;
	strPacket = null;
	strPasswordIE = null;
	strInitialStateIE = null;
	nIELength = null;
	nPasswordIELength = null;
	nInitialStateIELenght = null;
}

function Logout()
{
	// var strTemp = "Cmd:" + CMD_LOGOUT;
	// SendLogMessage("Logout", "Logout", strTemp);

	var strHeader = "";
	ECSETSInfo.m_nUniqueID++;
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_LOGOUT,0);
	SendRequestMessage(ECSETSInfo.m_nUniqueID, LOGOUT,strHeader);
	strHeader = null;
}

function LoginSSO(Password, InitialState, UserName, UserPassword, UploadPath, CCMMServerInfo){
	ECSETSInfo.m_nUniqueID++;

	var strTemp, strHeader, strPacket;
	var strPasswordIE, strInitialStateIE, strCCMMLoginIE, strUploadPathIE, strCCMMServerInfoIE;
	var nIELength, nPasswordIELength, nInitialStateIELenght, nCCMMLoginIELength, nUploadPathLength, nCCMMServerInfoLength;

	// strTemp = "Cmd: "+CMD_LOGINSSO+", Password: "+Password+", InitialState: "+InitialState+", UserName: "+UserName+", Password: "+UserName;
	// SendLogMessage("LoginSSO", "LoginSSO", strTemp);

	strPasswordIE = makeIEString(IE_PASSWORD, Password);
	nPasswordIELength = getTextLength(strPasswordIE);
	
	strInitialStateIE = makeIEString(IE_INITIALSTATE, InitialState.toString());
	nInitialStateIELenght = getTextLength(strInitialStateIE);

	strCCMMLoginIE = IE_CCMMLOGIN +
					prependSpace(UserName, 20) +
					prependSpace(UserName, 20);
	nCCMMLoginIELength = getTextLength(strCCMMLoginIE) + 8;	
	strCCMMLoginIE = IE_CCMMLOGIN +
					prependZero(nCCMMLoginIELength, 8) +
					prependSpace(UserName, 20) +
					prependSpace(UserName, 20);
					
	strUploadPathIE = makeIEString(IE_UPLOADPATH, UploadPath);
	nUploadPathLength = getTextLength(strUploadPathIE);
	
	strCCMMServerInfoIE = makeIEString(IE_CCMMSERVERINFO, CCMMServerInfo);
	nCCMMServerInfoLength = getTextLength(strCCMMServerInfoIE);

	nIELength = nPasswordIELength + nInitialStateIELenght + nCCMMLoginIELength + nUploadPathLength + nCCMMServerInfoLength;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_LOGINSSO, nIELength);

	strPacket = strHeader + strPasswordIE + strInitialStateIE + strCCMMLoginIE + strUploadPathIE + strCCMMServerInfoIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, SSOLOGIN, strPacket);
	
	strTemp = null;
	strHeader = null;
	strPacket = null;
	strPasswordIE = null; 
	strInitialStateIE = null; 
	strCCMMLoginIE = null; 
	strUploadPathIE = null;
	strCCMMServerInfoIE = null;
	nIELength = null;
	nPasswordIELength = null;
	nInitialStateIELenght = null;
	nCCMMLoginIELength = null;
	nUploadPathLength = null;
	nCCMMServerInfoLength = null;
}

function  LogoutSSO(){
	var strTemp, strHeader, strPacket;
	
	ECSETSInfo.m_nUniqueID++;

	// strTemp = "Cmd: "+ CMD_LOGOUTSSO;
	// SendLogMessage("LogoutSSO", "LogoutSSO", strTemp);

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_LOGOUTSSO, 0);
	
	SendRequestMessage(ECSETSInfo.m_nUniqueID, SSOLOGOUT, strHeader);
	
	strTemp = null;
	strHeader = null;
	strPacket = null;
}

function Ready()
{
	ECSETSInfo.m_nUniqueID++;
	// var strTemp = "Cmd:" + CMD_READY;
	// SendLogMessage("Ready", "Ready", strTemp);

	var strHeader = "";
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_READY,0);
	SendRequestMessage(ECSETSInfo.m_nUniqueID, READY, strHeader);
	strHeader= null;
}

function NotReady(strReasonCode)
{
	ECSETSInfo.m_nUniqueID++;
	
	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strIE = "";
	var nIELength = "";

	// strTemp = "Cmd:" + CMD_NOTREADY + ", ReasonCode:" + strReasonCode;
	// SendLogMessage("NotReady", "NotReady", strTemp);

	if (strReasonCode != "") {
		strIE = makeIEString(IE_REASONCODE, strReasonCode);
		nIELength = getTextLength(strIE);
		
		strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_NOTREADY,nIELength);
		strPacket = strHeader + strIE;
	}else{
		strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_NOTREADY,0);
		strPacket = strHeader;
	}
	SendRequestMessage(ECSETSInfo.m_nUniqueID, NOTREADY, strPacket);
	
	strTemp = null;
	strHeader = null;
	strPacket = null;
	strIE = null;
	nIELength = null;
}

function MakeCall(DialNumber)
{
	ECSETSInfo.m_nUniqueID++;
	
	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strIE = "";
	var nIELength = "";

	//var lastNum = "";
	//var hiddenDialNum = "";
	// if (DialNumber.toString().length > 4) {
		// hiddenDialNum = DialNumber.substr(DialNumber.toString().length - 4 , 4);
		// hiddenDialNum = hiddenDialNum.replace(lastNum, "XXXX" );
	// }else{
		// hiddenDialNum = DialNumber;
	// };
	// strTemp = "Cmd:" + CMD_MAKECALL + ", DialNumber:" + hiddenDialNum;
	// SendLogMessage("MakeCall", "MakeCall", strTemp);

	strIE = makeIEString(IE_DESTINATIONADDRESS, DialNumber);
	nIELength = getTextLength(strIE);
	
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_MAKECALL,nIELength);
	strPacket = strHeader + strIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, MAKECALL, strPacket);
	
	strTemp = null;
	strHeader = null;
	strPacket = null;
	strIE = null;
	nIELength = null;
    //lastNum = null;
	//hiddenDialNum = null;
}


function Accept(ContactID)
{
	ECSETSInfo.m_nUniqueID++;
	
	var strHeader = "";
	var strContactIDIE = "";
	var nIELength;
	var strPacket = "";
	
	// var strTemp = "Cmd:" + CMD_ACCEPT;
	// SendLogMessage("Accept", "Accept", strTemp);
	if(ContactID == "" || ContactID === undefined){
		strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_ACCEPT,0);
		SendRequestMessage(ECSETSInfo.m_nUniqueID, ACCEPT,strHeader);
	}else{
		strContactIDIE = makeIEString(IE_CONTACTID, ContactID);
		nIELength = getTextLength(strContactIDIE);
		strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_ACCEPT, nIELength);
		strPacket = strHeader + strContactIDIE;
		SendRequestMessage(ECSETSInfo.m_nUniqueID, ACCEPT, strPacket);
	}
	strHeader = null;
	strContactIDIE = null;
	nIELength = null;
	strPacket = null;
}

function Release(ContactID)
{
	ECSETSInfo.m_nUniqueID++;
	
	// var strTemp = "Cmd:" + CMD_RELEASE;
	// SendLogMessage("Release", "Release", strTemp);

	var strHeader = "";
	var strPacket = "";
	var strContactIDIE = "";
	var nIELength;
	
	if(ContactID == "" || ContactID === undefined){
		strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_RELEASE,0);
		SendRequestMessage(ECSETSInfo.m_nUniqueID, RELEASE,strHeader);
	}else{
		strContactIDIE = makeIEString(IE_CONTACTID, ContactID);
		nIELength = getTextLength(strContactIDIE);
		strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_RELEASE, nIELength);
		strPacket = strHeader + strContactIDIE;
		SendRequestMessage(ECSETSInfo.m_nUniqueID, RELEASE, strPacket);
	}
	strHeader = null;
	strPacket = null;
	strContactIDIE = null;
	nIELength = null;
}


function HoldToContactID(ContactID)
{
	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strContactIDIE = "";
	var nIELength;

	// var strTemp = "Cmd:" + CMD_HOLD;
	// SendLogMessage("HoldToContactID", "Hold", strTemp);

	ECSETSInfo.m_nUniqueID++;
	
	strContactIDIE = makeIEString(IE_CONTACTID, ContactID);
	nIELength = getTextLength(strContactIDIE);					

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_HOLD, nIELength);
	
	// Packet으로 만들고
	strPacket = strHeader + strContactIDIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, HOLD, strPacket);
	strTemp = null;
	strHeader = null;
	strPacket = null;
	strContactIDIE = null;
	nIELength = null;
}

function UnHoldToContactID(contactID)
{
 	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strContactIDIE = "";
	var nIELength;

	// var strTemp = "Cmd:" + CMD_UNHOLD;
	// SendLogMessage("UnHoldToContactID", "UnHold", strTemp);

	ECSETSInfo.m_nUniqueID++;
	
	strContactIDIE = makeIEString(IE_CONTACTID, ContactID);
	nIELength = getTextLength(strContactIDIE);	

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_UNHOLD, nIELength);
	
	// Packet으로 만들고
	strPacket = strHeader + strContactIDIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, UNHOLD, strPacket);
	strTemp = null;
	strHeader = null;
	strPacket = null;
	strContactIDIE = null;
	nIELength = null;
}

function SelectContact(ContactID){
	var strTemp, strHeader, strPacket, strIE;
	var nIELength;
	
	ECSETSInfo.m_nUniqueID++;

	// strTemp = "Cmd: "+ CMD_SELECTCONTACT;
	// SendLogMessage("SelectContact", "SelectContact", strTemp);
	
	strIE = makeIEString(IE_CONTACTID, ContactID);
	nIELength = strIE.toString().length;

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_SELECTCONTACT, nIELength);

	strPacket = strHeader + strIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, SELECTCONTACT, strPacket);
	strTemp = null;
	strHeader = null;
	strPacket = null;
	strIE = null;
	nIELength = null;
}

function Hold()
{
	// var strTemp = "Cmd:" + CMD_HOLD;
	// SendLogMessage("Hold", "Hold", strTemp);

	var strHeader = "";
	ECSETSInfo.m_nUniqueID++;
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_HOLD,0);
	SendRequestMessage (ECSETSInfo.m_nUniqueID, HOLD,strHeader);
	strHeader = null;
}

function UnHold()
{
	// var strTemp = "Cmd:" + CMD_UNHOLD;
	// SendLogMessage("UnHold", "UnHold", strTemp);

	var strHeader = "";
	ECSETSInfo.m_nUniqueID++;
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_UNHOLD,0);
	SendRequestMessage (ECSETSInfo.m_nUniqueID, UNHOLD,strHeader);
	strHeader = null;
}

function GenerateDTMF(strData)
{
	// var strTemp = "Cmd:" + CMD_GENERATEDTMF;
	// SendLogMessage("GenerateDTMF", "GenerateDTMF", strTemp);

	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strIE = "";
	var nIELength;
	
	ECSETSInfo.m_nUniqueID++;
	
	strIE = makeIEString(IE_DATA, strData);
	nIELength = getTextLength(strIE);

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_GENERATEDTMF, nIELength);
	
	// Packet으로 만들고
	strPacket = strHeader + strIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, DTMF, strPacket);
	strTemp = null;
	strHeader = null;
	strPacket = null;
	strIE = null;
	nIELength = null;
}

function SetDataStr(strData,ContactID)
{
	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strDataIE = "";
	var strContactIDIE = "";
	var nDataIELength = 0;
	var nContactIDIELength = 0;
	var nIELength = 0;

	// strTemp = "Cmd:" + CMD_SETDATASTR + ", Data:" + strData;
	// SendLogMessage("SetDataStr", "SetDataStr", strTemp);

	ECSETSInfo.m_nUniqueID++;
	
	strDataIE = makeIEString(IE_HANGUL, strData);
	nDataIELength = getTextLength(strDataIE);

	strContactIDIE = makeIEString(IE_CONTACTID, ContactID);
	nContactIDIELength = getTextLength(strContactIDIE);

	nIELength = nDataIELength + nContactIDIELength;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_SETDATASTR, nIELength);

	// Packet으로 만들고
	strPacket = strHeader + strDataIE + strContactIDIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, SETDATASTR, strPacket);
	
	strTemp = null;
	strHeader = null;
	strPacket = null;
	strDataIE = null;
	strContactIDIE = null;
	nDataIELength = null;
	nContactIDIELength = null;
	nIELength = null;
}

function SetDataIntrinsic(strData,ContactID)
{
	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strDataIE = "";
	var strContactIDIE = "";
	var nDataIELength = 0;
	var nContactIDIELength = 0;
	var nIELength = 0;

	// strTemp = "Cmd:" + CMD_SETDATAINTRINSIC + ", Data:" + strData +" , ContactId:"+ContactID;
	// SendLogMessage("SetDataIntrinsic", "SetDataInt", strTemp);

	ECSETSInfo.m_nUniqueID++;
	
	strDataIE = makeIEString(IE_HANGUL, strData);
	nDataIELength = getTextLength(strDataIE);

	strContactIDIE = makeIEString(IE_CONTACTID, ContactID);
	nContactIDIELength = getTextLength(strContactIDIE);

	nIELength = nDataIELength + nContactIDIELength;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_SETDATAINTRINSIC, nIELength);

	// Packet으로 만들고
	strPacket = strHeader + strDataIE + strContactIDIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, SETDATAINTRINSIC, strPacket);
	strTemp = null;
	strHeader = null;
	strPacket = null;
	strDataIE = null;
	strContactIDIE = null;
	nDataIELength = null;
	nContactIDIELength = null;
	nIELength = null;
}

function SetDataUUI(strData,ContactID)
{
	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strDataIE = "";
	var strContactIDIE = "";
	var nDataIELength = 0;
	var nContactIDIELength = 0;
	var nIELength = 0;

	// strTemp = "Cmd:" + CMD_SETDATAUUI + ", Data:" + strData;
	// SendLogMessage("SetDataUUI", "SetDataUUI", strTemp);

	ECSETSInfo.m_nUniqueID++;
	
	strDataIE = makeIEString(IE_HANGUL, strData);
	nDataIELength = getTextLength(strDataIE);

	strContactIDIE = makeIEString(IE_CONTACTID, ContactID);
	nContactIDIELength = getTextLength(strContactIDIE);

	nIELength = nDataIELength + nContactIDIELength;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_SETDATAUUI, nIELength);

	// Packet으로 만들고
	strPacket = strHeader + strDataIE + strContactIDIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, SETDATAUUI, strPacket);
}

function Observe(agentID)
{
 	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strDataIE = "";
	var nIELength;

	ECSETSInfo.m_nUniqueID++;
	
	strDataIE = makeIEString(IE_HANGUL, agentID);
	nIELength = getTextLength(strDataIE);

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_OBSERVE, nIELength);
	
	strPacket = strHeader + strDataIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, "CMD_OBSERVE", strPacket);
}

function BargeIn(agentID)
{
 	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strDataIE = "";
	var nIELength;

	ECSETSInfo.m_nUniqueID++;
	
	strDataIE = makeIEString(IE_HANGUL, agentID);
	nIELength = getTextLength(strDataIE);

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_BARGEIN, nIELength);
	
	strPacket = strHeader + strDataIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, "CMD_BARGEIN", strPacket);
}

function GetDataStr(ContactID)
{
 	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strContactIDIE = "";
	var nIELength;

	// strTemp = "Cmd:" + CMD_GETDATASTR;
	// SendLogMessage("GetDataStr", "GetDataStr", strTemp);

	ECSETSInfo.m_nUniqueID++;
	
	strContactIDIE = makeIEString(IE_CONTACTID, ContactID);
	nIELength = getTextLength(strContactIDIE);

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_GETDATASTR, nIELength);
	
	// Packet으로 만들고
	strPacket = strHeader + strContactIDIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, GETDATASTR, strPacket);
}

function GetDataIntrinsic(strData,ContactID)
{

 	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strDataIE = "";
	var strContactIDIE = "";
	var nDataIELength = 0;
	var nContactIDIELength = 0;
	var nIELength = 0;

	// strTemp = "Cmd:" + CMD_GETDATAINTRINSIC;
	// SendLogMessage("GetDataIntrinsic", "GetDataIntrinsic", strTemp);

	ECSETSInfo.m_nUniqueID++;
	
	strDataIE = makeIEString(IE_HANGUL, strData);
	nDataIELength = getTextLength(strDataIE);

	strContactIDIE = makeIEString(IE_CONTACTID, ContactID);
	nContactIDIELength = getTextLength(strContactIDIE);

	nIELength = nDataIELength + nContactIDIELength;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_GETDATAINTRINSIC, nIELength);

	// Packet으로 만들고
	strPacket = strHeader + strDataIE + strContactIDIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, GETDATAINTRINSIC, strPacket);
}

function GetDataUUI(ContactID)
{
 	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strContactIDIE = "";
	var nIELength;

	// strTemp = "Cmd:" + CMD_GETDATAUUI;
	// SendLogMessage("GetDataUUI", "GetDataUUI", strTemp);
	
	ECSETSInfo.m_nUniqueID++;
	
	strContactIDIE = makeIEString(IE_CONTACTID, ContactID);
	nIELength = getTextLength(strContactIDIE);

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_GETDATAUUI, nIELength);
	
	// Packet으로 만들고
	strPacket = strHeader + strContactIDIE;
	SendRequestMessage(ECSETSInfo.m_nUniqueID, GETDATAUUI, strPacket);
}

function Transfer(DialNumber)
{
	// var strTemp = "Cmd:" + CMD_TRANSFER;
	// SendLogMessage("Transfer", "Transfer", strTemp);

	ECSETSInfo.m_nUniqueID++;
	//strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strIE = "";
	var nIELength = "";

	strIE = makeIEString(IE_DESTINATIONADDRESS, DialNumber);
	nIELength = getTextLength(strIE);
					
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_TRANSFER,nIELength);
	strPacket = strHeader + strIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, TRANSFER,strPacket);
}

function Conference(DialNumber)
{
	ECSETSInfo.m_nUniqueID++;

	//var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strIE = "";
	var nIELength = "";

	// strTemp = "Cmd:" + CMD_CONFERENCE;
	// SendLogMessage("Conference", "Conference", strTemp);

	strIE = makeIEString(IE_DESTINATIONADDRESS, DialNumber);
	nIELength = getTextLength(strIE);
	
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_CONFERENCE,nIELength);
	strPacket = strHeader + strIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, CONFERENCE,strPacket);
}

function TransferData(DialNumber,strData)
{
	ECSETSInfo.m_nUniqueID++;
	//var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strIE = "";
	var strDataIE = "";
	var nIELength = "";
	var nDestIELength = "";
	var nDataIELength = "";

	// strTemp = "Cmd:" + CMD_TRANSFERDATA;
	// SendLogMessage("TransferData", "TransferData", strTemp);

	strIE = makeIEString(IE_DESTINATIONADDRESS, DialNumber);
	nDestIELength = getTextLength(strIE);

	strDataIE = makeIEString(IE_HANGUL, strData);
	nDataIELength = getTextLength(strDataIE);

	nIELength = nDestIELength + nDataIELength
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_TRANSFERDATA,nIELength);
	strPacket = strHeader + strIE + strDataIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, TRANSFERDATA,strPacket);
}

function ConferenceData(DialNumber,strData)
{
	ECSETSInfo.m_nUniqueID++;
	var strTemp = "";
	var strHeader = "";
	var strPacket = "";
	var strIE = "";
	var strDataIE = "";
	var nIELength = "";
	var nDestIELength = "";
	var nDataIELength = "";

	// strTemp = "Cmd:" + CMD_CONFERENCEDATA;
	// SendLogMessage("ConferenceData", "ConferenceData", strTemp);

	strIE = makeIEString(IE_DESTINATIONADDRESS, DialNumber);
	nDestIELength = getTextLength(strIE);

	strDataIE = makeIEString(IE_HANGUL, strData);
	nDataIELength = getTextLength(strDataIE);

	nIELength = nDestIELength + nDataIELength
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_CONFERENCEDATA,nIELength);
	strPacket = strHeader + strIE + strDataIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, CONFERENCEDATA,strPacket);
}

function TransferComplete()
{
	// var strTemp = "Cmd:" + CMD_TRANSFERCOMPLETE;
	// SendLogMessage("TransferComplete", "TransferComplete", strTemp);

	var strHeader = "";
	ECSETSInfo.m_nUniqueID++;
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_TRANSFERCOMPLETE,0);
	SendRequestMessage(ECSETSInfo.m_nUniqueID, TRANSFERCOMPLETE,strHeader);
	strHeader = null;
}


function ConferenceComplete()
{
	// var strTemp = "Cmd:" + CMD_CONFERENCECOMPLETE;
	// SendLogMessage("ConferenceComplete", "ConferenceComplete", strTemp);

	var strHeader = "";
	ECSETSInfo.m_nUniqueID++;
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_CONFERENCECOMPLETE,0);
	SendRequestMessage(ECSETSInfo.m_nUniqueID, CONFERENCECOMPLETE,strHeader);
	strHeader = null;
}

function CollaborationCancel()
{
	// var strTemp = "Cmd:" + CMD_COLLABORATIONCANCEL;
	// SendLogMessage("CollaborationCancel", "CollaborationCancel", strTemp);

	var strHeader = "";
	ECSETSInfo.m_nUniqueID++;
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ,ECSETSInfo.m_strDN,CMD_COLLABORATIONCANCEL,0);
	SendRequestMessage(ECSETSInfo.m_nUniqueID, COLLABORATIONCANCEL,strHeader);
	strHeader = null;
}


function CCMMLogin(UserName, Password, UploadPath, CCMMServerInfo){
	ECSETSInfo.m_nUniqueID++;

	var strTemp, strHeader, strPacket, strIE;
	var strUploadPathIE;
	var strCCMMServerInfoIE;
	var nCCMMLoginLength;
	var nUploadPathLength;
	var nCCMMServerInfoLength;
	var nIELength = 0;

	// strTemp = "Cmd: "+CMD_CCMMLOGIN+", UserName: "+UserName+", Password: "+UserName;
	// SendLogMessage("CCMMLogin", "CCMMLogin", strTemp);
	
	strIE = IE_CCMMLOGIN +
			prependSpace(UserName, 20) +
			prependSpace(Password, 20);
	nCCMMLoginLength = getTextLength(strIE) + 8;
	strIE = IE_CCMMLOGIN +
			prependZero(nCCMMLoginLength, 8) +
			prependSpace(UserName, 20) +
			prependSpace(Password, 20);
			
	strUploadPathIE = makeIEString(IE_UPLOADPATH, UploadPath);
	nUploadPathLength = getTextLength(strUploadPathIE);
	
	strCCMMServerInfoIE = makeIEString(IE_CCMMSERVERINFO, CCMMServerInfo);
	nCCMMServerInfoLength = getTextLength(strCCMMServerInfoIE);
			
	nIELength = nCCMMLoginLength + nUploadPathLength + nCCMMServerInfoLength;

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_CCMMLOGIN, nIELength);

	// Packet으로 만들고
	strPacket = strHeader + strIE + strUploadPathIE + strCCMMServerInfoIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, CCMMLOGIN, strPacket);
}

function CCMMLogout(){
	var strTemp, strHeader, strPacket;
	
	ECSETSInfo.m_nUniqueID++;

	// strTemp = "Cmd: "+ CMD_CCMMLOGOUT;
	// SendLogMessage("CCMMLogout", "CCMMLogout", strTemp);

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_CCMMLOGOUT, 0);
	
	SendRequestMessage(ECSETSInfo.m_nUniqueID, CCMMLOGOUT, strHeader);
}

function OriginateMail(Subject, Body, mailTo, mailCC, mailBCC, mailFrom, Charset, SkillsetID, CRCID, Attachment){
	var strTemp, strHeader, strPacket;
	var strSubjectIE, strBodyIE, strmailToIE, strmailCCIE, strmailBCCIE, strmailFromIE, strCharSet, strSkillsetID, strCRCID, strAttachment;
	var nIELength, nSubjectIE, nBodyIE, nmailToIE, nmailCCIE, nmailBCCIE, nmailFromIE, nCharSet, nSkillsetID, nCRCID, nAttachment;
	
	ECSETSInfo.m_nUniqueID++;

	if(CRCID == null)
		CRCID = "";
	if(Attachment == null)
		Attachment = "";

	// strTemp = "Cmd: "+CMD_ORIGINATEMAIL+", Subject: "+Subject+", Body: "+Body+", mailTo: "+mailTo+", mailCC: "+
	          // mailCC+", mailBCC: "+mailBCC+", mailFrom: "+mailFrom+", Charset: "+Charset+", SkillsetID: "+SkillsetID+", CRCID: "+
			  // CRCID+", Attachment: "+ Attachment;
	// SendLogMessage("OriginateMail", "OriginateMail", strTemp);

	strSubjectIE = makeIEString(IE_SUBJECT, Subject);
	nSubjectIE = getTextLength(strSubjectIE);

	strBodyIE = makeIEString(IE_BODY, Body);
	nBodyIE = getTextLength(strBodyIE);

	strmailToIE = makeIEString(IE_MAILTO, mailTo);
	nmailToIE = getTextLength(strmailToIE);

	strmailCCIE = makeIEString(IE_MAILCC, mailCC);
	nmailCCIE = getTextLength(strmailCCIE);

	strmailBCCIE = makeIEString(IE_MAILBCC, mailBCC);
	nmailBCCIE = getTextLength(strmailBCCIE);

	strmailFromIE = makeIEString(IE_MAILFROM, mailFrom);
	nmailFromIE = getTextLength(strmailFromIE);

	strCharSet = makeIEString(IE_CHARSET, Charset);
	nCharSet = getTextLength(strCharSet);

	strSkillsetID = makeIEString(IE_SKILLSETID, SkillsetID);
	nSkillsetID = getTextLength(strSkillsetID);

	strCRCID = makeIEString(IE_CRCID, CRCID);
	nCRCID = getTextLength(strCRCID);

	strAttachment = makeIEString(IE_ATTACHMENT, Attachment);
	nAttachment = getTextLength(strAttachment);
	
	nIELength = nSubjectIE + nBodyIE + nmailToIE + nmailCCIE + nmailBCCIE + nmailFromIE + nCharSet + nSkillsetID + nCRCID + nAttachment;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_ORIGINATEMAIL, nIELength);

	strPacket = strHeader + strSubjectIE + strBodyIE + strmailToIE + strmailCCIE + strmailBCCIE + strmailFromIE + strCharSet + strSkillsetID + strCRCID + strAttachment;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, ORIGINATEMAIL, strPacket);
}

function  TransferMail(SelectType, ContactID, TargetID, Note){
	var strTemp, strHeader, strPacket;
	var strSelectType, strContactID, strTargetID, strNote;
	var nIELength, nSelectType, nContactID, nTargetID, nNote;
	
	ECSETSInfo.m_nUniqueID++;

	// strTemp = "Cmd: "+CMD_TRANSFERMAIL+", SelectType: "+SelectType+", ContactID: "+ContactID+", TargetID: "+TargetID+", Note: "+Note;
	// SendLogMessage("TransferMail", "TransferMail", strTemp);

	strSelectType = makeIEString(IE_SELECTTYPE, SelectType);
	nSelectType = getTextLength(strSelectType);

	strContactID = makeIEString(IE_CCMMCONTACTID, ContactID);
	nContactID = getTextLength(strContactID);

	strTargetID = makeIEString(IE_TARGETID, TargetID);
	nTargetID = getTextLength(strTargetID);

	if(Note == null)
		Note = "";
	strNote = makeIEString(IE_NOTE, Note);
	nNote = getTextLength(strNote);

	nIELength = nSelectType + nContactID + nTargetID + nNote;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_TRANSFERMAIL, nIELength);

	strPacket = strHeader + strSelectType + strContactID + strTargetID + strNote;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, TRANSFERMAIL, strPacket);
}

function  ReadContact(ContactID){
	var strTemp, strHeader, strPacket, strContactID;
	var nIELength;
	
	ECSETSInfo.m_nUniqueID++;

	// strTemp = "Cmd: "+CMD_READCONTACT+", Data: "+ContactID;
	// SendLogMessage("ReadContact", "ReadContact", strTemp);

	strContactID = makeIEString(IE_CCMMCONTACTID, ContactID);
	nIELength = getTextLength(strContactID);

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_READCONTACT, nIELength);

	strPacket = strHeader + strContactID;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, READCONTACT, strPacket);
}

function CCMMGetAllSkillSets(){
	var strTemp, strHeader, strPacket;
	
	ECSETSInfo.m_nUniqueID++;

	// strTemp = "Cmd: "+ CMD_CCMMGETALLSKILLSETS;
	// SendLogMessage("CCMMGetAllSkillSets", "CCMMGetAllSkillSets", strTemp);

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_CCMMGETALLSKILLSETS, 0);
	
	SendRequestMessage(ECSETSInfo.m_nUniqueID, GETSKILLSETID, strHeader);
}

function CCMMGetLoginAgent(){
	var strTemp, strHeader, strPacket;
	
	ECSETSInfo.m_nUniqueID++;

	// strTemp = "Cmd: "+ CMD_CCMMGETLOGINAGENT;
	// SendLogMessage("CCMMGetLoginAgent", "CCMMGetLoginAgent", strTemp);

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_CCMMGETLOGINAGENT, 0);
	
	SendRequestMessage(ECSETSInfo.m_nUniqueID, GETLOGINAGENT, strHeader);
}

function CCMMGetAllClosedReason(){
	var strTemp, strHeader, strPacket;
	
	ECSETSInfo.m_nUniqueID++;

	// strTemp = "Cmd: "+ CMD_CCMMGETALLCLOSEDREASON;
	// SendLogMessage("CCMMGetAllClosedReason", "CCMMGetAllClosedReason", strTemp);

	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_CCMMGETALLCLOSEDREASON, 0);
	
	SendRequestMessage(ECSETSInfo.m_nUniqueID, GETCLOSEREASON, strHeader);
}

function  Reply(ContactID, Subject, Body, Attachment){
	var strTemp, strHeader, strPacket, strContactIDIE, strSubjectIE, strBodyIE, strAttachmentIE;
	var nIELength, nContactIDIE, nSubjectIE, nBodyIE, nAttachmentIE;
	
	ECSETSInfo.m_nUniqueID++;

	if(Attachment == null)
		Attachment = "";

	// strTemp = "Cmd: "+CMD_REPLY+", ContactID: "+ContactID+", Subject: "+Subject+", Body: "+Body+", Attachment: "+Attachment;
	// SendLogMessage("Reply", "Reply", strTemp);
	
	strContactIDIE = makeIEString(IE_CCMMCONTACTID, ContactID);
	nContactIDIE = getTextLength(strContactIDIE);

	strSubjectIE = makeIEString(IE_SUBJECT, Subject);
	nSubjectIE = getTextLength(strSubjectIE);

	strBodyIE = makeIEString(IE_BODY, Body);
	nBodyIE = getTextLength(strBodyIE);

	strAttachmentIE = makeIEString(IE_ATTACHMENT, Attachment);
	nAttachmentIE = getTextLength(strAttachmentIE);

	nIELength = nContactIDIE + nSubjectIE + nBodyIE + nAttachmentIE;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_REPLY, nIELength);

	strPacket = strHeader + strContactIDIE + strSubjectIE + strBodyIE + strAttachmentIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, REPLAY, strPacket);
}

function  ReplyAll(ContactID, Subject, Body, Attachment){
	var strTemp, strHeader, strPacket, strContactIDIE, strSubjectIE, strBodyIE, strAttachmentIE;
	var nIELength, nContactIDIE, nSubjectIE, nBodyIE, nAttachmentIE;
	
	ECSETSInfo.m_nUniqueID++;

	if(Attachment == null)
		Attachment = "";

	// strTemp = "Cmd: "+CMD_REPLYALL+", ContactID: "+ContactID+", Subject: "+Subject+", Body: "+Body+", Attachment: "+Attachment;
	// SendLogMessage("ReplyAll", "ReplyAll", strTemp);
	
	strContactIDIE = makeIEString(IE_CCMMCONTACTID, ContactID);
	nContactIDIE = getTextLength(strContactIDIE);

	strSubjectIE = makeIEString(IE_SUBJECT, Subject);
	nSubjectIE = getTextLength(strSubjectIE);

	strBodyIE = makeIEString(IE_BODY, Body);
	nBodyIE = getTextLength(strBodyIE);

	strAttachmentIE = makeIEString(IE_ATTACHMENT, Attachment);
	nAttachmentIE = getTextLength(strAttachmentIE);

	nIELength = nContactIDIE + nSubjectIE + nBodyIE + nAttachmentIE;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_REPLYALL, nIELength);

	strPacket = strHeader + strContactIDIE + strSubjectIE + strBodyIE + strAttachmentIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, REPLAYALL, strPacket);
}

function  Forward(ContactID, Subject, Body, mailTo, mailCC, mailBCC, Attachment){
	var strTemp, strHeader, strPacket;
	var strContactID, strSubjectIE, strBodyIE, strmailToIE, strmailCCIE, strmailBCCIE, strAttachment;
	var nIELength, nContactID, nSubjectIE, nBodyIE, nmailToIE, nmailCCIE, nmailBCCIE, nAttachment;
	
	ECSETSInfo.m_nUniqueID++;

	if(Attachment == null)
		Attachment = "";

	// strTemp = "Cmd: "+CMD_FORWARD+", ContactID: "+ContactID+", Subject: "+Subject+", Body: "+Body+", mailTo: "+mailTo+
			// ", mailCC: "+mailCC+", mailBCC: "+mailBCC+", Attachment: "+Attachment;
	// SendLogMessage("Forward", "Forward", strTemp);

	strContactID = makeIEString(IE_CCMMCONTACTID, ContactID);
	nContactID = getTextLength(strContactID);

	strSubjectIE = makeIEString(IE_SUBJECT, Subject);
	nSubjectIE = getTextLength(strSubjectIE);

	strBodyIE = makeIEString(IE_BODY, Body);
	nBodyIE = getTextLength(strBodyIE);

	strmailToIE = makeIEString(IE_MAILTO, mailTo);
	nmailToIE = getTextLength(strmailToIE);

	strmailCCIE = makeIEString(IE_MAILCC, mailCC);
	nmailCCIE = getTextLength(strmailCCIE);

	strmailBCCIE = makeIEString(IE_MAILBCC, mailBCC);
	nmailBCCIE = getTextLength(strmailBCCIE);
	
	strAttachment = makeIEString(IE_ATTACHMENT, Attachment);
	nAttachment = getTextLength(strAttachment);

	nIELength = nContactID + nSubjectIE + nBodyIE + nmailToIE + nmailCCIE + nmailBCCIE + nAttachment;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_FORWARD, nIELength);

	strPacket = strHeader + strContactID + strSubjectIE + strBodyIE + strmailToIE + strmailCCIE + strmailBCCIE + strAttachment;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, FORWARD, strPacket);
}

function  CloseContact(ContactID, CloseComment, CloseReasonCode){
	var strTemp, strHeader, strPacket, strContactIDIE, strCloseCommenctIE, strCloseReasonCodeIE;
	var nIELength, nContactIDIE, nCloseCommenctIE, nCloseReasonCodeIE;
	
	ECSETSInfo.m_nUniqueID++;

	if(CloseComment == null)
		CloseComment = "";
	if(CloseReasonCode == null)
		CloseReasonCode = "";

	// strTemp = "Cmd: "+CMD_CLOSECONTACT+", ContactID: "+ContactID+", CloseComment: "+CloseComment+", CloseReasonCode: "+CloseReasonCode;
	// SendLogMessage("CloseContact", "CloseContact", strTemp);

	strContactIDIE = makeIEString(IE_CCMMCONTACTID, ContactID);
	nContactIDIE = getTextLength(strContactIDIE);

	strCloseCommenctIE = makeIEString(IE_CLOSECOMMENT, CloseComment);
	nCloseCommenctIE = getTextLength(strCloseCommenctIE);

	strCloseReasonCodeIE = makeIEString(IE_CLOSEREASONCODE, CloseReasonCode);
	nCloseReasonCodeIE = getTextLength(strCloseReasonCodeIE);

	nIELength = nContactIDIE + nCloseCommenctIE + nCloseReasonCodeIE;
	strHeader = MakeHeader(MSG_SOP, ECSETSInfo.m_nUniqueID, MSG_TYPE_REQ, ECSETSInfo.m_strDN, CMD_CLOSECONTACT, nIELength);

	strPacket = strHeader + strContactIDIE + strCloseCommenctIE + strCloseReasonCodeIE;

	SendRequestMessage(ECSETSInfo.m_nUniqueID, CLOSECONTACT, strPacket);
}


///////////////////////////////////////////////////////////////////////////////
//////////////////////////// parse Util part///////////////////////////////////
function makeIEString (strIECode, strValue){
	var strIE = "";
	var nIELength = 0;
	
	strValue = new String(strValue);
	if(strValue.toString().length < 1){return "";}
	var strValueLen = getTextLength(strValue);
	nIELength = strValueLen + IE_LEN_SIZE + IE_ID_SIZE;
	strIE = strIECode + 
	        prependZero(nIELength,IE_LEN_SIZE) + 
			strValue; 
	try{
		return strIE;
	}finally{
		strIE = null;
		nIELength = null;
	}
}

function makeIEServerString(ip1, ip2, ip3, port){
	var strIE = "";
	var nIELength = 0;
	
	var strValueLen = getTextLength(ip1);
	nIELength = IE_ID_SIZE+
			    IE_SERVERIP_SIZE + IE_SERVERIP_SIZE +IE_SERVERIP_SIZE + IE_SERVERPORT_SIZE+
				IE_LEN_SIZE;
	strIE = IE_SERVERINFO +
			prependZero(nIELength, IE_LEN_SIZE) +
			prependSpace(ip1,IE_SERVERIP_SIZE) +
			prependSpace(ip2,IE_SERVERIP_SIZE) +
			prependSpace(ip3,IE_SERVERIP_SIZE) +
			prependSpace(port,IE_SERVERPORT_SIZE);
	return strIE;
}


function prependSpace(str, len) {
	if (typeof str == "string") {
		str = str.toString();
		while(str.length < len) {
			str = " " + str;
		}
	}
	return str;
}
function lastpendSpace(str, len) {
	str = str.toString();
	while(str.length < len) {
		str = str + " ";
	}
	return str;
}

function prependZero(num, len) {
	num = num.toString();
	while(num.length < len) {
		num = "0" + num;
	}
	return num;
}

function removeZeroString(value){
	return value.replace(/(^0+)/, "");
}

function encode_utf8( s )
{
  return unescape( encodeURIComponent( s ) );
}

function substr_utf8_bytes(str, startInBytes, lengthInBytes) {

   /* this function scans a multibyte string and returns a substring. 
    * arguments are start position and length, both defined in bytes.
    * 
    * this is tricky, because javascript only allows character level 
    * and not byte level access on strings. Also, all strings are stored
    * in utf-16 internally - so we need to convert characters to utf-8
    * to detect their length in utf-8 encoding.
    *
    * the startInBytes and lengthInBytes parameters are based on byte 
    * positions in a utf-8 encoded string.
    * in utf-8, for example: 
    *       "a" is 1 byte, 
            "ü" is 2 byte, 
       and  "你" is 3 byte.
    *
    * NOTE:
    * according to ECMAScript 262 all strings are stored as a sequence
    * of 16-bit characters. so we need a encode_utf8() function to safely
    * detect the length our character would have in a utf8 representation.
    * 
    * http://www.ecma-international.org/publications/files/ecma-st/ECMA-262.pdf
    * see "4.3.16 String Value":
    * > Although each value usually represents a single 16-bit unit of 
    * > UTF-16 text, the language does not place any restrictions or 
    * > requirements on the values except that they be 16-bit unsigned 
    * > integers.
    */

    var resultStr = '';
    var startInChars = 0;

    // scan string forward to find index of first character
    // (convert start position in byte to start position in characters)

    for (bytePos = 0; bytePos < startInBytes; startInChars++) {

        // get numeric code of character (is >128 for multibyte character)
        // and increase "bytePos" for each byte of the character sequence

        ch = str.charCodeAt(startInChars);
		//pos += (str.charCodeAt(i) > 128) ? 2 : 1;
		//bytePos += (ch < 128) ? 1 : encode_utf8(str[startInChars]).length;
        bytePos += (ch < 128) ? 1 : 2;
    }

    // now that we have the position of the starting character,
    // we can built the resulting substring

    // as we don't know the end position in chars yet, we start with a mix of
    // chars and bytes. we decrease "end" by the byte count of each selected 
    // character to end up in the right position
    end = startInChars + lengthInBytes - 1;

    for (n = startInChars; startInChars <= end; n++) {
        // get numeric code of character (is >128 for multibyte character)
        // and decrease "end" for each byte of the character sequence
        ch = str.charCodeAt(n);
        //end -= (ch < 128) ? 1 : encode_utf8(str[n]).length;
		end -= (ch < 128) ? 1 : 2;

        resultStr += str[n];
    }
	try{
		return resultStr;
	}finally{
		resultStr = null;
		startInChars = null;
	}
}

function obj(){
    obj=new Object();
    this.add=function(key,value){
        obj[""+key+""]=value;
    }
    this.obj=obj
}

function GetParam(key){
	var str = ECSETSParcer.m_mapParam.obj[key];
	if (str == undefined){
		return "";
	}
	delete ECSETSParcer.m_mapParam.obj[key];
	try{
		return str;
	}finally{
		str = null;
	}
}

// function strTrim(str){
	// return str.replace(/(^\s*)|(\s*$)/gi, "");
// }

// var MapParam = new Object();
	// MapParam.m_strMsgId 			= "";
	// MapParam.m_strMsgType			= "";
	// MapParam.m_strSeq				= "";
	// MapParam.m_strReserved			= "";	
	// MapParam.m_strData				= "";	
	
// var EMsg = new Object();
	// EMsg.m_strMsgID						= "";
	// EMsg.m_strData						= "";


////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////MessageParsing Util part ////////////////////////////////


function JS_CmdChange(nMsgID)
{
	var strtemp = "";
	if(nMsgID == "1000")
		strTemp = "OPEN";
	else if(nMsgID == "1001")
		strTemp = "CLOSE";
	else if(nMsgID == "1002")
		strTemp = "INIT";
	else if(nMsgID == "1003")
		strTemp = "DINIT";	
	else if(nMsgID == "1006")
		strTemp = "EVTPR";
	else if(nMsgID == "1007")
		strTemp = "EVTPR2";
	else if(nMsgID == "1100")
		strTemp = "CNCT";
	else if(nMsgID == "1200")
		strTemp = "LOGIN";
	else if(nMsgID == "1201")
		strTemp = "LOGOU";
	else if(nMsgID == "1202")
		strTemp = "READY";
	else if(nMsgID == "1203")
		strTemp = "NRDY";
	else if(nMsgID == "1204")
		strTemp = "SLOGI";
	else if(nMsgID == "1205")
		strTemp = "SLOGO";
	else if(nMsgID == "1300")
		strTemp = "MKCL";
	else if(nMsgID == "1301")
		strTemp = "DROP";
	else if(nMsgID == "1302")
		strTemp = "ACEPT";
	else if(nMsgID == "1303")
		strTemp = "HOLD";
	else if(nMsgID == "1304")
		strTemp = "UHOLD";
	else if(nMsgID == "1314")
		strTemp = "HORUN";
	else if(nMsgID == "1305")
		strTemp = "TRNS";
	else if(nMsgID == "1306")
		strTemp = "CPTRS";
	else if(nMsgID == "1307")
		strTemp = "CONF";
	else if(nMsgID == "1308")
		strTemp = "CPCFR";
	else if(nMsgID == "1309")
		strTemp = "CANCL";
	else if(nMsgID == "1310")
		strTemp = "BTRN";
	else if(nMsgID == "1311")
		strTemp = "SELCT";
	else if(nMsgID == "1312")
		strTemp = "DTMF";
	else if(nMsgID == "1315")
		strTemp = "TRNSD";
	else if(nMsgID == "1316")
		strTemp = "CONFD";
	else if(nMsgID == "1400")
		strTemp = "SDATS";
	else if(nMsgID == "1401")
		strTemp = "SDATI";
	else if(nMsgID == "1402")
		strTemp = "SDATU";
	else if(nMsgID == "1403")
		strTemp = "GDATS";
	else if(nMsgID == "1404")
		strTemp = "GDATI";
	else if(nMsgID == "1405")
		strTemp = "GDATU";
	// 추가 기능 20140912
	else if(nMsgID == "1406")
		strTemp = "GNRRC";
	else if(nMsgID == "1407")
		strTemp = "GACWC";
	else if(nMsgID == "1408")
		strTemp = "GACD";
	else if(nMsgID == "1409")
		strTemp = "GETST";
	else if(nMsgID == "1500")
		strTemp = "SNERS";
	else if(nMsgID == "1501")
		strTemp = "RQSER";

	// 추가 기능 20140912
	else if(nMsgID == "1700")
		strTemp = "INSUP";
	else if(nMsgID == "1701")
		strTemp = "SACON";
	else if(nMsgID == "1702")
		strTemp = "REACN";
	else if(nMsgID == "1703")
		strTemp = "OBSER";
	else if(nMsgID == "1704")
		strTemp = "BARGE";
	else if(nMsgID == "1705")
		strTemp = "WHISP";
	else if(nMsgID == CMD_CCMMLOGIN)
		strTemp = "CLOGI";
	else if(nMsgID == CMD_CCMMLOGOUT)
		strTemp = "CLOGO";
	else if(nMsgID == CMD_CCMMTOCCTCONNECT)
		strTemp = "CCNCT";
	else if(nMsgID == CMD_CCMMTOCCTDISCONNECT)
		strTemp = "CDCNT";
	else if(nMsgID == CMD_CCMMTOCCTLOGIN)
		strTemp = "CCLGI";
	else if(nMsgID == CMD_CCMMTOCCTLOGOUT)
		strTemp = "CCLGO";
	else if(nMsgID == CMD_CCMMGETALLSKILLSETS)
		strTemp = "CGASS";
	else if(nMsgID == CMD_CCMMGETALLCLOSEDREASON)
		strTemp = "CGACR";
	else if(nMsgID == CMD_CCMMGETLOGINAGENT)
		strTemp = "CGLOA";
	else if(nMsgID == CMD_ORIGINATEMAIL)
		strTemp = "OMAIL";
	else if(nMsgID == CMD_TRANSFERMAIL)
		strTemp = "TMAIL";
	else if(nMsgID == CMD_READCONTACT)
		strTemp = "RCONT";
	else if(nMsgID == CMD_CLOSECONTACT)
		strTemp = "CCONT";
	else if(nMsgID == CMD_REPLY)
		strTemp = "REPL";
	else if(nMsgID == CMD_REPLYALL)
		strTemp = "REPLA";
	else if(nMsgID == CMD_FORWARD)
		strTemp = "FOWRD";
	else
		strTemp = "ERROR";
	
	try{
		return strTemp;
	}finally{
		strTemp = null;
	}
}
function JS_ConnectionStateChange(strMsgID)
{
	strMsgID = strMsgID.trim();
	var strtemp = "";
	if(strMsgID == "0")
		strTemp = CONNECTIONSTATE_0;
	else if(strMsgID == "1")
		strTemp = CONNECTIONSTATE_1;
	else if(strMsgID == "2")
		strTemp = CONNECTIONSTATE_2;
	else if(strMsgID == "3")
		strTemp = CONNECTIONSTATE_3;
	else if(strMsgID == "4")
		strTemp = CONNECTIONSTATE_4;
	else if(strMsgID == "5")
		strTemp = CONNECTIONSTATE_5;
	else if(strMsgID == "6")
		strTemp = CONNECTIONSTATE_6;
	else if(strMsgID == "7")
		strTemp = CONNECTIONSTATE_7;
	else if(strMsgID == "8")
		strTemp = CONNECTIONSTATE_8;
	else if(strMsgID == "9")
		strTemp = CONNECTIONSTATE_9;
	else if(strMsgID == "10")
		strTemp = CONNECTIONSTATE_10;
	else if(strMsgID == "11")
		strTemp = CONNECTIONSTATE_11;
	else if(strMsgID == "12")
		strTemp = CONNECTIONSTATE_12;
	else if(strMsgID == "13")
		strTemp = CONNECTIONSTATE_13;
	else if(strMsgID == "14")
		strTemp = CONNECTIONSTATE_14;
	else if(strMsgID == "15")
		strTemp = CONNECTIONSTATE_15;
	else if(strMsgID == "16")
		strTemp = CONNECTIONSTATE_16;
	else if(strMsgID == "17")
		strTemp = CONNECTIONSTATE_17;
	else
		strTemp = "ERROR";
	try{
		return strTemp;
	}finally{
		strTemp = null;
	}
}

function JS_ReasonChange(strMsgID)
{
	strMsgID = strMsgID.trim();
	var strTemp = "";
	if(strMsgID == "00" || strMsgID == "0")
		strTemp = REASON_0;
	else if(strMsgID == "01" || strMsgID == "1")
		strTemp = REASON_1;
	else if(strMsgID == "02" || strMsgID == "2")
		strTemp = REASON_2;
	else if(strMsgID == "03" || strMsgID == "3")
		strTemp = REASON_3;
	else if(strMsgID == "04" || strMsgID == "4")
		strTemp = REASON_4;
	else if(strMsgID == "05" || strMsgID == "5")
		strTemp = REASON_5;
	else if(strMsgID == "06" || strMsgID == "6")
		strTemp = REASON_6;
	else if(strMsgID == "07" || strMsgID == "7")
		strTemp = REASON_7;
	else if(strMsgID == "08" || strMsgID == "8")
		strTemp = REASON_8;
	else if(strMsgID == "09" || strMsgID == "9")
		strTemp = REASON_9;
	else if(strMsgID == "10")
		strTemp = REASON_10;
	else if(strMsgID == "11")
		strTemp = REASON_11;
	else if(strMsgID == "12")
		strTemp = REASON_12;
	else if(strMsgID == "13")
		strTemp = REASON_13;
	else if(strMsgID == "14")
		strTemp = REASON_14;
	else if(strMsgID == "15")
		strTemp = REASON_15;
	else if(strMsgID == "16")
		strTemp = REASON_16;
	else if(strMsgID == "17")
		strTemp = REASON_17;
	else if(strMsgID == "18")
		strTemp = REASON_18;
	else if(strMsgID == "19")
		strTemp = REASON_19;
	else if(strMsgID == "20")
		strTemp = REASON_20;
	else if(strMsgID == "21")
		strTemp = REASON_21;
	else if(strMsgID == "22")
		strTemp = REASON_22;
	else if(strMsgID == "23")
		strTemp = REASON_23;
	else if(strMsgID == "24")
		strTemp = REASON_24;
	else if(strMsgID == "25")
		strTemp = REASON_25;
	else if(strMsgID == "26")
		strTemp = REASON_26;
	else if(strMsgID == "27")
		strTemp = REASON_27;
	else if(strMsgID == "28")
		strTemp = REASON_28;
	else if(strMsgID == "29")
		strTemp = REASON_29;
	else if(strMsgID == "30")
		strTemp = REASON_30;
	else if(strMsgID == "31")
		strTemp = REASON_31;
	else if(strMsgID == "32")
		strTemp = REASON_32;
	else if(strMsgID == "33")
		strTemp = REASON_33;
	else if(strMsgID == "34")
		strTemp = REASON_34;
	else if(strMsgID == "35")
		strTemp = REASON_35;
	else if(strMsgID == "36")
		strTemp = REASON_36;
	else if(strMsgID == "37")
		strTemp = REASON_37;
	else if(strMsgID == "38")
		strTemp = REASON_38;
	else if(strMsgID == "39")
		strTemp = REASON_39;
	else if(strMsgID == "40")
		strTemp = REASON_40;
	else if(strMsgID == "41")
		strTemp = REASON_41;
	else if(strMsgID == "42")
		strTemp = REASON_42;
	else if(strMsgID == "43")
		strTemp = REASON_43;
	else if(strMsgID == "44")
		strTemp = REASON_44;
	else if(strMsgID == "45")
		strTemp = REASON_45;
	else if(strMsgID == "46")
		strTemp = REASON_46;
	else if(strMsgID == "47")
		strTemp = REASON_47;
	else if(strMsgID == "48")
		strTemp = REASON_48;
	else if(strMsgID == "49")
		strTemp = REASON_49;
	else
		strTemp = "ERROR";
	try{
		return strTemp;
	}finally{
		strTemp = null;
	}
}

function JS_ReasourceStateChange(strMsgID)
{
	strMsgID = strMsgID.trim();
	var strTemp = "";
	if(strMsgID == "0")
		strTemp = RESOURCESTATE_0;
	else if(strMsgID == "1")
		strTemp = RESOURCESTATE_1;
	else if(strMsgID == "2")
		strTemp = RESOURCESTATE_2;
	else if(strMsgID == "3")
		strTemp = RESOURCESTATE_3;
	else
		strTemp = "ERROR";
	try{
		return strTemp;
	}finally{
		strTemp = null;
	}
}

function JS_TerminalConnectionStateChange(strMsgID)
{
	strMsgID = strMsgID.trim();
	var strTemp = "";
	if(strMsgID == "0")
		strTemp = TERMINALCONNECTIONSTATE_0;
	else if(strMsgID == "1")
		strTemp = TERMINALCONNECTIONSTATE_1;
	else if(strMsgID == "2")
		strTemp = TERMINALCONNECTIONSTATE_2;
	else if(strMsgID == "3")
		strTemp = TERMINALCONNECTIONSTATE_3;
	else if(strMsgID == "4")
		strTemp = TERMINALCONNECTIONSTATE_4;
	else if(strMsgID == "5")
		strTemp = TERMINALCONNECTIONSTATE_5;
	else if(strMsgID == "6")
		strTemp = TERMINALCONNECTIONSTATE_6;
	else if(strMsgID == "7")
		strTemp = TERMINALCONNECTIONSTATE_7;
	else
		strTemp = "ERROR";
	try{
		return strTemp;
	}finally{
		strTemp = null;
	}
}

function JS_LinkStateChange(strMsgID)
{
	strMsgID = strMsgID.trim();
	var strTemp = "";
	if(strMsgID == "0")
		strTemp = LINKSTATE_0;
	else if(strMsgID == "1")
		strTemp = LINKSTATE_1;
	else if(strMsgID == "2")
		strTemp = LINKSTATE_2;
	else if(strMsgID == "3")
		strTemp = LINKSTATE_3;
	else if(strMsgID == "4")
		strTemp = LINKSTATE_4;
	else if(strMsgID == "5")
		strTemp = LINKSTATE_5;
	else if(strMsgID == "6")
		strTemp = LINKSTATE_6;
	else
		strTemp = "ERROR";
	try{
		return strTemp;
	}finally{
		strTemp = null;
	}
}

function JS_LinkStateReasonChange(strMsgID)
{
	strMsgID = strMsgID.trim();
	var strTemp = "";
	if(strMsgID == "0")
		strTemp = LINKSTATEREASON_0;
	else if(strMsgID == "1")
		strTemp = LINKSTATEREASON_1;
	else if(strMsgID == "2")
		strTemp = LINKSTATEREASON_2;
	else if(strMsgID == "3")
		strTemp = LINKSTATEREASON_3;
	else if(strMsgID == "4")
		strTemp = LINKSTATEREASON_4;
	else if(strMsgID == "5")
		strTemp = LINKSTATEREASON_5;
	else if(strMsgID == "6")
		strTemp = LINKSTATEREASON_6;
	else if(strMsgID == "7")
		strTemp = LINKSTATEREASON_7;
	else if(strMsgID == "8")
		strTemp = LINKSTATEREASON_8;
	else if(strMsgID == "9")
		strTemp = LINKSTATEREASON_9;
	else if(strMsgID == "10")
		strTemp = LINKSTATEREASON_10;
	else if(strMsgID == "11")
		strTemp = LINKSTATEREASON_11;
	else if(strMsgID == "12")
		strTemp = LINKSTATEREASON_12;
	else if(strMsgID == "13")
		strTemp = LINKSTATEREASON_13;
	else if(strMsgID == "14")
		strTemp = LINKSTATEREASON_14;
	else if(strMsgID == "15")
		strTemp = LINKSTATEREASON_15;
	else
		strTemp = "ERROR";
	try{
		return strTemp;
	}finally{
		strTemp = null;
	}
}

function JS_LinkIDChange(strMsgID)
{
	var strTemp = "";
	if(strMsgID == "0")
		strTemp = LINKID_0;
	else if(strMsgID == "1")
		strTemp = LINKID_1;
	else if(strMsgID == "2")
		strTemp = LINKID_2;
	else
		strTemp = "ERROR";
	try{
		return strTemp;
	}finally{
		strTemp = null;
	}
}

function JS_ToolkitStateChange(strMsgID)
{
	var strTemp = "";
	if(strMsgID == "0")
		strTemp = TOOLKITSTATE_0;
	else if(strMsgID == "1")
		strTemp = TOOLKITSTATE_1;
	else if(strMsgID == "2")
		strTemp = TOOLKITSTATE_2;
	else if(strMsgID == "3")
		strTemp = TOOLKITSTATE_3;
	else if(strMsgID == "4")
		strTemp = TOOLKITSTATE_4;
	else if(strMsgID == "5")
		strTemp = TOOLKITSTATE_5;
	else
		strTemp = "ERROR";
	try{
		return strTemp;
	}finally{
		strTemp = null;
	}
}
function JS_HeaderOutput(strMsgID)
{
	var strTemp = "";
	if(strMsgID == CMD_OPENETSCON)
		strTemp = "CMD_OPENETSCON";
	else if(strMsgID == CMD_CLOSEETSCON)
		strTemp = "CMD_CLOSEETSCON";
	else if(strMsgID == CMD_INITSDK)
		strTemp = "CMD_INITSDK";
	else if(strMsgID == CMD_DEINITSDK)
		strTemp = "CMD_DEINITSDK";
	else if(strMsgID == CMD_CONNECTTOSERVER)
		strTemp = "CMD_CONNECTTOSERVER";
	else if(strMsgID == CMD_LOGIN)
		strTemp = "CMD_LOGIN";
	else if(strMsgID == CMD_LOGOUT)
		strTemp = "CMD_LOGOUT";
	else if(strMsgID == CMD_READY)
		strTemp = "CMD_READY";
	else if(strMsgID == CMD_NOTREADY)
		strTemp = "CMD_NOTREADY";
	else if(strMsgID == CMD_LOGINSSO)
		strTemp = "CMD_LOGINSSO";
	else if(strMsgID == CMD_LOGOUTSSO)
		strTemp = "CMD_LOGOUTSSO";
	else if(strMsgID == CMD_MAKECALL)
		strTemp = "CMD_MAKECALL";
	else if(strMsgID == CMD_RELEASE)
		strTemp = "CMD_RELEASE";
	else if(strMsgID == CMD_ACCEPT)
		strTemp = "CMD_ACCEPT";
	else if(strMsgID == CMD_HOLD)
		strTemp = "CMD_HOLD";
	else if(strMsgID == CMD_UNHOLD)
		strTemp = "CMD_UNHOLD";
	else if(strMsgID == CMD_TRANSFER)
		strTemp = "CMD_TRANSFER";
	else if(strMsgID == CMD_TRANSFERCOMPLETE)
		strTemp = "CMD_TRANSFERCOMPLETE";
	else if(strMsgID == CMD_CONFERENCE)
		strTemp = "CMD_CONFERENCE";
	else if(strMsgID == CMD_CONFERENCECOMPLETE)
		strTemp = "CMD_CONFERENCECOMPLETE";
	else if(strMsgID == CMD_COLLABORATIONCANCEL)
		strTemp = "CMD_COLLABORATIONCANCEL";
	else if(strMsgID == CMD_SELECTCONTACT)
		strTemp = "CMD_SELECTCONTACT";
	else if(strMsgID == CMD_GENERATEDTMF)
		strTemp = "CMD_GENERATEDTMF";
	else if(strMsgID == CMD_SETDATASTR)
		strTemp = "CMD_SETDATASTR";
	else if(strMsgID == CMD_SETDATAINTRINSIC)
		strTemp = "CMD_SETDATAINTRINSIC";
	else if(strMsgID == CMD_SETDATAUUI)
		strTemp = "CMD_SETDATAUUI";
	else if(strMsgID == CMD_GETDATASTR)
		strTemp = "CMD_GETDATASTR";
	else if(strMsgID == CMD_GETDATAINTRINSIC)
		strTemp = "CMD_GETDATAINTRINSIC";
	else if(strMsgID == CMD_GETDATAUUI)
		strTemp = "CMD_GETDATAUUI";
	// NCC 20150518추가 
	else if(strMsgID == CMD_TRANSFERDATA)
		strTemp = "CMD_TRANSFERDATA";
	else if(strMsgID == CMD_CONFERENCEDATA)
		strTemp = "CMD_CONFERENCEDATA";
	
	
	
	else if(strMsgID == CMD_CCMMLOGIN)
		strTemp = "CMD_CCMMLOGIN";
	else if(strMsgID == CMD_CCMMLOGOUT)
		strTemp = "CMD_CCMMLOGOUT";
	else if(strMsgID == CMD_CCMMTOCCTCONNECT)
		strTemp = "CMD_CCMMTOCCTCONNECT";
	else if(strMsgID == CMD_CCMMTOCCTDISCONNECT)
		strTemp = "CMD_CCMMTOCCTDISCONNECT";
	else if(strMsgID == CMD_CCMMTOCCTLOGIN)
		strTemp = "CMD_CCMMTOCCTLOGIN";
	else if(strMsgID == CMD_CCMMTOCCTLOGOUT)
		strTemp = "CMD_CCMMTOCCTLOGOUT";
	else if(strMsgID == CMD_CCMMGETALLSKILLSETS)
		strTemp = "CMD_CCMMGETALLSKILLSETS";
	else if(strMsgID == CMD_CCMMGETALLCLOSEDREASON)
		strTemp = "CMD_CCMMGETALLCLOSEDREASON";
	else if(strMsgID == CMD_CCMMGETLOGINAGENT)
		strTemp = "CMD_CCMMGETLOGINAGENT";
	else if(strMsgID == CMD_ORIGINATEMAIL)
		strTemp = "CMD_ORIGINATEMAIL";
	else if(strMsgID == CMD_TRANSFERMAIL)
		strTemp = "CMD_TRANSFERMAIL";
	else if(strMsgID == CMD_READCONTACT)
		strTemp = "CMD_READCONTACT";
	else if(strMsgID == CMD_CLOSECONTACT)
		strTemp = "CMD_CLOSECONTACT";
	else if(strMsgID == CMD_REPLY)
		strTemp = "CMD_REPLY";
	else if(strMsgID == CMD_REPLYALL)
		strTemp = "CMD_REPLYALL";
	else if(strMsgID == CMD_FORWARD)
		strTemp = "CMD_FORWARD";

	else if(strMsgID == EVT_CONNECTIONSTATE)
		strTemp = "EVT_CONNECTIONSTATE";
	else if(strMsgID == EVT_REMOTECONNECTIONSTATE)
		strTemp = "EVT_REMOTECONNECTIONSTATE";
	else if(strMsgID == EVT_TERMINALCONNECTIONSTATE)
		strTemp = "EVT_TERMINALCONNECTIONSTATE";
	else if(strMsgID == EVT_AGENTSTATE)
		strTemp = "EVT_AGENTSTATE";
	else if(strMsgID == EVT_CCTSTATE)
		strTemp = "EVT_CCTSTATE";	
	else if(strMsgID == EVT_LINKSTATE)
		strTemp = "EVT_LINKSTATE";	
		// 추가 기능 20140912
	//6.4 추 가 cmd
	else if(strMsgID == CMD_GETNOTREADYREASONCODES)
		strTemp = "CMD_GETNOTREADYREASONCODES";	
	else if(strMsgID == CMD_GETAFTERCALLWORKCODES)
		strTemp = "CMD_GETAFTERCALLWORKCODES";	


	else
		strTemp = "EMPTY";

	try{
		return strTemp;
	}finally{
		strTemp = null;
	}
}


//////////////////////parce part ////////////////////////////////////

function EtsMsgProcess(strMsg) {
   
	var nRet = EtsPacketParse(strMsg);
	if(nRet <= false)
	{
		ECSETSInfo.m_logMsg = "Parsing Error!!!! MSG[" + strMsg + "]" + "RET[" + nRet + "]";
		SendLogMessage("EtsMsgProcess", ECSETSInfo.m_strMsgId,"<<<<Receive Message>>>> "+ECSETSInfo.m_logMsg);
		return false;
	}
	if(ECSETSInfo.m_strMsgId != CMD_UPDATESDK){//CMD_UPDATESDK는 ws 연결되지 않은상태
		SendLogMessage("EtsMsgProcess", ECSETSInfo.m_strMsgId,"<<<<Receive Message>>>> "+strMsg);
	}
	//console.log("EtsMsgProcess packet:"+strMsg);
	// Return 메세지 구분
	switch (ECSETSInfo.m_strMsgType)
	{
		case MSG_RESULT:
			EventEtsReturn(ECSETSInfo.m_strMsgType, ECSETSInfo.m_strSeq, ECSETSInfo.m_strMsgId);
			break;
		case MSG_CNF:
			var strResultIE     = GetParam(IE_RESULT);
			strIELength = getTextLength(strResultIE);
			JS_StringConfirmEvent("0", IE_RESULT, strIELength, ECSETSInfo.m_strMsgId, strResultIE, 0);
			break;
		default:	
			// Return 메세지 구분
			var pstrMsgID = ECSETSInfo.m_strMsgId;
			if(pstrMsgID == "" || pstrMsgID.toString().length <= 0) 
			{
				ECSETSInfo.m_logMsg = "MSG ID Error!!!! MSG[" + strMsg + "]";
				return false;
			}
			//console.log("EtsMsgProcess  MSG ID = "+pstrMsgID);
			switch (pstrMsgID)
			{
				case EVT_LINKSTATE:
					EventLinkState();
					break;
				case EVT_CONNECTIONSTATE:
					EventConnectionState();
					break;
				case EVT_REMOTECONNECTIONSTATE:
					EventRemoteConnectionState();
					break;
				case EVT_TERMINALCONNECTIONSTATE:
					EventTerminalConnectionState();
					break;
				case EVT_AGENTSTATE:
					EventAgentState();
					break;					
				case EVT_CCTSTATE:
					EventCCTState();
					break;
				default:
					break;
			}
	}
		
	return true;
}

function EventEtsReturn(strMsgType,strSeq,strMsgId)
{

	var strMsgIdCmd 	= strMsgId;
	var strResultIE     = GetParam(IE_RESULT);
	var strResultCauseIE  = GetParam(IE_RESULTCAUSE);
	var strResultDetailIE = GetParam(IE_RESULTDETAIL);
	var strDATAIE         = GetParam(IE_DATA);
	var strServerInfoIE   = GetParam(IE_SERVERINFO);
	var strContactIDIE    = GetParam(IE_CONTACTID);
	ECSETSInfo.m_logMsg =  "MSGtype:"+strMsgType+ " " +
			  "Cmd:"+strMsgIdCmd + " " +
	          "ReturnIE:" + strResultIE + " " +
			  "ResultCause:" + strResultCauseIE + " " +
			  "ResDetail:" + strResultDetailIE;
	
	//console.log("EventEtsReturn logMsg : "+ECSETSInfo.m_logMsg);
	
	if (strMsgIdCmd == CMD_UPDATESDK){
		//SendLogMessage("0","OnEtsReturn", "FUNC_CALL_RETURN", "UpdateSDK Check:" + strResultIE);
		// 업데이트 체크
		if(strResultIE == "1"){
			// 서버가 업데이트 중이므로 5초 후에 sendInitSDK
			setTimeout(WebSocketConnect, 5000);
		}else {
			WebSocketConnect();
		}
		strMsgIdCmd = null;
		strResultIE = null;
		strResultCauseIE = null;
		strResultDetailIE = null;
		strDATAIE = null;
		strServerInfoIE = null;
		strContactIDIE = null;
		return false;
	}
	
	var strIELength = 0;
	if(strContactIDIE.toString().length > 0){
		strIELength = getTextLength(strContactIDIE);
		JS_StringContactIDIE("0", IE_CONTACTID, strIELength, strMsgIdCmd, strContactIDIE, 0);
	}
	if(strDATAIE.toString().length > 0){
		strIELength = getTextLength(strDATAIE);
		JS_StringDataIE("0", IE_DATA, strIELength, strMsgIdCmd, strDATAIE, 0);
	}
	if(strServerInfoIE.toString().length > 0){
		strIELength = getTextLength(strServerInfoIE);
		JS_StringServerInfoIE("0", IE_SERVERINFO, strIELength, strMsgIdCmd, strServerInfoIE, 0);
	}
	if (strMsgIdCmd == CMD_INITSDK){
		if(strResultIE == "1") { isInit = true;}
		else {isInit = false;}
	}
	if(strResultIE.toString().length > 0){
		var strCommand = JS_CmdChange(strMsgIdCmd);
		strCommand = strCommand+":"+removeZeroString(strSeq);
		var strCauseDetail = "";
		if(strResultIE > 0){
			strCauseDetail = strResultDetailIE;
		}else{
			strCauseDetail = strResultCauseIE;
			OnEvent(strCommand, strCauseDetail, strResultIE);
		}
		OnResult(strCommand, strResultIE, strCauseDetail);
	}
	
	strCommand = null;
	strCauseDetail = null;
	strMsgIdCmd 	= null;
	strResultIE     = null;
	strResultCauseIE  = null;
	strResultDetailIE = null;
	strDATAIE         = null;
	strServerInfoIE   = null;
	strContactIDIE    = null;
	log = null;
	return true;
}

function EtsPacketParse(strPacket)
{
    
	//데이터 초기화
	ECSETSInfo.m_strMsgId 					= "";
	ECSETSInfo.m_strMsgType 				= "";
	ECSETSInfo.m_strReserved 				= "";	
	ECSETSInfo.m_strData 					= "";
	
	var nInx = 0;
	var nSize = 0;

	if(strPacket.toString().length < MSG_HEADER_SIZE) {
		return -9999;
	}
	
	nSize = MSG_SOP_SIZE;
	var strSop = strPacket.substr(nInx, nSize);
	if(strSop != MSG_SOP) {
		return -9998;
	}
	nInx += nSize;
	
	nSize = MSG_LEN_SIZE;
	var strMsgLen = strPacket.substr(nInx, nSize);
	var nMsgLen = parseInt(strMsgLen,10);
	
	if(nMsgLen < MSG_HEADER_SIZE || nMsgLen > MSG_MAX_SIZE) {
		return -9997;
	}
	
	nInx += nSize;
	
	nSize = MSG_SEQ_SIZE;
	ECSETSInfo.m_strSeq = strPacket.substr(nInx, nSize);
	nInx += nSize;

	nSize = MSG_TYPE_SIZE;
	ECSETSInfo.m_strMsgType = strPacket.substr(nInx, nSize);
	nInx += nSize;

	nSize = MSG_DN_SIZE;
	ECSETSInfo.m_strReserved = strPacket.substr(nInx, nSize);
	nInx += nSize;

	nSize = MSG_ID_SIZE;
	ECSETSInfo.m_strMsgId = strPacket.substr(nInx, nSize);
	nInx += nSize;
	
	if(nMsgLen > MSG_HEADER_SIZE) {
		var nDataSize = nMsgLen - MSG_HEADER_SIZE;
		if(nDataSize > 0) {
			ECSETSInfo.m_strData = substr_utf8_bytes(strPacket,nInx,nDataSize);
			//MAP에 IE별로 넣어줌..
			var nLoopCount = 0;
			nInx = 0;
			var strIEID = "";
			var strIELen = "";
			var strIEData = "";
			while(nInx < nDataSize) {
				nLoopCount++;	//혹시모를 버그에 대비해 무한루프를 방지하기 위해 100번으로 제한을 두기 위해...(어차피 IE가 100개 이상 셋팅될 일이 없다.)
				if(nLoopCount > 100) {
					//ERROR
					break;
				}

				if(nInx + IE_HEADER_SIZE > nDataSize) break;	//IE헤더 사이즈만큼도 안남았으면 이후 데이터는 의미없는 데이터이다. 루프를 빠져나간다. 
				
				nSize = IE_ID_SIZE;
				strIEID = substr_utf8_bytes(ECSETSInfo.m_strData,nInx,nSize); 
				nInx += nSize;

				nSize = IE_LEN_SIZE;
				strIELen = substr_utf8_bytes(ECSETSInfo.m_strData,nInx,nSize);
				var nIELen = parseInt(strIELen,10);
				nInx += nSize;

				if(nIELen >= IE_HEADER_SIZE) {
					var nIEDataSize = nIELen - IE_HEADER_SIZE;
					if(nIEDataSize > 0) {
						strIEData = substr_utf8_bytes(ECSETSInfo.m_strData,nInx,nIEDataSize);
						//console.log("map add key value = "+strIEID+",  data = "+strIEData);
						ECSETSParcer.m_mapParam.add(strIEID, strIEData);	//IE값 MAP에 입력
						nInx += nIEDataSize;
						continue;
					}
				} else {
					//ERROR
					break;
				}
			}

		}
	}
	
	return true;
}

function EventLinkState()
{
	var strLinkState = "";
	var strLinkStateReason = "";
	var strLinkID = "";
	var strToolkitState = "";
	var strServerAddress = "";
	var strTerminalname = "";
	
	var linkStateData = GetParam(IE_LINKSTATE);
	
	//link status  
	var nSize = 0;
	strLinkState = linkStateData.substr(nSize, 1);
	nSize += 1;
	strLinkState = JS_LinkStateChange(strLinkState);
	
	strLinkStateReason = linkStateData.substr(nSize, 2);
	nSize += 2;
	//console.log("EventLinkState strLinkStateReason:"+strLinkStateReason);
	strLinkStateReason = JS_LinkStateReasonChange(strLinkStateReason);
	
	strLinkID = linkStateData.substr(nSize, 1);
	nSize += 1;
	strLinkID = JS_LinkIDChange(strLinkID);
	
	strToolkitState = linkStateData.substr(nSize, 1);
	nSize += 1;
    strToolkitState = JS_ToolkitStateChange(strToolkitState);
	
	strServerAddress = linkStateData.substr(nSize, 15);
	
	//terminal name
	strTerminalname = GetParam(IE_TERMINALNAME);
	
	ECSETSInfo.m_logMsg = "LinkState:" + strLinkState + " " +
 			 "LinkStateReason:" + strLinkStateReason + " " + 
			 "LinkID:" + strLinkID + " " +
			 "ToolkitState:" + strToolkitState + " " +
			 "ServerAddress:"+ strServerAddress + " " +
			 "Terminalname:" + strTerminalname;
			 
	SendLogMessage("EventLinkState", "OnLinkState", ECSETSInfo.m_logMsg);
	OnLinkState(strLinkState, strLinkStateReason, strLinkID, strToolkitState, strServerAddress, strTerminalname);
	OnEvent("OnLinkState", strLinkState+":"+strLinkStateReason+"@"+strServerAddress, "");
	return true;
}

function EventConnectionState(){
	
	//Address
	var addressData = GetParam(IE_ADDRESS);
	
	var strTemp = "";
	var strIEID = "";
    var strIELength = 0;
	var strNameLength = 0;
	var strName = "";
	var strURILength = 0;
	var strURI = "";
	var strDoNotDisturb = "";
	var strIsForwarded = "";
	var strResourceState = "";
	strIEID = IE_ADDRESS;
	strIELength = getTextLength(addressData);
	
	var evt_log = "";

	
	var nRestLength;
	nRestLength = parseInt(strIELength) - 11;
	var nSize = 0;

	
	strNameLength = addressData.substr(nSize, 4);
	nSize += 4;
	
	if(nRestLength > 0)
	{
		var nTemp = parseInt(strNameLength);		
		strName = addressData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strURILength = addressData.substr(nSize, 4);
	nSize += 4;
	
	if(nRestLength > 0)
	{
		var nTemp = parseInt(strURILength);		
		strURI = addressData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strDoNotDisturb = addressData.substr(nSize, 1);
	nSize += 1;
		
	strIsForwarded = addressData.substr(nSize, 1);
	nSize += 1;

	strResourceState = addressData.substr(nSize, 1);
	nSize += 1;
	strResourceState = JS_ReasourceStateChange(strResourceState);
	
	evt_log = "ConnectionName:" + strName + " " +
 			 "ConnectionURI:" + strURI + " " + 
			 "ConnectionDonotDisturb:" + strDoNotDisturb + " " +
			 "ConnectionIsForwarded:" + strIsForwarded + " " +
			 "ConnectionResourceState:"+ strResourceState;
	
	//Connection
	var connectionData = GetParam(IE_CONNECTION);
	
	var strContactID = "";
	var strNew = "";
	var strPrevious = "";
	var strPrevious = "";
	var strisRemote = "";
	var strReason = "";
	
	nSize = 0;

	strContactID = connectionData.substr(nSize, 16);
	nSize += 16;
	
	strNew = connectionData.substr(nSize, 2);
	nSize += 2;
	//console.log("EventConnectionState new:"+strNew);
	strNew = JS_ConnectionStateChange(strNew);
	
	strPrevious = connectionData.substr(nSize, 2);
	nSize += 2;
	//console.log("EventConnectionState strPrevious:"+strPrevious);
	strPrevious = JS_ConnectionStateChange(strPrevious);
		
	strisRemote  = connectionData.substr(nSize, 1);
	nSize += 1;

	strReason = connectionData.substr(nSize, 2);
	nSize += 2;
	strReason = JS_ReasonChange(strReason);
	
	evt_log = evt_log+" "+"ConnectionContactID:" + strContactID + " " +
 			 "ConnectionNew:" + strNew + " " + 
			 "ConnectionPrevious:" + strPrevious + " " +
			 "ConnectionIsRemote:" + strisRemote + " " +
			 "ConnectionReason:"+ strReason;
	
	//Contact
	var contactData = GetParam(IE_CONTACT);
	
	var strCalledAddr = "";
	var strCallingAddr = "";
	var strCallingTerminal = "";
	var strContactType = "";
	var strContactContactID = "";
	var strLastReDirectAddr = "";
	var strMainContactID = "";
	var strOriginalDestination = "";
	
	var strCalledAddrLength = 0;
	
	
	nRestLength = 0;
	strIELength = getTextLength(contactData);
	nRestLength = parseInt(strIELength) - 11;
	nSize = 0;

	strCalledAddrLength = contactData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strCalledAddrLength);
		strCalledAddr = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strCallingAddrLength = contactData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strCallingAddrLength);
		strCallingAddr = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strCallingTerminalLength  = contactData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strCallingTerminalLength);
		strCallingTerminal = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strContactType = contactData.substr(nSize, 16);
	nSize += 16;
		
	strContactContactID = contactData.substr(nSize, 16);
	nSize += 16;

	strLastReDirectAddrLength = contactData.substr(nSize, 4);
	nSize += 4;
	
	if(nRestLength > 0)
	{
		var nTemp = parseInt(strLastReDirectAddrLength);
		strLastReDirectAddr = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strMainContactID = contactData.substr(nSize, 16);
	nSize += 16;

	strOriginalDestinationLength = contactData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strOriginalDestinationLength);
		strOriginalDestination = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}
	
	evt_log = evt_log+" "+"ConnectionCalledAddress:" + strCalledAddr + " " +
 			 "ConnectioCallingAddress:" + strCallingAddr + " " + 
			 "ConnectionCallingTerminal:" + strCallingTerminal + " " +
			 "ConnectionContactType:" + strContactType + " " +
			 "ConnectionContactID:"+ strContactContactID + " " +
			 "ConnectionLastRedirectAddress:" + strLastReDirectAddr + " " +
			 "ConnectionMainContactID:"+ strMainContactID + " " +
			 "ConnectionOriginalDestination:"+ strOriginalDestination;
			 
	SendLogMessage("EventConnectionState", "OnConnectionState", evt_log);
	//console.log("EventConnectionState :  "+ evt_log);
	
	tagStrConnectionStateEvent.strName = strName;
	tagStrConnectionStateEvent.strURI = strURI;
	tagStrConnectionStateEvent.strDoNotDisturb = strDoNotDisturb;
	tagStrConnectionStateEvent.strIsForwarded = strIsForwarded;
	tagStrConnectionStateEvent.strResourceState = strResourceState;
	tagStrConnectionStateEvent.strConnectionContactID = strContactID;
	tagStrConnectionStateEvent.strNew 	= strNew;
	tagStrConnectionStateEvent.strPrevious 	= strPrevious;
	tagStrConnectionStateEvent.strisRemote  = strisRemote;
	tagStrConnectionStateEvent.strReason 	= strReason;
	tagStrConnectionStateEvent.strCalledAddr = strCalledAddr;
	tagStrConnectionStateEvent.strCallingAddr = strCallingAddr;
	tagStrConnectionStateEvent.strCallingTerminal = strCallingTerminal;
	tagStrConnectionStateEvent.strContactType = strContactType;
	tagStrConnectionStateEvent.strContactID  = strContactContactID;
	tagStrConnectionStateEvent.strLastReDirectAddr  = strLastReDirectAddr;
	tagStrConnectionStateEvent.strMainContactID = strMainContactID;
	tagStrConnectionStateEvent.strOriginalDestination = strOriginalDestination;	
	
	OnConnectionState(strName, strURI, strDoNotDisturb, strIsForwarded, strResourceState, 
					strContactID, strNew, strPrevious, strisRemote, strReason, 
					strCalledAddr, strCallingAddr, strCallingTerminal, strContactType, strContactContactID, strLastReDirectAddr, strMainContactID, strOriginalDestination);
	return true;
}

function EventRemoteConnectionState(){
	
	//Address
	var addressData = GetParam(IE_ADDRESS);
	
	var strTemp = "";
	var strIEID = "";
    var strIELength = 0;
	var strNameLength = 0;
	var strName = "";
	var strURILength = 0;
	var strURI = "";
	var strDoNotDisturb = "";
	var strIsForwarded = "";
	var strResourceState = "";
	strIEID = IE_ADDRESS;
	strIELength = getTextLength(addressData);
	
	var evt_log = "";

	
	var nRestLength;
	nRestLength = parseInt(strIELength) - 11;
	var nSize = 0;

	
	strNameLength = addressData.substr(nSize, 4);
	nSize += 4;
	
	if(nRestLength > 0)
	{
		var nTemp = parseInt(strNameLength);		
		strName = addressData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strURILength = addressData.substr(nSize, 4);
	nSize += 4;
	
	if(nRestLength > 0)
	{
		var nTemp = parseInt(strURILength);		
		strURI = addressData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strDoNotDisturb = addressData.substr(nSize, 1);
	nSize += 1;
		
	strIsForwarded = addressData.substr(nSize, 1);
	nSize += 1;

	strResourceState = addressData.substr(nSize, 1);
	nSize += 1;
	//console.log("EventRemoteConnectionState strResourceState:"+strResourceState);
	strResourceState = JS_ReasourceStateChange(strResourceState);
	
	evt_log = "ConnectionName:" + strName + " " +
 			 "ConnectionURI:" + strURI + " " + 
			 "ConnectionDonotDisturb:" + strDoNotDisturb + " " +
			 "ConnectionIsForwarded:" + strIsForwarded + " " +
			 "ConnectionResourceState:"+ strResourceState;
	
	//Connection
	var connectionData = GetParam(IE_CONNECTION);
	
	var strContactID = "";
	var strNew = "";
	var strPrevious = "";
	var strisRemote = "";
	var strReason = "";
	
	nSize = 0;

	strContactID = connectionData.substr(nSize, 16);
	nSize += 16;
	
	strNew = connectionData.substr(nSize, 2);
	nSize += 2;
	strNew = JS_ConnectionStateChange(strNew);
	
	strPrevious = connectionData.substr(nSize, 2);
	nSize += 2;
	strPrevious = JS_ConnectionStateChange(strPrevious);
		
	strisRemote  = connectionData.substr(nSize, 1);
	nSize += 1;

	strReason = connectionData.substr(nSize, 2);
	nSize += 2;
	strReason = JS_ReasonChange(strReason);
	
	evt_log = evt_log+" "+"ConnectionContactID:" + strContactID + " " +
 			 "ConnectionNew:" + strNew + " " + 
			 "ConnectionPrevious:" + strPrevious + " " +
			 "ConnectionIsRemote:" + strisRemote + " " +
			 "ConnectionReason:"+ strReason;
	
	//Contact
	var contactData = GetParam(IE_CONTACT);
	
	var strCalledAddr = "";
	var strCallingAddr = "";
	var strCallingTerminal = "";
	var strContactType = "";
	var strContactContactID = "";
	var strLastReDirectAddr = "";
	var strMainContactID = "";
	var strOriginalDestination = "";
	
	var strCalledAddrLength = 0;
	
	
	nRestLength = 0;
	strIELength = getTextLength(contactData);
	nRestLength = parseInt(strIELength) - 11;
	nSize = 0;

	strCalledAddrLength = contactData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strCalledAddrLength);
		strCalledAddr = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strCallingAddrLength = contactData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strCallingAddrLength);
		strCallingAddr = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strCallingTerminalLength  = contactData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strCallingTerminalLength);
		strCallingTerminal = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strContactType = contactData.substr(nSize, 16);
	nSize += 16;
		
	strContactContactID = contactData.substr(nSize, 16);
	nSize += 16;

	strLastReDirectAddrLength = contactData.substr(nSize, 4);
	nSize += 4;
	
	if(nRestLength > 0)
	{
		var nTemp = parseInt(strLastReDirectAddrLength);
		strLastReDirectAddr = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strMainContactID = contactData.substr(nSize, 16);
	nSize += 16;

	strOriginalDestinationLength = contactData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strOriginalDestinationLength);
		strOriginalDestination = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}
	
	evt_log = evt_log+" "+"ConnectionCalledAddress:" + strCalledAddr + " " +
 			 "ConnectioCallingAddress:" + strCallingAddr + " " + 
			 "ConnectionCallingTerminal:" + strCallingTerminal + " " +
			 "ConnectionContactType:" + strContactType + " " +
			 "ConnectionContactID:"+ strContactContactID + " " +
			 "ConnectionLastRedirectAddress:" + strLastReDirectAddr + " " +
			 "ConnectionMainContactID:"+ strMainContactID + " " +
			 "ConnectionOriginalDestination:"+ strOriginalDestination;
			 
	SendLogMessage("EventRemoteConnectionState", "OnRemoteConnectionState", evt_log);
	//console.log("EventRemoteConnectionState  :  "+ evt_log);
	
	tagStrRemoteConnectionStateEvent.strName 					= strName;
	tagStrRemoteConnectionStateEvent.strURI 					= strURI;
	tagStrRemoteConnectionStateEvent.strDoNotDisturb 			= strDoNotDisturb;
	tagStrRemoteConnectionStateEvent.strIsForwarded 			= strIsForwarded;
	tagStrRemoteConnectionStateEvent.strResourceState 			= strResourceState;
	tagStrRemoteConnectionStateEvent.strConnectionContactID 	= strContactID;
	tagStrRemoteConnectionStateEvent.strNew 					= strNew;
	tagStrRemoteConnectionStateEvent.strPrevious 				= strPrevious;
	tagStrRemoteConnectionStateEvent.strisRemote 				= strisRemote;
	tagStrRemoteConnectionStateEvent.strReason 					= strReason;
	tagStrRemoteConnectionStateEvent.strCalledAddr 				= strCalledAddr;
	tagStrRemoteConnectionStateEvent.strCallingAddr 			= strCallingAddr;
	tagStrRemoteConnectionStateEvent.strCallingTerminal 		= strCallingTerminal;
	tagStrRemoteConnectionStateEvent.strContactType 			= strContactType;
	tagStrRemoteConnectionStateEvent.strContactID 				= strContactContactID;
	tagStrRemoteConnectionStateEvent.strLastReDirectAddr 		= strLastReDirectAddr;
	tagStrRemoteConnectionStateEvent.strMainContactID 			= strMainContactID;
	tagStrRemoteConnectionStateEvent.strOriginalDestination 	= strOriginalDestination;
	
	OnRemoteConnectionState(strName, strURI, strDoNotDisturb, strIsForwarded, strResourceState, 
			strContactID, strNew, strPrevious, strisRemote, strReason, 
			strCalledAddr, strCallingAddr, strCallingTerminal, strContactType, strContactContactID, strLastReDirectAddr, strMainContactID, strOriginalDestination);
}

function EventTerminalConnectionState(){
	
	var terminalData = GetParam(IE_TERMINAL);
	
	var strIELength = 0;
	strIELength = getTextLength(terminalData);
	var nRestLength = 0;
	var strNameLength = 0;
	var strURILength = 0;
	var strName = "";
	var strURI = "";
	var strDoNotDisturb = "";
	var strIsForwarded = "";
	var strResourceState = "";
	
	var evt_log = "";
	

	nRestLength = parseInt(strIELength) - 11;

	var nSize = 0;


	strNameLength = terminalData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strNameLength);
		strName = terminalData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strURILength = terminalData.substr(nSize, 7);
	nSize += 4;
	
	if(nRestLength > 0)
	{
		var nTemp = parseInt(strURILength);
		strURI = terminalData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strDoNotDisturb = terminalData.substr(nSize, 1);
	nSize += 1;
		
	strIsForwarded = terminalData.substr(nSize, 1);
	nSize += 1;

	strResourceState = terminalData.substr(nSize, 1);
	nSize += 1;
	//console.log("EventTerminalConnectionState  strResourceState:  "+ strResourceState);
	strResourceState = JS_ReasourceStateChange(strResourceState);
	
	evt_log = "ConnectionName:" + strName + " " +
 			 "ConnectionURI:" + strURI + " " + 
			 "ConnectionDonotDisturb:" + strDoNotDisturb + " " +
			 "ConnectionIsForwarded:" + strIsForwarded + " " +
			 "ConnectionResourceState:"+ strResourceState;
	
	//TerminalConnection
	var termainlConnectionData = GetParam(IE_TERMINALCONNECTION);
	
	strIELength = getTextLength(termainlConnectionData);

	nRestLength = parseInt(strIELength) - 11;
	nSize = 0;

	var strTerminalConnectionContactType = "";
	var strConnectionContactID = "";
	var strNew = "";
	var strPrevious = "";
	var strisMute = "";
	var strReason = "";
	
	strTerminalConnectionContactType = termainlConnectionData.substr(nSize, 16);
	nSize += 16;

	strConnectionContactID = termainlConnectionData.substr(nSize, 16);
	nSize += 16;

	strNew = termainlConnectionData.substr(nSize, 2);
	nSize += 2;
	strNew = JS_TerminalConnectionStateChange(strNew);

	strPrevious = termainlConnectionData.substr(nSize, 2);
	nSize += 2;
	strPrevious = JS_TerminalConnectionStateChange(strPrevious);

	strisMute = termainlConnectionData.substr(nSize, 1);
	nSize += 1;

	strReason = termainlConnectionData.substr(nSize, 2);
	nSize += 2;
	strReason = JS_ReasonChange(strReason);
	
	evt_log = evt_log + " "+"ConnectionContactType:" + strTerminalConnectionContactType + " " +
 			 "ConnectionConatctId:" + strConnectionContactID + " " + 
			 "ConnectionNew:" + strNew + " " +
			 "ConnectionPrevious" + strPrevious + " " +
			 "ConnectionisMute:"+ strisMute + " " +
			 "ConnectionReason:"+ strReason;
	
	//Contact
	var contactData = GetParam(IE_CONTACT);
	
	var strCalledAddr = "";
	var strCallingAddr = "";
	var strCallingTerminal = "";
	var strContactType = "";
	var strContactContactID = "";
	var strLastReDirectAddr = "";
	var strMainContactID = "";
	var strOriginalDestination = "";
	
	var strCalledAddrLength = 0;
	
	
	nRestLength = 0;
	strIELength = getTextLength(contactData);
	nRestLength = parseInt(strIELength) - 11;
	nSize = 0;

	strCalledAddrLength = contactData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strCalledAddrLength);
		strCalledAddr = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strCallingAddrLength = contactData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strCallingAddrLength);
		strCallingAddr = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strCallingTerminalLength  = contactData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strCallingTerminalLength);
		strCallingTerminal = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strContactType = contactData.substr(nSize, 16);
	nSize += 16;
		
	strContactContactID = contactData.substr(nSize, 16);
	nSize += 16;

	strLastReDirectAddrLength = contactData.substr(nSize, 4);
	nSize += 4;
	
	if(nRestLength > 0)
	{
		var nTemp = parseInt(strLastReDirectAddrLength);
		strLastReDirectAddr = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}

	strMainContactID = contactData.substr(nSize, 16);
	nSize += 16;

	strOriginalDestinationLength = contactData.substr(nSize, 4);
	nSize += 4;

	if(nRestLength > 0)
	{
		var nTemp = parseInt(strOriginalDestinationLength);
		strOriginalDestination = contactData.substr(nSize, nTemp);
		nSize += nTemp;
	}
	
	evt_log = evt_log+" "+"ConnectionCalledAddress:" + strCalledAddr + " " +
 			 "ConnectioCallingAddress:" + strCallingAddr + " " + 
			 "ConnectionCallingTerminal:" + strCallingTerminal + " " +
			 "ConnectionContactType:" + strContactType + " " +
			 "ConnectionContactID:"+ strContactContactID + " " +
			 "ConnectionLastRedirectAddress:" + strLastReDirectAddr + " " +
			 "ConnectionMainContactID:"+ strMainContactID + " " +
			 "ConnectionOriginalDestination:"+ strOriginalDestination;
	SendLogMessage("EventTerminalConnectionState", "OnTerminalConnectionState", evt_log);
	//console.log("EventTerminalConnectionState :  "+ evt_log);
	
	tagStrTerminalConnectionStateEvent.strName 					= strName;
	tagStrTerminalConnectionStateEvent.strURI 					= strURI;
	tagStrTerminalConnectionStateEvent.strURI 					= strURI;
	tagStrTerminalConnectionStateEvent.strDoNotDisturb 			= strDoNotDisturb;
	tagStrTerminalConnectionStateEvent.strIsForwarded 			= strIsForwarded;
	tagStrTerminalConnectionStateEvent.strResourceState 		= strResourceState;
	tagStrTerminalConnectionStateEvent.strConnectionContactType	= strTerminalConnectionContactType;
	tagStrTerminalConnectionStateEvent.strConnectionContactID 	= strConnectionContactID;
	tagStrTerminalConnectionStateEvent.strNew 					= strNew;
	tagStrTerminalConnectionStateEvent.strPrevious 				= strPrevious;
	tagStrTerminalConnectionStateEvent.strisMute 				= strisMute;
	tagStrTerminalConnectionStateEvent.strReason 				= strReason;
	tagStrTerminalConnectionStateEvent.strCalledAddr 			= strCalledAddr;
	tagStrTerminalConnectionStateEvent.strCallingAddr 			= strCallingAddr;
	tagStrTerminalConnectionStateEvent.strCallingTerminal 		= strCallingTerminal;
	tagStrTerminalConnectionStateEvent.strContactType 			= strContactType;
	tagStrTerminalConnectionStateEvent.strContactID 			= strContactContactID;
	tagStrTerminalConnectionStateEvent.strLastReDirectAddr 		= strLastReDirectAddr;
	tagStrTerminalConnectionStateEvent.strMainContactID 		= strMainContactID;
	tagStrTerminalConnectionStateEvent.strOriginalDestination 	= strOriginalDestination;	
	
	OnTerminalConnectionState(strName, strURI, strDoNotDisturb, strIsForwarded, strResourceState, 
			strTerminalConnectionContactType,	strConnectionContactID, strNew, strPrevious, strisMute, strReason, 
			strCalledAddr, strCallingAddr, strCallingTerminal, strContactType, strContactContactID, strLastReDirectAddr, strMainContactID, strOriginalDestination);
	
	terminalData = null;
	strIELength = null;
	nRestLength = null;
	strNameLength = null;
	strURILength = null;
	strName = null;
	strURI = null;
	strDoNotDisturb = null;
	strIsForwarded = null;
	strResourceState = null;
	evt_log = null;
	nSize = null;
	termainlConnectionData = null;
	strTerminalConnectionContactType = null;
	strConnectionContactID = null;
	strNew = null;
	strPrevious = null;
	strisMute = null;
	strReason = null;
	contactData = null;
	strCalledAddr = null;
	strCallingAddr = null;
	strCallingTerminal = null;
	strContactType = null;
	strContactContactID = null;
	strLastReDirectAddr = null;
	strMainContactID = null;
	strOriginalDestination = null;
	strCalledAddrLength = null;
}

function EventAgentState(){
	var strTerminalName = "";
	var strAgentState = "";
	var strUserID = "";
	var strReasonCode = "";
	var strLoginID = "";
	var evt_log = "";
	
	strTerminalName = GetParam(IE_TERMINALNAME);
	strAgentState = GetParam(IE_AGENTSTATUS);
	strUserID = GetParam(IE_USERID);
	strReasonCode = GetParam(IE_REASONCODE);
	strLoginID = GetParam(IE_LOGINID);
	
	evt_log = "AgentTerminalName:" + strTerminalName + " " +
 			 "AgentState:" + strAgentState + " " + 
			 "AgentUserId:" + strUserID + " " +
			 "AgentReasonCode:" + strReasonCode + " " +
			 "AgentLoginId:"+ strLoginID;
	//console.log("EventAgentState logmsg : "+evt_log);
	SendLogMessage("EventAgentState", "OnAgentState", evt_log);
	OnAgentState(strTerminalName, strAgentState, strUserID, 
		strReasonCode, strLoginID);		
}

function EventCCTState(){
	
	//UserID
	var strUserID = "";
	var userIDData = GetParam(IE_USERID);
	
	var strIELength = 0;
	strIELength = getTextLength(userIDData);

	var nRestLength;
	nRestLength = parseInt(strIELength) - 11;
	var nSize = 0;
	var evt_log = "";
	
	if(nRestLength > 0)
	{
		strUserID = userIDData.substr(nSize, nRestLength);
	}
	
	//Data
	var strData = "";
	var strTemp = "";
	var dataData = GetParam(IE_DATA);
	strIELength = getTextLength(dataData);

	var nRestLength;
	nRestLength = parseInt(strIELength) - 11;
	var nSize = 0;

	if(nRestLength > 0)
	{
		strData = dataData.substr(nSize, nRestLength);
		strData = strData.substr_utf8_bytes(strData, 0, nRestLength);
	}
	
	//AgentState
	var strAgentState = "";
	var agentStateData = GetParam(IE_AGENTSTATUS);
	strIELength = getTextLength(agentStateData);

	var nRestLength;
	nRestLength = parseInt(strIELength) - 11;
	var nSize = 0;

	if(nRestLength > 0)
	{
		strAgentState = agentStateData.substr(nSize, nRestLength);
	}
	
	evt_log = "CCStateUserId:" + strUserID + " " +
 			 "CCStateData:" + strData + " " + 
			 "CCStateAgentState:" + strAgentState + " " +
			 "AgentReasonCode:" + strReasonCode + " " +
			 "AgentLoginId:"+ strLoginID;
	SendLogMessage("EventCCTState", "OnCCTState", evt_log);
	OnCCTState(strUserID, strData, strAgentState);
}


function JS_StringConfirmEvent(strSeq, nIEID, strIELength, strMsgID, strRecvBytes, nRecvSize)
{
	var strIEID = "";
	var strTemp = "";

	tagStrResult.strIEID 										= "";
	tagStrResult.strIELength 									= "";
	tagStrResult.strResult 										= "";
	tagStrResult.strREsultDetail 								= "";
		
	tagStrResult.strIEID = nIEID;
	tagStrResult.strIELength = strIELength;

	// 들어온 값 중 IEID, IELength의 길이만큼 뺀 길이를 구함
	var nRestLength = 0;
	nRestLength = parseInt(strIELength) - 11;

	var nSize = 0;

	//tagStrResult.strResult = strRecvBytes.substr(nSize, 13);
	tagStrResult.strResult =  strRecvBytes.substr(nSize, 13).replace(/0/g, '');
	nSize += 13;

	if(tagStrResult.strResult.toString().length == 0)
	{
		tagStrResult.strResult = "0";
	}

	// 위에서 할당 한 이후 가변 인자의 길이가 달라졌기 때문에 다시 셋팅
	// 이후 동적으로 메모리 할당, 나머지 Length가 0보다 작거나 같으면 가변인자는 없는 것으로 판단
	nRestLength = nRestLength - 13;
	if(nRestLength > 0)
	{
		tagStrResult.strREsultDetail = strRecvBytes.substr(nSize, nRestLength);
		nSize += nRestLength;	
	}

	tagStrResult.strCmd = JS_CmdChange(strMsgID);
	
	if (tagStrResult.strCmd == "RCONT")
	{
		JS_OnParamOnReadContact();
	}
	else
	{
		OnConfirm(tagStrResult.strCmd, tagStrResult.strResult, tagStrResult.strREsultDetail);

		JS_OnConfirmLog ();
	}
}
function JS_OnParamOnReadContact()
{
	var strTemp = "";
	var strDetail = "";
	// 추후에 혹시 메일 이력을 보내야 할 일이 있다면, 아래 변수에 저장하자.
	var strDetails = "";
	var strSubject = "";
	var strBody = "";
	var strFrom = "";
	var strTo = "";
	var strBCC = "";
	var strCC = "";
	var strTime = "";
	var strPriproty = "";
	var strSkillset = "";
	var strStatus = "";
	var strAttachment = "";

	strDetail = tagStrResult.strREsultDetail;
	var nSubject = 0;
	var nBody = 0;
	var nFrom = 0;
	var nTo = 0;
	var nBCC = 0;
	var nCC = 0;
	var nTime = 0;
	var nPriproty = 0;
	var nSkillset = 0;
	var nStatus = 0;
	var nAttachment = 0;

	if (tagStrResult.strResult == "1")
	{
		nSubject = strDetail.search("@BODY:");
		if(nSubject != -1)
		{
			strSubject = strDetail.substr(9, nSubject - 9);
			nSubject += 6;
		}

		nBody = strDetail.search("@FROM:");
		if(nBody != -1)
		{
			strBody = strDetail.substr(nSubject, nBody - nSubject);
			nBody += 6;
		}

		nFrom = strDetail.search("@TO:");
		if(nFrom != -1)
		{
			strFrom = strDetail.substr(nBody, nFrom - nBody);
			nFrom += 4;
		}

		nTo = strDetail.search("@BCC:");
		if(nTo != -1)
		{
			strTo = strDetail.substr(nFrom, nTo - nFrom);
			nTo += 5;
		}
	
		nBCC = strDetail.search("@CC:");
		if(nBCC != -1)
		{
			strBCC = strDetail.substr(nTo, nBCC - nTo);
			nBCC += 4;
		}

		nCC = strDetail.search("@TIME:");
		if(nCC != -1)
		{
			strCC = strDetail.substr(nBCC, nCC - nBCC);
			nCC += 6;
		}

		nTime = strDetail.search("@PRIORITY:");
		if(nTime != -1)
		{
			strTime = strDetail.substr(nCC, nTime - nCC);
			nTime += 10;
		}

		nPriproty = strDetail.search("@SKILLSET:");
		if(nPriproty != -1)
		{
			strPriproty = strDetail.substr(nTime, nPriproty - nTime);
			nPriproty += 10;
		}

		nSkillset = strDetail.search("@STATUS:");
		if(nSkillset != -1)
		{
			strSkillset = strDetail.substr(nPriproty, nSkillset - nPriproty);
			nSkillset += 8;
		}

		nStatus = strDetail.search("@ATTACHMENT:");
		if(nStatus != -1)
		{
			strStatus = strDetail.substr(nSkillset, nStatus - nSkillset);
		
			nStatus += 12;
			strAttachment = strDetail.substr(nStatus, strDetail.toString().length - nStatus);
		}
		else
			strStatus = strDetail.substr(nSkillset, strDetail.toString().length - nSkillset);
	}
	else
	{
		strDetails = strDetail;
	}

	OnReadContact(tagStrResult.strResult, strSubject, strBody, strFrom, strTo, strBCC, strCC, strTime, strPriproty, strSkillset, strStatus, strAttachment, strDetails);
    JS_OnReadContactLog(tagStrResult.strResult, strSubject, strBody, strFrom, strTo, strBCC, strCC, strTime, strPriproty, strSkillset, strStatus, strAttachment, strDetails);
}

function JS_StringDataIE(strSeq, nIEID, strIELength, strMsgID, strRecvBytes, nRecvSize)
{
	var strIEID = "";
	var strTemp = "";
		
	tagStrData.strIEID = nIEID;
	tagStrData.strIELength = strIELength;

	// 들어온 값 중 IEID, IELength의 길이만큼 뺀 길이를 구함
	var nRestLength;
	nRestLength = parseInt(strIELength) - 11;
	// memcpy를 위한 배열의 위치
	var nSize = 0;

	// 위에서 할당 한 이후 가변 인자의 길이가 달라졌기 때문에 다시 셋팅
	// 이후 동적으로 메모리 할당, 나머지 Length가 0보다 작거나 같으면 가변인자는 없는 것으로 판단
	if(nRestLength > 0)
	{
		tagStrData.strData = strRecvBytes.substr(nSize, nRestLength);
		tagStrData.strData = tagStrData.strData.substr_utf8_bytes(tagStrData.strData, 0 , nRestLength);
		nRestLength = tagStrData.strData.toString().length;
		nSize += nRestLength;
	}

	tagStrData.strDataIEID = strRecvBytes.substr(nSize, 3);
	nSize += 3;
	
	tagStrData.strDataIELength = strRecvBytes.substr(nSize, 8);
	nSize += 8;
	
	nRestLength = nRecvSize - nSize;
	if(nRestLength > 0)
	{
		var nTemp = parseInt(tagStrData.strDataIELength) - 11;
		tagStrData.strContactID = strRecvBytes.substr(nSize, nTemp);
		nSize += nTemp;
	}

	tagStrData.strResultID = strRecvBytes.substr(nSize, 3);

	// 따라온 추가 IE가 ResultIE가 아닌 경우는, Result가 아니므로 다음 이벤트로 넘긴다.
	if(tagStrData.strResultID == "500")
	{
		nSize += 3;

		//권기남 20140911 Length  8로 변경
		tagStrData.strResultLength = strRecvBytes.substr(nSize, 8);
		nSize += 8;
		//tagStrData.strResultLength = strRecvBytes.substr(nSize, 5);
		//nSize += 5;

		tagStrData.strResult = strRecvBytes.substr(nSize, 13);
		nSize += 13;

		tagStrData.strResult = tagStrData.strResult.replace(/0/g, "");
		if(tagStrData.strResult.toString().length == 0)
		{
			tagStrData.strResult = "0";
		}

		nRestLength = parseInt(tagStrData.strResultLength) - 24;
		if(nRestLength > 0)
		{
			tagStrData.strResultDetail = strRecvBytes.substr(nSize, nRestLength);
			nSize += nRestLength;
		}
	}

	tagStrData.strCmd = JS_CmdChange(strMsgID);

	OnData(tagStrData.strCmd, tagStrData.strContactID, tagStrData.strData, tagStrData.strResult, tagStrData.strResultDetail);
	JS_OnDataLog();
}

function JS_StringContactIDIE(strSeq, nIEID, strIELength, strMsgID, strRecvBytes, nRecvSize)
{
	var strIEID = "";
	var strTemp = "";

	tagStrData.strIEID = nIEID;
	tagStrData.strIELength = strIELength;

	// 들어온 값 중 IEID, IELength의 길이만큼 뺀 길이를 구함
	var nRestLength;
	nRestLength = parseInt(strIELength) - 11;

	var nSize = 0;

	// 위에서 할당 한 이후 가변 인자의 길이가 달라졌기 때문에 다시 셋팅
	// 이후 동적으로 메모리 할당, 나머지 Length가 0보다 작거나 같으면 가변인자는 없는 것으로 판단
	if(nRestLength > 0)
	{
		tagStrData.strContactID = strRecvBytes.substr(nSize, nRestLength);
		nSize += nRestLength;
	}

	tagStrData.strDataIEID = strRecvBytes.substr(nSize, 3);
	nSize += 3;

	tagStrData.strDataIELength = strRecvBytes.substr(nSize, 8);
	nSize += 8;
	
	nRestLength = nRecvSize - nSize;
	if(nRestLength > 0)
	{
		var nTemp = parseInt(tagStrData.strDataIELength) - 11;
		tagStrData.strData = strRecvBytes.substr(nSize, nTemp);
		tagStrData.strData = tagStrData.strData.substr_utf8_bytes(tagStrData.strData, 0, nTemp);
		nTemp = tagStrData.strData.toString().length;
	
		nSize += nTemp;
	}

	tagStrData.strResultID = strRecvBytes.substr(nSize, 3);

	// 따라온 추가 IE가 ResultIE가 아닌 경우는, Result가 아니므로 다음 이벤트로 넘긴다.
	if(tagStrData.strResultID == "500")
	{
		nSize += 3;

		tagStrData.strResultLength = strRecvBytes.substr(nSize, 8);
		nSize += 8;

		tagStrData.strResult = strRecvBytes.substr(nSize, 13);
		nSize += 13;

		tagStrData.strResult = tagStrData.strResult.replace(/0/g, "");
		if(tagStrData.strResult.toString().length == 0)
		{
			tagStrData.strResult = "0";
		}

		nRestLength = parseInt(tagStrData.strResultLength) - 24;
		if(nRestLength > 0)
		{
			tagStrData.strResultDetail = strRecvBytes.substr(nSize, nRestLength);
			nSize += nRestLength;
		}
	}

	tagStrData.strCmd = JS_CmdChange(strMsgID);
	OnData(tagStrData.strCmd, tagStrData.strContactID, tagStrData.strData, tagStrData.strResult, tagStrData.strResultDetail);
	JS_OnDataLog();
}

function JS_StringServerInfoIE(strSeq, nIEID, strIELength, strMsgID, strRecvBytes, nRecvSize)
{
	var strIEID = "";
	var strTemp = "";
		
	tagStrServerInfo.strIEID = nIEID;
	tagStrServerInfo.strIELength = strIELength;

	// 들어온 값 중 IEID, IELength의 길이만큼 뺀 길이를 구함
	var nRestLength;

	nRestLength = parseInt(strIELength) - 11;
	var nSize = 0;

	tagStrServerInfo.strServerA = strRecvBytes.substr(nSize, 20);
	nSize += 20;

	tagStrServerInfo.strServerS = strRecvBytes.substr(nSize, 20);
	nSize += 20;

	tagStrServerInfo.strServerG = strRecvBytes.substr(nSize, 20);
	nSize += 20;
			
	tagStrServerInfo.strBServerPort = strRecvBytes.substr(nSize, 10);
	nSize += 10;

	tagStrServerInfo.tagStrResultID = strRecvBytes.substr(nSize, 3);

	// 따라온 추가 IE가 ResultIE가 아닌 경우는, Result가 아니므로 다음 이벤트로 넘긴다.
	if(tagStrServerInfo.tagStrResultID == "500")
	{
		nSize += 3;

		tagStrServerInfo.strIELength = strRecvBytes.substr(nSize, 8);
		nSize += 8;

		tagStrServerInfo.strResult = strRecvBytes.substr(nSize, 13);
		nSize += 13;

		tagStrServerInfo.strResult = tagStrServerInfo.strResult.replace(/0/g, '');
		if(tagStrServerInfo.strResult.toString().length == 0)
		{
			tagStrServerInfo.strResult = "0";
		}

		nRestLength = parseInt(tagStrServerInfo.tagStrResultLength) - 24;
		if(nRestLength > 0)
		{
			tagStrServerInfo.strResultDetail = strRecvBytes.substr(nSize, nRestLength);
			nSize += nRestLength;
		}
	}
	
	var strCMD = JS_CmdChange(strMsgID);
	var strTemp = "[Event] Cmd:" + strCMD +
                ", Result:" + tagStrServerInfo.strResult +
                ", ResultDetail:" + tagStrServerInfo.strResultDetail +
				", ServerA:" + tagStrServerInfo.strServerA +
				", ServerS:" + tagStrServerInfo.strServerS +
				", ServerG:" + tagStrServerInfo.strServerG +
				", ServerPort:" + tagStrServerInfo.strBServerPort;

	SendLogMessage("JS_StringServerInfoIE", "OnServerInfo", strTemp);
	OnServerInfo(tagStrServerInfo.strResult, tagStrServerInfo.strResultDetail, tagStrServerInfo.strServerA, tagStrServerInfo.strServerS, tagStrServerInfo.strServerG, tagStrServerInfo.strBServerPort);
}


////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////LOG Part/////////////////////////////////////////////////

var websocketLog_url = 'ws://localhost:10088';
var ws_Log = null;

function getNowDate(){
	// date format
	//"yyyy-MM-dd hh:mm:ss:SSS"
	var date = new Date();
	var year = date.getFullYear();                                
	var month = (1 + date.getMonth());                  
	month = month >= 10 ? month : '0' + month;    
	var day = date.getDate();                                        
	day = day >= 10 ? day : '0' + day;         
	var hour = date.getHours();
	hour = hour >= 10 ? hour : '0' + hour;
	var minutes = date.getMinutes();
	minutes = minutes >= 10 ? minutes : '0' + minutes;
	var seconds = date.getSeconds();
	seconds = seconds >= 10 ? seconds : '0' + seconds;
	var millisec = date.getMilliseconds();
	try{
		return  year + '-' + month + '-' + day +" "+hour+ ":"+minutes+":"+seconds+"."+millisec;
	}finally{
		date = null;
		year = null;
		month = null;
		day = null;
		hour = null;
		minutes = null;
		seconds = null;
		millisec = null;
	}
}

function getMilliSecondsTime(){
	var date = new Date();
	try{
		return date.getTime();
	}finally{
		date = null;
	}
}

function convertDate(date){
	var year = date.getFullYear();                                
	var month = (1 + date.getMonth());                  
	month = month >= 10 ? month : '0' + month;    
	var day = date.getDate();                                        
	day = day >= 10 ? day : '0' + day;         
	var hour = date.getHours();
	hour = hour >= 10 ? hour : '0' + hour;
	var minutes = date.getMinutes();
	minutes = minutes >= 10 ? minutes : '0' + minutes;
	var seconds = date.getSeconds();
	seconds = seconds >= 10 ? seconds : '0' + seconds;
	var millisec = date.getMilliseconds();
	try{
		return  year + '-' + month + '-' + day +" "+hour+ ":"+minutes+":"+seconds+"."+millisec;
	}finally{
		year = null;
		month = null;
		day = null;
		hour = null;
		minutes = null;
		seconds = null;
		millisec = null;
	}
}


function SendLogMessage(pszFuncName, pszCommandName,strLog)
{
	ECSETSInfo.m_nUniqueID++;
	var strHeader = "";
	var strPacket = "";
	var cur_Time = "";
	
	cur_Time = getNowDate();
	
	var logMsg = "[" + cur_Time + "]" + " " + 
				"[" + prependSpace(pszFuncName,15) + "]" + " " +
				"[" + prependSpace(pszCommandName, 20) + "]" + " " +
				strLog;
	
	var strLogIDIE = makeIEString(IE_DATA,logMsg);
	var nTotalIELength  = getTextLength(strLogIDIE);
	strHeader = MakeHeader(MSG_SOP,ECSETSInfo.m_nUniqueID,MSG_TYPE_REQ, ECSETSInfo.m_strDN,CMD_MSG_SCRIPT_LOG,nTotalIELength);
	strPacket = strHeader + strLogIDIE;
	//console.log("logmessage "+logMsg);
	if(ECSETSSocket.m_ws != null)
	ECSETSSocket.m_ws.send(strPacket);

	strHeader = null;
	strPacket = null;
	cur_Time = null;
	logMsg = null;
	strLogIDIE = null;
	nTotalIELength = null;
}

function JS_OnResultLog ()
{  
  var strTemp = "[Event] Command:" + tagStrResult.strCmd +
                ", Result:" + tagStrResult.strResult + 
                ", Details:" + tagStrResult.strREsultDetail;
  SendLogMessage("JS_OnResultLog", "OnResult", strTemp);
}

function JS_OnConfirmLog ()
{  
  var strTemp = "[Event] Command:" + tagStrResult.strCmd +
                ", Result:" + tagStrResult.strResult + 
                ", Details:" + tagStrResult.strREsultDetail;
  //console.log("JS_OnConfirmLog() "+strTemp);				
  SendLogMessage("JS_OnConfirmLog", "OnConfirm", strTemp);
}

function JS_OnDataLog()
{
  var strTemp = "[Event] Cmd:" + tagStrData.strCmd +
                ", ContactID:" + tagStrData.strContactID +
                ", Data:PrivateData" + 
                ", Result:" + tagStrData.strResult +
                ", ResultDetail:" + tagStrData.strResultDetail; 
  //console.log("JS_OnDataLog() "+strTemp);
  SendLogMessage("JS_OnDataLog", "OnData", strTemp);
}

function JS_OnReadContactLog(strResult, strSubject, strBody, strFrom, strTo, strBCC, strCC, strTime, strPriproty, strSkillset, strStatus, strAttachment, strDetails)
{
  var strTemp = "[Event] strResult:" + strResult +
                ", strSubject:" + strSubject +
                ", strFrom:" + strFrom +
                ", strTo:" + strTo +
                ", strBCC:" + strBCC + 
                ", strCC:" + strCC
                ", strTime:" + strTime +
                ", strPriproty:" + strPriproty + 
                ", strSkillset:" + strSkillset +
                ", strStatus:" + strStatus +
                ", strAttachment:" + strAttachment +
                ", strDetails:" + strDetails; 

  SendLogMessage("JS_OnReadContactLog", "OnReadContact", strTemp);

}


function SocketAliveReceiveErrorLog(){
	if(ECSETSInfo.m_InitCheck == 1){
		var log = "Alive packet not received, websoc ready state = "+ ECSETSSocket.m_ws.readyState;
		console.log(log);
		SendLogMessage("ALIVE RESPONSE", "Alive packet not received","Alive packet not received");
		log = null;
	}
}

function SocketAliveSendErrorLog(){
	if(ECSETSInfo.m_InitCheck == 1){
		var log = "Alive packet send fail, websoc ready state = " + ECSETSSocket.m_ws.readyState;
		console.log(log);
		SendLogMessage("ALIVE RESPONSE", "Alive packet send fail", log);
		log = null;
	}
}

