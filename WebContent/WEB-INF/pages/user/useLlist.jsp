<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../common/NavigationLeft.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>二维码管理系统</title>
</head>
<body style="height: 100%">
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <!-- 	  <nav class="navbar  navbar-fixed-static" bo> -->
    <!-- 	  		<h5 style="font-size:20px"><b>资产列表</b></h5> -->
    <!-- 	  </nav> -->
    <h2 class="page-header">用户列表</h2>
        <div class="row m-b-sm m-t-sm">
            <div class="col-md-1">
                <a href="listAsset"><button type="button"
                                            class="btn btn-default btn-sm">刷新</button></a>
            </div>
            <form class="form-horizontal" action="listAsset.action"
                  method="post" id="searchForm">
                <div class="col-md-5">
                    <button class="btn btn-default btn-sm" type="button"
                            id="deleteMany_btn">删除</button>
                    <a href="to_addAsset.action"><button type="button"
                                                         class="btn btn-default btn-sm" id="entry_btn">添加</button></a>
                    <button type="button" class="btn btn-default btn-sm" id="download_btn" onclick="download();">导出表格</button>
                </div>
                <div class="col-md-4 f-r">
                    <div class="input-group">
                        <input type="text" class="form-control" value="${temp }" name="temp"
                               placeholder="请输入用户名" style="height:30px;"> <span
                            class="input-group-btn"><button
                            class="btn btn-primary btn-sm" type="submit" id="search_btn">搜索</button> </span>
                    </div>
                </div>
                <input id="pageCurr_hi" name="pageSizeCurr" type="hidden" value="${pageSizeCurr}"/>
                <input id="pageAll_hi" name="pageSizeALL" type="hidden" value="${pageSizeALL}"/>
            </form>
        </div>
        <div class="placeholder"></div>
        <!-- 		<table id="" class="table table-striped" cellspacing="0" width="100%"> -->
        <form class="form-horizontal" action="" method="post" id="user_Form" target="_blank">
            <table id="" class="table" cellspacing="0">
                <thead>
                <tr>
                    <th>
                        <input autocomplete="off" type="checkbox" id="CheckedAll"
                               onclick="checkAll()">
                    </th>
                    <th>用户名</th>
                    <th>角色</th>
                    <th>添加时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <s:if test="userLists.size()==0">
                    <tr class="odd">
                        <td valign="top" colspan="10" class="dataTables_empty">没有数据</td>
                    </tr>
                </s:if>
                <s:iterator value="userLists"
                            var="user" status="st">
                    <tr>
                        <td><input autocomplete="off" name="checkedIds" type="checkbox"
                                   value="${ass.id}"></td>
                        <td><a href="userInfo.action?id=${user.id}" class="Ident_a">${user.name}</a></td>
                        <td>${user.rule}</td>
                        <td><s:date name="#ass.lastTime " format="yyyy-MM-dd" /></td>
                        <td><s:date name="#ass.lastTime " format="yyyy-MM-dd" /></td>
                        <td>
                            <div class="btn-group">
                                <button data-toggle="dropdown"
                                        class="btn btn-primary btn-xs dropdown-toggle" type="button">
                                    <i class="fa fa-cog"></i> 操作 <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a class="" href="assetInfo.action?id=${ass.id}">查看</a></li>
                                    <li><a class="" href="to_addAsset.action?id=${ass.id}"
                                           onclick="">修改</a></li>
                                    <li><a class="Del_li" href="javascript:void(0);"
                                           assetId="${ass.id}">删除</a></li>
                                </ul>
                            </div>
                        </td>
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
                    <s:iterator value="pagingArr"
                                var="page" status="st">
                        <li value="${page}"><a >${page}</a></li>
                    </s:iterator>
                    <li value=""><a>&raquo;</a></li>
                </ul>
            </div>
        </form>
</div>
<div id="batch_import" class="edit-detail layer_panel"
     style="height: 80px;display:none" >
    <form method="post" id="file_upload_form" class="m-t"
          action="fileInputAsset.action">
        <div class="form-group">
            <label class="col-sm-4 control-label"><span
                    class="text-danger">*</span>文件：</label>
            <input  class="row col-sm-6 control-label" type="file" name="fileName" id="file_input" />
        </div>
    </form>
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
            layer.msg(tip,{area: ['300px','50px']});
        }
        $("#QRcode_btn").click(function() {
            checkboxlen = 0;
            $("td :checkbox").each(function(index, ele) {
                if ($(this).prop("checked")) {
                    checkboxlen++;
                }
            });
            if(checkboxlen<1){
                layer.msg("至少勾选一项");
            }else{
                $("#asset_Form").submit();
            }
        });
        ////////////////////////


    });


    function download(){
        window.location.href="exportAssetExcel.action";
    }
    $(".Del_li").click(function() {
        $.ajax({
            type : 'POST',
            url : 'ajax_deleteAsset.action',
            data : {
                "id" : $(this).attr("assetId")
            },
            success : function(result) {
                if (result.operaRes == "1") {
                    $("#search_btn").click();
                    //layer.msg('删除成功');
                } else {
                    $("#search_btn").click();
                    //layer.msg('删除失败');
                }
            }
        });
    });
    //删除多个
    $("#deleteMany_btn").click(function() {
        var ids = selectIds();
        $.ajax({
            type : 'POST',
            url : 'ajax_deleteAssetMany.action',
            data : {
                "ids" : ids
            },
            success : function(result) {
                if (result.operaRes == "1") {

                    //layer.msg('删除成功');
                    $("#search_btn").click();
                } else {
                    //layer.msg('删除失败');
                    $("#search_btn").click();
                }
            }
        });
    })

    function checkAll() {
        if ($("#CheckedAll").prop("checked")) {
            $(":checkbox").prop("checked", true);
        } else {
            $(":checkbox").prop("checked", false);
        }
    }
    function selectIds() {
        var assIds = new Array();
        var idString = "";
        $("td :checkbox").each(function(index, ele) {
            if ($(this).prop("checked")) {
                assIds.push($(this).attr("value"));
            }
        })
        for (var i = 0; i < assIds.length; i++) {
            idString = assIds[i] + "," + idString;
        }
        return idString;
    }

    function changeFileName(){
        var filePath = $("#file").val();
        var fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
        $("#fileName").val(fileName);
        $("#file").parent().next().hide();
    }

    $("#fileUpload_btn").click(function(){
        layer.open({
            title: '文件批量导入',
            type: 1,
            area: ['400px','200px'],
            content: $("#File_upload_panel"),
            btn: ['确定', '取消'],
            yes: function(index, layero) {
                if($("#file").val()!=''){
                    $("#uploadFileForm").submit();
                }
                else{
                    $("#file").parent().next().show();
                }
            },
            cancel: function(index) {}
        });
    });
</script>
</html>