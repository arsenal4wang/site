<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"></meta>
<title>top</title>
<link href="skin/css/base.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="skin/js/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("ul li").click(function() {
			$("ul li").removeClass("itemsel");
			$("ul li").addClass("item");
			var id = $(this).attr("id");
			$("#" + id).removeClass("item");
			$("#" + id).addClass("itemsel");
		});
	});
	$(document).ready(function() {
		var hidden = $("#hidden").val();
		//	alert(hidden);
		if (hidden == null) {
			//	window.location.href="Login.jsp";
		}
	});
</script>
</head>
<body style="background-color: #ffffff">
	<input type="hidden" value='${sessionScope.username}' id="hidden">
	<div
		style="width: 100%; height: 60px; background: url(skin/images/frame/topbg.gif);">
		<div style="width: 20%; height: 40px; float: left;">
			<a href="main.jsp" target='main'> <img
				src="skin/images/frame/logo.gif" alt="LOGO" /></a>
		</div>
		<div style="width: 80%; height: 40px; float: right;">
			<div style="float: right;">
				<div>
					您好：<span class="username">${sessionScope.adminName}</span>，欢迎使用内容管理系统！
					您的权限为：<!--  ${sessionScope.authority}-->
					<s:if test="#session.authority==2">普通管理员</s:if>
					<s:elseif test="#session.authority==1">高级管理员</s:elseif>
					<s:elseif test="#session.authority==0">超级管理员</s:elseif>
					[<a href="Body/User/UserSelfDetail.jsp" target="main">修改密码</a>] [<a
						id="logout" href="logout.action" target="_top">注销退出</a>]&nbsp;
				</div>
			</div>
			<!--  	<div style="float: left; margin-top: 30px;">
				<ul>
					<li class='float_left itemsel' id='item1'><a href="#">主菜单</a></li>
					<li class='float_left item' id='item2'><a href="#">内容发布</a></li>
					<li class='float_left item' id='item3'><a href="#">内容发布2</a></li>
					<li class='float_left item' id='item4'><a href="#">内容发布3</a></li>
				</ul>
			</div>-->
		</div>
	</div>
</body>
</html>