<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="skin/js/jquery.min.js"></script>
<title>Before</title>
<script type="text/javascript">
	function checkParent() {
		if (window.parent.length==0) {
			window.parent.location = "Login.jsp";
		}
	}
</script>
</head>

<body onload="checkParent();">

</body>
</html>