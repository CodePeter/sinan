package com.sinan.tiny;

import com.sinan.tiny.event.ThriftStartEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.sinan.tiny");
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.sinan.tiny");
//        ctx.refresh();
//        ctx.start();
        ctx.publishEvent(new ThriftStartEvent(ctx));


//        ctx.
//        ConfigurableApplicationContext ctx = new ConfigurableApplicationContext();
    }

//    public static void startup(StartupProcess startup) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//    }
}
