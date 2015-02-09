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
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="<%=basePath%>skin/css/base.css">
<script type="text/javascript" src="<%=basePath%>skin/js/main.js"></script>
<script type="text/javascript" src="<%=basePath%>skin/js/jquery.min.js"></script>
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
				<td width="100%" height="24" colspan="5"
					background="skin/images/tbg.gif">&nbsp;文档列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="6%">日志ID</td>
				<td width="6%">用户ID</td>
				<td width="10%">帐号</td><!-- 
				<td width="10%">所属部门</td> -->
				<td width="15%">登录时间</td>
				<td width="15%">登录IP</td>
			</tr>

			<s:iterator value="listLog" status="status">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><s:property value="%{logID}" /></td>
					<td><s:property value="%{userID}" /></td>
					<td><s:property value="%{userName}" /></td>
			<!-- 		<td><s:property value="%{firstCatName}" /></td> -->
					<td><s:property value="%{logTime}" /></td>
					<td><s:property value="%{loginIP}" /></td>
				</tr>
			</s:iterator>
			<tr align="right" bgcolor="#EEF4EA">
				<td height="36" colspan="13" align="center">
					<!--翻页代码 -->
					<div class="pagination">
						<ul class="page">
							<s:if test="beginnum>=20">
								<li><s:a action="userLog.action">
										<s:param name="beginnum" value="0" />
        					首页</s:a></li>
							</s:if>
							<s:elseif test="beginnum<20">
								<li><span>首页</span></li>
							</s:elseif>
							<li><s:if test="beginnum>=20">
									<s:a action="userLog.action">
										<s:param name="beginnum" value="beginnum-20" />上一页</s:a>
								</s:if> <s:else>
									<span class="page_turn">上一页</span>
								</s:else></li>

							<li><s:if test="beginnum==page*20-20">
									<span>下一页</span>
								</s:if> <s:else>
									<s:a action="userLog.action">
										<s:param name="beginnum" value="beginnum+20" />
									下一页</s:a>
								</s:else></li>

							<li><s:a action="userLog.action">
									<s:param name="beginnum" value="(page-1)*20">
									</s:param>
								尾页
							</s:a></li>

						</ul>
					</div>
					<div id="stastic">
						<span> 第 <s:property value="beginnum/20+1" /> 页
						</span> <span> 共 <s:property value="page" /> 页
						</span> <span>共 <s:property value="allnum" /> 条纪录
						</span>
					</div>
				</td>
			</tr>
		</table>

	</div>
</body>
</html>