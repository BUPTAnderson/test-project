package org.training.rpc;

/**
 * Created by anderson on 17-6-17.
 */
public class RpcProvider
{
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
