package org.training.nio2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * Created by anderson on 17-11-2.
 */
public class WatchDemo
{
    public static void main(String[] args)
            throws IOException, InterruptedException
    {
        // 1. 创建观察服务
        WatchService ws = FileSystems.getDefault().newWatchService();
        Path p = Paths.get("/home/anderson/GitHub");
        // 2. 注册目录到观察服务上
        WatchKey k = p.register(ws, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

        try {
            while (true) {
                // 3. 从观察服务队列中获取WatchKey
                WatchKey key = ws.take();
                for (WatchEvent<?> e : key.pollEvents()) {
                    // 4. 处理发生在已注册目录中的事件
                    WatchEvent.Kind<?> kind = e.kind();
                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }
                    WatchEvent<Path> currEvent = (WatchEvent<Path>) e;
                    Path path = currEvent.context();
                    System.out.println(path + "发生" + kind);
                    // 5. 处理完事件后重置WatchKey
                    key.reset();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭观察服务
            ws.close();
        }
    }
}
