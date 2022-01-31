package com.lyx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyx.dto.TeacherDto;
import com.lyx.entity.EduTeacher;
import com.lyx.dao.EduTeacherDao;
import com.lyx.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author lyx
 * @since 2021-10-09
 */
@Service
public class EduTeacherServiceImpl implements EduTeacherService {

    @Autowired
    private EduTeacherDao teacherDao;

    @Override
    public List<EduTeacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public Integer deleteByLogic(String id) {
        return teacherDao.deleteByLogic(id);
    }

    @Override
    public Integer addTeacher(EduTeacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    @Override
    public List<EduTeacher> findByPage(TeacherDto teacherDto) {
        return teacherDao.findByPage(teacherDto);
    }

    @Override
    public Integer updateTeacher(String id,EduTeacher teacher) {
        return teacherDao.updateTeacher(id,teacher);
    }

    @Override
    public EduTeacher getById(String id) {
        return teacherDao.getById(id);
    }

    @Override
    public List<EduTeacher> getHotTeacher() {
        return teacherDao.getHotTeacher();
    }

    @Override
    public List<EduTeacher>  getFrontTeachers() {
        return teacherDao.getFrontTeacher();
    }

    @Override
    public EduTeacher getTeacherInfoById(String id) {
        return teacherDao.getTeacherInfoById(id);
    }
}
