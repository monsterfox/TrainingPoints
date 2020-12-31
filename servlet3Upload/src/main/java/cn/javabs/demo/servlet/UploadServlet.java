package cn.javabs.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UploadServlet",urlPatterns = "/uploadFile")
@MultipartConfig(maxFileSize = 1024*50*1024)
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 1. 定义路径
        String realPath = this.getServletContext().getRealPath("/upload/");

        // 2. 如果该文件夹不存在、则帮我创建出来
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        Part fileSource = null;

//        String author = request.getParameter("author");
//        System.out.println(author);

        try {
            // 3. 获取上传文件
            fileSource = request.getPart("uploadFile");
        } catch (Exception e) {
            throw new RuntimeException("\"文件上传失败，请上传小于5kb的文件\""+e);
        }
        // 4. 获取上传文件的文件名
        //Tomcat8 可用
        //String fileName = sourceName.getSubmittedFileName();

        //Tomcat7 可用
        String cd = fileSource.getHeader("Content-Disposition");
        //截取不同类型的文件需要自行判断
        String fileName = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);

        //4.2 更改上传文件名称:
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        // 如果文件名称存在
        if (!fileName.equals("") || fileName != null){
            fileName = currentDate + "_" + fileName;
        }

        fileSource.write(realPath+"/"+fileName);

        request.setAttribute("msg","添加资源成功！");
        request.getRequestDispatcher("/message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
