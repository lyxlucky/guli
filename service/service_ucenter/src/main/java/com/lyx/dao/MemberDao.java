package com.lyx.dao;

import com.lyx.entity.Member;
import com.lyx.vo.RegisterVo;
import org.springframework.stereotype.Repository;

/**
 * @author liao 2021/10/20
 */
@Repository
public interface MemberDao {

    /**
     * 用户登录接口
     * @param email
     * @param password
     * @return
     */
    public Member login(String email,String password);

    /**
     * 用户注册接口
     * @param member
     * @return
     */
    public Integer register(Member member);

    /**
     * 判断手机号是否重复
     * @param mobile
     * @return
     */
    public Integer findMobileRepeat(String mobile);

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    public Member getById(String id);

    /**
     * 根据openid查询openid
     * 判断是否重复
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
