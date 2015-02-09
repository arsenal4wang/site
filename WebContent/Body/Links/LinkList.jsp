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
<link rel="stylesheet" type="text/css" href="<%=basePath %>skin/css/base.css">
<script type="text/javascript" src="<%=basePath %>/skin/js/main.js"></script>
<script type="text/javascript" src="<%=basePath %>/skin/js/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkClassifyDel() {
		if (confirm("该网址将被删除！")) {
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
		<!--  快速转换位置按钮  -->
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
		</div>
		<!--  内容列表   -->
		<table style="margin-top: 8px;">
			<tr bgcolor="#E7E7E7">
				<td width="100%" height="24" colspan="5"
					background="skin/images/tbg.gif">&nbsp;第一模块列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="6%">链接ID</td>
				<td width="10%">链接标题</td>
				<td width="10%">链接地址</td>
				<td width="6%">排列顺序</td>
				<td width="10%">操作</td>
			</tr>

			<s:iterator value="link_list" status="status">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><s:property value="%{webID}" /></td>
					<td><s:property value="%{webName}" /></td>
					<td><s:property value="%{webAddr}" /></td>
					<td><s:property value="%{linkOrder}" /></td>
					<td><s:a action="delLink.action"
							onclick="return checkClassifyDel();">
							<s:param name="webID" value="%{webID}"></s:param>删除</s:a>|<s:a
							action="modLink.action">
							<s:param name="webID" value="webID"></s:param>
							<s:param name="webName" value="webName"></s:param>
							<s:param name="webAddr" value="webAddr"></s:param>
							<s:param name="linkOrder" value="linkOrder"></s:param>
							修改</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>