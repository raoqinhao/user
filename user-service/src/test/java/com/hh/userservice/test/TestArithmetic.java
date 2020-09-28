package com.hh.userservice.test;

import org.junit.Test;

public class TestArithmetic {


    /**
     * 二分查找法
     */
    @Test
    public void testBinarySearch() {
        int a = 10;
        int[] arr = new int[]{1,2,3,4,5};
        int index = getBinarySearch(arr, a);
        System.out.println(index);
    }

    private int getBinarySearch(int[] arr, int a) {
        if (arr.length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] == a) {
                return mid;
            } else if (arr[mid] < a) {
                left = mid + 1;
            } else if (arr[mid] > a) {
                right = mid - 1;
            }
        }
        return -1;
    }


}
