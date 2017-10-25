package org.training.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RedirectDemo {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("out.txt");
        PrintStream p = new PrintStream(f);
        System.setOut(p);
        System.out.println("hello");
    }
}
