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


}
