package org.training.io;

import java.io.FileInputStream;

public class InputStreamDemo {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("/Users/anderson/IdeaProjects/test-project/f2.txt")) {
            int data = fis.read();
            byte byteData;
            // 每次读取一个字节，如果是中文的话，这样会出现问题， 因为utf-8编码下一个中文字符占2个或以上字节
            while ((byteData = (byte) data) != -1) {
                System.out.println((char) byteData);
                data = fis.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
