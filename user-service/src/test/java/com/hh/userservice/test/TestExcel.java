package com.hh.userservice.test;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.hh.userservice.handle.CostomWriteHandler;
import com.hh.userservice.listen.CustomAnalysisEventListener;
import com.hh.userservice.listen.ObjectAnalysisEventListener;
import com.hh.userservice.pojo.Excel;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    @Test
    public void testExportExcelData() {
        List<TestExportVO> arrayList1 = new ArrayList<>();
        List<TestExportVO> arrayList2 = new ArrayList<>();
        arrayList1.add(new TestExportVO("1","zhangsan","17879303721"));
        arrayList1.add(new TestExportVO("2","lisi","17879303721"));
        arrayList2.add(new TestExportVO("3","wangwu","17879303721"));
        ExcelWriter exportVO = EasyExcel.write("ExportVO.xlsx").build();
        WriteSheet sheet1 = EasyExcel.writerSheet(0, "1").head(TestExportVO.class).build();
        exportVO.write(arrayList1,sheet1);
        WriteSheet sheet2 = EasyExcel.writerSheet(1, "2").head(TestExportVO.class).build();
        exportVO.write(arrayList2,sheet2);
        exportVO.finish();
    }

    @Test
    public void testImportExcelData() {
        ExcelReader excelReader = EasyExcel.read("ExportVO.xlsx").build();
        List<TestExportVO> list = EasyExcel.read("ExportVO.xlsx").head(TestExportVO.class).sheet(0).doReadSync();

        ReadSheet readSheet1 = EasyExcel.readSheet(0, "1").registerReadListener(new ObjectAnalysisEventListener()).build();
        ReadSheet readSheet2 = EasyExcel.readSheet(0, "2").registerReadListener(new ObjectAnalysisEventListener()).build();
        excelReader.read(readSheet1,readSheet2);
        excelReader.finish();
    }




    @Test
    public void exportExcelData() {

        List<List<String>> outDataList = new ArrayList<>();
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("zhangsan");
        dataList.add("17879303721");
        outDataList.add(dataList);



        ExcelWriter excelWriter = EasyExcel.write("测试多Sheet工作溥.xlsx").build();
        WriteSheet writeSheet = EasyExcel.writerSheet(0,"0").head(getHead()).build();
        excelWriter.write(outDataList,writeSheet);
        WriteSheet writeSheet1 = EasyExcel.writerSheet(1, "1").head(getHead()).build();
        excelWriter.write(outDataList,writeSheet1);
        excelWriter.finish();
    }


    @Test
    public void testReadMultiWork() {

        List<LinkedHashMap> string = EasyExcel.read("测试多Sheet工作溥.xlsx").sheet(0).head(getHead()).doReadSync();
        for (int i = 0; i < string.size(); i++) {
            LinkedHashMap linkedHashMap = string.get(i);
            System.out.println(linkedHashMap);
        }
        ExcelReader excelReader = EasyExcel.read("测试多Sheet工作溥.xlsx").build();
        ReadSheet readSheet = EasyExcel.readSheet(0).head(getHead()).registerReadListener(new CustomAnalysisEventListener()).build();
        ReadSheet readSheet1 = EasyExcel.readSheet(1).head(getHead()).registerReadListener(new CustomAnalysisEventListener()).build();
        ExcelReader read = excelReader.read(readSheet,readSheet1);
        read.finish();
    }


    public static List<List<String>> getHead() {
        List<List<String>> arrayList = new ArrayList<>();
        List<String> names1 = new ArrayList<>();
        List<String> names2 = new ArrayList<>();
        List<String> names3 = new ArrayList<>();
        names1.add("id");
        names2.add("name");
        names3.add("phone");
        arrayList.add(names1);
        arrayList.add(names2);
        arrayList.add(names3);
        return arrayList;
    }


    @Test
    public void testHeadInCollection() throws Exception{
        // 只用使用xls后缀的文件，不支持xlsx文件。。。。execlpoi
        String filePath = "E:\\workspace\\user\\user-service\\测试EasyExcel文件输出一条记录多个子数据数据.xls";
        List<TestExcelHeadCollection> dataList = new ArrayList<>();
        TestExcelHeadCollection testExcelHeadCollection = new TestExcelHeadCollection();
        testExcelHeadCollection.setAge("10");
        testExcelHeadCollection.setId("123");
        testExcelHeadCollection.setName("张三");

        List<TestExcelHeadCollectionData> arrayList = new ArrayList<>();
        TestExcelHeadCollectionData testExcelHeadCollectionData = new TestExcelHeadCollectionData();
        testExcelHeadCollectionData.setId("1_1");
        testExcelHeadCollectionData.setColor("黑色");
        testExcelHeadCollectionData.setLikeName("打篮球");
        TestExcelHeadCollectionData testExcelHeadCollectionData1 = new TestExcelHeadCollectionData();
        testExcelHeadCollectionData1.setId("1_2");
        testExcelHeadCollectionData1.setColor("白色");
        testExcelHeadCollectionData1.setLikeName("打篮球");
        arrayList.add(testExcelHeadCollectionData);
        arrayList.add(testExcelHeadCollectionData1);

        testExcelHeadCollection.setLike(arrayList);
        // 有表头
        dataList.add(testExcelHeadCollection);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                TestExcelHeadCollection.class, dataList);
        // 没有表头的概念
        Workbook workbook1 = ExcelExportUtil.exportExcel(new ExportParams(),
                TestExcelHeadCollection.class, dataList);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
    }


}
