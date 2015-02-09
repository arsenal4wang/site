<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>main</title>
<base target="_self">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>skin/css/base.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>skin/css/main.css" />
</head>
<body leftmargin="8" topmargin='8'>
	<table width="98%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><div style='float: left'>
					<img height="14" src="<%=basePath%>skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用内容管理系统
				</div>
				<div style='float: right; padding-right: 8px;'>
					<!--  //保留接口  -->
				</div></td>
		</tr>
		<tr>
			<td height="1" background="../skin/images/frame/sp_bg.gif"
				style='padding: 0px'></td>
		</tr>
	</table>
	<table width="98%" align="center" border="0" cellpadding="3"
		cellspacing="1" bgcolor="#CBD8AC"
		style="margin-bottom: 8px; margin-top: 8px;">
		<tr>
			<td background="<%=basePath%>skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
				class='title'><span>消息</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td>&nbsp;</td>
		</tr>
	</table>
	<table width="98%" align="center" border="0" cellpadding="4"
		cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
		<tr>
			<td colspan="2" background="<%=basePath%>skin/images/frame/wbg.gif"
				bgcolor="#EEF4EA" class='title'>
				<div style='float: left'>
					<span>快捷操作</span>
				</div>
				<div style='float: right; padding-right: 10px;'></div>
			</td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td height="30" colspan="2" align="center" valign="bottom"><table
					width="100%" border="0" cellspacing="1" cellpadding="1">
					<tr>
						<td width="15%" height="31" align="center"><img
							src="<%=basePath%>skin/images/frame/qc.gif" width="90" height="30" /></td>
						<td width="85%" valign="bottom"><div class='icoitem'>
								<div class='ico'>
									<img src='<%=basePath%>skin/images/frame/addnews.gif' width='16' height='16' />
								</div>
								<div class='txt'>
									<a href='newslist.action'><u>新闻列表</u></a>
								</div>
							</div>
							<div class='icoitem'>
								<div class='ico'>
									<img src='<%=basePath%>skin/images/frame/manage1.gif' width='16' height='16' />
								</div>
								<div class='txt'>
									<a href='NewsPublish.jsp'><u>内容发布</u></a>
								</div>
							</div>
							<div class='icoitem'>
								<div class='ico'>
									<img src='<%=basePath%>skin/images/frame/file_dir.gif' width='16'
										height='16' />
								</div>
								<div class='txt'>
									<a href='getClassifyList.action'><u>栏目管理</u></a>
								</div>
							</div></td>
					</tr>
				</table></td>
		</tr>
	</table>
	<table width="98%" align="center" border="0" cellpadding="4"
		cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
		<tr bgcolor="#EEF4EA">
			<td colspan="2" background="skin/images/frame/wbg.gif" class='title'><span>系统基本信息</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td width="25%" bgcolor="#FFFFFF">您的级别：</td>
			<td width="75%" bgcolor="#FFFFFF">${sessionScope.authority}</td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td>您的部门：</td>
			<td>${sessionScope.firstName}</td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td>本次登录IP：</td>
			<td>${sessionScope.LoginIP}</td>
		</tr>
	</table>
</body>
</html>