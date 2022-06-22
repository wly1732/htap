/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-06-17 15:33:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.memberManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class companyManager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <!--如果在页面中写了base标签后，当前页面中所有的路径都接着往下写就行了-->\r\n");
      out.write("    <base href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"static/themes/default/easyui.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"static/themes/icon.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"static/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"static/jquery.easyui.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"static/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        $(function(){\r\n");
      out.write("            $('#dg').datagrid({\r\n");
      out.write("                url:'company/getCompanyByCondition',\r\n");
      out.write("                columns:[[\r\n");
      out.write("                    {field:'cid',title:'编号',width:100},\r\n");
      out.write("                    {field:'cpwd',title:'密码',width:100},\r\n");
      out.write("                    {field:'cname',title:'公司名称',width:100},\r\n");
      out.write("                    {field:'ceo',title:'公司法人',width:100},\r\n");
      out.write("                    {field:'cphone',title:'手机号',width:100},\r\n");
      out.write("                    {field:'cnum',title:'订单量',width:100},\r\n");
      out.write("                    {field:'status',title:'状态',width:100}\r\n");
      out.write("                ]],\r\n");
      out.write("                fitColumns:true,\r\n");
      out.write("                toolbar:'#tb', //工具条使用 id=tb的\r\n");
      out.write("                loadMsg:'数据加载中...',\r\n");
      out.write("                pagination:true,\r\n");
      out.write("                rownumbers:true,\r\n");
      out.write("                pagePosition:'bottom',\r\n");
      out.write("                pageNumber:1,\r\n");
      out.write("                pageSize:2,\r\n");
      out.write("                pageList:[2,3,4,5,6]\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            //给查询按钮绑定事件\r\n");
      out.write("            $('#searchBtn').click(function(){\r\n");
      out.write("                $('#dg').datagrid('load', { // 加载 加载  加载\r\n");
      out.write("                    cname:$('#cname').val(),\r\n");
      out.write("                    status:$('#status').val(),\r\n");
      out.write("                    cnumOrder:$('#cnumOrder').val()\r\n");
      out.write("                })\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            //给添加公司按钮绑定事件，打开对话框\r\n");
      out.write("            $('#addBtn').click(function(){\r\n");
      out.write("                $('#adddlg').dialog('open').dialog('center').dialog('setTitle','添加公司')\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            //给添加的保存按钮绑定事件，提交表单\r\n");
      out.write("            $('#addSaveBtn').click(function(){\r\n");
      out.write("                $('#addfm').form('submit',{\r\n");
      out.write("                    url:'company/addCompany',\r\n");
      out.write("                    success:function(data){\r\n");
      out.write("                      if(eval(data)){\r\n");
      out.write("                          $.messager.alert('提示','添加成功！','info');\r\n");
      out.write("                          $('#adddlg').dialog('close');\r\n");
      out.write("                          $('#addfm').form('clear');\r\n");
      out.write("                          $('#dg').datagrid('reload');\r\n");
      out.write("                      }else{\r\n");
      out.write("                          $.messager.alert('提示','添加失败！','error');\r\n");
      out.write("                          $('#adddlg').dialog('close');\r\n");
      out.write("                      }\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            //给修改公司按钮绑定事件，打开对话框，并且回显修改的信息\r\n");
      out.write("            $('#updateBtn').click(function(){\r\n");
      out.write("\r\n");
      out.write("                //判断一下是否选中了一条数据\r\n");
      out.write("                var trs = $('#dg').datagrid('getChecked');\r\n");
      out.write("                if(trs != null && trs.length == 1){\r\n");
      out.write("\r\n");
      out.write("                    // $('#cname').val(trs[0].cname);\r\n");
      out.write("\r\n");
      out.write("                    //将选中的数据使用表单的自动填充方法填充，注意，要能正确使用自动填充，\r\n");
      out.write("                    //要求 表单的name属性值和 填充的数据的属性得一致！\r\n");
      out.write("                    $('#updatefm').form('load',trs[0]);\r\n");
      out.write("\r\n");
      out.write("                    $('#updatedlg').dialog('open').dialog('center').dialog('setTitle','编辑公司信息')\r\n");
      out.write("\r\n");
      out.write("                }else{\r\n");
      out.write("                    $.messager.alert('提示','请选中一条数据后再操作！','error');\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            //给修改的保存按钮绑定事件，提交表单\r\n");
      out.write("            $('#updateSaveBtn').click(function(){\r\n");
      out.write("                $('#updatefm').form('submit',{\r\n");
      out.write("                    url:'company/updateCompany',\r\n");
      out.write("                    success:function(data){\r\n");
      out.write("                        if(eval(data)){\r\n");
      out.write("                            $.messager.alert('提示','修改成功！','info');\r\n");
      out.write("                            $('#updatedlg').dialog('close');\r\n");
      out.write("                            $('#dg').datagrid('reload');\r\n");
      out.write("                        }else{\r\n");
      out.write("                            $.messager.alert('提示','修改失败！','error');\r\n");
      out.write("                            $('#updatedlg').dialog('close');\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            //给策划师列表按钮绑定事件，跳转到策划师列表展示页面\r\n");
      out.write("            $('#plannerBtn').click(function(){\r\n");
      out.write("\r\n");
      out.write("                //判断用户是否选中了一条公司数据\r\n");
      out.write("                var trs = $('#dg').datagrid('getChecked');\r\n");
      out.write("                if(trs != null && trs.length == 1){\r\n");
      out.write("                    //跳转到策划师列表展示页面，并且将该条数据的公司编号给传过去\r\n");
      out.write("                    window.location.href = 'memberManager/plannerList.jsp?cid='+trs[0].cid;\r\n");
      out.write("                }else{\r\n");
      out.write("                    $.messager.alert('提示','请选中一条数据后再操作！','error');\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <input class=\"easyui-textbox\" id=\"cname\" data-options=\"prompt:'公司名称'\" style=\"width: 150px\">\r\n");
      out.write("    <select class=\"easyui-combobox\" data-options=\"editable:false\" id=\"status\" style=\"width: 150px\">\r\n");
      out.write("        <option value=\"\">账号状态</option>\r\n");
      out.write("        <option value=\"正常\">正常</option>\r\n");
      out.write("        <option value=\"禁用\">禁用</option>\r\n");
      out.write("    </select>\r\n");
      out.write("    <select class=\"easyui-combobox\" data-options=\"editable:false\" id=\"cnumOrder\" style=\"width: 150px\">\r\n");
      out.write("        <option value=\"\">订单量的排序</option>\r\n");
      out.write("        <option value=\"asc\">升序</option>\r\n");
      out.write("        <option value=\"desc\">降序</option>\r\n");
      out.write("    </select>\r\n");
      out.write("    <a href=\"javascript:;\" class=\"easyui-linkbutton\" id=\"searchBtn\" data-options=\"iconCls:'icon-search'\">查询</a>\r\n");
      out.write("\r\n");
      out.write("    <table id=\"dg\"></table>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"tb\">\r\n");
      out.write("        <a href=\"javascript:;\" id=\"addBtn\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add',plain:true\">添加公司</a>\r\n");
      out.write("        <a href=\"javascript:;\" id=\"updateBtn\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit',plain:true\">修改公司</a>\r\n");
      out.write("        <a href=\"javascript:;\" id=\"plannerBtn\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-more',plain:true\">策划师列表</a>\r\n");
      out.write("        <a href=\"javascript:;\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove',plain:true\">账号状态</a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- 添加公司的对话框(dialog) -->\r\n");
      out.write("    <div id=\"adddlg\" class=\"easyui-dialog\" style=\"width:400px\" data-options=\"closed:true,modal:true,border:'thin',buttons:'#adddlg-buttons'\">\r\n");
      out.write("        <form id=\"addfm\" method=\"post\" novalidate style=\"margin:0;padding:20px 50px\">\r\n");
      out.write("            <h3>公司信息</h3>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"cpwd\" class=\"easyui-textbox\" label=\"公司密码:\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"cname\" class=\"easyui-textbox\" label=\"公司名称:\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"ceo\" class=\"easyui-textbox\" label=\"公司法人:\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"cphone\" class=\"easyui-textbox\" label=\"联系方式:\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"cmail\" class=\"easyui-textbox\" label=\"公司邮箱:\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"adddlg-buttons\">\r\n");
      out.write("        <a href=\"javascript:void(0)\" id=\"addSaveBtn\" class=\"easyui-linkbutton c6\" iconCls=\"icon-ok\" style=\"width:90px\">保存</a>\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" onclick=\"javascript:$('#adddlg').dialog('close')\" style=\"width:90px\">取消</a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- 修改公司的对话框(dialog) -->\r\n");
      out.write("    <div id=\"updatedlg\" class=\"easyui-dialog\" style=\"width:400px\" data-options=\"closed:true,modal:true,border:'thin',buttons:'#updatedlg-buttons'\">\r\n");
      out.write("        <form id=\"updatefm\" method=\"post\" novalidate style=\"margin:0;padding:20px 50px\">\r\n");
      out.write("            <input type=\"hidden\" name=\"cid\" id=\"cid\">\r\n");
      out.write("            <h3>公司信息</h3>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"cpwd\" class=\"easyui-textbox\" label=\"公司密码:\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"cname\" class=\"easyui-textbox\" label=\"公司名称:\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"ceo\" class=\"easyui-textbox\" label=\"公司法人:\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"cphone\" class=\"easyui-textbox\" label=\"联系方式:\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"cmail\" class=\"easyui-textbox\" label=\"公司邮箱:\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"updatedlg-buttons\">\r\n");
      out.write("        <a href=\"javascript:void(0)\" id=\"updateSaveBtn\" class=\"easyui-linkbutton c6\" iconCls=\"icon-ok\" style=\"width:90px\">保存</a>\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" onclick=\"javascript:$('#updatedlg').dialog('close')\" style=\"width:90px\">取消</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
