<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="skin/css/base.css">
<script type="text/javascript" src="skin/js/main.js"></script>
<script type="text/javascript" src="skin/js/jquery.min.js"></script>
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
<script type="text/javascript">
	$(function() {
		$(function() {
			$("#selectAll").click(function() {
				selectAll();
			});
			$("#cancel").click(function() {
				cancelAll();
			});
			$("#reverse").click(function() {
				reverse();
			});

			$("#delete")
					.click(
							function() {
								$("input:checkbox")
										.each(
												function() {
													if ($(this).is(':checked')) {
														var id = $(this).attr(
																"id");
														//	alert(id);
														var content = {
															"userID" : id,
														};
														$
																.ajax({
																	type : "post",//发送方式 
																	url : "delPicSlider.action",// 路径 
																	data : content,
																	success : function() {
																		window.location.href = "getPicSliderList.action";
																	},
																	error : function() {
																		//		alert("对不起,没有成功");
																	}
																});
														//	alert("if...");
													}
													//	alert("each...");
												});
								//	alert("function...");
								//		window.location.href="filelist.action";
							});
		});
	});
</script>
</head>

<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>
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
		</div>  -->
		<!--  内容列表   -->
		<table style="margin-top: 8px;">
			<tr bgcolor="#E7E7E7">
				<td width="100%" height="24" colspan="9"
					background="skin/images/tbg.gif">&nbsp;文档列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">选择</td>
				<td width="4%">ID</td>
				<td width="10%">图片名称</td>
				<td width="20%">图片路径</td>
				<td width="10%">图片链接</td>
				<td width="6%">新闻ID</td>
				<td width="10%">新闻标题</td>
				<td width="6%">显示顺序</td>
				<td width="10%">操作</td>
			</tr>

			<s:iterator value="list" status="status">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><input name="check_id" type="checkbox"
						id='<s:property value="%{picID}" />' value="101" class="np"></td>
					<td><s:property value="%{picID}" /></td>
					<td><s:property value="%{picName}" /></td>
					<td><s:property value="%{picLocation}" /></td>
					<td><s:property value="%{href}" /></td>
					<td><s:property value="%{newsID}" /></td>
					<td><s:property value="%{newsTitle}" /></td>
					<td><s:property value="%{picOrder}" /></td>
					<td><s:a action="delPicSlider.action"
							onclick="return check_del();">
							<s:param name="picID" value="%{picID}"></s:param>删除</s:a>|<s:a
							action="picSliderMod.action">
							<s:param name="picID" value="%{picID}"></s:param>
							<s:param name="picName" value="%{picName}"></s:param>
							<s:param name="picLocation" value="%{picLocation}"></s:param>
							<s:param name="href" value="%{href}"></s:param>
							<s:param name="newsID" value="%{newsID}"></s:param>
							<s:param name="newsTitle" value="%{newsTitle}"></s:param>修改</s:a></td>
				</tr>
			</s:iterator>
		</table>
		<!--  内容列表   -->
		<table style="margin-top: 8px;">
			<tr bgcolor="#E7E7E7">
				<td width="100%" height="24" colspan="5"
					background="skin/images/tbg.gif">&nbsp;文档列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">ID</td>
				<td width="20%">图片路径</td>
				<td width="10%">图片链接</td>
				<td width="6%">显示顺序</td>
				<td width="10%">操作</td>
			</tr>
			<s:iterator value="gdpic" status="status">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><s:property value="%{picID}" /></td>
					<td><s:property value="%{picLocation}" /></td>
					<td><s:property value="%{href}" /></td>
					<td><s:property value="%{picOrder}" /></td>
					<td><s:a action="delGdPic.action"
							onclick="return check_del();">
							<s:param name="picID" value="%{picID}"></s:param>删除</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>