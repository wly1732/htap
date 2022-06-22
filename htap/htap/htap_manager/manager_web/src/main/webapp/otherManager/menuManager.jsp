<%--
  Created by IntelliJ IDEA.
  User: 52363
  Date: 2021/8/23
  Time: 14:36
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

    <script type="text/javascript">

        $(function () {

            //给增加菜单的按钮绑定事件
            $('#addBtn').click(function () {
                //获取到选中的菜单节点
                var node = $('#tt').tree('getSelected');

                var pid = '';
                if (node != null) { //如果选中了某个菜单
                    pid = node.id;
                } else { //没有选中任何菜单
                    pid = 0;
                }

                $('#pid').val(pid);

                //弹出对话框
                $('#adddlg').dialog('open').dialog('center').dialog('setTitle', '添加菜单');
            });

            //给添加的保存按钮绑定事件，提交表单
            $('#addSaveBtn').click(function () {
                $('#addfm').form('submit', {
                    url: 'menu/addMenu',
                    success: function (data) {
                        if (eval(data)) {
                            $.messager.alert('提示', '添加成功！', 'info');
                            $('#adddlg').dialog('close');
                            $('#addfm').form('clear');
                            //重新加载一下菜单树的信息
                            $('#tt').tree('reload');
                        } else {
                            $.messager.alert('提示', '添加失败！', 'error');
                            $('#adddlg').dialog('close');
                        }
                    }
                });
            });

            //给修改菜单按钮绑定事件，弹出对话框
            $('#updateBtn').click(function () {
                //判断是否选中了某一个菜单
                var node = $('#tt').tree('getSelected');
                if (node == null) {
                    $.messager.alert('提示', '请选中菜单后再操作！', 'error');
                } else {

                    //回显表单的信息
                    $('#mid').val(node.id);
                    //注意我们现在输入框使用的是easyui提供的textbox组件，回显数据的话，
                    // 不能使用 $().val(xxx)，要使用textbox组件的setText方法设置值
                    $('#mname').textbox('setText', node.text);
                    $('#url').textbox('setText', node.attributes.url);
                    $('#mdesc').textbox('setText', node.attributes.mdesc);

                    //打开修改的对话框
                    $('#updatedlg').dialog('open').dialog('center').dialog('setTitle', '编辑菜单')
                }
            });

            //修改的保存按钮
            $('#updateSaveBtn').click(function () {

                $('#updatefm').form('submit', {
                    url: 'menu/updateMenu',
                    success: function (data) {
                        if (eval(data)) {
                            $.messager.alert('提示', '修改成功！', 'info');
                            $('#updatedlg').dialog('close');
                            $('#tt').tree('reload');
                        } else {
                            $.messager.alert('提示', '修改失败！', 'info');
                            $('#updatedlg').dialog('close');
                        }
                    }
                });
            });


            //删除菜单的按钮
            $('#deleteBtn').click(function () {
                //判断一下是否选中了某个菜单,而且还得判断是不是父菜单
                var node = $('#tt').tree('getSelected');
                if (node == null) {
                    $.messager.alert('提示', '请选中菜单后再操作！', 'error');
                } else if (node.attributes.isparent == 1) {
                    $.messager.alert('提示', '不能直接删除父菜单！', 'error');
                } else { //删除

                    //发送ajax请求到后端去删除某个菜单，传递参数有
                    //要删除的菜单的id 和 它的 父id
                    var mid = node.id;

                    //查找到要删除节点的DOM对象
                    var nodeDom = $('#tt').tree('find', node.id);

                    //找这个节点dom对象的父节点
                    var pid = 0;
                    var parentNode = $('#tt').tree('getParent', nodeDom.target);
                    if (parentNode != null) {
                        pid = parentNode.id;
                    }


                    //发送ajax请求
                    $.get('menu/deleteMenu', {'mid': mid, 'pid': pid}, function (data) {
                        if (eval(data)) {
                            $.messager.alert('提示', '删除成功！', 'info');
                            $('#tt').tree('reload');
                        } else {
                            $.messager.alert('提示', '删除失败！', 'error');
                        }
                    });
                }
            });

            //刷新按钮
            $('#refreshBtn').click(function () {
                $('#tt').tree('reload');
            });

        })


    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'west',title:'操作',collapsible:false" style="width:40%;padding:10px;">

    <a href="javascript:;" id="addBtn" class="easyui-linkbutton">增加菜单</a><br><br>
    <a href="javascript:;" id="updateBtn" class="easyui-linkbutton">编辑菜单</a><br><br>
    <a href="javascript:;" id="deleteBtn" class="easyui-linkbutton">删除菜单</a><br><br>
    <a href="javascript:;" id="refreshBtn" class="easyui-linkbutton">刷新菜单</a><br><br>

</div>
<div data-options="region:'center'" title="当前系统菜单" style="width: 60%">

    <ul id="tt" class="easyui-tree" data-options="url:'menu/getMenuByPid',animate:true,lines:true"></ul>

</div>

<!-- 添加菜单的对话框(dialog) -->
<div id="adddlg" class="easyui-dialog" style="width:400px"
     data-options="closed:true,modal:true,border:'thin',buttons:'#adddlg-buttons'">
    <form id="addfm" method="post" novalidate style="margin:0;padding:20px 50px">
        <h3>菜单信息</h3>
        <input type="hidden" name="pid" id="pid">
        <div style="margin-bottom:10px">
            <input name="mname" class="easyui-textbox" label="菜单名称:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="url" class="easyui-textbox" label="菜单url:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="mdesc" class="easyui-textbox" label="菜单描述:" style="width:100%">
        </div>
    </form>
</div>
<div id="adddlg-buttons">
    <a href="javascript:void(0)" id="addSaveBtn" class="easyui-linkbutton c6" iconCls="icon-ok"
       style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
       onclick="javascript:$('#adddlg').dialog('close')" style="width:90px">取消</a>
</div>

<!-- 修改菜单的对话框(dialog) -->
<div id="updatedlg" class="easyui-dialog" style="width:400px"
     data-options="closed:true,modal:true,border:'thin',buttons:'#updatedlg-buttons'">
    <form id="updatefm" method="post" novalidate style="margin:0;padding:20px 50px">
        <h3>菜单信息</h3>
        <input type="hidden" name="mid" id="mid">
        <div style="margin-bottom:10px">
            <input name="mname" id="mname" class="easyui-textbox" label="菜单名称:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="url" id="url" class="easyui-textbox" label="菜单url:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="mdesc" id="mdesc" class="easyui-textbox" label="菜单描述:" style="width:100%">
        </div>
    </form>
</div>
<div id="updatedlg-buttons">
    <a href="javascript:void(0)" id="updateSaveBtn" class="easyui-linkbutton c6" iconCls="icon-ok"
       style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
       onclick="javascript:$('#updatedlg').dialog('close')" style="width:90px">取消</a>
</div>
</body>
</html>
