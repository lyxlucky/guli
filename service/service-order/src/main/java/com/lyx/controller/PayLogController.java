package com.lyx.controller;

import com.lyx.entity.CommonResult;
import com.lyx.service.PayLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liao 2021/10/30
 */
@RestController
@RequestMapping("/eduorder")
public class PayLogController {

    @Autowired
    private PayLogService payLogService;


    @PostMapping("/paylog/{orderNo}")
    @ApiOperation("根据订单号，生成支付二维码的接口")
    public CommonResult createWxQrcode(@PathVariable String orderNo){
        //返回信息，包含二维码地址、其他信息
        Map<String, Object> map = payLogService.createWxQrCode(orderNo);
        return CommonResult.ok().data("data",map);
    }

    @GetMapping("/paylog/{orderNo}")
    @ApiOperation("根据订单号查询订单支付状态")
    public CommonResult getOrderStatus(@PathVariable String orderNo){
        Map<String, String> map = payLogService.queryPayStatus(orderNo);
        if (map==null){
            return CommonResult.error().message("支付出错了");
        }
        //如果返回的map不为空，通过map获取订单的状态
        //支付成功
        if (map.get("trade_state").equals("SUCCESS")){
            //添加记录到支付表里，并更新订单表的状态
            payLogService.updateOrderStatus(map);
            return CommonResult.ok().message("支付成功");
        }

        return CommonResult.ok().message("支付中").code(25000);
    }

}
