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
			var secID = $("#subSecID").val();
			var secIDforSub = $("#firstSec").val();
			var sectionName = $("#firstSec").find("option:selected").text();
			var subNavName = $("#subNavName").val();
			var navOrder = $("#navOrders").val();
			var isContent = $("#isContent").val();
			var secLocate = $("#secLocate").val();
			var conOrder = $("#conOrder").val();
			var showUL = $('input[name="showUL"]:checked').val();

			alert(subNavName + "   subNavName");
			var content = {
				"showUL" : showUL,	
				"secID" : secID,
				"secIDforSub" : secIDforSub,
				"secName" : sectionName,
				"subNavName" : subNavName,
				"navOrder" : navOrder,
				"secLocate" : secLocate,
				"isContent" : isContent,
				"isFirst" : "N",
				"conOrder" : conOrder
			};
			$.ajax({
				type : "post",
				url : "updateSection.action",
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
				<span class="htitle" style="">修改二级模块</span>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>二级模块ID：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<input type="text" id="subSecID" style="width: 250px;"
					value="${secID}" readOnly>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>一级类别：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="firstSec">
					<option value="${secIDforSub}" selected>${secName}</option>
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
				<input type="text" id="subNavName" style="width: 250px;"
					value="${subNavName}">
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
				<input type="radio" name="showUL" value="3">教师&领导
				<input type="radio" name="showUL" value="4">暂无
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
					<option value="N" <s:if test='isContent=="N"' >selected</s:if>>否</option>
					<option value="Y" <s:if test='isContent=="Y"' >selected</s:if>>是</option>
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
					<option value="1" <s:if test='conOrder=="1"'>selected</s:if>>1</option>
					<option value="2" <s:if test='conOrder=="2"'>selected</s:if>>2</option>
					<option value="3" <s:if test='conOrder=="3"'>selected</s:if>>3</option>
					<option value="4" <s:if test='conOrder=="4"'>selected</s:if>>4</option>
					<option value="5" <s:if test='conOrder=="5"'>selected</s:if>>5</option>
					<option value="6" <s:if test='conOrder=="6"'>selected</s:if>>6</option>
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
					<option value="left"
						<s:if test='secLocate=="left"' >selected</s:if>>左</option>
					<option value="center"
						<s:if test='secLocate=="center"' >selected</s:if>>中</option>
					<option value="right"
						<s:if test='secLocate=="right"' >selected</s:if>>右</option>
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