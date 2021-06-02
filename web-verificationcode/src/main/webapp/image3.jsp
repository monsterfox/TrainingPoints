<%@page contentType="image/jpeg" pageEncoding="UTF-8"
        import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*"%>
<%!
    //生成随机颜色
    Color getRandColor(Random random, int fc, int bc) {
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
    //设置页面不缓存
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
// 设置图片的长宽
    int width=106, height=30;
//设置备选汉字，剔除一些不雅的汉字
    String base =
            "\u6211\u662f\u5f90\u5f20\u660e\u71d5\u534e\u541b\u5c24\u6731\u7ea2\u7231\u4f20\u534e\u6768\u5510\u536b\u5b8f\u950b\u5f20\u4e2d\u56fd\u5317\u4eac\u4e0a\u6d77\u5929\u6d25\u6e56\u5317";

//备选汉字的长度
    int length = base.length();
//创建内存图像
    BufferedImage image =
            new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
// 获取图形上下文
    Graphics g = image.getGraphics();
//创建随机类的实例
    Random random = new Random();
// 设定图像背景色(因为是做背景，所以偏淡)
    g.setColor(getRandColor(random, 200, 250));
    g.fillRect(0, 0, width, height);
//备选字体
    String[] fontTypes = { "u5b8bu4f53", "u65b0u5b8bu4f53",
            "u9ed1u4f53", "u6977u4f53", "u96b6u4e66" };
    int fontTypesLength = fontTypes.length;
//在图片背景上增加噪点
    g.setColor(getRandColor(random, 160, 200));
    g.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    for (int i=0; i<6; i++) {
        g.drawString("*********************************************",
                0, 5 * (i + 2));
    }
//取随机产生的认证码(6个汉字)
//保存生成的汉字字符串
    String sRand = "";
    for (int i=0; i<3; i++) {
        int start = random.nextInt(length);
        String rand = base.substring(start, start + 1);
        sRand += rand;
//设置字体的颜色
        g.setColor(getRandColor(random, 10, 150));
//设置字体
        g.setFont(new Font(fontTypes[random.nextInt(fontTypesLength)],
                Font.BOLD, 18 + random.nextInt(6)));
//将此汉字画到图片上
        g.drawString(rand, 24*i + 15 + random.nextInt(8), 24);
    }
//将认证码存入session
    session.setAttribute("rand", sRand);
    g.dispose();

//输出图像到页面
    ImageIO.write(image, "JPEG", response.getOutputStream());
    response.flushBuffer();
    out.clear();
    out = pageContext.pushBody();
%>

