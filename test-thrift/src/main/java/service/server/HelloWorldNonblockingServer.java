package service.server;

import com.thrift.demo.HelloWorldService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import service.demo.HelloWorldImpl;

/**
 * Created by anderson on 17-6-9.
 *
 * 使用非阻塞式IO，服务端和客户端需要指定 TFramedTransport 数据传输的方式。
 * 对应的client: HelloWorldNonblockingClient
 * 使用非阻塞式IO, 也可以用量作为异步客户端的server
 * 如果要作为异步客户端的server, 对应的client: HelloWorldAsyncClient
 * 可分别测试如下TProtocolFactory协议:
 * TBinaryProtocol —— 二进制编码格式进行数据传输
 * TCompactProtocol —— 高效率的、密集的二进制编码格式进行数据传输
 * TJSONProtocol —— 使用 JSON 的数据编码协议进行数据传输
 */
public class HelloWorldNonblockingServer
{
    public static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            System.out.println("HelloWorld TNonblockingServer start ....");

            TProcessor tprocessor = new HelloWorldService.Processor(new HelloWorldImpl());

            TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(
                    SERVER_PORT);
            TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(
                    tnbSocketTransport);
            tnbArgs.processor(tprocessor);
            // 使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式
            tnbArgs.transportFactory(new TFramedTransport.Factory());
//            tnbArgs.protocolFactory(new TCompactProtocol.Factory());
            tnbArgs.protocolFactory(new TBinaryProtocol.Factory());
//            tnbArgs.protocolFactory(new TJSONProtocol.Factory());

            // 使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式
            TServer server = new TNonblockingServer(tnbArgs);
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
        HelloWorldNonblockingServer server = new HelloWorldNonblockingServer();
        server.startServer();
    }
}
