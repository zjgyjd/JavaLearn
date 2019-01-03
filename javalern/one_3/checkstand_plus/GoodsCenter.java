package com.bittech.checkstand.plus;

/**
 * 商品中心
 * <p>
 * Author: secondriver
 * Created: 2018/12/21
 */
public interface GoodsCenter {
    
    /**
     * 添加商品
     *
     * @param goods
     */
    void addGoods(Goods goods);
    
    /**
     * 移除商品
     *
     * @param goodsId
     */
    void removeGoods(String goodsId);
    
    /**
     * 更新商品
     *
     * @param goods
     */
    void updateGoods(Goods goods);
    
    /**
     * 判断商品是否存在
     *
     * @param goodsId
     * @return
     */
    boolean isExistGoods(String goodsId);
    
    /**
     * 通过商品编号获取商品
     *
     * @param goodsId
     * @return
     */
    Goods getGoods(String goodsId);
    
    /**
     * 列出商品信息
     */
    String listGoods();
    
    
    /**
     * 保存商品信息
     */
    void store();
    
}