package com.lyx.controller;

import com.lyx.dto.LoginDto;
import com.lyx.entity.CommonResult;
import com.lyx.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author liao 2021/10/10
 */
@RestController
@RequestMapping("/eduservice/")
public class EduLoginController {

    @GetMapping("/user")
    public CommonResult info(){
        return CommonResult.ok().data("roles","[admin]").data("name","admin").data("avatar","https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/10/30/de47ee9b-7fec-43c5-8173-13c5f7f689b2.png");
    }

}
