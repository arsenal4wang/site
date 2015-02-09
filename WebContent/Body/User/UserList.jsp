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

			$("#delete").click(function() {
				$("input:checkbox").each(function() {
					if ($(this).is(':checked')) {
						var id = $(this).attr("id");
						//	alert(id);
						var content = {
							"userID" : id,
						};
						$.ajax({
							type : "post",//发送方式 
							url : "delUser.action",// 路径 
							data : content,
							success : function() {
								window.location.href = "getUserList.action";
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
		</div>-->
		<!--  内容列表   -->
		<table style="margin-top: 8px;">
			<tr bgcolor="#E7E7E7">
				<td width="100%" height="24" colspan="6"
					background="skin/images/tbg.gif">&nbsp;文档列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">选择</td>
				<td width="4%">ID</td>
				<td width="10%">帐号</td>
				<td width="10%">帐号权限</td>
				<!-- 	<td width="10%">所属模块</td> -->
				<td width="10%">注册日期</td>
				<td width="10%">操作</td>
			</tr>

			<s:iterator value="user_list" status="status">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><input name="check_id" type="checkbox"
						id='<s:property value="%{adminID}" />' value="101" class="np"></td>
					<td><s:property value="%{adminID}" /></td>
					<td><s:property value="%{adminName}" /></td>
					<td><s:property value="%{authority}" /></td>
					<!-- 	<td><s:property value="%{firstName}" /></td> -->
					<td><s:property value="%{signDate}" /></td>
					<td><s:if test="adminID==1">
							<span>删除</span>
						</s:if> <s:else>
							<s:a action="delUser" onclick="return check_del();">
								<s:param name="adminID" value="%{adminID}"></s:param>删除</s:a>
						</s:else> <!--  |<s:a action="changeAuthority.action">
							<s:param name="authority" value="%{authority}"></s:param>
							<s:param name="adminID" value="%{adminID}"></s:param>修改权限</s:a>--></td>
				</tr>
			</s:iterator>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan="13">&nbsp; <a id="selectAll"
					class="coolbg">全选</a> <a id="cancel" class="coolbg">取消</a> <a
					id="reverse" class="coolbg">&nbsp;反选&nbsp;</a> <a id="delete"
					class="coolbg">&nbsp;删除&nbsp;</a>

				</td>
			</tr>
		</table>

		<!--  搜索表单
		<div id="search_form">
			<span>搜索条件：</span><select name='cid' style='width: 150'>
				<option value='0'>选择类型...</option>
				<option value='1'>名称</option>
			</select> <span> 关键字：</span> <input type="text"><select name='orderby'
				style='width: 80px'>
				<option value='id'>排序...</option>
				<option value='pubdate'>发布时间</option>
			</select> <img alt="" src="skin/images/frame/search.gif">
		</div>  -->
	</div>
</body>
</html>