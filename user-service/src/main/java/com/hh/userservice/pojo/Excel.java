package com.hh.userservice.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Excel {
    @ExcelProperty("ID")
    @ColumnWidth(33)
    private String id;
    @ExcelProperty("用户名")
    private String name;
    @ExcelProperty("状态")
    private String state;
    @ExcelProperty("手机号码")
    @ColumnWidth(15)
    private String phone;
}
