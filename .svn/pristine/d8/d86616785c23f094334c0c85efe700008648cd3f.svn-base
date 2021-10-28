/**
 *  로그인
 */
var viewData = {
	userId:"",
	password:""
};

//시작
$(document).ready(function(e) {
	sessionClear();

	var tmpId = getLocalItem("userId");
	//console.log(getLocalItem("userId"))
	if (!fnIsNull(tmpId)) {
		$("#userId").val(tmpId);
		$("input:checkbox[id='saveUserId']").attr("checked", true);
	}

	$("#userId").keyup(function(e){ loginEnter(e);});
	$("#password").keyup(function(e){ loginEnter(e);});

});

// 로그인 클릭
$("#login").click(function() {
	viewData = {userId:"", password:"", stgUserId:"", stgExtNo:""}; // 로그인 데이터 초기화

	viewData.userId = $.trim($("#userId").val());
	viewData.password = $.trim($("#password").val());

	viewData.stgUserId = getLocalItem("userId");

	if (loin01Validator()) { // 화면 입력값 검증
		progressShow();
		LOIN01_Service.findUser(viewData, function(rslt) { // 서버 로그인 처리 로직
			progressHide();
			if (rslt.result == "S") {
				var resetYn = rslt.inf.resetYn;
				setSessionItem("_loginInfo", JSON.stringify(rslt.inf));
				if(resetYn=="Y"){
					LLYNX_Alert("현재 비밀번호가 초기비밀번호입니다.\n비밀번호를 변경해주세요.", "function", "chPassUp");
				}else{
					loin01LocalSaveAndMove(); // 메인화면 이동
				}
			} else {
				LLYNX_Alert(rslt.message);
				$("#password").val("");
				return;
			}
		});
	}
});

// 입력값 검증
function loin01Validator() {
	if (viewData.userId=="") {
		LLYNX_Alert("사용자 ID를 입력하지 않았습니다.");
		$("#userId").focus();
		return false;
	}

	if (viewData.password=="") {
		LLYNX_Alert("비밀번호를 입력하지 않았습니다.");
		$("#password").focus();
		return false;
	} else {
		var strCrypto = getCrypto(viewData.password, 9);
		if (strCrypto!="error") {
			viewData.password = strCrypto;
		}
	}

	return true;
}

// 저장후 메인화면 이동
function loin01LocalSaveAndMove() {
	if ($("#saveUserId").prop("checked")) {
		//console.log(viewData.userId);
		setLocalItem("userId", viewData.userId);
	} else {
		localRemove("userId");
	}

	window.location.href = "/fr/frfr01.do"; // 메인화면호출
}

// 비밀번호 변경화면 호출
$("#tmodal_1").click(function(e) {
	var tmpId = $.trim($("#userId").val());
	if (tmpId=="") {
		LLYNX_Alert("비밀번호 변경할 사용자 ID를 입력하세요", 'focus', 'userId');
	} else {
		modalOpen( $(this).attr("id"));
		pswdChangeUser(tmpId);
	}
});

function chPassUp(){
	var tmpId = $.trim($("#userId").val());
	if (tmpId=="") {
		LLYNX_Alert("비밀번호 변경할 사용자 ID를 입력하세요", 'focus', 'userId');
	} else {
		modalOpen($("#tmodal_1").attr("id"));
		pswdChangeUser(tmpId);
	}
}

function loginEnter(e) {
	if (e.keyCode == 13) {
		$("#login").click();
	}
}

var viewMsg = false;
function capslock(e) {
	var keyCode = 0;
	var shirftKey = false;

	if (!viewMsg) {
		shirftKey = e.shirftKey;
		keyCode = e.keyCode;

		if( ((keyCode>=65&&keyCode<90) && !shirftKey)
				|| ((keyCode>=97&&keyCode<=112) && shirftKey) ) {
			LLYNX_Alert("CapsLock이 켜져 있습니다.");
			viewMsg = true;
		}
	}

}