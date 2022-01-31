package com.lyx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPayUtil;
import com.lyx.dao.PayLogDao;
import com.lyx.entity.Order;
import com.lyx.entity.PayLog;
import com.lyx.service.OrderService;
import com.lyx.service.PayLogService;
import com.lyx.utils.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liao 2021/10/30
 */
@Service
public class PayLogServiceImpl implements PayLogService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayLogDao payLogDao;


    @Override
    public Map<String, Object> createWxQrCode(String orderNo) {
        try {
            Order orderInfo = orderService.getOrderByOrderId(orderNo);
            HashMap<String, String> map = new HashMap<>();
            //支付id
            map.put("appid","wx74862e0dfcf69954");
            //商户号
            map.put("mch_id", "1558950191");
            //生成随机的字符串，让每次生成的二维码不一样
            map.put("nonce_str", WXPayUtil.generateNonceStr());
            //生成二维码的名字
            map.put("body", orderInfo.getCourseTitle());
            //二维码唯一的标识
            map.put("out_trade_no", orderNo);
            //支付金额
            map.put("total_fee", orderInfo.getTotalFee().multiply(new BigDecimal("100")).longValue()+"");
            //现在进行支付的ip地址，实际项目使用项目的域名
            map.put("spbill_create_ip", "127.0.0.1");
            //支付后回调地址
            map.put("notify_url", "http://localhost:8160/api/order/weixinPay/weixinNotify");
            //支付类型，NATIVE:根据价格生成二维码
            map.put("trade_type", "NATIVE");
            //3、发送httpClient请求，传递参数【xml格式】，微信支付提供的固定地址
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");

            client.setXmlParam(WXPayUtil.generateSignedXml(map,"T6m9iK73b0kn9g5v426MKfHQH7X8rKwb"));
            //上面发送请求的是https。默认支持，需要设置为true支持
            client.setHttps(true);
            //执行post请求发送
            client.post();

            //4、得到发送请求返回的结果
            //返回的结果是xml格式的
            String content = client.getContent();
            //把xml格式转换为map集合，他里面的数据不全
            Map<String, String> resultMap = WXPayUtil.xmlToMap(content);

            HashMap hashMap = new HashMap<>();
            hashMap.put("out_trade_no",orderNo);
            hashMap.put("course_id",orderInfo.getCourseId());
            hashMap.put("total_fee",orderInfo.getTotalFee());
            //二维码操作状态码
            hashMap.put("result_code",resultMap.get("result_code"));
            //二维码地址
            hashMap.put("code_url",resultMap.get("code_url"));
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("生成二维码失败");
        }
    }

    @Override
    public Map<String, String> queryPayStatus(String orderNo) {
        try{
            //1、封装参数
            Map m = new HashMap<>();
            m.put("appid", "wx74862e0dfcf69954");
            m.put("mch_id", "1558950191");
            m.put("out_trade_no", orderNo);
            m.put("nonce_str", WXPayUtil.generateNonceStr());

            //2、发送httpClient请求
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/orderquery");
            client.setHttps(true);
            //通过商户key加密
            client.setXmlParam(WXPayUtil.generateSignedXml(m,"T6m9iK73b0kn9g5v426MKfHQH7X8rKwb"));
            client.post();

            //3、返回第三方的数据
            String xml = client.getContent();
            //4、转成Map
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);

            //5、返回
            return resultMap;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateOrderStatus(Map<String, String> map) {
        //获取前一步生成二维码中的订单号
        String orderNo = map.get("out_trade_no");
        Order orderByOrderId = orderService.getOrderByOrderId(orderNo);
        //判断订单状态是否为1，为1就是支付过了
        if (orderByOrderId.getStatus().intValue()==1){return;}

        //更新订单表中的叮当状态
        //1代表已支付
        orderByOrderId.setStatus(1);
        orderService.updateById(orderByOrderId);

        PayLog payLog = new PayLog();
        //支付订单号
        payLog.setOrderNo(orderNo);
        //支付时间
        payLog.setPayTime(new Date());
        //支付类型
        payLog.setPayType(1);
        //总金额(分)
        payLog.setTotalFee(orderByOrderId.getTotalFee());
        //支付状态
        payLog.setTradeState(map.get("trade_state"));
        //订单流水号
        payLog.setTransactionId(map.get("transaction_id"));
        payLog.setAttr(JSONObject.toJSONString(map));

        payLogDao.addPayLog(payLog);
    }
}
