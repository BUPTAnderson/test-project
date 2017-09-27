package org.training.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("f2.txt");
        BufferedReader br = new BufferedReader(reader);
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        br.close();
        reader.close();
    }
}
