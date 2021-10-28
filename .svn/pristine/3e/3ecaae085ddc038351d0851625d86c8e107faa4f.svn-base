/**
 * 소프트폰 관련 변수 선언
 */

let ctiTimerId; // 통화시간 타이머 ID
let accessInfo; // 로딩시 세션조회 결과

const LOG_CLIENT = true; // CTI 이벤트 브라우저 로그 view
const LOG_STAT = false;  // 전화걸기 받기 이벤트만 별도로 분리

const inboundText = ["고객센터 IVR 호인입", "고객센터 상담원 호전환"];
//              외부발신, 고객센터
const PREFIX_NO = ["9", "8"];

// 주민등록번호, 계좌번호, 카드번호, 카드유효기간, 카드비밀번호, 상품설명(상품코드)
const IVR_NO = [84000, 84001, 84002, 84003, 84004, 84005];
const IVR_BLACK_CONSUMER_NO = "83091"; // 성희롱 통화종료

const REASON_CODE = { // 이석 사유코드
    MOT_READY: "00"      // 이석
	, RESTING: "01"      // 휴식
    , LUNCH: "02"        // 식사
    , CONFERENCE: "03"   // 회의
    , IN_EDUCATION: "04" // 교육
    , STEP_OUT: "05"     // 기타
};
const RESAON_TEXT = ["대기해제", "휴식", "식사", "회의", "교육", "기타"];

const WORK_CODE = {  // 업무코드
	 AFTER_WORK: "11"   // 후처리
	 , OUTBOUND: "12"   // 아웃바운드
}
const WORK_TEXT = ["후처리", "아웃바운드"];

const COMMAND_LIST = {
		NOT_USE: "NOTUS"
		, INIT_SDK: "INIT"
		, EVENT_PARAMS: "EVTPR"
		, CONNECT_SERVER: "CNCT"
		, LOGIN: "LOGIN"	
		, LOGOUT: "LOGOU"
		, DEINIT_SDK: "DINIT"
		, READY: "READY"
        , NOT_READY: "NRDY"
        , RINGING: "RING"
        , MAKE_CALL: "MKCL"
	    , ANSWER: "ACEPT"
        , HANGUP: "DROP"
        , HOLD: "HOLD"
        , UN_HOLD: "UHOLD"
        , TRANSFER: "TRNS"
		, TRANSFER_DATA: "TRNSD"
        , TRANSFER_COMPLETE: "CPTRS"
        , CONFERENCE: "CONF"
		, CONFERENCE_DATA: "CONFD"
        , CONFERENCE_COMPLETE: "CPCFR"
        , COLLABORATION_CANCEL: "CANCL"
        , GET_DATA_STR: "GDATS"
        , GET_DATA_UUI: "GDATU"
        , GET_DATA_INTRINSIC: "GDATI"
		, SET_DATA_STR: "SDATS"
		, SET_DATA_UUI: "SDATU"
		, SET_DATA_INTRINSIC: "SDATI"

        , EVENT_DEFAULT: "Default"
        , EVENT_INITIATED: "Initiated"
        , EVENT_IDLE: "Idle"
		, EVENT_ALERTING: "Alerting"
		, EVENT_RINGING: "Ringing"	
		, EVENT_ACTIVE: "Active"	
		, EVENT_ESTABLISHED: "Established"                    
		, EVENT_DROPPED: "Dropped"    
		, EVENT_DISCONNECTED: "Disconnected"
		, EVENT_TRANSFER: "TransferInitiated"
		, EVENT_TRANSFER_COMPLETE: "TransferComplete"
		, EVENT_CONFERENCE: "ConferenceInitiated"
		, EVENT_CONFERENCE_COMPLETE: "ConferenceComplete"
		, EVENT_COLLABORATION_CANCEL: "CollaborationCancel"
		// 에러
		, EVENT_ERR_FAILED : "Failed"
		, EVENT_ERR_INVLIDREQUEST: "InvalidRequest"

        , TO_TRAN_CONF_ONE_STEP: "One"
		, TO_TRAN_CONF_TWO_STEP: "Two"
		, TO_TRAN_CONF_IVR: "Ivr"
		, TO_TRAN_CONF_IVR_GOODS: "IvrGoodsDesc"
				
		, FROM_RESULT: "OnResult"
		, FROM_CONNECTION_STAT: "OnConnectionState"
		, FROM_TERMINAL_CONNECTION_STAT: "OnTerminalConnectionState"
		, FROM_REMOTE_CONNECTION_STAT: "OnRemoteConnectionState"
		, EVNET_HANDLER: "conntectORterminalORremote"
};

let ctiInfo = { // CTI 접속정보
	domain:""   // CTI domain  @see application properties file
	, ip:""     // CTI IP      @see application properties file 
	, port:""   // CTI port    @see application properties file
	, id:""     // 로그인ID - 사용자관리
	, pswd:""   // 공통 로그인 비밀번호 @see application properties file
	, inwrNo:"" // 내선번호 -> 로그인시 입력한 번호 - 미입력시 로그인하지 않음
	, upSvrIp:"" // CTI update 서버 IP
	, etsSender:"" // 통계용
    , etsFtp:""    // 통계용
    , etsReceive:"" // 통계용
    , freeSeat:"" // 통계용
};

// 녹취 접속정보
var recInfo = {};

/** 상담이력등록, 로그인시 초기화됨 */
var SP_INFO = { // 소프트폰 정보
	cmd: "" // 현재 요청
	, prevCmd: "" // 이전 요청
	, tel: {
		io: "" // 인/아웃구분
		, recKey: "" // 녹취키	
		, dialNo:"" // 연결된 전화번호
	    , dialType:"" // 전화유형
		, startDt: "" // 통화시작일시
		, endDt: "" // 통화종료일시
		, talkTime: "" // 총 통화초
		, cid: "" // 2자 전화 ID
		, otherCid: "" // 3자 전화 ID
		, tranConfType:"" // one or two step
		, agentStatus:""
	}, eventResult: { 
		cmd: "" // 현재 처리한 내용
		, result: "" // 처리결과 1성공 else error
		, dtlinfo:"" // 처리결과의 상세정보
		, otherCalled: "" // 호전환/3자 연결정보
		, connStat: {}
		, remoteStat: {}
		, terminalStat: {}
	}   
};