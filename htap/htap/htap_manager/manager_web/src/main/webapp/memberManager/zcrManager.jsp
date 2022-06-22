<%--
  Created by IntelliJ IDEA.
  User: 52363
  Date: 2021/8/20
  Time: 8:52
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
                url:'host/getHostByCondition',
                columns:[[
                    {field:'strong',title:'权重',width:100, formatter:function(value,row,index){
                        return '<input class="strong" hid="'+row.hid+'" type="text" style="width: 80px" value="'+value+'">';
                        }},
                    {field:'hname',title:'姓名',width:100},
                    {field:'hphone',title:'手机号',width:100},
                    {field:'starttime',title:'开通时间',width:100},
                    {field:'hpprice',title:'价格',width:100, formatter:function(value,row,index){
                            return row.hostPower ? row.hostPower.hpprice : "";
                        }},
                    {field:'num',title:'订单量',width:100},
                    {field:'hpdiscount',title:'折扣',width:100, formatter:function(value,row,index){
                            return row.hostPower ? row.hostPower.hpdiscount : "";
                        }},
                    {field:'hpstart',title:'星推荐',width:100, formatter:function(value,row,index){
                            return row.hostPower ? row.hostPower.hpstart : "";
                        }},
                    {field:'status',title:'账号状态',width:100}
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

            //给查询按钮绑定事件，让datagrid根据查询参数重新去查询一下数据
            $('#seatchBtn').click(function(){
                $('#dg').datagrid('load',{
                    hname:$('#hname').val(),
                    status:$('#status').val(),
                    strongOrder:$('#strongOrder').val(),
                    hpstart:$('#hpstart').val(),
                    hpdiscount:$('#hpdiscount').val()
                });
            });


            //给添加主持人按钮绑定事件，用来打开对话框
            $('#addBtn').click(function(){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加主持人');
            });

            //给保存按钮绑定事件，用来提交表单的
            $('#saveBtn').click(function(){
                $('#fm').form('submit',{
                    url:'host/addHost',
                    success:function(data){
                        if(eval(data)){
                            //提示信息
                            $.messager.alert('提示','添加成功！','info');
                            //关闭对话框
                            $('#dlg').dialog('close');
                            //清空表单中的数据
                            $('#fm').form('clear');
                            //让datagrid重新加载一下数据
                            $('#dg').datagrid('reload');
                        }else{
                            //提示信息
                            $.messager.alert('提示','添加失败！','error');
                            //关闭对话框
                            $('#dlg').dialog('close');
                        }
                    }
                })
            });

            //给账号状态绑定事件，用来打开修改状态的对话框
            $('#statusBtn').click(function(){

                //先判断用户是否选中了数据
                var trs = $('#dg').datagrid('getChecked');

                if(trs.length > 0){//选中了数据

                    //通过for循环遍历 上面选中的数据的数组，获取到每条数据的hid
                    var ids = ''; // 1,2,3,
                    for(var i = 0; i < trs.length; i++){
                        ids += trs[i].hid + ',';
                    }
                    //去掉最后的逗号
                    ids = ids.substring(0, ids.length - 1);
                    $('#ids').val(ids);
                    $('#statusdlg').dialog('open').dialog('center').dialog('setTitle','修改状态');
                }else{
                    $.messager.alert('提示','请选中数据后再操作！','error');
                }
            });

            //给修改账号状态的保存按钮绑定事件，提交表单
            $('#statusSaveBtn').click(function(){

                $('#statusfm').form('submit',{
                    url:'host/updateHostStatus',
                    success:function(data){
                        if(eval(data)){
                            //修改成功提示
                            $.messager.alert('提示','状态修改成功！','info');
                            //关闭对话框
                            $('#statusdlg').dialog('close');
                            //清空表单
                            $('#statusfm').form('clear');
                            //datagrid重写加载一下
                            $('#dg').datagrid('reload');
                        }else{
                            //修改成功提示
                            $.messager.alert('提示','状态修改失败！','error');
                            //关闭对话框
                            $('#statusdlg').dialog('close');
                        }
                    }
                });
            });

            //给权限批量设置按钮绑定事件，打开对话框
            $('#powerBtn').click(function(){

                //先判断有没有选中数据
                var trs = $('#dg').datagrid('getChecked');

                if(trs.length > 0){//有选中的

                    //打开对话框
                    $('#powerdlg').dialog('open').dialog('center').dialog('setTitle','权限批量设置');

                    var ids = '';
                    for(var i = 0; i < trs.length; i++){
                         ids += trs[i].hid + ',';
                    }

                    ids = ids.substring(0, ids.length-1);

                    $('#ids2').val(ids);

                }else{
                    $.messager.alert("提示","请选中数据后再操作！","error");
                }
            });

            //给权限表单中的保存按钮绑定事件，提交表单
            $('#powerSaveBtn').click(function(){
                $('#powerForm').form('submit',{
                    url:'hostPower/addHostPower',
                    success:function(data){
                        if(eval(data)){
                            $.messager.alert('提示','权限设置成功！','info');
                            $('#powerdlg').dialog('close');
                            $('#powerForm').form('clear');
                            $('#dg').datagrid('reload');
                        }else{
                            $.messager.alert('提示','权限设置失败！','info');
                            $('#powerdlg').dialog('close');
                        }
                    }
                });
            });


            //给class=strong动态绑定事件
            $(document).on('change','.strong',function(){

                //1.获取到本次修改的 数据的id和新的权重值
                var hid = $(this).attr('hid'); //使用attr可以获取自定义的属性，prop不行！
                var strong = $(this).val();

                if(!isNaN(strong)){ //判断是不是数字
                    //2.发送ajax请求到后端去修改
                    $.get('host/updateHostStrong',{'hid':hid,'strong':strong},function(data){
                        if(eval(data)){
                            $.messager.alert('提示','修改成功！','info');
                        }else{
                            $.messager.alert('提示','修改失败！','error');
                        }
                    });
                }else{
                    $.messager.alert('提示','请修改正确的数字！','error')
                }



            });
        })

    </script>
</head>
<body>

    <input class="easyui-textbox" id="hname" data-options="prompt:'姓名'" style="width: 150px">
    <select class="easyui-combobox" data-options="editable:false" id="status" style="width: 150px">
        <option value="">账号状态</option>
        <option value="正常">正常</option>
        <option value="禁用">禁用</option>
    </select>
    <select class="easyui-combobox" data-options="editable:false" id="strongOrder" style="width: 150px">
        <option value="">权重的排序</option>
        <option value="asc">升序</option>
        <option value="desc">降序</option>
    </select>
    <select class="easyui-combobox" data-options="editable:false" id="hpstart" style="width: 150px">
        <option value="">星推荐</option>
        <option value="是">是</option>
        <option value="否">否</option>
    </select>
    <select class="easyui-combobox" data-options="editable:false" id="hpdiscount" style="width: 150px">
        <option value="">折扣</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
    </select>
    <a href="javascript:;" class="easyui-linkbutton" id="seatchBtn" data-options="iconCls:'icon-search'">查询</a>
    <a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">导出</a>

    <table id="dg"></table>

    <div id="tb">
        <a href="javascript:;" id="addBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加主持人</a>
        <a href="javascript:;" id="statusBtn" class="easyui-linkbutton" data-options="iconCls:'icon-no',plain:true">账号禁用</a>
        <a href="javascript:;" id="powerBtn" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">权限批量设置</a>
    </div>

    <!-- 添加的对话框(dialog) -->
    <div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <h3>主持人信息</h3>
            <div style="margin-bottom:10px">
                <input name="hname" class="easyui-textbox" label="姓名:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="hpwd" class="easyui-textbox" label="密码:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="hphone" class="easyui-textbox" label="手机:" style="width:100%">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" id="saveBtn" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>

    <!-- 修改账号状态的对话框(dialog) -->
    <div id="statusdlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#statusdlg-buttons'">
        <form id="statusfm" method="post" novalidate style="margin:0;padding:20px 50px">
            <h3>账号状态</h3>
            <div style="margin-bottom:10px">
                <input class="easyui-radiobutton" labelWidth="50" name="status" value="正常" checked="checked" label="正常:">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="easyui-radiobutton" labelWidth="50" name="status" value="禁用" label="禁用:">
            </div>

            <input type="hidden" name="ids" id="ids">
        </form>
    </div>
    <div id="statusdlg-buttons">
        <a href="javascript:void(0)" id="statusSaveBtn" class="easyui-linkbutton c6" iconCls="icon-ok" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#statusdlg').dialog('close')" style="width:90px">取消</a>
    </div>

    <!-- 权限批量设置的对话框 -->
    <div id="powerdlg" class="easyui-dialog" style="width:800px" data-options="closed:true,modal:true,border:'thin',buttons:'#powerdlg-buttons'">
        <form id="powerForm" method="post">
            <table cellpadding="5" style="margin-left: 50px">
                <tr>
                    <td>是否星推荐:</td>
                    <td>
                        <input class="easyui-radiobutton" labelWidth="50" name="hpstart" value="是" checked="checked" label="是:">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="easyui-radiobutton" labelWidth="50" name="hpstart" value="否" label="否:">
                    </td>
                </tr>
                <tr>
                    <td>星推荐有效期:</td>
                    <td>
                        <input class="easyui-datebox" name="hpstartBeigindate"> ---
                        <input class="easyui-datebox" name="hpstartEnddate">
                    </td>
                </tr>
                <tr>
                    <td>星推荐时间:</td>
                    <td>
                        <input class="easyui-timespinner" showSeconds="true" name="hpstartBegintime" value="00:00:00"> ---
                        <input class="easyui-timespinner" showSeconds="true" name="hpstartEndtime" value="00:00:00">
                    </td>
                </tr>
                <tr>
                    <td>自添订单:</td>
                    <td>
                        <input class="easyui-radiobutton" labelWidth="50" name="hpOrderPower" value="是" checked="checked" label="是:">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="easyui-radiobutton" labelWidth="50" name="hpOrderPower" value="否" label="否:">
                    </td>
                </tr>
                <tr>
                    <td>折扣:</td>
                    <td>
                        <select class="easyui-combobox" style="width: 170px" name="hpdiscount">
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>折扣周期:</td>
                    <td>
                        <input class="easyui-datebox" name="hpDisStarttime"> ---
                        <input class="easyui-datebox" name="hpDisEndtime">
                    </td>
                </tr>
                <tr>
                    <td>价格:</td>
                    <td>
                        <input name="hpprice" class="easyui-numberbox" data-options="precision:2" value="0.00">
                    </td>
                </tr>
                <tr>
                    <td>管理费:</td>
                    <td>
                        <input name="hcosts" class="easyui-numberbox" data-options="precision:2" value="0.00">
                    </td>
                </tr>
            </table>
            <input type="hidden" name="ids" id="ids2">
        </form>
    </div>
    <div id="powerdlg-buttons">
        <a href="javascript:void(0)" id="powerSaveBtn" class="easyui-linkbutton c6" iconCls="icon-ok" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#powerdlg').dialog('close')" style="width:90px">取消</a>
    </div>
</body>
</html>
