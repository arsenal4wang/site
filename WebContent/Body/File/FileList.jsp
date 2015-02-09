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
<link rel="stylesheet" type="text/css" href="<%=basePath%>skin/css/base.css">
<script type="text/javascript" src="<%=basePath%>skin/js/main.js"></script>
<script type="text/javascript" src="<%=basePath%>skin/js/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
					//		alert(id);
					var content = {
						"fileID" : id,
					};
					$.ajax({
						type : "post",//发送方式 
						url : "deletefile.action",// 路径 
						data : content,
						success : function() {
							window.location.href = "filelist.action";
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
</script>
</head>

<body leftmargin="8" topmargin="8" background='<%=basePath%>skin/images/allbg.gif'>
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
				<td width="100%" height="24" colspan="8"
					background="skin/images/tbg.gif">&nbsp;文档列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">资源ID</td>
				<td width="4%">选择</td>
				<td width="28%">资源标题</td>
				<td width="15%">上传时间</td>
				<td width="5%">下载次数</td>
				<td width="5%">所属分类</td>
				<td width="6%">上传作者</td>
				<td width="10%">操作</td>
			</tr>

			<s:iterator value="list" status="status">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><s:property value="%{fileID}" /></td>
					<td><input name="check_id" type="checkbox"
						id='<s:property value="%{fileID}" />' value="101" class="np"></td>
					<td align="left"><s:property value="%{fileName}" /></td>
					<td><s:property value="%{up_Date}" /></td>
					<td><s:property value="%{downTimes}" /></td>
					<td><s:property value="%{classify}" /></td>
					<td><s:property value="%{author}" /></td>
					<td><s:a action="deletefile.action">
							<s:param name="fileID" value="%{fileID}">
							</s:param> 删除</s:a>||<s:a action="download.action" namespace="/file" encode="false">
							<s:param name="fileName" value="%{fileName}" />下载  </s:a>||查看</td>
				</tr>
			</s:iterator>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan="8">&nbsp; <a id="selectAll"
					class="coolbg">全选</a> <a id="cancel" class="coolbg">取消</a><a
					id="reverse" class="coolbg">反选</a>  <a id="delete"
					class="coolbg">&nbsp;删除&nbsp;</a>
				</td>
			</tr>
			<tr align="right" bgcolor="#EEF4EA">
				<td height="36" colspan="8" align="center">
					<!--翻页代码 -->
					<div class="pagination">
						<ul class="page">
							<s:if test="begin_num>=20">
								<li><s:a action="filelist.action">
										<s:param name="begin_num" value="0" />
        					首页</s:a></li>
							</s:if>
							<s:elseif test="begin_num<20">
								<li><span>首页</span></li>
							</s:elseif>


							<li><s:if test="begin_num>=20">
									<s:a action="filelist.action">
										<s:param name="begin_num" value="begin_num-20" />上一页</s:a>
								</s:if> <s:else>
									<span class="page_turn">上一页</span>
								</s:else></li>

							<li><s:if test="begin_num==page*20-20">
									<span>下一页</span>
								</s:if> <s:else>
									<s:a action="filelist.action">
										<s:param name="begin_num" value="begin_num+20" />
									下一页</s:a>
								</s:else></li>


							<li><s:a action="filelist.action">
									<s:param name="begin_num" value="(page-1)*20">
									</s:param>
								尾页
							</s:a></li>

						</ul>
					</div>
					<div id="stastic">
						<span> 第 <s:property value="begin_num/20+1" /> 页
						</span> <span> 共 <s:property value="page" /> 页
						</span> <span>共 <s:property value="all_num" /> 条纪录
						</span>
					</div>
				</td>
			</tr>
		</table>

		<!--  搜索表单  -->
		<div id="search_form">
			<span>搜索条件：</span><select name='cid' style='width: 150'>
				<option value='0'>选择类型...</option>
				<option value='1'>名称</option>
			</select> <span> 关键字：</span> <input type="text"><select name='orderby'
				style='width: 80px'>
				<option value='id'>排序...</option>
				<option value='pubdate'>发布时间</option>
			</select> <img alt="" src="skin/images/frame/search.gif">
		</div>
	</div>
</body>
</html>