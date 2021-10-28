<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 공통 해더파일 include  --%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<%-- body 시작  --%>
<body>
<div class='popup_align'>
<div class="popup_window drag">
	<div class="popup_header">
		<h1>알림</h1>
	</div>
	<div class="popup_content">
		<!-- popup_body : start -->
		<div class="popup_body">
			<div class="popup_alert">
				<div class="popup_msg" id="msg" style="line-height:18px"></div>
			</div>
		</div>
		<!-- popup_footer : start -->
		<div class="popup_footer">
			<div class="button a_r">
				<button type="button" class="btn btn_third btn_size_n popup_close" id="alertClose">
					<i class="xi-check"></i>확인
				</button>
			</div>
		</div>
		<!-- popup_footer : end -->
	</div>
</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$("#alertClose").focus();
	});

	$("#alertClose").keyup(function(e){
		if(e.keyCode==13){
			$("#alertClose").click();
		}
	});

	$("#alertClose").click(function(){
		parent.alertClose();
	});
</script>

</body>

<%-- 공통 푸터파일 include  --%>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />