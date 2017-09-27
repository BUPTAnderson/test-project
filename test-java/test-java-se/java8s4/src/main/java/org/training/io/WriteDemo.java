package org.training.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDemo {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("f5.txt"))) {
            bw.write("Hello");
            bw.newLine();
            bw.append("world");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
