package com.hh.userservice.test;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.BetweenFormatter;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.text.StrSplitter;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.core.thread.ConcurrencyTester;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.*;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import org.junit.Test;
import sun.net.ftp.FtpClient;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TestHutool
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/6/29 10:31
 * @Version 1.0
 **/
public class TestHutool {

    @Test
    public void testFtpUtil() throws Exception {
        InetSocketAddress inetSocketAddress = InetSocketAddress.createUnresolved("192.168.10.55", 21);
        FtpClient ftpClient = FtpClient.create(inetSocketAddress);
        char[] chars = {1,2,3,4,5,6};
        FtpClient loginClient = ftpClient.login("admin", chars);
        loginClient.putFile("/usr/local/src/upload",new FileInputStream(new File("D:\\hutoolimgtest\\777.jpg")));
        loginClient.close();
        ftpClient.close();
    }

    @Test
    public void testCronUtil() throws Exception{
        CronUtil.schedule("*/2 * * * * *", new Task() {
            @Override
            public void execute() {
                System.out.println("............");
            }
        });
        CronUtil.setMatchSecond(true);
        CronUtil.start();
    }

    @Test
    public void testRotate() throws Exception{
        Image image = ImgUtil.rotate(ImageIO.read(FileUtil.file("D:\\hutoolimgtest\\777 - 副本 (2).jpg")), 90);
        ImgUtil.write(image, FileUtil.file("D:\\hutoolimgtest\\7777777.jpg"));
    }

    @Test
    public void testScale() {
        ImgUtil.scale(
                FileUtil.file("D:\\hutoolimgtest\\777 - 副本 (2).jpg"),
                FileUtil.file("D:\\hutoolimgtest\\777 - 副本 (3).jpg"),
                0.5f//缩放比例
        );
    }

    @Test
    public void testImgUtilPressText() {
        ImgUtil.pressText(FileUtil.file("D:\\hutoolimgtest\\777.jpg"),FileUtil.file("D:\\hutoolimgtest\\777.jpg"),"版权所有", Color.RED,new Font("黑体", Font.BOLD, 20),-400,-200,0.8f);
    }

    @Test
    public void testImgUtilGray() {
        ImgUtil.gray(FileUtil.file("D:\\images\\777.jpg"),FileUtil.file("D:\\hutoolimgtest\\777.jpg"));
    }

    @Test
    public void testConcurrencyTester() {
        // 并发测试数据
        ConcurrencyTester concurrencyTester = ThreadUtil.concurrencyTest(10, () -> {
            long aLong = RandomUtil.randomLong(10, 100);
            ThreadUtil.sleep(aLong);
            Console.log("{} 执行完成，延迟 {}", Thread.currentThread().getName(), aLong);
        });
        Console.log(concurrencyTester.getInterval());
    }


    @Test
    public void testStrSpliter() {
        String str = "1,3,,3, 6, 9,4";
        List<String> split = StrSplitter.split(str, ',', 0, true, true);
        split.forEach(System.out::println);
    }

    @Test
    public void testUnicodeUtil() throws Exception{
        String china = UnicodeUtil.toUnicode("中国");
        System.out.println(china);
        System.out.println("-----------");
        String str = UnicodeUtil.toString("\\xE6\\xB6\\x88\\xE7\\x81\\xAB\\xE6\\xA0\\x93\\xE4\\xB8\\xBB\\xE7\\xAE\\xA1\\xE7\\xBD\\x91\\xE5\\x8E\\x8B\\xE5\\x8A\\x9B");
        System.out.println(str);
        System.out.println("----------");
        String ch = "中国";
    }

    @Test
    public void testBase64() {
        String str = "hello world";
        String encode = Base64.encode(str);
        System.out.println(encode);
        byte[] decode = Base64.decode(encode);
        String s = new String(decode);
        System.out.println(s);
    }

    @Test
    public void testAssertUtil() {
        try {
            Assert.isNull("zhangsan");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("a111111111111111");
    }

    @Test
    public void testCreditCode() {
        String creditCode = CreditCodeUtil.randomCreditCode();
        System.out.println(creditCode);
        boolean creditCodeState = CreditCodeUtil.isCreditCode(creditCode);
        System.out.println(creditCodeState);
    }

    @Test
    public void testDesensitizedUtil() {
        String phone = DesensitizedUtil.mobilePhone("17879303721");
        System.out.println(phone);
        System.out.println("------------");
        String hide = StrUtil.hide("123456789", 3, 7);
        System.out.println(hide);
        System.out.println("------------");
        String idCardNum = DesensitizedUtil.idCardNum("36112119970226431X", 3, 3);
        System.out.println(idCardNum);
        System.out.println("------------");
        String password = DesensitizedUtil.password("123456789");
        System.out.println(password);
    }

    @Test
    public void testIdUtil() {
//        IdUtil.createSnowflake();
        Snowflake snowflake = IdUtil.getSnowflake(2, 1);
        long nextId = snowflake.nextId();
        System.out.println(nextId);
    }

    @Test
    public void testIoUtil() throws Exception{
        BufferedInputStream inputStream = FileUtil.getInputStream("D:\\project\\user\\user-service\\2021\\06\\07\\1623030949140.xlsx");
        BufferedOutputStream outputStream = FileUtil.getOutputStream("D:\\project\\user\\user-service\\2021\\06\\07\\11111.xlsx");
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes,0,len);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
    }

    @Test
    public void testDateUtil() {
        String dateStr = "2021-06-29 10:48:50";
        Date dateTime = DateUtil.parse(dateStr);
        System.out.println(dateTime);
        System.out.println("----------");
        Date date = new Date();
        String dateFormat = DateUtil.format(date, "yyyy/MM/dd");
        System.out.println(dateFormat);
        System.out.println("----------");
        String now = DateUtil.now();
        System.out.println(now);
        System.out.println("----------");
        DateTime startDateTime = DateUtil.parse("2021-06-29 23:59:59");
        DateTime endDateTime = DateUtil.parse(DateUtil.now());
        String between = DateUtil.formatBetween(startDateTime, endDateTime, BetweenFormatter.Level.HOUR);
        System.out.println(between);
        long between1 = DateUtil.between(startDateTime, endDateTime, DateUnit.MINUTE);
        System.out.println(between1);
        long between2 = DateUtil.between(startDateTime, endDateTime, DateUnit.SECOND);
        System.out.println(between2);
        System.out.println("----------");
        String chineseZodiac = DateUtil.getChineseZodiac(1997);
        System.out.println(chineseZodiac);
    }

    @Test
    public void testPageUtil() {
        int[] ints0 = PageUtil.transToStartEnd(0, 10);
        int[] ints1 = PageUtil.transToStartEnd(1, 10);
        for (int i = 0; i < ints0.length; i++) {
            System.out.println(ints0[i]);
        }
        System.out.println("-------------");
        for (int i = 0; i < ints1.length; i++) {
            System.out.println(ints1[i]);
        }
    }

}
