package com.zjgyjd;

import java.util.Scanner;

public class Testjdbc_2  extends jdbcTemplate{
    @Override
    public String praviderSql() {
        String insert = "insert into memo_group(id,name,created_time) values(5,'C++',current_time())";
        String delete = "delete from memo_group where id = 5";
        String select =  "select id,name,created_time,modify_time from memo_group";
        String update = "update memo_group set name = 'C++' where id = 4";
        int i = new Scanner(System.in).nextInt();
        return i==1?select:update;
    }


    @Override
    public <T> T handlerResultSet() {
        return null;
    }

    public static void main(String[] args) {
        jdbcTemplate jdbcTemplate = new Testjdbc_2();
        jdbcTemplate.execute();
    }
}
