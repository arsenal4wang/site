<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中央民族大学哲学与宗教学院</title>
<script type="text/javascript" src="skin/js/jquery.min.js"></script>
<script type="text/javascript" src="skin/js/ent.js"></script>
<script type="text/javascript">
	$(function() {
		var firNav = $("#firNav").val();
		$(".nav li a").each(function() {
			var id = $(this).attr("id");
			//	alert(id);clobtn
			if (id == firNav) {
				//	alert(id);
				$("#" + id).addClass("clobtn");
			}
		});

		$("#search").click(function() {
		});
	});
</script>
<style type="text/css">
</style>
</head>
<body>
	<input type="hidden" name="hidden" id="firNav" value="first${navID}">
	<div id="header">
		<div class="logbar">
			<a class="logo" href="welcome">中央民族大学哲学与宗教学院</a>
		</div>
		<div class="navbar">
			<ul class="nav">
				<li class="li"><a class=" " id="first0" href="welcome">首页</a></li>
				<s:iterator value="listSection" status="status" id="f">
					<li class="li"><s:a action="newsList.action"
							id="first%{secID}">
							<s:param name="navID" value="%{secID}"></s:param>
							<s:param name="isNav">1</s:param>
							<s:property value="#f.secName" />
						</s:a>
						<ul class="">
							<s:iterator value="listSubSection" status="status" id="s">
								<s:if test="%{#s.secIDforSub==#f.secID}">
									<li class="" style="text-align: left;"><div
											style="width: 100%; margin-right: -20px;">
											<s:if test='%{#s.showUL=="4"}'>
												<s:a id="sec%{secID}" action="getTL">
													<s:param name="secID" value="%{secID}"></s:param>
													<s:param name="navID" value="%{secIDforSub}"></s:param>
													<s:param name="isNav">0</s:param>
													<s:param name="showUL" value="%{showUL}"></s:param>
													<span><s:property value="#s.subNavName" /></span>
												</s:a>
											</s:if>
											<s:elseif test='%{#s.showUL=="3"}'>
												<s:a  id="sec%{secID}" action="getTL">
													<s:param name="secID" value="%{secID}"></s:param>
													<s:param name="navID" value="%{secIDforSub}"></s:param>
													<s:param name="isNav">0</s:param>
													<s:param name="showUL" value="%{showUL}"></s:param>
													<span><s:property value="#s.subNavName" /></span>
												</s:a>
											</s:elseif>
											<s:elseif test='%{#s.showUL=="2"}'>
												<s:a id="sec%{secID}" action="getInfo">
													<s:param name="secID" value="%{secID}"></s:param>
													<s:param name="navID" value="%{secIDforSub}"></s:param>
													<s:param name="isNav">0</s:param>
													<s:param name="showUL">2</s:param>
													<span><s:property value="#s.subNavName" /></span>
												</s:a>
											</s:elseif>
											<s:else>
												<s:a  id="sec%{secID}" action="newsList.action">
													<s:param name="secID" value="%{secID}"></s:param>
													<s:param name="navID" value="%{secIDforSub}"></s:param>
													<s:param name="isNav">0</s:param>
													<span><s:property value="#s.subNavName"/></span>
												</s:a>
											</s:else>
										</div></li>
								</s:if>
							</s:iterator>
						</ul></li>
				</s:iterator>
			</ul>
			<div class="searchbar">
				<div class="chobox">
					<span id="chose" checkedid="-1" checkedname="全站搜索"
						onmouseover="choseType_show();" onmouseout="choseType_hid();">==请选择==</span>
					<div class="chose" style="display: none;"
						onmouseover="choseType_show();" onmouseout="choseType_hid();">
						<ul>
							<li><a id="0" style="cursor: pointer;"
								onclick="swapChose(this)">全站搜索</a></li>

							<s:iterator value="listSection" status="status" id="f">
								<li><a id='<s:property value="#f.secID" />'
									style="cursor: pointer;" onclick="swapChose(this)"><s:property
											value="#f.secName" /></a></li>
							</s:iterator>
							<!-- 
							<li><a id="8385" style="cursor: pointer;"
								onclick="swapChose(this)">学院概况</a></li> -->
							<div class="clr"></div>
						</ul>
					</div>
				</div>
				<div class="search">
					<form action="newsSearch.action" method="post" name="form">
						<input type="hidden" id="hiddenSecID" name="secID">
						<!-- secIDforSub  secID -->
						<input type="text" class="input" name="keyWords" id="keywords"
							style="color: #909090;" value="请输入您要搜索的内容！" title="请输入您要搜索的内容！"
							onfocus="hiddenTips()" onblur="showTips()">
						<button type="submit" id="submit" onclick="javascript:queryKey();">搜索</button>
					</form>
				</div>
				<div class="clr"></div>
			</div>
		</div>
	</div>
</body>
</html>