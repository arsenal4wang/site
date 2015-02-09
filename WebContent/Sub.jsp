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
	
</script>
<style type="text/css">
.newsTop {
	float: left;
	width: 5px;
	color: red;
}
</style>
</head>
<body>
	<input type="hidden" id="hidden" value="${secID}">
	<s:include value="Topbar.jsp"></s:include>
	<div class="wapper">
		<s:include value="Top.jsp"></s:include>
		<div id="main" class="mainbg">
			<div class="mrtop2"></div>
			<div class="content">
				<div class="snav">
					<h2>
						<s:property value="%{firstName}" />
					</h2>
					<!--  <h2>法律硕士教育</h2>-->
					<ul>
						<s:iterator value="listSubByfirst" status="status" id="s">

							<li><s:if test="%{#s.secID==isSecID}">
									<!-- 	<a class="stybtn2" id="${secID}"
										href='newsList.action?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0'>
										<s:property value="#s.subNavName" />
									</a>
 -->
									<s:if test='%{#s.showUL=="4"}'>
										<a class="stybtn2" id="${secID}"
											href='getTL?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0&showUL=<s:property value="showUL"/>'>
											<span><s:property value="#s.subNavName" /></span>
										</a>
									</s:if>
									<s:elseif test='%{#s.showUL=="3"}'>
										<a class="stybtn2" id="${secID}"
											href='getTL?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0&showUL=<s:property value="showUL"/>'>
											<span><s:property value="#s.subNavName" /></span>
										</a>
									</s:elseif>
									<s:elseif test='%{#s.showUL=="2"}'>
										<a class="stybtn2" id="${secID}"
											href='getInfo?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0&showUL=<s:property value="showUL"/>'>
											<span><s:property value="#s.subNavName" /></span>
										</a>
									</s:elseif>
									<s:else>
										<a class="stybtn2" id="${secID}"
											href='newsList?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0'>
											<span><s:property value="#s.subNavName" /></span>
										</a>
									</s:else>

								</s:if> <s:else>
									<s:if test='%{#s.showUL=="4"}'>
										<a class="stybtn1" id="${secID}"
											href='getTL?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0&showUL=<s:property value="showUL"/>'>
											<span><s:property value="#s.subNavName" /></span>
										</a>
									</s:if>
									<s:elseif test='%{#s.showUL=="3"}'>
										<a class="stybtn1" id="${secID}"
											href='getTL?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0&showUL=<s:property value="showUL"/>'>
											<span><s:property value="#s.subNavName" /></span>
										</a>
									</s:elseif>
									<s:elseif test='%{#s.showUL=="2"}'>
										<a class="stybtn1" id="${secID}"
											href='getInfo?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0&showUL=<s:property value="showUL"/>'>
											<span><s:property value="#s.subNavName" /></span>
										</a>
									</s:elseif>
									<s:else>
										<a class="stybtn1" id="${secID}"
											href='newsList?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0'>
											<span><s:property value="#s.subNavName" /></span>
										</a>
									</s:else>
									<!--	<a class="stybtn1" id="${secID}"
										href='newsList.action?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0'>
										<s:property value="#s.subNavName" />
									</a>  -->
								</s:else></li>
							<!-- 	<li><s:if test='%{#s.secID==isSecID}'>
									<a class="stybtn2" id="${secID}"
										href='newsList.action?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0'>
										<s:property value="#s.subNavName" />
									</a>
								</s:if> <s:else>
									<a class="stybtn1" id="${secID}"
										href='newsList.action?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0'>
										<s:property value="#s.subNavName" />
									</a>
								</s:else></li> -->
						</s:iterator>
					</ul>
					<div class="ovbox"></div>
				</div>
				<div class="pagemain">
					<em>位置：<a href="welcome.action">首页</a> &gt;<a>
					<s:property value="%{firstName}" /></a>
					 <s:if test="isNav==0">&gt;<a>
					 <s:property value="%{secondName}" /></a>
						</s:if>
					</em>
					<div class="pgwapper">
						<div class="mainbox">
							<ul class="listext">
								<div id="list" class="list">
									<div class="loading" style="display: none;">
										<img src="skin/images/loading.gif" alt="正在加载...">
									</div>
									<ul class="lcontent">
										<s:iterator value="listNewsTop" status="status" id="s">
											<s:if test='%{#s.isTop=="1"}'>
												<li><span><s:property value="%{subDate}" /></span>
													<div class="title_show" style="width: 530px;">
														<a
															href='readNews.action?newsID=<s:property value="newsID"/>&navID=<s:property value="navID"/>&secID=<s:property value="secSecID"/>'
															target="_self"
															title='<s:property value="%{newsTitle}" />'> [<s:property
																value="%{secSecName}" />]<!-- 
															<span class="newsTop" style="float: left;width: 5px;color: red;">[顶]</span> -->
															<s:property value="%{newsTitle}" />
															<font style="color: red;">(顶)</font> 
															<s:if test='%{#s.haveFile=="1"}'>
																<font style="color: red;">(附)</font>
															</s:if>
														</a>
													</div></li>
											</s:if>
											<s:else>
												<li><span><s:property value="%{subDate}" /></span>
													<div class="title_show" style="width: 530px;">
														<a
															href='readNews.action?newsID=<s:property value="newsID"/>&navID=<s:property value="navID"/>&secID=<s:property value="secSecID"/>'
															target="_self"
															title='<s:property value="%{newsTitle}" />'> [<s:property
																value="%{secSecName}" />]<s:property
																value="%{newsTitle}" /> <s:if
																test='%{#s.haveFile=="1"}'>
																<font style="color: red;">(附)</font>
															</s:if>
														</a>
													</div></li>
											</s:else>
										</s:iterator>
									</ul>
									<div class="clr"></div>
									<div class="listfoot">
										<span class="pagenum">共<s:property value="allNum" />
											条, 第 <s:property value="page" /> 页 / 共 <s:property
												value="pageAll" /> 页
										</span> 
										
										<span class="pagecontrol"> 
										<a href='newsList.action?navID=<s:property value="navID" />&secID=<s:property value="secID" />&isNav=<s:property value="isNav" />&page=1'>
										<input type="button" title="第一页" value="9" style="font-family: Webdings; width: 20px;">
										</a>
										<s:if test="page==1">
										<input type="button" title="前一页" value="3" style="font-family: Webdings; width: 20px;">
										</s:if> 
										<s:else>
										<a href='newsList.action?navID=<s:property value="navID" />&secID=<s:property value="secID" />&isNav=<s:property value="isNav" />&page=<s:property value="page-1"/>'>
										<input type="button" title="前一页" value="3" style="font-family: Webdings; width: 20px;">
										</a>
										</s:else> 
										<s:if test="page==pageAll"> 
										<input type="button" title="后一页" value="4" style="font-family: Webdings; width: 20px;">
										</s:if>
										<s:else>
										<a href='newsList.action?navID=<s:property value="navID" />&secID=<s:property value="secID" />&isNav=<s:property value="isNav" />&page=<s:property value="page+1"/>'>
										<input type="button" title="后一页" value="4" style="font-family: Webdings; width: 20px;">
										</a>
										</s:else> 
										<a href='newsList.action?navID=<s:property value="navID" />&secID=<s:property value="secID" />&isNav=<s:property value="isNav" />&page=<s:property value="pageAll"/>'>
										<input type="button" title="末一页" value=":" style="font-family: Webdings; width: 20px;">
										</a>
										</span>
									</div>
								</div>
							</ul>
						</div>
					</div>
				</div>
				<div class="clr"></div>
			</div>
			<div class="boxbg"></div>
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