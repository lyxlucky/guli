package com.lyx.vo.chapter;

import lombok.Data;

import java.util.List;

/**
 * @author liao 2021/10/13
 */
@Data
public class SubjectOneBackVo {
    private String id;
    private String title;
    private List<SubjectTwoBackVo> children;
}
