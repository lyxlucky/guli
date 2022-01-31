package com.lyx.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyx.entity.Banner;
import com.lyx.entity.CommonResult;
import com.lyx.service.CrmBannerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liao 2021/10/19
 */
@RestController
@RequestMapping("/educms")
public class CrmBannerAdminController {

    @Autowired
    private CrmBannerService bannerService;


    @GetMapping("/banner/{current}/{pageSize}")
    @ApiOperation("分页查询轮播图接口")
    public CommonResult pageBanner(@PathVariable Integer current,@PathVariable Integer pageSize){
        Page<Object> page = PageHelper.startPage(current, pageSize);
        List<Banner> banners = bannerService.findAllByPage();
        return CommonResult.ok().data("list",banners).data("total",page.getTotal());
    }

    @PostMapping("/banner")
    @ApiOperation("添加轮播图")
    public CommonResult addBanner(@RequestBody Banner banner){
        Integer integer = bannerService.addBanner(banner);
        return integer!=null?CommonResult.ok():CommonResult.error();
    }

    @PutMapping("/banner")
    @ApiOperation("根据轮播图Id修改轮播图")
    public CommonResult updateBanner(@RequestBody Banner banner){
        Integer integer = bannerService.updateBanner(banner);
        return integer!=null?CommonResult.ok():CommonResult.error();
    }

    @DeleteMapping("/banner/{id}")
    @ApiOperation("根据轮播图Id删除轮播图")
    public CommonResult deleteById(@PathVariable String id){
        Integer integer = bannerService.deleteBanner(id);
        return integer!=null?CommonResult.ok():CommonResult.error();
    }

    @GetMapping("/banner/{id}")
    @ApiOperation("根据轮播图Id删除轮播图")
    public CommonResult findById(@PathVariable String id){
        Banner banner = bannerService.findById(id);
        return CommonResult.ok().data("item",banner);
    }

}
