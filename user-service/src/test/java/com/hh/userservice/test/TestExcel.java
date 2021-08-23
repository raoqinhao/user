package com.hh.userservice.test;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.hh.userservice.handle.CostomWriteHandler;
import com.hh.userservice.pojo.Excel;
import lombok.Data;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

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
//
//    @Test
//    public void testExportExcelData() {
//        List<TestExportVO> arrayList1 = new ArrayList<>();
//        List<TestExportVO> arrayList2 = new ArrayList<>();
//        arrayList1.add(new TestExportVO("1","zhangsan","17879303721"));
//        arrayList1.add(new TestExportVO("2","lisi","17879303721"));
//        arrayList2.add(new TestExportVO("3","wangwu","17879303721"));
//        ExcelWriter exportVO = EasyExcel.write("ExportVO.xlsx").build();
//        WriteSheet sheet1 = EasyExcel.writerSheet(0, "1").head(TestExportVO.class).build();
//        exportVO.write(arrayList1,sheet1);
//        WriteSheet sheet2 = EasyExcel.writerSheet(1, "2").head(TestExportVO.class).build();
//        exportVO.write(arrayList2,sheet2);
//        exportVO.finish();
//    }
//
//    @Test
//    public void testImportExcelData() {
//        ExcelReader excelReader = EasyExcel.read("ExportVO.xlsx").build();
//        List<TestExportVO> list = EasyExcel.read("ExportVO.xlsx").head(TestExportVO.class).sheet(0).doReadSync();
//
//        ReadSheet readSheet1 = EasyExcel.readSheet(0, "1").registerReadListener(new ObjectAnalysisEventListener()).build();
//        ReadSheet readSheet2 = EasyExcel.readSheet(0, "2").registerReadListener(new ObjectAnalysisEventListener()).build();
//        excelReader.read(readSheet1,readSheet2);
//        excelReader.finish();
//    }




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


//    @Test
//    public void testReadMultiWork() {
//
//        List<LinkedHashMap> string = EasyExcel.read("测试多Sheet工作溥.xlsx").sheet(0).head(getHead()).doReadSync();
//        for (int i = 0; i < string.size(); i++) {
//            LinkedHashMap linkedHashMap = string.get(i);
//            System.out.println(linkedHashMap);
//        }
//        ExcelReader excelReader = EasyExcel.read("测试多Sheet工作溥.xlsx").build();
//        ReadSheet readSheet = EasyExcel.readSheet(0).head(getHead()).registerReadListener(new CustomAnalysisEventListener()).build();
//        ReadSheet readSheet1 = EasyExcel.readSheet(1).head(getHead()).registerReadListener(new CustomAnalysisEventListener()).build();
//        ExcelReader read = excelReader.read(readSheet,readSheet1);
//        read.finish();
//    }


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

//
//    @Test
//    public void testHeadInCollection() throws Exception{
//        // 只用使用xls后缀的文件，不支持xlsx文件。。。。execlpoi
//        String filePath = "E:\\workspace\\user\\user-service\\测试EasyExcel文件输出一条记录多个子数据数据.xls";
//        List<TestExcelHeadCollection> dataList = new ArrayList<>();
//        TestExcelHeadCollection testExcelHeadCollection = new TestExcelHeadCollection();
//        testExcelHeadCollection.setAge("10");
//        testExcelHeadCollection.setId("123");
//        testExcelHeadCollection.setName("张三");
//
//        List<TestExcelHeadCollectionData> arrayList = new ArrayList<>();
//        TestExcelHeadCollectionData testExcelHeadCollectionData = new TestExcelHeadCollectionData();
//        testExcelHeadCollectionData.setId("1_1");
//        testExcelHeadCollectionData.setColor("黑色");
//        testExcelHeadCollectionData.setLikeName("打篮球");
//        TestExcelHeadCollectionData testExcelHeadCollectionData1 = new TestExcelHeadCollectionData();
//        testExcelHeadCollectionData1.setId("1_2");
//        testExcelHeadCollectionData1.setColor("白色");
//        testExcelHeadCollectionData1.setLikeName("打篮球");
//        arrayList.add(testExcelHeadCollectionData);
//        arrayList.add(testExcelHeadCollectionData1);
//
//        testExcelHeadCollection.setLike(arrayList);
//        // 有表头
//        dataList.add(testExcelHeadCollection);
//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
//                TestExcelHeadCollection.class, dataList);
//        // 没有表头的概念
//        Workbook workbook1 = ExcelExportUtil.exportExcel(new ExportParams(),
//                TestExcelHeadCollection.class, dataList);
//        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
//        workbook.write(fileOutputStream);
//        workbook.close();
//        fileOutputStream.close();
//    }


    @Test
    public void testExportEasyPOIUtil() throws Exception {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setId("1");
        student.setName("张三");
        student.setAge("19");
        student.setAddress("测试地址");
        List<Class> classList = new ArrayList<>();
        Class mathClass = new Class();
        mathClass.setStudentId("1");
        mathClass.setId("1");
        mathClass.setScore("99");
        mathClass.setClassName("数学");
        Class chineseClass = new Class();
        chineseClass.setStudentId("1");
        chineseClass.setId("2");
        chineseClass.setScore("95");
        chineseClass.setClassName("语文");
        classList.add(mathClass);
        classList.add(chineseClass);
        student.setClassList(classList);
        studentList.add(student);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), Student.class, studentList);
        String path = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        File file = new File("D:\\project\\user\\user-service\\" + path);
        if (!file.exists()) {
            file.mkdirs();
        }
        workbook.write(new FileOutputStream("D:\\project\\user\\user-service\\" + path + "\\" + System.currentTimeMillis() + ".xlsx"));
        workbook.close();
    }


    @Test
    public void testImportEasyPOIUtil() {
        ImportParams importParams = new ImportParams();
//        importParams.setTitleRows(1);
//        importParams.setHeadRows(1);
        List<Student> studentList = ExcelImportUtil.importExcel(new File("D:\\project\\user\\user-service\\2021\\06\\03\\1622714896724.xlsx"), Student.class, importParams);
        studentList.forEach(System.out::println);
    }

    @Test
    public void testImportEasyPOIByImportData() {
        ImportParams importParams = new ImportParams();
//        importParams.setTitleRows(1);
        importParams.setHeadRows(2);
        List<ImportData> importDataList = ExcelImportUtil.importExcel(new File("D:\\project\\user\\user-service\\2021\\06\\07\\1623030949140.xlsx"), ImportData.class, importParams);
        importDataList.forEach(System.out::println);
    }

}

@Data
class Student {
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "学生id", height = 20, width = 30, orderNum = "0", needMerge = true, isImportField = "true_st")
    public String id;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "学生姓名", height = 20, width = 30, orderNum = "1", needMerge = true, isImportField = "true_st")
    public String name;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "学生年龄", height = 20, width = 30, orderNum = "2", needMerge = true, isImportField = "true_st")
    public String age;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "学生地址", height = 20, width = 30, orderNum = "3", needMerge = true, isImportField = "true_st")
    public String address;
    @ExcelCollection(id = "", name = "学生分数信息" , orderNum = "4",type = ArrayList.class)
    public List<Class> classList;
}

@Data
class Class {
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "科目id", height = 20, width = 30, isImportField = "true_st")
    public String id;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "学生id", height = 20, width = 30, isImportField = "true_st")
    public String studentId;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "科目名称", height = 20, width = 30, isImportField = "true_st")
    public String className;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "学生分数", height = 20, width = 30, isImportField = "true_st")
    public String score;
}

@Data
class ImportData {

    @cn.afterturn.easypoi.excel.annotation.Excel(name = "学生id")
    public String id;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "学生姓名")
    public String name;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "学生年龄")
    public String age;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "学生地址")
    public String address;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "科目id", groupName = "学生分数信息")
    public String classId;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "学生id", groupName = "学生分数信息")
    public String studentId;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "科目名称", groupName = "学生分数信息")
    public String className;
    @cn.afterturn.easypoi.excel.annotation.Excel(name = "学生分数", groupName = "学生分数信息")
    public String score;


}