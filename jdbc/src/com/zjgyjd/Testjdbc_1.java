package com.zjgyjd;

import java.sql.*;
import java.time.LocalDateTime;

/*
增添
 */
public class Testjdbc_1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        String url = "jdbc:mysql://localhost:3306/memo";
        Connection connection = null;
        Statement statement = null;
        int resultSet = 0;
            try {
            connection  = DriverManager.getConnection(url,"root","1234");

            statement = connection.createStatement();

            String sql = "insert into memo_group(id,name,created_time) values(5,'C++',current_time())";
            resultSet = statement.executeUpdate(sql);
            System.out.println(resultSet);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

