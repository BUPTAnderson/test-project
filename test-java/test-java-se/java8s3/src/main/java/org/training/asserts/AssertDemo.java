package org.training.asserts;

/**
 * Created by kongyunlong on 2016/7/9.
 */
public class AssertDemo
{
    public static void m(int num)
    {
        assert num > 10 : "参数不合法";
        System.out.println(num);
    }

    public static void main(String[] args)
    {
        int num = 15;
        assert num == 10;
        System.out.println("Assert");
        m(-20);
        System.out.println("End");
    }
}