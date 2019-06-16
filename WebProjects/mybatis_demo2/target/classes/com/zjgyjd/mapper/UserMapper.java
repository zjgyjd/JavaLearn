package com.zjgyjd.mapper;

import com.zjgyjd.po.User;

import java.util.List;

public interface UserMapper {
    public List<User> queryUserByUser(String name)throws Exception;
}
