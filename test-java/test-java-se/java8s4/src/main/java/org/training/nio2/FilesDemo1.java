package org.training.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by anderson on 17-11-2.
 */
public class FilesDemo1
{
    public static void main(String[] args)
            throws IOException
    {
        Path p1 = Paths.get("f8.txt");
        if (!Files.exists(p1)) {
//            Files.createFile(p1);
        }

        Path p2 = Paths.get("d1/d2");
        // 类似于File里面的mkdir()方法, 如果父目录不存在会报错, 如果已经存在的话也会报错
//        Files.createDirectory(p2);
        // 类似于File里面的mkdirs()方法, 如果父目录不存在会创建
//        Files.createDirectories(p2);

        // 会在/tmp目录下面创建一个以ttt开头, .tmp结尾的临时文件, 比如:　/tmp/ttt2796891588170467420.tmp
//        System.out.println(Files.createTempFile("ttt", ".tmp").toRealPath());

        // 创建软连接，　第二个参数使用绝对路径
//        Files.createSymbolicLink(Paths.get("/home/anderson/桌面/f8.txt"), Paths.get("/home/anderson/gitJD/test-project/f8.txt"));
        // 符号连接及其指向的目标文件都存在, 才会返回true, 如果目标文件不存在, 则返回false
        System.out.println(Files.exists(Paths.get("/home/anderson/桌面/f8.txt")));
        // 加上后面的参数之后, 只要符号连接存在, 则会返回true, 不管目标文件是否存在
        System.out.println(Files.exists(Paths.get("/home/anderson/桌面/f8.txt"), LinkOption.NOFOLLOW_LINKS));

        // 删除指定目录的文件或文件夹, 如果不存在会抛出异常
        Files.delete(p2);
        // 目标文件或目录存在的话再删除, 不存在的话放回false
        Files.deleteIfExists(p1);
    }
}
