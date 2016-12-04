<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="Style.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>二维码管理系统</title>
</head>
<body>
	  <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">二维码管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
<!--             <li><a href="#">登录</a></li> -->
          </ul>
        </div>
      </div>
    </nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li<c:if test="${session.colId==1||session.colId==''}"> class="active"</c:if>><a href="listAsset.action?colId=1">资产管理 <span class="sr-only"></span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li <c:if test="${session.colId==2}"> class="active"</c:if>>
						<a href="#" data-toggle="dropdown" class="dropdown-toggle">
							资产盘点<span class="caret"></span>
						</a>
						<ul class="col-sm-12 col-md-12 dropdown-menu">
							<li><a href="toPdAlreadyAsset.action?colId=2">已盘点</a></li>
							<li><a href="toPdNotAsset.action?colId=2">未盘点</a></li>
						</ul>
					</li>
				</ul>
				<ul class="nav nav-sidebar">
					<li <c:if test="${session.colId==3}"> class="active"</c:if>><a href="">用户管理</a></li>
				</ul>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
</script>
</html>