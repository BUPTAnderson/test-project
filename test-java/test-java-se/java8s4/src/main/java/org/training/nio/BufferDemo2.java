package org.training.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by anderson on 17-11-1.
 */
public class BufferDemo2
{
    public static void main(String[] args)
    {
        ByteBuffer b = ByteBuffer.allocate(10);
        // 将ByteBuffer设置为只读的
//        b.asReadOnlyBuffer();
        // 复制一份一样的buffer, 共享源buffer的内容
        ByteBuffer c = b.duplicate();

        for (int i = 0; i < c.limit(); i++) {
            System.out.println(c.get(i));
        }

        for (int i = 1; i <= b.limit(); i++) {
            b.put((byte) i);
        }

        for (int i = 0; i < c.limit(); i++) {
            System.out.println(c.get(i));
        }
        //        System.out.println(b.position());
        b.position(3);
        System.out.println(b.get(3));
        // 调用slice, 新的ByteBuffer共享原ByteBuffer从position到limit的数据
        ByteBuffer b1 = b.slice();
        b.put(5, (byte) 1);
        while (b1.hasRemaining()) {
            System.out.println(b1.get());
        }
        System.out.println("----------------------");
//        b.position(0);
        // position设置为0
        b.rewind();
        System.out.println(b.position());
        b.limit(5);
        for (int i = 0; i < b.limit(); i++) {
            System.out.println(b.get());
            if (i == 2) {
                // mark次数的position, 此时position是3
                b.mark();
            }
        }

        System.out.println(b.position());
        // reset():设置位置(position)到标记(mark), 若无标记, 则抛出InvalidMarkException
        b.reset();
        System.out.println(b.position());
        System.out.println(b.limit());
        // 将Buffer从写模式切换到读模式
        b.flip();
        System.out.println(b.position());
        System.out.println(b.limit());

        // 将ByteBuffer装换为其它类型的buffer
        CharBuffer charBuffer = b.asCharBuffer();
    }
}
