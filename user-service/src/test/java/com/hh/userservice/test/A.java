package com.hh.userservice.test;

public class A {
    static class B{
        private static int value = 0;
        public B() {
            value++;
        }

    }
    private static B[] b;

    public static void main(String[] args) {
        b = new B[3];
        b[0] = new B();
        System.out.println(b[0].value);
        b[1] = new B();
        System.out.println(b[1].value);
        b[2] = new B();
        System.out.println(b[2].value);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i].value);
        }
    }

}
