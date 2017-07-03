package org.training.exceptions;

import java.io.IOException;

/**
 * Created by kongyunlong on 2016/5/24.
 */
public class TestExceptionDemo {
    int a;
    static {
        int [] i = {1, 2, 3};
        System.out.println(i[3]);
//        throw new IOException();
    }

    {
//        System.in.read();
    }
    public TestExceptionDemo() throws IOException{
    }

    public TestExceptionDemo(int a)  throws IOException {
        this.a = a;
    }

    public static void main(String[] args) {
        try {
            TestExceptionDemo demo = new TestExceptionDemo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int [] i = {1, 2, 3};
        try {
            System.out.println(i[3]);
            throw new RuntimeException();
//            throw new IOException();
        } catch (Error e) {
        }
    }
}

//System.out.println("message:" + e.getMessage());
//        e.printStackTrace();
//        System.out.println("----------------------");
//        System.out.println(e.getStackTrace());
//        System.exit(-1);

//System.out.println("hello");