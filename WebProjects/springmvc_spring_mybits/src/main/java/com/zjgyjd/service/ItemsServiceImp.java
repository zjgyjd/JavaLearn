package com.zjgyjd.service;

import com.zjgyjd.mapper.ItemsCustomMapper;
import com.zjgyjd.mapper.ItemsMapper;
import com.zjgyjd.po.Items;
import com.zjgyjd.po.ItemsCustom;
import com.zjgyjd.po.ItemsEx;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImp implements ItemsService {
    @Autowired
    private ItemsCustomMapper itemsCustomMapper;
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom> queryItemsByName(ItemsEx itemsEx) throws Exception {
        return itemsCustomMapper.queryItemsByName(itemsEx);
    }

    public void updateItemsById(ItemsEx itemsEx) throws Exception {
       itemsCustomMapper.updateItemsById(itemsEx);
    }

    public ItemsCustom selectByPrimaryKey(int id) {
        Items items = itemsMapper.selectByPrimaryKey(id);
        ItemsCustom itemsCustom = new ItemsCustom();
        BeanUtils.copyProperties(items, itemsCustom);
        return itemsCustom;
    }

    public void deleteByPrimaryKey(Integer id){
        itemsMapper.deleteByPrimaryKey(id);
    }
}
