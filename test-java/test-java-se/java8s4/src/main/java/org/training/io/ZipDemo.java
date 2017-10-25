package org.training.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipDemo {
    public static void main(String[] args) throws IOException {
//        createZip();
//        unzip();
//        list();
        list2();
    }

    private static void createZip() {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("test.zip"))) {
            // 设置压缩的级别
            zos.setLevel(Deflater.BEST_COMPRESSION);
            // 条目名称， 可以任意， 一般与文件名相同
            ZipEntry ze1 = new ZipEntry("f2.txt");
            zos.putNextEntry(ze1);
            // 读取f2内容写入ze1
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("f2.txt"));
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = bis.read(buffer, 0, buffer.length)) != -1) {
                zos.write(buffer, 0, len);
            }
            bis.close();

            ZipEntry ze2 = new ZipEntry("f3.txt");
            zos.putNextEntry(ze2);
            // 读取f2内容写入ze1
            BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream("f3.txt"));
            byte[] buffer2 = new byte[1024];
            int len2 = -1;
            while ((len2 = bis2.read(buffer2, 0, buffer2.length)) != -1) {
                zos.write(buffer2, 0, len2);
            }
            bis2.close();

            zos.closeEntry();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void unzip() {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream("test.zip"))) {
            ZipEntry entry = null;
            while ((entry = zis.getNextEntry()) != null) {
                String name = entry.getName();
                String path = "test" + File.separator + name;
                File file = new File(path);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdir();
                }
                file.createNewFile();
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = zis.read(buffer, 0, buffer.length)) != -1) {
                    bos.write(buffer, 0, len);
                }
                bos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void list() throws IOException {
        ZipFile f = new ZipFile("test.zip");
        Enumeration<? extends ZipEntry> e = f.entries();
        while (e.hasMoreElements()) {
            ZipEntry entry = e.nextElement();
            System.out.println(entry.getName());
        }
    }

    public static void list2() throws IOException {
        ZipFile f = new ZipFile("test.zip");
        f.stream().forEach(entry -> System.out.println(entry.getName()));
    }
}
