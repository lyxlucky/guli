package com.lyx.vo.chapter;

import lombok.Data;

import java.util.List;

/**
 * @author liao 2021/10/12
 */
@Data
public class ChapterVo {

    private String id;

    private String title;

    private List<VideoVo> children;

}
