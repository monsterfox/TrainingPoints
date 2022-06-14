/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-12-28 02:17:57 UTC
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

public final class image1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

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
      response.setContentType("text/html");
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
      out.write('\r');
      out.write('\n');

    try {
        //åæ¶ç¼å­
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //çæéªè¯ç å¾ç
        int width = 60, height = 20;
        //å»ºç«BufferedImageå¯¹è±¡ãæå®å¾ççé¿åº¦å®½åº¦åè²å½©
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        OutputStream os = response.getOutputStream();
        //åå¾Graphicså¯¹è±¡ï¼ç¨æ¥ç»å¶å¾ç
        Graphics g = image.getGraphics();
        //ç»å¶å¾çèæ¯åæå­ï¼éæ¾Graphicså¯¹è±¡æå ç¨çèµæº
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);

        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        g.setColor(getRandColor(160, 200));

        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);//çæå¹²æ°çº¿
        }
        //çæéªè¯ç 
        String sRand = "";
        for (int i=0; i<4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20
                    + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13*i+6, 16);
        }

        session.setAttribute("rand", sRand);//æéªè¯ç æ¾å¥sessionä½ç¨å

        g.dispose();
        //éè¿ImageIOå¯¹è±¡çwriteéææ¹æ³å°å¾çè¾åºã
        ImageIO.write(image, "JPEG", os);
        //ç¥éäºå¾çççææ¹æ³ï¼å©ä¸çé®é¢å°±æ¯å¦ä½å°éæºæ°çæå°é¡µé¢ä¸äºãè¦æ¾ç¤ºå¾çï¼åªè¦
        //å°çæçå¾çæµè¿åç»responseå¯¹è±¡ï¼è¿æ ·ç¨æ·è¯·æ±çæ¶åå°±å¯ä»¥å¾å°å¾çãèä¸ä¸ªJSP
        //é¡µé¢çpageåæ°çcontentTypeå±æ§å¯ä»¥æå®è¿åçresponseå¯¹è±¡çå½¢å¼ï¼å¤§å®¶å¹³æ¶
        //çJSPé¡µé¢ä¸­è®¾å®çcontentTypeæ¯text/htmlï¼æä»¥ä¼è¢«ä»¥HTMLæä»¶çå½¢å¼è¯»åå
        //åæãå¦æè®¾å®ä¸ºimage/jpegï¼å°±ä¼è¢«ä»¥å¾ççå½¢å¼è¯»åååæ
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

      out.write('\r');
      out.write('\n');
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
