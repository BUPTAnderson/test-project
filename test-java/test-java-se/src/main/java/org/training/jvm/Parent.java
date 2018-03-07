package org.training.jvm;

/**
 * Created by anderson on 18-3-6.
 */
public class Parent
{
    static class Par {
        public static int a = 1;
        static {
            a = 2;
        }
    }

    static class Sub extends Par {
        public static int b = a;
    }

    public static void main(String[] args)
    {
        System.out.println(Sub.b);
    }
}
