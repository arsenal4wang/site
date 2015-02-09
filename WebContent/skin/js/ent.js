	function getDate(){
		var myDate = new Date();
		myDate.getFullYear(); //获取完整的年份(4位,1970-????)
		myDate.getMonth(); //获取当前月份(0-11,0代表1月)
		myDate.getDate(); //获取当前日(1-31)
		var year = myDate.getFullYear();
		var month = myDate.getMonth() + 1;
		var day = myDate.getDate();
		var day = year + "年" + month + "月" + day + "日";
		//	alert(day);
		$("#date").html(day);
		switch (myDate.getDay()) {
		case 1:
			$("#day").html("星期一");
			break;
		case 2:
			$("#day").html("星期二");
			break;
		case 3:
			$("#day").html("星期三");
			break;
		case 4:
			$("#day").html("星期四");
			break;
		case 5:
			$("#day").html("星期五");
			break;
		case 6:
			$("#day").html("星期六");
			break;
		case 7:
			$("#day").html("星期日");
			break;
		}
	}
function getVisitTime() {
	var href = "getStastic.action";
	$.getJSON(href, function(data) {
		if (data.success) {
			$.each(data.statistic, function(i, it) {
				$("#statistic").html(it.visitTimes);
			});
		} else {
			alert("服务器返回了未知的数据");
		}
	});
}

var userName = "";
function logout() {
	Login.logout(logoutBack);
}
function logoutBack(rtn) {
	location = '/';
}
function change() {
	if ($("#menuleve").val() != null || $("#menuleve").val() != ""
			|| $("#menuleve").val() != "undefined") {
		var url = $("#menuleve").val().split("-")[0];
		var target = $("#menuleve").val().split("-")[1];
		if (target == "_self") {
			location.href = url;
		} else {
			window.open(url);
		}
	}
}
function showUser(name) {
	$("#user").html(name + "欢迎您！");
	$("#userbox").show();
	$("#login").hide();
}
var pid = 725;
function hiddenTips() {
	if ($("#keywords").val() == $("#keywords").attr("title")) {
		$("#keywords").val("");
		$("#keywords").css({
			"color" : ""
		});
	}
}
function showTips() {
	if ($("#keywords").val() == "") {
		$("#keywords").val($("#keywords").attr("title"));
		$("#keywords").css({
			"color" : "#909090"
		});
	}
}

function guestbook_show() {
	$("#guestbook_show").toggle();
}

// 收索 选中分类
function choseType_show() {
	$("DIV[class='chose']").show();
}
function choseType_hid() {
	$("DIV[class='chose']").hide();
}
function swapChose(obj) {
	$("#chose").attr("checkedid", obj.id);
	$("#chose").attr("checkedname", $(obj).text());
	$("#chose").text($(obj).text());
	choseType_hid();
}

function queryKey() {
	var id = $("#chose").attr("checkedid");
	if (id == -1) {
		alert("请选择类别！");
		$("form").submit(function(e) {
			e.preventDefault();
		});
	} else {
		var _keywords = $("#keywords").val();
		$("#hiddenSecID").val(id);
		$("form").submit();
	}
}