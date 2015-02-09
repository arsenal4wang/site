<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中央民族大学哲学与宗教学院</title>
<link href="skin/css/common.css" rel="stylesheet" type="text/css">
<link href="skin/css/ent.css" rel="stylesheet" type="text/css">
<link href="skin/css/home.css" rel="stylesheet" type="text/css">
<link href="skin/css/main.css" rel="stylesheet" type="text/css">
<link href="skin/css/pages.css" rel="stylesheet" type="text/css">
<link href="skin/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="skin/js/jquery.min.js"></script>
<script type="text/javascript" src="skin/js/ent.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">

	$(function() {
		getVisitTime();
		getDate();
	});
</script>
</head>
<body>
	<div class="top_bar">
		<div class="wapper">
			<span class="tsbox">欢迎来到中央民族大学哲学与宗教学学院！今天是<em><span
					id="date"></span></em><em><span id="day"></span></em><em>浏览统计：<span id="statistic"></span>次</em></span>
			<ul>
				<li><span class="chs">中文版</span></li>
				<li><a class="english" target="_blank" href="#">English</a></li>
				<li><a class="english" target="_blank" href="#">联系我们</a></li>
				<li><a class="english" target="_blank"
					href="http://phil.muc.edu.cn/">旧版入口</a></li>
			</ul>
			<div class="clr"></div>
		</div>
	</div>
</body>
</html>