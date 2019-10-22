package com.sinan.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

public class Bootstrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Bootstrap.class, args);
        applicationContext.getBean(Bootstrap.class);

    }
}
