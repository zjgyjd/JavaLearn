package com.zjgyjd.db;

import java.sql.*;

public class dbManager {
    private String drives = "com.mysql.jdbc.Driver";
    private String username = "root";
    private String password = "1234";
    private String url = "jdbc:mysql://localhost:3306/servletdb";

    public Connection conn = null;
    public Statement state = null;
    private ResultSet rs = null;

    public dbManager() {

    }

    public Connection getConn() {
        try {
            Class.forName(drives);//驱动
            conn = DriverManager.getConnection(url, username, password);//连接
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet queryFunction(String strSql){
        conn = this.getConn();
        try {
            state = conn.createStatement();
            rs  = state.executeQuery(strSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void closeDb() {
        try {
            if (state != null) state.close();
            if (conn != null) conn.close();
            if(rs != null) rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
