package com.lyx.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author liao 2020/12/18
 */
public class JwtUtils {

    /**
     * 签名
     */
    private static final  String SING = "!@#$%120.[]ok";


    /**
     * 生成Token
     * @return
     */
    public static  String getToken(Map<String,String> map){
        Calendar c  = Calendar.getInstance();
        c.add(Calendar.DATE,7);
        /**
         * 创建JWTBuilder
         */
        JWTCreator.Builder builder = JWT.create();
        /**
         * payload
         */
        map.forEach((k,v) ->{
            builder.withClaim(k,v);
        });
        String token = builder.withExpiresAt(c.getTime()).sign(Algorithm.HMAC256(SING));
        return token;
    }


    /**
     * 验证Token合法性
     * @param token
     */
    public static void validateToken(String token){
        //创建验证对象
        DecodedJWT require = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }

    /**
     * 获取Token信息
     * @param token
     * @return
     */
    public static DecodedJWT getTokenInfo(String token){
        DecodedJWT require = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
        return require;
    }
}
