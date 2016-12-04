<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" media="screen" />
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.min.css" media="screen" />
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-validation-1.11.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery-validation-1.11.1/additional-methods.min.js"></script>
<script type="text/javascript" src="js/jquery-validation-1.11.1/messages_zh.js"></script>

<title>Insert title here</title>
</head>
<body>
	<img src="${webRoot}/getQRcode.action?text=www.chinac.com"/>
	
	<button class="btn btn-primary btn-lg" data-toggle="modal" 
	   data-target="#File_upload_panel">
	   	批量添加
	</button>
	<a href="${webRoot }/exportAssetExcel.action">下载</a>
	

<div class="modal fade" id="File_upload_panel" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <form action="upload.action" method="post" id="uploadFileForm" enctype="multipart/form-data">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
             	 上传文件
            </h4>
         </div>
         <input type="hidden" name="fileName" value="123" />
         <div class="modal-body">
         	<s:file type="file" name="file" id="file"> 上传文件</s:file>
         	<!-- <input type="file" name="file">   -->
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="submit" class="btn btn-primary">
              	提交
            </button>
         </div>
      </div><!-- /.modal-content -->
	</div>
	</form>
</div>


	<script>
		
	</script>
	
</body>
</html>