package com.zjgyjd;

import com.zjgyjd.mapper.ItemsCustomMapper;
import com.zjgyjd.po.Items;
import com.zjgyjd.po.ItemsCustom;
import com.zjgyjd.po.ItemsEx;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyBatisTest_02 {
    private ApplicationContext applicationContext = null;

    @Before
    public void initFun() throws Exception {
        applicationContext =
                new ClassPathXmlApplicationContext("spring/applicationContext-mapper.xml");
    }

    @Test
    public void testQueryItemsByName() throws Exception {
        ItemsCustomMapper itemsCustomMapper = (ItemsCustomMapper) applicationContext.
                getBean("itemsCustomMapper");
        ItemsEx itemsEx = new ItemsEx();
        itemsEx.setName("本");
        List<ItemsCustom> itemsExList = itemsCustomMapper.queryItemsByName(itemsEx);
        System.out.println(itemsExList);
    }
}
