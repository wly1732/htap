/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-06-17 15:33:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.orderManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class hostOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("        $(function(){\r\n");
      out.write("            $('#dg').datagrid({\r\n");
      out.write("                url:'hostOrder/getHostOrderByOidAndHid',\r\n");
      out.write("                columns:[[\r\n");
      out.write("                    {field:'oid',title:'订单id号',width:100},\r\n");
      out.write("                    {field:'hid',title:'主持人id号',width:100},\r\n");
      out.write("                    {field:'cid',title:'公司id',width:100},\r\n");
      out.write("                    {field:'pid',title:'新人id',width:100},\r\n");
      out.write("                    {field:'hoteladdress',title:'婚礼地址',width:100},\r\n");
      out.write("                    {field:'wedding_time',title:'婚礼时间',width:100},\r\n");
      out.write("\r\n");
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
      out.write("            //给查询按钮绑定事件，去后端带条件分页查询数据\r\n");
      out.write("            $('#searchBtn').click(function(){\r\n");
      out.write("                //调用datagrid组件中的load方法，带上条件，重新走一下url查询数据\r\n");
      out.write("                $('#dg').datagrid('load',{\r\n");
      out.write("                    oid:$('#oid').val(),\r\n");
      out.write("                    hid:$('#hid').val()\r\n");
      out.write("                })\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        })\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<input class=\"easyui-textbox\" style=\"width: 250px\" data-options=\"label:'订单号:'\" id=\"oid\" >\r\n");
      out.write("<input class=\"easyui-textbox\" style=\"width: 250px\" data-options=\"label:'主持人号:'\" id=\"hid\" >\r\n");
      out.write("<a href=\"javascript:;\" id=\"searchBtn\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search'\">查询</a>\r\n");
      out.write("<table id=\"dg\"></table>\r\n");
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
