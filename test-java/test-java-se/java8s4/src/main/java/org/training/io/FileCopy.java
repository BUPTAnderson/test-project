package org.training.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("/Users/anderson/Documents/a.jpg"); FileOutputStream fos = new FileOutputStream("a-copy.jpg")) {
            byte[] buffer = new byte[2048];
            int length = 0;
            while ((length = fis.read(buffer, 0, buffer.length)) != -1) {
                fos.write(buffer, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
