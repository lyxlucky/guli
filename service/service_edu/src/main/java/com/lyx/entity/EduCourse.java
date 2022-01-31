package com.lyx.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author liao 2021/10/12
 */
@Data
public class EduCourse {
    @ApiModelProperty("课程Id")
    private String id;
    @ApiModelProperty("讲师Id")
    private String teacherId;
    @ApiModelProperty("二级分类Id")
    private String subjectId;
    @ApiModelProperty("一级分类Id")
    private String subjectParentId;
    @ApiModelProperty("课程标题")
    private String title;
    @ApiModelProperty("课程价格")
    private BigDecimal price;
    @ApiModelProperty("总课时")
    private Integer lessonNum;
    @ApiModelProperty("课程封面图片路径")
    private String cover;
    @ApiModelProperty("销售数量")
    private Integer buyCount;
    @ApiModelProperty("浏览数量")
    private Integer viewCount;
    @ApiModelProperty("乐观锁")
    private Integer version;
    @ApiModelProperty("课程状态 draft未发布 Normal发布")
    private String status;
    @ApiModelProperty("逻辑删除 1（true）已删除 0（false）未删除 ")
    private Integer isDeleted;
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    @ApiModelProperty("修改时间")
    private Date gmtModified;
}
