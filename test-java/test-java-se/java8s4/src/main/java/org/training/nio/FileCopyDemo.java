package org.training.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by anderson on 17-11-1.
 */
public class FileCopyDemo
{
    public static void main(String[] args)
    {
        try (FileChannel src = new FileInputStream("f2.txt").getChannel();
        FileChannel des = new FileOutputStream("f2_bak.txt").getChannel()) {
//            src.transferTo(0, src.size(), des);
            des.transferFrom(src, 0, src.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
