package com.zjgyjd.service;

import com.zjgyjd.domain.Account;

import java.util.List;
public interface AccountService {
    //查找
    public List<Account> findAll();
    //保存
    public void saveAccount(Account account);
}
