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
 *
 * TThreadPoolServer使用一个专用连接接收connection，一旦接收到请求就会放入ThreadPoolExecutor中的一个worker里处理，当请求处理完毕该worker释放并回到线程池中，
 * 可以配置线程最大值，当达到线程最大值时请求会被阻塞。TThreadPoolServer性能表现优异，代价是并发高时会创建大量线程
 *
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

            // ttpsArgs默认使用TTransportFactory和TBinaryProtocol
            // TTransportFactory inputTransportFactory = new TTransportFactory();
            // TTransportFactory outputTransportFactory = new TTransportFactory();
            // TProtocolFactory inputProtocolFactory = new TBinaryProtocol.Factory();
            // TProtocolFactory outputProtocolFactory = new TBinaryProtocol.Factory();
            //
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
