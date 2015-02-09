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
<script type="text/javascript"
	src="<%=basePath%>/skin/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/skin/js/main.js"></script>
<link rel="stylesheet" href="<%=basePath%>/skin/css/main.css">
<script type="text/javascript">
	//menuseclect();
	$(function() {
		$("#secondCatSub").click(function() {
			var firstID = $("#firstSec").val();
			var firstSecName = $("#firstSec").find("option:selected").text();
			var SecondSecName = $("#secondSecName").val();
			var orders = $("#orders").val();
			var isContent = $("#isContent").val();
			var secLocate = $("#secLocate").val();

			//		alert(firstID);
			//		alert(firstSecName);
			//		alert(SecondSecName);
			//		alert(orders);
			//		alert(isContent);
			//		alert(secLocate);
			var content = {
				"firstID" : firstID,
				"firstSectionName" : firstSecName,
				"secondSecName" : SecondSecName,
				//	"secLocate" : secLocate,
				//	"isContent" : isContent,
				"orders" : orders
			};
			$.ajax({
				type : "post",
				url : "addSecSec.action",
				data : content,
				success : function() {
					window.location.href = "getSecList.action";
				},
			});
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
		<div class="height height_nomal">
			<div class="right_normal  position_left">
				<span class="htitle" style="">添加二级模块</span>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>一级类别：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="firstSec">
					<s:iterator value="listFirst" id="id">
						<option value="${firstID}"><s:property
								value="#id.firstSectionName" /></option>
					</s:iterator>
				</select>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>二级模块标题：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<input type="text" id="secondSecName" style="width: 250px;">
			</div>
		</div>
		<!-- 
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>显示位置：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<span>导航条中：</span><select id="secLocate" name="secLocate">
					<option value="yes">是</option>
					<option value="no">否</option>
				</select> <span class="green" style="padding-left: 70px;">*是否显示在二级导航条</span>
			</div>
		</div> 
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>显示位置：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<span>内容版块中：</span><select id="isContent" name="isContent">
					<option value="no">否</option>
					<option value="yes">是</option>
				</select> <span class="green" style="padding-left: 110px;">*是否同时显示在内容版块</span>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>内容版块位置：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="secLocate" name="secLocate">
					<option value="left">左</option>
					<option value="center">中</option>
					<option value="right">右</option>
				</select><span class="green" style="padding-left: 210px;">*当为内容版块时的位置。若只有两列，则只分左右</span>
			</div>
		</div>-->
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>导航排列顺序：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="orders" name="orders">
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
				</select> <span class="green" style="padding-left: 200px;">*导航条显示顺序</span>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>内容版块排列顺序：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="orders" name="contentOrder">
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
				</select> <span class="green" style="padding-left: 200px;">*内容显示顺序</span>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal"></div>
			<div class="right_normal height_nomal position_left">
				<input type="button" id="secondCatSub" value="确定">
			</div>
		</div>
	</div>
</body>
</html>