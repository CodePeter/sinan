package com.sinan.tiny.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {

    @Bean
    public ThriftStartListener thriftStartListener() {
        return new ThriftStartListener();
    }
}
