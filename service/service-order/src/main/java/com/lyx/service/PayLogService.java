package com.lyx.service;

import java.util.Map;

/**
 * @author liao 2021/10/30
 */
public interface PayLogService {

    /**
     * 生成微信支付二维码
     * @param orderNo
     * @return
     */
    public Map<String,Object> createWxQrCode(String orderNo);

    /**
     * 根据订单号，查询支付的状态
     * @param orderNo
     * @return
     */
    Map<String, String> queryPayStatus(String orderNo);

    /**
     * 向支付表中添加支付记录，并更新订单表的订单状态
     * @param map
     */
    void updateOrderStatus(Map<String, String> map);
}
