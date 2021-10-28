/**
 *
 */



/** 한글 formatter */

function ECMError(code, message){
	var msg="";
	var propertiy = "";
	if(message.indexOf("[")!=-1){
		propertiy = message.match(/\[(.*)\]/)[1];
	}
	var reason = "";
	if(code=="112"||code=="113"){
		reason = message.split(":")[1].trim();
	}
	switch(code){
		case "111":
			msg=message.replace("Not Found Entity", "엔티티가 없음");
			break;
		case "112":
			msg=message.replace("Failed to Register", "엔티티 등록 실패");
			break;
		case "113":
			msg=message.replace("Not Allowed Manipulation", "엔티티 수정, 삭제 실패");
			break;
		case "114":
			msg=message.replace("Type Mismatch", "유효하지 않은 유형의 데이터 입력");
			break;
		case "121":
			msg=message.replace("Duplicated Body Parameter", "중복 데이터 입력");
			break;
		case "122":
			msg=message.replace("Missing Parameter", "특정 속성 값이 입력되지 않음");
			break;
		case "123":
			msg=message.replace("Invalid Query Parameter", "잘못된 Query 파라미터 입력");
			break;
		case "124":
			msg=message.replace("Invalid Body Parameter", "잘못된 Body 파라미터 입력");
			break;
		case "125":
			msg=message.replace("Invalid Entity Status", "잘못된 엔티티 상태 입력");
			break;
		case "126":
			msg=message.replace("Limit Excess", "문자열 길이, 정수 범위 등 초과된 값 입력");
			break;
		case "127":
			msg=message.replace("Empty Result", "로직 수행 중 특정 값이 없을 때");
			break;
		case "131":
			msg=message.replace("Unknown Value", "로직 수행 중 특정 값을 알 수 없음");
			break;
		case "141":
			msg=message.replace("Not Allowed Operation", "허용되지 않은 동작을 수행하려고 함");
			break;
		case "181":
			msg=message.replace("Invalid Format", "잘못된 형식의 데이터 입력");
			break;
		case "182":
			msg=message.replace("Json Parsing Error", "JSON 파싱 에러");
			break;
		case "201":
			msg=message.replace("Not Found Job", "실행중인 작업을 찾을 수 없음");
			break;
		case "202":
			msg=message.replace("Cannot execute Operation", "실행 가능한 작업 상태가 아님");
			break;
		case "203":
			msg=message.replace("Not Running Campaign Job", "실행중인 캠페인 작업이 아님");
			break;
		case "204":
			msg=message.replace("Invalid Job Parameters", "잘못된 작업 파라미터 입력");
			break;
		case "205":
			msg=message.replace("Job is already running", "이미 실행중인 작업");
			break;
		case "801":
			msg=message.replace("Restricted Paramter", "제한된 파라미터 입력");
			break;
		case "900":
			msg=message.replace("Read Timeout", "타임아웃 초과");
			break;
		case "999":
			msg="알 수 없는 에러"
			break;
		case "101":
			msg="로그인 실패"
			break;
		case "102":
			msg="접근 제한"
			break;
		case "105":
			msg="요청에 토큰이 입력되지 않음.\n5초 뒤 로그아웃 됩니다."
			break;
		case "106":
			msg="잘못된 형식의 토큰 입력.\n5초 뒤 로그아웃 됩니다."
			break;
		case "107":
			msg="토큰 만료됨.\n5초 뒤 로그아웃 됩니다."
			break;
		case "109":
			msg="제한된 사용자의 접근"
			break;
	}
	if(code=="105"||code=="106"||code=="107"){
		setTimeout(function(){top.location.href = "/lo/loin01.do";}, 5000)
	}

	return msg;
}


function setAttrType(value){
	//console.log(value)
	var format="";;
	if(value=='Predefined'){
		format='시스템';
	}else if(value=='Custom'){
		format='사용자 정의';
	}else{
		format="";
	}
	return format;
}

function setcontactPropertyName01(value){
	//console.log(value)
	var format="";;
	switch(value) {
		case "contactId" :
			format='컨택 아이디';
			break;
		case "userContactId" :
			format='사용자 컨택 아이디';
			break;
		case "title" :
			format='제목';
			break;
		case "firstName" :
			format='이름';
			break;
		case "lastName" :
			format='성';
			break;
		case "addressLine1" :
			format='주소1';
			break;
		case "addressLine2" :
			format='주소2';
			break;
		case "addressLine3" :
			format='주소3';
			break;
		case "addressLine4" :
			format='주소4';
			break;
		case "addressLine5" :
			format='주소5';
			break;
		case "phoneNumber1" :
			format='전화번호1';
			break;
		case "phoneNumber1CountryCode" :
			format='전화번호1 국가코드';
			break;
		case "phoneNumber1TimeZone" :
			format='전화번호1 시간대';
			break;
		case "phoneNumber1TimeZoneInteger" :
			format='전화번호1 시간대(밀리초)';
			break;
		case "phoneNumber2" :
			format='전화번호2';
			break;
		case "phoneNumber2CountryCode" :
			format='전화번호2 국가코드';
			break;
		case "phoneNumber2TimeZone" :
			format='전화번호2 시간대';
			break;
		case "phoneNumber2TimeZoneInteger" :
			format='전화번호1 시간대(밀리초)';
			break;
		case "email" :
			format='이메일';
			break;
		case "language" :
			format='언어';
			break;
		case "lastAttemptTime" :
			format='마지막 시도 시간';
			break;
		case "lastSuccessfulAttemptTime" :
			format='마지막 성공 시도 시간';
			break;
		case "lastCompletionCodeId" :
			format='마지막 완료 코드 아이디';
			break;
		case "country" :
			format='국가';
			break;
		case "zipcode" :
			format='우편번호';
			break;
		case "contactStatusFlag" :
			format='컨택 상태';
			break;
		case "phoneNumber1State" :
			format='전화번호1 상태';
			break;
		case "phoneNumber2State" :
			format='전화번호2 상태';
			break;
		case "phoneNumber1Wireless" :
			format='전화번호1 무선 여부';
			break;
		case "phoneNumber2Wireless" :
			format='전화번호2 무선 여부';
			break;
		case "lastModifiedOn" :
			format='마지막 수정 시간';
			break;
		case "counter" :
			format='시도 횟수';
			break;
		case "lastAddressDialedAttributeName" :
			format='마지막 다이얼된 특성 이름';
			break;
		case "lastHandledByAgentId" :
			format='마지막 연결된 상담원 아이디';
			break;
		case "lastNuisanceCallTime" :
			format='마지막 포기콜 시간';
			break;
		case "systemAgentId" :
			format='시스템 상담원 아이디';
			break;

		default :
			format=value;
		break;
	}

	return format;
}


function datasourceTypeKr(value){
	var format="";;
	switch(value) {
		case "contact_file" :
			format='파일';
			break;
		case "database_sql" :
			format='데이터베이스';
			break;
		case "custom" :
			format='사용자 정의';
			break;
		case "upload_file" :
			format='파일 업로드';
			break;
		case "dnc_file_for_add" :
			format='DNC 파일 추가';
			break;
		case "dnc_file_for_remove" :
			format='DNC 파일 제거';
			break;
		case "exclude_contacts" :
			format='컨택 제외';
			break;
		case "reset_excluded_contacts" :
			format='제외된 컨택 재설정';
			break;
		case "EXCLUDE_CONTACTS_FILE" :
			format='컨택 파일 제외';
			break;
		case "EXCLUDE_CONTACTS_DB" :
			format='컨택 데이터베이스 제외';
			break;
		case "EXCLUDE_CONTACTS_CUSTOM" :
			format='컨택 사용자 정의 제외';
			break;
		default :
			format=value;
		break;
	}
	return format;
}

function strategyTypeKr(value){
	var format="";;
	switch(value) {
		case "Draft" :
			format='초안';
			break;
		case "Template" :
			format='템플릿';
			break;
		case "Completed" :
			format='완료';
			break;
		default :
			format=value;
		break;
	}
	return format;
}

function datasourceActiveKr(value){
	if(value!=""){
		if(value=="INACTIVE"){
			return "대기 중";
		}else{
			return "진행 중";
		}
	}else{
		return value;
	}
}

function lastDatasourceJobStatus(value){
	var format="";
	switch(value){
		case "NotExecuted":
			format="-";
			break;
		case "Completed":
			format="완료";
			break;
		case "Queued":
			format="대기";
			break;
		case "Running":
			format="실행 중";
			break;
		case "Error":
			format="에러";
			break;
		case "FileCopying":
			format="파일 복사 중";
			break;
		case "Pausing":
			format="중지 중";
			break;
		case "Paused":
			format="중지";
			break;
		case "Stopping":
			format="종료 중";
			break;
		case "WaitingToResume":
			format="재개 대기 중";
			break;
		case "DeletingContact":
			format="컨택 삭제 중";
			break;
		case "CreatingHistoryRecords":
			format="히스토리 레코드 생성 중";
			break;
	}
	return format;
}