package org.training.concurrent2.classloader;

public class Test {
    public static void main(String[] args) {
        System.out.println(Sub.B);
    }

    static class Parent {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }
}

