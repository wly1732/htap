<%--
  Created by IntelliJ IDEA.
  User: 52363
  Date: 2021/8/19
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!--如果在页面中写了base标签后，当前页面中所有的路径都接着往下写就行了-->
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="static/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/themes/icon.css">
    <script type="text/javascript" src="static/jquery.min.js"></script>
    <script type="text/javascript" src="static/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="static/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">

        $(function(){
            $('#dg').datagrid({
                url:'marriedPerson/getMarriedPersonByNameAndPhone',
                columns:[[
                    {field:'pid',title:'新人编号',width:100},
                    {field:'pname',title:'新人名字',width:100},
                    {field:'pphone',title:'手机号',width:100},
                    {field:'pmail',title:'邮箱',width:100},
                    {field:'marrydate',title:'婚期',width:100},
                    {field:'regdate',title:'注册日期',width:100},
                    {field:'status',title:'账号状态',width:100}
                ]],
                fitColumns:true, //自动调整单元格大小
                striped:true, //隔行变色
                loadMsg:'正在加载中...',
                pagination:true, //分页
                rownumbers:true, //显示行号
                pagePosition:'bottom', //分页的页码位置
                pageNumber:1, //初始化页码
                pageSize:2, //每页显示多少条
                pageList:[2,3,4,5,6] //可以跳整每页显示的条数
            });

            //给查询按钮绑定事件，去后端带条件分页查询数据
            $('#searchBtn').click(function(){
                //调用datagrid组件中的load方法，带上条件，重新走一下url查询数据
                $('#dg').datagrid('load',{
                    pname:$('#pname').val(),
                    pphone:$('#pphone').val()
                })
            });

        })

    </script>

</head>
<body>
    <input class="easyui-textbox" style="width: 250px" data-options="label:'姓名:'" id="pname" >
    <input class="easyui-textbox" style="width: 250px" data-options="label:'手机号:'" id="pphone" >
    <a href="javascript:;" id="searchBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
    <table id="dg"></table>
</body>
</html>
