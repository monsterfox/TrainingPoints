package com.foxbill.domain;

import java.util.List;

/** 
 * 封装分页信息 
 * @author Administrator 
 * 
 */  
public class PageModel<E> {  
    //结果集  
    private List<E> list;
    //当前页
    private int pageNo;
    //每页显示记录数
    private int pageSize;
    //查询记录数
    private int totalRecords;
    //总页数            （根据总记录数和每页记录数计算）
    private int totalPages;
    //上一页            （根据当前页计算）
    private int previousPageNo;
    //下一页            （根据当前页计算）
    private int nextPageNo;

    /** 
     * 总页数 
     * @return 
     */  
    public int getTotalPages() {  
        return (totalRecords + pageSize - 1) / pageSize;  
    }  

    /** 
     * 上一页 
     * @return 
     */  
    public int getPreviousPageNo() {  
        if (pageNo <= 1) {  
            return 1;  
        }  
        return pageNo - 1;  
    }  
      
    /** 
     * 下一页 
     * @return 
     */  
    public int getNextPageNo() {  
        if (pageNo >= getTotalPages()) {
            return getTotalPages();
        }  
        return pageNo + 1;    
    }  

    /**
     * get set函数  
     * @return
     */
    public List<E> getList() {  
        return list;  
    }  
  
    public void setList(List<E> list) {  
        this.list = list;  
    }  
  
    public int getTotalRecords() {  
        return totalRecords;  
    }  
  
    public void setTotalRecords(int totalRecords) {  
        this.totalRecords = totalRecords;  
    }  
  
    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
  
    public int getPageNo() {  
        return pageNo;  
    }  
  
    public void setPageNo(int pageNo) {  
        this.pageNo = pageNo;  
    }  
}