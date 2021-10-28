//////////////////////////////////////////////////
/// ETS_Client
// Script Version 9.3.x 
//
//////////////////////////////////////////////////



// var ECS_UPDATESRV_IP  = "192.100.20.110,192.100.20.110:29377"; // 개발계
// var ECS_UPDATESRV_IP  = "10.2.18.34,10.2.18.39:29377"; // 운영계

var ecsInfo = _getLoginInfo();
var ECS_UPDATESRV_IP = ecsInfo.etcUpdate;

//console.log("ECS_UPDATESRV_IP="+ ECS_UPDATESRV_IP);

var	MSG_SOP			= "!@#$";
var	MSG_COMMAND		= "CMD";
var	MSG_TYPE_REQ	= "REQ";
var	MSG_EVENT		= "EVT";
var	MSG_RESULT		= "RET";
var MSG_CNF         = "CNF";

var  	MSG_SOP_SIZE								= 4;
var  	MSG_LEN_SIZE								= 8;
var  	MSG_SEQ_SIZE								= 5;
var  	MSG_TYPE_SIZE								= 3;
var  	MSG_DN_SIZE						        	= 10;
var  	MSG_ID_SIZE									= 4;
var  	MSG_HEADER_SIZE								= MSG_SOP_SIZE + MSG_LEN_SIZE + MSG_SEQ_SIZE + MSG_TYPE_SIZE + MSG_DN_SIZE + MSG_ID_SIZE;	//헤더 사이즈(34)
var		MSG_ALIVE_CHECK_SIZE						= MSG_SOP_SIZE + MSG_LEN_SIZE + MSG_SEQ_SIZE + MSG_TYPE_SIZE + MSG_DN_SIZE;
var  	MSG_MAX_SIZE								= 999999;	//거의 1MB... 이 이상 오면 에러로 처리...
//---------------------------------------------------------------------
//  Packet Length
//---------------------------------------------------------------------
var RECV_MAXSIZE			= 99999;
var CMD_TEST				= 9999;
var CMD_ERROR				= 7777;

// Command start
var  CMD_MSG_SCRIPT_LOG						    	= "9998";
var  CMD_OPENETSCON									= "1000";
var  CMD_UPDATESDK							     	= "1001";
var  CMD_CLOSEETSCON								= "1099";
var  CMD_INITSDK									= "1002";
var  CMD_DEINITSDK									= "1003";
var  CMD_EVENTSERVERINFO                            = "1006";    
var  CMD_EVENTSERVERINFO2                           = "1007";    

var  CMD_CONNECTTOSERVER							= "1100";

var  CMD_LOGIN										= "1200";
var  CMD_LOGOUT										= "1201";
var  CMD_READY										= "1202";
var  CMD_NOTREADY									= "1203";
var  CMD_LOGINSSO									= "1204";
var  CMD_LOGOUTSSO									= "1205";

var  CMD_MAKECALL									= "1300";
var  CMD_RELEASE									= "1301";
var  CMD_ACCEPT										= "1302";
var  CMD_HOLD										= "1303";
var  CMD_UNHOLD										= "1304";
var  CMD_TRANSFER									= "1305";
var  CMD_TRANSFERCOMPLETE							= "1306";
var  CMD_CONFERENCE									= "1307";
var  CMD_CONFERENCECOMPLETE							= "1308";
var  CMD_COLLABORATIONCANCEL						= "1309";
var  CMD_SELECTCONTACT								= "1311";
var  CMD_GENERATEDTMF								= "1312";
var  CMD_MUTE										= "1313";

//NCC 추가 20150518
var  CMD_TRANSFERDATA								= "1315";
var  CMD_CONFERENCEDATA								= "1316";


var  CMD_SETDATASTR									= "1400";
var  CMD_SETDATAINTRINSIC							= "1401";
var  CMD_SETDATAUUI									= "1402"; 
var  CMD_GETDATASTR									= "1403"; 
var  CMD_GETDATAINTRINSIC							= "1404"; 
var  CMD_GETDATAUUI									= "1405"; 
//6.4 추 가 cmd
var  CMD_GETNOTREADYREASONCODES						="1406";
var  CMD_GETAFTERCALLWORKCODES						="1407";
 
var  CMD_SENDCONTACTHISTORYTOERS					= "1500";

var  CMD_OBSERVE									= "1703";
var  CMD_BARGEIN									= "1704";

// Command end

// CCMM Command start
var  CMD_CCMMLOGIN									= "3000"; 
var  CMD_CCMMLOGOUT									= "3001"; 
var  CMD_CCMMTOCCTCONNECT							= "3002"; 
var  CMD_CCMMTOCCTDISCONNECT						= "3003"; 
var  CMD_CCMMTOCCTLOGIN								= "3004"; 
var  CMD_CCMMTOCCTLOGOUT							= "3005"; 

var  CMD_CCMMGETALLSKILLSETS						= "3100"; 
var  CMD_CCMMGETALLCLOSEDREASON						= "3101"; 
var  CMD_CCMMGETLOGINAGENT							= "3102";

var  CMD_ORIGINATEMAIL								= "3200"; 
var  CMD_TRANSFERMAIL								= "3201"; 
var  CMD_READCONTACT								= "3202"; 
var  CMD_CLOSECONTACT								= "3203"; 
var  CMD_REPLY										= "3204"; 
var  CMD_REPLYALL									= "3205"; 
var  CMD_FORWARD									= "3206"; 
// CCMM Command end

// event start
var  EVT_LINKSTATE									= "5000";
var  EVT_CONNECTIONSTATE							= "6000";
var  EVT_REMOTECONNECTIONSTATE						= "6001";
var  EVT_TERMINALCONNECTIONSTATE					= "7000";
var  EVT_AGENTSTATE									= "8000";
var  EVT_CCTSTATE									= "9000";
// event end

//---------------------------------------------------------------------
// IE start

var		IE_ID_SIZE		= 3;
var		IE_LEN_SIZE		= 8;
var     IE_SERVERIP_SIZE  = 20;
var     IE_SERVERPORT_SIZE  = 10;
var		IE_HEADER_SIZE	= IE_ID_SIZE + IE_LEN_SIZE;
 
var IE_SERVERINFO									= "100";
var IE_EVENTSENDERINFO                              = "101";
var IE_UPDATESERVERINFO						        = '103';
var IE_FTPSERVERINFO                                = "105";
var IE_COMPLEMENTARYSERVER                          = "106";
var IE_CCMMSERVERINFO                               = "107";
var IE_FREESEATSEVER								= "108";

var IE_USERID										= "200";
var IE_DOMAIN										= "201";
var IE_LOGINID										= "202";
var IE_PASSWORD										= "203";
var IE_INITIALSTATE									= "204";
var IE_REASONCODE									= "205";
var IE_AGENTSTATUS									= "206";

var IE_CONTACT										= "300";
var IE_ADDRESS										= "303";
var IE_TERMINAL										= "304";
var IE_CONTACTID									= "305";
var IE_DESTINATIONADDRESS							= "306";
var IE_TERMINALCONNECTION							= "307";
var IE_CONNECTION									= "308";

var IE_DATA											= "400";
var IE_DETAIL										= "402";
var IE_TERMINALNAME									= "403";
var IE_HANGUL										= "404";

var IE_RESULT										= "500";
var IE_RESULTCAUSE								    = "501";
var IE_RESULTDETAIL                                 = "502";

var IE_LINKSTATE									= "600";
	
var IE_ERSINTERFACE									= "800";
// IE end
// CCMM IE start
var IE_SUBJECT										= "700";
var IE_BODY											= "701";
var IE_MAILTO										= "702";
var IE_MAILCC										= "703";
var IE_MAILBCC										= "704";
var IE_MAILFROM										= "705";
var IE_CHARSET										= "706";
var IE_SKILLSETID									= "707";
var IE_CRCID										= "708";
var IE_ATTACHMENT									= "709";


var IE_SELECTTYPE									= "711";
var IE_CCMMCONTACTID								= "712";
var IE_TARGETID										= "713";
var IE_NOTE											= "714";
var IE_CLOSECOMMENT									= "715";
var IE_CLOSEREASONCODE								= "716";
var IE_UPLOADPATH                                   = "717";

var IE_CCMMLOGIN									= "720";
var IE_CCMMTOCCTCONNECT								= "721";
// CCMM IE end



// 내부호출용 메시지 정의
var WM_USER											= 1024
// Command start
var CMD_SEND_OPENETSCON								= WM_USER+1000;
var CMD_SEND_CLOSEETSCON							= WM_USER+1001;
var CMD_SEND_INITSDK								= WM_USER+1002;
var CMD_SEND_DEINITSDK								= WM_USER+1003;
var CMD_SEND_CONNECTTOSERVER						= WM_USER+1100;

var CMD_SEND_LOGIN									= WM_USER+1200;
var CMD_SEND_LOGOUT									= WM_USER+1201;
var CMD_SEND_READY									= WM_USER+1202;
var CMD_SEND_NOTREADY								= WM_USER+1203;
var CMD_SEND_LOGINSSO								= WM_USER+1204;
var CMD_SEND_LOGOUTSSO								= WM_USER+1205;

var CMD_SEND_MAKECALL								= WM_USER+1300;
var CMD_SEND_RELEASE								= WM_USER+1301;
var CMD_SEND_ACCEPT									= WM_USER+1302;
var CMD_SEND_HOLD									= WM_USER+1303;
var CMD_SEND_UNHOLD									= WM_USER+1304;
var CMD_SEND_TRANSFER								= WM_USER+1305; 
var CMD_SEND_TRANSFERCOMPLETE						= WM_USER+1306; 
var CMD_SEND_CONFERENCE								= WM_USER+1307; 
var CMD_SEND_CONFERENCECOMPLETE						= WM_USER+1308;
var CMD_SEND_COLLABORATIONCANCEL					= WM_USER+1309; 
var CMD_SEND_BLINDTRANSFER							= WM_USER+1310; 
var CMD_SEND_SELECTCONTACT							= WM_USER+1311;
var CMD_SEND_GENERATEDTMF							= WM_USER+1312;

var CMD_SEND_SETDATASTR								= WM_USER+1400;
var CMD_SEND_SETDATAINTRINSIC						= WM_USER+1401;
var CMD_SEND_SETDATAUUI								= WM_USER+1402; 
var CMD_SEND_GETDATASTR								= WM_USER+1403; 
var CMD_SEND_GETDATAINTRINSIC						= WM_USER+1404; 
var CMD_SEND_GETDATAUUI								= WM_USER+1405; 
 
var CMD_SEND_REQUESTSERVER							= WM_USER+1501;

var CMD_SEND_UPDATEAGENTSKILLSET					= WM_USER+1600;
var CMD_SEND_UPDATEAGENTURI							= WM_USER+1601;
var CMD_SEND_DELETEAGENTURI							= WM_USER+1602;
// Command end

// event start
var EVT_SEND_LINKSTATE								= WM_USER+5000;
var EVT_SEND_CONNECTIONSTATE						= WM_USER+6000;
var EVT_SEND_REMOTECONNECTIONSTATE					= WM_USER+6001;
var EVT_SEND_TERMINALCONNECTIONSTATE				= WM_USER+7000;
var EVT_SEND_AGENTSTATE								= WM_USER+8000;
var EVT_SEND_CCTSTATE								= WM_USER+9000;
// event end

// IE start
var IE_SEND_SERVERINFO								= WM_USER+100;

var IE_SEND_USERID									= WM_USER+200;
var IE_SEND_DOMAIN									= WM_USER+201;
var IE_SEND_LOGINID									= WM_USER+202;
var IE_SEND_PASSWORD								= WM_USER+203;
var IE_SEND_INITIALSTATE							= WM_USER+204;
var IE_SEND_REASONCODE								= WM_USER+205;
var IE_SEND_AGENTSTATUS								= WM_USER+206;

var IE_SEND_CONTACT									= WM_USER+300;
var IE_SEND_ADDRESS									= WM_USER+303;
var IE_SEND_TERMINAL								= WM_USER+304;
var IE_SEND_CONTACTID								= WM_USER+305;
var IE_SEND_DESTINATIONADDRESS						= WM_USER+306;
var IE_SEND_TERMINALCONNECTION						= WM_USER+307;
var IE_SEND_CONNECTION								= WM_USER+308;

var IE_SEND_DATA									= WM_USER+400;
var IE_SEND_DETAIL									= WM_USER+402;
var IE_SEND_TERMINALNAME							= WM_USER+403;
var IE_SEND_HANGUL									= WM_USER+404;

var IE_SEND_RESULT									= WM_USER+500;

var IE_SEND_LINKSTATE								= WM_USER+600;

var IE_SEND_ERSINTERFACE							= WM_USER+800;
var IE_SEND_READCONTACT								= WM_USER+888;
var IE_SEND_CONFIRMEVENT							= WM_USER+999;
// IE end

var ATTRIBUTE_CODE_ACCOUNT							= 0x01;
var ATTRIBUTE_CODE_DEVICE_ID						= 0x21;

var OPENETSCON 										= "OPEN";
var CLOSEETSCON 									= "CLOSE";
var INITSDK											= "INIT";
var DEINITSDK 										= "DINIT";
var CONNECTTOSERVER									= "CNCT";

var LOGIN 											= "LOGIN";
var LOGOUT 											= "LOGOU";
var SSOLOGIN                                        = "SLOGI";
var SSOLOGOUT                                       = "SLOGO";
var READY 											= "READY";
var NOTREADY  										= "NRDY";
var MAKECALL 										= "MKCL";
var RELEASE 										= "DROP";
var ACCEPT 											= "ACEPT";
var HOLD 											= "HOLD";
var UNHOLD	 										= "UHOLD";
var HOLDUNHOLD	 									= "HUHLD";
var DTMF                                            = "DTMF";
var TRANSFER 										= "TRNS";
var TRANSFERCOMPLETE								= "CPTRS";
var CONFERENCE 										= "CONF";
var CONFERENCECOMPLETE								= "CPCFR";
var COLLABORATIONCANCEL 							= "CANCL";
var SELECTCONTACT 									= "SELCT";
var SETDATASTR 										= "SDATS";
var SETDATAINTRINSIC								= "SDATI";
var SETDATAUUI										= "SDATU";
var GETDATASTR										= "GDATS";
var GETDATAINTRINSIC								= "GDATI";
var GETDATAUUI										= "GDATU";
var SENDCONTACTHISTORYTOERS 						= "SNERS";
//NCC 추가  20150518
var TRANSFERDATA 									= "TRNSD";
var CONFERENCEDATA 									= "CONFD";
var EVENTPARAMS                                     = "EVTPR";
var EVENTPARAM2                                     = "EVTPR2";

var OBSERVE											= "OBSERVE";
var BARGEIN											= "BARGEIN"

var CCMMLOGIN                                       = "CLOGI";
var CCMMLOGOUT                                      = "CLOGO";
var ORIGINATEMAIL                                   = "OMAIL";
var TRANSFERMAIL                                    = "TMAIL";
var READCONTACT                                     = "RCONT";
var GETSKILLSETID                                   = "CGASS";
var GETLOGINAGENT                                   = "CGLOA";
var GETCLOSEREASON                                  = "CGACR";
var REPLAY                                          = "REPL";
var REPLAYALL                                       = "REPLA";
var FORWARD                                         = "FOWRD";
var CLOSECONTACT                                    = "CCONT";

var CONNECTIONSTATE_0								= "Alerting";
var CONNECTIONSTATE_1								= "Dialing";
var CONNECTIONSTATE_2								= "Disconnected";
var CONNECTIONSTATE_3								= "Established";
var CONNECTIONSTATE_4								= "Failed";
var CONNECTIONSTATE_5								= "Idle";
var CONNECTIONSTATE_6								= "Initiated";
var CONNECTIONSTATE_7								= "NetworkAlerting";
var CONNECTIONSTATE_8								= "NetworkReached";
var CONNECTIONSTATE_9								= "Offered";
var CONNECTIONSTATE_10								= "Queued";
var CONNECTIONSTATE_11								= "Unknown";
var CONNECTIONSTATE_12								= "Routing";
var CONNECTIONSTATE_13								= "Active";
var CONNECTIONSTATE_14								= "Anchored";
var CONNECTIONSTATE_15								= "Controlled";
var CONNECTIONSTATE_16								= "Retrieving";
var CONNECTIONSTATE_17								= "Parked";

var REASON_0										= "Default";
var REASON_1										= "BargeIn";
var REASON_2										= "CallSupervisor";
var REASON_3										= "ConferenceComplete";
var REASON_4										= "ConferenceInitiated";
var REASON_5										= "ConsultComplete";
var REASON_6										= "ConsultInitiated";
var REASON_7										= "Emergency";
var REASON_8										= "Observe";
var REASON_9										= "Park";
var REASON_10										= "Redirect";
var REASON_11										= "Reject";
var REASON_12										= "Route";
var REASON_13										= "Shutdown";
var REASON_14										= "TransferComplete";
var REASON_15										= "TransferInitiated";
var REASON_16										= "Whisper";
var REASON_17										= "DefaultTreatment";
var REASON_18										= "ForceDisconnect";
var REASON_19										= "AddressRemoved";
var REASON_20										= "NotReady";
var REASON_21										= "Pull";
var REASON_22										= "Denied";
var REASON_23										= "Cancelled";
var REASON_24										= "Timeout";
var REASON_25										= "InsufficientResources";
var REASON_26										= "BulkRecord";
var REASON_27										= "DemandRecord";
var REASON_28										= "ProviderOutOfService";
var REASON_29										= "ResourceNotFound";
var REASON_30										= "ResourceDisabled";
var REASON_31										= "AcquisitionFailure";
var REASON_32										= "LicenseNotGranted";
var REASON_33		     							= "RelatedResourceNotLicensed";
var REASON_34										= "InitiatedByAgent";
var REASON_35										= "InitiatedBySystem";
var REASON_36										= "CTILinkDown";
var REASON_37										= "CTILinkUp";
var REASON_38										= "PINValidation";
var REASON_39										= "DigitCollection";
var REASON_40										= "ContextCreation";
var REASON_41										= "DestinationBusy";
var REASON_42										= "ServerError";
var REASON_43										= "ServiceUnavailable";
var REASON_44										= "CallForwardImmediate";
var REASON_45										= "CallForwardNoAnswer";
var REASON_46										= "InvalidRequest";
var REASON_47										= "AssignedToUser";
var REASON_48										= "UnassignedFromUser";
var REASON_49										= "SupervisorAssociation";

var RESOURCESTATE_0									= "Invalid";
var RESOURCESTATE_1									= "OutOfService";
var RESOURCESTATE_2									= "InService";
var RESOURCESTATE_3									= "Unknown";

var TERMINALCONNECTIONSTATE_0					    = "Active";
var TERMINALCONNECTIONSTATE_1					   	= "Bridged";
var TERMINALCONNECTIONSTATE_2						= "Dropped";
var TERMINALCONNECTIONSTATE_3						= "Held";
var TERMINALCONNECTIONSTATE_4						= "Idle";
var TERMINALCONNECTIONSTATE_5						= "InUse";
var TERMINALCONNECTIONSTATE_6						= "Ringing";
var TERMINALCONNECTIONSTATE_7						= "Unknown";

var LINKSTATE_0										= "Unknown";
var LINKSTATE_1										= "Connecting";
var LINKSTATE_2										= "ConnectionFailed";
var LINKSTATE_3										= "ConnectedStandby";
var LINKSTATE_4										= "ConnectedActive";
var LINKSTATE_5										= "Disconnected";
var LINKSTATE_6										= "Unconfigured";

var LINKSTATEREASON_0								= "Default";
var LINKSTATEREASON_1								= "Unreachable";
var LINKSTATEREASON_2								= "AuthenticationFailure";
var LINKSTATEREASON_3								= "InvalidCredentials";
var LINKSTATEREASON_4								= "UnauthorizedUser";
var LINKSTATEREASON_5								= "NoLicense";
var LINKSTATEREASON_6								= "LoginOperationFailure";
var LINKSTATEREASON_7								= "SessionSetupFailure";
var LINKSTATEREASON_8								= "ChannelClosed";
var LINKSTATEREASON_9								= "ChannelFaulted";
var LINKSTATEREASON_10							    = "TransitionToStandby";
var LINKSTATEREASON_11								= "TransitionToActive";
var LINKSTATEREASON_12								= "ClientServerIncompatibility";
var LINKSTATEREASON_13								= "RequestTimeout";
var LINKSTATEREASON_14								= "UnauthorizedApplication";
var LINKSTATEREASON_15								= "NoTerminal";

var LINKID_0										= "Primary";
var LINKID_1										= "CampusAlternate";
var LINKID_2										= "GeographicAlternate";

var TOOLKITSTATE_0									= "Disconnected";
var TOOLKITSTATE_1									= "Connecting";
var TOOLKITSTATE_2									= "Connected";
var TOOLKITSTATE_3									= "ConnectedNoStandby";
var TOOLKITSTATE_4									= "ConnectedGeographic";
var TOOLKITSTATE_5									= "Reconnecting";
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// start Char 구조체
var	strDN = "          ";
var MessageHeader = new Object();
	MessageHeader.m_strSOP 										= "";
	MessageHeader.m_strMsgLength 								= "";
	MessageHeader.m_strMsgUniqueID 								= "";
	MessageHeader.m_strMsgType 									= "";
	MessageHeader.m_strSourceID 								= "";
	MessageHeader.m_strMsgID 									= "";
	MessageHeader.m_strIEID 									= "";
	MessageHeader.m_strIELength 								= "";
	MessageHeader.errmsg 										= "";

var strResultIE = new Object();
	strResultIE.strIEID 										= "";
	strResultIE.strIELength          							= "";
	strResultIE.strCmd               							= "";
	strResultIE.strResult            							= "";
	strResultIE.strREsultDetail    								= "";

var tagStrServerInfo = new Object();
	tagStrServerInfo.strIEID 									= "";
	tagStrServerInfo.strDataIELength 							= "";
	tagStrServerInfo.strServerA								= "";
	tagStrServerInfo.strServerS								= "";
	tagStrServerInfo.strServerG								= "";
	tagStrServerInfo.strBServerPort							= "";
	tagStrServerInfo.strResultIEID								= "";
	tagStrServerInfo.strResultIELength							= "";
	tagStrServerInfo.strResult								= "";
	tagStrServerInfo.strREsultDetail  							= "";

var tagStrUserID  = new Object();
	tagStrUserID.strResultIEID 								= "";
	tagStrUserID.strIELength 									= "";
	tagStrUserID.strUserID 									= "";

var tagStrDomain  = new Object();
	tagStrDomain.strIEID 										= "";
	tagStrDomain.strIELength									= "";
	tagStrDomain.strDomain   									= "";

var tagStrLoginID  = new Object();
	tagStrLoginID.strIEID 										= "";
	tagStrLoginID.strIELength   								= "";
	tagStrLoginID.strLoginID									= "";

var tagStrPassword  = new Object();
	tagStrPassword.strResultIEID 								= "";
	tagStrPassword.strIELength 								= "";
	tagStrPassword.strPassword									= "";

var tagStrInitialState  = new Object();
	tagStrInitialState.strIEID 								= "";
	tagStrInitialState.strIELength          					= "";
	tagStrInitialState.strInitialState 						= "";

var tagStrReasonCode  = new Object();
	tagStrReasonCode.strResultIEID  							= "";
	tagStrReasonCode.strIELength 								= "";
	tagStrReasonCode.strReasonCode 							= "";

var tagStrAgentStatus  = new Object();
	tagStrAgentStatus.strIEID 									= "";
	tagStrAgentStatus.strIELength 								= "";
	tagStrAgentStatus.strAgentStatus							= "";

var tagStrContact  = new Object();
	tagStrContact.strIEID 										= "";
	tagStrContact.strIELength 									= "";
	tagStrContact.strCalledAddrLength 							= "";
	tagStrContact.strCalledAddr	   							= "";
	tagStrContact.strCallingAddrLength 						= "";
	tagStrContact.strCallingAddr								= "";
	tagStrContact.strCallingTerminalLength						= "";
	tagStrContact.strCallingTerminal 							= "";
	tagStrContact.strContactType 								= "";
	tagStrContact.strContactID 								= "";
	tagStrContact.strLastReDirectAddrLength 					= "";
	tagStrContact.strLastReDirectAddr 							= "";
	tagStrContact.strMainContactID 							= "";
	tagStrContact.strOriginalDestinationLength 				= "";
	tagStrContact.strOriginalDestination 						= "";

var tagStrTerminalConnection  = new Object();
	tagStrTerminalConnection.strResultIEID 					= "";
	tagStrTerminalConnection.strIELength 						= "";
	tagStrTerminalConnection.strContactType					= "";
	tagStrTerminalConnection.strContactID 					= "";
	tagStrTerminalConnection.strNew 							= "";
	tagStrTerminalConnection.strPrevious 						= "";
	tagStrTerminalConnection.strisMute 						= "";
	tagStrTerminalConnection.strReason 						= "";

var tagStrConnection  = new Object();
	tagStrConnection.strIEID      								= "";
	tagStrConnection.strIELength 								= "";
	tagStrConnection.strContactID 							= "";
	tagStrConnection.strNew 									= "";
	tagStrConnection.strPrevious 								= "";
	tagStrConnection.strisRemote								= "";
	tagStrConnection.strReason 								= "";

var tagStrAddress  = new Object();
	tagStrAddress.strIEID 										= "";
	tagStrAddress.strIELength 									= "";
	tagStrAddress.strNameLength	      						= "";
	tagStrAddress.strName 										= "";
	tagStrAddress.strURILength 								= "";
	tagStrAddress.strURI 										= "";
	tagStrAddress.strDoNotDisturb 								= "";
	tagStrAddress.strIsForwarded   							= "";
	tagStrAddress.strResourceState 							= "";

var tagStrTerminal  = new Object();
	tagStrTerminal.strIEID 									= "";
	tagStrTerminal.strIELength 								= "";
	tagStrTerminal.strNameLength 								= "";
	tagStrTerminal.strName 									= "";
	tagStrTerminal.strURILength 								= "";
	tagStrTerminal.strURI 										= "";
	tagStrTerminal.strDoNotDisturb 							= "";
	tagStrTerminal.strIsForwarded 								= "";
	tagStrTerminal.strResourceState 							= "";

var tagStrContactID  = new Object();
	tagStrContactID.strIEID 									= "";
	tagStrContactID.strIELength 								= "";
	tagStrContactID.strContactID 								= "";

var tagStrCLID  = new Object();
	tagStrCLID.strIEID 										= "";
	tagStrCLID.strIELength 									= "";
	tagStrCLID.strCLID 										= "";

var tagStrDialedNumber  = new Object();
	tagStrDialedNumber.strIEID 								= "";
	tagStrDialedNumber.strIELength 							= "";
	tagStrDialedNumber.strDialedNumber 						= "";

var tagStrData  = new Object();
	tagStrData.strIEID 										= "";
	tagStrData.strIELength 									= "";
	tagStrData.strContactID 									= "";
	tagStrData.strDataIEID 									= "";
	tagStrData.strDataIELength 								= "";
	tagStrData.strData											= "";
	tagStrData.strResultIEID 									= "";
	tagStrData.strResultIELength 								= "";
	tagStrData.strResult										= "";
	tagStrData.strResultDetail 								= "";

var tagStrDetails  = new Object();
	tagStrDetails.strIEID 										= "";
	tagStrDetails.strIELength 									= "";
	tagStrDetails.strDetails 									= "";

var tagStrTerminalName  = new Object();
	tagStrTerminalName.strIEID 								= "";
	tagStrTerminalName.strIELength 							= "";
	tagStrTerminalName.strTerminalName 						= "";

var tagStrResult  = new Object();
	tagStrResult.strIEID 										= "";
	tagStrResult.strIELength 									= "";
	tagStrResult.strResult 									= "";
	tagStrResult.strREsultDetail 								= "";

var tagStrLinkState  = new Object();
	tagStrLinkState.strIEID 									= "";
	tagStrLinkState.strIELength 								= "";
	tagStrLinkState.strLinkState 								= "";
	tagStrLinkState.strLinkStateReason 						= "";
	tagStrLinkState.strLinkID 									= "";
	tagStrLinkState.strToolkitState 							= "";
	tagStrLinkState.strServerAddress 							= "";

var tagStrERSInterface  = new Object();
	tagStrERSInterface.strIEID 								= "";
	tagStrERSInterface.strIELength 							= "";	
	tagStrERSInterface.strAgentID 							= "";
	tagStrERSInterface.strUniqueID 							= "";
	tagStrERSInterface.strCode 								= "";
	tagStrERSInterface.strCode2 								= "";
	tagStrERSInterface.strComments 							= "";
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Event 구조체

var tagStrConnectionStateEvent = new Object();
	tagStrConnectionStateEvent.strName 							= "";
	tagStrConnectionStateEvent.strURI 							= "";
	tagStrConnectionStateEvent.strDoNotDisturb 					= "";
	tagStrConnectionStateEvent.strIsForwarded 					= "";
	tagStrConnectionStateEvent.strResourceState 					= "";
	tagStrConnectionStateEvent.strConnectionContactID 			= "";
	tagStrConnectionStateEvent.strNew 							= "";
	tagStrConnectionStateEvent.strPrevious 						= "";
	tagStrConnectionStateEvent.strisRemote 						= "";
	tagStrConnectionStateEvent.strReason 						= "";
	tagStrConnectionStateEvent.strCalledAddr 					= "";
	tagStrConnectionStateEvent.strCallingAddr 					= "";
	tagStrConnectionStateEvent.strCallingTerminal 				= "";
	tagStrConnectionStateEvent.strContactType 					= "";
	tagStrConnectionStateEvent.strContactID 						= "";
	tagStrConnectionStateEvent.strLastReDirectAddr 				= "";
	tagStrConnectionStateEvent.strMainContactID 					= "";
	tagStrConnectionStateEvent.strOriginalDestination	 		= "";	

var tagStrRemoteConnectionStateEvent = new Object();
	tagStrRemoteConnectionStateEvent.strName 					= "";
	tagStrRemoteConnectionStateEvent.strURI 					= "";
	tagStrRemoteConnectionStateEvent.strDoNotDisturb 			= "";
	tagStrRemoteConnectionStateEvent.strIsForwarded 			= "";
	tagStrRemoteConnectionStateEvent.strResourceState 			= "";
	tagStrRemoteConnectionStateEvent.strConnectionContactID 	= "";
	tagStrRemoteConnectionStateEvent.strNew 					= "";
	tagStrRemoteConnectionStateEvent.strPrevious 				= "";
	tagStrRemoteConnectionStateEvent.strisRemote 				= "";
	tagStrRemoteConnectionStateEvent.strReason 					= "";
	tagStrRemoteConnectionStateEvent.strCalledAddr 				= "";
	tagStrRemoteConnectionStateEvent.strCallingAddr 			= "";
	tagStrRemoteConnectionStateEvent.strCallingTerminal 		= "";
	tagStrRemoteConnectionStateEvent.strContactType 			= "";
	tagStrRemoteConnectionStateEvent.strContactID 				= "";
	tagStrRemoteConnectionStateEvent.strLastReDirectAddr 		= "";
	tagStrRemoteConnectionStateEvent.strMainContactID 			= "";
	tagStrRemoteConnectionStateEvent.strOriginalDestination 	= "";

var tagStrTerminalConnectionStateEvent = new Object();
	tagStrTerminalConnectionStateEvent.strName 					= "";
	tagStrTerminalConnectionStateEvent.strURI 					= "";
	tagStrTerminalConnectionStateEvent.strDoNotDisturb 			= "";
	tagStrTerminalConnectionStateEvent.strIsForwarded 			= "";
	tagStrTerminalConnectionStateEvent.strResourceState 		= "";
	tagStrTerminalConnectionStateEvent.strConnectionContactType	= "";
	tagStrTerminalConnectionStateEvent.strConnectionContactID 	= "";
	tagStrTerminalConnectionStateEvent.strNew 					= "";
	tagStrTerminalConnectionStateEvent.strPrevious 				= "";
	tagStrTerminalConnectionStateEvent.strisMute 				= "";
	tagStrTerminalConnectionStateEvent.strReason 				= "";
	tagStrTerminalConnectionStateEvent.strCalledAddr 			= "";
	tagStrTerminalConnectionStateEvent.strCallingAddr 			= "";
	tagStrTerminalConnectionStateEvent.strCallingTerminal 		= "";
	tagStrTerminalConnectionStateEvent.strContactType 			= "";
	tagStrTerminalConnectionStateEvent.strContactID 			= "";
	tagStrTerminalConnectionStateEvent.strLastReDirectAddr 		= "";
	tagStrTerminalConnectionStateEvent.strMainContactID 		= "";
	tagStrTerminalConnectionStateEvent.strOriginalDestination 	= "";	

var tagStrAgentState = new Object();
	tagStrAgentState.strTerminalName 							= "";
	tagStrAgentState.strAgentState 								= "";
	tagStrAgentState.strUserID 									= "";
	tagStrAgentState.strReasonCode 								= "";
	tagStrAgentState.strLoginID 								= "";

var tagStrCCTConnect = new Object();
	tagStrCCTConnect.strUserID 									= "";
	tagStrCCTConnect.strData 									= "";
	tagStrCCTConnect.strAgentState 								= "";

var tagStrLinkStateEvent = new Object();
	tagStrLinkStateEvent.strLinkState 							= "";
	tagStrLinkStateEvent.strLinkStateReason 					= "";
	tagStrLinkStateEvent.strLinkID 								= "";
	tagStrLinkStateEvent.strToolkitState 						= "";
	tagStrLinkStateEvent.strServerAddress 						= "";
	tagStrLinkStateEvent.strTerminalName 						= "";
// End Event 구조체
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
var tagStrError = new Object();
	tagStrError.nErrorCode 										= "";
	tagStrError.Info 											= "";




//var tagFailCode = new Object();
//	tagFailCode.E_EAPI_FAIL_CODE_ACOUNT_DEVICE_BLAND			= 2004;
