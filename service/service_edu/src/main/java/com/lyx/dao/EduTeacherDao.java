package com.lyx.dao;

import com.lyx.dto.TeacherDto;
import com.lyx.entity.EduTeacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author lyx
 * @since 2021-10-09
 */
@Repository
public interface EduTeacherDao {

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
    public Integer updateTeacher(@Param("id") String id,@Param("teacher") EduTeacher teacher);

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
    List<EduTeacher> getFrontTeacher();

    /**
     * 根据讲师Id查询讲师基本信息
     * @param id
     * @return
     */
    EduTeacher getTeacherInfoById(String id);
}
