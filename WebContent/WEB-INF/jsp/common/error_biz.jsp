<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error_login</title>
</head>
<body>
	<script  type="text/javascript">
// TODO 메세지 처리
		var error = "${message}";
		if (error == null || typeof error == "undefined" || error == "") {
			error = "요청처리중 오류가 발생되었습니다.\n잠시후 다시 시도하세요.";
		}
		alert(error);
		history.back();
	</script>
	
</body>
</html>