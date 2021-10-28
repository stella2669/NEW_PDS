/**
 *  비밀번호 변경
 */
var oldPswd = "";
var inptPswd = "";
var viewData = {
		userId:"",
		password:""
}

$(document).ready(function(){
});


$("#oPswd").keyup(function(e){ chgPswdEnter(e);});
$("#nPswd").keyup(function(e){ chgPswdEnter(e);});
$("#cPswd").keyup(function(e){ chgPswdEnter(e);});

// 비밀번호 변경 사용자 정보 조회
function pswdChangeUser(id) {
	init(); // 폼 초기화

	viewData.userId = id;
	$("#id").text(id);

	progressShow();

	LOCH01_Service.findUser(viewData, function(result) {
		progressHide();

		if (result.result=="F") { // 사용자 조회 실패
			LLYNX_Alert(result.message);
			$("#close").click(); // 창닫기
		} else {
			//alert(JSON.stringify(result));
			oldPswd = result.password;
			//alert(result.result.password);
		}
	});
}

// 팝업창 닫기, 취소버튼 클릭
$(".popup_close").click(function(e){
	e.preventDefault();

	init(); // 초기화
	modalClose(this); //
});

// 비밀번호 변경
$("#save").click(function() {
	if (loch01Validator()) {
		LLYNX_Confirm("비밀번호를 변경하시겠습니까?", "changePasswordFunc");
	}
});

function changePasswordFunc(){
	progressShow();
	LOCH01_Service.updateUserPswd(viewData, function(result) {
		progressHide();

		LLYNX_Alert(result.message);
		if (result.result=="S") {
			$(".popup_close").click(); // 창닫기
		}
	});
}

// 입력값 검증
function loch01Validator() {
	combo = false;
    numeric = false;
    literal = false;
    specialWord = false;

    var userId = viewData.userId;// 로그인 아이디
    var oPswd = $.trim($("#oPswd").val()); // 현재 비밀번호
    var nPswd = $.trim($("#nPswd").val()); // 변경 비밀번호
    var cPswd = $.trim($("#cPswd").val()); // 변경 비밀번호 확인

   if (oPswd.length<1) {
	   LLYNX_Alert("이전 비밀번호를 입력하세요.");
	   $("#oPswd").focus();

       return false;
   }

   inptPswd = getCrypto(oPswd, 9);
   if (inptPswd=="error") {
       LLYNX_Alert("이전 비밀번호는 9자이상 16자 이내 이어야 합니다.");
       $("#oPswd").focus();

       return false;
   }

   if (oldPswd!=inptPswd) {
		LLYNX_Alert("이전 비밀번호가 틀렸습니다.\n다시 입력하세요.");
		$("#oPswd").val("");
		$("#oPswd").focus();

		return false;
   }

   if (nPswd.length<1) {
	   LLYNX_Alert("신규 비밀번호를 입력하세요.");
	   $("#nPswd").focus();

	   return false;
   }

   if (nPswd.length<9 || nPswd.length>16) {
        LLYNX_Alert("신규 비밀번호는 9자이상 16자 이내 이어야 합니다.");
        $("#nPswd").val("");
        $("#nPswd").focus();
        return false;
   }

   if (cPswd.length<1) {
		LLYNX_Alert("신규 비밀번호 확인을 입력하세요.");
		$("#cPswd").focus();

		return false;
   }

   if (nPswd!=cPswd) {
        LLYNX_Alert("신규 비밀번호와 신규 비밀번호 확인이 다릅니다.");
        $("#cPswd").val("");
        $("#cPswd").focus();

        return false;
   }
   inptPswd = getCrypto(nPswd, 9);
   if (oldPswd==inptPswd) {
        LLYNX_Alert("이전 비밀번호를 재사용 할 수 없습니다.");
        $("#nPswd").val("");
        $("#cPswd").val("");
        $("#nPswd").focus();

        return false;
   }

   if (userId==nPswd) {
        LLYNX_Alert("사용자 ID를 비밀번호로 사용할 수 없습니다.");
        $("#nPswd").val("");
        $("#cPswd").val("");
        $("#nPswd").focus();

        return false;
    }

    // 3자이상 중복 확인
    var cnt = 0;
    for(i=0; i<(nPswd.length - 1); i++) {
        if(nPswd.charCodeAt(i)==nPswd.charCodeAt(i+1)) {
            cnt++;
            if(cnt > 1) combo = true;
        } else {
            cnt = 0;
        }
    }

    // 문자와 숫자 혼용확인
    for (i=0; i<nPswd.length; i++) {
        if (nPswd.charCodeAt(i)<48 || nPswd.charCodeAt(i)>57) {
            literal = true;
        } else if(nPswd.charCodeAt(i)>=48 || nPswd.charCodeAt(i)<=57) {
            numeric = true;
        }
    }

    //특수문자 체크
    var special_pettern ="~!@#$%^&*()-=+_'/|\[]?.,";
    for (i=0; i<nPswd.length; i++) {
    	for(j=0; j<special_pettern.length; j++) {
    		if(nPswd.charAt(i) == special_pettern.charAt(j)) {
    			specialWord = true;
    			break;
    		}
    	}
    }

    if (combo) {
        LLYNX_Alert("신규 비밀번호에 연속으로 3글자이상 들어가면 안됩니다.");
        $("#nPswd").val("");
        $("#cPswd").val("");
        $("#nPswd").focus();

        return false;
    }

    if (literal!=true || numeric!=true || specialWord!=true)
    {
        LLYNX_Alert("신규 비밀번호는 영문자, 숫자 및 특수문자를 혼용하여야 합니다.");
        $("#nPswd").val("");
        $("#cPswd").val("");
        $("#nPswd").focus();

        return false;
    }

    viewData.password = getCrypto(nPswd, 9);

	return true;
}

// 초기화
function init() {
	oldPswd = "";
	inptPswd = "";
	viewData={userId:"",password:""};
	$("#pCnsrId").val("");
	$("#oPswd").val("");
	$("#nPswd").val("");
	$("#cPswd").val("");
}

function chgPswdEnter(e) {
	if (e.keyCode == 13) {
		$("#save").click();
	}
}