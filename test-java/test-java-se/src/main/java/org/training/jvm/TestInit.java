package org.training.jvm;

/**
 * Created by anderson on 18-3-6.
 */
public class TestInit
{
    int a = 10;
    {
        a = 100;
    }

    {
        b = 200;
    }
    int b = 20;

    public static void main(String[] args)
    {
        TestInit test = new TestInit();
        System.out.println(test.a);
        System.out.println(test.b);
    }
}
