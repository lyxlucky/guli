package com.lyx.service.impl;

import com.lyx.dao.MemberDao;
import com.lyx.entity.CommonResult;
import com.lyx.entity.Member;
import com.lyx.service.MemberService;
import com.lyx.utils.JwtUtils;
import com.lyx.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @author liao 2021/10/20
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public CommonResult login(String email, String password) {
        Member member = memberDao.login(email, MD5.encrypt(password));
        if(member!=null){
            HashMap<String, String> map = new HashMap<>();
            map.put("id",member.getId());
            map.put("nickname",member.getNickname());
            String token = JwtUtils.getToken(map);
            return CommonResult.ok().data("token",token);
        }
        return CommonResult.error().message("不存在该用户");
    }

    @Override
    public CommonResult register(Member member) {
        Integer repeat = memberDao.findMobileRepeat(member.getEmail());
        if(repeat >0){
            return CommonResult.error().message("邮箱已存在");
        }
        member.setAvatar("https://edu-longyang.oss-cn-beijing.aliyuncs.com/fa104ef58c4e5bc4270d911da1d1b34d.jpg");
        Integer register = memberDao.register(member);
        return register!=0?CommonResult.ok():CommonResult.error();
    }

    @Override
    public Member getById(String id) {
        return memberDao.getById(id);
    }

    @Override
    public Member getOpenId(String openId) {
        return memberDao.getOpenId(openId);
    }

    @Override
    public Integer addUser(Member member) {
        return memberDao.addUser(member);
    }
}
