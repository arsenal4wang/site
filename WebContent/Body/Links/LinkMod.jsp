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
<script type="text/javascript" src="<%=basePath%>/skin/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/skin/js/main.js"></script>
<link rel="stylesheet" href="<%=basePath%>/skin/css/main.css">
<script type="text/javascript">
$(function(){
	$("form").submit(function() {
		var linkOrder = $("#linkOrder").val();
	//	alert(linkOrder);
		if (!isNaN(linkOrder)) {
		//	alert("数字");
			if(linkOrder>100){
				alert("排列顺序应小于100！");
				return false;
			}
		} else {
			alert("请正确输入数字！");
			return false;
		}
	});
});
</script>
<style type="text/css">
.green {
	color: green;
}
</style>	
</head>
<body>
	<div class="container">
		<form action="updateLink" method="post">
			<div class="height height_nomal">
				<div class="right_normal  position_left">
					<span class="htitle" style="">修改链接</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>链接ID：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" name="webID" style="width: 250px;"
						value="${webID}" readOnly>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>网站名称：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" name="webName" style="width: 250px;"
						value='<s:property value="webName"/>'>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>网站网址：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" name="webAddr" style="width: 250px;"
						value="${webAddr}">
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>排列顺序：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" name="linkOrder" id="linkOrder" value="${linkOrder}" style="width: 250px;">
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