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
	width: 20%;
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
		$("#searchIMG").click(function() {
			$("#searchForm").submit();
		});
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
						"newsID" : id,
					};
					$.ajax({
						type : "post",//发送方式 
						url : "deleteNews.action",// 路径 
						data : content,
						success : function() {
							window.location.href = "newslist.action";
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
				<td width="100%" height="24" colspan="14"
					background="skin/images/tbg.gif">&nbsp;文档列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">新闻ID</td>
				<td width="4%">选择</td>
				<td width="28%">文章标题</td>
				<td width="9%">发布时间</td>
				<td width="9%">修改时间</td>
				<td width="5%">一级分类</td>
				<td width="5%">二级分类</td>
				<td width="4%">点击次数</td>
				<s:if test="#session.authority!='普通管理员'}">
					<td width="4%">是否审核</td>
				</s:if>
				<td width="4%">是否置顶</td>
				<td width="6%">发布作者</td>
				<td width="6%">修改作者</td>
				<td width="10%">操作</td>
			</tr>

			<s:iterator value="list_news" status="status">
				<tr class="tabletr" height="22">
					<td><s:property value="%{newsID}" /></td>
					<td><input name="check_id" type="checkbox"
						id='<s:property value="%{newsID}" />' value="101" class="np"></td>
					<td align="left"><s:property value="%{newsTitle}" /></td>
					<td><s:property value="%{subDate}" /></td>
					<td><s:property value="%{modDate}" /></td>
					<td><s:property value="%{secFirstName}" /></td>
					<td><s:property value="%{secSecName}" /></td>
					<td><s:property value="%{readTimes}" /></td>


					<s:if test="#session.authority!='普通管理员'}">
						<s:if test="%{isChecked==1}">
							<td><span title="取消审核"><s:a action="changeCheck">
										<s:param name="isChecked">0</s:param>
										<s:param name="newsID" value="%{newsID}"></s:param>
						是</s:a></span></td>
						</s:if>
						<s:else>
							<td><span title="通过审核"><s:a action="changeCheck">
										<s:param name="isChecked">1</s:param>
										<s:param name="newsID" value="%{newsID}"></s:param>
						否</s:a></span></td>
						</s:else>
					</s:if>
					<s:if test="%{isTop==1}">
						<td><span title="取消置顶"><s:a action="changeIsTop">
									<s:param name="isTop">0</s:param>
									<s:param name="newsID" value="%{newsID}"></s:param>
						是</s:a></span></td>
					</s:if>
					<s:else>
						<td><span title="置顶"><s:a action="changeIsTop">
									<s:param name="isTop">1</s:param>
									<s:param name="newsID" value="%{newsID}"></s:param>
						否</s:a></span></td>
					</s:else>
					<td><s:property value="%{Author}" /></td>
					<td><s:property value="%{modAuthor}" /></td>
					<td><span title="删除"><s:a action="deleteNews.action"
								onclick="return check_del();">
								<s:param name="newsID" value="%{newsID}"></s:param>
						删除</s:a></span>| <s:a action="newsMod.action">
							<s:param name="newsID" value="newsID"></s:param>修改
							</s:a></td>
				</tr>
			</s:iterator>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan="13">&nbsp; <a id="selectAll"
					class="coolbg">全选</a> <a id="cancel" class="coolbg">取消</a> <a
					id="reverse" class="coolbg">&nbsp;反选&nbsp;</a> <a id="delete"
					class="coolbg">&nbsp;删除&nbsp;</a>
				</td>
			</tr>
			<tr align="right" bgcolor="#EEF4EA">
				<td height="36" colspan="13" align="center">
					<!--翻页代码 -->
					<div class="pagination">
						<ul class="page">
							<s:if test="begin_num>=10">
								<li><s:a action="searchNews.action">
										<s:param name="begin_num" value="0" />
										<s:param name="frompage">1</s:param>
										<s:param name="keyWordsPage2" value="keyWords" />
        					首页</s:a></li>
							</s:if>
							<s:elseif test="begin_num<10">
								<li><span>首页</span></li>
							</s:elseif>


							<li><s:if test="begin_num>=10">
									<s:a action="searchNews.action">
										<s:param name="begin_num" value="begin_num-10" />
										<s:param name="frompage">1</s:param>
										<s:param name="keyWordsPage2" value="keyWords" />上一页</s:a>
								</s:if> <s:else>
									<span class="page_turn">上一页</span>
								</s:else></li>

							<li><s:if test="begin_num==page*10-10">
									<span>下一页</span>
								</s:if> <s:else>
									<s:a action="searchNews.action">
										<s:param name="begin_num" value="begin_num+10" />
										<s:param name="keyWordsPage2" value="keyWords" />
									下一页</s:a>
								</s:else></li>

							<li><s:if test="begin_num==(page-1)*10">
									<span>尾页</span>
								</s:if> <s:else>
									<s:a action="searchNews.action">
										<s:param name="begin_num" value="(page-1)*10" />
										<s:param name="keyWordsPage2" value="keyWords" />
								尾页
							</s:a>
								</s:else></li>

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
			<form action="searchNews" method="post" id="searchForm">
				<span> 关键字：</span> <input type="text" id="keyWords" name="keyWords">
				<!-- <span id="searchIMG"><img alt="搜索"
					src="skin/images/frame/search.gif"></span> -->
				<input type="submit" value="提交">
			</form>
		</div>
	</div>
</body>
</html>