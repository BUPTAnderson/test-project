package org.training.nio2;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by anderson on 17-11-2.
 */
public class FileSystemDemo
{
    public static void main(String[] args)
            throws IOException
    {
        FileSystem fs = FileSystems.getDefault();
        System.out.println(fs.isReadOnly());
        System.out.println(fs.getSeparator());
        for (FileStore s : fs.getFileStores()) {
            System.out.printf("%s, %s, %s, %s, %s \n", s.name(), s.getTotalSpace(), s.getUnallocatedSpace(), s.getUsableSpace(), s.type());
        }
        System.out.println("-------------------------");

        for (Path p : fs.getRootDirectories()) {
            System.out.println(p);
        }
    }
}
