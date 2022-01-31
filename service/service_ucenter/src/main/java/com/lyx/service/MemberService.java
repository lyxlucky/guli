package com.lyx.service;

import com.lyx.entity.CommonResult;
import com.lyx.entity.Member;

/**
 * @author liao 2021/10/20
 */
public interface MemberService {

    /**
     * 用户登录接口
     * @param email
     * @param password
     * @return
     */
    public CommonResult login(String email, String password);

    /**
     * 用户注册接口
     * @param member
     * @return
     */
    public CommonResult register(Member member);

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    public Member getById(String id);

    /**
     * 根据openid返回openid
     * 判断openId是否重复
     * @param openId
     * @return
     */
    public Member getOpenId(String openId);

    /**
     * 万用添加用户方法
     * @param member
     * @return
     */
    public Integer addUser(Member member);

}
