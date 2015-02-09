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
<title>新闻发布</title>

<script type="text/javascript" src="<%=basePath%>skin/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>skin/js/main.js"></script>
<link rel="stylesheet" href="<%=basePath%>skin/css/main.css">

<script charset="utf-8" src="<%=basePath%>/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=basePath%>/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="<%=basePath%>/kindeditor/plugins/code/prettify.js"></script>
<style type="text/css">
body {
	font-size: 10px;
}

.container {
	width: 960px;
	margin: 0 auto;
}
</style>
<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="content"]', {
			cssPath : '<%=basePath%>/kindeditor/plugins/code/prettify.css',uploadJson : '<%=basePath%>/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterBlur : function() {
				this.sync();
				K.ctrl(document, 13, function() {
					K('form[name=myform]')[0].submit();
				});
				K.ctrl(this.edit.doc, 13, function() {
					K('form[name=myform]')[0].submit();
				});
			}
		});
		prettyPrint();
	});
</script>

<script type="text/javascript">
	menuseclect();
	$(function() {
		$("#btn").click(function() {
			var value = $("#secSec").val();
			var txt = $("#secSec").find("option:selected").text();
			//		alert("value值：" + value);
			//		alert("text值：" + txt);
		});

		$("#secFirst").change(function() {
			menuseclect_showsecond();
		});
	});
	function submit() {

		var secFirstID = $("#secFirst").val();
		if(secFirstID!=-1){
			var secFirstName = $("#secFirst").find("option:selected").text();
			var secSecName = $("#secSec").find("option:selected").text();
			var secSecID = $("#secSec").val();
			var newsContent = $("#content").val();
			var newstitle = $("#newsTitle").val();
			var istop = $("input:radio:checked").val();
			var author = $("#author").text();
			var newsID=$("#newsID").val();
			var content = {
				"newsID" : newsID,
				"author" : author,
				"isTop" : istop,
				"newsContent" : newsContent,
				"newsTitle" : newstitle,
				"secFirstName" : secFirstName,
				"secFirstID" : secFirstID,
				"secSecID" : secSecID,
				"secSecName" : secSecName
			};
			$.ajax({
				type : "post",//发送方式 
				url : "newsUpdate.action",// 路径 
				data : content,
				success : function() {
					alert("提交成功！");
					window.location.href = "newslist.action";
				},
				error : function() {
					alert("对不起,没有发布成功");
				}
			});
		}else{
			alert("请选择类别!");
		}
		
	}
</script>
</head>
<body>
	<div class="container">
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>新闻ID：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<input type="text" id="newsID" style="width: 250px;"
					value="${requestScope.newsID}" readOnly>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>一级类别：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="secFirst">
					<option value="-1" selected>==请选择==</option>
				</select>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>二级类别：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="secSec">
				</select>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>新闻标题：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<input type="text" id="newsTitle" style="width: 250px;"
					value="${requestScope.newsTitle}">
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_area">
			<div class="left_area height_area">
				<span>详细内容：</span>
			</div>
			<div class="right position_left">
				<textarea name="content" cols="100" rows="8" id="content"
					style="width: 800px; height: 500px; visibility: hidden;">${requestScope.newsContent}</textarea>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>是否置顶：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<input type="radio" name="isTop" value="1">是 <input
					type="radio" name="isTop" value="0" checked>否
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>发布者：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<input type="text" name="author" value="${sessionScope.adminName}" readOnly>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal"></div>
			<div class="right_normal height_nomal position_left">
				<input type="button" name="submit" onclick="submit()" value="确定">
			</div>
		</div>
		<div class="border"></div>
	</div>
</body>
</html>