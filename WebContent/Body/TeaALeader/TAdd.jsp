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

<script type="text/javascript" src="skin/js/jquery.min.js"></script>
<script type="text/javascript" src="skin/js/main.js"></script>
<link rel="stylesheet" href="skin/css/main.css">

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
		var editor1 = K.create('textarea[name="lProfile"]', {
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
	function submit() {
		var tlName = $("#lclass").find("option:selected").text();
		var tlID = $("#lclass").val();
		var teaLeaProfile = $("#lProfile").val();//详细信息
		var teaLeaName = $("#lName").val();//名字

		
		var content = {
			"tlName" : tlName,
			"tlID" : tlID,
			"teaLeaName" : teaLeaName,
			"teaLeaProfile" : teaLeaProfile
		};
		$.ajax({
			type : "post",//发送方式 
			url : "addTeacher.action",// 路径 
			data : content,
			success : function() {
				alert("提交成功！");
				window.location.href = "getTeaLeaList.action";
			},
			error : function() {
				alert("对不起,没有添加成功");
			}
		}); /**/
	}
</script>
</head>
<body>
	<div class="container">

		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>职位：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="lclass">
					<s:iterator value="listTL" id="id">
						<option value='<s:property value="%{tlID}"/>'><s:property
								value="tlName" /></option>
					</s:iterator>
				</select>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>姓名：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<input type="text" id="lName" style="width: 250px;">
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_area">
			<div class="left_area height_area">
				<span>详细信息：</span>
			</div>
			<div class="right position_left">
				<textarea name="lProfile" cols="100" rows="8" id="lProfile"
					style="width: 800px; height: 500px; visibility: hidden;"></textarea>
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