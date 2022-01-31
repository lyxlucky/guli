package com.lyx.controller;

import com.lyx.entity.CommonResult;
import com.lyx.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liao 2021/10/11
 */
@RestController
@RequestMapping("eduoss/file")
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping("/upload")
    public CommonResult upload(MultipartFile file){
        String url = ossService.uploadFileAvatar(file);
        return CommonResult.ok().data("url",url);
    }

}
