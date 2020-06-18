package com.foxbill.util;

import java.sql.*;

public class DBUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String username = "root";
    private static String password = "root";
    static {
        try {
            /**
             * 加载驱动
             */
            Class.forName(driver);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Connection getConnection() {
        /**
         * 创建连接对象
         */
        Connection conn=null;
        try {
            conn=(Connection) DriverManager.getConnection(url,username,password);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    /**
     * 关闭相关流
     */
    public static void close(ResultSet rs,Statement st,Connection conn) {
        try {
            if(rs!=null) {
                rs.close();
            }
            if(st!=null) {
                st.close();
            }
            if(conn!=null) {
                conn.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closePst(ResultSet rs,PreparedStatement pst,Connection conn) {
        try {
            if(rs!=null) {
                rs.close();
            }
            if(pst!=null) {
                pst.close();
            }
            if(conn!=null) {
                conn.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }


}