/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-05-31 07:37:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.*;
import java.io.OutputStream;

public final class image4_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=gb2312");
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
      out.write("\r\n");

    try {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        int width = 110, height = 20;
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        OutputStream os = response.getOutputStream();
        Graphics g = image.getGraphics();
        Random random = new Random();
//设置背景颜色
        g.setColor(new Color(251, 244, 166));
//填充指定的矩形
        g.fillRect(0, 0, width, height);
//设置文字的样式
        g.setFont(new Font("Times New Roman", Font.BOLD, 18));
//设置文字的颜色
        g.setColor(new Color(198, 39, 60));
//设置运算符号
        String[] s = {"+", "-"};
        String sRand = "";
//设置运算因子
        int num1 = random.nextInt(100);
        int num2 = random.nextInt(100);
        int index = random.nextInt(2);
        String rand = s[index];
//设置运算结果
        int end = 0;
//得到运算表达式
        sRand = num1 + rand + num2;
//绘制运算表达式
        g.drawString(sRand, 33, 16);
        if (rand.equals("+")) {
            end = num1 + num2;
        } else {
            end = num1 - num2;
        }
        session.setAttribute("rand", end);
        g.dispose();

        ImageIO.write(image, "JPEG", os);
        os.flush();
        os.close();
        os = null;
        response.flushBuffer();
        out.clear();
        out = pageContext.pushBody();
    } catch (IllegalStateException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }

      out.write("\r\n");
      out.write("\r\n");
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
