/* design.js 에서 가져옴 */
$(function() {
	// 이석사유코드
	$(".expand").mouseover(function(e){
		e.preventDefault();

		if ($(".btn_soft2").hasClass("select")) {
			$(".expand").addClass("active");
		}
	});
	$(".expand").mouseout(function(e){
		e.preventDefault();

		if ($(".btn_soft2").hasClass("select")) {
			$(".expand").removeClass("active");
		}
	});
	// 이석사유코드

	//main tm_secA
	$(".box_ctrl").click(function(e){
		e.preventDefault();

		if($(this).hasClass("mode_wide")){
			$(".tm_secA , .tm_secB , .box_ctrl").removeClass("mode_wide");
			$(".box_ctrl span").text("고객리스트 닫기")
		} else {
			$(".tm_secA , .tm_secB , .box_ctrl").addClass("mode_wide");
			$(".box_ctrl span").text("고객리스트 열기")
		}
	});


	//byte_chk
	$(".byte_chk").keyup(function(){
		bytesHandler(this);
	});
	//byte_chk -end
});

function getTextLength(str){
	var len = 0;
	for(var i = 0; i < str.length; i++){
		if (escape(str.charAt(i)).length == 6){
			len++;
		}
		len++;
	}
	return len;
}



function date_to_str(format1){
	try{
		if(format1.length>8){
			var format=new Date(format1)
		    var year = format.getFullYear();
		    var month = format.getMonth() + 1;
		    if(month<10) month = '0' + month;
		    var date = format.getDate();
		    if(date<10) date = '0' + date;
		    var hour = format.getHours();
		    if(hour<10) hour = '0' + hour;
		    var min = format.getMinutes();
		    if(min<10) min = '0' + min;
		    var sec = format.getSeconds();
		    if(sec<10) sec = '0' + sec;

		    return year + "-" + month + "-" + date + " " + hour + ":" + min + ":" + sec;
		}else{
			 return "";
		}




	}catch(e){
		return "";
	}
	return "";
}



function bytesHandler(obj){
	var text = $(obj).val();
	$(".byte_info").text(getTextLength(text));
}
/* design.js 에서 가져옴 */


    /**
     * 숫자에 comma를 붙인다.
     *
     * @param   obj
     */
    function addComma(obj) {
        obj.value = trim(obj.value);
        var value = obj.value;

        if (value == "") {
            return;
        }

        value = deleteCommaStr(value);

        if (!isFloat(value)) {
            dispName = obj.getAttribute("dispName");

            if (dispName == null) {
                dispName = "";
            }

            LLYNX_Alert(dispName + " 형식이 올바르지 않습니다.");
            obj.value = "0";
            obj.focus();
            if (window.event) {
                window.event.returnValue = false;
            }
            return;
        }

        obj.value = addCommaStr(value);
    }

    /**
     * 숫자에 comma를 붙인다.
     */
    function addComma2() {
        var obj = window.event.srcElement;
        addComma(obj);
    }

    /**
     * 숫자에 comma를 붙인다.
     *
     * @param   str
     */
    function addCommaStr(str) {
        var rxSplit = new RegExp('([0-9])([0-9][0-9][0-9][,.])');
		if(!isNaN(str)){
			str = str+"";
		}
        var arrNumber = str.split('.');
        arrNumber[0] += '.';
        do {
            arrNumber[0] = arrNumber[0].replace(rxSplit, '$1,$2');
        } while (rxSplit.test(arrNumber[0]));

        if (arrNumber.length > 1) {
            replaceStr = arrNumber.join("");
        } else {
            replaceStr = arrNumber[0].split(".")[0];
        }
        return replaceStr+" ";
    }

    /**
     * 숫자에서 comma를 없앤다.
     *
     * @param   obj
     */
    function deleteComma(obj) {
        obj.value = deleteCommaStr(obj.value);
    }

    /**
     * 숫자에서 comma를 없앤다.
     */
    function deleteComma2() {
        var obj = window.event.srcElement;
        deleteComma(obj);
        obj.select();
    }

    /**
     * 숫자에서 comma를 없앤다.
     *
     * @param   str
     */
    function deleteCommaStr(str) {
        var temp = '';

        for (var i = 0; i < str.length; i++) {
            if (str.charAt(i) == ',') {
                continue;
            } else {
                temp += str.charAt(i);
            }
        }

        return  temp;
    }


    /**
     * 날짜에 "-"를 붙인다.
     *
     * @param   str
     */
    function addDateFormatStr(str) {
    		if (str == null || str == ""){
    			str = "";
    			return str;
    		}

        return  str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8);
    }


    /**
     * 시간에 ":"를 붙인다.
     *
     * @param   str
     */
    function addTimeFormatStr(str) {
    		if (str == null || str == ""){
    			str = "";
    			return str;
    		}

        return  str.substring(0, 2) + ":" + str.substring(2, 4) + ":" + str.substring(4, 6);
    }

    /**
     * 날짜(년월)에 "/"를 붙인다.
     *
     * @param   str
     */
    function addYmFormatStr(str) {
        return  str.substring(0, 4) + "/" + str.substring(4, 6);
    }

    /**
     * 날짜(년월)에 "/"를 붙인다.
     *
     * @param   str
     */
    function addYmFormatStr02(str) {
        return  str.substring(0, 4) + "-" + str.substring(4, 6);
    }

    /**
     * 날짜에서 "/"를 없앤다.
     *
     * @param   obj
     */
    function deleteDateFormat(obj) {
        obj.value = deleteDateFormatStr(obj.value);
    }

    /**
     * 날짜에서 "/"를 없앤다.
     */
    function deleteDateFormat2() {
        var obj = window.event.srcElement;
        deleteDateFormat(obj);
        obj.select();
    }

    /**
     * 날짜에서 "/"를 없앤다.
     *
     * @param   str
     */
    function deleteDateFormatStr(str) {
        var temp = '';

        for (var i = 0; i < str.length; i++) {
            if (str.charAt(i) == '/') {
                continue;
            } else {
                temp += str.charAt(i);
            }
        }

        return  temp;
    }
	/**
     * 날짜에서 "-"를 없앤다.
     *
     * @param   str
     */
	function deleteDateFormatStr1(str) {
        var temp = '';

        for (var i = 0; i < str.length; i++) {
            if (str.charAt(i) == '-') {
                continue;
            } else {
                temp += str.charAt(i);
            }
        }

        return  temp;
    }

    /**
     * 시간에서 ":"를 없앤다.
     *
     * @param   str
     */
	function deleteDateFormatTime(str) {
        var temp = '';

        for (var i = 0; i < str.length; i++) {
            if (str.charAt(i) == ':') {
                continue;
            } else {
                temp += str.charAt(i);
            }
        }

        return  temp;
    }

    /**
     * trim
     *
     * @param   text
     * @return  string
     */
    function trim(text) {
        if (text == "") {
            return  text;
        }

        var len = text.length;
        var st = 0;

        while ((st < len) && (text.charAt(st) <= ' ')) {
            st++;
        }

        while ((st < len) && (text.charAt(len - 1) <= ' ')) {
            len--;
        }

        return  ((st > 0) || (len < text.length)) ? text.substring(st, len) : text;
    }

    /**
     * ltrim
     *
     * @param   text
     * @return  string
     */
    function ltrim(text) {
        if (text == "") {
            return  text;
        }

        var len = text.length;
        var st = 0;

        while ((st < len) && (text.charAt(st) <= ' ')) {
            st++;
        }

        return  (st > 0) ? text.substring(st, len) : text;
    }

    /**
     * rtrim
     *
     * @param   text
     * @return  string
     */
    function rtrim(text) {
        if (text == "") {
            return  text;
        }

        var len = text.length;
        var st = 0;

        while ((st < len) && (text.charAt(len - 1) <= ' ')) {
            len--;
        }

        return  (len < text.length) ? text.substring(st, len) : text;
    }

    /**
     * 이벤트 핸들러를 등록한다.
     */
    function setEventHandler() {
        for (i = 0; i < document.forms.length; i++) {

            var elements = document.forms(i).elements;

            for (j = 0; j < elements.length; j++) {
                // INPUT 객체의 onblur 이벤트에 핸들러를 등록한다.
                if (elements(j).tagName == "INPUT") {

                    dataType = elements(j).getAttribute("dataType");

                    if (dataType == "date") {
                        elements(j).onblur = addDateFormat2;
                        elements(j).onfocus = deleteDateFormat2;
                        addDateFormat(elements(j));
                    } else if (dataType == "number" || dataType == "integer" || dataType == "float" || dataType == "double") {
                        if (elements(j).getAttribute("comma") != null) {
                            elements(j).onblur = addComma2;
                            elements(j).onfocus = deleteComma2;
                            addComma(elements(j));
                        }
                    } else if (dataType == "yyyymm") {
                        elements(j).onblur = addYmFormat2;
                        elements(j).onfocus = deleteDateFormat2;
                        addYmFormat(elements(j));
                    }
                }
            }
        }
    }

    /**
     * 자리수의 최소값, 최대값
     *
     * 최소값만 체크 : jsRange(2, -1)
     * 최대값만 체크 : jsRange(-1, 10)
     * 최소값, 최대값 모두 체크 : jsRange(2, 10)
     * 최소값, 최대값 둘다 체크 안함 : jsRange(-1, -1)
     *
     */
    function jsRange(minValue, maxValue)
    {
        jsMinLength(minValue);
        jsMaxLength(maxValue);
    }

     /**
     * 문자열의 byte length를 얻는다.
     *
     * @param   str 문자열
     * @return  byte length
     * @author  marie
     */
    function jsByteLength(str) {
        if (str == "") {
            return  0;
        }

        var len = 0;

        for (var i = 0; i < str.length; i++) {
            if (str.charCodeAt(i) > 128) {
                len++;
            }
            len++;
        }

        return  len;
    }

    /**
     * 최대값
     */
    function jsMaxLength(maxValue)
    {
        var obj         = window.event.srcElement;
        var dispName    = obj.getAttribute("dispName");
        //var maxValue    = obj.getAttribute("maxValue");
        var val         = jsByteLength(obj.value);
        if(maxValue != -1 && val > maxValue)
        {
            LLYNX_Alert(dispName +" 값이 최대값("+ maxValue +")을 초과합니다.\n초과 길이 :"+ (val - maxValue));
            //obj.value = "0";
            obj.focus();
            if(window.event)
            {
                window.event.returnValue = false;
            }
            return;
        }
    }

    /**
     * 최소값
     */
    function jsMinLength(minValue)
    {
        var obj         = window.event.srcElement;
        var dispName    = obj.getAttribute("dispName");
        //var minValue    = obj.getAttribute("minValue");
        var val         = jsByteLength(obj.value);
        if(minValue != -1 && val < minValue)
        {
            LLYNX_Alert(dispName +" 값이 최소값(" + minValue + ") 미만입니다.\n부족 길이 :"+ (minValue - val));
            //obj.value = "0";
            obj.focus();
            if(window.event)
            {
                window.event.returnValue = false;
            }
            return;
        }
    }

    /**
     * 숫자이면 숫자, 숫자가 아니면 0
     */
    function nvlNumber(val)
    {
        if(val == "" || isNaN(val) || val == "undefined")
            return 0;

        return Number(val);
    }

    /**
     * 숫자형식에서 comma를 없애고, 날짜형식에서 "/" 를 없앤다.
     *
     * @param   form
     */
    function makeValue(form) {
        for (i = 0; i < form.elements.length; i++) {
            obj = form.elements(i);

            if (obj.tagName == "INPUT") {
                dataType = obj.getAttribute("dataType");

                if (dataType == "date") {
                    deleteDateFormat(obj);
                } else if (dataType == "number" || dataType == "integer" || dataType == "float" || dataType == "double") {
                    if (obj.getAttribute("comma") != null) {
                        deleteComma(obj);
                    }
                } else if (dataType == "yyyymm") {
                    deleteDateFormat(obj);
                }
                /// notHyphen 이라고 선언했다면 하이픈을 모두 제거한다.
                if(obj.getAttribute("notHyphen") != null) {
                    deleteHyphenObj(obj);
                }
            }
        }
    }

    /**
      * 문자에서 Hyphen을 없앤다.
      *
      * @param  obj
      */
    function deleteHyphenObj(obj) {
        obj.value = deleteHyphen(obj.value);
    }

    /**
     * 데이터 유효성을 체크한다.
     *
     * @param   form
     */
    /*function validate1(form) {

        var obj;
        var dispName;
        var dataType;
        var minValue;
        var maxValue;
        var len;
        var lenCheck;
        var lenMCheck;
        var isValid;
        var value;
        var lenMinCheck;

        for (i = 0; i < form.elements.length; i++) {
            obj = form.elements[i];

        if(obj.name != ""){ //이름이 있는 경우만 체크함.(2004.10.26 suna)
                obj.value = trim(obj.value);

            dispName 		= obj.getAttribute("dispName");
            dataType 		= obj.getAttribute("dataType");
            minValue 		= obj.getAttribute("minValue");
            maxValue 		= obj.getAttribute("maxValue");
            len      		= obj.getAttribute("len");
            lenCheck 		= obj.getAttribute("lenCheck");
            lenMCheck 		= obj.getAttribute("lenMCheck");
            lenMinCheck		= obj.getAttribute("lenMinCheck");

            value = obj.value;

            if (dispName == null) {
                dispName = obj.name;
            }

            // 필수 입력 항목 체크
            if (obj.getAttribute("notNull") != null) {
                isValid = false;

                if (obj.type == "radio" || obj.type == "checkbox") {
                    if (form.elements(obj.name).length) {
                        for (j = 0; j < form.elements(obj.name).length; j++) {
                            if (form.elements(obj.name)[j].checked) {
                                isValid = true;
                                break;
                            }
                        }
                    } else {
                        if (obj.checked) {
                            isValid = true;
                        }
                    }
                } else {
                    if (value != "") {
                        isValid = true;
                    } else {
                        if (obj.getAttribute("comma") != null) {
                            obj.value = 0;
                            isValid = true;
                        }
                    }
                }

                if (!isValid) {
                    LLYNX_Alert(dispName + "을(를) 입력하십시오.");
                    obj.focus();
                    if (window.event) {
                        window.event.returnValue = false;
                    }
                    return  false;
                }
            }




            // 데이터 길이 체크
            if (len != null) {
                if (value.length != eval(len)) {
                    LLYNX_Alert(dispName + "은(는) " + len + "자리를 입력해야 합니다.");
                    obj.focus();
                    if (window.event) {
                        window.event.returnValue = false;
                    }
                    return  false;
                }
            }

           if(lenCheck != null )
            {

              if( jsByteLength(value) > eval(lenCheck) )
                {
                  LLYNX_Alert(dispName + "은(는) " + lenCheck + " 자리를 넘을수 없습니다 현재 글자수("+jsByteLength(value)+")");
                  obj.value = value;
                  obj.focus();
                  if(window.event)
                    {
                       window.event.returnValue = false;
                    }

                    return false;
                }

            }



            // 입력자리수 체크(2004.07.21 추가     작성자 : 박광진)
            // 입력값이 없는 경우는 체크하지 않토록 수정(2007.02.09 박상철)
            if(lenMCheck != null) {
                if(value.length > 0 && value.length < eval(lenMCheck)) {
                    LLYNX_Alert(dispName + "은(는) " + lenMCheck + " 자리수을 입력하셔야 합니다.");
                    obj.focus();
                    if(window.event)
                        window.event.returnValue = false;

                    return false;
                }
            }

                        // 최소 입력자리수 체크(2004.07.21 추가     작성자 : 박광진)
            // 입력값이 없는 경우는 체크하지 않토록 수정(2007.02.09 박상철)
            if(lenMinCheck != null) {
                if(value.length > 0 && value.length < eval(lenMinCheck)) {
                    LLYNX_Alert(dispName + "은(는) " + lenMinCheck + " 자리수 이상 입력하셔야 합니다.");
                    obj.focus();
                    if(window.event)
                        window.event.returnValue = false;

                    return false;
                }
            }

            if (obj.type == "text") {
                // 데이터 타입 체크
                if (dataType == null) { // 2002.01.30 추가

                } else if ((value != "") && (dataType != null)) {
                    isValid = true;
                    checkValue = false;

                    if (dataType == "date") {
                        value = deleteDateFormatStr(value);
                        isValid = isDate(value);
                        checkValue = true;
                    } else if (dataType == "yyyymm") {
                        value = deleteDateFormatStr(value);
                        isValid = isYyyyMm(value);
                        checkValue = true;
                    } else if (dataType == "email") {
                        isValid = isEmail(value);
                    } else if (dataType == "float") {
                        value = deleteCommaStr(value);
                        isValid = isFloat(value);
                        checkValue = true;
                    } else if (dataType == "integer") {
                        value = deleteCommaStr(value);
                        isValid = isInteger(value);
                        checkValue = true;
                    } else if (dataType == "number") {
                        value = deleteCommaStr(value);
                        isValid = isNumber(value);
                        checkValue = true;
                    } else if (dataType == "double") {
                        value = deleteCommaStr(value);
                        isValid = isNumber(value);
                        checkValue = true;
                    }

                    if (!isValid) {
                        LLYNX_Alert(dispName + " 형식이 올바르지 않습니다.");
                        if (dataType == "float" || dataType == "integer" || dataType == "number" || dataType == "double") {
                            obj.value = "0";
                        }
                        obj.focus();
                        if (window.event) {
                            window.event.returnValue = false;
                        }
                        return  false;
                    }

                    if (checkValue) {
                        if (minValue != null) {
                            if (eval(minValue) > eval(value)) {
                                LLYNX_Alert(dispName + " 값은 최소값(" + minValue + ") 이상입니다.");
                                obj.focus();
                                if (window.event) {
                                    window.event.returnValue = false;
                                }
                                return  false;
                            }
                        }

                        if (isValid && (maxValue != null)) {
                            if (eval(maxValue) < eval(value)) {
                                LLYNX_Alert(dispName + " 값이 최대값(" + maxValue + ")을 초과합니다.");
                                obj.focus();
                                if (window.event) {
                                    window.event.returnValue = false;
                                }
                                return  false;
                            }
                        }
                    }
                }
            }
         }
      }
        return  true;
    }*/

    /**
     * 숫자형식에서 comma를 없애고, 날짜형식에서 "/" 를 없앤다.
     * 하나의 오브젝트에 대한 것임.
     *
     * @param   form
     * @param   obj
     */
    function makeValueObj(form, obj) {
        if (obj.tagName == "INPUT") {
            dataType = obj.getAttribute("dataType");

            if (dataType == "date") {
                deleteDateFormat(obj);
            } else if (dataType == "number" || dataType == "integer" || dataType == "float" || dataType == "double") {
                if (obj.getAttribute("comma") != null) {
                    deleteComma(obj);
                }
            }
        }
    }

     /**
      * 문자에서 Hyphen을 없앤다.
      *
      * @param   str
      */
    function deleteHyphen(str) {
        var temp = '';

        for (var i = 0; i < str.length; i++) {
            if (str.charAt(i) == '-') {
                continue;
            } else {
                temp += str.charAt(i);
            }
        }

        return  temp;
    }

    /**
     * 주민등록번호&사업자번호에 '-'넣기
     */
     function setJuminHyphen(obj) {
        var str = deleteHyphen(obj.value);

        if(str.length == 13) {  // 주민등록번호  6-7
            str = str.substring(0, 6) + "-" + str.substring(6);
        }else if(str.length == 10) { // 사업자번호 3-2-5
            str = str.substring(0, 3) + "-"+ str.substring(3, 5) + "-"+ str.substring(5);
        }
        obj.value = str;
     }


     /**
      * 주민등록번호 마스킹처리
      */
      function setJuminMaskIng(obj) {
         var str = deleteHyphen(obj);
         if(str.length == 7) { // 사업자번호 3-2-5
        	 str = str.substring(0, 6) + "-" + str.substring(6) + "******";
         } else if ( str.length === 13 ) {
        	 str = str.substring(0, 6) + "-" + str.substring(6, 7) + "******";
         }
         return str;
      }


    /**
     * 법인번호 에 '-'넣기
     */
    function setPupinHyphen(obj) {
        var str = deleteHyphen(obj.value);

        if(str.length == 13) {  // 주민등록번호  6-7
            str = str.substring(0, 6) + "-" + str.substring(6);
        }
        obj.value = str;
    }

    /**
     * 납입주기에 따른 이율을 계산한다.
     * (소수로 반환한다.)
     *
     * @param   currencyCd 통화
     * @param   yRate 년이율
     * @param   term 납입주기
     * @return  소수 이율
     */
 /*   function jsRateCalc(currencyCd, yRate, term) {

        var yday = jsYdayCalc(currencyCd);
        var rate = eval((yRate / 100) * (term / 12) * (365 / yday));

        return  rate;
    }*/

    /**
     * 금액을 단수 처리한다.
     *
     * 원화(WON)
     *
     *  단수단위
     *      0 - 원미만
     *      1 - 십원미만
     *      2 - 백원미만
     *      3 - 천원미만
     *      4 - 만원미만
     *
     *  단수처리
     *      1 - 반올림
     *      2 - 절상
     *      3 - 절사
     *
     * 외화
     *
     *  단수단위
     *      0 - 소수점 0 미만
     *      1 - 소수점 1 미만
     *      2 - 소수점 2 미만
     *
     *  단수처리
     *      1 - 반올림
     *      2 - 절상
     *      3 - 절사
     * @param   currency 통화 (text)
     * @param   amt 금액 (text)
     * @param   unit 단수단위 (text)
     * @param   method 단수처리 (text)
     */
/*    function jsTruncAmt(currency, amt, unit, method) {

        var after = eval(amt);

        if (currency == "WON") {

            after /= Math.pow(10, eval(unit));

            if (method == "1") {
                after = Math.round(after);
            } else if (method == "2") {
                after = Math.ceil(after);
            } else if (method == "3") {
                after = Math.floor(after);
            }

            after *= Math.pow(10, eval(unit));
        } else {
            after *= Math.pow(10, eval(unit));

            if (method == "1") {
                after = Math.round(after);
            } else if (method == "2") {
                after = Math.ceil(after);
            } else if (method == "3") {
                after = Math.floor(after);
            }

            after /= Math.pow(10, eval(unit));
        }

        return  after;
    }*/

    /**
     * String이 null인 경우 '0'으로 바꾸어 준다.
     *
     * @param   string
     * @return  String
     */
    function jsNumnvl(str) {
        if(str == null || str == "") {
            return "0";
        }
        return  str;
    }

	/**
     * String이 null인 경우 ''으로 바꾸어 준다.
     *
     * @param   string
     * @return  String
     */
    function jsstr(str) {
        if(str == null || str == "") {
            return "";
        }
        return  str;
    }

    function jsNvl(str) {
        if(str == null) {
            return "";
        }
        return  str;
    }

    /**
     * 폼 안의 숫자 오브젝트에 콤마를 붙여준다.
     */
    function setComma() {

        for (i = 0; i < document.forms.length; i++) {
            var elements = document.forms(i).elements;
            for (j = 0; j < elements.length; j++) {
                if (elements(j).tagName == "INPUT") {
                    dataType = elements(j).getAttribute("dataType");
                    if (dataType == "number" || dataType == "integer" ||
                    dataType == "float" || dataType == "double") {
                        if (elements(j).getAttribute("comma") != null) {
                            addComma(elements(j));
                        }
                    }
                }
            }
        }
    }

    /**
     * 일수를 계산한다.(초일산입 말일불산입)
     *
     * @param   from 시작일
     * @param   to 종료일
     * @return  일수
     */
  /*  function jsGetDays(from, to) {

        var fromDt = deleteDateFormatStr(from);
        var toDt = deleteDateFormatStr(to);
        var days = 0 ;

        var fromYy = eval(fromDt.substring(0,4));
        var fromMm = eval(fromDt.substring(4,6) - 1);
        var fromDd = eval(fromDt.substring(6,8));

        var toYy = eval(toDt.substring(0,4));
        var toMm = eval(toDt.substring(4,6) - 1);
        var toDd = eval(toDt.substring(6,8));

        var fromDate = new Date(fromYy, fromMm, fromDd) ;
        var toDate = new Date(toYy, toMm, toDd) ;

        days = ((toDate - fromDate) / 60 / 60 / 24 / 1000);

        return  days;
    }*/

    /**
     * 비밀번호 체크
     */
    function passChk(p_id, p_pass, obj) {

        var cnt = 0;
        var cnt2 = 1;
        var cnt3 = 1;
        var temp = "";

        /* 비밀번호에에 숫자만 입력되는것을 체크 - 이혁*/
        regNum = /^[0-9]+$/gi;
        bNum = regNum.test(p_pass);
        if(bNum) {
            LLYNX_Alert('비밀번호는 숫자만으로 구성하실수는 없습니다.');
               obj.focus();
            return false;
        }
        /* 비밀번호에에 문자만 입력되는것을 체크 - 이혁*/
        regNum = /^[a-zA-Z]+$/gi;
        bNum = regNum.test(p_pass);
        if(bNum) {
            LLYNX_Alert('비밀번호는 문자만으로 구성하실수는 없습니다.');
               obj.focus();
            return false;
        }

        for(var i = 0; i < p_id.length; i++) {
            temp_id = p_id.charAt(i);

            for(var j = 0; j < p_pass.length; j++) {
                if (cnt > 0) {
                    j = tmp_pass_no + 1;
                }

                if (temp == "r") {
                    j=0;
                    temp="";
                }

                temp_pass = p_pass.charAt(j);

                if (temp_id == temp_pass){
                    cnt = cnt + 1;
                    tmp_pass_no = j;
                    break;
                } else if (cnt > 0 && j > 0){
                    temp="r";
                    cnt = 0;
                } else {
                    cnt = 0;
                }
            }

            if (cnt > 3) {
                break;
            }
        }

        if (cnt > 3){
            LLYNX_Alert("비밀번호가 ID와 4자 이상 중복되거나, \n연속된 글자나 순차적인 숫자를 4개이상 사용해서는 안됩니다.");
            obj.focus();
            return  false;
        }

        for(var i = 0; i < p_pass.length; i++) {
            temp_pass1 = p_pass.charAt(i);
            next_pass = (parseInt(temp_pass1.charCodeAt(0)))+1;
            temp_p = p_pass.charAt(i+1);
            temp_pass2 = (parseInt(temp_p.charCodeAt(0)));

            if (temp_pass2 == next_pass) {
                cnt2 = cnt2 + 1;
            } else {
                cnt2 = 1;
            }

            if (temp_pass1 == temp_p) {
                cnt3 = cnt3 + 1;
            } else {
                cnt3 = 1;
            }

            if (cnt2 > 3) {
                break;
            }

            if (cnt3 > 3) {
                break;
            }
        }

        if (cnt2 > 3){
            LLYNX_Alert("비밀번호에 연속된 글이나 순차적인 숫자를 4개이상 사용해서는 안됩니다.");
            obj.focus();
            return  false;
        }

        if (cnt3 > 3){
            LLYNX_Alert("비밀번호에 반복된 문자/숫자를 4개이상 사용해서는 안됩니다.");
            obj.focus();
            return  false;
        }

        return true;
    }

    /**
     * 브라우저의 버전을 체크한다.
     *
     * @param   none
     * @return  none
     */
    function objDetectBrowser() {
        var strUA, s, i;
        this.isIE = false;  // 인터넷 익스플로러인지를 나타내는 속성
        this.isNS = false;  // 넷스케이프인지를 나타내는 속성
        this.version = null; // 브라우저 버전을 나타내는 속성

        // Agent 정보를 담고 있는 문자열.
        strUA = navigator.userAgent;

        s = "MSIE";
        // Agent 문자열(strUA) "MSIE"란 문자열이 들어 있는지 체크

        if ((i = strUA.indexOf(s)) >= 0) {
            this.isIE = true;
            // 변수 i에는 strUA 문자열 중 MSIE가 시작된 위치 값이 들어있고,
            // s.length는 MSIE의 길이 즉, 4가 들어 있다.
            // strUA.substr(i + s.length)를 하면 strUA 문자열 중 MSIE 다음에
            // 나오는 문자열을 잘라온다.
            // 그 문자열을 parseFloat()로 변환하면 버전을 알아낼 수 있다.
            this.version = parseFloat(strUA.substr(i + s.length));
            return;
        }

        s = "Netscape6/";
        // Agent 문자열(strUA) "Netscape6/"이란 문자열이 들어 있는지 체크

        if ((i = strUA.indexOf(s)) >= 0) {
            this.isNS = true;
            this.version = parseFloat(strUA.substr(i + s.length));
            return;
        }

        // 다른 "Gecko" 브라우저는 NS 6.1로 취급.

        s = "Gecko";
        if ((i = strUA.indexOf(s)) >= 0) {
            this.isNS = true;
            this.version = 6.1;
            return;
        }
    }

  /**
   * 화면 크기를 1024*768로 고정 시킨다.
   */
  function fixScreen(){
    if ((screen.availWidth >= 1024) & (screen.availHeight >= 768)){
      availX = 1024;
      availY = 768;
      screenX = screen.availWidth;
      screenY = screen.availHeight;
      windowX = (screenX - availX)/2;
      windowY = (screenY - availY)/2;
    }
    else {
      //availX = 1024;
      //availY = 768;
      availX = screen.availWidth;
      availY = screen.availHeight;
      windowX = 0;
      windowY = 0;
    }
    moveTo(windowX,windowY);
    resizeTo(availX, availY);
  }

    /**
     * sub 화면을 가운데에 위치 시킨다.
     * centerSubWindow(winName, wx, wy)
     * winName : 서브윈도우의 이름
     * ww : 서브윈도우로 열 창의 너비
     * wh : 서브윈도우로 열 창의 높이
     */
    function centerSubWindow(winName, ww, wh){
        if (document.layers) {
            sw = screen.availWidth;
            sh = screen.availHeight;
        }
        if (document.all) {
            sw = screen.width;
            sh = screen.height;
        }

        w = (sw - ww)/2;
        h = (sh - wh)/2;
        winName.moveTo(w,h);
    }

    /**
     * 문자열에서 삭제를 원하는 문자를 삭제한다.
     *
     * @param   val 문자열
     * @param   str 삭제할 문자
     */
    function jsTrim(val, str) {
        var temp  = val.value;
        temp = temp.split(str);

        val.value = temp.join("");
    }

    /**
     * 폼 전체를 읽기전용으로 만든다.
     *
     * @param    form명
     */
    function setAllDisabled(tform) {
        var len = tform.elements.length;
        LLYNX_Alert("len ::"+ len);
        for(i=0; i<len; i++) {
            if(tform.elements[i].type == "text" || tform.elements[i].type == "select-one"
               || tform.elements[i].type == "textarea" || tform.elements[i].type == "file"
               || tform.elements[i].type == "radio" || tform.elements[i].type == "checkbox") {
                 tform.elements[i].disabled = true;
            }
        }
    }

    /**
     * 폼 전체를 읽기전용을 정상으로 돌려 놓는다.
     *
     * @param    form명
     */
    function setAllEnabled(tform) {
        var len = tform.elements.length;
        for(i=0; i<len; i++) {
            if(tform.elements[i].type == "text" || tform.elements[i].type == "select-one"
               || tform.elements[i].type == "textarea" || tform.elements[i].type == "file"
               || tform.elements[i].type == "radio" || tform.elements[i].type == "checkbox") {
                 tform.elements[i].disabled = false;
            }
        }
    }

    /**
     * tokenCommaPatt
     *
     * @param    val
     * @param    patt
     * @ String val을 String patt로 구분하여배열로 리턴한다.
     * example
     *  var TestArray = tokenCommaPatt( "abcd efgh ijkl", " ")
     *  TestArray[0] = "abcd";
     *  TestArray[1] = "efgh";
     *  TestArray[2] = "ijkl";
     */
    function tokenCommaPatt(val, patt){
        var i = 0, iFst = 0;
        var sCheckValue = val;
        var arrRst = new Array();
        while( ( iFst = sCheckValue.indexOf( patt ) ) >= 0 ) {
            arrRst[i++] = sCheckValue.substring( 0 , iFst );
            sCheckValue = sCheckValue.substring( iFst + patt.length ,  sCheckValue.length );
            }
        arrRst[i] = sCheckValue;
        return arrRst;
    }

     /**
     * 숫자로만 이루어져 있는지 체크 한다.
     *
     * @param    num
     * @return   boolean
     */
    function isNumber3(num){
        var inText = num;
        var ret;

        for (var i = 0; i < inText.length; i++) {
            ret = inText.charCodeAt(i);
            if (!((ret > 47) && (ret < 58)))  {
                LLYNX_Alert("숫자만 입력 가능합니다.");
                num.value = "";
                num.focus();
                return false;
            }
        }
        return true;
    }

    /**
     * 숫자로만 이루어져 있는지 체크 한다.
     *
     * @param    num
     * @return   boolean
     */
    function isNumber(num){
        var inText = num;
        var ret;

        if(num == "") {
        	return false;
        }

        for (var i = 0; i < inText.length; i++) {
            ret = inText.charCodeAt(i);
            if (!((ret > 47) && (ret < 58)))  {
                LLYNX_Alert("숫자만 입력 가능합니다.");
                num.value = "";
                num.focus();
                return false;
            }
        }
        return true;
    }



    /**
     * 숫자로만 이루어져 있는지 체크 한다.
     *
     * @param    num
     * @return   boolean
     */
    function isNumber2(num){
        var inText = num.value;
        var ret;

        for (var i = 0; i < inText.length; i++) {
            ret = inText.charCodeAt(i);
            if (!((ret > 47) && (ret < 58)))  {
                LLYNX_Alert("숫자만 입력 가능합니다.");
                num.value = "";
                num.focus();
                return false;
            }
        }
        return true;
    }

    /**
     * 한글로만 이루어져 있는지 체크 한다.
     *
     * @param    han
     * @return   boolean
     */
    function isHangul(han) {
        var inText = han.value;
        var ret;

        ret = inText.charCodeAt();
        if (ret > 31 && ret < 127) {
            LLYNX_Alert("한글만 입력 가능합니다.");
            han.value = "";
            han.focus();
            return false;
        }

        return true;
    }

   /**
    * 영문캐릭터인지 체크(대문자)
    *
    * param obj
    * return
    */
    function checkChar(obj)
    {
        var strValue = obj.value

        var retChar = strValue.toUpperCase();

        if (retChar <  "A" || retChar  > "Z")
        {
            LLYNX_Alert("영문자만 입력이 가능합니다.");
            obj.value = "";
            obj.focus();
            return;
        }
        obj.value = retChar;
    }

    /**
     * 키보드 입력시 숫자만 입력 가능
     */
    function onlyNumber(){
        if ((event.keyCode >= 32 && event.keyCode < 48)
            || (event.keyCode > 57 && event.keyCode < 65)
            || (event.keyCode > 90 && event.keyCode < 97)
            || (event.keyCode >= 97 && event.keyCode <= 122)
            || (event.keyCode >= 65 && event.keyCode <= 90))
            event.returnValue = false;
    }

    /**
     * 키보드 입력시 수자 및 ','가 입력 가능
     */
    function AmtNumber(){
        if ((event.keyCode >= 32 && event.keyCode < 44)
            || (event.keyCode >= 45 && event.keyCode < 48)
            || (event.keyCode > 57 && event.keyCode < 65)
            || (event.keyCode > 90 && event.keyCode < 97)
            || (event.keyCode >= 97 && event.keyCode <= 122)
            || (event.keyCode >= 65 && event.keyCode <= 90))
            event.returnValue = false;
    }

    /**
     * 키보드 입력시 수자 및 '.'가 입력 가능
     */
    function RateNumber(){
        if ((event.keyCode >= 32 && event.keyCode < 46)
            || (event.keyCode >= 47 && event.keyCode < 48)
            || (event.keyCode > 57 && event.keyCode < 65)
            || (event.keyCode > 90 && event.keyCode < 97)
            || (event.keyCode >= 97 && event.keyCode <= 122)
            || (event.keyCode >= 65 && event.keyCode <= 90))
            event.returnValue = false;
    }

    /**
     * 숫자형식에 null이 입력되면 0으로 셋팅한다.
     *
     * @param   form
     */
    function setZero(form) {
        for (i = 0; i < form.elements.length; i++) {
            obj = form.elements(i);

            if (obj.tagName == "INPUT") {
                dataType = obj.getAttribute("dataType");

                if (dataType == "number" || dataType == "integer" || dataType == "float" || dataType == "double") {
                    if (obj.value == null || obj.value == "") {
                        obj.value = "0";
                    }
                }
            }
        }
    }

    /* 날짜관련 *******************************************************************************/
    var dateBase  = new Date();

    /**
     * 년
     */
    function getYear()
    {
        return dateBase.getFullYear();
    }

    /**
     * 월
     */
    function getMonth()
    {
        var month = dateBase.getMonth()+1;
        if (("" + month).length == 1)
            month = "0" + month;
        return month;
    }

    /**
     * 일
     */
    function getDay()
    {
        var day = dateBase.getDate();
        if(("" + day).length == 1)
            day   = "0" + day;
        return day;
    }

    /**
     * 현재일부터 특정일자 이전(0), 이후(1)의 날짜를 리턴한다.(YYYYMMDD)
     */
    function getIntervalDate(term, isPrevNext)
    {
        var year2, month2, day2;
        var dt = new Date(getMonth() +"-"+ getDay() +"-"+ getYear());
        var anyTime;
        var anyDate;
        if(isPrevNext == "0") /// 이전
            anyTime = dt.getTime() - (term) * 1000 * 3600 * 24;
        else /// 이후
            anyTime = dt.getTime() + (term) * 1000 * 3600 * 24;
        anyDate = new Date();
        anyDate.setTime(anyTime);
        year2 = ( (anyDate.getYear()<100) ? "19"+ anyDate.getYear() : anyDate.getYear() );
        month2 = anyDate.getMonth()+1;
        day2 = anyDate.getDate();
        if (("" + month2).length == 1)
            month2 = "0" + month2;
        if(("" + day2).length == 1)
            day2   = "0" + day2;
        //LLYNX_Alert("["+ year2 +"/"+ month2 +"/"+ day2 +"]");

        return year2 +""+ month2 +""+ day2;
    }

    /**
     * 기준일부터 특정일자 이전(0), 이후(1)의 날짜를 리턴한다.(YYYYMMDD)
     */
    function getIntervalDate2(kijunDate, term, isPrevNext)
    {
        var year2, month2, day2;
        var dt = toTimeObject(deleteDateFormatStr(kijunDate) +"0000");
        var anyTime;
        var anyDate;
        if(isPrevNext == "0") /// 이전
            anyTime = dt.getTime() - (term) * 1000 * 3600 * 24;
        else /// 이후
            anyTime = dt.getTime() + (term) * 1000 * 3600 * 24;
        anyDate = new Date();
        anyDate.setTime(anyTime);
        year2 = ( (anyDate.getYear()<100) ? "19"+ anyDate.getYear() : anyDate.getYear() );
        month2 = anyDate.getMonth()+1;
        day2 = anyDate.getDate();
        if (("" + month2).length == 1)
            month2 = "0" + month2;
        if(("" + day2).length == 1)
            day2   = "0" + day2;
        //LLYNX_Alert("["+ year2 +"/"+ month2 +"/"+ day2 +"]");

        return year2 +""+ month2 +""+ day2;
    }

    /**
     * 기준일부터 특정일자 이전(0), 이후(1)의 개월수 만큼 차이나는 날짜를 리턴한다.(YYYYMMDD)
     */
/*    function getIntervalMonth(kijunDate, term, isPrevNext)
    {
        var kijunDate   = deleteDateFormatStr(kijunDate);
        var year        = kijunDate.substring(0,4); /// 년
        var month       = kijunDate.substring(4,6); /// 월
        var date        = kijunDate.substring(6,8); /// 일
        var addMonth;
        var addYear;
        var tempYear;
        var tempMonth;
        var rtnDate;

        if(isPrevNext == "0") /// 이전
        {
            addMonth    = eval(month) - eval(term);
            addYear     = Math.floor(eval(addMonth/12)); /// 빼줄 년도 계산
            tempYear    = eval(addYear) + eval(addMonth%12);
            if(tempYear > 0)
            {
                tempMonth   = eval(tempYear%13);
            }
            else
            {
                tempMonth   = eval(12 + addMonth%12);
                if(tempYear == 0)
                    addYear     = addYear-1;
            }
        }
        else /// 이후
        {
            addMonth    = eval(month) + eval(term);
            addYear     = Math.floor(eval(addMonth/13)); /// 더해줄 년도 계산
            tempYear    = eval(addYear) + eval(addMonth%13);

            if(tempYear < 13)
            {
                tempMonth   = eval(tempYear%13);
            }
            else
            {
                tempMonth   = eval(tempYear%13 +1);
                addYear     = addYear+1;
            }
        }

        tempMonth   = tempMonth + ""; /// 길이를 알아보기위해 string으로 바꿔줌.
        if(tempMonth.length == 1)
        {
            tempMonth = "0" + tempMonth;
        }
        /// 해당월에 해당일이 존재하는지 체크하고 존재하지 않는다면 마지막 일을 가져온다.
        if( !isValidDay(eval(year) + eval(addYear), tempMonth, date))
            date = getLastDay(eval(year) + eval(addYear), tempMonth);

        rtnDate = eval(year) + eval(addYear) +""+ tempMonth +""+ date;
        //LLYNX_Alert(">날짜 ::"+ rtnDate);

        return rtnDate;
    }*/

    /**
     * Time 스트링을 자바스크립트 Date 객체로 변환
     *
     * parameter time: Time 형식의 String
     */
    function toTimeObject(time)
    { //parseTime(time)
        var year  = time.substr(0,4);
        var month = time.substr(4,2) - 1; // 1월=0,12월=11
        var day   = time.substr(6,2);
        var hour  = time.substr(8,2);
        var min   = time.substr(10,2);

        return new Date(year,month,day,hour,min);
    }

    /**
     * 자바스크립트 Date 객체를 Time 스트링으로 변환
     *
     * parameter date: JavaScript Date Object
     */
    function toTimeString(date)
    { //formatTime(date)
        var year  = date.getFullYear();
        var month = date.getMonth() + 1; // 1월=0,12월=11이므로 1 더함
        var day   = date.getDate();
        var hour  = date.getHours();
        var min   = date.getMinutes();

        if(("" + month).length == 1) { month = "0" + month; }
        if(("" + day).length   == 1) { day   = "0" + day;   }
        if(("" + hour).length  == 1) { hour  = "0" + hour;  }
        if(("" + min).length   == 1) { min   = "0" + min;   }

        return ("" + year + month + day + hour + min);
    }

    /**
     * 유효한(존재하는) 월(月)인지 체크
     */
    function isValidMonth(mm)
    {
        var m = parseInt(mm,10);
        return (m >= 1 && m <= 12);
    }

    /**
     * 유효한(존재하는) 일(日)인지 체크
     */
    function isValidDay(yyyy, mm, dd)
    {
        var m = parseInt(mm,10) - 1;
        var d = parseInt(dd,10);

        var end = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
        if ((yyyy % 4 == 0 && yyyy % 100 != 0) || yyyy % 400 == 0) {
            end[1] = 29;
        }

        return (d >= 1 && d <= end[m]);
    }

    /**
     * 해당 월의 마지막 일을 가져온다.
     */
    function getLastDay(yyyy, mm)
    {
        var m = parseInt(mm,10) - 1;
        var d;

        var end = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
        if ((yyyy % 4 == 0 && yyyy % 100 != 0) || yyyy % 400 == 0) {
            end[1] = 29;
        }
        for(var i=0; i<end.length; i++)
        {
            if(m == i)
                d = end[i];
        }
        //LLYNX_Alert("d ::"+ d);

        return d;
    }

    /**
     * 유효한(존재하는) 시(時)인지 체크
     */
    function isValidHour(hh)
    {
        var h = parseInt(hh,10);
        return (h >= 1 && h <= 24);
    }

    /**
     * 유효한(존재하는) 분(分)인지 체크
     */
    function isValidMin(mi)
    {
        var m = parseInt(mi,10);
        return (m >= 1 && m <= 60);
    }

    /**
     * 현재날짜를 리턴한다.
     *
     */
    function getCurDate()
    {
        var date  = new Date();
        var year  = date.getFullYear();
        var month = date.getMonth() + 1; // 1월=0,12월=11이므로 1 더함
        var day   = date.getDate();
        var hour  = date.getHours();
        var min   = date.getMinutes();

        if (("" + month).length == 1) { month = "0" + month; }
        if (("" + day).length   == 1) { day   = "0" + day;   }
        if (("" + hour).length  == 1) { hour  = "0" + hour;  }
        if (("" + min).length   == 1) { min   = "0" + min;   }

        return ("" + year + month + day)
    }

    function getReckey(extNo) {
    	var c = new Date();
        return c.getFullYear() +(c.getMonth()+1).fill(2)
               +c.getDate().fill(2) +c.getHours().fill(2)
               +c.getMinutes().fill(2) +c.getSeconds().fill(2)
               +c.getMilliseconds() + "-" + extNo;
    }

    function getCallDateTimeStr() {
        var c = new Date();
        return c.getFullYear() +(c.getMonth()+1).fill(2) +c.getDate().fill(2) +c.getHours().fill(2) +c.getMinutes().fill(2) +c.getSeconds().fill(2);
    }
    String.prototype.string = function(len){var s="",i=0; while(i++<len){s +=this;} return s;}
    String.prototype.fill = function(len){return "0".string(len-this.length)+this;}
    Number.prototype.fill = function(len){return this.toString().fill(len);}


    /* 날짜관련 *******************************************************************************/

    /**
     * 날짜를 체크하여 금월을 return
     *
     * @param       날짜
     */
    function jsThisMonth(nowDate) {
        var form = document.form1;

        var nowYear = nowDate.substring(0, 4);
        var nowMonth = nowDate.substring(4, 6);
        var nowDay = nowDate.substring(6, 8);
        var newDay = "";

        for(var i=28; i<=31; i++) {
            if (isDate(nowYear + nowMonth + i)) {
                newDay = i + "";
            }
        }

        form.fromDate.value = addDateFormatStr(nowYear + nowMonth + "01");
        form.toDate.value = addDateFormatStr(nowYear + nowMonth + newDay);
    }

    /**
     * 날짜를 체크하여 금주를 return
     *
     * @param       날짜
     */
    function jsThisWeek(nowDate) {
        var form = document.form1;

        var dateWeek = getDateWeek(nowDate);
        var monday = Number(nowDate) - dateWeek + 1;
        var sunday = monday + 6 ;

        form.fromDate.value = addDateFormatStr(monday + "");
        form.toDate.value = addDateFormatStr(sunday + "");
    }

    /**
     * 날짜를 체크하여 금일를 return
     *
     * @param       날짜
     */
    function jsThisDay(nowDate) {
        var form = document.form1;

        form.fromDate.value = addDateFormatStr(nowDate);
        form.toDate.value = addDateFormatStr(nowDate);
    }

    /**
     * 지정한 날짜의 요일(1 -> 월, ~ 7 -> 일)
     *
     * @param       날짜
     */
    function getDateWeek(val){
        var day;
        var d = new Date();

        d.setUTCFullYear(Number(val.substring(0, 4)));
        d.setUTCMonth(Number(val.substring(4, 6)) - 1);
        d.setUTCDate(Number(val.substring(6, 8)));

        day = d.getDay();

        return day;
    }

    /**
     * 엔터키 누르면 자동으로 다음 필드로 이동
     */
    function enterNextField(field, event)
    {
        var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

        if(keyCode == 13)
        {
            var i;
            for(i = 0; i<field.form.elements.length; i++)
            {
                if(field == field.form.elements[i])
                    break;
            }

            i = (i + 1) % field.form.elements.length;
            field.form.elements[i].focus();
            return false;
        }
        else
            return true;
    }

    /**
     * 화면의 첫번째 TextField에 포커스 이동
     */
    function firstTextFocus()
    {
        var elements;
        var obj;

        for(var j=0; j<document.forms.length; j++)
        {
            elements = document.forms(j).elements;

            for(var i=0; i<elements.length; i++)
            {
                obj = elements(i);

                if(obj.tagName == "INPUT")
                {
                    if(obj.type == "text" && obj.disabled == false)
                    {
                        obj.focus();
                        return;
                    }
                }
            }
        }
    }

    /**
     * FM## - getFM(12, 4) -> 0012로 변경한다.
     * @param       val 원본 값
     * @param       len 사이즈 (0을 채울 갯수)
     */
    function getFM(val, len)
    {
        if(val == "")
            return val;
        var str     = "";
        var zero    = "";
        var valLen  = new String(val).length;
        var forLen  = len-valLen;
        if(len <= valLen)
            return val;
        for(var i=0; i<(forLen); i++)
        {
            zero    += "0";
        }
        str = zero+val;

        return str;
    }


    //--	값을 입력여부 확인
function isEmpty(data) {
	for (var i = 0; i < data.length; i++) {
		if (data.substring(i, i+1) != " ") {
			return false;
		}
	}
	return true;
}

//--	번호를 제대로 입력하였는지 확인
function Check_Num1(num) {
	for (var i = 0 ; i < num.length ; i++) {
		if ((num.charAt(i) < '0') || (num.charAt(i) > '9')) {
			return false;
		}
	}
	return true;
}
//--	번호를 제대로 입력하였는지 확인(몇개 특수문자포함)
function Check_Num2(num) {
	for (var i = 0 ; i < num.length ; i++) {
		if ((num.charAt(i) >= '0') && (num.charAt(i) <= '9')
			|| (num.charAt(i) == '-') || (num.charAt(i) == '(')
			|| (num.charAt(i) == ')'))
			continue;
		else
			return false;
	}
	return true;
}
//--	번호를 제대로 입력하였는지 확인(소수점포함)
function Check_Num3(num) {
	if (num == '') {
		num		=	'0';
	}
	var var_1	=	0;


	for (var i = 0 ; i < num.length ; i++) {
		if ((num.charAt(i) >= '0' && num.charAt(i) <= '9') || (num.charAt(i) == '.')) {
			if (num.charAt(i) == '.') {
				var_1	=	var_1 + 1;
			}
		//	continue;
		}
		else {
			return false;
		}
	}
	//--	소숫점갯수, 소숫점이하 자리수,
	if (var_1 > 1) {
		return false;
	}

	return true;
}

//--	숫자를 제대로 입력하였는지 확인
function num_check(num) {
	for (var i = 0 ; i < num.length ; i++) {
		if ((num.charAt(i) < '0') || (num.charAt(i) > '9')) {
			return false;
		}
	}
	return true;
}

//--	소숫점 이하자릿수(1자리) 체크
function Check_Decimal(num) {

	if (num == '') {
		num		=	'0';
	}

	var var_1	=	0;
	var var_p	=	9;
	for (var i = 0 ; i < num.length ; i++) {

		if (num.charAt(i) == '.') {
			var_p		=	i;
		}
		//--	소숫점이하 자리수 계산
		if (i > var_p && (num.charAt(i) >= '0' && num.charAt(i) <= '9')) {
			var_1		=	var_1 + 1;
		}
	}

	//--	소숫점이하 자리수,
	if (var_1 > 1 || var_p == 0) {
		return false;
	}

	return true
}

//--	입력항목이 공백인지 확인
function empty_check(data) {
	if (data.length == 0) {
		return false;
	}
	else {
		for (var i=0; i<data.length; i++) {
			if (data.substring(i,i+1) != " ") {
				return true;
			}
		}
		return false;
	}
	return true;
}

//--	공백이 있는지 확인
function Space_Check(data) {
	for (var i=0; i<data.length; i++) {
		if (data.substring(i,i+1) == " ") {
			return false;
		}
	}
	return true;
}

//--	입력값 검사
function char_Check(data) {
	var num_cnt		=	0;
	var chk_str		=	'-./[]_{|}~';
//	var chk_str		=	'!#$%()*,-./:;<=>@[\]^_{|}~';
	for (var i = 0; i < data.length; i++) {
		if ((((data.charAt(i) >= '0') && (data.charAt(i) <= '9'))) || (((data.charAt(i) >= 'a') && (data.charAt(i) <= 'z'))) || (((data.charAt(i) >= 'A') && (data.charAt(i) <= 'Z'))))
			num_cnt +=	1;
	}
	if (num_cnt == data.length) {
		return true;
	}
	return false;
}

//--	필드길이 검사(영문, 숫자 1Byte, 한글 2Byte로 계산)
function getLength(str) {
	return (str.length + (escape(str) + "/%u").match(/%u/g).length-1);
}

//--	특수문자 검사(전체)
function Special_Check1(data) {
	var num_cnt		=	0;
	var chk_str		=	'!#$%()*,-./:;<=>@[\]^_`{|}~&+?"';

	for (var i = 0; i < data.length; i++) {
		for (var j = 0; j < chk_str.length; j++)
			if (chk_str.charAt(j) == data.charAt(i) || data.charAt(i) == '"' || data.charAt(i) == "'" || data.charAt(i) == '\\')
				num_cnt += 1;
	}

	if (num_cnt > 0) {
		return false;
	}
	return true;
}

//--	특수문자 검사(-_제외)
function Special_Check2(data) {
	var num_cnt		=	0;
	var chk_str		=	'!#$%()*,./:;<=>@[\]^`{|}~&+?"';

	for (var i = 0; i < data.length; i++) {
		for (var j = 0; j < chk_str.length; j++)
			if (chk_str.charAt(j) == data.charAt(i) || data.charAt(i) == '"' || data.charAt(i) == "'")
				num_cnt += 1;
	}

	if (num_cnt > 0) {
		return false;
	}
	return true;
}

//--	특수문자 검사(/제외)
function Special_Check3(data) {
	var num_cnt		=	0;
	var chk_str		=	'!#$%()*,-.:;<=>@[\]^_`{|}~&+?"';

	for (var i = 0; i < data.length; i++) {
		for (var j = 0; j < chk_str.length; j++)
			if (chk_str.charAt(j) == data.charAt(i) || data.charAt(i) == '"' || data.charAt(i) == "'" || data.charAt(i) == '\\')
				num_cnt += 1;
	}

	if (num_cnt > 0) {
		return false;
	}
	return true;
}

//--	특수문자 검사(복수)
function Double_Check(data) {
	var num_cnt		=	0;
	var chk_str		=	'--__@@(())[[]]{{}}//\\||##$$%%**,,..::;;<<>>&&++??';
	var var_str1	=	'';
	var var_str2	=	'';
	for (var i = 0; i < data.length; i++) {
		if (i < data.length)
			var_str1	=	data.substring(i,i+2);

		for (var j = 0; j < chk_str.length; j++)
			if (j < chk_str.length)
				var_str2	=	chk_str.substring(j,j+1);

			if (var_str1 == var_str2 || var_str1 == '""' || var_str1 == "''")
				num_cnt += 1;
	}

	if (num_cnt > 0) {
		return false;
	}
	return true;
}

//--	OR 문자 검사
function Or_Check(data) {
	var num_cnt		=	0;
	var var_str1	=	'';
	var var_no		=	data.length;

	for (var i = 0; i < data.length; i++) {
		for (var j = i; j < data.length; j++) {
			if (j < data.length)
				var_str1	=	data.substring(i,j+1).toLowerCase();

				if (var_str1 == 'oror' || var_str1 == 'oror ' || var_str1 == ' oror' || var_str1 == ' oror '
					|| var_str1 == 'or' || var_str1 == 'or ' || var_str1 == ' or' || var_str1 == ' or ')
					num_cnt += 1;

		}
	}

	if (num_cnt > 0) {
		return false;
	}
	return true;
}

//--	Union 문자 검사
function Union_Check(data) {
	var num_cnt		=	0;
	var var_str1	=	'';
	var var_no		=	data.length;

	for (var i = 0; i < data.length; i++) {
		for (var j = i; j < data.length; j++) {
			if (j < data.length)
				var_str1	=	data.substring(i,j+4).toLowerCase();

				if (var_str1 == 'union' || var_str1 == 'union ' || var_str1 == ' union' || var_str1 == ' union ')
					num_cnt += 1;

		}
	}

	if (num_cnt > 0) {
		return false;
	}
	return true;
}


//-- 특정 form의 특정name에 대한 chkbox를 모두 value로 setting
function setChkboxAll(formname, name, value) {
    for (var i = 0; i < formname.length ; i++) {
        if (name == formname.elements[i].name)
             formname.elements[i].checked = value;
    }
}

// 처리내용 : 특정값(char)를 append한 결과를 return(체크안되었으면 default값을 append)
//  check된 checkbox의 value를 attach한다 (check안되면 value값을)
// 주로 멀티 선택시 사용
function getChkBoxByValue(formname, name, defvalue)
{
    var Buf = "";
    var chkCnt = 0;
    for (var i = 0; i < formname.length ; i++) {
        if (name == formname.elements[i].name) {
            if (formname.elements[i].checked) {
                chkCnt ++;
                Buf = Buf + formname.elements[i].value + defvalue;
            }
        }
    }
    return Buf;
}

// 특수문자등을 사용했는지를 체크한다.
function dataCheck(data) {
	var num_cnt		=	0;
	var chk_str		=	'!#$%()*,-./:;<=>@[\]^_`{|}~';
	for (var i = 0; i < data.length; i++) {
		if ((((data.charAt(i) >= '0') && (data.charAt(i) <= '9'))) || (((data.charAt(i) >= 'a') && (data.charAt(i) <= 'z'))) || (((data.charAt(i) >= 'A') && (data.charAt(i) <= 'Z'))))
			num_cnt += 1;
		for (var j = 0; j < chk_str.length; j++)
			if (chk_str.charAt(j) == data.charAt(i))
				num_cnt += 1;
	}
	if (num_cnt == data.length) {
		return true;
	}
	return false;
}

	function isEmpty(data)
	{
		for ( var i = 0 ; i < data.length ; i++ ) {
			if ( data.substring( i, i+1 ) != ' ' )
				return false;
		}
		return true;
	}

   function windowLeftPosition(pos){
      var leftPosition = screen.width - pos;

	  leftPosition = (leftPosition < 0) ? 0 : leftPosition/2;

	  return leftPosition;
   }

   function windowTopPosition(pos){
	  var topPosition = screen.height - pos;

	  topPosition  = (topPosition < 0)  ? 0 : topPosition /2;

	  return topPosition;
   }


   function center_popup(s_url, s_name, s_width, s_height) {

	ls_pri = "toolbar=no, location=no, directories=no, menubar=no, resizable=no, scrollbars=no, status=no, width="+s_width+" height="+s_height;
	wd_pop = window.open(s_url, s_name,ls_pri);
	wd_pop.blur();
//	wd_pop.moveTo(((screen.availwidth - eval(s_width))/2),((screen.availheight - eval(s_height))/2));
	wd_pop.moveTo(((screen.availwidth - s_width)/2),((screen.availheight - s_height)/2));
	wd_pop.focus();
	return wd_pop;
   }
/*
   function center_popup_scroll(s_url, s_name, s_width, s_height) {
	ls_pri = "toolbar=no, location=no, directories=no, menubar=no, resizable=no, scrollbars=yes, status=no, width="+s_width+" height="+s_height;
	wd_pop = window.open(s_url, s_name,ls_pri);
	wd_pop.blur();
	wd_pop.moveTo(((screen.availwidth - eval(s_width))/2),((screen.availheight - eval(s_height))/2));
	wd_pop.focus();
	return wd_pop;
   }
   */
   function sel_box_insert(obj, s_text, s_val) {
	obj.options[obj.length] = new Option(s_text,s_val,false,false);
   }

   function sel_box_removeall(obj) {
        var len = obj.length;
        for (var i = len; i > 0; i--) {
    		obj.options[i] = null;
    	}
    }

   function sel_box_remove(obj) {
        var len = obj.length;
        for (var i = len-1; i >= 0; i--) {
    		obj.options[i] = null;
    	}
    }

    function sel_box_value(obj) {
	  return obj.options[obj.options.selectedIndex].value;
    }

    function sel_box_text(obj) {
	  return obj.options[obj.options.selectedIndex].text;
    }

    function sel_box_select(obj, s_val) {
		for(i=0; i< obj.length; i++) {
			if(obj.options[i].value==s_val) {
				obj.options[i].selected = true;
			}
		}
    }

	function com_checkbox_check(obj) {
	    isChk=false;
	    if(obj.length == undefined) {
	        isChk=false;
	    } else {
	        isChk=true;
	    }
	    return isChk;
	}

	var checkbox_flag = true;
	function checkBoxSelectAll(obj) {
	    try
	    {
	        if(com_checkbox_check(obj)) {
	            for(i=0; i< obj.length; i++) {
	                obj[i].checked=checkbox_flag;
	            }
	        } else {
	            obj.checked=checkbox_flag;
	        }
	        if(checkbox_flag==true) {
	            checkbox_flag=false;
	        } else  {
	            checkbox_flag=true;
	        }
	    }catch (e) {
	        window.status = "error";
	    }
	}

	function getFileExtension(str){
       if(str == "") return "";

       var index = str.lastIndexOf(".");
       var extension = str.substring(index+1,str.length);

	   return extension;
	}


	//문자열의 오른쪽 공백을 제거 함수
	function java_right_trim(char_text)
	{
		var search = char_text.length - 1;

		while (char_text.charAt(search) ==" ")
		{
			search = search - 1;
		}
		return char_text.substring(0, search + 1)
	}
	//팝업가운데로 띄우기
	function popWin(url,w,h) {
		var winl = (screen.width - w) / 2;
		var wint = (screen.height - h) / 2;
		window.open(url,'pop_win','width='+w+',height='+h+', top='+wint+',left='+winl+', toolbars=no,menubars=no,scrollbars=no');
	}

	// 증서번호 입력값 포멧
	function autoFormatCertNo(form)
	{
		if(event.keyCode != 8)
		{
			if(form.value.length == 2) form.value = form.value+"-";
			else if(form.value.length == 5) form.value = form.value+"-";
		}
	}

	// 인가번호 입력값 포멧
	function autoFormatIngaNo(form)
	{
		if(event.keyCode != 8)
		{
			jumin = form.value;
			jumin = form.value.replace(/,/g, "");
			if(jumin.split("-").length == 1)
			{
				var num_str = jumin.toString();
				var result = "";
				for(var i=0; i<num_str.length; i++)
				{
					if(i == 1) result = result+num_str.charAt(i)+'-';
					else result = result + num_str.charAt(i);
				}
				form.value = result;
			}
			else
			{
				if(form.value.length == 2) form.value = form.value+"-";
			}
		}
	}


	function removeStr(arg0 ,arg1)
	{
		if(arg0 == "" || arg1 == "") return "";

		var str = arg0;
		var i = 0;
		var pos_str = 0;
		var rtn_str = "";
		while(i<str.length)
		{
			pos_str = str.indexOf(arg1, i);
			if(pos_str == -1)
			{
				rtn_str += str.substring(i, str.length);
				break;
			}
			else
			{
				rtn_str += str.substring(i, pos_str);
				i = pos_str+1;
			}
		}
		return rtn_str;
	}

	function toHourMinSec(t) {
		var hour;
		var min;
		var sec;
		// 정수로부터 남은 시, 분, 초 단위 계산
		hour = Math.floor(t / 3600);
		min = Math.floor( (t-(hour*3600)) / 60 );
		sec = t - (hour*3600) - (min*60);
		// hh:mm:ss 형태를 유지하기 위해 한자리 수일 때 0 추가
		if(hour < 10) hour = "0" + hour;
		if(min < 10) min = "0" + min;
		if(sec < 10) sec = "0" + sec;
		return(hour + ":" + min + ":" + sec);
	}

	function AjaxError(request,status,errorMsg) {
		 if (request.status == "403" || request.status == "401") {
			 LLYNX_Alert("session이 만료되었습니다.");
	    	 logOut();
	     } else {
	    	 LLYNX_Alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+errorMsg);
	     }
	}

	function mailSet(obj) {
		if($("#selectEmail",obj).val() != 1) {
			$("#textEmail",obj).val($("#selectEmail",obj).val());
		}else {
			$("#textEmail",obj).val("");
		}
	}

	function setFormatTel(str){

		var val = str;
		try{
			if(val.substring(0,2) == "02"){
				if(val.length == 9){
					val = val.substring(0,2) + "-" + val.substring(2,5) + "-" + val.substring(5,9);
				}else if(val.length == 10){
					val = val.substring(0,2) + "-" + val.substring(2,6) + "-" + val.substring(6,10);
				}else if(val.length == 11){
					val = val.substring(0,3) + "-" + val.substring(3,7) + "-" + val.substring(7,11);
				}
			}else{
				if(val.length == 10){
					val = val.substring(0,3) + "-" + val.substring(3,6) + "-" + val.substring(6,10);
				}else if(val.length == 11){
					val = val.substring(0,3) + "-" + val.substring(3,7) + "-" + val.substring(7,11);
				}else if(val.length == 12){
					val = val.substring(0,4) + "-" + val.substring(4,8) + "-" + val.substring(8,12);
				}
			}
		} catch(e) {
			val = str;
		}

		return val;
	}
function getTimeS(){
	var d = new Date();
	var s= '';
	var sh=d.getHours();
	var sm=d.getMinutes();
	var ss=d.getSeconds();
	if(sh<10){
		sh="0"+sh;
	}
	if(sm<10){
		sm="0"+sm;
	}
	if(ss<10){
		ss="0"+ss;
	}
	s=sh+":"+sm+":"+ss;
	return s;
}

	/*마스킹 */
function setMask(gubun, mask_data,user_mask,site_mask){

	if ( typeof mask_data == "undefined" || mask_data=="" ){
		return " ";
	}

	//setFormatTel
		var val = "";
		var l_length=0;
		var temptext="";
		try{
			if(site_mask=="Y"){
				if(user_mask=="Y"){
					if(gubun=="1"){
						//이름
						l_length=mask_data.length;
						if(mask_data.length==3){

							val=mask_data.substring(0,2)+"*";
						}else{
							var templength=0;
							templength=l_length/3;

							for(i=0; i<templength;i++){
								temptext=temptext+"*";
							}
							val=mask_data.substring(0,(l_length-templength))+temptext;
						}
					}else if(gubun=="2"){
						//전화번호

						l_length=mask_data.length;
						mask_data=mask_data.replace(/-/g, "");
						if(l_length==9){
							temptext=mask_data.substring(0,2)+"-"+mask_data.substring(2,4)+"*_**"+mask_data.substring(7);
						}else if(l_length==10){
							if(mask_data.substring(0,2)=="02"){
								temptext=mask_data.substring(0,2)+"-"+mask_data.substring(2,4)+"**_**"+mask_data.substring(8);
							}else{
								temptext=mask_data.substring(0,3)+"-"+mask_data.substring(3,5)+"**_**"+mask_data.substring(8);
							}
						}else if(l_length==11){
							temptext=mask_data.substring(0,3)+"-"+mask_data.substring(3,5)+"**_**"+mask_data.substring(9);
						}else{
							temptext=mask_data;
						}
						val=temptext;
					}else if(gubun=="3"){
						//이메일
						if(mask_data.length<3){
							return "";
						}
						try{
							var stemp=mask_data.split("@");
							l_length=stemp[0].length;
							temptext=stemp[0].substring(0,l_length-3)+"***@"+stemp[1];
							val=temptext;
						}catch(e){
							val=mask_data;
						}
					}else if(gubun=="4"){
						//주소
					}
				}else{
					val=mask_data;
				}

			}else{
				if(user_mask=="Y"){
					if(gubun=="1"){
						//이름
						l_length=mask_data.length;
						if(mask_data.length==3){

							val=mask_data.substring(0,2)+"*";
						}else{
							var templength=0;
							templength=l_length/3;

							for(i=0; i<templength;i++){
								temptext=temptext+"*";
							}
							val=mask_data.substring(0,(l_length-templength))+temptext;
						}
					}else if(gubun=="2"){
						//전화번호

						l_length=mask_data.length;
						mask_data=mask_data.replace(/-/g, "");
						if(l_length==9){
							temptext=mask_data.substring(0,2)+"-"+mask_data.substring(2,4)+"*_**"+mask_data.substring(7);
						}else if(l_length==10){
							if(mask_data.substring(0,2)=="02"){
								temptext=mask_data.substring(0,2)+"-"+mask_data.substring(2,4)+"**_**"+mask_data.substring(8);
							}else{
								temptext=mask_data.substring(0,3)+"-"+mask_data.substring(3,5)+"**_**"+mask_data.substring(8);
							}
						}else if(l_length==11){
							temptext=mask_data.substring(0,3)+"-"+mask_data.substring(3,5)+"**_**"+mask_data.substring(9);
						}else{
							temptext=mask_data;
						}
						val=temptext;
					}else if(gubun=="3"){
						//이메일
						if(mask_data.length<3){
							return "";
						}
						try{
							var stemp=mask_data.split("@");
							l_length=stemp[0].length;
							temptext=stemp[0].substring(0,l_length-3)+"***@"+stemp[1];
							val=temptext;
						}catch(e){
							val=mask_data;
						}
					}else if(gubun=="4"){
						//주소
					}
				}else{
					val=mask_data;
				}
			}
		}catch(e){
			//LLYNX_Alert(e);
			val=mask_data;
			return val;
		}

		return val;
	}

function phoneNumHy(no) {
	if(no!=""&&no!=null){
		no=no.replace(/-/g, "");
		var telLeng=no.length;

		if (telLeng==9) {
			return no.substring(0, 2)+"-"+no.substring(2, 6)+"-"+no.substring(6, 9);
		} else if (telLeng==10) {
			if(no.substring(0,2)=="02"){
				return no.substring(0, 2)+"-"+no.substring(2, 6)+"-"+no.substring(6, 10);
			}else{
				return no.substring(0, 3)+"-"+no.substring(3, 6)+"-"+no.substring(6, 10);
			}
		} else if (telLeng==8) {
			no.substring(0, 4)+"-"+no.substring(4, 8);
		} else if(telLeng==11) {
			return no.substring(0,3)+"-"+no.substring(3, 7)+"-"+no.substring(7, 11);
		} else {
			return no.substring(0,3)+"-"+no.substring(3, 7)+"-"+no.substring(7, telLeng);
		}
	}else{
		no=="";
	}
	return no;
}

/*
 * null check
 */
function fnIsNull(obj) {
	if (obj === "" || obj === null || obj === undefined
		|| (obj != null && obj === "Object" && !Object.keys(obj).length)) {
		return true;
	} else {
		return false;
	}
}

/*
 * locale
 */
function getLocale() {
	return navigator.language || navigator.userLanguage;
}

function progressShow() {
//	$(".loading").show();
	$("#jspLoading").show();
}

function progressHide() {
//	$(".loading").hide();
	$("#jspLoading").hide();
}

$(document).ajaxStart(function() {
//	progressShow();
});

function ___fileDownload(url, param) {
	$.ajax({
		url: url
		, data: JSON.stringify(param)
		, dataType: "binary"
		, xhrFields: {"responseType": "blob"}
		, method: "POST"
		, contentType: "application/json; charset=utf-8"
		, async: false
		, cache: false
		, success: function(data, status, xhr) {
			var filename= decodeURIComponent(xhr.getResponseHeader("Content-Disposition").split(";")[1].split("=")[1]);
			var blob = new Blob([data]);
			// console.log(filename);
			if(window.navigator && window.navigator.msSaveOrOpenBlob) {
				window.navigator.msSaveOrOpenBlob(blob, filename);
			} else {
				var url = window.URL || window.webkitURL
				var url_instance = url.createObjectURL(blob);

				let link = document.createElement("a");
				    link.style.display = "none";
				    link.href = url_instance;
				    link.download = filename;

				document.body.appendChild(link);
				link.click();

				url.revokeObjectURL(url_instance);
			}
		},
		error: function(data) {
//			LLYNX_Alert('파일다운로드중 오류가 발생되었습니다.\n'+ data.status+' : '+data.statusText);
			// console.log(data);
		},
		complete: function(data) {
			progressHide();
			// console.log("file download complete");
		}
	});
}

var xhr = new XMLHttpRequest();
function fileDownload(url, param) {
	xhr.open("POST", url);
	xhr.responseType = "blob";
	xhr.setRequestHeader("Accept", "application/json; charset=utf-8");
	xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
	xhr.send(JSON.stringify(param));
}
xhr.onreadystatechange = function() {
	if(this.readyState == 4 && this.status == 200) {
		var filename= decodeURIComponent(xhr.getResponseHeader("Content-Disposition").split(";")[1].split("=")[1]);
//		// console.log(filename);
		var url = window.URL.createObjectURL(this.response);
		let link = document.createElement("a");
		    link.style.display = "none";
		    link.href = url;
		    link.download = filename;

		document.body.appendChild(link);
		link.click();

		window.URL.revokeObjectURL(url);
	} else {
	    // console.log("파일 다운로드중 오류가 발생되었습니다.");
		// console.log(this);
	}
}

function getGroupMap(gropNm) {
	var map = {};
	//
	$("input[group='" + gropNm + "'],textarea[group='" + gropNm + "'],select[group='" + gropNm + "']").each(function() {
		var type = $(this).prop("type");
		var id = $(this).prop("id").replace(gropNm + "_", "");
		var name = $(this).prop("name").replace(gropNm + "_", "");
		var val = $(this).val();
		var tag = $(this).prop("tagName").toUpperCase();
//		// console.log("##########################");
//		// console.log("tag: " + tag);
//		// console.log("type: " + type);
//		// console.log("id: " + id);
//		// console.log("name: " + name);
//		// console.log("val: " + val);
//		// console.log("##########################");

		if (tag == "INPUT") {
			if (type == "hidden" || type == "text") {
				map[id] = val;
			} else if (type == "radio") {
				if ($(this).is(":checked")) {
					map[name] = val;
				}
			} else if (type == "checkbox") {
				if (!map[name]) {
					map[name] = new Array();
				}
				if ($(this).is(":checked")) {
					map[name].push(val);
				}
			}
		} else if (tag == "TEXTAREA") {
			map[id] = val;
		} else if (tag == "SELECT") {
			map[id] = val;
		}
	});
	//
	return map;
}

function clearGroup(gropNm) {
	//
	$("input[group='" + gropNm + "'],textarea[group='" + gropNm + "'],select[group='" + gropNm + "']").each(function() {
		var type = $(this).prop("type");
		var id = $(this).prop("id").replace(gropNm + "_", "");
		var name = $(this).prop("name").replace(gropNm + "_", "");
		var val = $(this).val();
		var tag = $(this).prop("tagName").toUpperCase();
		/*
		// console.log("##########################");
		// console.log("tag: " + tag);
		// console.log("type: " + type);
		// console.log("id: " + id);
		// console.log("name: " + name);
		// console.log("val: " + val);
		// console.log("##########################");
		*/
		if (tag == "INPUT") {
			if (type == "hidden" || type == "text") {
				$(this).val("");
			} else if (type == "radio") {
				$(this).prop("checked", false);
			} else if (type == "checkbox") {
				$(this).prop("checked", false);
			}
		} else if (tag == "TEXTAREA") {
			$(this).val("");
		} else if (tag == "SELECT") {
			$(this).val("");
		}
	});
}

function setGroupMap(gropNm, obj) {
	//
	$("input[group='" + gropNm + "'],textarea[group='" + gropNm + "'],select[group='" + gropNm + "']").each(function() {
		var type = $(this).prop("type");
		var id = $(this).prop("id").replace(gropNm + "_", "");
		var name = $(this).prop("name").replace(gropNm + "_", "");
		var val = $(this).val();
		var newVal = obj[id];
		var tag = $(this).prop("tagName").toUpperCase();
		if (tag == "INPUT") {
			if (type == "hidden" || type == "text") {
				$(this).val(newVal);
			} else if (type == "radio" || type == "checkbox") {
				if (val == newVal) {
					$(this).prop("checked", true);
				} else {
					$(this).prop("checked", false);
				}
			}
		} else if (tag == "TEXTAREA") {
			$(this).val(newVal);
		} else if (tag == "SELECT") {
			$(this).val(newVal);
		}
	});
}

$(document).ready(function() {

	var className;
	var message;

	dwr.engine.setErrorHandler(function(msg, exc) {
//		// console.log(exc);
//		// console.log(msg);
		try {
			className = exc.cause.javaClassName ;
			message =  exc.cause.message;
		} catch(e) {
			className = exc.javaClassName;
			message =  exc.message;

		}
		// console.log("dwr.engine.setErrorHandler execption class ["+className+"], message["+message+"]");

		if ("com.llynx.cmn.auth.AccessDeninedException" == className) { // access denined
			LLYNX_Alert(message);

			var page;
			var panelId;
			try {
				if ($("#cmmPoopup:not(:hidden)").length == 1) {
					popupClose();
				} else {
					page = $(".main_tab_header li:last");
					$(page).closest("li").remove().attr("aria-controls");
					$("#"+panelId).remove();
					tabs.tabs("refresh");
				}
			} catch(e) {
				try {
					if (parent.$("#cmmPoopup:not(:hidden)").length == 1) {
						parent.popupClose();
					} else {
						page = parent.$(".main_tab_header li:last");
						panelId = $(page).closest("li").remove().attr("aria-controls");
						$("#"+panelId).remove();
						parent.tabs.tabs("refresh");
					}
				} catch (e) {
					// console.log(e);
				}
			}
		} else if ("com.llynx.cmn.auth.DwrLoginException" == className) { // session expired
			alert("세션이 종료되었습니다.\n로그인 페이지로 이동합니다.");
			top.location.href = "/lo/lolog01.do"; // 로그인화면호출

		} else if ("java.lang.Exception" == className) {  // transaction throw and etc..
			LLYNX_Alert(message);

		} else { // dwr or other exception
			msg = message || msg;
			LLYNX_Alert("시스템에 장애가 발생하였습니다. 잠시 후 다시 시도해 주세요.\n지속적인 문제 발생시 문의 해 주시기 바랍니다.\n\n에러 메시지\n" + msg);
		}

		progressHide();
	});

});


//추가 함수

//=================================================================================
//Program Name : SPIZ_getAge
//Program Desc : 보험연령 계산하기
//Parameter    : ageDvsn - 구분 (1 : 보험연령, 2 : 만연령)
//           rrno - 주민등록번호(13자리)
//           inpDate - 기준일자
//			   returnType - 1:성별(남자:여자) 2:계산나이, 3: 성별, 나이
//Comment      :
//기준일자에서 생년월일을 감한 나이를 계산하는 것으로 나머지가 6월 이상인
//경우는 1세를 더하고, 6월 미만(5개월30일 포함)은 버린다.
//** 계산기준 : 1년은 12개월, 1달은 30일을 기준으로 한다.
//<예시> 1972.2.25 출생일인 자가 2006.8.24일에 가입한 경우와 2006.8.25
//     일에 가입한 경우 보험나이를 계산하여 본다.
//     계약일    2006.  8. 24                    2006.  8. 25
//     출생일    1972.  2. 25                    1972.  2. 25
//             -----------------               -----------------
//                 34.  5. 29                      34.  6.  0
//     보험연령    34세                            35세
//=================================================================================
function getInsureAge(ageDvsn, rrno, inpDate, returnType){
	var birthDate;
	var baseBirth = parseInt(inpDate, 10);
	var resultYear, resultMonth, resultDay;
	var sex;
	var returnAge;

	// 성별 체크
	switch (rrno.substr(6,1)){
		case '2' :
		case '4' :
		case '6' :
		case '8' :
		   sex = "여자";
		   break;
		default :
		   sex = "남자";
	}

	//기준일자의 년월일과 주민번호의 생년월일이 같은 경우에 태아로 표시
	if (inpDate.substr(2,6) == rrno.substr(0,6)){
		sex = "태아";
	}

	switch (rrno.substr(6,1)){
		case '1' :
		case '2' :
		case '5' :
		case '6' :
		   birthDate = parseInt(rrno.substr(0,6), 10) + 19000000;
		   break;
		case '3' :
		case '4' :
		case '7' :
		case '8' :
		  birthDate = parseInt(rrno.substr(0,6), 10) + 20000000;
		  break;
		//'0'과 '9'는 1800년대 이나 현재는 없으므로 에러메세지 발생
		default :
		  return "";
	}

	var birthYear		= parseInt(birthDate / 10000, 10);
	var birthMonth	= parseInt((birthDate % 10000) / 100, 10);
	var birthDay		= parseInt(birthDate % 100, 10);

	var baseYear		= parseInt(baseBirth / 10000, 10);
	var baseMonth	= parseInt((baseBirth % 10000) / 100, 10);
	var baseDay		= parseInt(baseBirth % 100, 10);

	if ( baseBirth - birthDate < 0 ){
	   LLYNX_Alert("생년월일의 년도가 기준일 보다 큽니다.(" + rrno.substr(0,6) + ")", "");
	   return "";
	}

	// 날짜 처리
	if( (baseDay - birthDay) < 0 ){
	   baseMonth -= 1;
	   resultDay = baseDay + 30 - birthDay;
	}else{
	   resultDay = baseDay - birthDay;
	}

	// 달수 처리
	if( (baseMonth - birthMonth) < 0 ){
	   baseYear -= 1;
	   resultMonth = baseMonth + 12 - birthMonth;
	}else{
	   resultMonth = baseMonth - birthMonth;
	}

	// 년수 처리
	resultYear = baseYear - birthYear;

	//보험연령이 아닐경우에는 만연령이므로 결과 값을 바로 Out으로 보낸다
	returnAge = resultYear;     // 만나이

	if (ageDvsn == "1"){
	   if ( (resultMonth * 100 + resultDay) > 530 ){
	       returnAge = resultYear + 1;
	   }else{
	       returnAge = resultYear;
	   }
	}

	// 결과값 Return
	//return "(" + sex + ", " + returnAge + "세)";

	if (returnType == "1") {
		 return sex;
	} else if (returnType == "2") {
		 return returnAge;
	} else {
		 return sex + ", " + returnAge;
	}
}

// keyup이벤트로 숫자가 아닌 값이 입력 되었을 때 alert후 한글자 back
function numberKeyup(obj){
	var val = obj.value;
	if(isNaN(val)){
		var text = $(obj).val();
		var length = $(obj).val().length;
		var textSplit = text.split(""); // input의 value를 한글자씩 쪼개기
		var nanCnt = 0; // 숫자가 아닌 문자의 개수
		var nanIndex = []; // 숫자가 아닌 문자의 인덱스

		// 숫자가 아닌 글자 개수 구하기
		for(var i=0;i<textSplit.length;i++){
			if(isNaN(textSplit[i])){
				nanCnt++; // 개수
				nanIndex.push(i); // 인덱스
			}
		}

		LLYNX_Alert("숫자만 입력가능합니다");

		// 원래 value에서 숫자가 아닌 문자의 인덱스를 textSplit의 인덱스에 넣어 해당 글자를 공백으로 치환
		if(nanCnt>0){
			for(var i=0;i<nanIndex.length;i++){
				text=text.replace(textSplit[nanIndex[i]],"");
			}
		}

		// 치환된 텍스트를 다시 value에 넣어줌
		$(obj).val(text);
	}
}

function checkMobileNo(no) {
	var regEx = /[01](0|1|6|7|8|9)(\d{4}|\d{3})\d{4}$/g;
	if (regEx.test(no)) {
		return true;
	} else {
		return false;
	}
}

// custInfo.s_insuAge - 고객정보 조회될 경우 자동 셋팅
// 우체국 보험나이 계산
function getInsuAge(birth){
	var age = 0;
	var now   = new Date();
	curr = jsToday('');

	var iCurr_Date = parseInt(curr.substring(6,8), 10);
	var iBirth_Date = parseInt(birth.substring(6,8), 10);

	var iCurr_Mon = now.getMonth()+1;
	var iBirth_Mon = parseInt(birth.substring(4,6), 10);
	var iCurr_Year = parseInt(curr.substring(0,4));
	var iBirth_Year = parseInt(birth.substring(0,4));
	var iYear = (iCurr_Year - iBirth_Year)-1;

	iBirth_Mon = iBirth_Mon - 6;
	if(iBirth_Mon < 1)
	{
		iYear = iYear + 1;
		iBirth_Mon = iBirth_Mon + 12;
	}

	var iMon = iCurr_Mon - iBirth_Mon;
	var iDay = iCurr_Date - iBirth_Date;
	if(iMon < 0){
		age = iYear;
	}else if(iMon > 0){
		age = iYear +1;
	}else{
	  	 if(iDay < 0)
	  	 {
	  	 	age = iYear;
	  	 }
	  	 else
	  	 {
	  	 	age = iYear +1;
	  	 }
	}
	return age;
}

function jsToday(gubun){
	var curr = new Date();
	curYear = curr.getFullYear();
	curMonth = curr.getMonth()+1;
	curDate = curr.getDate();
	if(curMonth < 10) curMonth = "0"+curMonth;
	if(curDate < 10) curDate = "0"+curDate;
	return curYear + gubun + curMonth + gubun + curDate ;
}

// form 데이터를 Object형태로 받기
$.fn.serializeObject = function() {
  "use strict"
  var result = {}
  var extend = function(i, element) {
    var node = result[element.name]
    if ("undefined" !== typeof node && node !== null) {
      if ($.isArray(node)) {
        node.push(element.value)
      } else {
        result[element.name] = [node, element.value]
      }
    } else {
      result[element.name] = element.value
    }
  }

  $.each(this.serializeArray(), extend)
  return result
}

/*var alertMsg = "";
var focusId = "";
var closeYn = "N";

function LLYNX_Alert(msg, focusDoc, close){
	if($(".popup_window").length){
		if(!$("#alertLayer").length){
			var layer = $("<div/>",{
				class:"popup_wrap",
				id:"alertLayer"
			});
			$("body").prepend(layer);
		}
		$("#alertLayer").show();
		$("#alertLayer").html('<iframe id="alertIfr" src="/common/alert.do" onload="addAlertMsg();"></iframe>');
		alertMsg = msg;
		if(focusDoc!=''&&focusDoc!=null&&focusDoc!=undefined){
			focusId = focusDoc;
		}
		if(close!=''&&close!=null&&close!=undefined){
			if(close=="Y"){
				closeYn="Y";
			}
		}
	}else{
		if(!$("#alertLayer", top.document).length){
			var layer = $("<div/>",{
				class:"popup_wrap",
				id:"alertLayer"
			});
			$("body", top.document).prepend(layer);
		}
		$("#alertLayer", top.document).show();
		$("#alertLayer", top.document).html('<iframe id="alertIfr" src="/common/alert.do" onload="addAlertMsg();"></iframe>');
		$("#alertLayer", top.document).contents().find("#alertIfr").find(".popup_window").find(".popup_content").find(".popup_body").find("#msg").text(msg);
		top.alertMsg = msg;
		if(focusDoc!=''&&focusDoc!=null&&focusDoc!=undefined){
			top.focusId = focusDoc;
		}
		if(close!=''&&close!=null&&close!=undefined){
			if(close=="Y"){
				top.closeYn="Y";
			}
		}
	}
}

function addAlertMsg() {
	$("#alertIfr").contents().find(".popup_window").find(".popup_content").find(".popup_body").find("#msg").text(alertMsg);
}

//메인화면 팝업 종료
function alertClose() {
	$("#alertLayer").hide();
	$("#alertLayer").html("");
	if(focusId!=""){
		afterFocus(focusId);
	}
	if(closeYn=="Y"){
		parent.popupClose();
	}
	focusId="";
	alertMsg="";
	closeYn="N";

}

function afterFocus(id){
	$("#contents").find("#tabs").find("div").each(function(){
		if($(this).css("display")!="none"){
			$(this).find("iframe").contents().find("#"+id).focus();
		}
	});
}

var testFunc;

function findMe(){
	var id="";
	$("#contents").find("#tabs").find("div").each(function(){
		if($(this).css("display")!="none"){
			id=$(this).find("iframe").attr("id");
		}
	});
	return id;
}*/

function removeComma(value){
	//console.log(value);
	if(isNaN(value)){
		return value.replace(/,/ig, '');
	}else{
		return value;
	}
}

// 날짜에서 '-'제거
function removeHyphen(strDate){
	return strDate.replace(/-/ig, '');
}

// 숫자 뒤에 퍼센트 추가
function addPercent(value){
	if(isNaN(value)){
		return value;
	}else{
		return value + '%';
	}
}

function secToTime(sec){
	if(isNaN(sec)){
		sec = sec*1;
	}
	var timeSec = Math.floor(sec%60);
	var timeMin = Math.floor(sec/60);
	var timeHour = Math.floor(sec/60/60);

	if(timeSec<10){
		timeSec = "0"+timeSec;
	}else{
		timeSec = timeSec+"";
	}

	if(timeMin<10){
		timeMin = "0"+timeMin;
	}else{
		timeMin = timeMin+"";
	}

	if(timeHour<10){
		timeHour = "0"+timeHour;
	}else{
		timeHour = timeHour+"";
	}

	return timeHour+":"+timeMin+":"+timeSec;
}


function momentDateFormat(value){
	if(value!=""&&value!=undefined&&value!=null){
		return moment(value).format("YYYY-MM-DD HH:mm:ss");
	}else{
		return "";
	}
}

function momentDateTimeFormat(value){
	if(value!=""&&value!=undefined&&value!=null){
		return moment(value).format("DD일 HH:mm:ss");
	}else{
		return "";
	}
}

function momentMonthDateTimeFormat(value){
	if(value!=""&&value!=undefined&&value!=null){
		return moment(value).format("MM월 DD일 HH:mm:ss");
	}else{
		return "";
	}
}

function momentTimeFormat(value){
	if(value!=""&&value!=undefined&&value!=null){
		return moment(value).format("HH:mm:ss");
	}else{
		return "";
	}
}

function booleanFormat(value){
	if(value){
		return "Y";
	}else{
		return "N";
	}
}


function nullOrUndefinedToZero(value){
	if(value==null||value==undefined){
		return 0;
	}else{
		return value;
	}
}