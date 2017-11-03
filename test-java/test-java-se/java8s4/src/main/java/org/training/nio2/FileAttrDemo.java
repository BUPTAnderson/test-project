package org.training.nio2;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;

/**
 * Created by anderson on 17-11-2.
 */
public class FileAttrDemo
{
    public static void main(String[] args)
            throws IOException
    {
        Path p = Paths.get("/home/anderson/GitHub");
        FileStore s = Files.getFileStore(p);
        System.out.println(s.supportsFileAttributeView(BasicFileAttributeView.class));
        System.out.println(s.supportsFileAttributeView(DosFileAttributeView.class));
        System.out.println(s.supportsFileAttributeView(PosixFileAttributeView.class));
    }
}
