package com.lyx.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.lyx.entity.EduSubject;
import com.lyx.entity.excel.SubjectData;
import com.lyx.service.EduSubjectService;
import com.lyx.utils.snowFlakeUtils;

import java.util.Map;

/**
 * @author liao 2021/10/11
 */
public class SubjectListener extends AnalysisEventListener<SubjectData> {

    private EduSubjectService subjectService;

    public SubjectListener() {
    }

    public SubjectListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invokeHeadMap(Map headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData != null) {
            EduSubject eduSubject = this.existFirstSubject(subjectData.getFirstSubject());
            if (eduSubject == null) {
                eduSubject = new EduSubject();
                eduSubject.setParentId("0");
                eduSubject.setId(snowFlakeUtils.getSnow()+"");
                eduSubject.setTitle(subjectData.getFirstSubject());
                eduSubject.setSort("0");
                subjectService.saveFirstSubject(eduSubject);
            }
            String id = eduSubject.getId();
            EduSubject subject = this.existSecondSubject(subjectData.getSecondSubject(), id);
            if (subject == null) {
                subject = new EduSubject();
                subject.setId(snowFlakeUtils.getSnow()+"");
                subject.setParentId(id);
                subject.setTitle(subjectData.getSecondSubject());
                subject.setSort("0");
                subjectService.saveSecondSubject(subject);
            }
        }
    }

    private EduSubject existFirstSubject(String name){
        return subjectService.findFirstSubject(name);
    }

    private EduSubject existSecondSubject(String name,String id){
        return subjectService.findSecondSubject(name, id);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
