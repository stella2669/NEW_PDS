/**
 * 
 */

$(document).ready(function(){
	var url = document.location.pathname;
	
	if(url!="/lo/loin01.do"){
		var loginInfo = _getLoginInfo();
		if(loginInfo==null){			
			alert("세션이 만료되었습니다.\n로그인페이지로 이동합니다.");
			top.location.href = "/lo/loin01.do"; // 로그인화면호출
		} 
	}
});