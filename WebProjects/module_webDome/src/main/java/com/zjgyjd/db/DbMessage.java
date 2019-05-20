package com.zjgyjd.db;

import java.sql.*;

public class DbMessage {
    private String drives = "com.mysql.jdbc.Driver";
    private String username = "root";
    private String password = "1234";
    private String url = "jdbc:mysql://localhost:3306/servletdb";

    public Connection conn = null;
    public Statement state = null;

    public ResultSet excute(String str) throws ClassNotFoundException, SQLException {
        try {
            Class.forName(drives).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection(url, username, password);
        state = conn.createStatement();
        return state.executeQuery(str);
    }

    public void closeDb() {
        try {
            if (state != null) state.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
