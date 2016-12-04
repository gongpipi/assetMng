<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/NavigationLeft.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>二维码管理系统</title>
</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="form-horizontal">
			<div class="form-group form-inline">
				<label  class="col-sm-2 control-label">资产编号：</label>
				<span  class="col-sm-4 control-label" style="text-align:left">${asset.equipIdentifier} </span>
			</div>
			<div class="form-group form-inline">
				<label  class="col-sm-2 control-label">设备型号：</label>
				<span  class="col-sm-4 control-label" style="text-align:left">${asset.equipModel} </span>
			</div>
			<div class="form-group">
				<label for="equipGenre_input" class="col-sm-2 control-label">设备类别：</label>
				<span class="col-sm-4 control-label" style="text-align:left">${asset.equipGenre} </span>
			</div>
			<div class="form-group">
				<label for="equipGenre_input" class="col-sm-2 control-label">使用人员：</label>
				<span class="col-sm-4 control-label" style="text-align:left">${asset.usePerson} </span>
			</div>
			<div class="form-group">
				<label for="equipGenre_input" class="col-sm-2 control-label">使用部门：</label>
				<span class="col-sm-4 control-label" style="text-align:left">${asset.useDepart} </span>
			</div>
			<div class="form-group">
				<label for="usePosition_input" class="col-sm-2 control-label">使用地点：</label>
				<span class="col-sm-4 control-label" style="text-align:left">${asset.usePosition} </span>
			</div>
			<div class="form-group">
				<label for="equipGenre_input" class="col-sm-2 control-label">使用状况：</label>
				<span class="col-sm-4 control-label" style="text-align:left">${asset.condition} </span>
			</div>
			<div class="form-group">
				<label for="equipGenre_input" class="col-sm-2 control-label">设备来源：</label>
				<span class="col-sm-4 control-label" style="text-align:left">${asset.source} </span>
			</div>
			<div class="form-group">
				<label for="equipGenre_input" class="col-sm-2 control-label">资产配置：</label>
				<span class="col-sm-4 control-label" style="text-align:left">${asset.assetAllocation} </span>
			</div>	
			<div class="form-group form-inline">
				<label for="buyTime_input" class="col-sm-2 control-label">购买时间：</label> 
				<span class="col-sm-4 control-label" style="text-align: left">
					<s:date name="asset.buyTime " format="yyyy-MM-dd" />
				</span>
			</div>
			<div class="form-group form-inline">
				<label for="useTime_input" class="col-sm-2 control-label">使用时间：</label>
				<span class="col-sm-4 control-label" style="text-align:left">
					<s:date name="asset.usedTime " format="yyyy-MM-dd"/>
				</span>
			</div>
			<div class="form-group">
				<label for="equipGenre_input" class="col-sm-2 control-label">备注：</label>
				<span class="col-sm-4 control-label" style="text-align:left">${asset.remarks} </span>
			</div>	
		</div>
	</div>
</body>
</html>