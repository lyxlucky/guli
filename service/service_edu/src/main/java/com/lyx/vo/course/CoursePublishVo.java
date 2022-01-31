package com.lyx.vo.course;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liao 2021/10/15
 */
@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private BigDecimal price;
    private Integer lessonNum;
    private String description;
    private String name;
    private String oneSubject;
    private String twoSubject;
}
