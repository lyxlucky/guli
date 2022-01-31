package com.lyx.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author liao 2021/10/11
 */
@Data
public class SubjectData {

    @ExcelProperty(index = 0)
    private String firstSubject;

    @ExcelProperty(index = 1)
    private String secondSubject;

}
