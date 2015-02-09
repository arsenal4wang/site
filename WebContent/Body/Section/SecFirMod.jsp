<%@ page language="java" contentType="text/html; charset=GBK"
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
	
</script>
<style type="text/css">
.green {
	color: green;
}
</style>
</head>
<body>
	<div class="container">
		<form action="updateFirstCat" method="post">
			<div class="height height_nomal">
				<div class="right_normal  position_left">
					<span class="htitle" style="">添加一级模块</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>一级模块ID：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" name="firstID" style="width: 250px;"
						value="${requestScope.firstID}" readOnly>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>一级模块标题：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" name="firstSectionName" style="width: 250px;"
						value="${requestScope.firstSectionNameMod}">
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>显示位置：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<span> 导航条中：</span> <select id="isNav" name="isNav">
						<option value="yes">是</option>
						<option value="no">否</option>
					</select> <span class="green" style="padding-left: 100px;">*是否显示在导航条</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>显示位置：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<span> 内容版块中：</span> <select id="isContent" name="isContent">
						<option value="no" <s:if test='isContent=="no"' >selected</s:if>>否</option>
						<option value="yes" <s:if test='isContent=="yes"' >selected</s:if>>是</option>
					</select> <span class="green" style="padding-left: 85px;">*是否显示在内容版块</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>内容版块位置：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<select id="secLocate" name="secLocate">
						<option value="left"
							<s:if test='secLocate=="left"'>selected</s:if>>左</option>
						<option value="center"
							<s:if test='secLocate=="center"'>selected</s:if>>中</option>
						<option value="right"
							<s:if test='secLocate=="right"'>selected</s:if>>右</option>
					</select><span class="green" style="padding-left: 190px;">*当为内容版块时的位置。若只有两列，则只分左右</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>排列顺序：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<select id="locate" name="orders">
						<option value="1" <s:if test='orders=="1"'>selected</s:if>>1</option>
						<option value="2" <s:if test='orders=="2"'>selected</s:if>>2</option>
						<option value="3" <s:if test='orders=="3"'>selected</s:if>>3</option>
						<option value="4" <s:if test='orders=="4"'>selected</s:if>>4</option>
						<option value="5" <s:if test='orders=="5"'>selected</s:if>>5</option>
						<option value="6" <s:if test='orders=="6"'>selected</s:if>>6</option>
						<option value="7" <s:if test='orders=="7"'>selected</s:if>>7</option>
						<option value="8" <s:if test='orders=="8"'>selected</s:if>>8</option>
						<option value="9" <s:if test='orders=="9"'>selected</s:if>>9</option>
						<option value="10" <s:if test='orders=="10"'>selected</s:if>>10</option>
					</select> <span class="green" style="padding-left: 180px;">*内容显示或导航条显示顺序</span>
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