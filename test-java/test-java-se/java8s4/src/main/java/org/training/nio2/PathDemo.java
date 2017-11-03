package org.training.nio2;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by anderson on 17-11-2.
 */
public class PathDemo
{
    public static void main(String[] args)
    {
        Path p1 = FileSystems.getDefault().getPath("/home/anderson/gitJD/test-project/f2.txt");
        System.out.println(p1);
        int count = p1.getNameCount();
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(p1.getName(i));
        }
        System.out.println("--------------------");
        System.out.println(p1.getRoot());
        System.out.println(p1.getParent());
        System.out.println(p1.isAbsolute());

        System.out.println("--------------------");
//        Path p2 = Paths.get("/home/anderson/gitJD/../f2.txt");
        Path p2 = Paths.get("/home/anderson/gitJD/f2.txt");
        System.out.println(p2.normalize());

        Path p3 = Paths.get("f3");
//        Path p3 = Paths.get("/f3");
        // 将p3连接在p2后面, 前提是p3不是绝对路径, 如果是绝对路径的话p3保持不变
        System.out.println(p2.resolve(p3));

        Path p4 = Paths.get("/home");
        System.out.println(p2.relativize(p4));
        System.out.println(p4.relativize(p2));

        System.out.println(p2.subpath(1, 3));

        System.out.println(p2.startsWith(p4));
        System.out.println(p2.endsWith(Paths.get("gitJD/f2.txt")));
        System.out.println(p2.equals(Paths.get("/home/anderson/gitJD/f2.TXT")));
    }
}
