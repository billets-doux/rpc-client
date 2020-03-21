package org.example;

import java.lang.reflect.Proxy;

public class RpcProxyClient {

    public <T> T clientProxy(final Class<T> interfaceCls, final String host,final int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),new Class<?>[]{interfaceCls},new RemoteInvokeHandler(host,port));
    }
}
