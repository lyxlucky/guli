package com.lyx.service.impl;

import com.lyx.dao.EduCourseDao;
import com.lyx.dao.EduCourseDescriptionDao;
import com.lyx.dto.CourseDto;
import com.lyx.dto.CourseListDto;
import com.lyx.entity.CommonResult;
import com.lyx.entity.EduCourse;
import com.lyx.service.EduChapterService;
import com.lyx.service.EduCourseService;
import com.lyx.utils.snowFlakeUtils;
import com.lyx.vo.chapter.ChapterVo;
import com.lyx.vo.chapter.CourseBackVo;
import com.lyx.vo.course.CourseHotVo;
import com.lyx.vo.course.CourseInfoVo;
import com.lyx.vo.course.CoursePublishVo;
import com.lyx.vo.front.CourseFrontVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liao 2021/10/12
 */
@Service
public class EduCourseServiceImpl implements EduCourseService {

    @Autowired
    private EduCourseDao courseDao;

    @Autowired
    private EduChapterService chapterService;

    @Autowired
    private EduCourseDescriptionDao courseDescriptionDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult addCourse(CourseDto courseDto) {
        Integer cResult = courseDao.addCourse(courseDto);
        String id = courseDto.getId();
        Integer dResult = courseDescriptionDao.addCourseDescription(id, courseDto.getDescription());
        return cResult+dResult!=0?CommonResult.ok().data("id",id):CommonResult.error();
    }

    @Override
    public CourseBackVo getById(String id) {
        return courseDao.getById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateCourseById(CourseDto courseDto) {
        Integer cResult = courseDao.updateCourse(courseDto);
        String id = courseDto.getId();
        Integer dResult = courseDescriptionDao.updateCourseDescription(id, courseDto.getDescription());
        return cResult+dResult;
    }

    @Override
    public CoursePublishVo publishById(String id) {
        return courseDao.publishById(id);
    }

    @Override
    public Integer publishCourse(String id) {
        return courseDao.publishCourse(id);
    }

    @Override
    public List<EduCourse> getAllCourseByPage(CourseListDto courseDto) {
        return courseDao.getAllCourseByPage(courseDto);
    }

    @Override
    public Integer deleteCourseById(String id) {
        return courseDao.deleteCourseById(id);
    }

    @Override
    public List<CourseHotVo> getHotCourse() {
        return courseDao.getHotCourse();
    }

    @Override
    public List<EduCourse> findByTeacherId(String id) {
        return courseDao.findByTeacherId(id);
    }

    @Override
    public List<CourseHotVo> getCourseFrontList(CourseFrontVo courseFrontVo) {
        return courseDao.getCourseFrontList(courseFrontVo);
    }

    @Override
    public CommonResult getCourseInfoById(String id) {
        CourseInfoVo course = courseDao.getCourseInfoById(id);
        List<ChapterVo> chapters = chapterService.getFirstChapterAndSecondChapter(id);
        return CommonResult.ok().data("course",course).data("chapter",chapters);
    }

    @Override
    public Integer addCourseViewCount(String id) {
        return courseDao.addCourseViewCount(id);
    }
}
