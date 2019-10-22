package com.sinan.scan;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class SpringBeanTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringBeanTest.class, args);
        Map<String, SpringBeanTest> beans = applicationContext.getBeansOfType(SpringBeanTest.class);
    }
}
