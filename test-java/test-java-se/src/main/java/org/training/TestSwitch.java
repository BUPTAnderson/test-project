package org.training;

/**
 * Created by anderson on 18-3-13.
 */
public class TestSwitch
{
    public static void main(String[] args)
    {
//        long a = 100L;
        int a = 20;
        switch (a) {
            case 10 :
                System.out.println("---");
                break;
            case 20 :
                System.out.println("++++");
                break;
            default :
                System.out.println("~~~~");
                break;
        }
    }
}
