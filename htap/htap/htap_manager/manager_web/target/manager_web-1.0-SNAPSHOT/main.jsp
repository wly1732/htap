<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2022/6/14
  Time: 14:48
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

        $(function(){

            //给菜单树绑定点击事件
            $('#tt').tree({
                onClick:function(node){//node表示的就是你点击的那个菜单  node: id text state attributes(url、isparent)
                    var isparent = node.attributes.isparent; // 0  1
                    if(isparent == 0){ //本次点击的菜单节点是叶子节点
                        //判断有没有打开当前的节点对应的选项卡
                        var exists = $('#tabs').tabs('exists', node.text);
                        if(exists){ //表示当前节点对应的选项卡已经打开了
                            $('#tabs').tabs('select', node.text);
                        }else{//当前没有打开这个节点对应的选项卡
                            $('#tabs').tabs('add', {
                                title:node.text,
                                closable:true,
                                content:'<iframe src="'+node.attributes.url+'" style="height: 100%;width: 100%;border: none">'
                            });
                        }
                    }
                }
            });

        })

    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:60px;padding:10px">
    <span style="float: right;margin-top: 20px;">欢迎${sessionScope.admin.aname}登录。<a href="admin/logout">退出</a></span>
</div>
<div data-options="region:'west',split:true,title:'系统菜单'" style="width:150px;padding:10px;">
    <ul id="tt" class="easyui-tree" data-options="animate:true,lines:true,url:'menu/getMenus'"></ul>
</div>
<div data-options="region:'south',border:false" style="height:50px;padding:10px;">south region</div>
<div data-options="region:'center'">
    <div id="tabs" class="easyui-tabs" data-options="border:false" style="width:100%;height:100%;">
        <div title="首页" style="padding:20px;display:none">
            我是首页
        </div>
    </div>
</div>
</body>
</html>
