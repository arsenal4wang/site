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
<title>一级分类</title>
<script type="text/javascript" src="<%=basePath%>skin/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>skin/js/main.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>skin/css/base.css">
<link rel="stylesheet" href="<%=basePath%>skin/css/main.css">
<script type="text/javascript">
	
</script>
</head>

<body leftmargin="8" topmargin="8"
	background='<%=basePath%>skin/images/allbg.gif'>
	<div class="container" style="margin-top: 30px;">
		<form action="updateFileClass" method="post">
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>资源分类ID：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" name="fileClassID" style="width: 250px;"
						value="${requestScope.fileClassID}" readOnly>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>资源分类：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" name="fileClassName" style="width: 250px;"
						value="${requestScope.fileClassNameMod}">
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