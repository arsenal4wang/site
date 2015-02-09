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

<script type="text/javascript">
KindEditor.ready(function(K) {
	var editor = K.editor({
		allowFileManager : true
	});
	K('#image3').click(function() {
		editor.loadPlugin('image', function() {
			editor.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#url3').val(),
				clickFn : function(url, title, width, height, border, align) {
					K('#url3').val(url);
					editor.hideDialog();
				}
			});
		});
	});
});
</script>
<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="newsContent"]', {
			cssPath : '<%=basePath%>/kindeditor/plugins/code/prettify.css',uploadJson : '<%=basePath%>/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>/kindeditor/jsp/file_manager_json.jsp',
									allowFileManager : true,
									afterChange : function() {
										$("#selectPic").empty();
										$("#selectPic")
												.append(
														"<option value='NoPic'>请选择封面图片</option>");
										getPic();
									},
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
		var heightFile=30;
		$("#btn").click(function() {
			var value = $("#secSec").val();
			var txt = $("#secSec").find("option:selected").text();
			//		alert("value值：" + value);
			//		alert("text值：" + txt);
		});

		$("#secFirst").change(function() {
			menuseclect_showsecond();
		});
		$("#addFile").click(
				function() {
					heightFile+=30;
					$("#fileCSS").css("height", heightFile);
					var i = 0;
					$("#upload").after(
							"<input type='file' name='upload' id='upload'>");
					$("#upload").after("<br/>");
				});
	});
	function submit() {

		var secFirstID = $("#secFirst").val();
		if (secFirstID != -1) {
			var secFirstName = $("#secFirst").find("option:selected").text();
			var secFirstID = $("#secFirst").val();
			var secSecName = $("#secSec").find("option:selected").text();
			var secSecID = $("#secSec").val();
			var newsContent = $("#content").val();
			var newstitle = $("#newsTitle").val();
			var istop = $("input:radio:checked").val();
			var author = $("#author").text();
			if (!secSecID)
				secSecID = 0;

			var picLocation = $("#url3").val();
			//	alert(picLocation);
			if (picLocation == "") {
				picLocation = $("#selectPic").val();
				//	var ss=$("#selectPic").find("option:selected").text();
				//	alert(picLocation+"2");
				//	alert("ss"+ss);
			}
			var content = {
				"picLocation" : picLocation,
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
				namespace : "",
				type : "post",//发送方式 
				url : "newsAdd.action",// 路径 
				data : content,
				success : function() {
					alert("提交成功！");
					window.location.href = "../../newslist.action";
				},
				error : function() {
					alert("对不起,没有发布成功");
				}
			});
		} else {
			alert("请选择类别!");
		}
	}
</script>
</head>
<body>
	<div class="container">
		<form action="newsAdd.action" enctype="multipart/form-data"
			method="post">
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>一级类别：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<select id="secFirst" name="secFirstName">
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
					<select id="secSec" name="secSecName">
					</select>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>新闻标题：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" id="newsTitle" name="newsTitle"
						style="width: 250px;">
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>设置轮播图片：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="text" id="url3" value="" name="picLocation" readOnly />
					<input type="button" id="image3" value="选择图片" />（本地上传，更高优先级）<span
						style="color: green;">（图片将在该文章审核过后显示）</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>设置轮播图片：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<select id="selectPic" name="picSlider2">
						<option value="NoPic">请选择封面图片</option>
					</select>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>提示：</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<span style="color: green; font-style: italic; padding-right: 5px;">文章内图片宽度为</span><span
						style="font-weight: bold; color: red;">650</span><span
						style="color: green; font-style: italic;">相素为最佳****轮播图片为980*300为最佳</span>
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_area">
				<div class="left_area height_area">
					<span>详细内容：</span>
				</div>
				<div class="right position_left">
					<textarea name="newsContent" cols="100" rows="8" id="content"
						style="width: 800px; height: 500px; visibility: hidden;"></textarea>
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
			<div class="height height_nomal" id="fileCSS">
				<div class="left_nomal height_nomal">
					<span>添加附件</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="file" name="upload" id="upload">
				</div>
			</div>
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal">
					<span>继续添加附件</span>
				</div>
				<div class="right_normal height_nomal position_left">
					<input type="button" name="addFile" id="addFile" value="继续添加">
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
			<!---->
			<div class="border"></div>
			<div class="height height_nomal">
				<div class="left_nomal height_nomal"></div>
				<div class="right_normal height_nomal position_left">
					<input type="submit" name="submit" value="确定">
					<!--  onclick="submit()" -->
				</div>
			</div>
		</form>
	</div>
</body>
</html>