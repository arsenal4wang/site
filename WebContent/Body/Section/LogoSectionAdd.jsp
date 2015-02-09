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
<title>一级分类</title>
<script type="text/javascript" src="<%=basePath%>skin/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>skin/js/main.js"></script>
<link rel="stylesheet" href="<%=basePath%>skin/css/main.css">

<script charset="utf-8" src="<%=basePath%>/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=basePath%>/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="<%=basePath%>/kindeditor/plugins/code/prettify.js"></script>

<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="content"]', {
			cssPath : '<%=basePath%>/kindeditor/plugins/code/prettify.css',uploadJson : '<%=basePath%>/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterChange : function() {
				$("#selectPic").empty();
				$("#selectPic").append("<option value='-1'>请选择封面图片</option>");
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
	KindEditor.ready(function(K) {
		var editor = K.editor({
			allowFileManager : true
		});
		K('#image3').click(
				function() {
					editor.loadPlugin('image', function() {
						editor.plugin.imageDialog({
							showRemote : false,
							imageUrl : K('#url3').val(),
							clickFn : function(url, title, width, height,
									border, align) {
								K('#url3').val(url);
								editor.hideDialog();
							}
						});
					});
				});
	});
</script>
<script type="text/javascript">
	//menuseclect();
	$(function() {
		$("#secondCatSub").click(function() {
			var secID = $("#firstSec").val();
			var sectionName = $("#firstSec").find("option:selected").text();
			var subNavName = $("#subNavName").val();
			var navOrder = $("#navOrders").val();
			var isContent = $("#isContent").val();
			var secLocate = $("#secLocate").val();
			var url3 = $("#url3").val();
			alert(url3);
			//alert(showUL);
			//		alert(firstID);
			//		alert(firstSecName);
			//		alert(SecondSecName);
			//		alert(orders);
			//		alert(isContent);
			//		alert(secLocate);
			var content = {
				"picLocation" : url3,
				"secIDforSub" : secID,
				"secName" : sectionName,
				"subNavName" : subNavName,
				"navOrder" : navOrder
			};
			$.ajax({
				type : "post",
				url : "addLOGO.action",
				data : content,
				success : function() {
						window.location.href = "getSecionNavList.action";
				},
			});
		});
	});
</script>
<style type="text/css">
.green {
	color: green;
}
</style>
</head>
<body>
	<div class="container">
		<div class="height height_nomal">
			<div class="right_normal  position_left">
				<span class="htitle" style="">添加二级模块</span>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>一级类别：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="firstSec">
					<s:iterator value="listSection" id="id">
						<option value="${secID}"><s:property value="#id.secName" /></option>
					</s:iterator>
				</select>
			</div>
		</div>
		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>二级模块标题：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<input type="text" id="subNavName" style="width: 250px;">
			</div>
		</div>

		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>LOGO图片：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<input type="text" id="url3" value="" name="picLocation" readOnly />
				<input type="button" id="image3" value="选择图片" />（本地上传）
			</div>
		</div>

		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal">
				<span>导航排列顺序：</span>
			</div>
			<div class="right_normal height_nomal position_left">
				<select id="navOrders" name="navOrders">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
				</select> <span class="green" style="padding-left: 200px;">*显示顺序</span>
			</div>
		</div>

		<div class="border"></div>
		<div class="height height_nomal">
			<div class="left_nomal height_nomal"></div>
			<div class="right_normal height_nomal position_left">
				<input type="button" id="secondCatSub" value="确定">
			</div>
		</div>
	</div>
</body>
</html>