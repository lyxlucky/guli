package com.lyx.service;

import com.lyx.entity.Order;

/**
 * @author liao 2021/10/30
 */
public interface OrderService {

    /**
     * 生成订单的方法
     * @param courseId
     * @param memberID
     * @return
     */
    public String createOrder(String courseId,String memberID);

    /**
     * 根据订单Id查询订单详细信息
     * @param orderNo
     * @return
     */
    public Order getOrderByOrderId(String orderNo);

    /**
     * 根据orderId更新order
     * @param order
     * @return
     */
    public Integer updateById(Order order);


}
