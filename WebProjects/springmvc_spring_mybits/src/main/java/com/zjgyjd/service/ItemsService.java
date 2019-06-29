package com.zjgyjd.service;

import com.zjgyjd.po.ItemsCustom;
import com.zjgyjd.po.ItemsEx;

import java.util.List;

public interface ItemsService {
    //依据商品名称查询列表
    public List<ItemsCustom> queryItemsByName(ItemsEx itemsEx) throws  Exception;
}
