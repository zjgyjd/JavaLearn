package com.zjgyjd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class jdbcTemplate {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public void loadDriverClass(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connection(){
        //todo
    }

    public abstract String praviderSql();

    public  abstract <T> T  handlerResultSet();

    public void createStatement(){
        //todo
    }

    public void closeResource(){
        //todo
    }

    public final <T> T execute(){
        this.loadDriverClass();
        this.connection();
        this.createStatement();
        String sql = this.praviderSql();
        if(sql.trim().startsWith("select")||sql.trim().startsWith("SELECT")){
            //todo
        }else {
            //todo
        }
        //close用finally
        return null;
    }
}

