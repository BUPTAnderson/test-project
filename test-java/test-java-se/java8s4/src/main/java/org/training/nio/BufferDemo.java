package org.training.nio;

import java.nio.ByteBuffer;

/**
 * Created by anderson on 17-11-1.
 */
public class BufferDemo
{
    public static void main(String[] args)
    {
        byte[] b = new byte[10];
        // allocate是在java虚拟机里面分配
        ByteBuffer b1 = ByteBuffer.allocate(10);
        ByteBuffer b2 = ByteBuffer.wrap(new byte[] {1, 2, 3});
        // allocateDirect是在操作系统的内存里面分配, 该方法是ByteBuffer独有的
        ByteBuffer b3 = ByteBuffer.allocateDirect(10);

        int limit = b1.limit();
        for (int i = 0; i < limit; i++) {
            // put(byte b)放入数据后会使position自增
            b1.put((byte) i);
        }
        System.out.println(limit);
        for (int i = 0; i < limit; i++) {
            System.out.print(b1.position() + " : ");
            // get方法会把位置自增
//            System.out.println(b1.get());
            // 直接指定位置的话对position没有影响, 即position不会变化
            System.out.println(b1.get(i));
        }
    }
}
