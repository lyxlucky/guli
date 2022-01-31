package com.lyx.service.impl;

import com.lyx.dao.CrmBannerDao;
import com.lyx.entity.Banner;
import com.lyx.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liao 2021/10/19
 */
@Service
public class CrmBannerServiceImpl implements CrmBannerService {

    @Autowired
    private CrmBannerDao bannerDao;


    @Override
    public List<Banner> findAllByPage() {
        return bannerDao.findAllByPage();
    }

    @Override
    public Integer addBanner(Banner banner) {
        return bannerDao.addBanner(banner);
    }

    @Override
    public Integer updateBanner(Banner banner) {
        return bannerDao.updateBanner(banner);
    }

    @Override
    public Integer deleteBanner(String id) {
        return bannerDao.deleteBanner(id);
    }

    @Override
    public Banner findById(String id) {
        return bannerDao.findById(id);
    }

    @Override
    public List<Banner> getAll() {
        return bannerDao.getAll();
    }
}
