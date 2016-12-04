<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/Style.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/jQueryPrint/js/jQuery.print.js"></script>
<title>二维码管理系统</title>
</head>
<body>

	<s:iterator value="QRcodeUrl" var="codeUrl">
		<img src="${webRoot}${codeUrl}" style="width: 200px; height: 200px">
	</s:iterator>
</body>
<script>
</script>

</html>