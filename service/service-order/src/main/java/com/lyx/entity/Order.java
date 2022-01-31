package com.lyx.entity;

import com.lyx.utils.snowFlakeUtils;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liao 2021/10/30
 */
@Data
public class Order {

    private String id = snowFlakeUtils.getSnow().toString();

    private String orderNo;

    private String courseId;

    private String courseTitle;

    private String courseCover;

    private String teacherName;

    private String memberId;

    private String nickname;

    private String email;

    private BigDecimal totalFee;

    private Integer payType;

    private Integer status;

    private Integer isDeleted;

    private Date gmtCreate;

    private Date gmtModified;

}
