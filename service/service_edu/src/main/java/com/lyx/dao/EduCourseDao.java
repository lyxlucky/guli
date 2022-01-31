package com.lyx.dao;

import com.lyx.dto.CourseDto;
import com.lyx.dto.CourseListDto;
import com.lyx.entity.EduCourse;
import com.lyx.vo.chapter.CourseBackVo;
import com.lyx.vo.course.CourseHotVo;
import com.lyx.vo.course.CourseInfoVo;
import com.lyx.vo.course.CoursePublishVo;
import com.lyx.vo.front.CourseFrontVo;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author liao 2021/10/12
 */
@Repository
public interface EduCourseDao {

    /**
     * 添加课程
     * @param courseDto
     * @return
     */
    public Integer addCourse(CourseDto courseDto);

    /**
     * 根据Id回显数据
     * @param id
     * @return
     */
    public CourseBackVo getById(String id);

    /**
     * 更新课程信息
     * @param courseDto
     * @return
     */
    public Integer updateCourse(CourseDto courseDto);

    /**
     * 根据Id回显,最终发布
     * @param id
     * @return
     */
    public CoursePublishVo publishById(String id);

    /**
     * 发布课程
     * @param id
     * @return
     */
    public Integer publishCourse(String id);

    /**
     * 分页带条件查询所有课程
     * @param courseDto
     * @return
     */
    public List<EduCourse> getAllCourseByPage(CourseListDto courseDto);

    /**
     * 根据课程Id删除课程
     * @param id
     * @return
     */
    public Integer deleteCourseById(String id);

    /**
     * 获取热门课程
     * @return
     */
    public List<CourseHotVo> getHotCourse();

    /**
     * 根据讲师Id查询讲师所讲课程
     * @param id
     * @return
     */
    List<EduCourse> findByTeacherId(String id);

    /**
     * 获取所有课程
     * @param courseFrontVo
     * @return
     */
    List<CourseHotVo> getCourseFrontList(CourseFrontVo courseFrontVo);

    /**
     * 根据课程Id查询课程
     * @param id
     * @return
     */
    CourseInfoVo getCourseInfoById(String id);

    /**
     * 增加课程浏览数，步长为1
     * @param id
     * @return
     */
    Integer addCourseViewCount(String id);

}
