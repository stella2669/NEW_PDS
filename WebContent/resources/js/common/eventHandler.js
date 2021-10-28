
// 키입력 막기
$(document).keydown(function(e) {
//	// console.log(e);
//	// console.log(e.target.nodeName);
	if (e.which===116) { // F5
		if (typeof event === "object") e.keyCode=0;
		return false;
	} else if (e.target.nodeName!="INPUT" && e.target.nodeName!="TEXTAREA"
				&& e.which===8) { // backspace
		if (typeof event === "object") e.keyCode=0;
		return false;
	} else if (e.ctrlKey && (e.which===78 || e.which===82)) {  // ctrl+N, ctrl+R
		return false;
	} else if (e.altKey && (e.which===37 || e.which===39)) {  // altl+<-, alt+->
		return false;
	}
});

// 마우스 우측버튼 막기
$(document).contextmenu(function(e) {
	return false;
});

// 브라우저 뒤로가기 막기
try {
	history.pushState(null, null, location.href);
	window.onpopstate = function() {
		history.go(1);
	}
} catch (e) {
//	// console.log("eventHandler.js --> "+ e);
}