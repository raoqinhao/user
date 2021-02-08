package com.hh.userservice.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.hh.userservice.handle.CostomWriteHandler;
import com.hh.userservice.pojo.Excel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestExcel {


    @Test
    public void mergeCellData() {
        String fileName = "测试EasyExcel文件输出数据";
        List<Excel> data = getExcelData();
        WriteSheet sheet = EasyExcel.write(fileName, Excel.class).sheet("DATA").build();


    }


    @Test
    public void exportUserBeanData() {
        String fileName = "测试EasyExcel文件输出数据.xlsx";
        List<Excel> data = getExcelData();
        EasyExcel.write(fileName, Excel.class).sheet("DATA").registerWriteHandler(new CostomWriteHandler()).doWrite(data);
    }

    private static List<Excel> getExcelData() {
        List<Excel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                list.add(new Excel(UUID.randomUUID().toString().replaceAll("-",""),"name"+i,"0","13006257601"));
            else
                list.add(new Excel(UUID.randomUUID().toString().replaceAll("-",""),"name"+i,"1","13006257601"));
        }
        return list;
    }


    @Test
    public void readUserBeanData() {
        String filePath = "E:\\workspace\\user\\user-service\\测试EasyExcel文件输出数据";
        try {
            List<Excel> excels = EasyExcel.read(filePath).head(Excel.class).sheet().doReadSync();
            System.out.println();
            excels.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
