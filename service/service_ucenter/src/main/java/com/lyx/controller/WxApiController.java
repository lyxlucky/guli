package com.lyx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.lyx.entity.CommonResult;
import com.lyx.entity.Member;
import com.lyx.service.MemberService;
import com.lyx.utils.HttpClientUtils;
import com.lyx.utils.JwtUtils;
import com.lyx.utils.WxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * @author liao 2021/10/21
 */
@Controller
@RequestMapping("/api/ucenter/wx")
public class WxApiController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/callback")
    public String callBack(String code,String state){
        try {
            String baseAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                    "appid=%s" +
                    "&secret=%s" +
                    "&code=%s" +
                    "&grant_type=authorization_code";

            String accessTokenUrl = String.format(baseAccessTokenUrl,WxUtils.APPID,WxUtils.APPSECRET,code);
            String url = HttpClientUtils.get(accessTokenUrl);
            Gson gson = new Gson();
            HashMap map = gson.fromJson(url, HashMap.class);
            String token = (String) map.get("access_token");
            String openid = (String) map.get("openid");
            Member member = memberService.getOpenId(openid);
            if (member == null){
                String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo"+
                        "?access_token=%s&" +
                        "openid=%s";
                String userInfoUrl = String.format(baseUserInfoUrl, token, openid);
                String s = HttpClientUtils.get(userInfoUrl);
                HashMap hashMap = gson.fromJson(s, HashMap.class);
                String nickname = (String) hashMap.get("nickname");
                String headimgurl = (String) hashMap.get("headimgurl");
                member = new Member();
                member.setAvatar(headimgurl);
                member.setOpenId(openid);
                member.setNickname(nickname);
                memberService.addUser(member);
            }
            HashMap<String, String> stringHashMap = new HashMap<>();
            stringHashMap.put("id", member.getId());
            stringHashMap.put("nickname",member.getNickname());
            String reToken = JwtUtils.getToken(stringHashMap);
            return "redirect:http://localhost:3000?token="+reToken;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("登录失败");
        }

    }


    @GetMapping("/getWxCode")
    public String getWxCode(){
        String url = null;
        try {
            String redirectUrl = URLEncoder.encode(WxUtils.REDIRECTURL, "utf8");
            url = String.format("https://open.weixin.qq.com/connect/qrconnect?" +
                    "appid=%s&redirect_uri=%s&response_type=code" +
                    "&scope=snsapi_login&state=atguigu#wechat_redirect", WxUtils.APPID,redirectUrl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "redirect:"+url;
    }

}
