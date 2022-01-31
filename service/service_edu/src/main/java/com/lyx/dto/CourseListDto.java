package com.lyx.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author liao 2021/10/15
 */
@Data
public class CourseListDto {
    private String title;
    private String status;
    private String begin;
    private String end;
}
