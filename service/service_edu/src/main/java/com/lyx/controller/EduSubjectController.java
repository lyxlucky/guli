package com.lyx.controller;

import com.lyx.vo.subject.FirstSubjectVo;
import com.lyx.entity.CommonResult;
import com.lyx.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author liao 2021/10/11
 */
@RestController
@RequestMapping("/eduservice")
@Api("分类管理")
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    @PostMapping("/subject")
    @ApiOperation("通过excel批量导入课程")
    public CommonResult upload(MultipartFile file){
        subjectService.saveSubject(file, subjectService);
        return CommonResult.ok();
    }

    /**
     * 返回所有科目，以树形结构
     * @return
     */
    @GetMapping("/subject")
    @ApiOperation("返回所有科目以树形结构")
    public CommonResult getAllSubject(){
        List<FirstSubjectVo> list = subjectService.findAll();
        return CommonResult.ok().data("list",list);
    }


}
