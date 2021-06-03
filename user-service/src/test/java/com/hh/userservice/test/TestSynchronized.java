package com.hh.userservice.test;


import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestSynchronized {

    @Test
    public void testCollSynch() {
        Collections.synchronizedMap(new HashMap<>());
        Collections.synchronizedMap(new Hashtable<>());
        Map<String, String> map = new Hashtable<>();
        map.put("key","1");
        map.put(null,"1");
        System.out.println(map);
    }

}
