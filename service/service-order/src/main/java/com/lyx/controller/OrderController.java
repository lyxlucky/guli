package com.lyx.controller;

import com.lyx.entity.CommonResult;
import com.lyx.entity.Order;
import com.lyx.service.OrderService;
import com.lyx.utils.JwtUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author liao 2021/10/30
 */
@RestController
@RequestMapping("/eduorder")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 根据课程Id生成订单
     * @return
     */
    @PostMapping("/order/{id}")
    @ApiOperation("根据课程Id生成订单")
    public CommonResult createOrder(@PathVariable String id, @RequestHeader("token") String token){
        String userId = JwtUtils.getTokenInfo(token).getClaim("id").asString();
        if(StringUtils.isEmpty(userId)){
            throw new RuntimeException("请先登录");
        }
        String orderNo = orderService.createOrder(id, userId);
        return CommonResult.ok().data("orderNo",orderNo);
    }

    @GetMapping("/order/{orderNo}")
    @ApiOperation("根据订单Id查询订单信息")
    public CommonResult getOrderInfo(@PathVariable String orderNo){
        Order orderByOrderId = orderService.getOrderByOrderId(orderNo);
        return CommonResult.ok().data("item",orderByOrderId);
    }

}
