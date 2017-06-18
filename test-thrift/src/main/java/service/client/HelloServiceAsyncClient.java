package service.client;

import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import service.callback.MethodCallback;
import service.demo.Hello;

import java.io.IOException;

/**
 * Created by anderson on 17-6-6.
 */
public class HelloServiceAsyncClient {
    /**
     * 调用 Hello 服务
     * @param args
     */
    public static void main(String[] args) throws Exception {
        try {
            TAsyncClientManager clientManager = new TAsyncClientManager();
            TNonblockingTransport transport = new TNonblockingSocket(
                    "10.12.163.45", 10005);
            TProtocolFactory protocol = new TBinaryProtocol.Factory();
            Hello.AsyncClient asyncClient = new Hello.AsyncClient(protocol,
                    clientManager, transport);
            System.out.println("Client calls .....");
            MethodCallback callBack = new MethodCallback();
            asyncClient.helloString("Hello World", callBack);
            Object res = callBack.getResult();
            while (res == null) {
                Thread.currentThread().sleep(100L);
                res = callBack.getResult();
            }
            System.out.println(res.getClass().getName());
            System.out.println("result: " + ((Hello.AsyncClient.helloString_call) res)
                    .getResult());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
