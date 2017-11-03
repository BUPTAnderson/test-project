package org.training.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;

/**
 * Created by anderson on 17-11-2.
 */
public class FilesDemo2
{
    public static void main(String[] args)
            throws IOException
    {
        Path src = Paths.get("f2.txt");
        Path des = Paths.get("/tmp/f2_bak.txt");
        // 如果目标文件存在, 则抛出FileAlreadyExistsException
//        Files.copy(src, des);
        Files.copy(src, des, StandardCopyOption.REPLACE_EXISTING);
        FileTime t = Files.getLastModifiedTime(src);
        System.out.println(Files.getLastModifiedTime(src));
        System.out.println(t.toInstant());
        System.out.println(t.toMillis());

        System.out.println(Files.probeContentType(src));

        Files.lines(src).forEach(System.out::println);

        String s = new String(Files.readAllBytes(src));
        System.out.println(s);

        Files.readAllLines(src).forEach(System.out::println);

        // 默认是覆盖写
        Files.write(src, "Hello".getBytes());
        Files.write(src, "hahaha".getBytes(), StandardOpenOption.APPEND);
    }
}
