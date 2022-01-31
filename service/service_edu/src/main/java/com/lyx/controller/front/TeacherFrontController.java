package com.lyx.controller.front;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyx.entity.CommonResult;
import com.lyx.entity.EduCourse;
import com.lyx.entity.EduTeacher;
import com.lyx.service.EduCourseService;
import com.lyx.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @author liao 2021/10/22
 */
@RestController
@RequestMapping("/eduservice")
public class TeacherFrontController {

    @Autowired
    private EduTeacherService teacherService;

    @Autowired
    private EduCourseService courseService;

    @GetMapping("/teacherFront/{current}/{pageSize}")
    @ApiOperation("分页查询讲师")
    public CommonResult getTeachByPage(@PathVariable Integer current,@PathVariable Integer pageSize){
        Page<Object> page = PageHelper.startPage(current, pageSize);
        List<EduTeacher> teachers = teacherService.getFrontTeachers();
        return CommonResult.ok()
                .data("items",teachers)
                .data("total",page.getTotal());
    }

    @GetMapping("/teacherFront/{id}")
    @ApiOperation("获取老师详情")
    public CommonResult getTeacherById(@PathVariable String id){
        EduTeacher teacher = teacherService.getTeacherInfoById(id);
        List<EduCourse> courses = courseService.findByTeacherId(id);
        return CommonResult.ok().data("teacher",teacher).data("course",courses);
    }

}
