package com.lyx.entity;

import com.lyx.utils.snowFlakeUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author liao 2021/10/12
 */
@Data
public class EduCourseDescription {
    @ApiModelProperty("课程Id")
    private String id = snowFlakeUtils.getSnow()+"";
    @ApiModelProperty("课程简介")
    private String description;
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    @ApiModelProperty("修改时间")
    private Date gmtModified;
}
