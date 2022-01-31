package com.lyx.controller.front;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyx.dao.EduCourseDao;
import com.lyx.entity.CommonResult;
import com.lyx.entity.CourseInfoOrderVo;
import com.lyx.entity.EduCourse;
import com.lyx.service.EduCourseService;
import com.lyx.vo.course.CourseHotVo;
import com.lyx.vo.course.CourseInfoVo;
import com.lyx.vo.front.CourseFrontVo;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.COMM_FAILURE;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liao 2021/10/23
 */
@RestController
@RequestMapping("/eduservice")
public class CourseFrontController {

    @Autowired
    private EduCourseService eduCourseService;

    @Autowired
    private EduCourseDao courseDao;


    @GetMapping("/courseFront/{current}/{pageSize}")
    @ApiOperation("获取课程列表")
    public CommonResult getCourse(@PathVariable Integer current,
                                  @PathVariable Integer pageSize,
                                  @RequestBody(required = false) CourseFrontVo courseFrontVo){
        Page<Object> page = PageHelper.startPage(current, pageSize);
        List<CourseHotVo> courseFrontList = eduCourseService.getCourseFrontList(courseFrontVo);
        return CommonResult.ok().data("items",courseFrontList).data("total",page.getTotal());
    }

    @GetMapping("/courseFront/{id}")
    @ApiOperation("/根据课程Id获取课程详情")
    public CommonResult getCourseInfoById(@PathVariable String id){
        return eduCourseService.getCourseInfoById(id);
    }

    @PutMapping("/courseFront/{id}")
    @ApiOperation("/根据课程Id增加课程浏览数，步长为1")
    public CommonResult addCourseViewCount(@PathVariable String id){
        Integer integer = eduCourseService.addCourseViewCount(id);
        return integer!=0?CommonResult.ok():CommonResult.error();
    }

    @PostMapping("/courseFront/{id}")
    @ApiOperation("根据课程id查询")
    public CourseInfoOrderVo getCourseOrderInfoById(@PathVariable String id){
        CourseInfoVo course = courseDao.getCourseInfoById(id);
        CourseInfoOrderVo orderVo = new CourseInfoOrderVo();
        BeanUtils.copyProperties(course,orderVo);
        return orderVo;
    }

}
