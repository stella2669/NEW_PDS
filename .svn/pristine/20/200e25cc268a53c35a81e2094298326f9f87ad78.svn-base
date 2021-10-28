
//datepicker
$(function(){
	$(".date_pick .date_cell").datepicker({
		dateFormat:"yy-mm-dd",
		dayNamesMin:["일", "월", "화", "수", "목", "금", "토"],
		monthNames:["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
		showMonthAfterYear:true,
		yearSuffix: "년"
	});

//	$('.date_pick input').focus( function() {
//		$( this ).val('');
//	});
	
	$('.date_pick input').keyup( function() {
		var validText = '';
		var text = $( this ).val();
		
		text = text.replace(/\-/g, '');
		text = text.replace(/[^0-9]/g, '');
		if ( text.length > 8 ) {
			text = text.substring( 0, 8 );
		}
		for ( var index = 0; index < text.length; index++ ) {
			if ( index === 4 || index === 6 ) {
				validText += '-';
			}
			var char = text.substring( index, index + 1 );
			validText += char;
		}
		$( this ).val( validText );
	});
	
	$(".date_pick .date_cell").blur(function(date) {
		var target = date.target;
		var targetId = date.target.id;
		var targetVal = $(date.target).val();
		var d = new Date(targetVal);
		var rtnDate = new Date();
		var rtn = rtnDate.getFullYear()+'-'+(rtnDate.getMonth()+1).fill(2)+'-'+rtnDate.getDate().fill(2);
		if (d=='Invalid Date' || isNaN(d.getTime()) || d.getTime()<1 || d.getTime()=='NaN' || targetVal.replace(/[^0-9]/g, "").length<8) {
			$(target).val(rtn);
		}
//		// console.log($(date.target).val()+", input date: " +d+ ", getTime: "+d.getTime()+ ", isNaN: "+isNaN(d.getTime()));
	});
});

// 조회일자 설정
function getDate(year, month, day) {
	let pickerDate = new Date();
	
	if (year != undefined && year != "") {
		pickerDate.setFullYear(pickerDate.getFullYear() + parseInt(year));
	}	
	if (month != undefined && month != "") {
		pickerDate.setMonth(pickerDate.getMonth() + parseInt(month));
	}
	if (day != undefined && day != "") {
		pickerDate.setDate(pickerDate.getDate() + parseInt(day));
    }
	
	return pickerDate;
}

// 시작/종료일자 검증 및 최대 검색일 체크
function dateValidator(start, end, period) {
	var startDate;
	var endDate;
	
//	// console.log("--- startDate: ["+ start + "]");
//	// console.log("--- endDate: ["+ end + "]");
	try {
		startDate = new Date(start);
	} catch (e) {
		// console.log("startDate: ["+ e + "]");
	}
	try {
		endDate = new Date(end);
	} catch (e) {
		// console.log("endDate: ["+ e + "]");
	}
//	var startDate = new Date(start);
//	var endDate = new Date(end);
	
//	// console.log("startDate: ["+ startDate + "], getTime: ["+isNaN(startDate.getTime()) +"]");
//	// console.log("endDate: ["+ endDate + "], getTime: ["+isNaN(endDate.getTime()) +"]");
	
	var term = endDate - startDate;
	if (-1<term) {
		term = (term/(1000*60*60*24)) +1;
	}

//	// console.log("dateValidator --> start date["+start+"] end date["+end+"] term["+period+"]");
//	// console.log("date gap is --> "+term);
	
	if (term<0) {
		LLYNX_Alert("시작일자가 종료일자보다 클 수가 없습니다.");
		return false;
	}
	if (term>period && typeof period != "undefined" && period !="") {
		LLYNX_Alert("최대 검색 기간은 " + period +"일입니다.");
		return false;
	}
	
	return true;
}