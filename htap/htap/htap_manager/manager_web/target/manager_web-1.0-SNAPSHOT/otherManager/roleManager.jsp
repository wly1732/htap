<%--
  Created by IntelliJ IDEA.
  User: 52363
  Date: 2021/8/24
  Time: 8:50
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
                url:'role/getRoleByPage',
                columns:[[
                    {field:'rid',title:'角色编号',width:100},
                    {field:'rname',title:'角色名称',width:100},
                    {field:'rdesc',title:'角色描述',width:100}
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

            //给添加按钮绑定事件，打开对话
            $('#addBtn').click(function(){
                $('#adddlg').dialog('open').dialog('center').dialog('setTitle','添加角色');
            });

            //给添加的保存按钮绑定事件，用来提交表单
            $('#addSaveBtn').click(function(){
                //获取用户选中以及半选中的菜单id
                var nodes = $('#tt').tree('getChecked', ['checked','indeterminate']);
                if(nodes != null && nodes.length > 0){
                    var ids = '';
                    for(var i = 0; i < nodes.length; i++){
                        ids += nodes[i].id + ',';
                    }

                    ids = ids.substring(0, ids.length - 1);
                    //给表单中隐藏域放值
                    $('#ids').val(ids);
                }

                //提交表单
                $('#addfm').form('submit',{
                    url:'role/addRole',
                    success:function(data){
                        if(eval(data)){
                            $.messager.alert('提示','添加成功！','info');
                            $('#adddlg').dialog('close');
                            $('#addfm').form('clear');
                            $('#tt').tree('reload');
                            $('#dg').datagrid('reload');
                        }else{
                            $.messager.alert('提示','添加失败！','error');
                            $('#adddlg').dialog('close');
                        }
                    }
                });
            });

            //给修改角色按钮绑定事件，弹出对话框
            $('#updateBtn').click(function(){
                //判断是否选中了一条角色数据
                var trs = $('#dg').datagrid('getChecked');
                if(trs != null && trs.length == 1){

                    //回显表单中的数据
                    $('#updatefm').form('load', trs[0]);

                    //回显菜单树，回显菜单树就要求我们要知道该角色对应的菜单有哪些？
                    //而且在回显的时候，其实我们只需要知道该角色对应的子菜单有哪些就行了，
                    //因为在回显的时候，子菜单勾选住后，父菜单就自动选中。
                    //所以，我们需要根据当前这个角色id查询它对应的子菜单有哪些？

                    //发送ajax，查询子菜单，传递的参数有 角色id
                    $.get('menu/getChildMenuByRid', {'rid':trs[0].rid}, function(data){// data   List<TreeResult>

                        //遍历子菜单
                        for(var i = 0; i < data.length; i++){
                            //在菜单树中找到我要回显的那个菜单
                            var node = $('#updatett').tree('find', data[i].id);
                            //让指定的菜单节点勾选中
                            $('#updatett').tree('check',node.target);
                        }
                    });

                    $('#updatedlg').dialog('open').dialog('center').dialog('setTitle','修改角色');

                }else{
                    $.messager.alert('提示','请选中一条数据后再操作！','error');
                }
            });


            //给修改对话框绑定关闭事件
            $('#updatedlg').dialog({
                onClose:function(){ //使用panel的onCLose事件
                    //重新加载菜单树
                    $('#updatett').tree('reload');
                }
            });

            //修改的保存按钮
            $('#updateSaveBtn').click(function(){

                //获取用户选中 和 半选中的菜单节点
                var nodes = $('#updatett').tree('getChecked', ['checked','indeterminate']);
                if(nodes != null && nodes.length > 0){
                    var ids = '';
                    for(var i = 0; i < nodes.length; i++){
                        ids += nodes[i].id + ',';
                    }

                    ids = ids.substring(0, ids.length - 1);

                    $('#updateids').val(ids);
                }

                //提交表单
                $('#updatefm').form('submit',{
                    url:'role/updateRole',
                    success:function(data){
                        if(eval(data)){
                            $.messager.alert('提示','修改成功！','info');
                            $('#updatedlg').dialog('close');
                            $('#updatett').tree('reload');
                        }else{
                            $.messager.alert('提示','修改失败！','error');
                            $('#updatedlg').dialog('close');
                            $('#updatett').tree('reload');
                        }
                    }
                });
            });

            //删除角色按钮
            $('#deleteBtn').click(function(){

                $.messager.confirm('提示','确定删除吗？', function(r){
                    if(r){ // r - true 表示用户点击了确定 否则就是点击了取消
                        var trs = $('#dg').datagrid('getChecked');
                        if(trs != null && trs.length > 0){

                            var ids = '';
                            for(var i = 0; i < trs.length; i++){
                                ids += trs[i].rid + ',';
                            }
                            ids = ids.substring(0, ids.length - 1);

                            //发送ajax到后端
                            $.get('role/deleteRole',{'ids':ids},function(data){
                                if(eval(data)){
                                    $.messager.alert('提示','删除成功！','info');
                                    $('#dg').datagrid('reload');
                                }else{
                                    $.messager.alert('提示','删除失败！','error');
                                }
                            });
                        }else{
                            $.messager.alert('提示','请选中数据后再操作!','error');
                        }
                    }
                })
            });
        })

    </script>
</head>
<body>
    <table id="dg"></table>
    <div id="tb">
        <a href="javascript:;" id="addBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加角色</a>
        <a href="javascript:;" id="updateBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改角色</a>
        <a href="javascript:;" id="deleteBtn" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">删除角色</a>
    </div>


    <!--添加角色的对话框-->
    <div id="adddlg" class="easyui-dialog" style="width:800px" data-options="closed:true,modal:true,border:'thin',buttons:'#adddlg-buttons'">
        <div class="easyui-layout" style="width: 100%;height: 100%">
            <div data-options="region:'west',title:'角色信息',collapsible:false" style="width:40%;padding:10px;">
                <form id="addfm" method="post" novalidate style="margin:0;padding:20px 50px">
                    <div style="margin-bottom:10px">
                        <input name="rname" class="easyui-textbox" label="角色名称:" style="width:100%">
                    </div>
                    <div style="margin-bottom:10px">
                        <input name="rdesc" class="easyui-textbox" label="角色描述:" style="width:100%">
                    </div>
                    <div style="margin-bottom:10px">
                        <a href="javascript:;" id="addSaveBtn" class="easyui-linkbutton">保存</a>
                    </div>
                    <input type="hidden" name="ids" id="ids">
                </form>
            </div>
            <div data-options="region:'center',title:'角色对应的菜单'" style="width: 60%">
                <ul class="easyui-tree" id="tt" data-options="url:'menu/getAllMenu',animate:true,lines:true,checkbox:true"></ul>
            </div>
        </div>
    </div>

    <!--修改角色的对话框-->
    <div id="updatedlg" class="easyui-dialog" style="width:800px" data-options="closed:true,modal:true,border:'thin',buttons:'#updatedlg-buttons'">
        <div class="easyui-layout" style="width: 100%;height: 100%">
            <div data-options="region:'west',title:'角色信息',collapsible:false" style="width:40%;padding:10px;">
                <form id="updatefm" method="post" novalidate style="margin:0;padding:20px 50px">
                    <input type="hidden" name="rid" id="rid">
                    <div style="margin-bottom:10px">
                        <input name="rname" class="easyui-textbox" label="角色名称:" style="width:100%">
                    </div>
                    <div style="margin-bottom:10px">
                        <input name="rdesc" class="easyui-textbox" label="角色描述:" style="width:100%">
                    </div>
                    <div style="margin-bottom:10px">
                        <a href="javascript:;" id="updateSaveBtn" class="easyui-linkbutton">保存</a>
                    </div>
                    <input type="hidden" name="ids" id="updateids">
                </form>
            </div>
            <div data-options="region:'center',title:'角色对应的菜单'" style="width: 60%">
                <ul class="easyui-tree" id="updatett" data-options="url:'menu/getAllMenu',animate:true,lines:true,checkbox:true"></ul>
            </div>
        </div>
    </div>
</body>
</html>
