package com.zjgyjd.service;

import com.zjgyjd.db.DbMessage;
import com.zjgyjd.user.UserInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryService {

    public Connection conn= null;//rs
    public ResultSet rs = null;
    public List<UserInfo> queryDb(UserInfo userInfo){
        String db_username;
        String db_password;
        String query = "select * from t_userinfo where username='"+userInfo.getUsername()+
                "' and password ='"+userInfo.getPassword()+"';";
        DbMessage db = new DbMessage();
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        try {
            rs = db.excute(query);
            while(rs.next()){
                db_username = rs.getString("username");
                db_password = rs.getString("password");
                if(userInfo.getUsername().equals(db_username) && userInfo.getPassword().equals(db_password)){
                    userInfoList.add(userInfo);
                    return userInfoList;
                }else{
                    return null;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
