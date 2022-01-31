package com.lyx.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author liao 2021/10/19
 */
@Data
public class Banner {
    private String id;
    private String title;
    private String imageUrl;
    private String linkUrl;
    private Integer sort;
    private Integer isDeleted;
    private Date gmtCreate;
    private Date gmtModified;
}
