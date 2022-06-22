<%--
  Created by IntelliJ IDEA.
  User: 52363
  Date: 2021/8/23
  Time: 9:12
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
                url:'company/getCompanyByCondition',
                columns:[[
                    {field:'cid',title:'编号',width:100},
                    {field:'cpwd',title:'密码',width:100},
                    {field:'cname',title:'公司名称',width:100},
                    {field:'ceo',title:'公司法人',width:100},
                    {field:'cphone',title:'手机号',width:100},
                    {field:'cnum',title:'订单量',width:100},
                    {field:'status',title:'状态',width:100}
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

            //给查询按钮绑定事件
            $('#searchBtn').click(function(){
                $('#dg').datagrid('load', { // 加载 加载  加载
                    cname:$('#cname').val(),
                    status:$('#status').val(),
                    cnumOrder:$('#cnumOrder').val()
                })
            });

            //给添加公司按钮绑定事件，打开对话框
            $('#addBtn').click(function(){
                $('#adddlg').dialog('open').dialog('center').dialog('setTitle','添加公司')
            });


            //给添加的保存按钮绑定事件，提交表单
            $('#addSaveBtn').click(function(){
                $('#addfm').form('submit',{
                    url:'company/addCompany',
                    success:function(data){
                      if(eval(data)){
                          $.messager.alert('提示','添加成功！','info');
                          $('#adddlg').dialog('close');
                          $('#addfm').form('clear');
                          $('#dg').datagrid('reload');
                      }else{
                          $.messager.alert('提示','添加失败！','error');
                          $('#adddlg').dialog('close');
                      }
                    }
                });
            });


            //给修改公司按钮绑定事件，打开对话框，并且回显修改的信息
            $('#updateBtn').click(function(){

                //判断一下是否选中了一条数据
                var trs = $('#dg').datagrid('getChecked');
                if(trs != null && trs.length == 1){

                    // $('#cname').val(trs[0].cname);

                    //将选中的数据使用表单的自动填充方法填充，注意，要能正确使用自动填充，
                    //要求 表单的name属性值和 填充的数据的属性得一致！
                    $('#updatefm').form('load',trs[0]);

                    $('#updatedlg').dialog('open').dialog('center').dialog('setTitle','编辑公司信息')

                }else{
                    $.messager.alert('提示','请选中一条数据后再操作！','error');
                }

            });

            //给修改的保存按钮绑定事件，提交表单
            $('#updateSaveBtn').click(function(){
                $('#updatefm').form('submit',{
                    url:'company/updateCompany',
                    success:function(data){
                        if(eval(data)){
                            $.messager.alert('提示','修改成功！','info');
                            $('#updatedlg').dialog('close');
                            $('#dg').datagrid('reload');
                        }else{
                            $.messager.alert('提示','修改失败！','error');
                            $('#updatedlg').dialog('close');
                        }
                    }
                });
            });


            //给策划师列表按钮绑定事件，跳转到策划师列表展示页面
            $('#plannerBtn').click(function(){

                //判断用户是否选中了一条公司数据
                var trs = $('#dg').datagrid('getChecked');
                if(trs != null && trs.length == 1){
                    //跳转到策划师列表展示页面，并且将该条数据的公司编号给传过去
                    window.location.href = 'memberManager/plannerList.jsp?cid='+trs[0].cid;
                }else{
                    $.messager.alert('提示','请选中一条数据后再操作！','error');
                }

            });
        })
    </script>
</head>
<body>
    <input class="easyui-textbox" id="cname" data-options="prompt:'公司名称'" style="width: 150px">
    <select class="easyui-combobox" data-options="editable:false" id="status" style="width: 150px">
        <option value="">账号状态</option>
        <option value="正常">正常</option>
        <option value="禁用">禁用</option>
    </select>
    <select class="easyui-combobox" data-options="editable:false" id="cnumOrder" style="width: 150px">
        <option value="">订单量的排序</option>
        <option value="asc">升序</option>
        <option value="desc">降序</option>
    </select>
    <a href="javascript:;" class="easyui-linkbutton" id="searchBtn" data-options="iconCls:'icon-search'">查询</a>

    <table id="dg"></table>

    <div id="tb">
        <a href="javascript:;" id="addBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加公司</a>
        <a href="javascript:;" id="updateBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改公司</a>
        <a href="javascript:;" id="plannerBtn" class="easyui-linkbutton" data-options="iconCls:'icon-more',plain:true">策划师列表</a>
        <a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">账号状态</a>
    </div>

    <!-- 添加公司的对话框(dialog) -->
    <div id="adddlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#adddlg-buttons'">
        <form id="addfm" method="post" novalidate style="margin:0;padding:20px 50px">
            <h3>公司信息</h3>
            <div style="margin-bottom:10px">
                <input name="cpwd" class="easyui-textbox" label="公司密码:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="cname" class="easyui-textbox" label="公司名称:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="ceo" class="easyui-textbox" label="公司法人:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="cphone" class="easyui-textbox" label="联系方式:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="cmail" class="easyui-textbox" label="公司邮箱:" style="width:100%">
            </div>
        </form>
    </div>
    <div id="adddlg-buttons">
        <a href="javascript:void(0)" id="addSaveBtn" class="easyui-linkbutton c6" iconCls="icon-ok" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#adddlg').dialog('close')" style="width:90px">取消</a>
    </div>

    <!-- 修改公司的对话框(dialog) -->
    <div id="updatedlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#updatedlg-buttons'">
        <form id="updatefm" method="post" novalidate style="margin:0;padding:20px 50px">
            <input type="hidden" name="cid" id="cid">
            <h3>公司信息</h3>
            <div style="margin-bottom:10px">
                <input name="cpwd" class="easyui-textbox" label="公司密码:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="cname" class="easyui-textbox" label="公司名称:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="ceo" class="easyui-textbox" label="公司法人:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="cphone" class="easyui-textbox" label="联系方式:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="cmail" class="easyui-textbox" label="公司邮箱:" style="width:100%">
            </div>
        </form>
    </div>
    <div id="updatedlg-buttons">
        <a href="javascript:void(0)" id="updateSaveBtn" class="easyui-linkbutton c6" iconCls="icon-ok" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#updatedlg').dialog('close')" style="width:90px">取消</a>
    </div>
</body>
</html>
