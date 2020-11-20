package com.hh.userservice.test;

import org.junit.Test;

import java.math.BigDecimal;

public class TestBigDecimal {

    @Test
    public void testAddBigDecimal() {
        BigDecimal big1 = new BigDecimal("3.1415");
        BigDecimal big2 = new BigDecimal("0.9939");
        BigDecimal sum1 = big1.add(big2);
        System.out.println(sum1);
        BigDecimal sum2 = big1.add(big2).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(sum2);
    }

    @Test
    public void testMultiplyBigDecimal() {
        BigDecimal bigDecimal = new BigDecimal("11.111");
        BigDecimal bigDecima2 = new BigDecimal("1.11");
        BigDecimal result1 = bigDecimal.multiply(bigDecima2);
        System.out.println(result1);
        BigDecimal result2 = bigDecimal.multiply(bigDecima2).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(result2);
    }

    @Test
    public void testSubtractBigDecimal() {
        BigDecimal bigDecimal = new BigDecimal("12.33251");
        BigDecimal bigDecima2 = new BigDecimal("6.47251");
        BigDecimal result1 = bigDecimal.subtract(bigDecima2).setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(result1);
        BigDecimal result2 = bigDecimal.subtract(bigDecima2).setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(result2);

    }

    @Test
    public void testDivideBigDecimal() {
        BigDecimal bigDecimal = new BigDecimal("2.22");
        BigDecimal bigDecima2 = new BigDecimal("2.22");
        BigDecimal divide1 = bigDecimal.divide(bigDecima2);
        System.out.println(divide1);
        BigDecimal divide2 = bigDecimal.divide(bigDecima2).setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide2);
    }


    @Test
    public void testDev02() {
        //02
    }


    @Test
    public void test02() {
        
    }


    @Test
    public void pro02() {

    }

    @Test
    public void play02() {
        //02
    }
}
