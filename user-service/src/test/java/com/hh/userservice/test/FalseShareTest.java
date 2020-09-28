package com.hh.userservice.test;

public class FalseShareTest implements Runnable {
    // 定义4和线程
    public static int NUM_THREADS = 4;
    // 递增+1
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;
    // 定义一个 VolatileLong数组
    private static VolatileLong[] longs;
    // 计算时间
    public static long SUM_TIME = 0l;

    public FalseShareTest(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main(final String[] args) throws Exception {
        for (int j = 0; j < 10; j++) {
            System.out.println(j);
            if (args.length == 1) {
                NUM_THREADS = Integer.parseInt(args[0]);
            }
            longs = new VolatileLong[NUM_THREADS];
            for (int i = 0; i < longs.length; i++) {
                longs[i] = new VolatileLong();
            }
            final long start = System.nanoTime();
            runTest();
            final long end = System.nanoTime();
            SUM_TIME += end - start;
        }
        System.out.println("平均耗时：" + SUM_TIME / 10);
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseShareTest(i));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }

    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = i;
        }
    }

    //    @sun.misc.Contended
    public final static class VolatileLong  {
//        extends AbstractPaddingObject
        public volatile long value = 0L;
//        public long p1, p2, p3, p4, p5, p6;
    }
}