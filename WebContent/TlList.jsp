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
							<!--  	<li><s:if test="%{#s.secID==isSecID}">
									<a class="stybtn2" id="${secID}"
										href='newsList.action?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0'>
										<s:property value="#s.subNavName" />
									</a>
								</s:if> <s:else>
									<a class="stybtn1" id="${secID}"
										href='newsList.action?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0'>
										<s:property value="#s.subNavName" />
									</a>
								</s:else></li>-->
						</s:iterator>
					</ul>
					<div class="ovbox"></div>
				</div>
				<div class="pagemain">
					<em>位置：<a>首页</a> &gt;<a><s:property value="%{firstName}" /></a>
						&gt;<a><s:property value="%{secondName}" /></a>
					</em>
					<div class="pgwapper">
						<div class="mainbox">
							<table class='teacher_list'>
								<s:iterator value="tlList" id="id">
									<tr>
										<th colspan='2'><a style='color: #143A83;' href='#'><s:property
													value="%{tlName}" /></a></th>
									</tr>
									<tr>
										<td>
											<ul>
												<s:iterator value="teaLea_list" id="tlid">
													<s:if test="%{#tlid.tlID==#id.tlID}">
														<li class="teacherLi" style='width: 317px; height: 25px;'><a
															target='_blank'
															href='getTLinfo?teaLeaID=<s:property value="teaLeaID" />&secID=<s:property value="secID" />&navID=<s:property value="navID" />&isNav=0&isTL=<s:property value="tlID"/>'><s:property
																	value="teaLeaName" /></a></li>
													</s:if>

													<!-- 
													<a class="stybtn2" id="${secID}"
														href='getInfo?secID=<s:property value="#s.secID" />&navID=<s:property value="secIDforSub" />&isNav=0&showUL=<s:property value="showUL"/>'>
														<span><s:property value="#s.subNavName" /></span>
													</a> -->
												</s:iterator>
											</ul>
										</td>
									</tr>
								</s:iterator>
								<!--  		<tr>
									<th colspan='2'><a style='color: #143A83;'
										href='organization_show.#'>法学类</a></th>
								</tr>
								<tr>
									<td>
										<ul>
											<li class="teacherLi" style='width: 317px; height: 25px;'><a
												target='_blank' href='#'>法学研究所</a></li>
										</ul>
									</td>
								</tr>-->
							</table>

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
				<span>2014 中央民族大学哲学与宗教学学院</span> <span>地址:北京市海淀区中关村南大街4号</span> <span>邮编:100081</span>
				<span>电话:010-6893****</span>
			</p>

		</div>

	</div>
</body>
</html>