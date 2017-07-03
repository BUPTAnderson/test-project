package org.training.exceptions;

/**
 * Created by kongyunlong on 2016/5/25.
 */
public class ExceptionTest2 {
    public static void main(String[] args) {
        int n = fun(2);
        System.out.println(n);
    }
    public static int fun(int i) {
        try {
            int m = i / 0;
            return i++;
        } catch (ArithmeticException e) {
            return (i + 3);
        } finally {
            return (i + 8);
        }
    }
}
