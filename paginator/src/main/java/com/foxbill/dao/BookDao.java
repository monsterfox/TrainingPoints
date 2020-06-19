package com.foxbill.dao;


import com.foxbill.domain.Book;
import com.foxbill.domain.PageModel;
import com.foxbill.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public PageModel<Book> findData(String pageNo, String pageSize){
        PageModel<Book> pageModel=null;

        if (pageSize == null) {// 为空时设置默认页大小为10
            pageSize = "10";
        }
        if (pageNo == null) {// 为空时设置默认为第1页
            pageNo = "1";
        }

        Connection conn= DBUtil.getConnection();
        String sql="select * from books limit ?,?";
        PreparedStatement pst=null;  
        ResultSet rs=null;
        Book rec=null;
        List<Book> list=new ArrayList<Book>();

        try {  
              pst=conn.prepareStatement(sql); 
              //pstm.setInt(1, (pageNo-1)*pageSize); 
              //pstm.setInt(2, pageNo*pageSize);
              pst.setInt(1, (Integer.parseInt(pageNo)-1)*Integer.parseInt(pageSize));  
              pst.setInt(2, Integer.parseInt(pageSize));  
              rs=pst.executeQuery();
              while(rs.next()){  
                  rec=new Book();
                  rec.setId(rs.getInt("id"));  
                  rec.setName(rs.getString("name"));
                  rec.setPrice(rs.getFloat("price"));
                  rec.setPnum(rs.getInt("pnum"));
                  rec.setCategory(rs.getString("category"));
                  list.add(rec);
               }  
               ResultSet rs2=pst.executeQuery("select count(*) from books");
               int total=0;  
               if(rs2.next()){  
                   total=rs2.getInt(1);//总的数据条数 
               }  
                pageModel=new PageModel<Book>();
                pageModel.setPageNo(Integer.parseInt(pageNo));  
                pageModel.setPageSize(Integer.parseInt(pageSize));  
                pageModel.setTotalRecords(total);  
                pageModel.setList(list); 
            } catch (SQLException e) {  
                e.printStackTrace();  
            }finally{  
               DBUtil.closePst(rs, pst, conn);
            } 
        return pageModel;  
    }  
      
    public static void main(String[] args) {
        BookDao client=new BookDao();
        PageModel<Book> pageModel=client.findData("2","4");
        List<Book> list=pageModel.getList();
        for(Book a:list){
            System.out.print("ID:"+a.getId()+",名称:"+a.getName()+",价格:"+a.getPrice());
            System.out.println();  
        }  
        System.out.print("当前页:"+pageModel.getPageNo()+" ");  
        System.out.print("共"+pageModel.getTotalPages()+"页  ");  
        System.out.print("上一页:"+pageModel.getPreviousPageNo()+" ");
        System.out.print("下一页:"+pageModel.getNextPageNo()+" ");  
        System.out.print("尾页:"+pageModel.getTotalPages()+" ");
        System.out.print("共"+pageModel.getTotalRecords()+"条记录");  
        System.out.println();  
    }
  
}