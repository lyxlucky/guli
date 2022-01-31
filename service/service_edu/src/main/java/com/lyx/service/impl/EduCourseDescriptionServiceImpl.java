package com.lyx.service.impl;

import com.lyx.dao.EduCourseDescriptionDao;
import com.lyx.service.EduCourseDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liao 2021/10/12
 */
@Service
public class EduCourseDescriptionServiceImpl implements EduCourseDescriptionService {

    @Autowired
    private EduCourseDescriptionDao courseDescriptionDao;


    @Override
    public Integer addCourseDescription(String id, String description) {
        return courseDescriptionDao.addCourseDescription(id, description);
    }

    @Override
    public Integer updateCourseDescription(String id, String description) {
        return courseDescriptionDao.updateCourseDescription(id, description);
    }
}
