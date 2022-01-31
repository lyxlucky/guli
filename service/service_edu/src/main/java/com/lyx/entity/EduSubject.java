package com.lyx.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liao 2021/10/11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduSubject对象", description="课程")
public class EduSubject implements Serializable {

    @ApiModelProperty("课程ID")
    private String id;

    @ApiModelProperty(value = "课程名字")
    private String title;

    @ApiModelProperty(value = "父类ID")
    private String parentId;

    @ApiModelProperty(value = "排序")
    private String sort;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;

}
