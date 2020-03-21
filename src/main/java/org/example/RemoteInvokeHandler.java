package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvokeHandler implements InvocationHandler {
    private String host;
    private int port;

    public RemoteInvokeHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = new RpcRequest();

        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);
        RpcNetTransport rpcNetTransport = new RpcNetTransport(port,host);


        return rpcNetTransport.send(request);
    }
}
