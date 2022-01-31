package com.lyx.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liao 2021/10/26
 */
@Data
public class UcenterMemberOrder {

    private String id;

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
