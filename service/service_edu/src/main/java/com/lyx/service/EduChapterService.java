package com.lyx.service;


import com.lyx.entity.CommonResult;
import com.lyx.entity.EduChapter;
import com.lyx.vo.chapter.ChapterVo;

import java.util.List;

/**
 * @author liao 2021/10/12
 */
public interface EduChapterService {

    /**
     * 获取一级章节和二级章节
     * @param id
     * @return
     */
    public List<ChapterVo> getFirstChapterAndSecondChapter(String id);

    /**
     * 添加章节
     * @param eduChapter
     * @return
     */
    public Integer addChapter(EduChapter eduChapter);

    /**
     * 根据id回显章节
     * @param id
     * @return
     */
    public EduChapter getChapterById(String id);

    /**
     * 根据Id更新章节信息
     * @param chapter
     * @return
     */
    public Integer updateChapter(EduChapter chapter);

    /**
     * 根据Id删除
     * @param id
     * @return
     */
    public CommonResult deleteById(String id);


}
