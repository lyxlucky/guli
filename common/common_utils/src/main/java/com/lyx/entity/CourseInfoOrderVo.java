package com.lyx.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liao 2021/10/23
 */
@Data
public class CourseInfoOrderVo {
    private String id;
    private String teacherId;
    private String title;
    private String cover;
    private String avatar;
    private BigDecimal price;
    private String buyCount;
    private String lessonNum;
    private String viewCount;
    private String description;
    private String name;
    private String intro;
}
