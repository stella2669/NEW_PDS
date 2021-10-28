<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<h1 class="logo"><a href="#">PDS_SYSTEM</a></h1>
	
	<div class="utils">
		<ul class="user">
			<li class="user_id circle">${sessionScope.PDS_USER_INFO.userNm}(${sessionScope.PDS_USER_INFO.userId})</li>
<%-- 			<li class="user_inwr circle">${sessionScope.PDS_USER_INFO.dn}</li> --%>
			<li class="button">
				<!-- <button type="button" class="btn btn_dark btn_size_xs" id="chgUserInfo" name="chgUserInfo">정보변경</button> --> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn_dark btn_size_xs" id="logOut" name="logOut">로그아웃</button>
			</li>
		</ul>
	</div>

<!-- gnb : start -->
	<nav id="gnb">
		<h2>메인메뉴</h2>
		
		<div id="frme_tabs" class="tabs tab_A0">
			<ul class="sub_tab_header">
				<li><a href="#frme_tabs-1">전체메뉴</a></li>
				<li>
					<a id="myMenuTab" href="#frme_tabs-2" style="padding-right:5px">마이메뉴</a>
					<button id="addMyMenu" class="close mr_5">
						<i class="xi-plus-circle"></i><span class="replace_text">마이메뉴추가</span>
					</button>
				</li>
			</ul>
			<!-- sub_tab_body : start -->
			<div id="frme_tabs-1" class="sub_tab_body ui-tabs-panel ui-corner-bottom ui-widget-content" style="padding:0px; border:none; border-top:1px solid">
				<ul id="allMenu"></ul>
			</div>
			
			
			<!-- sub_tab_body : start -->
			<div id="frme_tabs-2" class="sub_tab_body ui-tabs-panel ui-corner-bottom ui-widget-content" style="padding:0px; border:none; border-top:1px solid">
				<ul id="myMenu"></ul>
			</div>		
		</div>
		
	</nav>
<!-- gnb : end -->

	<button type="button" class="gnb_ctrl"><span class="replace_text">메인메뉴 닫기</span></button>
	
	<script>
		$("#frme_tabs").tabs();
	</script>