<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中央民族大学哲学与宗教学院</title>
<link href="skin/css/common.css" rel="stylesheet" type="text/css">
<link href="skin/css/ent.css" rel="stylesheet" type="text/css">
<link href="skin/css/home.css" rel="stylesheet" type="text/css">
<link href="skin/css/main.css" rel="stylesheet" type="text/css">
<link href="skin/css/pages.css" rel="stylesheet" type="text/css">
<link href="skin/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="skin/js/jquery.min.js"></script>
<script type="text/javascript" src="skin/js/ent.js"></script>
<script type="text/javascript">
	$(function() {
		var hidden = $("#hidden").val();
		$(".stybtn1").each(function() {
			var id = $(this).attr("id");
			if (id == hidden) {
				$("#" + id).removeClass("stybtn1");
				$("#" + id).addClass("stybtn2");
			}
		});
	});
</script>
<style type="text/css">
</style>
</head>
<body>
	<input type="hidden" id="hidden" value="${secID}">
	<s:include value="Topbar.jsp"></s:include>
	<div class="wapper">
		<s:include value="Top.jsp"></s:include>

		<div id="main" class="searchmain">
			<div class="mrtop3"></div>
			<div class="content">
				<div class="pagesearch">
					<em>分类：<span>${firstName}</span></em>
					<div class="sewapper">
						<div class="mainbox">
							<div class="search_box">
								<h1>
									<span>含有"</span>${KeyWords}<span>"的搜索结果</span>
								</h1>
								<ul class="listext">
									<div id="news" class="list" pageno="1" pagecount="11"
										recordnum="101">
										<ul class="lcontent">
											<s:iterator value="listNews" var="f">
												<li><span>[<s:property value="#f.subDate" />]
												</span>
													<div
														style="width: 530px; float: left; text-overflow: ellipsis; overflow: hidden; white-space: nowrap;">
														<span style="float: left;"
															title='<s:property value="#f.secFirstName"/>'> <a
															target="_self"
															href='newsList.action?secID=<s:property value="#f.secSecID"/>&navID=<s:property value="#f.secFirstID"/>&isNav=0'>[<s:property
																	value="#f.secFirstName" />]
														</a></span> <a target="_self"
															href='readNews.action?newsID=<s:property value="#f.newsID"/>&navID=<s:property value="#f.secFirstID"/>&secID=<s:property value="secSecID"/>'
															title='<s:property value="#f.newsTitle"/>'> <s:property
																value="#f.newsTitle" /></a>
													</div></li>
											</s:iterator>
										</ul>
										<div class="clr"></div>
										<div class="listfoot">
											<span class="pagenum">共 <s:property value="allNum" />
												条, 第 <s:property value="page" /> 页 / 共 <s:property
													value="pageAll" /> 页
											</span>
											<span class="pagecontrol"> <!-- keyWordsPage -->
											
											 <s:url id="url" action="newsSearch.action">
													<s:param name="keyWordsPage" value="keyWords"></s:param>
													<s:param name="page">1</s:param>
													<s:param name="secID" value="secID"></s:param>
												</s:url> 
												
												<s:a href="%{url}">
													<input type="button" title="第一页" value="9"
														style="font-family: Webdings; width: 20px;">
												</s:a> 
												
												<s:if test="page==1">
													<input type="button" title="前一页" value="3"
														style="font-family: Webdings; width: 20px;">
												</s:if>
												 <s:else>
													<s:a action="newsSearch.action">
														<s:param name="keyWordsPage" value="keyWords"></s:param>
														<s:param name="page" value="page-1"></s:param>
														<s:param name="secID" value="secID"></s:param>
														<input type="button" title="前一页" value="3"
															style="font-family: Webdings; width: 20px;">
													</s:a>
												<!-- 	<a
														href='newsSearch.action?keyWordsPage=<s:property value="keyWords" />&page=<s:property value="page-1"/>&secID=<s:property value="secID"/>'>
														<input type="button" title="前一页" value="3"
														style="font-family: Webdings; width: 20px;">
													</a> -->
												</s:else> 
												<s:if test="page==pageAll">
													<input type="button" title="后一页" value="4"
														style="font-family: Webdings; width: 20px;">
												</s:if> <s:else>
													<s:a action="newsSearch.action">
														<s:param name="keyWordsPage" value="keyWords"></s:param>
														<s:param name="page" value="page+1"></s:param>
														<s:param name="secID" value="secID"></s:param>
														<input type="button" title="后一页" value="4"
															style="font-family: Webdings; width: 20px;">
													</s:a>
												</s:else>
												<s:a action="newsSearch.action">
														<s:param name="keyWordsPage" value="keyWords"></s:param>
														<s:param name="page" value="page+1"></s:param>
														<s:param name="secID" value="secID"></s:param>
														<input type="button" title="末一页" value=":"
															style="font-family: Webdings; width: 20px;">
													</s:a>
											<!-- 
											<input class="pageno" style="width: 30px; text-align: center;"
											title="跳转至" value="1" name="pageJump">&nbsp;
											<a href=""><input type="button" value="GO" title="跳转至"></a> -->
											</span>
										</div>
									</div>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<script type="text/javascript" src="skin/js/showDiv.js"></script>

		<div id="footer">
			<p>
				<span>©2014 中央民族大学哲学与宗教学学院</span> <span>地址:北京市海淀区中关村南大街4号</span> <span>邮编:100081</span>
				<span>电话:010-6893****</span>
			</p>
		</div>
	</div>
</body>
</html>