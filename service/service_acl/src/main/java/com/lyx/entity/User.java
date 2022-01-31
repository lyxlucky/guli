package com.lyx.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author liao 2021/10/27
 */
@Data
public class User {

    @ApiModelProperty("用户Id")
    private String id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户名称")
    private String nickname;

    @ApiModelProperty("盐")
    private String salt;

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("逻辑删除")
    private Integer isDeleted;

    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    @ApiModelProperty("更新时间")
    private Date gmtModified;

}
