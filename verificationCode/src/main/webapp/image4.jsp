<%@ page contentType="text/html;charset=gb2312" %>
<%@ page
        import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*" %>
<%@ page import="java.io.OutputStream" %>
<%
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
%>

