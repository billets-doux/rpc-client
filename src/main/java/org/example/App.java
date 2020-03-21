package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient rpcProxyClient = context.getBean(RpcProxyClient.class);
        IHelloService iHelloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", 8080);
        String  result = iHelloService.sayHello("Billetsdoux");
        System.out.println(result);

    }
}
