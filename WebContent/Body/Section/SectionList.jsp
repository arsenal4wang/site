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
		</div> -->
		<!--  内容列表   -->
		<table style="margin-top: 8px;">
			<tr bgcolor="#E7E7E7">
				<td width="100%" height="24" colspan="7"
					background="skin/images/tbg.gif">&nbsp;第一模块列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">ID</td>
				<td width="10%">模块标题</td>
				<td width="10%">是否导航</td>
				<td width="10%">是否内容版块</td>
				<td width="10%">内容版块位置（如果是）</td>
				<td width="10%">显示顺序</td>
				<td width="10%">操作</td>
			</tr>

			<s:iterator value="listFirst" status="status">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><s:property value="%{firstID}" /></td>
					<td><s:property value="%{firstSectionName}" /></td>
					<td><s:property value="%{isNav}" /></td>
					<td><s:property value="%{isContent}" /></td>
					<td><s:property value="%{secLocate}" /></td>
					<td><s:property value="%{orders}" /></td>
					<td><s:a action="delFirstSec.action"
							onclick="return checkClassifyDel();">
							<s:param name="firstID" value="%{firstID}"></s:param>删除</s:a>|<s:a
							action="modFirstSec.action">
							<s:param name="firstID" value="firstID"></s:param>
							<s:param name="firstSectionNameMod" value="firstSectionName"></s:param>
							<s:param name="isNav" value="isNav"></s:param>
							<s:param name="isContent" value="isContent"></s:param>
							<s:param name="secLocate" value="secLocate"></s:param>
							<s:param name="orders" value="orders"></s:param>
							修改</s:a></td>
				</tr>
			</s:iterator>
		</table>

		<table style="margin-top: 8px;">
			<tr bgcolor="#E7E7E7">
				<td width="100%" height="24" colspan="7"
					background="skin/images/tbg.gif">&nbsp;第二模块列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">ID</td>
				<td width="10%">第二模块</td>
				<td width="10%">所属模块ID</td>
				<td width="10%">所属模块</td>
				<td width="10%">显示方式(Y列表、N简介)</td>
				<td width="4%">排列顺序</td>
				<td width="10%">操作</td>
			</tr>

			<s:iterator value="listSec" status="status">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><s:property value="%{secID}" /></td>
					<td><s:property value="%{secName}" /></td>
					<td><s:property value="%{firstID}" /></td>
					<td><s:property value="%{firstName}" /></td>
					<td><s:property value="%{showUL}" /></td>
					<td><s:property value="%{orders}" /></td>
					<td><s:a action="delSecSec.action"
							onclick="return checkClassifyDel();">
							<s:param name="secID" value="%{secID}"></s:param>删除</s:a>|<s:a
							action="modSecSec.action">
							<s:param name="secID" value="secID"></s:param>
							<s:param name="SecondSecNameMod" value="secName"></s:param>
							<s:param name="firstID" value="firstID"></s:param>
							<s:param name="orders" value="orders"></s:param>
							<s:param name="firstSectionNameMod" value="firstName"></s:param>
							修改</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>