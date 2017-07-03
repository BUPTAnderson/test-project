package org.training.exceptions;

/**
 * Created by kongyunlong on 2016/5/25.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            System.out.println("i=" + (i++));
            int m = 10 / 0;
        }   catch (ArithmeticException e) {
            System.exit(0);
            e.printStackTrace();
        }   finally {
            System.out.println("i=" + (++i));
        }
        int a = 0;
    }
}
