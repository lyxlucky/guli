package com.lyx.vo.chapter;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liao 2021/10/13
 */
@Data
public class CourseBackVo {

    private String title;

    private BigDecimal price;

    private Integer lessonNum;

    private String cover;

    private String description;

    private String teacherId;

    private String subjectId;

    private String subjectParentId;

    private List<TeacherListBackVo> teacherList;

    private List<SubjectOneBackVo> subjectList;

}
