package com.lyx.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author liao 2021/10/21
 */
@Component
public class WxUtils implements InitializingBean {

    @Value("${appid}")
    private String appid;

    @Value("${appsecret}")
    private String appsecret;

    @Value("${redirecturl}")
    private String redirecturl;

    public static String APPID;

    public static String APPSECRET;

    public static String REDIRECTURL;

    @Override
    public void afterPropertiesSet() throws Exception {
        APPID = appid;
        APPSECRET = appsecret;
        REDIRECTURL = redirecturl;
    }
}
