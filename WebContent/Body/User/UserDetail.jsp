<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>一级分类</title>
<script type="text/javascript" src="skin/js/jquery.min.js"></script>
<script type="text/javascript" src="skin/js/main.js"></script>
<link rel="stylesheet" href="skin/css/main.css">
<script type="text/javascript">
	menuseclect();
	$(function() {
		$("#submit").click(function() {

			var username = $("#username").text();
			var firstCatName = $("#first_cat").find("option:selected").text();
			var firstCatID = $("#first_cat").val();
			var userID = $("#userID").text();
		//	alert(firstCatID);
			var content = {
				"userID" : userID,
				"firstCatID" : firstCatID,
				"firstCatName" : firstCatName
			};
			$.ajax({
				type : "post",//发送方式 
				url : "changeUserDetail.action",// 路径 
				data : content,
				success : function() {
					alert("修改成功！");
					window.location.href = "getUserList.action";
				},
				error : function() {
					alert("对不起,没有修改成功");
				}
			});
		});
		/*
		 */
	});
</script>
</head>
<body>
	<div class="container">

		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>用户ID：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<span id="userID"><s:property value="user.userID" /> </span>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>用户名称：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<span id="username"><s:property value="user.username" /> </span>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>用户权限：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<span id="userAuthority"> <s:property
						value="user.firstCatName" /></span>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>新权限：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="secFirst" name="firstID">
				</select>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal"></div>
			<div class="right_normal height_nomal position_left">
				<input type="button" id="submit" value="确定"> <input
					type="button" name="reset" value="重置">
			</div>
		</div>

	</div>
</body>
</html>