/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-05-31 07:39:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
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
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html;\r\n");
      out.write("           charset=utf-8\">\r\n");
      out.write("    <title>用户登录</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        caption {\r\n");
      out.write("            font: 18px bold;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        tr {\r\n");
      out.write("            height: 60px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        div {\r\n");
      out.write("            color: #ffffFF;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            background-color: black;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"submit\"] {\r\n");
      out.write("            width: 100px;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("            font-size: 18px;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <script language=\"javascript\">\r\n");
      out.write("        function loadimage(i) { //i是为了区分多种验证码，实际使用时，可以不用这个参数。\r\n");
      out.write("            document.getElementById(\"randImage\" + i).src = \"image\" + i + \".jsp?\" + Math.random();\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form action=\"validate.jsp\" method=\"post\" name=\"loginForm\">\r\n");
      out.write("    <table width=\"500\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\r\n");
      out.write("        <!--DWLayoutTable-->\r\n");
      out.write("        <caption>四种验证码的实现</caption>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>数字验证码：</td>\r\n");
      out.write("            <td width=\"118\" height=\"22\" valign=\"middle\" align=\"center\">\r\n");
      out.write("                <input type=\"text\" name=\"rand\" size=\"15\">\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"138\" valign=\"middle\" align=\"center\">\r\n");
      out.write("                <img alt=\"code...\" name=\"randImage\" id=\"randImage1\"\r\n");
      out.write("                     src=\"image1.jsp\" width=\"60\" height=\"20\"\r\n");
      out.write("                     border=\"1\" align=\"absmiddle\">\r\n");
      out.write("            </td>\r\n");
      out.write("            <td height=\"36\" colspan=\"3\" align=\"center\" valign=\"middle\">\r\n");
      out.write("                <a href=\"javascript:loadimage(1);\">\r\n");
      out.write("                    看不清点我\r\n");
      out.write("                </a>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>英文+数字验证码：</td>\r\n");
      out.write("            <td width=\"118\" height=\"22\" valign=\"middle\" align=\"center\">\r\n");
      out.write("                <input type=\"text\" name=\"rand\" size=\"15\">\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"138\" valign=\"middle\" align=\"center\">\r\n");
      out.write("                <img alt=\"code...\" name=\"randImage\" id=\"randImage2\"\r\n");
      out.write("                     src=\"image2.jsp\" width=\"60\" height=\"20\"\r\n");
      out.write("                     border=\"1\" align=\"absmiddle\">\r\n");
      out.write("            </td>\r\n");
      out.write("            <td height=\"36\" colspan=\"3\" align=\"center\" valign=\"middle\">\r\n");
      out.write("                <a href=\"javascript:loadimage(2);\">\r\n");
      out.write("                    看不清点我\r\n");
      out.write("                </a>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>中文验证码：</td>\r\n");
      out.write("            <td width=\"118\" height=\"22\" valign=\"middle\" align=\"center\">\r\n");
      out.write("                <input type=\"text\" name=\"rand\" size=\"15\">\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"138\" valign=\"middle\" align=\"center\">\r\n");
      out.write("                <img alt=\"code...\" name=\"randImage\" id=\"randImage3\"\r\n");
      out.write("                     src=\"image3.jsp\" width=\"60\" height=\"20\"\r\n");
      out.write("                     border=\"1\" align=\"absmiddle\">\r\n");
      out.write("            </td>\r\n");
      out.write("            <td height=\"36\" colspan=\"3\" align=\"center\" valign=\"middle\">\r\n");
      out.write("                <a href=\"javascript:loadimage(3);\">\r\n");
      out.write("                    看不清点我\r\n");
      out.write("                </a>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>表达式验证码：</td>\r\n");
      out.write("            <td width=\"118\" height=\"22\" valign=\"middle\" align=\"center\">\r\n");
      out.write("                <input type=\"text\" name=\"rand\" size=\"15\">\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"138\" valign=\"middle\" align=\"center\">\r\n");
      out.write("                <img alt=\"code...\" name=\"randImage\" id=\"randImage4\"\r\n");
      out.write("                     src=\"image4.jsp\" width=\"60\" height=\"20\"\r\n");
      out.write("                     border=\"1\" align=\"absmiddle\">\r\n");
      out.write("            </td>\r\n");
      out.write("            <td height=\"36\" colspan=\"3\" align=\"center\" valign=\"middle\">\r\n");
      out.write("                <a href=\"javascript:loadimage(4);\">\r\n");
      out.write("                    看不清点我\r\n");
      out.write("                </a>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td height=\"36\" colspan=\"4\" align=\"center\" valign=\"middle\">\r\n");
      out.write("                <div>Tips:验证码的值，放在session中了！</div>\r\n");
      out.write("                <input type=\"submit\" name=\"login\" value=\"提交\">\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("</form>\r\n");
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
