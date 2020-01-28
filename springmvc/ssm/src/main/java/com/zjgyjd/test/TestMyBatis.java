package com.zjgyjd.test;

import com.zjgyjd.dao.AccountDao;
import com.zjgyjd.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestMyBatis {
    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询数据
        List<Account> list =  dao.findAll();
        for (Account account : list){
            System.out.println(account);
        }
        session.close();
        is.close();
    }
    //测试保存
    @Test
    public void run2() throws IOException {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        Account account = new Account();
        account.setName("熊大");
        account.setMoney(100d);
        dao.saveAccount(account);
        //此时需要提交事务
        session.commit();
        session.close();
        is.close();
    }
}
