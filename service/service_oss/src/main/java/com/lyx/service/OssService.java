package com.lyx.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author liao 2021/10/11
 */
public interface OssService {

    /**
     * 讲师头像上传方法
     * @param file
     * @return
     */
    public String uploadFileAvatar(MultipartFile file);

}
