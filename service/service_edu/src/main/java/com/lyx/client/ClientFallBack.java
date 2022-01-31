package com.lyx.client;

import com.lyx.entity.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author liao 2021/10/19
 */
@Component
public class ClientFallBack implements VodClient {

    @Override
    public CommonResult deleteVideo(String id) {
        return CommonResult.error();
    }

    @Override
    public String test() {
        return "feign Fallback";
    }
}
