package com.foxbill.dao;


import com.foxbill.domain.Book;
import com.foxbill.domain.PageModel;
import com.foxbill.util.DBUtil;
import com.foxbill.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

    public PageModel<Book> findData(String pageNo, String pageSize) {
        //声明分页模型
        PageModel<Book> pageModel = null;
        //设置参数默认值
        if (pageSize == null) {// 为空时设置默认页大小为10
            pageSize = "10";
        }
        if (pageNo == null) {// 为空时设置默认为第1页
            pageNo = "1";
        }

        int size = Integer.parseInt(pageSize);
        int no = Integer.parseInt(pageNo);

        //连接数据库，查询分页相关数据
        try {
            String sql = "select * from books limit ?,?";//第一个参数，代表从哪条记录开始；第二个参数，代表一共查询多少条记录。
            List<Book> list = null;

            list = qr.query(sql,new BeanListHandler<Book>(Book.class),(no - 1) * size,size);
            //查询总记录数
            sql = "select count(*) from books";
            Long query = qr.query(sql, new ScalarHandler<>());
            int total = query.intValue();

            //初始化分页模型，并设置参数
            pageModel = new PageModel<Book>();
            pageModel.setPageNo(Integer.parseInt(pageNo));//设置页码
            pageModel.setPageSize(Integer.parseInt(pageSize));//设置每页记录数

            pageModel.setTotalRecords(total);//设置总记录数
            pageModel.setList(list);//设置图书信息（集合）
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageModel;
    }

    //测试分页方法
    public static void main(String[] args) {
        BookDao client = new BookDao();
        PageModel<Book> pageModel = client.findData("2", "4");
        List<Book> list = pageModel.getList();
        for (Book a : list) {
            System.out.print("ID:" + a.getId() + ",名称:" + a.getName() + ",价格:" + a.getPrice());
            System.out.println();
        }
        System.out.print("当前页:" + pageModel.getPageNo() + " ");
        System.out.print("共" + pageModel.getTotalPages() + "页  ");
        System.out.print("上一页:" + pageModel.getPreviousPageNo() + " ");
        System.out.print("下一页:" + pageModel.getNextPageNo() + " ");
        System.out.print("尾页:" + pageModel.getTotalPages() + " ");
        System.out.print("共" + pageModel.getTotalRecords() + "条记录");
        System.out.println();
    }

    /*
        查询所有图书
     */
    public List<Book> findAllData() {
        //连接数据库，查询分页相关数据
        String sql = "select * from books";
        List<Book> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}