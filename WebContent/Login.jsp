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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" href="<%=basePath%>skin/css/main.css">
<title>管理登陆</title>
<script type="text/javascript">
	function loadTopWindow() {
		if (window.top != null && window.top.document.URL != document.URL) {

			var url = document.URL;
			var start = url.lastIndexOf(".");
			var temp = url.substring(start + 1);
			if (temp == "jsp")
				window.top.location = "../../logout.action";
			else
				window.top.location = "logout.action";
		}
	}
</script>
<style type="text/css">
body {
	background: #9ad075;
	margin: 0 auto;
	width: 500px;
}

.STYLE1 {
	font-size: 11pt;
	font-weight: bold;
}

.Login_text {
	height: 25px;
	width: 200px;
	font-size: 15pt;
	font-weight: bold;
}

#Login_sub {
	width: 130px;
	height: 30px;
	background: url(skin/images/admin_login_button.png);
	border: 0;
	background-color: transparent;
}
</style>
</head>

<body onload="loadTopWindow()">
	<!--  	<div class="container">
		<div
			style="width: 100px; text-align: center; background-color: yellow; font-size: 20px;">
			<span><s:property value="#request.loginerror" /></span>
		</div>
	</div>-->
	<div id="login_div">
		<form action="adminLogin" method="post">
			<table id="Login_table">
				<tr>
					<td width="250">&nbsp;</td>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td height="40"><div align="right" class="STYLE1">用户名：</div></td>
					<td height="40" colspan="2"><input class="Login_text"
						type="text" name="adminName" value='' /></td>
				</tr>
				<tr>
					<td height="40"><div align="right" class="STYLE1">密&nbsp;
							码：</div></td>
					<td height="40" colspan="2"><input class="Login_text"
						type="password" name="password" style="" /></td>
				</tr>
				<!-- 
				<tr>
					<td height="40"><div align="right" class="STYLE1">验证码：</div></td>
					<td width="100" height="40"><input type="text"
						name="textfield3"
						style="height: 25px; width: 85px; font-size: 15pt; font-weight: bold;" /></td>
					<td width="150">&nbsp;</td>
				</tr> -->
				<tr>ba
					<td height="40">&nbsp;</td>
					<td height="40" colspan="2"><input type="submit" name="Submit"
						value="" id="Login_sub" style="" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

