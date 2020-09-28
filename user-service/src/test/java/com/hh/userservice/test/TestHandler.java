package com.hh.userservice.test;

import org.junit.Test;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class TestHandler {




    @Test
    public void testHandler() {
        Handler handler = new Handler() {
            @Override
            public void publish(LogRecord record) {
                Level level = record.getLevel();
                String message = record.getMessage();
                String loggerName = record.getLoggerName();
                System.out.println("查看消息等级：" + level + ",内容：" + message + ",日志名称：" + loggerName);
            }

            @Override
            public void flush() {
                System.out.println("flush");
            }

            @Override
            public void close() throws SecurityException {
                System.out.println("消息发送完毕close");
            }
        };
        LogRecord logRecord = new LogRecord(Level.INFO, "发送消息");
        logRecord.setLoggerName("记录用户操作数据");
        handler.publish(logRecord);
        handler.flush();
        handler.close();
    }




}
