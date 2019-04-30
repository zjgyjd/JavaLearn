package com.zjgyjd;

import java.sql.*;

public class CsdnBlogDB {
    private Connection conn = null;
    private Statement stmt = null;

    CsdnBlogDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test2?user=root&password=1234";
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public int add(CsdnBlog csdnBlog) {
        try {
            String sql = "INSERT INTO `test2`.`csdnblog` (`id`, `title`, `date`,  `view`,  `copyright`) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, csdnBlog.getId());
            ps.setString(2, csdnBlog.getTitle());
            ps.setString(3, csdnBlog.getDate());
            ps.setInt(4, csdnBlog.getView());
            ps.setString(5, csdnBlog.getCopyright());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


}
