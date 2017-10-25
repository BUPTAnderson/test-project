package org.training.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("f4.file"));
        dos.writeInt(100);
        dos.writeDouble(2.34);
        dos.writeUTF("hello");
        dos.close();
    }
}
