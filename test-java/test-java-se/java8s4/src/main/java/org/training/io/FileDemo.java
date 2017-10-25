package org.training.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        // 没有使用绝对路径的话使用的是相对路径（工作路径），就是上面的user.dir对应的路径：/Users/anderson/IdeaProjects/test-project
        File f1 = new File("f1.txt");
        File f2 = new File("test");
        System.out.println(f2.exists());
        System.out.println(f2.mkdir());
//        File f1 = new File("/home/anderson/IdeaProjects/test-project/f1.txt");
        System.out.println(f1.exists());
        System.out.println(f1.createNewFile());
        f1.renameTo(new File("f2.txt"));

        // /var/folders/52/xr4kc4nn0rl6xl53dk61cnrc0000gn/T/
        System.out.println(System.getProperty("java.io.tmpdir"));
        // 会在${java.io.tmpdir}下新建以aaa开头， tmp结尾的临时文件，比如这里是：aaa6512378516753308355tmp
//        File.createTempFile("aaa", "tmp");
        System.out.println(new File("f2.txt").length());

        for (File f : File.listRoots()) {
            System.out.println(f.getPath());
        }

        File testJava = new File("/Users/anderson/IdeaProjects/test-project/test-java/test-java-se");
        // list方法只会列出直接子文件或子文件夹，不会递归
        for (String str : testJava.list()) {
            System.out.println(str);
        }

        // java.io.FileFilter
        File[] files = new File("/Users/anderson/IdeaProjects/test-project/test-java/test-java-se/java8s4/src/main/java/org/training/collection").
                listFiles(file -> file.getAbsolutePath().endsWith("Demo.java"));
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
