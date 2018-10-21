package org.training.concurrent2.chaper3;

public class VolatileTest {
//    private static volatile int INIT_VALUE = 0;
    private static int INIT_VALUE = 0;
    private final static int MAX_LIMIT = 5;

    public static void main(String[] args) {
        // 该线程由于是读操作，一直从cpu缓存获取数据，没有去主内存获取INIT_VALUE的最新值，
        // 导致该线程一直判断localValue等于INIT_VALUE，从而该线程不会结束
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                if (localValue != INIT_VALUE) {
                    System.out.printf("The value updated to [%d]\n", INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }
        }, "READER").start();

        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.printf("Update the value to [%d]\n", ++localValue);
                INIT_VALUE = localValue;

                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Update").start();
    }
}
