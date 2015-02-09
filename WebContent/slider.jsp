<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<script>
	window.g_config = {
		appId : 2,
		assetsHost : "http://assets.taobaocdn.com"
	};
</script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="GENERATOR" content="MSHTML 8.00.6001.19046">
<style type="text/css">
.sliderLi {
	display: block;
	opacity: 0;
	position: absolute;
	z-index: 1;
	transition: none 500ms linear;
	-webkit-transition: none 500ms linear;
}

.sliderLi img,.sliderA {
	WIDTH: 980px;
	HEIGHT: 300px
}
</style>
<link href="skin/css/slider.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="skin/js/slider1.js"></script>
</head>
<body>
	<div id="content">

		<div style="WIDTH: 980px; HEIGHT: 300px"
			class="slider-promo J_Slider J_TWidget"
			data-widget-config="{'effect':'fade','contentCls': 'lst-main', 'navCls': 'lst-trigger', 'activeTriggerCls': 'current'}"
			data-widget-type="Slide" data-type="fade">
			<ul class="lst-main">
				<!--<li class="sliderLi"><a class="sliderA" target="_blank"><img
						src="skin/images2/3.jpg" alt=""></a></li>  -->
				<s:iterator value="picSliderlist" id="pic">
					<s:if test="%{#pic.newsID!=-1}">
						<li class="sliderLi"><a class="sliderA" target="_blank"
							title='<s:property value="newsTitle"/>' href='readNews?newsID=<s:property value="newsID"/>&navID=<s:property value="navID"/>&secID=<s:property value="secID"/>'> <img
								src="<s:property value='picLocation'/>" alt=""></a></li>
					</s:if>
					<s:else>
						<li class="sliderLi"><a class="sliderA" target="_blank"
							title='<s:property value="newsTitle"/>'
							href='<s:property value="href"/>'> <img
								src="<s:property value='picLocation'/>" alt="">
						</a></li>
					</s:else>
				</s:iterator>
			</ul>
			<ul class="lst-trigger">
				<s:iterator value="picSliderlist" id="pic" status="status">
					<s:if test="#status.first">
						<li class="current"><s:property value="#status.index+1" /></li>
					</s:if>
					<s:else>
						<li><s:property value="#status.index+1" /></li>
					</s:else>
				</s:iterator>
				<!-- 
				<li class="current">1</li>
				<li class="">2</li>
				<li class="">3</li> -->
			</ul>
		</div>
	</div>
	<script type="text/javascript">
		TShop.use('initFP', function(T) {
			TShop.initFP();
			//如果是预览页面加上：
			var S = KISSY, D = S.DOM, E = S.Event;
			var elBtn = S.get('#J_BtnClose');
			E.on(elBtn, 'click', function(evt) {
				evt.preventDefault();
				window.open('', '_self', '');
				window.close();
			});
		});
	</script>
	<div id="popupPanel"></div>
</body>
</html>