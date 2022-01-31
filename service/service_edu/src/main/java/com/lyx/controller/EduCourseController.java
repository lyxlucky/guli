package com.lyx.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyx.dto.CourseDto;
import com.lyx.dto.CourseListDto;
import com.lyx.entity.CommonResult;
import com.lyx.entity.EduCourse;
import com.lyx.service.EduCourseService;
import com.lyx.vo.chapter.CourseBackVo;
import com.lyx.vo.course.CoursePublishVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liao 2021/10/12
 */
@RestController
@RequestMapping("/eduservice")
@Api("课程管理")
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    @PostMapping("/course")
    @ApiOperation("添加课程")
    public CommonResult addCourse(CourseDto courseDto){
        CommonResult commonResult = courseService.addCourse(courseDto);
        return commonResult;
    }

    @GetMapping("/course/{id}")
    @ApiOperation("回显课程")
    public CommonResult getById(@PathVariable("id") String id){
        CourseBackVo course = courseService.getById(id);
        return CommonResult.ok().data("list",course);
    }

    @PutMapping("/course")
    @ApiOperation("修改课程信息")
    public CommonResult updateCourse(@RequestBody CourseDto courseDto){
        Integer integer = courseService.updateCourseById(courseDto);
        return integer!=0?CommonResult.ok():CommonResult.error();
    }

    @GetMapping("/course")
    @ApiOperation("最终发布回显格式化数据")
    public CommonResult publish(String id){
        CoursePublishVo coursePublishVo = courseService.publishById(id);
        return CommonResult.ok().data("item",coursePublishVo);
    }

    @PutMapping("/course/{id}")
    @ApiOperation("课程最终发布 Draft 未发布,Normal 发布")
    public CommonResult publishCourse(@PathVariable String id){
        Integer integer = courseService.publishCourse(id);
        return integer!=0?CommonResult.ok():CommonResult.error();
    }

    @GetMapping("/course/{current}/{pageSize}")
    @ApiOperation("查询课程带分页和模糊查询")
    public CommonResult findCourseWithAddition(@PathVariable Integer current,
                                               @PathVariable Integer pageSize,
                                               CourseListDto courseDto){
        Page<?> page = PageHelper.startPage(current,pageSize);
        List<EduCourse> courses = courseService.getAllCourseByPage(courseDto);
        return CommonResult.ok().data("total",page.getTotal()).data("items",courses);
    }

    @DeleteMapping("/course/{id}")
    @ApiOperation("删除课程")
    public CommonResult deleteCourseById(@PathVariable String id){
        Integer integer = courseService.deleteCourseById(id);
        return integer!=0?CommonResult.ok():CommonResult.error();
    }

}
