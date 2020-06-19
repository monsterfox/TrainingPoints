package com.foxbill.servlet;

import com.foxbill.dao.BookDao;
import com.foxbill.domain.Book;
import com.foxbill.domain.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class recomment
 */
@WebServlet(name = "BookServlet",value ="/getBook")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取参数
        String pageSize = request.getParameter("pageSize");// 每页显示行数
        String pageNo = request.getParameter("pageNo");// 当前显示页次

        //新建Dao对象，获取pageModel分页模型
        BookDao client=new BookDao();
        PageModel<Book> pageModel=client.findData(pageNo,pageSize);
        //pageModel分页模型放入request作用域，供前端展示使用
        request.setAttribute("pageModel", pageModel);
        //转发到result.jsp页面进行数据展示（如果页面展示使用jstl,可以把页面地址改为result-jstl.jsp）
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

}