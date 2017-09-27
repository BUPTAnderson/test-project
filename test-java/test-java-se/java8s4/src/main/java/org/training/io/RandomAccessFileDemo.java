package org.training.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        init("f6.txt");
        read("f6.txt");
        read("f6.txt");
        read("f6.txt");
    }

    private static void read(String fileName) throws IOException {
        RandomAccessFile f = new RandomAccessFile(fileName, "rw");
        int num = f.readInt();
        String name = f.readUTF();
        System.out.println(num + ", " + name);
        long p = f.getFilePointer();
        f.seek(0L);
        num = f.readInt();
        num++;
        f.seek(0);
        f.writeInt(num);
        f.seek(p);
        f.close();
    }

    private static void init(String fileName) throws IOException {
        RandomAccessFile f = new RandomAccessFile(fileName, "rw");
        f.writeInt(200);
        f.writeUTF("Tom");
        f.close();
    }
}
