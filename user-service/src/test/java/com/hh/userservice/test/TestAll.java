package com.hh.userservice.test;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

/**
 * @ClassName TestAll
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/7/27 9:41
 * @Version 1.0
 **/
public class TestAll {

    public static void createStr() {
        String abc = "ABC";
        System.out.println(abc);
    }

    @Test
    public void testIntern() {
        String abc = "ABC";
        String intern = "ABC".intern();
        System.out.println(intern);
    }

    @Test
    public void testSuanFa() {
        int a = 1;
        double x = a == 0 ? 0 : 1 / 2;
        System.out.println(x);

        BigDecimal multiply = new BigDecimal(37777).divide(new BigDecimal(170241),2, RoundingMode.FLOOR).multiply(new BigDecimal(100));
        System.out.println(multiply.toBigInteger().toString());

        BigDecimal multiply1 = new BigDecimal(3).divide(new BigDecimal(4),1, RoundingMode.FLOOR).multiply(new BigDecimal(100));
        System.out.println(multiply1.toBigInteger().toString());

        String str = " 泉州台商投资区东园辉盛鞋服商行";
        System.out.println(str.replaceAll(" ",""));
        System.out.println(str.trim());
        System.out.println(str.replaceAll("\\u00A0",""));
        System.out.println("---------------");
        Calendar calendar = Calendar.getInstance();
        int dayNum = 0;
        int count = 2;
        while (true) {
            calendar.add(Calendar.DAY_OF_MONTH,3 + dayNum);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            String date = year + "-" + month + "-" + day;
            if (count > dayNum) {
                dayNum++;
            } else {
                break;
            }
        }
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String date = year + "-" + month + "-" + day;
        System.out.println(date);
    }

}
