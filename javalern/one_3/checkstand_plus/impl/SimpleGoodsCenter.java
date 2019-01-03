package com.bittech.checkstand.plus.impl;

import com.bittech.checkstand.plus.Goods;
import com.bittech.checkstand.plus.GoodsCenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: secondriver
 * Created: 2018/12/21
 */
public class SimpleGoodsCenter implements GoodsCenter {
    
    private final Map<String, Goods> goodsMap = new HashMap<>();
    
    @Override
    public void addGoods(Goods goods) {
        this.goodsMap.put(goods.getId(), goods);
    }
    
    @Override
    public void removeGoods(String goodsId) {
        this.goodsMap.remove(goodsId);
    }
    
    @Override
    public void updateGoods(Goods goods) {
        if (this.goodsMap.containsKey(goods.getId())) {
            this.goodsMap.put(goods.getId(), goods);
        }
    }
    
    @Override
    public boolean isExistGoods(String goodsId) {
        return this.goodsMap.containsKey(goodsId);
    }
    
    @Override
    public Goods getGoods(String goodsId) {
        return this.goodsMap.get(goodsId);
    }
    
    @Override
    public String listGoods() {
        StringBuilder sb = new StringBuilder();
        sb.append("******************  商品清单  ********************");
        sb.append("\n");
        sb.append("\t" + "编号" + "\t" + "产品名称" + "\t\t" + "单价");
        sb.append("\n");
        
        for (Goods goods : this.goodsMap.values()) {
            sb.append("\t" + goods.getId() + "\t" + goods.getName() + "\t\t" + goods.getPrice());
            sb.append("\n");
        }
        sb.append("*************************************************");
        sb.append("\n");
        return sb.toString();
    }
    
    @Override
    public void store() {
        //TODO goodsMap数据存储到文件
    }
}
