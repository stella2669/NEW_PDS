<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>

<%-- 공통 해더파일 include  --%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body class="login_bg">
 	<div class="loading" id="jspLoading">
		<div>
			<span class="loading_progress">
			<i class="lp_1"></i>
			<i class="lp_2"></i>
			<i class="lp_3"></i>
		</span>
			<p>처리중입니다. 잠시만 기다리세요.</p>
		</div>
	</div>

<!-- popup : start -->
	<div class="popup modal p_size_xs" id="vmodal_1">
		<c:import url="/WEB-INF/jsp/lo/ch/LOCH01.jsp" />
	</div>
	<div id="blank_layer"></div>
<!-- popup : end -->

	<div class="login_height_fix">
		<div class="login_wrap">

			<div class="login">
			    <h1 class="login_logo">WebTics</h1>
				<div class="login_header mt_50">
					<h2>PDS 캠페인 매니저 로그인</h2>
					<p class="info">서비스를 이용하시려면 로그인을 하셔야 합니다.</p>
				</div>
			    <form>
			    <fieldset class="login_body">
			        <legend>TM system member login</legend>
					<ul class="login_field">
						<li class="field_id">
							<label for="userId">아이디</label>
							<input type="text" name="userId" id="userId" placeholder="아이디">
							<i class="xi-user"></i>
						</li>
						<li class="field_pw">
							<label for="password">비밀번호</label>
							<input type="password" name="password" id="password" placeholder="비밀번호">
							<i class="xi-lock"></i>
						</li>
					</ul>
					<div class="login_save">
						<div>
							<input type="checkbox" name="saveUserId" id="saveUserId" class="chk_type04">
							<label for="saveUserId">아이디저장</label>
						</div>
					</div>
					<div class="login_button">
						<button type="button" class="btn_c4" name="login" id="login">로그인</button>
						<button type="button" class="btn_c2" id="tmodal_1" name="tmodal_1">비밀번호변경</button>
					</div>
			    </fieldset>
			    </form>
				<!-- <div class="login_footer">Copyright ⓒ2021 (주)링스테크 All rights reserved.</div> -->
			</div>

		</div>
	</div>

	<%-- 로그인 javascript load --%>
	<script type="text/javascript" src="<c:url value='/dwr/interface/LOIN01_Service.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lo/in/LOIN01.js?timestamp=${nowDate}'/>"></script>

	<%--  비밀번호 변경 javascript load --%>
	<script type="text/javascript" src="<c:url value='/dwr/interface/LOCH01_Service.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lo/ch/LOCH01.js?timestamp=${nowDate}'/>"></script>
</body>

<%-- 공통 푸터파일 include  --%>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />