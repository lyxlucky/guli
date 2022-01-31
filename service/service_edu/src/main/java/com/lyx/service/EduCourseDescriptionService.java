package com.lyx.service;


/**
 * @author liao 2021/10/12
 */
public interface EduCourseDescriptionService {

    /**
     * 添加课程描述
     * @param id
     * @param description
     * @return
     */
    public Integer addCourseDescription(String id,String description);


    /**
     * 更新课程描述
     * @param id
     * @param description
     * @return
     */
    public Integer updateCourseDescription(String id,String description);

}
