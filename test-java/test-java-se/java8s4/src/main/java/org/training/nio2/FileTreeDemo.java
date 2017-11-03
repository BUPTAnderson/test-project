package org.training.nio2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by anderson on 17-11-2.
 */
public class FileTreeDemo
{
    public static void main(String[] args)
            throws IOException
    {
//        printName();
        deleteDir();
    }

    private static void printName()
            throws IOException
    {
        Path p = Paths.get("/home/anderson/gitJD/test-project/test-java/test-java-se/java8s4/src");
        System.out.println(Files.exists(p));

        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException
            {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException
            {
                System.out.println("File:" + file);
                return FileVisitResult.CONTINUE;
            }
        };

        Files.walkFileTree(p, visitor);
    }

    private static void deleteDir()
            throws IOException
    {
        Path p = Paths.get("d1");
        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                    throws IOException
            {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException
            {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
        };

        Files.walkFileTree(p, visitor);
    }
}
