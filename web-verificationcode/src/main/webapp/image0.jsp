<%@ page import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*"%>
<%@ page import="java.io.OutputStream" contentType="image/jpeg" %>
<%
    try {
        //0.取消缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);


        //1.建立BufferedImage对象。指定图片的长度宽度和色彩
        int width = 60, height = 20;
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        //2.取得Graphics对象，用来绘制图片
        Graphics g = image.getGraphics();
        //3.绘制图片背景和文字
        g.setColor(new Color(200, 250, 120));//设置画笔颜色
        g.fillRect(0, 0, width, height);//用画笔填充矩形区域

        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));//设置字体
        g.setColor(new Color(60, 0, 10));//设置画笔颜色
        g.drawLine(5, 5, 5 + 10, 5 + 8);//生成干扰线（画线）

        //生成验证码
        Random random = new Random();
        String sRand = 1000+random.nextInt(9000)+"";
        g.drawString(sRand, 20, 16);//画字符串

        //4.释放Graphics对象所占用的资源
        g.dispose();
        //5.通过ImageIO对象的write静态方法将图片输出。
        ImageIO.write(image, "JPEG", response.getOutputStream());

        /*
            知道了图片的生成方法，剩下的问题就是如何将随机数生成到页面上了。
            要显示图片，只要将生成的图片流返回给response对象，这样用户请求的时候就可以得到图片。
            而一个JSP页面的page参数的contentType属性可以指定返回的response对象的形式，
            大家平时的JSP页面中设定的contentType是text/html，所以会被以HTML文件的形式读取和分析。
            如果设定为image/jpeg，就会被以图片的形式读取和分析
         */

        /*
            由于jsp container在处理完成请求后会调用releasePageContet方法释放所用的PageContext object,
             并且同时调用getWriter方法,由于getWriter方法与在jsp页面中使用流相关的getOutputStream方法冲突,
             所以会造成这种异常,解决办法是:只需要在jsp页面的最后加上两条语句: out.clear();
            out=pageContext.pushBody();即可(其中out,pageContext均为jsp内置对象!)
        */

        //6.释放资源
//        os.flush();
//        os.close();
//        os = null;
//        response.flushBuffer();
        out.clear();
        out = pageContext.pushBody();
    } catch (IllegalStateException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
%>
