package service.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import service.demo.Hello;
import service.demo.HelloServiceImpl;

/**
 * Created by anderson on 17-6-6.
 */
public class HelloServiceAsyncServer {
    /**
     * 启动 Thrift 异步服务器
     * @param arg
     */
    public static void main(String[] arg) {
        TNonblockingServerTransport serverTransport;
        try {
            serverTransport = new TNonblockingServerSocket(10005);
            Hello.Processor processor = new Hello.Processor(
                    new HelloServiceImpl());
            TNonblockingServer.Args args = new TNonblockingServer.Args(serverTransport);
            args.processor(processor);
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
            // 默认就是使用的TBinaryProtocol.Factory, 可以不设置, 即下面这行代码可以没有
            args.protocolFactory(proFactory);
            TFramedTransport.Factory traFactory = new TFramedTransport.Factory();
            // 默认就是使用的TFramedTransport.Factory, 可以不设置, 即下面这行代码可以没有
            args.transportFactory(traFactory);
            TServer server = new TNonblockingServer(args);
            System.out.println("Start server on port 10005 ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
