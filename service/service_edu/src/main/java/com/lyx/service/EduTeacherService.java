package com.lyx.service;

import com.lyx.dto.TeacherDto;
import com.lyx.entity.EduTeacher;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author lyx
 * @since 2021-10-09
 */
public interface EduTeacherService{

    /**
     * 查询所有讲师
     * @return
     */
    public List<EduTeacher> findAll();

    /**
     * 逻辑删除讲师
     * @param id
     * @return
     */
    public Integer deleteByLogic(String id);

    /**
     * 新增讲师
     * @param teacher
     * @return
     */
    public Integer addTeacher(EduTeacher teacher);

    /**
     * 分页查询
     * @param teacherDto
     * @return
     */
    public List<EduTeacher> findByPage(TeacherDto teacherDto);

    /**
     * 修改讲师
     * @param teacher
     * @param id
     * @return
     */
    public Integer updateTeacher(String id,EduTeacher teacher);

    /**
     * 根据id回显数据
     * @param id
     * @return
     */
    public EduTeacher getById(String id);

    /**
     * 获取人气讲师
     * @return
     */
    public List<EduTeacher> getHotTeacher();

    /**
     * 分页查询讲师返回给前端
     * @return
     */
    List<EduTeacher> getFrontTeachers();

    /**
     * 根据讲师Id查询讲师基本信息
     * @param id
     * @return
     */
    EduTeacher getTeacherInfoById(String id);
}
