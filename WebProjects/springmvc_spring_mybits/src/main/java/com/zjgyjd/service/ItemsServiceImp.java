package com.zjgyjd.service;

import com.zjgyjd.mapper.ItemsCustomMapper;
import com.zjgyjd.po.ItemsCustom;
import com.zjgyjd.po.ItemsEx;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImp implements ItemsService {
    @Autowired
    private ItemsCustomMapper itemsCustomMapper;
    @Override
    public List<ItemsCustom> queryItemsByName(ItemsEx itemsEx) throws Exception{
        return itemsCustomMapper.queryItemsByName(itemsEx);
    }
}
