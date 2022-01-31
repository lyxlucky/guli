package excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author liao 2021/10/11
 */
public class ExcelListener extends AnalysisEventListener<ExcelDemo> {
    @Override
    public void invoke(ExcelDemo excelDemo, AnalysisContext analysisContext) {
        String name = excelDemo.getName();
        System.out.println("name = " + name);
    }


    @Override
    public void invokeHeadMap(Map headMap, AnalysisContext context) {
        System.out.println(headMap);
    }

    /**
     * 读取完成后的操作
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
