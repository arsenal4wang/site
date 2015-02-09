<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="skin/css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="skin/js/jquery.min.js"></script>
<script type="text/javascript" src="skin/js/ent.js"></script>
<style type="text/css">
#demo {
	background: #FFF;
	overflow: hidden;
	border: 1px dashed #CCC;
	width: 690px;
	height:180px;
}

#demo img {
	border: 3px solid #F2F2F2;
}

#indemo {
	float: left;
	width: 800%;
}

#demo1 {
	float: left;
}

#demo2 {
	float: left;
}
</style>
</head>
<body>
	<div id="demo">
		<div id="indemo">
			<div id="demo1">
				<s:iterator value="gdpic" id="id">
					<a href='<s:property value="href"/>' target="_blank"><img width="240" height="180"
						alt="" src='<s:property value="picLocation"/>' border="0"></a>
					<!-- <s:property value="{href}"/> -->
				</s:iterator>
				<!-- 
				<a href="#"><img src="skin/phil/wall_s1.jpg" border="0" /></a> <a
					href="#"><img src="skin/phil/wall_s2.jpg" border="0" /></a> <a
					href="#"><img src="skin/phil/wall_s3.jpg" border="0" /></a> <a
					href="#"><img src="skin/phil/wall_s4.jpg" border="0" /></a> <a
					href="#"><img src="skin/phil/wall_s5.jpg" border="0" /></a> <a
					href="#"><img src="skin/phil/wall_s6.jpg" border="0" /></a> -->
			</div>
			<div id="demo2">
				<s:iterator value="gdpic" id="id">
					<a href='<s:property value="href"/>' target="_blank"> <img width="240" height="180"
						alt="" src='<s:property value="picLocation"/>' border="0">
					<!--  -->
					</a>
				</s:iterator>

				<a href="#"><img src="skin/phil/wall_s1.jpg" border="0" /></a>
				<!-- 
				<a href="#"><img src="skin/phil/wall_s2.jpg" border="0" /></a> <a
					href="#"><img src="skin/phil/wall_s3.jpg" border="0" /></a> <a
					href="#"><img src="skin/phil/wall_s4.jpg" border="0" /></a> <a
					href="#"><img src="skin/phil/wall_s5.jpg" border="0" /></a> <a
					href="#"><img src="skin/phil/wall_s6.jpg" border="0" /></a>-->
			</div>
		</div>
	</div>
	<script>
	<!--
		var speed = 25;
		var tab = document.getElementById("demo");
		var tab1 = document.getElementById("demo1");
		var tab2 = document.getElementById("demo2");
		tab2.innerHTML = tab1.innerHTML;
		function Marquee() {
			if (tab2.offsetWidth - tab.scrollLeft <= 0)
				tab.scrollLeft -= tab1.offsetWidth
			else {
				tab.scrollLeft++;
			}
		}
		var MyMar = setInterval(Marquee, speed);
		tab.onmouseover = function() {
			clearInterval(MyMar)
		};
		tab.onmouseout = function() {
			MyMar = setInterval(Marquee, speed)
		};
		-->
	</script>

</body>
</html>