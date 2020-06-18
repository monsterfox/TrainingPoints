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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String pageSize = request.getParameter("pageSize");// 每页显示行数
        String pageNo = request.getParameter("pageNo");// 当前显示页次
        if (pageSize == null) {// 为空时设置默认页大小为10
            pageSize = "10";
        }
        if (pageNo == null) {// 为空时设置默认为第1页
            pageNo = "1";
        }
        //System.out.println("pageNo="+pageNo+"pageSize="+pageSize);
        // 保存分页参数，传递给下一个页面
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("pageNo", pageNo);
        //新建Dao对象，获取pageModel
        BookDao client=new BookDao();
        PageModel<Book> pageModel=client.findData(pageNo,pageSize);
        request.setAttribute("pageModel", pageModel);//前端获取这个值
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

}