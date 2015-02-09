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
<script type="text/javascript" src="skin/js/showDiv.js"></script>
<script type="text/javascript" src="skin/js/marquee/demo.js"></script>

<script type="text/javascript">
	function teacher_show() {
		$("#teacher").attr("class", "szbtn2");
		$("DIV[class='xylist']").show();
	}
	function teacher_hid() {
		$("#teacher").attr("class", "szbtn");
		$("DIV[class='xylist']").hide();
	}
	$(function() {

	});
</script>

<style type="text/css">
.scroll div {
	height: 30px;
}
</style>
</head>
<body>
	<h2>学院快讯</h2>
	<div>
		<ul>
			<marquee onmouseover="stop()" onmouseout="start()" direction="up"
				scrollamount="2" width="232" height="185">
				<s:iterator value="listNewsNew" var="ll">
					<li><s:a title="%{titleFake}" target="_blank"
							action="readNews.action">
							<s:param name="newsID" value="newsID"></s:param>
							<s:param name="navID" value="secFirstID"></s:param>
							<s:param name="secID" value="secSecID"></s:param>
												[<s:property value="%{secFirstName}" />]<s:property
								value="%{newsTitle}" />
							<s:if test="%{#ll.latest=='newer'}">
								<img class="new" alt="" src="skin/images/new.gif">
							</s:if>
							<span><s:property value="%{subDate}" /></span>
						</s:a></li>
				</s:iterator>
			</marquee>
		</ul>
	</div>
</body>
</html>