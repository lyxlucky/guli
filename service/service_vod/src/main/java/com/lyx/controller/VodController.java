package com.lyx.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.lyx.entity.CommonResult;
import com.lyx.service.VodService;
import com.lyx.utils.InitVod;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liao 2021/10/18
 */
@RestController
@RequestMapping("/eduvod")
public class VodController {

    @Autowired
    private VodService service;

    @Value("${aliyun.vod.file.key}")
    private String accessKeyId;

    @Value("${aliyun.vod.file.secret}")
    private String accessKeySecret;

    @PostMapping("/video")
    @ApiOperation("上传视频接口")
    public CommonResult uploadVideo(MultipartFile file){
        String videoId = service.uploadVideo(file);
        return CommonResult.ok().data("id",videoId);
    }

    @DeleteMapping("/video/{id}")
    @ApiOperation("删除视频接口")
    public CommonResult deleteVideo(@PathVariable String id){
        return service.deleteVideo(id);
    }

    @GetMapping("/video/{id}")
    @ApiOperation("根据视频Id获取视频凭证")
    public CommonResult getKey(@PathVariable String id){
        try {
            DefaultAcsClient client = InitVod.initVodClient(accessKeyId, accessKeySecret);
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            request.setVideoId(id);
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);
            String playAuth = response.getPlayAuth();
            return CommonResult.ok().data("auth",playAuth);
        } catch (ClientException e) {
            e.printStackTrace();
            return CommonResult.error();
        }
    }

}
