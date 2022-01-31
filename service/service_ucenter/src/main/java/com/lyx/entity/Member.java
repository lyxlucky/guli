package com.lyx.entity;

import com.lyx.utils.snowFlakeUtils;
import lombok.Data;

import java.util.Date;

/**
 * @author liao 2021/10/20
 */
@Data
public class Member {

    private String id = snowFlakeUtils.getSnow()+"";
    private String openId;
    private String email;
    private String password;
    private String nickname;
    private Integer sex;
    private Integer age;
    private String avatar;
    private String sign;
    private Integer isDisabled;
    private Integer isDeleted;
    private Date gmtCreate;
    private Date gmtModified;

}
