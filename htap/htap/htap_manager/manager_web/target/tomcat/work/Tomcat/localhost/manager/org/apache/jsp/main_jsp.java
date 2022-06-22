/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-06-17 15:33:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        $(function(){\r\n");
      out.write("\r\n");
      out.write("            //给菜单树绑定点击事件\r\n");
      out.write("            $('#tt').tree({\r\n");
      out.write("                onClick:function(node){//node表示的就是你点击的那个菜单  node: id text state attributes(url、isparent)\r\n");
      out.write("                    var isparent = node.attributes.isparent; // 0  1\r\n");
      out.write("                    if(isparent == 0){ //本次点击的菜单节点是叶子节点\r\n");
      out.write("                        //判断有没有打开当前的节点对应的选项卡\r\n");
      out.write("                        var exists = $('#tabs').tabs('exists', node.text);\r\n");
      out.write("                        if(exists){ //表示当前节点对应的选项卡已经打开了\r\n");
      out.write("                            $('#tabs').tabs('select', node.text);\r\n");
      out.write("                        }else{//当前没有打开这个节点对应的选项卡\r\n");
      out.write("                            $('#tabs').tabs('add', {\r\n");
      out.write("                                title:node.text,\r\n");
      out.write("                                closable:true,\r\n");
      out.write("                                content:'<iframe src=\"'+node.attributes.url+'\" style=\"height: 100%;width: 100%;border: none\">'\r\n");
      out.write("                            });\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        })\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\">\r\n");
      out.write("<div data-options=\"region:'north',border:false\" style=\"height:60px;padding:10px\">\r\n");
      out.write("    <span style=\"float: right;margin-top: 20px;\">欢迎");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.admin.aname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("登录。<a href=\"admin/logout\">退出</a></span>\r\n");
      out.write("</div>\r\n");
      out.write("<div data-options=\"region:'west',split:true,title:'系统菜单'\" style=\"width:150px;padding:10px;\">\r\n");
      out.write("    <ul id=\"tt\" class=\"easyui-tree\" data-options=\"animate:true,lines:true,url:'menu/getMenus'\"></ul>\r\n");
      out.write("</div>\r\n");
      out.write("<div data-options=\"region:'south',border:false\" style=\"height:50px;padding:10px;\">south region</div>\r\n");
      out.write("<div data-options=\"region:'center'\">\r\n");
      out.write("    <div id=\"tabs\" class=\"easyui-tabs\" data-options=\"border:false\" style=\"width:100%;height:100%;\">\r\n");
      out.write("        <div title=\"首页\" style=\"padding:20px;display:none\">\r\n");
      out.write("            我是首页\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
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
