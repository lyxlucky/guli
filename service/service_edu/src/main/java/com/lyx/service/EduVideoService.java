package com.lyx.service;


import com.lyx.entity.EduVideo;

import java.util.List;

/**
 * @author liao 2021/10/12
 */
public interface EduVideoService {

    /**
     * 根据章节Id来查找小节
     * @param id
     * @return
     */
    public List<EduVideo> getChapterById(String id);

    /**
     * 根据章节Id获取所有小节
     * @param id
     * @return
     */
    public List<EduVideo> getChapterVideo(String id);


    /**
     * 根据章节Id来添加小节
     * @param eduVideo
     * @return
     */
    public Integer addVideo(EduVideo eduVideo);

    /**
     * 根据小节Id更新小节
     * @param eduVideo
     * @return
     */
    public Integer updateVideo(EduVideo eduVideo);

    /**
     * 根据小节id删除小节
     * @param id
     * @return
     */
    public Integer deleteVideo(String id);

    /**
     * 根据小节Id回显小节
     * @param id
     * @return
     */
    public EduVideo getVideoById(String id);

    /**
     * 根据小节Id获取视频Id
     * @param id
     * @return
     */
    public EduVideo getVideoSourceIdByVideoId(String id);

}
