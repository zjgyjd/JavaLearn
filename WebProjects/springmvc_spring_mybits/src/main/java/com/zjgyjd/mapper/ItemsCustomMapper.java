package com.zjgyjd.mapper;

import com.zjgyjd.po.ItemsEx;

import java.util.List;

public interface ItemsCustomMapper {
       public List<ItemsEx> queryItemsByName(ItemsEx itemsEx) throws  Exception;
}
