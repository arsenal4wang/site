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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>skin/css/base.css">
<script type="text/javascript" src="<%=basePath%>/skin/js/main.js"></script>
<script type="text/javascript" src="<%=basePath%>/skin/js/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkClassifyDel() {
		if (confirm("该分类下文章也都将被删除！")) {
		} else {
			return false;
		}
	}
</script>
<style type="text/css">
img {
	vertical-align: middle;
	padding-bottom: 3px;
}

.pagination {
	padding-left: auto;
	padding-right: auto;
	width: 12%;
}

.page li {
	float: left;
	padding-right: 5px;
}

#stastic {
	width: 12%;
	float: right;
}
</style>
</head>

<body leftmargin="8" topmargin="8" background='../skin/images/allbg.gif'>
	<div class="flow-container">
		<!--  快速转换位置按钮  
		<div class="top_button">
			<input type='button' class="coolbg np" onClick="location='';"
				value='添加文档' /> <input type='button' class="coolbg np"
				onClick="location='';" value='我的文档' /> <input type='button'
				class='coolbg np' onClick="location='';" value='稿件审核' /> <input
				type='button' class="coolbg np" onClick="location='';" value='栏目管理' />
			<input type='button' class="coolbg np" onClick="location='';"
				value='更新列表' /> <input type='button' class="coolbg np"
				onClick="location='';" value='更新文档' /> <input type='button'
				class="coolbg np" onClick="location='';" value='文章回收站' />
		</div>-->
		<!--  内容列表   -->
		<table style="margin-top: 8px;">
			<tr bgcolor="#E7E7E7">
				<td width="100%" height="24" colspan="5"
					background="skin/images/tbg.gif">&nbsp;教师列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">教师ID</td>
				<td width="10%">姓名</td>
				<td width="4%">职位ID</td>
				<td width="10%">职位</td>
				<td width="10%">操作</td>
			</tr>

			<s:iterator value="teaLea_list2" id="id" status="status">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><s:property value="%{teaLeaID}" /></td>
					<td><s:property value="%{teaLeaName}" /></td>
					<td><s:property value="%{tlID}" /></td>
					<td><s:property value="%{tlName}" /></td>
					<td><s:a action="delTeacher.action">
							<s:param name="teaLeaID" value="%{teaLeaID}"></s:param>删除</s:a>|<s:a
							action="modTeacher.action">
							<s:param name="teaLeaID" value="%{teaLeaID}"></s:param>
							<s:param name="teaLeaNameMod" value="%{teaLeaName}"></s:param>
							修改</s:a></td>
				</tr>
			</s:iterator>
		</table>
		<!--  内容列表   -->
		<table style="margin-top: 8px;">
			<tr bgcolor="#E7E7E7">
				<td width="100%" height="24" colspan="5"
					background="skin/images/tbg.gif">&nbsp;领导列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">领导ID</td>
				<td width="10%">姓名</td>
				<td width="4%">职位ID</td>
				<td width="10%">职位</td>
				<td width="10%">操作</td>
			</tr>

			<s:iterator value="teaLea_list" id="id" status="status">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><s:property value="%{teaLeaID}" /></td>
					<td><s:property value="%{teaLeaName}" /></td>
					<td><s:property value="%{tlID}" /></td>
					<td><s:property value="%{tlName}" /></td>
					<td><s:a action="delLeader.action">
							<s:param name="teaLeaID" value="%{teaLeaID}"></s:param>删除</s:a>|<s:a
							action="modLeader.action">
							<s:param name="teaLeaID" value="%{teaLeaID}"></s:param>
							<s:param name="teaLeaNameMod" value="%{teaLeaName}"></s:param>
							修改</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>