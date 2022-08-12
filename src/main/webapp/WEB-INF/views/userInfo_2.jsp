<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/taglib/taglib.jsp"%>
<html>
<head>
    <title>Index</title>
    <!--引入bootstrap的css文件-->
    <link rel="stylesheet" href="../css/bootstrap.min.css">

    <!--引入dataTables的css文件-->
    <link rel="stylesheet" href="../css/jquery.dataTables.min.css">

    <!--引入jquery的js文件-->
    <script src="../js/jquery_3.2.1.js"></script>

    <!--引入bootstrap的js文件-->
    <script src="../js/bootstrap.min.js"></script>

    <!--引入dataTables的js文件-->
    <script src="../js/jquery.dataTables.min.js"></script>

    <!--引入sweet alert的js文件-->
    <script src="../js/sweetalert.min.js"></script>

</head>
<script type="text/javascript">
    var table = null;
    $(function() {
        var table_config = {
            "aLengthMenu":[5,10],
            "searching":false,//禁用搜索
            "lengthChange":true,
            "paging": true,//开启表格分页
            "bProcessing" : true,
            "bServerSide" : true,//是否在服务端分页
            "bAutoWidth" : false,
            "sort" : "position",
            "deferRender":true,//延迟渲染
            "bStateSave" : false, //在第三页刷新页面，会自动到第一页
            "dom": '<l<\'#topPlugin\'>f>rt<ip><"clear">',
            "ordering": true,//全局禁用排序
            "aaSorting": [3, 'desc'], // 使用第三列降序排序
            "ajax": {
                "type": "post",
                "url":"${ctx}/findAllUser_2"
            },
            deferRender: true,
            "aoColumns" : [{
                "mData" : "id",
                "orderable":true ,
                "sDefaultContent" : "",
                "render":function (data, type, row, meta) {
                    console.log("data:"+data);//这一列的值即id
                    console.log("type:"+type);//display
                    console.log("row:"+row);//行数据
                    console.log("meta:"+meta);

                    return '<a style="text-decoration:none" href="${ctx}/mmp/mMPJsonData/form?id='+row.id+'">'+row.id+'</a>';
                }
            },{
                "mData" : "name",
                "orderable" : false,
                "sDefaultContent" : ""
            },{
                "mData" : "age",
                "orderable" : true,
                "sDefaultContent" : ""
            },{
                "mData" : "gender",
                "orderable" : false,
                "sDefaultContent" : ""
            },{
            "mData" : "createDate",
                "orderable" : false,
                "sDefaultContent" : ""
            }],
            columnDefs: [{
                "orderable" :false,
                "sWidth":"28%",
                "targets" : [5], // 指定的列
                "data" : "",
                "render" : function(data, type, full, meta) {
                    var str = '';
                    str += '<a href="javascript:;" onclick="deleteUser(\''+full.id+'\')" class="btn btn-sm btn-icon btn-pure btn-danger" data-toggle="tooltip" data-original-title="删除"><i class="icon fa-times-rectangle" aria-hidden="true"></i>删除</a>';
                    str += '  ';
                    str += '<a href="${ctx}/mmp/mMPJsonData/download?id='+full.id+'" class="btn btn-sm btn-icon btn-pure btn-info" data-toggle="tooltip" data-original-title="编辑"><i class="icon fa-download" aria-hidden="true"></i>编辑</a>';
                    return str;
                }
            } ],
            rowId: 'id',
            select: {
                style: ['multi+shift'],
                order:'current',
                selector: 'td:first-child'
            },
            language : { // 国际化配置
                "sProcessing" : "正在获取数据，请稍后...",
                "sLengthMenu" : "显示 _MENU_ 条",
                "sZeroRecords" : "没有找到数据",
                "sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
                "sInfoEmpty" : "记录数为0",
                "sInfoFiltered" : "(全部记录数 _MAX_ 条)",
                "sInfoPostFix" : "",
                "sSearch" : "搜索",
                "sUrl" : "",
                "rows":"行",
                "oPaginate" : {
                    "sFirst" : "第一页",
                    "sPrevious" : "上一页",
                    "sNext" : "下一页",
                    "sLast" : "最后一页"
                },
                select: {
                    rows: "%d 行被选中"
                }
            },
            "initComplete": function(settings, json) {

            }
        };
        table = $('#listTab').DataTable(table_config);
    })
    function deleteUser(id) {
        console.log(id);
        swal({
            title: "确定删除吗？",
            text: "",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((willDelete) => {
                if (willDelete) {
                    $.ajax({
                        url:"${ctx}/deleteUser",
                        type:"POST",
                        data:{
                            id:id
                        },
                        success: function () {
                            table.ajax.reload();
                        },
                        error: function () {
                        }
                    })
                }
            });
    }
</script>
<body>
<p align="center">User Information</p>
<sys:messages content="${message}"/>
<div class="panel">
    <div class="panel-body">
        <table id="listTab" class="table table-bordered table-hover table-striped" cellspacing="0" id="exampleAddRow">
            <thead>
            <tr>
                <th>id</th>
                <th>名字</th>
                <th>年龄</th>
                <th>性别</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<a href="${ctx}/addUser" style="text-decoration:none">新增用户</a>
<div class="col-md-12 text-center" style="text-align: center">
    <input id="btnBack" class="btn btn-default" type="button" value="返回" onclick="javascript:history.go(-1)">
</div>
</body>
</html>
