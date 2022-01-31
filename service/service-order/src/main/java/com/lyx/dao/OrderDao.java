package com.lyx.dao;

import com.lyx.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * @author liao 2021/10/30
 */
@Repository
public interface OrderDao {

    /**
     * 添加订单记录
     * @param order
     * @return
     */
    public Integer addOrder(Order order);

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
