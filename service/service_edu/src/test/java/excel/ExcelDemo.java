package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author liao 2021/10/11
 */
@Data
public class ExcelDemo {

    @ExcelProperty("学生编号")
    private Integer id;

    @ExcelProperty("学生姓名")
    private String name;



}
