package com.lyx.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liao 2021/10/10
 */
@Data
public class TeacherDto {

    @ApiModelProperty("教师名称，模糊查询")
    private String name;

    @ApiModelProperty("教师等级 头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty("查询开始时间")
    private String begin;

    @ApiModelProperty("查询结束时间")
    private String end;

}
