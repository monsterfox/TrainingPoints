<%@ page
        import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*"%>
<%@ page import="java.io.OutputStream"%>
<%!
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
%>
<%
    try {
        //取消缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成验证码图片
        int width = 60, height = 20;
        //建立BufferedImage对象。指定图片的长度宽度和色彩
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        OutputStream os = response.getOutputStream();
        //取得Graphics对象，用来绘制图片
        Graphics g = image.getGraphics();
        //绘制图片背景和文字，释放Graphics对象所占用的资源
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
            g.drawLine(x, y, x + xl, y + yl);//生成干扰线
        }
        //生成验证码
        String sRand = "";
        for (int i=0; i<4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20
                    + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13*i+6, 16);
        }

        session.setAttribute("rand", sRand);//把验证码放入session作用域

        g.dispose();
        //通过ImageIO对象的write静态方法将图片输出。
        ImageIO.write(image, "JPEG", os);
        //知道了图片的生成方法，剩下的问题就是如何将随机数生成到页面上了。要显示图片，只要
        //将生成的图片流返回给response对象，这样用户请求的时候就可以得到图片。而一个JSP
        //页面的page参数的contentType属性可以指定返回的response对象的形式，大家平时
        //的JSP页面中设定的contentType是text/html，所以会被以HTML文件的形式读取和
        //分析。如果设定为image/jpeg，就会被以图片的形式读取和分析
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
%>
