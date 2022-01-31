package com.lyx.controller;

import com.lyx.entity.CommonResult;
import com.lyx.entity.User;
import com.lyx.service.UserService;
import com.lyx.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author liao 2021/10/27
 */
@RestController
@RequestMapping("/eduacl")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public CommonResult login(@RequestBody User user){
        if(StringUtils.hasText(user.getUsername())&&StringUtils.hasText(user.getPassword())){
            User userLogin = userService.login(user);
            HashMap<String, String> map = new HashMap<>();
            map.put("id",user.getId());
            String token = JwtUtils.getToken(map);
            return userLogin!=null?CommonResult.ok().data("token",token):CommonResult.error();
        }else{
            return CommonResult.error();
        }
    }

}
