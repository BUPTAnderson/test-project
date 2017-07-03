package org.training.exceptions;

/**
 * Created by kongyunlong on 2016/5/25.
 */
public class ExceptionTest3 {
    public static void main(String[] args) {
        int n = fun(2);
        System.out.println(n);
    }
    public static int fun(int i) {
        try {
            return ++i;
        } finally {
            i = i + 8;
        }
    }
}
