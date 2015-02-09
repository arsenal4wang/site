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
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=basePath%>skin/js/jquery.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>skin/css/main.css">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		var href = "getClassifyMenu.action";
		//	alert(href);
		// 清空，否则菜单会叠加，造成越来越长
		$("#classify").empty();
		$.getJSON(href, function(data) {
			if (data.success) {
				//		alert("success");
				// 显示一级菜单
				$.each(data.classify_menu, function(i, it) {
					$("#classify").append(
							"<option value=" + it.name + ">" + it.name
									+ "</option>");
				});
			} else {
				alert("服务器返回了未知的数据");
			}
		});
	});
</script>
<style type="text/css">
</style>
</head>
<body>
	<div class="container">
		<form action="uploadPro" enctype="multipart/form-data" method="post">
			<span class="warn"><s:property value="#request.error" /></span>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>资源分类：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<select name="classify" id="classify">
						<!--		<s:iterator value="list_class" status="status">
							<option value='<s:property value="%{name}" />'><s:property
									value="%{name}" /></option>
						</s:iterator>  -->
					</select>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>作者：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" id="textt" name="author" readonly
						value="${sessionScope.adminName}">
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>选择文件：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<s:file name="upload" />
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_file_textarea">
				<div class="left_file_textarea height_file_textarea">
					<span>文件描述：</span>
				</div>
				<div class="right_normal height_file_textarea position_left">
					<textarea name="fileInfo" style="width: 400px; height: 200px;"></textarea>
					<span style="color: red;">*100字以内</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal"></div>
				<div class="right_normal height_nomal position_left">
					<input type="submit" value="提交">
				</div>
			</div>
			<div class="border"></div>
		</form>
	</div>
</body>
</html>