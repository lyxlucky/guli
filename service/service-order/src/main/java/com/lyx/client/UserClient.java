package com.lyx.client;

import com.lyx.entity.UcenterMemberOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liao 2021/10/30
 */
@FeignClient(name = "service-ucenter")
@Component
public interface UserClient {
    @GetMapping("/educenter/getUserOrderInfo/{id}")
    public UcenterMemberOrder getOrderInfo(@PathVariable String id);
}
