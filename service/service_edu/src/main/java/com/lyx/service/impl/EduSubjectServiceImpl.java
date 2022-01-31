package com.lyx.service.impl;

import com.alibaba.excel.EasyExcel;
import com.lyx.dao.EduSubjectDao;
import com.lyx.vo.subject.FirstSubjectVo;
import com.lyx.entity.EduSubject;
import com.lyx.entity.excel.SubjectData;
import com.lyx.listener.SubjectListener;
import com.lyx.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author liao 2021/10/11
 */
@Service
public class EduSubjectServiceImpl implements EduSubjectService{

    @Autowired
    private EduSubjectDao subjectDao;

    @Override
    public void saveSubject(MultipartFile file,EduSubjectService subjectService) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class,new SubjectListener(subjectService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public EduSubject findFirstSubject(String name) {
        return subjectDao.findFirstSubject(name);
    }

    @Override
    public EduSubject findSecondSubject(String name, String pid) {
        return subjectDao.findSecondSubject(name, pid);
    }

    @Override
    public Integer saveFirstSubject(EduSubject subject) {
        return subjectDao.saveFirstSubject(subject);
    }

    @Override
    public Integer saveSecondSubject(EduSubject subject) {
        return subjectDao.saveSecondSubject(subject);
    }

    @Override
    public List<FirstSubjectVo> findAll() {
        return subjectDao.findAll();
    }
}
