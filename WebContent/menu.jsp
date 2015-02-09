<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>menu</title>
<link rel="stylesheet" href="skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="skin/css/menu.css" type="text/css" />
<script type="text/javascript" src="skin/js/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script language='javascript'>
	var curopenItem = '1';
</script>
<script language="javascript" type="text/javascript"
	src="skin/js/frame/menu.js"></script>
<base target="main" />
<script type="text/javascript">
	$(function() {
	});
</script>
</head>
<body target="main">
	<table width='99%' height="100%" border='0' cellspacing='0'
		cellpadding='0'>
		<tr>
			<td style='padding-left: 3px; padding-top: 8px' valign="top">
				<!-- Item 1 Strat --> <!-- Item 2 Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items2_2")'>
						<b>新闻管理</b>
					</dt>
					<dd style='display: block;' class="sitem" id="items2_2">
						<ul class='sitemu'>
							<li><a href='Body/News/NewsPublish.jsp' target='main'>添加新闻</a></li>
							<li><a href='newslist.action' target='main'>新闻列表</a></li>
							<li><a href='Body/News/PicSliderAdd.jsp' target='main'>添加轮播图片</a></li>
							<li><a href='getPicSliderList.action' target='main'>图片列表</a></li>
						</ul>
					</dd>
				</dl> <!-- Item 2 end --> <!-- Item 3 Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items3_3")'>
						<b>添加管理员</b>
					</dt>
					<dd style='display: block;' class='sitem' id='items3_3'>
						<ul class='sitemu'>
							<!-- WEB-INF/Body/Links/LinkAdd.jsp -->
							<s:if test="#session.authority==2">
								<li><a href='Error.jsp' target='main'>添加管理员</a></li>
								<li><a href='Error.jsp' target='main'>管理员列表</a></li>
							</s:if>
							<s:else>
								<li><a href='Body/User/UserAdd.jsp' target='main'>添加管理员</a></li>
								<li><a href='getUserList.action' target='main'>管理员列表</a></li>
							</s:else>
						</ul>
					</dd>
				</dl> <!-- Item 3 end --> <!-- Item 4 Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items4_4")'>
						<b>友情链接</b>
					</dt>
					<dd style='display: block;' class='sitem' id='items4_4'>
						<ul class='sitemu'>
							<!-- WEB-INF/Body/Links/LinkAdd.jsp -->
							<li><a href='Body/Links/LinkAdd.jsp' target='main'>添加友情链接</a></li>
							<li><a href='getLinkList.action' target='main'>友情链接列表</a></li>
						</ul>
					</dd>
				</dl> <!-- Item 4 end --> <!-- Item 5Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items1_5")'>
						<b>模块管理</b>
					</dt>
					<dd style='display: block;' class='sitem' id='items1_5'>
						<ul class='sitemu'>
							<s:if test="#session.authority==2">
								<li><a href='Error.jsp' target='main'>添加一级模块</a></li>
								<li><a href='Error.jsp' target='main'>添加二级模块</a></li>
								<li><a href='Error.jsp' target='main'>导航条列表</a></li>
							</s:if>
							<s:else>
								<li><a href='Body/Section/SectionAdd.jsp' target='main'>添加一级模块</a></li>
								<li><a href='getSecionList.action' target='main'>添加二级模块</a></li>
							<!-- 	<li><a href='getSecionCenterList.action' target='main'>添加LOGO</a></li> -->
								<li><a href='getSecionNavList.action' target='main'>导航条列表</a></li>
							</s:else>
						</ul>
					</dd>
				</dl> <!-- Item 5 end --> <!-- Item 6 Strat
				<dl class='bitem'>
					<dt onClick='showHide("items1_6")'>
						<b>资源管理</b>
					</dt>
					<dd style='display: block;' class='sitem' id='items1_6'>
						<ul class='sitemu'>
							<li><a href='getFileClassList.action' target='main'>资源分类列表</a></li>
							<li><a href='Body/File/FileUpload.jsp' target='main'>资源上传</a></li>
							<li><a href='filelist.action' target='main'>资源列表</a></li>
						</ul>
					</dd>
				</dl>  --><!-- Item 6 end --> <!-- Item 7 Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items1_7")'>
						<b>系统管理</b>
					</dt>
					<dd style='display: block;' class='sitem' id='items1_7'>
						<ul class='sitemu'>
							<s:if test="#session.authority==2">
								<li><a href='Error.jsp' target='main'>登录日志</a></li>
							</s:if>
							<s:else>
								<li><a href='userLog.action' target='main'>登录日志</a></li>
							</s:else>
						</ul>
					</dd>
				</dl> <!-- Item 7 end -->
				<!-- Item 8 Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items1_8")'>
						<b>职位&&人员管理</b>
					</dt>
					<dd style='display: block;' class='sitem' id='items1_8'>
						<ul class='sitemu'>
							<li><a href='Body/TeaALeader/TeacherLeaderSecAdd.jsp'
								target='main'>添加职位</a></li>
							<li><a href='getTLList.action' target='main'>职位列表</a></li>

							<li><a href='goAdd.action?addType=1' target='main'>添加教师</a></li>
							<li><a href='goAdd.action?addType=2' target='main'>添加领导</a></li>
							<li><a href='getTeaLeaList.action' target='main'>教师领导列表</a></li>
						</ul>
					</dd>
				</dl> <!-- Item 8 end -->
			</td>
		</tr>
	</table>
</body>
</html>