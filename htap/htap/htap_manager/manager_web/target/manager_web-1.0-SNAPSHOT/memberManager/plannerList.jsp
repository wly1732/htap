<%--
  Created by IntelliJ IDEA.
  User: 52363
  Date: 2021/8/23
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="static/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/themes/icon.css">
    <script type="text/javascript" src="static/jquery.min.js"></script>
    <script type="text/javascript" src="static/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="static/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">

        $(function(){
            $('#dg').datagrid({
                url:'planner/getPlannerByCid',
                queryParams:{'cid':${param.cid}}, //接收到公司列表页面中传递的公司id
                columns:[[
                    {field:'nname',title:'姓名',width:100},
                    {field:'nphone',title:'手机号',width:100},
                    {field:'addtime',title:'开通时间',width:100},
                    {field:'status',title:'账号状态',width:100},
                    {field:'cid',title:'所属公司',width:100, formatter:function(value,row,index){
                            return row.company ? row.company.cname : "";
                        }},
                    {field:'pnum',title:'订单量',width:100}
                ]],
                fitColumns:true,
                loadMsg:'数据加载中...',
                pagination:true,
                rownumbers:true,
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:2,
                pageList:[2,3,4,5,6]
            });

            $('#back').click(function(){
                window.history.back();
            });
        })

    </script>

</head>
<body>
    <div class="easyui-panel" title="策划师列表">
        <table id="dg"></table>
    </div>
    <a href="javascript:;" class="easyui-linkbutton" id="back">返回</a>
</body>
</html>
