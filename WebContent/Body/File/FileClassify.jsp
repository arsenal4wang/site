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
<script type="text/javascript" src="<%=basePath%>skin/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>skin/js/main.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>skin/css/base.css">
<link rel="stylesheet" href="<%=basePath%>skin/css/main.css">
<script type="text/javascript">
	
</script>
</head>

<body leftmargin="8" topmargin="8"
	background='<%=basePath%>skin/images/allbg.gif'>
	<div class="container" style="margin-top: 30px;">
		<form action="addFileClass" method="post">
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>资源分类：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" name="fileClassName" style="width: 250px;">
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal"></div>
				<div class="right_normal height_nomal position_left">
					<input type="submit" name="submit" value="确定">
				</div>
			</div>
		</form>
		<div style="margin-top: 30px;">
			<!--  列表   -->
			<table style="margin-top: 8px;">
				<tr bgcolor="#E7E7E7">
					<td width="100%" height="24" colspan="3"
						background="skin/images/tbg.gif">&nbsp;资源分类列表&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">ID</td>
					<td width="10%">资源分类</td>
					<td width="10%">操作</td>
				</tr>

				<s:iterator value="list_class" status="status">
					<tr align='center' bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#FCFDEE';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<td><s:property value="%{id}" /></td>
						<td><s:property value="%{name}" /></td>
						<td><s:a action="delFileClass"
								onclick="return checkClassifyDel();">
								<s:param name="fileClassID" value="%{id}"></s:param>删除</s:a>| <s:a
								action="modFileClass">
								<s:param name="fileClassID" value="%{id}"></s:param>
								<s:param name="fileClassNameMod" value="%{name}"></s:param> 修改</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</body>
</html>