package com.lyx.client;

import com.lyx.entity.CommonResult;
import feign.Headers;
import feign.RequestLine;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liao 2021/10/18
 */
@Component
@FeignClient(name = "service-vod",fallback = ClientFallBack.class)
public interface VodClient {

    @DeleteMapping("/eduvod/video/{id}")
    public CommonResult deleteVideo(@PathVariable("id") String id);

    @DeleteMapping("/eduvod/test")
    public String test();

}
