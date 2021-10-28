//소프트폰 로그인
function init(){
	if (ctiid != ""){
		TSPhone.OcxInit("172.17.183.233" , "172.17.183.233" , "9710", ctiid, dn, "1","");
		//callReady();
	}
}
//전화받기
function callAction(){
	TSPhone.AnwserCall();
}

//대기상태로 전환
function callReady(){
	TSPhone.AgentReady();
}

//후처리상태로 전환
function callAfter(){
	TSPhone.AgentAfterCallWork();
}

//휴식
function callNotReady(){
	TSPhone.AgentAfterCallWork();
}

//전화벨 울릴때 뜨는 팝업
function answerCall(callData, popupname, width, height) {		
	
	var winl = (screen.width - width) / 2;
	var wint = (screen.height - height) / 2;
	
	var url = '/paradise/jsp/main/common/answerCall.jsp?calldata='+callData;

	var linkPopup =	window.open(url, popupname,'width='+width+',height='+height+', top='+wint+',left='+winl+', toolbars=no,menubars=no,scrollbars=no');
	linkPopup.focus();
	
}

//전화걸기
function MakeCall(str,knd,tel_gb,page_gb){
}	
		
function consultationCall(){	
}
		
function InCall(){
}

//전화받기
function answerPhone(){
	//form1.TSPhone.answerPhone();		
	start_dt();
}

//전화울림 팝업
function setRing(){	
}

//통화시작시간
function start_dt(){
	$.ajax({
      type: 'POST',
      url: servletPath2+'SystemTime', //데이터 가져올 경로 세팅
      dataType : 'json',      
      success: function(jsonData) {
		  
    	  main.document.mainInfo.START_DATE.value = jsonData.CURRENTDATE;
    	  main.document.mainInfo.START_TIME.value = jsonData.CURRENTTIME;
    	  
      },
      error: function(jsonData) {
      }
    });	
}

//통화종료시간
function end_dt(){
	$.ajax({
      type: 'POST',
      url: servletPath2+'SystemTime', //데이터 가져올 경로 세팅
      dataType : 'json',      
      success: function(jsonData) {
		
    	  main.document.mainInfo.END_DATE.value = jsonData.CURRENTDATE;
    	  main.document.mainInfo.END_TIME.value = jsonData.CURRENTTIME;
 
      },
      error: function(jsonData) {
      }
    });	
}
