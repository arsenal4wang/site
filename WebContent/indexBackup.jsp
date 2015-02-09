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
<script type="text/javascript" src="skin/js/showDiv.js"></script>
<script type="text/javascript" src="skin/js/marquee/demo.js"></script>

<script type="text/javascript">
	function teacher_show() {
		$("#teacher").attr("class", "szbtn2");
		$("DIV[class='xylist']").show();
	}
	function teacher_hid() {
		$("#teacher").attr("class", "szbtn");
		$("DIV[class='xylist']").hide();
	}
	$(function() {

	});
</script>

<style type="text/css">
.scroll div {
	height: 30px;
}
</style>
</head>
<body>
	<s:include value="Topbar.jsp"></s:include>

	<div class="wapper">
		<s:include value="Top.jsp"></s:include>
		<s:include value="slider.jsp"></s:include>
		<div id="main"
			style="background: url(skin/images/index_main.gif) 0 0 repeat-y;">
			<div class="mrtop1"></div>
			<div class="content">
				<div class="leftbox">
					<div class="pubox_left">
						<div class="" style="">
							<div class="main_list_l left"
								style="margin-right: 5px; width: 500px;">
								<s:include value="Newest.jsp"></s:include>
							</div>
							<div class="main_list_s left"
								style="margin-right: 5px; width: 190px;">
								<!-- 	<h2 style="width: 160px;">院长寄语</h2> -->
								<h2 style="width: 160px;">
									<s:property value="%{s2.contentName}" />
								</h2>
								<div>
									<p style="font-size:10px;">
										${shortNews}
									</p>
									<span>更多</span>
								</div>
							</div>
						</div>

						<div class="clr"></div>
						<div class="" style="">
							<s:iterator value="list1" id="id">
								<div class="main_list left" style="margin-right: 5px;">
									<h2>
										<s:property value="contentName" />
										<s:if test='%{#id.isFirst=="Y"}'>
											<a class="more" target="_blank"
												href='newsList?isNav=1&navID=<s:property value="secID"/>'>更多</a>
										</s:if>
										<s:else>
											<a class="more" target="_blank"
												href='newsList?isNav=0&navID=<s:property value="secIDforSub"/>&secID=<s:property value="secID"/>'>更多</a>
										</s:else>
									</h2>
									<ul>
										<s:if test='%{#id.isFirst=="N"}'>
											<s:iterator value="listNews" id="news">
												<s:if test="%{#news.secSecID==#id.secID}">
													<li><s:a title="%{titleFake}" target="_blank"
															action="readNews.action">
															<s:param name="newsID" value="newsID"></s:param>
															<s:param name="navID" value="secFirstID"></s:param>
															<s:param name="secID" value="secSecID"></s:param>
															<s:property value="%{newsTitle}" />
															<span><s:property value="%{subDate}" /></span>
															<s:if test="%{#news.latest=='newer'}">
																<img class="new" alt="" src="skin/images/new.gif">
															</s:if>
														</s:a></li>
												</s:if>
											</s:iterator>
										</s:if>
										<s:else>
											<s:iterator value="listNews" id="news">
												<s:if test="%{#news.secFirstID==#id.secID}">
													<li><s:a title="%{titleFake}" target="_blank"
															action="readNews.action">
															<s:param name="newsID" value="newsID"></s:param>
															<s:param name="navID" value="secFirstID"></s:param>
															<s:param name="secID" value="secSecID"></s:param>
															<s:property value="%{newsTitle}" />
															<span><s:property value="%{subDate}" /></span>
															<s:if test="%{#news.latest=='newer'}">
																<img class="new" alt="" src="skin/images/new.gif">
															</s:if>
														</s:a></li>
												</s:if>
											</s:iterator>
										</s:else>
									</ul>
								</div>
							</s:iterator>
						</div>
						<s:include value="Phil.jsp"></s:include>

						<div class="">
							<s:iterator value="list2" id="id">
								<div class="main_list left" style="margin-right: 5px;">
									<h2>
										<s:property value="contentName" />
										<s:if test='%{#id.isFirst=="Y"}'>
											<a class="more" target="_blank"
												href='newsList?isNav=1&navID=<s:property value="secID"/>'>更多</a>
										</s:if>
										<s:else>
											<a class="more" target="_blank"
												href='newsList?isNav=0&navID=<s:property value="secIDforSub"/>&secID=<s:property value="secID"/>'>更多</a>
										</s:else>
									</h2>
									<ul>
										<s:if test='%{#id.isFirst=="N"}'>
											<s:iterator value="listNews" id="news">
												<s:if test="%{#news.secSecID==#id.secID}">
													<li><s:a title="%{titleFake}" target="_blank"
															action="readNews.action">
															<s:param name="newsID" value="newsID"></s:param>
															<s:param name="navID" value="secFirstID"></s:param>
															<s:param name="secID" value="secSecID"></s:param>
															<s:property value="%{newsTitle}" />
															<span><s:property value="%{subDate}" /></span>
															<s:if test="%{#news.latest=='newer'}">
																<img class="new" alt="" src="skin/images/new.gif">
															</s:if>
														</s:a></li>
												</s:if>
											</s:iterator>
										</s:if>
										<s:else>
											<s:iterator value="listNews" id="news">
												<s:if test="%{#news.secFirstID==#id.secID}">
													<li><s:a title="%{titleFake}" target="_blank"
															action="readNews.action">
															<s:param name="newsID" value="newsID"></s:param>
															<s:param name="navID" value="secFirstID"></s:param>
															<s:param name="secID" value="secSecID"></s:param>
															<s:property value="%{newsTitle}" />
															<span><s:property value="%{subDate}" /></span>
															<s:if test="%{#news.latest=='newer'}">
																<img class="new" alt="" src="skin/images/new.gif">
															</s:if>
														</s:a></li>
												</s:if>
											</s:iterator>
										</s:else>
									</ul>
								</div>
							</s:iterator>
						</div>

					</div>
					<div class="clr"></div>
					<div class="friendlink">
						<dl>
							<dt>友情链接：</dt>
							<s:iterator value="linkList" id="link">
								<dd>
									<a href='<s:property value="#link.webAddr"/>'
										title='<s:property value="#link.webName"/>' target="_blank"><s:property
											value="#link.webName" /></a>
								</dd>
							</s:iterator>
						</dl>
					</div>
				</div>
				<div class="rightbox">
					<div class="syslink">
						<ul>
							<s:iterator value="listRight" id="id">
								<li><a target="_blank"
									href='newsList?navID=<s:property value="secID" />&isNav=1'><s:property
											value="#id.secName" /></a></li>
							</s:iterator>
							<!-- 	<li><a target="_blank" href="#">招生就业</a></li>-->
						</ul>
					</div>

					<div class="mail">
						<ul>

							<li><a class="yzmail_1" href="javascript:showid('nic');">书记</a></li>
							<li><a class="yzmail_2" href="javascript:showid('tang');">院长</a></li>
							<!--	<li><a class="kwmail" href="#">院办刊物</a></li>  
							<li><a class="fysmail" target="_blank" href="#">院庆</a></li>
							<li><a class="fysmail" target="_blank" href="#">主题团日竞赛</a></li>-->
						</ul>
					</div>

					<div class="intrduce">
						<div class="topbg"></div>
						<dl>
							<!--<dd style="z-index: 999;">
								<a id="teacher" class="szbtn" target="_blank" href="#"
									onmouseover="teacher_show();" onmouseout="teacher_hid();">资料下载</a>
								<div class="xylist" style="display: none;"
									onmouseover="teacher_show();" onmouseout="teacher_hid();">
									<ul>
										<li><a class="flist" target="_blank" href="#">软件资源</a></li>
										<li><a class="flist" target="_blank" href="#">文档资源</a></li>
										<li><a class="flist" target="_blank" href="#">文档资源</a></li>
									</ul>
									<div class="fbottom"></div>
								</div>
							</dd>
							<dd>
								<a class="jgbtn" href="#" target="_blank">学院机构</a>
							</dd>-->
							<dd>
								<a class="jsbtn" href="http://localhost:8080/EntAdmin/"
									target="_blank">后台登录</a>
							</dd>
							<dd>
								<a class="jsbtn" href="http://my.muc.edu.cn/" target="_blank">信息门户</a>
							</dd>
							<dd>
								<a class="jsbtn" href="#" target="_blank">联系我们</a>
							</dd>
						</dl>
					</div>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<div id="footer">
			<p>
				<span>©2014 中央民族大学哲学与宗教学院</span> <span>地址:北京市海淀区中关村南大街</span> <span>邮编:100081</span>
				<span>电话:010-6893****</span>
			</p>
		</div>
	</div>
	<div id="nic" style="display: none;">书记信箱:abcd@163.com</div>
	<div id="tang" style="display: none;">院长信箱:efgh@126.com</div>


	<style type="text/css">
.hidden {
	display: none;
}

#memail {
	width: 200px;
	height: 30px;
	padding: 8px 10px 10px;
	background-color: #FFFFFF;
	border: 1px solid #05549d;
	color: #333333;
	line-height: 24px;
	text-align: center;
	-webkit-box-shadow: 5px 2px 6px #000;
	-moz-box-shadow: 3px 3px 6px #555;
}

#tang {
	width: 200px;
	height: 30px;
	padding: 8px 10px 10px;
	background-color: #FFFFFF;
	border: 1px solid #05549d;
	color: #333333;
	line-height: 24px;
	text-align: center;
	-webkit-box-shadow: 5px 2px 6px #000;
	-moz-box-shadow: 3px 3px 6px #555;
}

#nic {
	width: 200px;
	height: 30px;
	padding: 8px 10px 10px;
	background-color: #FFFFFF;
	border: 1px solid #05549d;
	color: #333333;
	line-height: 24px;
	text-align: center;
	-webkit-box-shadow: 5px 2px 6px #000;
	-moz-box-shadow: 3px 3px 6px #555;
}
</style>
</body>
</html>