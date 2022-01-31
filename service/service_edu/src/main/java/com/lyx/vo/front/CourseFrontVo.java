package com.lyx.vo.front;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liao 2021/10/23
 */
@Data
public class CourseFrontVo {

    @ApiModelProperty(value = "课程名称")
    private String title;

    @ApiModelProperty(value = "讲师id")
    private String teacherId;

    @ApiModelProperty(value = "一级类别id")
    private String subjectParentId;

    @ApiModelProperty(value = "二级类别id")
    private String subjectId;

    @ApiModelProperty(value = "销量排序")
    private String buyCount;

    @ApiModelProperty(value = "最新时间排序")
    private String gmtCreate;

    @ApiModelProperty(value = "价格排序")
    private String price;

}
