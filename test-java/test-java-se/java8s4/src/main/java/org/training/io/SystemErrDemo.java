package org.training.io;

import java.io.IOException;

public class SystemErrDemo {
    public static void main(String[] args) throws IOException {
        System.err.println("Error");
        int num = -1;
        while ((num = System.in.read()) != '\n') {
            System.out.println((char) num);
        }
    }
}
