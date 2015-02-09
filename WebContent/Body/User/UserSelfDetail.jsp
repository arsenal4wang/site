<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>一级分类</title>
<script type="text/javascript" src="<%=basePath%>skin/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>skin/js/main.js"></script>
<link rel="stylesheet" href="<%=basePath%>skin/css/main.css">
<script type="text/javascript">
	$(function() {
		var s = $("#hidden").val();
		$("form").submit(function(e) {
			var p1 = $("#password").val();
			var p2 = $("#password2").val();
			if (p1 != p2) {
				e.preventDefault();
				alert("两次密码输入不同！");
			} else {
				alert("修改成功！");
			}
		});
	});
</script>
</head>
<body>
	<div class="container">
		<form action="changePassword.action" method="post">
			<input type="hidden" name="adminName" id="hidden"
				value='${session.username}'> <input type="hidden"
				name="adminIDStr" id="hidden" value='${session.userID}'>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>新密码：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" name="password" id="password"
						style="width: 250px;">
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>重复密码：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" id="password2" style="width: 250px;">
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal"></div>
				<div class="right_normal height_nomal position_left">
					<input type="submit" name="submit" value="确定">
				</div>
			</div>
		</form>
	</div>
</body>
</html>