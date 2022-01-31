package com.lyx.controller;

import com.lyx.client.VodClient;
import com.lyx.entity.CommonResult;
import com.lyx.entity.EduVideo;
import com.lyx.service.EduVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author liao 2021/10/12
 */
@RestController
@Api("小节管理")
@RequestMapping("/eduservice")
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;

    @Autowired
    private VodClient client;

    /**
     * TODO 方法未完成，后续更新 需要根据小节Id删除视频
     * @param id
     * @return
     */
    @DeleteMapping("/video/{id}")
    @ApiOperation("根据小节Id删除小节")
    public CommonResult deleteVideo(@PathVariable String id){
        //先查询小节id才能删除视频
        EduVideo videoId = eduVideoService.getVideoSourceIdByVideoId(id);
        if (!StringUtils.isEmpty(videoId.getVideoSourceId())) {
            client.deleteVideo(videoId.getVideoSourceId());
        }
        Integer integer = eduVideoService.deleteVideo(id);
        return integer!=0?CommonResult.ok():CommonResult.error();
    }

    @PutMapping("/video")
    @ApiOperation("根据小节Id更新小节内容")
    public CommonResult updateVideo(EduVideo eduVideo){
        Integer integer = eduVideoService.updateVideo(eduVideo);
        return integer!=0?CommonResult.ok():CommonResult.error();
    }


    @GetMapping("/video/{id}")
    @ApiOperation("根据小节Id回显小节")
    public CommonResult getVideoById(@PathVariable String id){
        EduVideo video = eduVideoService.getVideoById(id);
        return CommonResult.ok().data("item",video);
    }

    @PostMapping("/video")
    @ApiOperation("新增小节")
    public CommonResult addVideo(EduVideo eduVideo){
        Integer integer = eduVideoService.addVideo(eduVideo);
        return integer!=0?CommonResult.ok():CommonResult.error();
    }

}
