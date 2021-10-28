/**
 *  팝업
 */

$(".drag").draggable({containment:"parent", handle:".popup_header"}).css("cursor","move").mousedown(function(){
	$(this).css("z-index", 12);
	$(this).siblings(".layer").css("z-index", 11);
});

// 모달 팝업을 띄운다
function modalOpen(id) {
	$("body").addClass("no_scroll");
	$("#blank_layer").show();

//	var this_id = $(this).attr("id");
	var this_id = id;
	var this_str = this_id.split("_");
	var this_num = this_str[1];
	var this_view = "#vmodal_" + this_str[1];

	var this_width = $(this_view).width() / 2;
	var this_height = $(this_view).height() / 2;
	var this_calc_w = "calc(50% - "+this_width+"px)";
	var this_calc_h = "calc(50% - "+this_height+"px)";

	$(this_view).show().css("z-index", 21).css('left',this_calc_w).css('top',this_calc_h);
}

// 모달 팝업을 닫는다.
function modalClose(obj) {
//	$(this).parents(".popup").hide();
	$(obj).parents(".popup").hide();
	$("body").removeClass("no_scroll");
	$("#blank_layer").hide();
}


//popup
$(function(){
	$(".drag").draggable({containment:"parent", handle:".popup_header"}).css("cursor","move").mousedown(function(){
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
		$("#blank_layer2").hide();
	});

});