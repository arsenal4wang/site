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
</script>
<style type="text/css">
.green {
	color: green;
}
</style>
</head>
<body>
	<div class="container">
		<s:form action="updateSection" method="post">
			<input type="hidden" name="isFirst" value="Y">
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
					<input type="text" name="secID" style="width: 250px;" value="${secID}" readOnly>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>一级模块标题：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" name="secName" style="width: 250px;" value="${secName}">
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>显示位置：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<span> 导航条中：</span> <select id="isNav" name="isNav">
					<option value="N" <s:if test='isNav=="N"' >selected</s:if>>否</option>
					<option value="Y" <s:if test='isNav=="Y"' >selected</s:if>>是</option>
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
					<option value="N" <s:if test='isContent=="N"' >selected</s:if>>否</option>
					<option value="Y" <s:if test='isContent=="Y"' >selected</s:if>>是</option>
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
					<span>导航条排列顺序：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<select id="locate" name="navOrder">
					<option value="1" <s:if test='navOrder=="1"'>selected</s:if>>1</option>
					<option value="2" <s:if test='navOrder=="2"'>selected</s:if>>2</option>
					<option value="3" <s:if test='navOrder=="3"'>selected</s:if>>3</option>
					<option value="4" <s:if test='navOrder=="4"'>selected</s:if>>4</option>
					<option value="5" <s:if test='navOrder=="5"'>selected</s:if>>5</option>
					<option value="6" <s:if test='navOrder=="6"'>selected</s:if>>6</option>
					<option value="7" <s:if test='navOrder=="7"'>selected</s:if>>7</option>
					<option value="8" <s:if test='navOrder=="8"'>selected</s:if>>8</option>
					<option value="9" <s:if test='navOrder=="9"'>selected</s:if>>9</option>
					<option value="10" <s:if test='navOrder=="10"'>selected</s:if>>10</option>
					</select> <span class="green" style="padding-left: 180px;">*导航条显示顺序</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>内容版块排列顺序：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<select id="orders" name="conOrder">
					<option value="1" <s:if test='conOrder=="1"'>selected</s:if>>1</option>
					<option value="2" <s:if test='conOrder=="2"'>selected</s:if>>2</option>
					<option value="3" <s:if test='conOrder=="3"'>selected</s:if>>3</option>
					<option value="4" <s:if test='conOrder=="4"'>selected</s:if>>4</option>
					<option value="5" <s:if test='conOrder=="5"'>selected</s:if>>5</option>
					<option value="6" <s:if test='conOrder=="6"'>selected</s:if>>6</option>
					</select> <span class="green" style="padding-left: 180px;">*内容显示顺序</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal"></div>
				<div class="right_normal height_nomal position_left">
					<input type="submit" name="submit" value="确定">
				</div>
			</div>
		</s:form>
	</div>
</body>
</html>