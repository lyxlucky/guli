package com.lyx.controller.front;

import com.lyx.entity.CommonResult;
import com.lyx.entity.EduCourse;
import com.lyx.entity.EduTeacher;
import com.lyx.service.EduCourseService;
import com.lyx.service.EduTeacherService;
import com.lyx.vo.course.CourseHotVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liao 2021/10/19
 */
@RestController
@RequestMapping("/eduservice")
public class IndexFrontController {

    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduTeacherService teacherService;

    /**
     * 查询前8条热门课程和前四人气老师
     * @return
     */
    @GetMapping("/front")
    @ApiOperation("查询热门课程和热门讲师")
    @Cacheable(value = "HotCourseAndTeacher",key = "'getAll'")
    public CommonResult getAll(){
        List<CourseHotVo> hotCourse = courseService.getHotCourse();
        List<EduTeacher> hotTeacher = teacherService.getHotTeacher();
        return CommonResult.ok().data("courses",hotCourse).data("teachers",hotTeacher);
    }
}
