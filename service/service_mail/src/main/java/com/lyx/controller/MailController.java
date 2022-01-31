package com.lyx.controller;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdUtil;
import com.lyx.entity.CommonResult;
import com.lyx.service.MailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author liao 2021/10/20
 */
@RestController
@RequestMapping("/edumail")
public class MailController {

    @Autowired
    private MailService mailService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/mail/{mail}")
    @ApiOperation("发送邮件")
    public CommonResult sendMail(@PathVariable String mail){
        boolean email = Validator.isEmail(mail);
        if(email){
          String isEmail = redisTemplate.opsForValue().get(mail);
          if(StringUtils.hasText(isEmail)){
              return CommonResult.ok().message("已经发送验证码");
          }
          try{
              mailService.sendEmail(mail);
              return CommonResult.ok();
          }catch (Exception e){
              e.printStackTrace();
              return CommonResult.error();
          }
        }
        return CommonResult.error().message("请输入正确的邮箱地址");
    }

}
