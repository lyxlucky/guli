package com.lyx.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.lyx.entity.CommonResult;
import com.lyx.entity.Member;
import com.lyx.entity.UcenterMemberOrder;
import com.lyx.service.MemberService;
import com.lyx.utils.JwtUtils;
import com.lyx.vo.RegisterVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


/**
 * @author liao 2021/10/20
 */
@RestController
@RequestMapping("/educenter")
public class UserController {

    @Autowired
    private MemberService memberservice;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @PostMapping("/login")
    @ApiOperation("用户登录接口")
    public CommonResult login(String email,String password){
       return memberservice.login(email, password);
    }

    @PostMapping("/register")
    @ApiOperation("用户注册接口")
    public CommonResult register(@RequestBody RegisterVo registerVo){
        String code = redisTemplate.opsForValue().get(registerVo.getEmail());
        if (code==null){
            return CommonResult.error().message("验证码已过期，请重新获取");
        }
        if (!registerVo.getCode().equals(code)){
            return CommonResult.error().message("验证码错误");
        }
        if(registerVo.getCode().equals(code)){
            Member member = new Member();
            BeanUtils.copyProperties(registerVo,member);
            return memberservice.register(member);
        }
        return CommonResult.error();
    }

    @GetMapping("/getMemberInfo")
    public CommonResult getInfo(@RequestHeader("token") String token){
        DecodedJWT info = JwtUtils.getTokenInfo(token);
        String id = info.getClaim("id").asString();
        Member member = memberservice.getById(id);
        return CommonResult.ok().data("userInfo",member);
    }

    /**
     * 根据用户Id获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/getUserOrderInfo/{id}")
    public UcenterMemberOrder getOrderInfo(@PathVariable String id){
        Member member = memberservice.getById(id);
        UcenterMemberOrder ucenterMemberOrder = new UcenterMemberOrder();
        BeanUtils.copyProperties(member,ucenterMemberOrder);
        return ucenterMemberOrder;
    }


}
