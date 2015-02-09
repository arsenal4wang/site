<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>内容管理系统</title>
<script type="text/javascript" src="skin/js/jquery.min.js"></script>
<link rel="stylesheet" href="skin/css/base.css">

<style>
body {
	scrollbar-base-color: #C0D586;
	scrollbar-arrow-color: #FFFFFF;
	scrollbar-shadow-color: DEEFC6;
}
</style>
<script type="text/javascript">
	$(function() {
	});
</script>
</head>
<frameset rows="60,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="top.jsp" name="topFrame" scrolling="no">
	<frameset cols="180,*" name="btFrame" frameborder="NO" border="0"
		framespacing="0">
		<frame src="menu.jsp" noresize name="menu" scrolling="yes">
		<frame src="main.jsp" noresize name="main" scrolling="yes">
	</frameset>
</frameset>
<body>
</body>

</html>