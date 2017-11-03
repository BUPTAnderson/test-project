package org.training.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.time.Instant;
import java.util.Map;
import java.util.Set;

/**
 * Created by anderson on 17-11-2.
 */
public class FileAttrDemo2
{
    public static void main(String[] args)
            throws IOException
    {
        Path p = Paths.get("f2.txt");
        // 可以省略'basic:', 不写的话默认是'basic:', 后面的属性(attribute)可以查看BasicFileAttributeView, 必须是BasicFileAttributeView中所包含的
        System.out.println(Files.getAttribute(p, "basic:size"));

        // 正常的话是AttributeView的name方法返回的name, 加上该AttributeView对应支持的attribute, name:attribute
        Set<PosixFilePermission> permissions = (Set<PosixFilePermission>) Files.getAttribute(p, "posix:permissions");
        permissions.forEach(System.out::println);

        Files.setAttribute(p, "lastModifiedTime", FileTime.from(Instant.now()));

        // 上面的方法只能获取单个属性, 下面是获取多个属性的方法
        BasicFileAttributes fas = Files.readAttributes(p, BasicFileAttributes.class);
        System.out.println(fas.creationTime() + " " + fas.isDirectory() + "" + fas.size());

        Map<String, Object> fas2 = Files.readAttributes(p, "size,lastModifiedTime");
        fas2.forEach((k, v) -> {
            System.out.println("key: " + k + ", value: " + v);
        });

        BasicFileAttributeView bfv = Files.getFileAttributeView(p, BasicFileAttributeView.class);
        BasicFileAttributes bfa = bfv.readAttributes();
        System.out.println(bfa.creationTime() + " " + bfa.isDirectory() + "" + bfa.size());
    }
}
