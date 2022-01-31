package com.lyx.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.lyx.entity.CommonResult;
import com.lyx.service.VodService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

import static com.lyx.utils.InitVod.initVodClient;

/**
 * @author liao 2021/10/18
 */
@Service
public class VodServiceImpl implements VodService {

    @Value("${aliyun.vod.file.key}")
    private String accessKeyId;

    @Value("${aliyun.vod.file.secret}")
    private String accessKeySecret;


    @Override
    public String uploadVideo(MultipartFile file){
        String fileName = file.getOriginalFilename();
        String title = fileName.substring(0,fileName.lastIndexOf("."));
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        UploadStreamRequest request = new UploadStreamRequest(accessKeyId, accessKeySecret, title, fileName,inputStream);
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadStreamResponse response = uploader.uploadStream(request);
        //请求视频点播服务的请求ID
        System.out.print("RequestId=" + response.getRequestId() + "\n");
        if (response.isSuccess()) {
            return response.getVideoId();
        } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
            System.out.print("VideoId=" + response.getVideoId() + "\n");
            System.out.print("ErrorCode=" + response.getCode() + "\n");
            System.out.print("ErrorMessage=" + response.getMessage() + "\n");
        }
        return null;
    }

    @Override
    public CommonResult deleteVideo(String id) {
        try {
            DefaultAcsClient client = initVodClient(accessKeyId,accessKeySecret);
            DeleteVideoRequest deleteVideoRequest = new DeleteVideoRequest();
            deleteVideoRequest.setVideoIds(id);
            client.getAcsResponse(deleteVideoRequest);
            return CommonResult.ok();
        } catch (ClientException e) {
            e.printStackTrace();
            throw new RuntimeException("删除视频失败");
        }
    }
}
