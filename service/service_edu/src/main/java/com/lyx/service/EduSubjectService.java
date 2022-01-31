package com.lyx.service;

import com.lyx.vo.subject.FirstSubjectVo;
import com.lyx.entity.EduSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author liao 2021/10/11
 */
public interface EduSubjectService {

    /**
     * 从excel读取文件并保存
     * @param file
     * @param subjectService
     */
    public void saveSubject(MultipartFile file,EduSubjectService subjectService);

    /**
     * 判断一级分类不重复添加
     * @param name
     * @return
     */
    public EduSubject findFirstSubject(String name);

    /**
     * 判断二级分类不重复添加
     * @param name
     * @param pid
     * @return
     */
    public EduSubject findSecondSubject(String name,String pid);

    /**
     * 保存一级分类
     * @param subject
     * @return
     */
    public Integer saveFirstSubject(EduSubject subject);

    /**
     * 保存二级分类
     * @param subject
     * @return
     */
    public Integer saveSecondSubject(EduSubject subject);


    /**
     * 获得所有科目以树形结构
     * @return
     */
    public List<FirstSubjectVo> findAll();

}
