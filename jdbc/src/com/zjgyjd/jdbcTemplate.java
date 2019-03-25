package com.zjgyjd;

import java.sql.*;
import java.time.LocalDateTime;

public abstract class jdbcTemplate {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public void loadDriverClass() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connection(String url) {
        try {
            connection = DriverManager.getConnection(url, "root", "1234");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract String praviderSql();

    public abstract <T> T handlerResultSet();

    public void createStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeResource() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public final <T> T execute() {
        this.loadDriverClass();
        String url = this.getString("memo");
        this.connection(url);
        this.createStatement();
        String sql = this.praviderSql();
        if (sql.trim().startsWith("select") || sql.trim().startsWith("SELECT")) {
            try {
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    LocalDateTime createTime = resultSet.getTimestamp("created_time")
                            .toLocalDateTime();

                    LocalDateTime modifyTime = resultSet.getTimestamp("modify_time")
                            .toLocalDateTime();

                    System.out.println(id + "  " + name + "  " + createTime + "  " + modifyTime);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            int rSet  = 0;
            try {
                rSet = statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(rSet);
        }
        //close用finally
        return null;
    }

    private String getString(String dataBase) {

        return "jdbc:mysql://localhost:3306/" + dataBase;
    }
}

