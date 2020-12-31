package com.foxbill.servlet;

import com.foxbill.dao.ContentDao;
import com.foxbill.pojo.Content;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContentServlet",urlPatterns = "/content")
public class ContentServlet extends HttpServlet {
    private ContentDao contentDao = new ContentDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String command = request.getParameter("command");

        if ("addRTE".equals(command)){
            addRTE(request,response);
        }else if ("show".equals(command)){
            show(request,response);
        }
    }

    private void show(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Content> list = contentDao.show();
        request.setAttribute("list",list);
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }

    private void addRTE(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String content = request.getParameter("content");
        System.out.println(content);
        Content contentVO = new Content(content);
        contentDao.addContent(contentVO);

        response.sendRedirect("content?command=show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
