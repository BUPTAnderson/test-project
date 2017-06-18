package service.server;

import com.thrift.demo.HelloWorldService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import service.demo.HelloWorldImpl;

/**
 * Created by anderson on 17-6-9.
 * 线程池服务模型，使用标准的阻塞式IO，预先创建一组线程处理请求。
 * 对应的client: HelloWorldClient
 * 注意: server端和client的数据传输的协议要一致
 * 可分别测试如下TProtocolFactory协议:
 * TBinaryProtocol —— 二进制编码格式进行数据传输
 * TCompactProtocol —— 高效率的、密集的二进制编码格式进行数据传输
 * TJSONProtocol —— 使用 JSON 的数据编码协议进行数据传输
 */
public class HelloWorldThreadPollServer
{
    public static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            System.out.println("HelloWorld TThreadPoolServer start ....");

            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            TThreadPoolServer.Args ttpsArgs = new TThreadPoolServer.Args(serverTransport);
            TProcessor tprocessor = new HelloWorldService.Processor(new HelloWorldImpl());
            ttpsArgs.processor(tprocessor);
            ttpsArgs.protocolFactory(new TBinaryProtocol.Factory());
//            ttpsArgs.protocolFactory(new TCompactProtocol.Factory());
//            ttpsArgs.protocolFactory(new TJSONProtocol.Factory());

            // 线程池服务模型，使用标准的阻塞式IO，预先创建一组线程处理请求。
            TServer server = new TThreadPoolServer(ttpsArgs);
            server.serve();

        } catch (Exception e) {
            System.out.println("Server start error!!!");
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        HelloWorldThreadPollServer server = new HelloWorldThreadPollServer();
        server.startServer();
    }
}
