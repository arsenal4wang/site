//生成图片以代选择
function getPic(){
	var text = $("#content").val();
	var num = 0, check;
	check = text.indexOf("<img");
	if (check == 0){
		num++;
	}else {
		check = 0;
	}
	while (check != -1) {
		check = text.indexOf("<img", check + 1);
		num++;
	}
	num--;
	var strArr=new Array([num]);
	var start=0;
	for (var s = 0; s < num; s++) {
		start = text.indexOf("src", start);
		var end = text.indexOf("alt", start);
		strArr[s] = text.substring(start + 5, end - 2);
		start++;
	}$("#selectPic").empty;
	for (var length = 0; length < num; length++) {
		var x=strArr[length].lastIndexOf("/");
		var name=strArr[length].substring(x+1);
		 $("#selectPic").append("<option value="+strArr[length]+">"+name+"</option>");
	}
}
function menuseclect() {
	var href = "getMenu.action";
	// 清空，否则菜单会叠加，造成越来越长
	$("#secFirst").empty();
	$("#secSec").empty();
	$.getJSON(href, function(data) {
		if (data.success) {
			
			// 显示一级菜单
			$.each(data.secFirst, function(i, it) {
				// alert("ID.." + it.firstID + "..Name.." + it.firstName);
				$("#secFirst").append(
						"<option value=" + it.secID + ">" + it.secName
								+ "</option>");
			});
			$.each(data.secSec, function(i, it) {				
		/*	按登录人的ID生成
		 * 	if (data.catlog[i].firstID == 1) {
					$("#secSec").append(
							"<option  value=" + it.secondID + ">"
									+ it.secondName + "</option>");
				} else {
					$("#secSec").append(
							"<option  value=" + it.secondID + ">"
									+ it.secondName + "</option>");
				}*/
			});
		} else {
			alert("服务器返回了未知的数据");
		}
	});

	// 显示二级菜单
	$("#secFirst").change(function() {
	});
}
/**/
function menuseclect_showsecond() {
	// 清空，否则菜单会叠加，造成越来越长
	$("#secSec").empty();
	var t = $("#secFirst").val();
	var href = "getMenu.action";
	$.getJSON(href, function(data) {
		if (data.success) {
			$.each(data.secSec, function(i, it) {
				if (data.secSec[i].secIDforSub == t) {
					$("#secSec").append(
							"<option value=" + it.secID + ">"
									+ it.subNavName + "</option>");
				}
			});
		}
	});
}
function check_del() {
	if (confirm("确认删除吗")) {
	} else {
		return false;
	}
}
// 添加模块时
function check_checked(which) {
	$("#sub").attr("disabled", false);
	var mark = $(which).attr("flag");
	var mark2 = $(which).attr("flag2");
	$("#" + mark2 + "_text").attr("readOnly", true);
	$("#" + mark + "_text").attr("readOnly", false);
	$("#" + mark2 + "_select").hide();
	$("#" + mark + "_select").show();
}
/** ******** */
// 全选
function selectAll() {
	$("input[name='check_id']").each(function() {
		this.checked = true;
	});
}
// 全部取消
function cancelAll() {
	$("input[name='check_id']").attr("checked", false);
}
// 反选
function reverse() {
	$("input[name='check_id']").each(function() {
		if (this.checked) {
			this.checked = false;
		} else {
			this.checked = true;
		}
	});
}

function checkusername() {

	var username = $("#adminUser").val();
//	alert(username);
	if (username == "") {
	//	alert(username);
		$("#empty").show();
	} else {
		var content = {
			"adminName" : username
		};
		$.ajax({
			type : "post",
			url : "checkUserExist.action",
			data : content,
			dataType : "json",
			success : function(data) {
				if (data.success) {
					$("#empty").hide();
					$("#notexsit").hide();
					$("#exsit").show();
					$("#submit").attr("disabled", "false");
				} else {
					$("#empty").hide();
					$("#notexsit").show();
					$("#exsit").hide();
					$("#submit").removeAttr("disabled");
				}
			},
			error : function() {
				alert("请求失败");
			}
		});
	}
}

// 生成网址分类和网址导航
function navList() {
	var href = "getNaviListJSON.action";
	// 清空，否则菜单会叠加，造成越来越长
	$("#naviList").empty();
	$("#naviList2").empty();
	$.getJSON(href, function(data) {
		if (data.success) {
			$.each(data.navilist, function(i, it) {
				$("#naviList").append(
						"<option value=" + it.id + ">" + it.navigate
								+ "</option>");
				$("#naviList2").append(
						"<option value=" + it.id + ">" + it.navigate
								+ "</option>");
			});
		} else {
			alert("服务器返回了未知的数据");
		}
	});
}
function webClassList() {
	var href = "getWebClassListJSON.action";
	// 清空，否则菜单会叠加，造成越来越长
	$("#webClass").empty();
	$.getJSON(href, function(data) {
		if (data.success) {
			$.each(data.webClassList, function(i, it) {
				$("#webClass").append(
						"<option value=" + it.webClassId + ">" + it.webCName
								+ "</option>");
			});
		} else {
			alert("服务器返回了未知的数据");
		}
	});
}/**/