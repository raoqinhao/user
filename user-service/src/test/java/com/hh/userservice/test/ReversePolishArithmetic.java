package com.hh.userservice.test;

import java.util.Arrays;
import java.util.Stack;

public class ReversePolishArithmetic {

    public static void main(String[] args) {
        String[] arr = new String[]{"4","8","6","7","*","-","+"};
        arithmetic(arr);
    }

    //["4","8","6","*","-"]
    public static void arithmetic(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        Arrays.stream(arr).forEach(e -> {
            if ("+-*/".contains(e)) {
                Integer left = stack.pop();
                Integer right = stack.pop();
                stack.push(calculate(left,right,e));
            } else {
                stack.push(Integer.parseInt(e));
            }
        });
        System.out.println(stack.pop());
    }

    public static int calculate(int left, int right, String option) {
        int result = 0;
        switch (option) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
            case "/":
                result = left / right;
                break;
        }
        return result;
    }

}
