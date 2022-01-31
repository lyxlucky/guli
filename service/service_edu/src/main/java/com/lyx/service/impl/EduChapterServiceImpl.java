package com.lyx.service.impl;

import com.lyx.dao.EduChapterDao;
import com.lyx.entity.CommonResult;
import com.lyx.entity.EduChapter;
import com.lyx.entity.EduVideo;
import com.lyx.service.EduChapterService;
import com.lyx.service.EduVideoService;
import com.lyx.vo.chapter.ChapterVo;
import com.lyx.vo.chapter.VideoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liao 2021/10/12
 */
@Service
public class EduChapterServiceImpl implements EduChapterService {

    @Autowired
    private EduChapterDao eduChapterDao;

    @Autowired
    private EduVideoService videoService;

    @Override
    public List<ChapterVo> getFirstChapterAndSecondChapter(String id) {
        List<EduChapter> chapters = eduChapterDao.getChaptersByCourseId(id);
        ArrayList<ChapterVo> chapterList = new ArrayList<>();
        chapters.forEach(k -> {
            ChapterVo chapterVo = new ChapterVo();
            List<EduVideo> videos = videoService.getChapterVideo(k.getId());
            BeanUtils.copyProperties(k,chapterVo);
            chapterList.add(chapterVo);
            ArrayList<VideoVo> videoList = new ArrayList<>();
            videos.forEach(v->{
                VideoVo videoVo = new VideoVo();
                videoVo.setId(v.getId());
                videoVo.setTitle(v.getTitle());
                videoVo.setVideoSourceId(v.getVideoSourceId());
                videoList.add(videoVo);
            });
            chapterVo.setChildren(videoList);
        });
        return chapterList;
    }

    @Override
    public Integer addChapter(EduChapter eduChapter) {
        return eduChapterDao.addChapter(eduChapter);
    }

    @Override
    public EduChapter getChapterById(String id) {
        return eduChapterDao.getChapterById(id);
    }

    @Override
    public Integer updateChapter(EduChapter chapter) {
        return eduChapterDao.updateChapter(chapter);
    }

    @Override
    public CommonResult deleteById(String id) {
        List<EduVideo> videos = videoService.getChapterById(id);
        if(videos.isEmpty()){
            Integer integer = eduChapterDao.deleteById(id);
            return integer==0?CommonResult.error():CommonResult.ok();
        }
        return CommonResult.error().message("章节下面还有小节");
    }
}
