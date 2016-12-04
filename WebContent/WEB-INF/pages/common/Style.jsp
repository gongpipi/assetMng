<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
<script type="text/javascript">
	var ctx = '<%=request.getContextPath()%>';
	//console.log("项目路径    ：  "+ctx);
</script>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>

<link rel="stylesheet" type="text/css" href="${ctx}/bootstrap/css/bootstrap.min.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${ctx}/bootstrap/css/bootstrap-theme.min.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${ctx}/js/dashboard.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${ctx}/js/My97DatePicker/skin/WdatePicker.css" media="screen" />

<script type="text/javascript" src="${ctx}/js/jquery-2.2.1.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/js/maintabs.js"></script>
<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
<%-- <script type="text/javascript" src="${ctx}/js/jquery-validation-1.11.1/jquery.validate.min.js"></script> --%>
<%-- <script type="text/javascript" src="${ctx}/js/jquery-validation-1.11.1/additional-methods.min.js"></script> --%>
<%-- <script type="text/javascript" src="${ctx}/js/jquery-validation-1.11.1/messages_zh.js"></script> --%>



