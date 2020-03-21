package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean(name = "rpcProxyClent")
    public RpcProxyClient proxyClient(){
        return new RpcProxyClient();
    }

}
