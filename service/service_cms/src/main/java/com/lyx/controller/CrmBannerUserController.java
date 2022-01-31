package com.lyx.controller;

import com.lyx.entity.Banner;
import com.lyx.entity.CommonResult;
import com.lyx.service.CrmBannerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liao 2021/10/19
 */
@RestController
@RequestMapping("/educms/front")
public class CrmBannerUserController {


    @Autowired
    private CrmBannerService bannerService;

    @GetMapping("/banner")
    @ApiOperation("获取所有轮播图")
    @Cacheable(key = "'selectIndexList'",value = "banner")
    public CommonResult getAll(){
        List<Banner> all = bannerService.getAll();
        return CommonResult.ok().data("items",all);
    }


}
