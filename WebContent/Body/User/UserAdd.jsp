<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../skin/js/jquery.min.js"></script>
<script type="text/javascript" src="../../skin/js/main.js"></script>
<link rel="stylesheet" href="../../skin/css/main.css">
<script type="text/javascript">
//	menuseclect();
	$(function() {
		var flag;
		$("#different").hide();
		$("#notexsit").hide();
		$("#exsit").hide();
		$("#passwordempty").hide();
		$("#empty").hide();

		$("#adminUser").blur(function() {
			checkusername();
		});
		$("form").submit(function() {
			var username = $("#username").val();
			if (username == "") {
				$("#empty").show();
				return false;
			} else if (checkPassword()) {
				return true;
			} else {
				return false;
			}
		});
	});
	function checkPassword() {
		var password1 = $("#password1").val();
		var password2 = $("#password2").val();
		if (password1 == "" || password2 == "") {
			$("#different").hide();
			$("#passwordempty").show();
			return false;
		} else if (password1 == password2) {
			$("#passwordempty").hide();
			$("#different").hide();
			return true;
		} else {
			$("#passwordempty").hide();
			$("#different").show();
			return false;
		}
	}
	
</script>
</head>
<body>

	<div class="container">
		<form action="addUser" method="post">
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>权限：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="radio" name="authority" value="1">高 <input
						type="radio" name="authority" value="2" checked>普通
				</div>
			</div>
	<!-- 		<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>所属部门：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<select id="secFirst" name="firstID">
					</select>
				</div>
			</div> -->
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>用户名：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input id="adminUser" type="text" name="adminName"><span
						id="exsit" class="red">该帐号已经存在</span><span id="notexsit"
						class="green">恭喜，该帐号尚未注册</span><span id="empty" class="red">请输入帐号</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>密码：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input id="password1" type="text" name="password"><span
						id="different" class="red">两次密码输入不同</span><span id="passwordempty"
						class="red">请输入密码</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>再次输入密码：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input id="password2" type="text" name="password2">
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal"></div>
				<div class="right_normal height_nomal position_left">
					<input type="submit" id="submit" value="确定"> <input
						type="button" name="reset" value="重置">
				</div>
			</div>
			<div class="border"></div>
		</form>
	</div>
</body>
</html>