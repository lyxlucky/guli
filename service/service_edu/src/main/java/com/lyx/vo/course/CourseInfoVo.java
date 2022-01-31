package com.lyx.vo.course;

import com.lyx.vo.subject.FirstSubjectVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liao 2021/10/23
 */
@Data
public class CourseInfoVo {
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
