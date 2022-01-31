package com.lyx.vo.subject;

import lombok.Data;

import java.util.List;

/**
 * @author liao 2021/10/11
 */
@Data
public class FirstSubjectVo {
    private String id;
    private String title;
    private List<SecondSubjectVo> children;

}
