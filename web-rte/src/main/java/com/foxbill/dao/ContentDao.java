package com.foxbill.dao;

import com.foxbill.pojo.Content;
import com.foxbill.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ContentDao {
    private QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

    public boolean addContent(Content content){
        boolean flag = false;
        String sql = "insert into t_content values(null,?)";
        try {
            int row = qr.update(sql, content.getContent());
            flag = (row==0)?false:true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Content> show(){
        String sql = "select * from t_content";
        List<Content> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<Content>(Content.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
