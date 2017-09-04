package service.processor;

import com.thrift.demo.HelloWorldService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSaslClientTransport;
import org.apache.thrift.transport.TSaslServerTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.Map;

/**
 * Created by anderson on 17-7-28.
 */
public class TestProcessor extends HelloWorldService.Processor
{
    public TestProcessor(HelloWorldService.Iface iface)
    {
        super(iface);
    }

    protected TestProcessor(HelloWorldService.Iface iface, Map processMap)
    {
        super(iface, processMap);
    }

    @Override
    public boolean process(TProtocol in, TProtocol out)
            throws TException
    {
        setIpAddress(in);
        return super.process(in, out);
    }

    protected void setIpAddress(final TProtocol in) {
        TTransport transport = in.getTransport();
        TSocket tSocket = getUnderlyingSocketFromTransport(transport);
        if (tSocket == null) {
            System.out.println("Unknown Transport, cannot determine ipAddress");
        } else {
            System.out.println("--->" + tSocket.getSocket().getInetAddress().getHostAddress());
        }
    }

    private TSocket getUnderlyingSocketFromTransport(TTransport transport) {
        while (transport != null) {
            if (transport instanceof TSaslServerTransport) {
                transport = ((TSaslServerTransport) transport).getUnderlyingTransport();
            }
            if (transport instanceof TSaslClientTransport) {
                transport = ((TSaslClientTransport) transport).getUnderlyingTransport();
            }
            if (transport instanceof TSocket) {
                return (TSocket) transport;
            }
        }
        return null;
    }
}
