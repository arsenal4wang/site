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
	//menuseclect();
	$(function() {
		$("#secondCatSub").click(function() {
			var secID = $("#firstSec").val();
			var sectionName = $("#firstSec").find("option:selected").text();
			var subNavName = $("#subNavName").val();
			var navOrder = $("#navOrders").val();
			var isContent = $("#isContent").val();
			var secLocate = $("#secLocate").val();
			var conOrder = $("#conOrder").val();
			var showUL = $('input[name="showUL"]:checked').val();
			//alert(showUL);
			//		alert(firstID);
			//		alert(firstSecName);
			//		alert(SecondSecName);
			//		alert(orders);
			//		alert(isContent);
			//		alert(secLocate);
			var content = {
				"showUL" : showUL,
				"secIDforSub" : secID,
				"secName" : sectionName,
				"subNavName" : subNavName,
				"navOrder" : navOrder,
				"secLocate" : secLocate,
				"isContent" : isContent,
				"conOrder" : conOrder
			};
			$.ajax({
				type : "post",
				url : "addsubSection.action",
				data : content,
				success : function() {
					window.location.href = "getSecionNavList.action";
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
					<s:iterator value="listSection" id="id">
						<option value="${secID}"><s:property value="#id.secName" /></option>
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
				<input type="text" id="subNavName" style="width: 250px;">
			</div>
		</div>

		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>列出方式：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<input type="radio" name="showUL" value="1" checked>新闻列表
				<input type="radio" name="showUL" value="2">简介
				<input type="radio" name="showUL" value="3">教师
				<input type="radio" name="showUL" value="4">领导
				<span class="red" style="padding-left: 30px;">*如果选择“简介”，则单击二级模块时只显示最新消息，即简介性质</span>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>导航排列顺序：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="navOrders" name="navOrders">
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
				<span>显示位置：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<span> 内容版块中：</span> <select id="isContent" name="isContent">
					<option value="N">否</option>
					<option value="Y">是</option>
				</select> <span class="green" style="padding-left: 85px;">*是否显示在内容版块</span>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>内容版块排列顺序：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="conOrder" name="conOrder">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
				</select> <span class="green" style="padding-left: 200px;">*内容显示顺序</span>
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
				</select><span class="green" style="padding-left: 190px;">*当为内容版块时的位置。若只有两列，则只分左右</span>
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