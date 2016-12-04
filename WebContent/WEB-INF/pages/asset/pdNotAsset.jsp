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
				<div class="col-md-4 f-r form-group form-inline">
					<a href="toPdNotAsset"><button type="button"
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
				<div class="col-md-4 f-r">
					<div class="input-group">
						<input type="text" class="form-control" value="${temp }"
							name="temp" placeholder="请输入资产型号" style="height: 30px;">
						<span class="input-group-btn"><button
								class="btn btn-primary btn-sm" type="submit" id="search_btn">搜索</button>
						</span>
					</div>
				</div>
		<div class="placeholder"></div>	
		<table id="" class="table" cellspacing="0">
			<caption>未被盘点的资产  共  ${pageNumAll} 个</caption>
			<thead>
				<tr>
					<th>资产编号</th>
					<th>资产型号</th>
					<th>资产类别</th>
					<th>购买时间</th>
					<th>使用时间</th>
					<th>使用人</th>
					<th>资产状况</th>
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
					</tr>
				</s:iterator>
			</tbody>
		</table>
				<div class="form-inline">
					<ul class="pagination pull-left">
						<li>第${pageSizeCurr}</li>
						<li>/</li>
						<li>${pageSizeALL}页</li>
						<li>&nbsp</li>
						<li>共${querySum}条记录</li>
					</ul>
					<ul class="pagination pull-right">
						<li value=""><a>&laquo;</a></li>
						<s:iterator value="pagingArr" var="page" status="st">
							<li value="${page}"><a>${page}</a></li>
						</s:iterator>
						<li value=""><a>&raquo;</a></li>
					</ul>
				</div>
			</div>
</body>
<script type="text/javascript">

$(function(){
	if($("#pageCurr_hi").val()== "1"){
		$(".pull-right li:first").hide();
// 		alert("当前页"+$("#pageCurr_hi").val())
	}else{
		first =parseInt($("#pageCurr_hi").val());
		$(".pull-right li:first").attr("value",first-1);
	}
	
	if($("#pageCurr_hi").val()==$("#pageAll_hi").val()|| $("#pageAll_hi").val()=="3"){
// 		alert("当前页"+$("#pageCurr_hi").val())
// 		alert("当前页"+$("#pageAll_hi").val())
		$(".pull-right li:last").hide();
	}else{		
		last=parseInt($("#pageCurr_hi").val());
		$(".pull-right li:last").attr("value",last+1);
	}

	$(".pull-right li").click(function(){
		$("#pageCurr_hi").val($(this).attr("value"));
		$("#search_btn").click();
	});	
})

$(function(){
	var tip="${tip}";
	if(tip!=""){
		layer.msg(tip);
	}
});
</script>
</html>