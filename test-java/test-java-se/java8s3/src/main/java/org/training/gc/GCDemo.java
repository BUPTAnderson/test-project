package org.training.gc;

/**
 * Created by kongyunlong on 2016/7/9.
 */
public class GCDemo
{
    public static void main(String[] args)
    {
        long m1;
        long m2;
        long m3;
        Runtime r = Runtime.getRuntime();
        for (int i = 0; i < 3; i++) {
            m1 = r.freeMemory();
            createObjects(2000);
            m2 = r.freeMemory();
            System.gc();
            m3 = r.freeMemory();
            System.out.println(m1 + "," + m2 + "," + m3);
        }
    }

    public static void createObjects(int num)
    {
        for (int i = 0; i < num; i++) {
            new Object();
        }
    }
}
