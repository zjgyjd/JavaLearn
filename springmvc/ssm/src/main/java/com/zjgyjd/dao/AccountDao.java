package com.zjgyjd.dao;

import com.zjgyjd.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户dao接口,
 */
@Repository
public interface AccountDao {
    //查找
    @Select("select * from account")
    public List<Account> findAll();
    //保存
    @Insert("insert into account(name,money) values (#{name},#{money})")
    public void saveAccount(Account account);
}
