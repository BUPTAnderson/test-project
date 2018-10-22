package service.server;

import com.thrift.demo.HelloWorldService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import service.demo.HelloWorldImpl;

/**
 * Created by anderson on 17-6-9.
 * <p>
 * THsHaServer使用一个单独的线程处理IO，一个独立的worker线程池处理消息， 可以并行处理所有请求
 * <p>
 * 半同步半异步的服务端模型，需要指定为： TFramedTransport 数据传输的方式。
 * client可以继续使用 client: HelloWorldNonblockingClient
 */
public class HelloWorldTHsHaServer {
    public static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            System.out.println("HelloWorld THsHaServer start ....");

            TProcessor tprocessor = new HelloWorldService.Processor(new HelloWorldImpl());

            TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(
                    SERVER_PORT);
            THsHaServer.Args thhsArgs = new THsHaServer.Args(tnbSocketTransport);
            thhsArgs.processor(tprocessor);
            thhsArgs.transportFactory(new TFramedTransport.Factory());
            thhsArgs.protocolFactory(new TBinaryProtocol.Factory());
//            thhsArgs.protocolFactory(new TCompactProtocol.Factory());
//            thhsArgs.protocolFactory(new TJSONProtocol.Factory());

            //半同步半异步的服务模型
            TServer server = new THsHaServer(thhsArgs);
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
        HelloWorldTHsHaServer server = new HelloWorldTHsHaServer();
        server.startServer();
    }
}
