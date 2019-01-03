package com.bittech.checkstand.plus;

/**
 * 订单管理
 * Author: secondriver
 * Created: 2018/12/21
 */
public interface OrderCenter {
    
    /**
     * 添加订单
     *
     * @param order
     */
    void addOrder(Order order);
    
    /**
     * 移除订单
     *
     * @param order
     */
    void removeOrder(Order order);
    
    /**
     * 所有订单信息
     *
     * @return
     */
    String ordersTable();
    
    /**
     * 根据订单编号获取信息
     * @param orderId
     * @return
     */
    String orderTable(String orderId);
    
    /**
     * 存储订单信息
     */
    void storeOrders();
    
}
