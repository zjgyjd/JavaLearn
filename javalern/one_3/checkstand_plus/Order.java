package com.bittech.checkstand.plus;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: secondriver
 * Created: 2018/12/21
 */
public class Order {
    
    private final String orderId;
    
    private final Map<String, Integer> goodsInfo = new HashMap<>();
    
    public Order(String orderId) {
        this.orderId = orderId;
    }
    
    /**
     * 订单添加商品
     *
     * @param goodsId 商品编号
     * @param count   数量
     */
    public void add(String goodsId, Integer count) {
//        Optional<Integer> current = Optional.ofNullable(this.goodsInfo.get(goodsId));
//        Integer sum = current.map(integer -> integer + count).orElse(count);
//        this.goodsInfo.put(goodsId, sum);
        
        Integer sum = this.goodsInfo.get(goodsId);
        if (sum == null) {
            sum = count;
        } else {
            sum += count;
        }
        this.goodsInfo.put(goodsId, sum);
    }
    
    public void cancel(String goodsId, Integer count) {
//        Optional<Integer> current = Optional.ofNullable(this.goodsInfo.get(goodsId));
//        Integer sum = current.map(integer -> integer - count).orElse(0);
//        this.goodsInfo.put(goodsId, sum <= 0 ? 0 : sum);
        
        Integer sum = this.goodsInfo.get(goodsId);
        if (sum != null) {
            sum -= count;
            sum = sum < 0 ? 0 : sum;
            if (sum > 0) {
                this.goodsInfo.put(goodsId, sum);
            } else {
                this.goodsInfo.remove(goodsId);
            }
        }
    }
    
    public void clear() {
        this.goodsInfo.clear();
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    
    public Map<String, Integer> getOrderInfo() {
        return this.goodsInfo;
    }
    
    
}