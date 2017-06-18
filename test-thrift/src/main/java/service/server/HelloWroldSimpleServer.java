package service.server;

import com.thrift.demo.HelloWorldService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import service.demo.HelloWorldImpl;

/**
 * Created by anderson on 17-6-9.
 * 对应的client: HelloWorldClient
 * 简单的单线程服务模型, 一般用于测试
 * 可分别测试如下协议:
 * TBinaryProtocol —— 二进制编码格式进行数据传输
 * TCompactProtocol —— 高效率的、密集的二进制编码格式进行数据传输
 * TJSONProtocol —— 使用 JSON 的数据编码协议进行数据传输
 */
public class HelloWroldSimpleServer
{
    public static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            System.out.println("HelloWorld TSimpleServer start ....");

            // 简单的单线程服务模型，一般用于测试
            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            TServer.Args tArgs = new TServer.Args(serverTransport);
            TProcessor tprocessor = new HelloWorldService.Processor(new HelloWorldImpl());
            tArgs.processor(tprocessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());   // TBinaryProtocol.Factory()
//             tArgs.protocolFactory(new TCompactProtocol.Factory());
//             tArgs.protocolFactory(new TJSONProtocol.Factory());
            TServer server = new TSimpleServer(tArgs);
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
        HelloWroldSimpleServer server = new HelloWroldSimpleServer();
        server.startServer();
    }
}
