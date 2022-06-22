<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2022/6/16
  Time: 21:40
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
                url:'hostOrder/getHostOrderByOidAndHid',
                columns:[[
                    {field:'oid',title:'订单id号',width:100},
                    {field:'hid',title:'主持人id号',width:100},
                    {field:'cid',title:'公司id',width:100},
                    {field:'pid',title:'新人id',width:100},
                    {field:'hoteladdress',title:'婚礼地址',width:100},
                    {field:'wedding_time',title:'婚礼时间',width:100},

                ]],
                fitColumns:true,
                toolbar:'#tb', //工具条使用 id=tb的
                loadMsg:'数据加载中...',
                pagination:true,
                rownumbers:true,
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:2,
                pageList:[2,3,4,5,6]
            });

            //给查询按钮绑定事件，去后端带条件分页查询数据
            $('#searchBtn').click(function(){
                //调用datagrid组件中的load方法，带上条件，重新走一下url查询数据
                $('#dg').datagrid('load',{
                    oid:$('#oid').val(),
                    hid:$('#hid').val()
                })
            });

        })

    </script>

</head>
<body>
<input class="easyui-textbox" style="width: 250px" data-options="label:'订单号:'" id="oid" >
<input class="easyui-textbox" style="width: 250px" data-options="label:'主持人号:'" id="hid" >
<a href="javascript:;" id="searchBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
<table id="dg"></table>
</body>
</html>
