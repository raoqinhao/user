package com.hh.userservice.test;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class TestJava8TimeAPI {

    @Test
    public void testZonedTime() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(LocalDateTime.parse("2021-01-29 10:51:25", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime1);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2021-01-29 10:51:25", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("Asia/Shanghai")));
        System.out.println(zonedDateTime2);
    }

    @Test
    public void getlocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Shanghai"));
        int year = localDateTime.getYear();
        String monthValue = localDateTime.getMonthValue() < 10 ? "0" + localDateTime.getMonthValue() : "" + localDateTime.getMonthValue();
        String dayOfMonth = localDateTime.getDayOfMonth() < 10 ? "0" + localDateTime.getDayOfMonth() : "" + localDateTime.getDayOfMonth();
        System.out.println(year + "-" + monthValue + "-" + dayOfMonth);
    }

    @Test
    public void testLocalAPI() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalTime now1 = LocalTime.now();
        System.out.println(now1);
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);
    }

    @Test
    public void testInstantTime() {
        Instant now = Instant.now();  // Java8中的新时间API,获取当前的时间，没有时区的概念
        System.out.println(now);
        Instant parse = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)); // 没有时区所以需要手动添加时区
        System.out.println(parse);
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Asia/Shanghai"));
        LocalTime localTime = zonedDateTime.toLocalTime();


    }
}
