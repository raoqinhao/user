package com.hh.userservice.test;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestJava8TimeAPI {

    @Test
    public void testZonedTime() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(LocalDateTime.parse("2021-01-29 10:51:25", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime1);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2021-01-29 10:51:25", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("Asia/Shanghai")));
        System.out.println(zonedDateTime2);
    }

}
