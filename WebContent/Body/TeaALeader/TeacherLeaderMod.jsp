<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<title>新闻发布</title>

<script type="text/javascript" src="<%=basePath%>skin/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>skin/js/main.js"></script>
<link rel="stylesheet" href="<%=basePath%>skin/css/main.css">
<style type="text/css">
body {
	font-size: 10px;
}

.container {
	width: 960px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div class="container">
		<form action="tlUpdate" method="post">
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>职位ID：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input name="tlID" type="text" value="${tlID}">
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>职位名称：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input name="tlName" type="text" value="${tlNameMod}">
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>职位类别：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="radio" value="2" name="tlType" checked>领导职位 <input
						type="radio" value="1" name="tlType">教师职位
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>显示顺序：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<select id="locate" name="tlOrder">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select> <span class="green" style="padding-left: 180px;">*显示顺序</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal"></div>
				<div class="right_normal height_nomal position_left">
					<input type="submit" name="submit" value="确定">
				</div>
			</div>
			<div class="border"></div>
		</form>
	</div>

</body>
</html>