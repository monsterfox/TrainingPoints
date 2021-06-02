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
import java.util.List;


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
        /*
            1.设置编码
         */
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        /*
            2.查询数据 -- 返回分页模型对象（包含：集合，当前页，每页记录数，总记录数，总页数，上一页，下一页）
         */
        String pageSize = request.getParameter("pageSize");//获取参数-每页显示行数
        String pageNo = request.getParameter("pageNo");//获取参数-当前显示页次

        BookDao client=new BookDao();
        PageModel<Book> pageModel=client.findData(pageNo,pageSize);//查询分页数据
        request.setAttribute("pageModel", pageModel);//把pageModel分页模型放入request作用域，传递到前端页面进行展示

        /*
            3.转发到result.jsp页面进行数据展示（如果页面展示使用jstl,可以把页面地址改为result-jstl.jsp）
         */
        request.getRequestDispatcher("result-jstl.jsp").forward(request, response);
    }

}