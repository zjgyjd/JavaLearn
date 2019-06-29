package com.zjgyjd.mapper;

import com.zjgyjd.po.ItemsCustom;
import com.zjgyjd.po.ItemsEx;

import java.util.List;

public interface ItemsCustomMapper {
       public List<ItemsCustom> queryItemsByName(ItemsEx itemsEx) throws  Exception;
}
