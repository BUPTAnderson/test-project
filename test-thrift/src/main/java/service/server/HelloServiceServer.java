package service.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import service.demo.Hello;
import service.demo.HelloServiceImpl;

/**
 * Created by anderson on 17-6-3.
 */

public class HelloServiceServer {
    /**
     * 启动 Thrift 服务器
     * @param arg
     */
    public static void main(String[] arg) {
        try {
            // 设置服务端口为 7911
            TServerSocket serverTransport = new TServerSocket(7911);
            // 设置协议工厂为 TBinaryProtocol.Factory
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
            // 关联处理器与 Hello 服务的实现
            TProcessor processor = new Hello.Processor(new HelloServiceImpl());
//            TServer server = new TThreadPoolServer(processor, serverTransport,
//                    proFactory);
            // 0.9.0之后改为下面的方式
            TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverTransport);
            args.protocolFactory(proFactory).processor(processor);
//            TServer server = new TSimpleServer(args);
            TServer server = new TThreadPoolServer(args);
            System.out.println("Start server on port 7911...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
