package com.foxbill.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 基于Servlet3.0 实现文件（图片）上传
 */
@WebServlet(name = "ImgUploadServlet",urlPatterns = "/ImgUpload.action")
@MultipartConfig(maxFileSize = 1024*50*1024)
public class ImgUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        // CKEditor提交的很重要的一个参数
        String callback = request.getParameter("CKEditorFuncNum");//可以通过浏览器的开发者工具，查看
        String expandedName = ""; // 文件扩展名

        // 1. 定义路径
        String realPath = this.getServletContext().getRealPath("/img/uploadImg/");

        // 2. 如果该文件夹不存在、则创建出来
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }

        Part fileSource = null;
        try {
            // 3. 获取上传文件
            fileSource = request.getPart("upload");
        } catch (Exception e) {
            throw new RuntimeException("\"文件上传失败，请上传小于5kb的文件\""+e);
        }

        //4. 验证文件类型
        String uploadContentType = fileSource.getContentType();//获取文件类型
        //如果文件类型，不为图片，则提示错误
        if (uploadContentType.equals("image/pjpeg") || uploadContentType.equals("image/jpeg")) {
            // IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
            expandedName = ".jpg";
        } else if (uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")) {
            // IE6上传的png图片的headimageContentType是"image/x-png"
            expandedName = ".png";
        } else if (uploadContentType.equals("image/gif")) {
            expandedName = ".gif";
        } else if (uploadContentType.equals("image/bmp")) {
            expandedName = ".bmp";
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
            out.println("</script>");
        }

        //5. 验证文件大小
        long size = fileSource.getSize();//获取文件的大小
        System.out.println(size/1024);
        if (size > 600 * 1024) {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件大小不得大于600k');");
            out.println("</script>");
            return;
        }

        // 6. 获取上传文件的文件名
        //Tomcat8 可用
        //String fileName = fileSource.getSubmittedFileName();

        //Tomcat7 可用
        String cd = fileSource.getHeader("Content-Disposition");
        //截取不同类型的文件需要自行判断
        String fileName = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);
        System.out.println(fileName);

        //6.2 更改上传文件名称:
        // 如果文件名称不为空
        if (!fileName.equals("") || fileName != null){
            fileName = UUID.randomUUID() + "_" + fileName;
        }
        //7. 写文件
        fileSource.write(realPath+"/"+fileName);

        // 返回"图像"选项卡并显示图片  request.getContextPath()为web项目名
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + request.getContextPath() + "/img/uploadImg/" + fileName + "','')");
        out.println("</script>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
