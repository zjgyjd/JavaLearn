package com.zjgyjd;

import com.zjgyjd.mapper.ItemsCustomMapper;
import com.zjgyjd.po.ItemsCustom;
import com.zjgyjd.po.ItemsEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;
import java.util.List;

public class MyBatisTest_01 {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void initFun() throws Exception {
        String file = "mybatis/sqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(file);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }
   @Test
    public void testQueryItemsByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ItemsCustomMapper itemsCustomMapper = sqlSession.getMapper(ItemsCustomMapper.class);
        ItemsEx itemsEx = new ItemsEx();
        itemsEx.setName("本");
        List<ItemsCustom> itemsExList = itemsCustomMapper.queryItemsByName(itemsEx);
        System.out.println(itemsExList);
    }
}
