package com.hh.userservice.test;

import org.junit.Test;

public class TestTryCatch {

    @Test
    public void testFor() {

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                if (i == 5) throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("-----------");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5) throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
