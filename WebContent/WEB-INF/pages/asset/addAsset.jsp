<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/NavigationLeft.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>二维码管理系统</title>
</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

		<form id="addAsset_form" class="form-horizontal" method="post" >
			<input id="assetId"  type="hidden" name="asset.id"  value="${id}"/>
			<div class="form-group">
				<label for="equipGenre_input" class="col-sm-2 control-label">资产编号</label>
				<div class="col-sm-3">
					<input type="text" name="asset.equipIdentifier" class="form-control" id="equipIdent_input"
						placeholder="" value="${asset.equipIdentifier}">
				</div>
			</div>
			<div class="form-group">
				<label for="equipModel_input" class="col-sm-2 control-label">设备型号</label>
				<div class="col-sm-3">
					<input type="text" name="asset.equipModel" value="${asset.equipModel}" class="form-control" id="equipModel_input"
						placeholder="">
				</div>
			</div>
			<div class="form-group">
				<label for="equipGenre_input" class="col-sm-2 control-label">设备类别</label>
				<div class="col-sm-3">
					<input type="text" name="asset.equipGenre" value="${asset.equipGenre}" class="form-control" id="equipGenre_input"
						placeholder="">
				</div>
			</div>
			<div class="form-group">
				<label for="equipGenre_input" class="col-sm-2 control-label">使用人员</label>
				<div class="col-sm-3">
					<input type="text" name="asset.usePerson" value="${asset.usePerson}" class="form-control" id="usePerson_input"
						placeholder="">
				</div>
			</div>
			<div class="form-group form-inline">
				<label for="buyTime_input" class="col-sm-2 control-label">购买时间</label>
				<div class="col-sm-3">
					<input  type="text" name="asset.buyTime" onFocus="WdatePicker()" value="<s:date name="asset.buyTime " format="yyyy-MM-dd"/>" class="form-control" id="buyTime_input" /> 
					<img
						onclick="WdatePicker({el:'buyTime_input'})" src="${ctx}/js/My97DatePicker/skin/datePicker.gif"
						width="16" height="22" align="absmiddle"> 
				</div>
			</div>
			<div class="form-group form-inline">
				<label for="useTime_input" class="col-sm-2 control-label">开始使用时间</label>
				<div class="col-sm-3">
					<input  type="text" onFocus="WdatePicker()" name="asset.usedTime" value="<s:date name="asset.usedTime " format="yyyy-MM-dd"/>" class="form-control" id="useTime_input" /> 
					<img onclick="WdatePicker({el:'useTime_input'})"
						src="${ctx}/js/My97DatePicker/skin/datePicker.gif" width="16"
						height="22" align="absmiddle">
				</div>
			</div>
			<div class="form-group">
				<label for="usePosition_input" class="col-sm-2 control-label">使用地点</label>
				<div class="col-sm-3">
					<input type="text" name="asset.usePosition" value="${asset.usePosition}" class="form-control" id="usePosition_input"
						placeholder="">
				</div>
			</div>
			<div class="form-group">
				<label for="useDepart_input" class="col-sm-2 control-label">使用部门</label>
				<div class="col-sm-3">
					<input type="text" name="asset.useDepart" value="${asset.useDepart}" class="form-control" id="useDepart_input"
						placeholder="">
				</div>
			</div>
			<div class="form-group">
				<label for="condition_input" class="col-sm-2 control-label">使用状况</label>
				<div class="col-sm-3">
					<input type="text" name="asset.condition" value="${asset.condition}" class="form-control" id="condition_input"
						placeholder="">
				</div>
			</div>
			<div class="form-group">
				<label for="source_input" class="col-sm-2 control-label">设备来源</label>
				<div class="col-sm-3">
					<input type="text" name="asset.source" value="${asset.source}" class="form-control" id="source_input"
						placeholder="">
				</div>
			</div>
			<div class="form-group">
				<label for="assetAllocation_input" class="col-sm-2 control-label">资产配置</label>
				<div class="col-sm-3">
					<input type="text" name="asset.assetAllocation" value="${asset.assetAllocation}" class="form-control" id="assetAllocation_input"
						placeholder="">
				</div>
			</div>
			<div class="form-group">
				<label for="assetAllocation_input" class="col-sm-2 control-label">备注</label>
				<div class="col-sm-3">
					<input type="text" name="asset.assetAllocation" value="${asset.remarks}" class="form-control" id="assetAllocation_input"
						placeholder="">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="submit_btn" type="button"  class="btn btn-default">提交</button>
				</div>
			</div>			
		</form>
	</div>
<script type="text/javascript">
	$("#submit_btn").click(function(){
		if($("#assetId").val()=='0'){
			$("#addAsset_form").attr("action","addAsset.action");
		}else{
			$("#addAsset_form").attr("action","modifyAsset.action");
		}
		$("#addAsset_form").submit();
	})
</script>
</body>

</html>