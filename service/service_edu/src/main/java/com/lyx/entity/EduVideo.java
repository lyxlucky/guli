package com.lyx.entity;

import com.lyx.utils.snowFlakeUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author liao 2021/10/12
 */
@Data
public class EduVideo {

    @ApiModelProperty("视频Id")
    private String id = snowFlakeUtils.getSnow()+"";
    @ApiModelProperty("课程Id")
    private String courseId;
    @ApiModelProperty("章节Id")
    private String chapterId;
    @ApiModelProperty("节点名称")
    private String title;
    @ApiModelProperty("云端视频资源")
    private String videoSourceId;
    @ApiModelProperty("原始文件名称")
    private String videoOriginalName;
    @ApiModelProperty("排序")
    private Integer sort;
    @ApiModelProperty("播放次数")
    private Long playCount;
    @ApiModelProperty("是否可以试听 0收费 1免费")
    private Integer isFree;
    @ApiModelProperty("视频时长")
    private float duration;
    @ApiModelProperty("Empty未上传 Transcoding转码中  Normal正常")
    private String status;
    @ApiModelProperty("视频源文件大小（字节）")
    private Integer size;
    @ApiModelProperty("乐观锁")
    private Integer version;
    @ApiModelProperty("创建时间")
    private Date gmtCreate;
    @ApiModelProperty("修改时间")
    private Date gmtModified;
}
