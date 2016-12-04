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
		<h2 class="page-header">资产盘点</h1>
			<div class="row m-b-sm m-t-sm">
				<div class="form-group form-inline">
					<a href="toPdAsset"><button type="button"
							class="btn btn-default btn-sm">刷新</button></a>
					<s:if test="pdStatus!=1">
					<a href="editPdAsset.action?pdStatus=1"><button type="button"
							class="btn btn-default btn-sm">开启盘点</button></a>
					</s:if>
					<s:if test="pdStatus==1">
					<a href="editPdAsset.action?pdStatus=2"><button type="button"
							class="btn btn-default btn-sm">关闭盘点</button></a>
					</s:if>
				</div>
		<div class="placeholder"></div>
		<!-- 		<table id="" class="table table-striped" cellspacing="0" width="100%"> -->
		<table id="" class="table" cellspacing="0">
			<caption>已经盘点的资产</caption>
			<thead>
				<tr>
					<th>资产编号</th>
					<th>资产型号</th>
					<th>资产类别</th>
					<th>购买时间</th>
					<th>使用时间</th>
					<th>使用人</th>
					<th>资产状况</th>
<!-- 					<th>操作</th> -->
				</tr>
			</thead>
			<tbody>
				<s:if test="pdLists.size()==0">
					<tr class="odd">
						<td valign="top" colspan="10" class="dataTables_empty">没有数据</td>
					</tr>
				</s:if>
				<s:iterator value="pdLists"
					var="ass" status="st">
					<tr>
						<td><a href="assetInfo.action?id=${ass.id}" class="Ident_a">${ass.equipIdentifier}</a></td>
						<td>${ass.equipModel}</td>
						<td>${ass.equipGenre}</td>
						<td><s:date name="#ass.lastTime " format="yyyy-MM-dd" /></td>
						<td><s:date name="#ass.lastTime " format="yyyy-MM-dd" /></td>
						<td>${ass.usePerson}</td>
						<td>${ass.condition}</td>
						<%-- <td>
							<div class="btn-group">
								<button data-toggle="dropdown"
									class="btn btn-primary btn-xs dropdown-toggle" type="button">
									<i class="fa fa-cog"></i> 操作 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a class="" href="assetInfo.action?id=${ass.id}">查看</a></li>
								</ul>
							</div>
						</td> --%>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		
		<table id="" class="table" cellspacing="0">
			<caption>未被盘点的资产</caption>
			<thead>
				<tr>
					<th>资产编号</th>
					<th>资产型号</th>
					<th>资产类别</th>
					<th>购买时间</th>
					<th>使用时间</th>
					<th>使用人</th>
					<th>资产状况</th>
<!-- 					<th>操作</th> -->
				</tr>
			</thead>
			<tbody>
				<s:if test="unPdLists.size()==0">
					<tr class="odd">
						<td valign="top" colspan="10" class="dataTables_empty">没有数据</td>
					</tr>
				</s:if>
				<s:iterator value="unPdLists"
					var="ass" status="st">
					<tr>
						<td><a href="assetInfo.action?id=${ass.id}" class="Ident_a">${ass.equipIdentifier}</a></td>
						<td>${ass.equipModel}</td>
						<td>${ass.equipGenre}</td>
						<td><s:date name="#ass.lastTime " format="yyyy-MM-dd" /></td>
						<td><s:date name="#ass.lastTime " format="yyyy-MM-dd" /></td>
						<td>${ass.usePerson}</td>
						<td>${ass.condition}</td>
						<%-- <td>
							<div class="btn-group">
								<button data-toggle="dropdown"
									class="btn btn-primary btn-xs dropdown-toggle" type="button">
									<i class="fa fa-cog"></i> 操作 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a class="" href="assetInfo.action?id=${ass.id}">查看</a></li>
								</ul>
							</div>
						</td> --%>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">


$(function(){
	var tip="${tip}";
	if(tip!=""){
		layer.msg(tip);
	}
});
</script>
</html>