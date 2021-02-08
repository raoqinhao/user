package com.hh.userservice.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Test8Time {


    @Test
    public void testChronoUnitAndLocalDateTime() {

        String beforeString = "2020-02-07 13:52:49";
        ZonedDateTime beforeDateTime = LocalDateTime.parse(beforeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(beforeDateTime.toString());
        String afterString = "2020-02-07 15:36:29";
        ZonedDateTime afterDateTime = LocalDateTime.parse(afterString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(afterDateTime.toString());
        long hours = ChronoUnit.HOURS.between(beforeDateTime, afterDateTime);
        System.out.println(hours);
        System.out.println("---------------");
        ChronoZonedDateTime<?> from = ChronoZonedDateTime.from(beforeDateTime);
        System.out.println(from);

    }



    @Test
    public void testChronoUnitLocalDate(){
        LocalDate now = LocalDate.now();
        LocalDate afterNow = LocalDate.of(2021, 02, 07);
        afterNow.plusDays(1);
//        LocalDateTime now = LocalDateTime.of(2021, 02, 07, 11, 10, 5);
//        LocalDateTime afterNow = LocalDateTime.of(2021, 02, 07, 13, 50, 55);
        long dayLong = ChronoUnit.DAYS.between(now, afterNow);
        System.out.println(dayLong);
        long hoursLong = ChronoUnit.HOURS.between(now, afterNow);
        System.out.println(hoursLong);
    }



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
