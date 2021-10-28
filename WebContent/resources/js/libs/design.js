//tabs
$(document).ready(function(){

	var tabs = $("#tabs").tabs();

	function sizeTab_o(){
		var tab_count = $(".main_tab_header li").length;
		var tab_header = $(".main_tab_header").outerWidth();
		var tab_div = 100 / tab_count;
		var tab_min = Math.ceil(tab_header / tab_count);
		var tab_sum = 0;
		$(".main_tab_header li").each(function(index, item){
			var tab_W = $(item).outerWidth();
			tab_sum = tab_sum + tab_W;
			// if(tab_W < 40){ //40under
			// 	$(".main_tab_header .flow a").css("width", "10px").css("padding", "0");
			// 	$(".main_tab_header .flow").css("padding-right", "0");
			// }
		});

		if(tab_header < tab_sum){
			$(".main_tab_header li").css("max-width", tab_div+"%").css("min-width", tab_div+"%");
		}
	}

	function sizeTab_x(){
		var tab_count = $(".main_tab_header li").length;
		var tab_header = $(".main_tab_header").outerWidth();
		var tab_div = 100 / tab_count;
		var tab_min = Math.ceil(tab_header / tab_count);
		var tab_sum = 0;
		$(".main_tab_header li").each(function(index, item){
			var tab_W = $(item).outerWidth();
			tab_sum = tab_sum + tab_W;
			// if(tab_W > 40){ //40under
			// 	$(".main_tab_header .flow a").css("width", "auto").css("padding-right", "15px").css("padding-left", "15px");
			// 	$(".main_tab_header .flow").css("padding-right", "15px");
			// }
		});

		if(tab_min > 200){
			$(".main_tab_header li").css("max-width", "200px").css("min-width", "auto");
		} else {
			$(".main_tab_header li").css("max-width", tab_div+"%");
		}
	}

	$("#gnb .depth_2 li").click(function(){
		var link = $(this);
		var tabs_id = "tabs-" + $(link).attr("id");
		var find_id = $("[id="+tabs_id+"]").attr("id");
		var tab_id = "#" + tabs_id;

		function orderTab(){
			var ariactrl = "[aria-controls="+tabs_id+"]";
			$(ariactrl).insertAfter("#tab_fix");
			tabs.tabs("refresh");
			tabs.tabs("option", "active", id2Index("#tabs .main_tab_header", tab_id));
		}

		if( find_id == tabs_id ){
			orderTab();
		}else{
			addTab(link);
			orderTab();
		}

		sizeTab_o();
	});

	function id2Index(tabsId, srcId){
		var index = -1;
		var i = 0, tbH = $(tabsId).find("li a");
		var lntb = tbH.length;
		if(lntb>0){
			for(i=0; i<lntb; i++){
				// // console.log(lntb);
				// // console.log(i);
				o = tbH[i];
				if(o.href.search(srcId)>0){
					index = i;
					// // console.log(o);
					// // console.log("a"+i);
				}
			}
		}
		return index;
	}

	tabs.on("click", ".tab_close", function(){
		var panelId = $(this).closest("li").remove().attr("aria-controls");
		$("#"+panelId).remove();
		sizeTab_x();
		tabs.tabs("refresh");
	});

	function addTab(link){
		var label = $(link).text();
		var id = "tabs-" + $(link).attr("id");
		var rel = $(link).attr("rel");
		var li = "<li class='flow'><a href='#"+id+"'>"+label+"</a><button type='button' class='tab_close'><i class='xi-close'></i><span class='replace_text'>닫기</span></button><span class='tooltip'>"+label+"</span></li>";
		var tabContentHtml = "tabContentHtml "+id;

		// ajax 실행
		// $.ajax({
		// 	type : "POST",
		// 	url : rel, // controller로 갈 url
		// 	async:false, // tabContentHtml이 전역변수이기 떄문에 false값을 준다
		// 	dataType : "html", // 받아올 데이터타입은 html
		// 	success : function(data){ // tabContentHtml에 넘어온 data값을 준다 결국 jsp 파일을 html형식으로 tabContentHtml이 들어가는 것
		// 		tabContentHtml = data;
		// 	}
		// });

		tabs.find(".main_tab_header").append(li);
		tabs.append("<div id='"+id+"' class='main_tab_body'>"+tabContentHtml+"</div>")
		tabs.tabs("refresh");
		// tabs.tabs("option", "active", $("#tab_header").index());
	}
});


//popup
$(function(){
	$(".drag").draggable({containment:"parent"}).css("cursor","move").mousedown(function(){
		$(this).css("z-index", 12);
		$(this).siblings(".layer").css("z-index", 11);
	});

	$(".open_modal").click(function(e){
		e.preventDefault();

		$("body").addClass("no_scroll");
		$("#blank_layer").show();

		var this_id = $(this).attr("id");
		var this_str = this_id.split("_");
		var this_num = this_str[1];
		var this_view = "#vmodal_" + this_str[1];

		var this_width = $(this_view).width() / 2;
		var this_height = $(this_view).height() / 2;
		var this_calc_w = "calc(50% - "+this_width+"px)";
		var this_calc_h = "calc(50% - "+this_height+"px)";

		$(this_view).show().css("z-index", 21).css('left',this_calc_w).css('top',this_calc_h);


		// $("#blank_layer").click(function(){
		// 	$(".popup_close").trigger("click");
		// });
	});


	$(".open_layer").click(function(e){
		e.preventDefault();
		var this_id = $(this).attr("id");
		var this_str = this_id.split('_');
		var this_num = this_str[1];
		var this_view = "#vlayer_" + this_str[1];

		var this_width = $(this_view).width() / 2;
		var this_height = $(this_view).height() / 2;
		var this_calc_w = "calc(50% - "+this_width+"px)";
		var this_calc_h = "calc(50% - "+this_height+"px)";

		$(this_view).show().css("z-index", 11).css('left',this_calc_w).css('top',this_calc_h);

		if ($(this_view).hasClass("inner_popup")) {
			$(this_view).css("z-index", 12);
		}

	});

	$(".popup_close").click(function(e){
		e.preventDefault();
		$(this).parents(".popup").hide();
		$("body").removeClass("no_scroll");
		$("#blank_layer").hide();
	});

});


$(function(){
	//gnb
	$(".gnb_ctrl").click(function(e){
		e.preventDefault();

		if($(this).hasClass("mode_wide")){
			$("#container , #header , .gnb_ctrl").removeClass("mode_wide");
			$(".gnb_ctrl span").text("메인메뉴 닫기")
		} else {
			$("#container , #header , .gnb_ctrl").addClass("mode_wide");
			$(".gnb_ctrl span").text("메인메뉴 열기")
		}
	});

	//accordion
	$(".accordion > span").click(function(e){
	    e.preventDefault();
	    if($(this).parents(".accordion").hasClass("active")) {
	        $(this).parents(".accordion").removeClass("active");
	        $(this).parents(".accordion").find("ul").slideUp(100);
	    } else {
	        $(".accordion").removeClass("active");
	        $(this).parents(".accordion").addClass("active");
	        $(".accordion > ul").parent().not(this).find("ul").slideUp(100);
	        $(this).parents(".accordion").find("ul").slideToggle(100);
	    }
	});


	//ctrl_box test
	$(".ctrl_box button").click(function(e){
	    e.preventDefault();
		if($(this).hasClass("disable")) {

		} else {
			var ctrl_name = $(this).text();
			$(".state_box .info").text(ctrl_name);


			if($(this).hasClass("alt")) {
				$(".expand .select span").text(ctrl_name);
				$(".expand").removeClass("active");
			}

			// if($(this).hasClass("btn_c1")) {
			// 	$(".state_box").attr("class","state_box c_green");
			// }
			//
			// if($(this).hasClass("btn_c2")) {
			// 	$(".state_box").attr("class","state_box c_dark");
			// }
			//
			// if($(this).hasClass("btn_c3")) {
			// 	$(".state_box").attr("class","state_box c_blue");
			// }
			//
			// if($(this).hasClass("btn_c4")) {
			// 	$(".state_box").attr("class","state_box c_red");
			// }
		}
	});

	//ctrl_box expand_btn test
	// $(".expand .select").click(function(e){
	// 	e.preventDefault();
	// 	if($(this).parents(".expand").hasClass("active")){
	// 		$(".expand").removeClass("active");
	// 	} else {
	// 		$(".expand").addClass("active");
	// 	}
	// });

	$(".expand").mouseover(function(e){
		e.preventDefault();
		$(".expand").addClass("active");
	});
	$(".expand").mouseout(function(e){
		e.preventDefault();
		$(".expand").removeClass("active");
	});

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
	$(function(){
		$(".byte_chk").keyup(function(){
			bytesHandler(this);
		});
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

	function bytesHandler(obj){
		var text = $(obj).val();
		$(".byte_info").text(getTextLength(text));
	}
	//byte_chk -end

});


//timer
$(function(){
	var time = "";
	var set_time = setInterval(function(){
		var hour = parseInt(time/3600);
		var min = parseInt((time%3600)/60);
		var sec = time%60;

		if(hour.toString().length==1) hour = "0"+hour;
		if(min.toString().length==1) min = "0"+min;
		if(sec.toString().length==1) sec = "0"+sec;

		$(".timer").text(hour+":"+min+":"+sec);
		time++;
	}, 1000);
});

//datepicker
$(function(){
	$(".date_pick .date_cell").datepicker({
		dateFormat:"yy-mm-dd",
		dayNamesMin:["일", "월", "화", "수", "목", "금", "토"],
		monthNames:["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
		showMonthAfterYear:true,
		yearSuffix: "년",
		minDate: '0'
	});
});
