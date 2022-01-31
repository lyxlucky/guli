package com.lyx.entity;

import com.lyx.utils.snowFlakeUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liao 2021/10/12
 */
@Data
public class EduChapter implements Serializable {
    @ApiModelProperty("章节Id")
    private String id = snowFlakeUtils.getSnow()+"";
    @ApiModelProperty("课程Id")
    private String courseId;
    @ApiModelProperty("章节名称")
    private String title;
    @ApiModelProperty("显示排序")
    private Integer sort;
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    @ApiModelProperty("修改时间")
    private Date gmtModified;
}
