<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2022/6/13
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/"/>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="static/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/themes/icon.css">
    <script type="text/javascript" src="static/jquery.min.js"></script>
    <script type="text/javascript" src="static/jquery.easyui.min.js"></script>

    <script type="text/javascript">
        $(function(){
            //点击登录按钮后，提交表单
            $('#loginBtn').click(function(){
                $('#loginForm').form('submit', {
                    url:'admin/login',
                    success:function(data){
                        if(eval(data)){
                            window.location.href = 'main.jsp';
                        }else{
                            $('#msg').text('用户名或密码错误！').css('color', 'red');
                        }
                    }
                });
            });

        })
    </script>
</head>
<body>
<div style="width: 500px; margin: 100px auto">
    <form id="loginForm" method="post">
        <div class="easyui-panel" title="欢迎登录系统" style="width:100%;max-width:400px;padding:30px 60px;">
            <div style="height: 10px; text-align: center;"><span id="msg"></span></div>
            <div style="margin-bottom:10px; margin-top: 20px">
                <input class="easyui-textbox" name="aname" style="width:100%;height:40px;padding:12px" data-options="prompt:'用户名',iconCls:'icon-man',iconWidth:38">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-passwordbox" name="apwd" style="width:100%;height:40px;padding:12px" data-options="prompt:'密码',iconCls:'icon-lock',iconWidth:38">
            </div>
            <div style="margin-bottom:20px">
                <input type="checkbox" checked="checked">
                <span>记住我</span>
            </div>
            <div>
                <a id="loginBtn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
                    <span style="font-size:14px;">登录</span>
                </a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
