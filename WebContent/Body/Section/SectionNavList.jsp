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
				<td width="100%" height="24" colspan="8"
					background="skin/images/tbg.gif">&nbsp;第一模块列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">ID</td>
				<td width="10%">模块标题</td>
				<td width="10%">是否导航</td>
				<td width="10%">是否内容版块</td>
				<td width="10%">内容版块位置</td>
				<td width="6%">导航栏顺序</td>
				<td width="6%">内容版块顺序</td>
				<td width="10%">操作</td>
			</tr>

			<s:iterator value="listSection" status="status">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><s:property value="%{secID}" /></td>
					<td><s:property value="%{secName}" /></td>
					<td><s:property value="%{isNav}" /></td>
					<td><s:property value="%{isContent}" /></td>
					<td><s:property value="%{secLocate}" /></td>
					<td><s:property value="%{navOrder}" /></td>
					<td><s:property value="%{conOrder}" /></td>
					<td><s:a action="delSection.action"
							onclick="return checkClassifyDel();">
							<s:param name="isFirst" value="%{isFirst}"></s:param>
							<s:param name="secID" value="%{secID}"></s:param>删除</s:a>|<s:a
							action="modSection.action">
							<s:param name="isFirst" value="%{isFirst}"></s:param>
							<s:param name="secID" value="secID"></s:param>
							<s:param name="sectionNameMod" value="secName"></s:param>
							<s:param name="isNav" value="isNav"></s:param>
							<s:param name="isContent" value="isContent"></s:param>
							<s:param name="secLocate" value="secLocate"></s:param>
							<s:param name="navOrder" value="navOrder"></s:param>
							<s:param name="conOrder" value="conOrder"></s:param>
							修改</s:a></td>
				</tr>
			</s:iterator>
		</table>

		<table style="margin-top: 8px;">
			<tr bgcolor="#E7E7E7">
				<td width="100%" height="24" colspan="10"
					background="skin/images/tbg.gif">&nbsp;二级模块列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">ID</td>
				<td width="10%">模块名称</td>
				<td width="6%">所属模块ID</td>
				<td width="10%">所属模块</td>
				<td width="6%">是否内容版块</td>
				<td width="10%">显示方式(列表/简介/师资)</td>
				<td width="6%">导航栏顺序</td>
				<td width="6%">内容版块顺序</td>
				<td width="6%">内容版块位置</td>
				<td width="10%">操作</td>
			</tr>

			<s:iterator value="listSubSection" status="status" id="id">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><s:property value="%{secID}" /></td>
					<td><s:property value="%{subNavName}" /></td>
					<td><s:property value="%{secIDforSub}" /></td>
					<td><s:property value="%{secName}" /></td>
					<td><s:property value="%{isContent}" /></td>

					<s:if test='%{#id.showUL=="1"}'>
						<td>列表</td>
					</s:if>
					<s:elseif test='%{#id.showUL=="2"}'>
						<td>简介</td>
					</s:elseif>
					<s:elseif test='%{#id.showUL=="3"}'>
						<td>教师</td>
					</s:elseif>
					<s:elseif test='%{#id.showUL=="4"}'>
						<td>领导</td>
					</s:elseif>

					<td><s:property value="%{navOrder}" /></td>
					<td><s:property value="%{conOrder}" /></td>
					<td><s:property value="%{secLocate}" /></td>
					<td><s:a action="delSection.action"
							onclick="return checkClassifyDel();">
							<s:param name="isFirst" value="%{isFirst}"></s:param>
							<s:param name="secID" value="%{secID}"></s:param>删除</s:a>|<s:a
							action="modSection.action">
							<s:param name="isFirst" value="%{isFirst}"></s:param>
							<s:param name="secID" value="secID"></s:param>
							<s:param name="secIDforSub" value="%{secIDforSub}"></s:param>
							<s:param name="sectionNameMod" value="secName"></s:param>
							<s:param name="subNavNameMod" value="subNavName"></s:param>
							<s:param name="isContent" value="isContent"></s:param>
							<s:param name="navOrder" value="navOrder"></s:param>
							<s:param name="conOrder" value="conOrder"></s:param>
							修改</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>