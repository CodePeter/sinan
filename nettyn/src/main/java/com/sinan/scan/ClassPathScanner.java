package com.sinan.scan;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.web.servlet.mvc.Controller;

import java.util.Set;

public class ClassPathScanner extends ClassPathBeanDefinitionScanner {
    public ClassPathScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

//    @Override
//    protected void registerDefaultFilters() {
//        this.addIncludeFilter(new AnnotationTypeFilter(SpringBootApplication.class));
//        super.registerDefaultFilters();
//    }

    public static void main(String[] args) {
//        ClassPathBeanDefinitionScanner cpbds = new ClassPathBeanDefinitionScanner();
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        ClassPathScanner cps = new ClassPathScanner(beanFactory);
//        ClassPathScanner cps = new ClassPathScanner((BeanDefinitionRegistry) beanFactory);
//        cps.scan("com.sinan.showcase");
//        cps.registerDefaultFilters();
//        cps.resetFilters(false);
//        cps.addIncludeFilter(new AssignableTypeFilter(Configuration.class));
//        cps.addIncludeFilter(new AnnotationTypeFilter(SpringBootApplication.class));
//        cps.addIncludeFilter(new AssignableTypeFilter(HelloService.class));
        Set<BeanDefinition> sets = cps.findCandidateComponents("com.sinan.scan");
        System.out.println(sets.size());
        for(BeanDefinition bd : sets) {
            System.out.println(bd.getBeanClassName());
        }

    }
}
