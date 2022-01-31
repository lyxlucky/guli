package com.lyx.dao;

import com.lyx.entity.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liao 2021/10/19
 */
@Repository
public interface CrmBannerDao {

    /**
     * 分页查询所有的轮播图
     * @return
     */
    public List<Banner> findAllByPage();

    /**
     * 添加轮播图
     * @param banner
     * @return
     */
    public Integer addBanner(Banner banner);

    /**
     * 根据id修改轮播图
     * @param banner
     * @return
     */
    public Integer updateBanner(Banner banner);

    /**
     * 根据id删除轮播图
     * @param id
     * @return
     */
    public Integer deleteBanner(String id);

    /**
     * 根据id回显
     * 为修改做准备
     * @param id
     * @return
     */
    public Banner findById(String id);

    /**
     * 查询所有轮播图
     * @return
     */
    public List<Banner> getAll();

}
