package org.training;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        Thread.State state = Thread.currentThread().getState();
        System.out.println(state);
        try {
            Thread.sleep(0L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------- end -------------");
    }
}
