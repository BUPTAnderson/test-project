package service.server;

import com.thrift.demo.HelloWorldService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import service.demo.HelloWorldImpl;

/**
 * Created by anderson on 18-9-4.
 * <p>
 * TThreadedSelectorServer是thrift 0.8引入的实现，处理IO也使用了线程池，比THsHaServer有更高的吞吐量和更低的时延，与TThreadPoolServer比性能相近且能应对网络IO较多的情况
 */
public class HelloWorldSelectorServer {
    public static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            System.out.println("HelloWorld SelectorServer start ....");

            TProcessor tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());

            TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(
                    SERVER_PORT);
            tnbSocketTransport.getPort();
//            tnbSocketTransport.
            TThreadedSelectorServer.Args tnbArgs = new TThreadedSelectorServer.Args(tnbSocketTransport);
            tnbArgs.processor(tprocessor);
            tnbArgs.transportFactory(new TFramedTransport.Factory());
//            tnbArgs.protocolFactory(new TCompactProtocol.Factory());
            tnbArgs.protocolFactory(new TBinaryProtocol.Factory());
//            tnbArgs.protocolFactory(new TJSONProtocol.Factory());

            // 使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式
            TServer server = new TThreadedSelectorServer(tnbArgs);
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
        HelloWorldSelectorServer server = new HelloWorldSelectorServer();
        server.startServer();
    }
}
