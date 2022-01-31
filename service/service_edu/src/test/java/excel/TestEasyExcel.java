package excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liao 2021/10/11
 */
public class TestEasyExcel {

    public static void main(String[] args) {
        //实现Excel写操作
        //设置写入文件夹位置和文件name
        String filePath = "C:\\Users\\liao\\Desktop\\测试.xlsx";
        //EasyExcel.write(filePath, ExcelDemo.class).sheet("学生名称").doWrite(getData());
        EasyExcel.read(filePath,ExcelDemo.class,new ExcelListener()).sheet().doRead();
    }


    private static List<ExcelDemo> getData(){
        ArrayList<ExcelDemo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExcelDemo excelDemo = new ExcelDemo();
            excelDemo.setId(i);
            excelDemo.setName("admin"+i);
            list.add(excelDemo);
        }
        return list;
    }


}
