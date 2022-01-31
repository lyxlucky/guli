package com.lyx.service.impl;

import com.lyx.dao.EduVideoDao;
import com.lyx.entity.EduVideo;
import com.lyx.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liao 2021/10/12
 */
@Service
public class EduVideoServiceImpl implements EduVideoService {

    @Autowired
    private EduVideoDao eduVideoDao;

    @Override
    public List<EduVideo> getChapterById(String id) {
        return eduVideoDao.getChapterById(id);
    }

    @Override
    public List<EduVideo> getChapterVideo(String id) {
        return eduVideoDao.getChapterVideo(id);
    }

    @Override
    public Integer addVideo(EduVideo eduVideo) {
        return eduVideoDao.addVideo(eduVideo);
    }

    @Override
    public Integer updateVideo(EduVideo eduVideo) {
        return eduVideoDao.updateVideo(eduVideo);
    }

    @Override
    public Integer deleteVideo(String id) {
        return eduVideoDao.deleteVideo(id);
    }

    @Override
    public EduVideo getVideoById(String id) {
        return eduVideoDao.getVideoById(id);
    }

    @Override
    public EduVideo getVideoSourceIdByVideoId(String id) {
        return eduVideoDao.getVideoSourceIdByVideoId(id);
    }
}
