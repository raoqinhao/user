package com.hh.userservice.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test8Time {


    @Test
    public void testZonedDateTimePlus() {
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime = zdt.plusDays(2);
        System.out.println(zdt);
        System.out.println(zonedDateTime);

        ZonedDateTime zonedDateTime1 = zdt.plusDays(-2);
        System.out.println(zonedDateTime1);
    }



    @Test
    public void testZonedDateTime() {
        long start = System.currentTimeMillis();
        ZonedDateTime zdt = ZonedDateTime.parse("2020-11-20 17:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("Asia/Shanghai")));
        String date = zdt.getYear() + "-" + zdt.getMonthValue() + "-" + zdt.getDayOfMonth() + " " + zdt.getHour() + ":" + String.format("%02d",zdt.getMinute()) + ":" + String.format("%02d",zdt.getSecond());
        System.out.println(date);
        System.out.println((System.currentTimeMillis() - start));
    }


    @Test
    public void testSimpleDateFormatter() {
        long start = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);
        System.out.println((System.currentTimeMillis() - start));
    }


}
