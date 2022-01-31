package com.lyx.service;

import com.lyx.entity.CommonResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author liao 2021/10/18
 */
public interface VodService {

    /**
     * 上传视屏接口
     * @param file
     * @return
     */
    String uploadVideo(MultipartFile file);

    /**
     * 根据视屏id删除云端视屏
     * @param id
     * @return
     */
    CommonResult deleteVideo(String id);

}
