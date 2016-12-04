<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" media="screen" />
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.min.css" media="screen" />
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-validation-1.11.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery-validation-1.11.1/additional-methods.min.js"></script>
<script type="text/javascript" src="js/jquery-validation-1.11.1/messages_zh.js"></script>

<title>资产信息</title>
</head>
<body>
	<table class="table table-striped">
   <caption></caption>
   <thead>
      <tr>
         <th colspan="2" style='text-align: center;' >资产信息</th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td style='text-align: center;'>资产编号</td>
         <td style='text-align: center;'>${asset.equipIdentifier }</td>
      </tr>
      <tr>
         <td style='text-align: center;'>设备类别</td>
         <td style='text-align: center;'>${asset.equipGenre }</td>
      </tr>
      <tr>
         <td style='text-align: center;'>设备型号</td>
         <td style='text-align: center;'>${asset.equipModel}</td>
      </tr>
      <tr>
         <td style='text-align: center;'>使用人员</td>
         <td style='text-align: center;'>${asset.usePerson }</td>
      </tr>
      <tr>
         <td style='text-align: center;'>使用部门</td>
         <td style='text-align: center;'>${asset.useDepart }</td>
      </tr>
      <tr>
         <td style='text-align: center;'>使用地点</td>
         <td style='text-align: center;'>${asset.usePosition }</td>
      </tr>
      <tr>
         <td style='text-align: center;'>使用状况</td>
         <td style='text-align: center;'>${asset.condition }</td>
      </tr>
      <tr>
         <td style='text-align: center;'>设备来源</td>
         <td style='text-align: center;'>${asset.source }</td>
      </tr>
      <tr>
         <td style='text-align: center;'>资产配置</td>
         <td style='text-align: center;'>${asset.assetAllocation }</td>
      </tr>
      <tr>
         <td style='text-align: center;'>购买时间</td>
         <td style='text-align: center;'>  <s:date name="asset.buyTime " format="yyyy-MM-dd" /> </td>
      </tr>
      <tr>
         <td style='text-align: center;'>开始使用时间</td>
         <td style='text-align: center;'><s:date name="asset.lastTime " format="yyyy-MM-dd" /></td>
      </tr>
      
   </tbody>
</table>
<span  style="text-align:left">备注：${asset.remarks } </span>
	 <div class="alert alert-warning" style="display:none" id="warn_div">
	   <a href="#" class="close" data-dismiss="alert" >
	      &times;
	   </a>
	   <strong>${tip}</strong>
	</div> 
	<script>
		$(function(){
			var tip="${tip}";
			if(tip!=""){
				$("#warn_div").show();
				setTimeout(function(){$("#warn_div").fadeOut("slow");},2000);
			}else{
				$("#warn_div").hide();
			}
		}); 
	</script> 
	
</body>
</html>