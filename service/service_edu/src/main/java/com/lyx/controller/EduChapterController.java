package com.lyx.controller;

import com.lyx.entity.CommonResult;
import com.lyx.entity.EduChapter;
import com.lyx.service.EduChapterService;
import com.lyx.vo.chapter.ChapterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liao 2021/10/12
 */
@RestController
@Api("章节管理")
@RequestMapping("/eduservice")
public class EduChapterController {

    @Autowired
    private EduChapterService chapterService;

    @GetMapping("/chapter")
    @ApiOperation("根据课程Id查询所有的章节")
    public CommonResult getAllChapter(String id){
        List<ChapterVo> chapters = chapterService.getFirstChapterAndSecondChapter(id);
        return CommonResult.ok().data("list",chapters);
    }

    @PostMapping("/chapter")
    @ApiOperation("添加章节")
    public CommonResult addChapter(EduChapter chapter){
        Integer integer = chapterService.addChapter(chapter);
        return integer!=0?CommonResult.ok():CommonResult.error();
    }

    @GetMapping("/chapter/{id}")
    @ApiOperation("根据章节Id回显")
    public CommonResult getChapterById(@PathVariable String id){
        EduChapter chapter = chapterService.getChapterById(id);
        return CommonResult.ok().data("item",chapter);
    }

    @PutMapping("/chapter")
    @ApiOperation("修改章节")
    public CommonResult updateChapter(EduChapter eduChapter){
        Integer integer = chapterService.updateChapter(eduChapter);
        return integer!=0?CommonResult.ok():CommonResult.error();
    }

    @DeleteMapping("/chapter/{id}")
    @ApiOperation("根据Id删除章节")
    public CommonResult deleteById(@PathVariable String id){
        return chapterService.deleteById(id);
    }

}
