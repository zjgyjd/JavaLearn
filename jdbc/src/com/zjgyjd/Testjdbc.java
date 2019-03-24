package com.zjgyjd;

import java.sql.*;
import java.time.LocalDateTime;

public class Testjdbc {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        String url = "jdbc:mysql://localhost:3306/memo";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection  = DriverManager.getConnection(url,"root","1234");

            statement = connection.createStatement();

            String sql = "select id,name,created_time,modify_time from memo_group";
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime createTime = resultSet.getTimestamp("created_time")
                        .toLocalDateTime();

                LocalDateTime modifyTime = resultSet.getTimestamp("modify_time")
                        .toLocalDateTime();

                System.out.println(id+"  "+name+"  "+createTime+"  "+modifyTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
             if(resultSet != null){
                 try {
                     resultSet.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
             if(connection != null){
                 try {
                     connection.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
             if(statement != null){
                 try {
                     statement.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
        }
    }
}

