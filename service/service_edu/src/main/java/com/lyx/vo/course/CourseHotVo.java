package com.lyx.vo.course;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liao 2021/10/19
 */
@Data
public class CourseHotVo {
    @ApiModelProperty("课程Id")
    private String id;
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
    @ApiModelProperty("评论数")
    private Integer commentCount;
}
