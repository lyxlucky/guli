package com.lyx.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyx.dto.TeacherDto;
import com.lyx.entity.CommonResult;
import com.lyx.entity.EduTeacher;
import com.lyx.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.xmlbeans.impl.jam.JComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author lyx
 * @since 2021-10-09
 */
@RestController
@RequestMapping("/eduservice")
@Api("讲师管理")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @GetMapping("/teacher")
    @ApiOperation("查询所有讲师")
    public CommonResult getAll(){
        List<EduTeacher> all = teacherService.findAll();
        return CommonResult.ok().data("items",all);
    }

    @DeleteMapping("/teacher/{id}")
    @ApiOperation("逻辑删除讲师")
    public CommonResult<String,Object> deleteTeacher(@ApiParam(name = "id",value = "讲师Id",required = true) @PathVariable String id){
        Integer result = teacherService.deleteByLogic(id);
        return result!=0?CommonResult.ok():CommonResult.error().message("不存在该用户");
    }


    @PostMapping("/teacher")
    @ApiOperation("新增讲师")
    public CommonResult<String,Object> addTeacher(EduTeacher teacher){
        Integer result = teacherService.addTeacher(teacher);
        return result==0?CommonResult.error():CommonResult.ok();
    }

    @GetMapping("/teacher/{current}/{pageSize}")
    @ApiOperation("分页查询讲师")
    public CommonResult<String,Object> findByPage(@PathVariable Integer current, @PathVariable Integer pageSize, TeacherDto teacherDto){
        Page<Object> page = PageHelper.startPage(current, pageSize);
        List<EduTeacher> teachers = teacherService.findByPage(teacherDto);
        return CommonResult.ok().data("items",teachers).data("total",page.getTotal());
    }

    @PutMapping("/teacher/{id}")
    @ApiOperation("修改讲师")
    public CommonResult<String,Object> updateTeacher(@PathVariable String id,EduTeacher teacher){
        Integer integer = teacherService.updateTeacher(id,teacher);
        return integer!=0?CommonResult.ok():CommonResult.error();
    }

    @GetMapping("/teacher/{id}")
    @ApiOperation("根据id回显")
    public CommonResult getById(@PathVariable String id){
        EduTeacher teacher = teacherService.getById(id);
        return CommonResult.ok().data("items",teacher);
    }
}

